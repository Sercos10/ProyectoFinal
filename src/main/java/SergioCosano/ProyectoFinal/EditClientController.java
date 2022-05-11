package SergioCosano.ProyectoFinal;

import SergioCosano.ProyectoFinal.Model.Cliente;
import SergioCosano.ProyectoFinal.Utils.DataService;
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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditClientController {
    private Stage stage;
    private Scene scene;
    private String encrypt;
    @FXML
    private Button boton;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField correo;
    @FXML
    private TextField dni;
    @FXML
    private PasswordField contrasena;

    public void initEdit() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("EditClient.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    private void getUserdata() throws IOException {
        Cliente c = DataService.cliente;
        nombre.setText(c.getNombre_cliente());
        apellidos.setText(c.getApellidos_cliente());
        correo.setText(c.getCorreo_cliente());
        dni.setText(c.getDni_cliente());
    }


    /*
    Esta funcion recoge los datos introducidos por el cliente y hace un UPDATE en la base de datos
     */
    @FXML
    private void EditClose(){
        Cliente c= DataService.cliente;
        String s=""+c.getId_cliente();
        String select= "UPDATE `cliente` SET `nombre_cliente`=?, `apellidos_cliente`=?, `correo_cliente`=?, `dni_cliente`=?, `contrasena`=? WHERE `cliente`.`id_cliente` ="+s;
        Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
        encrypt= Utils.encryptSHA256(contrasena.getText());
        try {
            PreparedStatement pt= cn.prepareStatement(select);
            pt.setString(1,nombre.getText());
            pt.setString(2,apellidos.getText());
            pt.setString(3,correo.getText());
            pt.setString(4,dni.getText());
            pt.setString(5,encrypt);
            pt.executeUpdate();
            new SuccesfulController().initSuccesful();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        stage= (Stage) this.boton.getScene().getWindow();
        stage.close();
    }
}
