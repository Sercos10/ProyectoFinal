package SergioCosano.ProyectoFinal.Controllers;

import SergioCosano.ProyectoFinal.App;
import SergioCosano.ProyectoFinal.Utils.SQL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        LocalDate created= LocalDate.now();
        java.sql.Date sqlDate= java.sql.Date.valueOf(created);
        String select="INSERT INTO `inmueble` (`id_inmueble`, `desc_inmueble`, `ubic_inmueble`, `precio_inmueble`, `fech_dispo`, `tipo_inmueble`, `CRU`, `id_cliente`, `indice`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, 0)";
        Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
            try {
                PreparedStatement pt= cn.prepareStatement(select);
                pt.setString(1,descrip.getText());
                pt.setString(2,ubic.getText());
                pt.setDouble(3, Double.parseDouble(precio.getText()));
                pt.setDate(4, sqlDate);
                pt.setString(5,tipo.getText());
                pt.setDouble(6, Double.parseDouble(CRU.getText()));
                pt.setInt(7,7);
                pt.executeUpdate();
                new ApproveController().initApprove();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            stage= (Stage) this.boton.getScene().getWindow();
            stage.close();
    }
}
