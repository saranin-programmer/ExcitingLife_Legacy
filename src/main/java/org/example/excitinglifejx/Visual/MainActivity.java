package org.example.excitinglifejx.Visual;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class MainActivity
{



    public void initialize() {
       closeButton.setOnAction(event -> closeEmbeddedPopup());
    }

    public void setVisual(Visual visual)
    {
        this.visual=visual;
    }

    @FXML
    private void handleAddButtonClick() {

        if (popupContainer != null) {
            popupContainer.setVisible(true); // Включаем видимость встроенного окна
        }

        if (overlay != null) {

            overlay.setVisible(true); // Показываем затемнённый фон


        }
    }

    @FXML
    private VBox popupContainer; // Контейнер для встроенного окна
  //  @FXML
    //private Rectangle overlay;

    @FXML
    private VBox overlay;// Затемнённый фон

    @FXML
    private BorderPane mainContent;


    @FXML
    public void closeEmbeddedPopup() {

        if ( overlay != null) {

            overlay.setVisible(false); // Отключаем затемнённый фон

        }

        if (popupContainer != null) {
            popupContainer.setVisible(false); // Отключаем видимость встроенного окна
            mainContent.setMouseTransparent(false);
        }
    }

    public ListView<HBox> getTaskListView() {
        return taskListView;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Button getAddButton() {
        return addButton;
    }

    public TextArea getDescriptionField() {
        return descriptionField;
    }

    public TextField getTitleField() {
        return titleField;
    }

    @FXML
    private Button closeButton;
    @FXML
    private Button addButton;
    @FXML
    private  ListView<HBox> taskListView;
    @FXML
    private TextField titleField;
    @FXML
    private TextArea descriptionField;

    private Visual visual;
}
