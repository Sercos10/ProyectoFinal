package SergioCosano.ProyectoFinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ComprarController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button boton;

    /*
    Muestra un mensaje que muestra que la compra ha sido realizada satisfactoriamente
     */
    public void initComprar() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("Comprar.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    private void ComprarClose(){
        stage= (Stage) this.boton.getScene().getWindow();
        stage.close();
    }
}
