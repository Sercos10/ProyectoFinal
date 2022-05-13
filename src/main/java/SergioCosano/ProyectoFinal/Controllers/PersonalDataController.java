package SergioCosano.ProyectoFinal.Controllers;

import SergioCosano.ProyectoFinal.App;
import SergioCosano.ProyectoFinal.Model.Cliente;
import SergioCosano.ProyectoFinal.Model.Inmueble;
import SergioCosano.ProyectoFinal.Utils.DataService;
import SergioCosano.ProyectoFinal.Utils.SQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PersonalDataController implements Initializable {
    private Cliente comparar;
    private Inmueble inmueble;

    @FXML
    private Pane pane;
    @FXML
    private MenuBar menubar;
    @FXML
    private Label nombre;
    @FXML
    private Label apellidos;
    @FXML
    private Label correo;
    @FXML
    private Label dni;

    /*
    Esta funcion carga los datos del usuario
     */
    @FXML
    private void getUserdata() throws IOException{
       comparar= DataService.cliente;
        if (comparar.getClass()==Cliente.class&&comparar!=null){
            nombre.setText(comparar.getNombre_cliente());
            apellidos.setText(comparar.getApellidos_cliente());
            correo.setText(comparar.getCorreo_cliente());
            dni.setText(comparar.getDni_cliente());
        }else{
            App.loadScene(new Stage(), "Login", "Iniciar sesión", true, false);
        }

    }

    @FXML
    private void switchToPiso(ActionEvent event) throws IOException {
        String select= "SELECT * FROM inmueble WHERE tipo_inmueble='Piso'";
        try {
            PreparedStatement pt= SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml").prepareStatement(select);
            ResultSet st= pt.executeQuery();
            if (st.next()){
                Inmueble inmueble= new Inmueble();
                inmueble.setId_inmueble(st.getInt("id_inmueble"));
                inmueble.setDesc_inmueble(st.getString("desc_inmueble"));
                inmueble.setPrecio_inmueble(st.getFloat("precio_inmueble"));
                inmueble.setFech_dispo(st.getDate("fech_dispo"));
                inmueble.setTipo_inmueble(st.getString("tipo_inmueble"));
                inmueble.setIndice(st.getInt("indice"));
                DataService.inmmueble=inmueble;
                App.loadScene(new Stage(),"Inmuebles", "Ver inmuebles", true, false);
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToCasa(ActionEvent event) throws IOException {
        String select= "SELECT * FROM inmueble WHERE tipo_inmueble='Casa'";
        try {
            PreparedStatement pt= SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml").prepareStatement(select);
            ResultSet st= pt.executeQuery();
            if (st.next()){
                Inmueble inmueble= new Inmueble();
                inmueble.setId_inmueble(st.getInt("id_inmueble"));
                inmueble.setDesc_inmueble(st.getString("desc_inmueble"));
                inmueble.setPrecio_inmueble(st.getFloat("precio_inmueble"));
                inmueble.setFech_dispo(st.getDate("fech_dispo"));
                inmueble.setTipo_inmueble(st.getString("tipo_inmueble"));
                inmueble.setIndice(st.getInt("indice"));
                DataService.inmmueble=inmueble;
                App.loadScene(new Stage(),"Inmuebles", "Ver inmuebles", true, false);
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToLocal(ActionEvent event) throws IOException {
        String select= "SELECT * FROM inmueble WHERE tipo_inmueble='Local'";
        try {
            PreparedStatement pt= SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml").prepareStatement(select);
            ResultSet st= pt.executeQuery();
            if (st.next()){
                Inmueble inmueble= new Inmueble();
                inmueble.setId_inmueble(st.getInt("id_inmueble"));
                inmueble.setDesc_inmueble(st.getString("desc_inmueble"));
                inmueble.setPrecio_inmueble(st.getFloat("precio_inmueble"));
                inmueble.setFech_dispo(st.getDate("fech_dispo"));
                inmueble.setTipo_inmueble(st.getString("tipo_inmueble"));
                inmueble.setIndice(st.getInt("indice"));
                DataService.inmmueble=inmueble;
                App.loadScene(new Stage(),"Inmuebles", "Ver inmuebles", true, false);
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToNave(ActionEvent event) throws IOException {
        String select= "SELECT * FROM inmueble WHERE tipo_inmueble='Nave'";
        try {
            PreparedStatement pt= SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml").prepareStatement(select);
            ResultSet st= pt.executeQuery();
            if (st.next()){
                Inmueble inmueble= new Inmueble();
                inmueble.setId_inmueble(st.getInt("id_inmueble"));
                inmueble.setDesc_inmueble(st.getString("desc_inmueble"));
                inmueble.setPrecio_inmueble(st.getFloat("precio_inmueble"));
                inmueble.setFech_dispo(st.getDate("fech_dispo"));
                inmueble.setTipo_inmueble(st.getString("tipo_inmueble"));
                inmueble.setIndice(st.getInt("indice"));
                DataService.inmmueble=inmueble;
                App.loadScene(new Stage(),"Inmuebles", "Ver inmuebles", true, false);
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToAlmacen(ActionEvent event) throws IOException {
        String select= "SELECT * FROM inmueble WHERE tipo_inmueble='Almacen'";
        try {
            PreparedStatement pt= SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml").prepareStatement(select);
            ResultSet st= pt.executeQuery();
            if (st.next()){
                Inmueble inmueble= new Inmueble();
                inmueble.setId_inmueble(st.getInt("id_inmueble"));
                inmueble.setDesc_inmueble(st.getString("desc_inmueble"));
                inmueble.setPrecio_inmueble(st.getFloat("precio_inmueble"));
                inmueble.setFech_dispo(st.getDate("fech_dispo"));
                inmueble.setTipo_inmueble(st.getString("tipo_inmueble"));
                inmueble.setIndice(st.getInt("indice"));
                DataService.inmmueble=inmueble;
                App.loadScene(new Stage(),"Inmuebles", "Ver inmuebles", true, false);
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToPrimary() {
        App.loadScene(new Stage(), "primary", "Iniciar sesion", true, false);
    }

    @FXML
    private void switchToAbout(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) menubar.getScene().getWindow();
            new AboutController().initAbout();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
    Esta funcion abre una ventana emergente donde puedes cambiar tus datos
     */
    @FXML
    private void switchToEditData(ActionEvent event) throws IOException {
        try {
            new EditClientController().initEdit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}