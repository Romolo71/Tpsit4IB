module it.rtonini.javafx.cookieclicker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens it.rtonini.javafx.cookieclicker to javafx.fxml;
    exports it.rtonini.javafx.cookieclicker;
}