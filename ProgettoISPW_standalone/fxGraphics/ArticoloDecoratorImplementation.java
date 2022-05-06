package fxGraphics;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ArticoloDecoratorImplementation extends ArticoliDecorator{

	private Integer r;
	public ArticoloDecoratorImplementation(ArticoloPane component,int r) {
		super(component);
		this.r = r;
		
	}
	
	public VBox append(VBox v)
	{
		v.getChildren().removeAll();
		Pane p=new Pane();
		Label lab=new Label();
		lab.setText("Annunci trovati: " + r.toString());
		lab.setAlignment(Pos.CENTER);
		p.getChildren().add(lab);
		p.prefWidthProperty().bind(v.widthProperty());
		//p.prefHeightProperty().bind(v.heightProperty());
		lab.prefWidthProperty().bind(p.prefWidthProperty());
		v.getChildren().add(p);
		return super.append(v);
	}

}
