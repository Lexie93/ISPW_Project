package fxGraphics;

import java.util.Vector;

import control.ControlloreAdapter;
import control.ControlloreArticoliPreferiti;
import entity.Articolo;
import javaFxController.AlertMessageGenerator;
import javaFxController.SceneUpdater;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ArticoliCercatiPane extends ArticoloPane{

	private Vector<Articolo> articoli; 
	private SceneUpdater sceneUpdater;
	
	public ArticoliCercatiPane(Vector<Articolo> articoli, SceneUpdater sceneUpdater)
	{
		this.sceneUpdater= sceneUpdater;
		this.articoli= articoli;
	}

	@Override
	public VBox append(VBox v) {
		for(int i=0; i<articoli.size(); i++){
			Pane p=articoloPane(articoli.elementAt(i), sceneUpdater);
			p.prefWidthProperty().bind(v.prefWidthProperty());
			v.getChildren().add(p);
			v.getChildren().add(new Separator());
		}
		return v;
	}
	
private Pane articoloPane(Articolo a, SceneUpdater sceneUpdater){
		
		ControlloreAdapter conAd=ControlloreAdapter.getSingletonInstance();
		
		Pane p=new Pane();
		GridPane g=new GridPane();
		ColumnConstraints column = new ColumnConstraints();
	    column.setPercentWidth(16);
	    g.getColumnConstraints().add(column);
		g.setPadding(new Insets(15,15,15,15));
		g.addColumn(0, new Label("ID"),new Label(a.getID().toString()));
		g.getColumnConstraints().add(column);
		g.addColumn(1, new Label("Nome"),new Label(a.getNome()));
		g.getColumnConstraints().add(column);
		g.addColumn(2, new Label("Prezzo"),new Label(a.getPrezzo()));
		g.getColumnConstraints().add(column);
		Label desc=new Label("Descrizione");
		desc.setTextFill(Color.web("#0000FF"));
		desc.setOnMouseClicked(new EventHandler<MouseEvent>() {
		      @Override
		      public void handle(MouseEvent e) {
		        AlertMessageGenerator.createAlert(a.getNome(),a.getDescrizione());
		      }
		    });
		g.addColumn(3, desc);
		g.getColumnConstraints().add(column);
		g.addColumn(4, new Label("Venditore"),new Label(a.getVenditore()));
		if(conAd.isUserLogged()){
			if(!a.getVenditore().trim().equals(conAd.getUser().getUsername().trim())){
				g.getColumnConstraints().add(column);
				Label preferiti=new Label("Aggiungi ai preferiti");
				preferiti.setTextFill(Color.web("#0000FF"));
				preferiti.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						if(AlertMessageGenerator.askConfirmation("Conferma operazione", "Vuoi aggiungere questo articolo alla lista dei preferiti?")){
							try{
								ControlloreArticoliPreferiti conAP=new ControlloreArticoliPreferiti();
								conAP.aggiungiArticoloPreferito(conAd.getUser().getUsername(), a.getID());
								sceneUpdater.updateScene("index");
							}catch (Exception ex) {
								AlertMessageGenerator.createAlertForError("inserimento annuncio tra i preferiti", new Exception("Errore durante l'inserimento dell'annuncio tra i preferiti, controllare che l'articolo non sia già stato contrassegnato come preferito"));
							}
						}
					}
				});
				g.addColumn(5, preferiti);
			} else {
				g.getColumnConstraints().add(column);
				g.addColumn(5, new Label("Tuo annuncio"));
			}
		}
		g.prefWidthProperty().bind(p.prefWidthProperty());
		g.setAlignment(Pos.CENTER);
		p.getChildren().add(g);
		return p;
	}
}
