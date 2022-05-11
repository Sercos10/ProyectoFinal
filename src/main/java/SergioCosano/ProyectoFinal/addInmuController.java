package SergioCosano.ProyectoFinal;

import SergioCosano.ProyectoFinal.Utils.SQL;
import SergioCosano.ProyectoFinal.Utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addInmuController {
    private Stage stage;
    private Scene scene;
    private String encrypt;
    @FXML
    private Button boton;
    @FXML
    private TextField descrip;
    @FXML
    private TextField ubic;
    @FXML
    private TextField precio;
    @FXML
    private TextField tipo;
    @FXML
    private TextField CRU;

    /*
    Esta funcion carga la ventana emergente donde estan todos los campos a rellenar
     */
    public void initAddInmu() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("addInmu.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    /*
    esta funcion es llamada por el boton aceptar y lo que hacer es guardar los datos introducidos por el usuario en la base de datos
     */
    @FXML
    private void InmmuClose(){
        LocalDateTime created= LocalDateTime.now();

        String select="INSERT INTO `inmueble`(`desc_inmueble`, `ubic_inmueble`, `precio_inmueble`,`fech_dispo`, `tipo_inmueble`, `CRU`,`id_cliente`) VALUES (?,?,?,?,?,?,?)";
        Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
            try {
                PreparedStatement pt= cn.prepareStatement(select);
                pt.setString(1,descrip.getText());
                pt.setString(2,ubic.getText());
                pt.setString(3,precio.getText());
                pt.setString(4, created.toString());
                pt.setString(5,tipo.getText());
                pt.setString(6,CRU.getText());
                pt.setString(7,"7");
                pt.executeUpdate();
                new ApproveController().initApprove();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            stage= (Stage) this.boton.getScene().getWindow();
            stage.close();
    }
}
