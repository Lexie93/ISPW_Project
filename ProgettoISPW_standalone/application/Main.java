package application;
	

import javaFxController.SceneUpdater;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SceneUpdater sceneUpdater = new SceneUpdater(primaryStage);
			
			sceneUpdater.updateScene("index");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
