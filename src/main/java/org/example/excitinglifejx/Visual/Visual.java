package org.example.excitinglifejx.Visual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.excitinglifejx.BusinessLogic.Task.TaskInf;
import org.example.excitinglifejx.Controller.AddTaskControl;
import org.example.excitinglifejx.Controller.CompleteTaskControll;
import org.example.excitinglifejx.Controller.TroveControls;

import java.io.IOException;
import java.util.ArrayList;

public class Visual {



    public void start(Stage stage, TroveControls troveControls) {
        this.stage = stage;
        this.troveControls=troveControls;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/excitinglifejx/main_activity.fxml"));
            Parent root = loader.load();
            this.mainActivity = loader.getController();

            this.mainActivity.setVisual(this);
            this.mainActivity.getAddButton().setOnAction(troveControls.getAddTaskControl());

            Scene scene = new Scene(root, 1280, 720);


            Image icon = new Image(getClass().getResourceAsStream("/icons/icon.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Exciting Life | Legacy");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("petuh");
    }

    public MainActivity getMainActivity()
    {
        return mainActivity;
    }

    public void showTasks(ArrayList<TaskInf> tasks)
    {
        if (mainActivity != null)
        {
            mainActivity.getTaskListView().getItems().clear();

            for (TaskInf task : tasks)
            {
                addTask(task.getName(),task.getId());
            }
        }
    }

    private void addTask(String taskName,String id) {
        if (mainActivity != null) {
            HBox taskItem = new HBox(10);  // Создание контейнера для задачи
            Label taskLabel = new Label(taskName);
            taskLabel.setStyle("-fx-font-size: 20;");

            Button taskButton = new Button("□");
            taskButton.setStyle("-fx-font-size: 20;");
            taskButton.setUserData(id);
            taskButton.setOnAction(troveControls.getCompleteTaskControll());
            taskItem.getChildren().addAll(taskLabel, taskButton);

            mainActivity.getTaskListView().getItems().add(taskItem);  // Добавление задачи в ListView
        }
    }



    private Stage stage = null;
    private MainActivity mainActivity=null;
    private TroveControls troveControls;

}
