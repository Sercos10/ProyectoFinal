package SergioCosano.ProyectoFinal;

import SergioCosano.ProyectoFinal.Utils.SQL;
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

public class RegisterController {
    private Stage stage;
    private Scene scene;
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

    public void initRegister() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("Register.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    private void RegisterClose(){
        String select="INSERT INTO `cliente`(`nombre_cliente`, `apellidos_cliente`, `correo_cliente`, `dni_cliente`, `contrasena`) VALUES (?,?,?,?,?)";
        Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
        try {
            PreparedStatement pt= cn.prepareStatement(select);
            pt.setString(1,nombre.getText());
            pt.setString(2,apellidos.getText());
            pt.setString(3,correo.getText());
            pt.setString(4,dni.getText());
            pt.setString(5,contrasena.getText());
            pt.executeUpdate();
            new ApproveController().initApprove();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        stage= (Stage) this.boton.getScene().getWindow();
        stage.close();
    }
}
