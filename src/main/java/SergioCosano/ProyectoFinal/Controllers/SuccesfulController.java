package SergioCosano.ProyectoFinal.Controllers;

import SergioCosano.ProyectoFinal.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SuccesfulController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button boton;

    /*
    Esta funcion muestra una ventana emergente cuando el usuario a cambiado sus datos correctamente
     */
    public void initSuccesful() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("Succesful.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    private void SuccesfulClose(){
        stage= (Stage) this.boton.getScene().getWindow();
        stage.close();
    }
}
