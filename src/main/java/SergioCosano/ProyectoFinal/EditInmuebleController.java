package SergioCosano.ProyectoFinal;

import SergioCosano.ProyectoFinal.Model.Cliente;
import SergioCosano.ProyectoFinal.Model.Inmueble;
import SergioCosano.ProyectoFinal.Utils.DataService;
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

public class EditInmuebleController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button boton;
    @FXML
    private TextField descrip;
    @FXML
    private TextField ubic;
    @FXML
    private TextField prec;
    @FXML
    private TextField tipo;

    public void initEdit() throws IOException{
        stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("EditInmueble.fxml"));
        scene= new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    private void getUserdata() throws IOException {
        Inmueble i = DataService.inmmueble;
        descrip.setText(i.getDesc_inmueble());
        ubic.setText(i.getUbic_inmueble());
        prec.setText(i.getPrecio_inmueble()+"");
        tipo.setText(i.getTipo_inmueble());
    }


    /*
    Esta funcion recoge los datos introducidos por el cliente y hace un UPDATE en la base de datos
     */
    @FXML
    private void EditClose(){
        Inmueble i= DataService.inmmueble;
        String s=""+i.getId_inmueble();
        String select= "UPDATE `inmueble` SET `desc_inmueble`=?, `ubic_inmueble`=?, `precio_inmueble`=?, `tipo_inmueble`=? WHERE `inmueble`.`id_inmueble` ="+s;
        Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
        try {
            PreparedStatement pt= cn.prepareStatement(select);
            pt.setString(1,descrip.getText());
            pt.setString(2,ubic.getText());
            pt.setString(3,prec.getText());
            pt.setString(4,tipo.getText());
            pt.executeUpdate();
            new SuccesfulController().initSuccesful();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        stage= (Stage) this.boton.getScene().getWindow();
        stage.close();
    }
}
