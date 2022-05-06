package javaFxController;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneFactory 
{

	static public Scene createScene(String resource, Object controller) throws IOException
	{
		FXMLLoader fxmlLoader =  new FXMLLoader(Main.class.getResource(resource));
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		return scene;
	}
}
