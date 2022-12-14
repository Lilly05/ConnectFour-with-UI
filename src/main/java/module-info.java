module com.example.connectfourwithui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires fontawesomefx;

    opens com.example.connectfourwithui to javafx.fxml;
    exports com.example.connectfourwithui;
    exports com.example.connectfourwithui.GamePlay;
    opens com.example.connectfourwithui.GamePlay to javafx.fxml;
}