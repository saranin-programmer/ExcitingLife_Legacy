module org.example.excitinglifejx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens org.example.excitinglifejx.Controller to javafx.graphics, javafx.fxml;
    opens org.example.excitinglifejx.Visual to javafx.fxml;

    opens org.example.excitinglifejx to javafx.fxml;
    exports org.example.excitinglifejx;
}