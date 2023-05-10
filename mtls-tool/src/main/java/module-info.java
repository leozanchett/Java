module com.example.mtlstool {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires servcore.crypto;
    requires org.bouncycastle.provider;

    opens com.example.mtlstool to javafx.fxml;
    exports com.example.mtlstool;
}