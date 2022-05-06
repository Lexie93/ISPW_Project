package fxGraphics;


import javafx.scene.layout.VBox;

public abstract class ArticoliDecorator extends ArticoloPane
{
	private ArticoloPane component;
	
	public ArticoliDecorator(ArticoloPane component)
	{
		this.component = component;
	}
	
	public VBox append(VBox vbox)
	{
		
		return component.append(vbox);
	}
}
