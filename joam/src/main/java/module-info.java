module ch.hslu.oop.sw13ex {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires org.slf4j;
    requires java.desktop;

    opens ch.hslu.oop.sw13ex to javafx.fxml;
    exports ch.hslu.oop.sw13ex;
}