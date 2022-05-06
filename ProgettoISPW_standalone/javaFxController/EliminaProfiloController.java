package javaFxController;

import control.ControlloreAdapter;
import exception.ErroreFxController;

public class EliminaProfiloController 
{
	SceneUpdater sceneUpdater;
	
	public EliminaProfiloController(SceneUpdater sceneUpdater)
	{
		this.sceneUpdater = sceneUpdater;
	}
	public void conferma()
	{
		try 
		{
			ControlloreAdapter cAdapter = ControlloreAdapter.getSingletonInstance();
			cAdapter.eliminaProfilo();
			sceneUpdater.updateSceneAndController("index");
		} catch (Exception e) 
		{
			AlertMessageGenerator.createAlertForError("eliminazione", e);
		}
	}
	
	public void annulla()
	{
		try {
			sceneUpdater.updateScene("gestioneProfilo");
		} catch (ErroreFxController e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AlertMessageGenerator.createAlertForError("reindirizzo a gestione profilo", e);
		}
	}
}
