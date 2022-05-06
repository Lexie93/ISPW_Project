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

public class ArticoliPreferitiPane extends ArticoloPane{

	private Vector<Articolo> articoli; 
	private SceneUpdater sceneUpdater;
	
	public ArticoliPreferitiPane(Vector<Articolo> articoli, SceneUpdater sceneUpdater)
	{
		this.sceneUpdater= sceneUpdater;
		this.articoli= articoli;
	}

private  Pane articoloDesideriPane(Articolo a, SceneUpdater sceneUpdater){
		
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
		g.getColumnConstraints().add(column);
		Label preferiti=new Label("Rimuovi dai preferiti");
		preferiti.setTextFill(Color.web("#0000FF"));
		preferiti.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(AlertMessageGenerator.askConfirmation("Conferma rimozione", "Vuoi davvero rimuovere questo articolo dalla lista dei preferiti?")){
					try{
						ControlloreArticoliPreferiti conAP=new ControlloreArticoliPreferiti();
						conAP.eliminaArticoloPreferito(conAd.getUser().getUsername(), a.getID());
						sceneUpdater.updateScene("index");
					}catch (Exception ex) {
						AlertMessageGenerator.createAlertForError("rimozione annuncio dai preferiti", new Exception("Errore durante la rimozione dell'annuncio dai preferiti"));
					}
				}
			}
		  });
		g.addColumn(5, preferiti);
		p.getChildren().add(g);
		g.prefWidthProperty().bind(p.prefWidthProperty());
		g.setAlignment(Pos.CENTER);
		return p;
	}
	@Override
	public VBox append(VBox v) {
		for(int i=0; i<articoli.size(); i++){
			Pane p=articoloDesideriPane(articoli.elementAt(i), sceneUpdater);
			p.prefWidthProperty().bind(v.prefWidthProperty());
			v.getChildren().add(p);
			v.getChildren().add(new Separator());
		}
		return v;
	}

}
