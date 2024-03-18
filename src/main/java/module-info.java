module com.example.swep2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;

    opens com.example.swep2 to javafx.fxml;
    exports com.example.swep2;
}