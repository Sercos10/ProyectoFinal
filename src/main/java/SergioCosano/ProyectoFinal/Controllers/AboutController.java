package SergioCosano.ProyectoFinal.Controllers;

import SergioCosano.ProyectoFinal.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AboutController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button boton;

    /*
    Muestra la version de la aplicacion y del autor que la ha desarrollado
     */
    public void initAbout() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("About.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    private void AboutClose(){
        stage= (Stage) this.boton.getScene().getWindow();
        stage.close();
    }
}
