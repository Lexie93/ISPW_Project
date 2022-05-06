package fxGraphics;

import java.util.Vector;

import entity.Articolo;
import javaFxController.SceneUpdater;

public class ArticoliPaneFactory {

	public ArticoloPane createArticoloPane(Vector<Articolo> articoli, SceneUpdater sceneUpdater,String type)
	{
		if(articoli.size()==0)
			return new ArticoliNonTrovatiPane();
		else	if(type.equals("propri"))
				return new ArticoloDecoratorImplementation(new ArticoliPropriPane(articoli,sceneUpdater),articoli.size());
		else	if(type.equals("preferiti"))
			return new ArticoloDecoratorImplementation(new ArticoliPreferitiPane(articoli,sceneUpdater),articoli.size());
		else	if(type.equals("ricerca"))
			return new ArticoloDecoratorImplementation(new ArticoliCercatiPane(articoli,sceneUpdater),articoli.size());
		return null;

			
	}
}
