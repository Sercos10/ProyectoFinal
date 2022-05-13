package SergioCosano.ProyectoFinal.Controllers;

import SergioCosano.ProyectoFinal.App;
import SergioCosano.ProyectoFinal.Model.Inmueble;
import SergioCosano.ProyectoFinal.Model.InmuebleDAO;
import SergioCosano.ProyectoFinal.Utils.DataService;
import SergioCosano.ProyectoFinal.Utils.SQL;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminController{

    private InmuebleDAO iDAO = new InmuebleDAO();
    private List<Inmueble> inmuebles= (List<Inmueble>) iDAO.getAll();
    private final ObservableList<Inmueble>listaInmuebles= FXCollections.observableArrayList(inmuebles);
    @FXML
    private MenuBar menubar;
    @FXML
    private Button add;
    @FXML
    private Button edit;
    @FXML
    private Button delete;
    @FXML
    private TableView<Inmueble> tblinmueble;
    @FXML
    private TableColumn<Inmueble,Double> CRU;
    @FXML
    private TableColumn<Inmueble,String> tipo;
    @FXML
    private TableColumn<Inmueble,Float> precio;


    @FXML
    public void initialize() {
        this.configuraTabla();
        tblinmueble.setItems(FXCollections.observableArrayList(inmuebles));

    }
    @FXML
    private void configuraTabla() {
        CRU.setCellValueFactory(inmueble ->{
            ObservableValue<Double> ov = new SimpleDoubleProperty().asObject();
            ((ObjectProperty<Double>) ov).setValue(inmueble.getValue().getCRU());
            return ov;
        });
        tipo.setCellValueFactory(inmueble ->{
            SimpleStringProperty ssp = new SimpleStringProperty();
            ssp.setValue(inmueble.getValue().getTipo_inmueble());
            return ssp;
        });
        precio.setCellValueFactory(inmueble ->{
            ObservableValue<Float> fl = new SimpleFloatProperty().asObject();
            ((ObjectProperty<Float>) fl).setValue(inmueble.getValue().getPrecio_inmueble());
            return fl;
        });
    }

    @FXML
    private void delInmu(ActionEvent event){
        if (tblinmueble.getSelectionModel().getSelectedItem()!=null) {
            Inmueble selected = tblinmueble.getSelectionModel().getSelectedItem();
            iDAO.delete(selected);
        }
    }

    @FXML
    private void switchToEditInmu(ActionEvent event) throws IOException {
        try {
            if (tblinmueble.getSelectionModel().getSelectedItem()!=null){
                Inmueble selected= tblinmueble.getSelectionModel().getSelectedItem();
                DataService.inmmueble=selected;
                new EditInmuebleController().initEdit();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        this.initialize();
    }

    @FXML
    private void switchToAddInmu(ActionEvent event) throws IOException {
        try {
            new addInmuController().initAddInmu();
            initialize();
        } catch (Exception e) {
            System.out.println(e);
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
                inmueble.setCRU(st.getDouble("CRU"));
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
                inmueble.setCRU(st.getDouble("CRU"));
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
                inmueble.setCRU(st.getDouble("CRU"));
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
                inmueble.setCRU(st.getDouble("CRU"));
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
                inmueble.setCRU(st.getDouble("CRU"));
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
}
