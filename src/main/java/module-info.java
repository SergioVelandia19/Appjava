module com.example.appjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jbcrypt;

    opens com.example.appjava to javafx.fxml;
    exports com.example.appjava;
}