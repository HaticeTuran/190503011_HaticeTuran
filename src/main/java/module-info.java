module com.hatice.fahrkurs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.hatice.fahrkurs to javafx.fxml;
    exports com.hatice.fahrkurs;
}