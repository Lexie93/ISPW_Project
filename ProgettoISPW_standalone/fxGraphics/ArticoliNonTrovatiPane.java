package fxGraphics;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ArticoliNonTrovatiPane extends ArticoloPane 
{
 public ArticoliNonTrovatiPane()
 {
	 
 }
 
 @Override
 public VBox append(VBox v)
 {	
	 v.getChildren().removeAll();
	 Pane p=new Pane();
		Label lab=new Label();
		lab.setText("Nessun annuncio trovato");
		lab.setAlignment(Pos.CENTER);
		p.getChildren().add(lab);
		p.prefWidthProperty().bind(v.widthProperty());
		//p.prefHeightProperty().bind(v.heightProperty());
		lab.prefWidthProperty().bind(p.prefWidthProperty());
		v.getChildren().add(p);
		return v;
 }
}
