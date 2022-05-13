module SergioCosano.ProyectoFinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.swing;
    requires java.sql;
    requires java.xml.bind;

    opens SergioCosano.ProyectoFinal.Utils to java.xml.bind;
    opens SergioCosano.ProyectoFinal to javafx.fxml;
    opens SergioCosano.ProyectoFinal.Controllers to javafx.fxml;
    exports SergioCosano.ProyectoFinal;
}
