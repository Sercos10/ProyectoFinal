package SergioCosano.ProyectoFinal;

import SergioCosano.ProyectoFinal.Utils.SQL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    //iniciamos la aplicacion y hacemos la conexcion con la base de datos
    @Override
    public void start(Stage stage) throws IOException {
        Connection conectado= SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
        scene = new Scene(loadFXML("Login"), 449, 629);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}