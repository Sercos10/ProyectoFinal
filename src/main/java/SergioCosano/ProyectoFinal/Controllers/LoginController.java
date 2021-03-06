package SergioCosano.ProyectoFinal.Controllers;

import SergioCosano.ProyectoFinal.App;
import SergioCosano.ProyectoFinal.Model.Cliente;
import SergioCosano.ProyectoFinal.Utils.DataService;
import SergioCosano.ProyectoFinal.Utils.SQL;
import SergioCosano.ProyectoFinal.Utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    private Cliente client;
    private String encrypt;
    @FXML
    javafx.scene.control.TextField email;
    @FXML
    Pane panel;
    @FXML
    PasswordField contrasena;
    @FXML
    Button login;


    /*
    Esta funcion cambia a la pagina principal
    @email2 Recoge el email introducido en el campo email
    @contrasena2 Recoge la contraseña introducida en el campo contrasena
    @select Sentencia SQL para comprobar que el email y la contraseña introducidas coinciden con un usuario de la base de datos
     */
    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        String select= "SELECT * FROM cliente WHERE correo_cliente=? AND contrasena=?";
        List<Object> rq= new ArrayList<>();
        String email2= email.getText();
        //Expresion regular para validar un email
        Pattern pat= Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        Matcher mat= pat.matcher(email2);
        String contrasena2= contrasena.getText();
        encrypt=Utils.encryptSHA256(contrasena2);
        //La contraseña debe tener minimo 8 caracteres, una misnuscula, una mayuscula, un digito y un caracter especial.
        Pattern pat2= Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[?!¡¿.@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher mat2= pat2.matcher(contrasena2);
        if (mat.matches()&&mat2.matches()){
            rq.add(email2);
            rq.add(encrypt);

            ResultSet comp= SQL.execQuery(select,rq);
            if (comp!=null) {
                try {
                    if(comp.next()) {
                        //Creo un nuevo cliente y le asignos los valores de la base de datos
                        client= new Cliente();
                        client.setId_cliente(comp.getInt("id_cliente"));
                        client.setNombre_cliente(comp.getString("nombre_cliente"));
                        client.setApellidos_cliente(comp.getString("apellidos_cliente"));
                        client.setCorreo_cliente(comp.getString("correo_cliente"));
                        client.setDni_cliente(comp.getString("dni_cliente"));
                        client.setContrasena(comp.getString("contrasena"));
                        DataService.cliente=client;
                        if (client.getId_cliente() != 7) {
                            App.loadScene(new Stage(),"primary", "Primary", true, false);
                        }else{
                            App.loadScene(new Stage(),"admin", "Admin", true, false);
                        }
                    }else{
                        //en caso de que los datos introducidos sean erroneos salta una ventana emergente de error
                        new ErrorController().initError();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else{
                //en caso de que los datos introducidos sean erroneos salta una ventana emergente de error
                new ErrorController().initError();
            }
        }else{
            //en caso de que los datos introducidos sean erroneos salta una ventana emergente de error
            new ErrorController().initError();
        }

    }

    /*
    Esta funcion hace que en caso de que el usuario no este loggeado en el sistema
    le aparezca una ventana emergente donde introduce los datos pertinentes para logearse
     */
    @FXML
    private void switchToRegister(ActionEvent event) throws IOException {
        try {
            //aqui llama a la ventana emergente para poder logearse
            new RegisterController().initRegister();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
