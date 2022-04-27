package SergioCosano.ProyectoFinal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import SergioCosano.ProyectoFinal.Model.Inmueble;
import SergioCosano.ProyectoFinal.Utils.DataService;
import SergioCosano.ProyectoFinal.Utils.SQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;

public class PrimaryController implements Initializable {
    private Inmueble inmbueble;
    private Inmueble inmueble;
    private Integer index;
    @FXML
    private MenuBar menubar;
    @FXML
    private Pane pane;
    @FXML
    private Pagination pagination;
    @FXML
    private Button button;
    private File fileJpg[];


    @FXML
    private void handleButtonAction(ActionEvent event){
        //crea un escenario para mostrar una foto
        Stage  stage= (Stage) pane.getScene().getWindow();

        openDirectoryChooser(stage);

        //estas 3 lineas lo que hace es mostrar una imagen mediante el indice que estemos en el pagination
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer PageIndex) {
                index=PageIndex;
                return createPage(PageIndex); //En este return la funcion createPage es donde Formateo la imagen para poder mostrarla
            }
        });
    }

    private void openDirectoryChooser(Stage parent){
        //Aqui selecciono el directorio donde se guardan las fotos para que carguen
        File selectedDirectory = new File("src/main/resources/SergioCosano/Inmuebles");

        if (selectedDirectory!=null){
            //Creo un filtro para que solo se muestren imagenes .png
            FilenameFilter filterJpg = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".jpg");
                }
            };
            //anado la imagenes al array de ficheros
            fileJpg= selectedDirectory.listFiles(filterJpg);
        }
    }
    public VBox createPage(int index){
        //Creo un contenedor ImageView para poder mostrar las imagenes
        ImageView imageView= new ImageView();
        //Selecciono una imagen por el indice
        File file= fileJpg[index];
        try {
            //Convierto la imagen a un BufferedImage y le doy formato para mostrarla en el pagination
            BufferedImage bufferedImage= ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage,null);
            imageView.setImage(image);
            imageView.setFitWidth(323);
            imageView.setFitHeight(337);
            imageView.setSmooth(true);
            imageView.setCache(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Aqui anado la imagen a un VBox y lo devuelvo para mostrarla
        VBox pageBox= new VBox();
        pageBox.getChildren().add(imageView);
        return pageBox;
    }
    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        String select= "SELECT * FROM inmueble WHERE indice=?";
        List<Object> rq= new ArrayList<>();
        rq.add(index+1);

        ResultSet comp= SQL.execQuery(select,rq);
        if (comp!=null) {
            try {
                while (comp.next()) {
                    inmbueble= new Inmueble();
                    inmbueble.setId_inmueble(comp.getInt("id_inmueble"));
                    inmbueble.setDesc_inmueble(comp.getString("desc_inmueble"));
                    inmbueble.setUbic_inmueble(comp.getString("ubic_inmueble"));
                    inmbueble.setPrecio_inmueble(comp.getFloat("precio_inmueble"));
                    inmbueble.setFech_dispo(comp.getDate("fech_dispo"));
                    inmbueble.setTipo_inmueble(comp.getString("tipo_inmueble"));
                    inmbueble.setIndice(comp.getInt("indice"));
                    DataService.inmmueble=inmbueble;

                    App.setRoot("secondary");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            System.out.println("error");
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
    private void switchToPersonalData(ActionEvent event) throws IOException {
        try {
                App.setRoot("personaldata");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
