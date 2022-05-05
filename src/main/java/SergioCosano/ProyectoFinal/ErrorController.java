package SergioCosano.ProyectoFinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ErrorController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button boton;

    /*
    Esta funcion muestra una ventana la muestra que la contrasena o el email introducidos son erroneos
     */
    public void initError() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("Error.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    private void ErrorClose(){
        stage= (Stage) this.boton.getScene().getWindow();
        stage.close();
    }
}
