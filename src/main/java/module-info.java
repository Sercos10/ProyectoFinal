module SergioCosano.ProyectoFinal {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires javafx.swing;
    requires java.sql;
    requires java.xml.bind;

    opens SergioCosano.ProyectoFinal.Utils to java.xml.bind;
    opens SergioCosano.ProyectoFinal to javafx.fxml;
    exports SergioCosano.ProyectoFinal;
}
