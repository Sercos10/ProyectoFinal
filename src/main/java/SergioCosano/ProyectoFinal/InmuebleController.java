package SergioCosano.ProyectoFinal;

import SergioCosano.ProyectoFinal.Model.Cliente;
import SergioCosano.ProyectoFinal.Model.Inmueble;
import SergioCosano.ProyectoFinal.Utils.DataService;
import SergioCosano.ProyectoFinal.Utils.SQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InmuebleController {
    private Inmueble inmueble;
    @FXML
    private MenuBar menubar;
    @FXML
    private Pane pane;
    @FXML
    private Button comprar;
    @FXML
    private javafx.scene.control.Label tipo2;
    @FXML
    private javafx.scene.control.Label desc;
    @FXML
    private javafx.scene.control.Label ubic;
    @FXML
    private javafx.scene.control.Label prec;
    @FXML
    private javafx.scene.control.Label fech;
    @FXML
    private javafx.scene.control.Label tipo;
    @FXML
    private ImageView foto;
    private Image imagen;

    @FXML
    private void getUserdata(){
       inmueble= DataService.inmmueble;

        tipo2.setText(inmueble.getTipo_inmueble());
        desc.setText(inmueble.getDesc_inmueble());
        ubic.setText(inmueble.getUbic_inmueble());
        String precio= ""+inmueble.getPrecio_inmueble();
        prec.setText(precio);
        String fecha= ""+inmueble.getFech_dispo();
        fech.setText(fecha);
        tipo.setText(inmueble.getTipo_inmueble());
        int index=inmueble.getIndice();
        if (index>-1){
            switch (index){
                case 1: imagen= new Image("file:src/main/resources/SergioCosano/Inmuebles/almacen.jpg");
                    foto.setImage(imagen);
                    break;
                case 2: imagen= new Image("file:src/main/resources/SergioCosano/Inmuebles/casa.jpg");
                    foto.setImage(imagen);
                    break;
                case 3: imagen= new Image("file:src/main/resources/SergioCosano/Inmuebles/local.jpg");
                    foto.setImage(imagen);
                    break;
                case 4: imagen= new Image("file:src/main/resources/SergioCosano/Inmuebles/nave.jpg");
                    foto.setImage(imagen);
                    break;
                case 5: imagen= new Image("file:src/main/resources/SergioCosano/Inmuebles/pisos.jpg");
                    foto.setImage(imagen);
                    break;
            }
        }
    }

    @FXML
    private void Comprar(){
        Cliente client= DataService.cliente;

            String select= "UPDATE `inmueble` SET `id_cliente` = ? WHERE `inmueble`.`id_inmueble` = ?";
        Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");
        try {
            PreparedStatement pt= cn.prepareStatement(select);
            pt.setInt(1,client.getId_cliente());
            pt.setInt(2,inmueble.getId_inmueble());
            pt.executeUpdate();
            new ComprarController().initComprar();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
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
                App.setRoot("Inmuebles");
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
                App.setRoot("Inmuebles");
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
                App.setRoot("Inmuebles");
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
                App.setRoot("Inmuebles");
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
                App.setRoot("Inmuebles");
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToEditData(ActionEvent event) throws IOException {
        try {
            new EditClientController().initEdit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void switchToPersonalData(ActionEvent event) throws IOException {
        try {
            App.setRoot("personaldata");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}