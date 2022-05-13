package SergioCosano.ProyectoFinal.Controllers;

import SergioCosano.ProyectoFinal.App;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterController {
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

    /*
    Esta funcion carga la ventana emergente donde estan todos los campos a rellenar
     */
    public void initRegister() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("Register.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    /*
    esta funcion es llamada por el boton aceptar y lo que hacer es guardar los datos introducidos por el usuario en la base de datos
     */
    @FXML
    private void RegisterClose(){
        String select="INSERT INTO `cliente`(`nombre_cliente`, `apellidos_cliente`, `correo_cliente`, `dni_cliente`, `contrasena`) VALUES (?,?,?,?,?)";
        Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
        //Expresion regular para validar un email
        Pattern pat= Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        Matcher mat= pat.matcher(correo.getText());
        //La contraseña debe tener minimo 8 caracteres, una misnuscula, una mayuscula, un digito y un caracter especial.
        Pattern pat2= Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[?!¡¿.@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher mat2= pat2.matcher(contrasena.getText());
        encrypt= Utils.encryptSHA256(contrasena.getText());
        Pattern pat3= Pattern.compile("^[0-9]{7,8}[A-Z]");
        Matcher mat3= pat3.matcher(dni.getText());
        if ((mat.matches()&&mat2.matches())&&mat3.matches()){
            try {
                PreparedStatement pt= cn.prepareStatement(select);
                pt.setString(1,nombre.getText());
                pt.setString(2,apellidos.getText());
                pt.setString(3,correo.getText());
                pt.setString(4,dni.getText());
                pt.setString(5,encrypt);
                pt.executeUpdate();
                new ApproveController().initApprove();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            stage= (Stage) this.boton.getScene().getWindow();
            stage.close();
        }else{
            try {
                new ErrorController().initError();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
