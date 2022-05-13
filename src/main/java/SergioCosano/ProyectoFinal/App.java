package SergioCosano.ProyectoFinal;

import SergioCosano.ProyectoFinal.Utils.SQL;
import SergioCosano.ProyectoFinal.Utils.Utils;
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
        loadScene(stage, "Login", "Iniciar sesion", false, false);
        //scene = new Scene(loadFXML("Login"), 449, 629);
        //stage.setScene(scene);
        //stage.show();
    }

    private static Parent loadFXML(String fxml) {
        Parent result;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        try {
            result = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            //Dialog.showError("ERROR", "Hubo un error al cargar la vista", "La vista " + fxml + " no pudo cargarse debido a:\n " + e.getMessage());
            result = null;
        }
        return result;
    }

    public static void loadScene(Stage stage, String fxml, String title, boolean SaW, boolean isResizable) {
        stage.setScene(new Scene(loadFXML(fxml)));
        Utils.addCssAndIcon(stage, fxml);
        stage.setTitle(title);
        stage.setResizable(isResizable);
        if (SaW)
            stage.showAndWait();
        else
            stage.show();
    }

    /*private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }*/

    public static void main(String[] args) {
        launch();
    }

}