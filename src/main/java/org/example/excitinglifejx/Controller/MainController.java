package org.example.excitinglifejx.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.excitinglifejx.BusinessLogic.BusinessLogic;
import org.example.excitinglifejx.Visual.Visual;

import java.io.IOException;

public class MainController extends Application {

    public MainController()
    {
        troveControls=new TroveControls(bc, visual);
    }

    @Override
    public void start(Stage stage)
    {


        //bc.addTask("посрать","смело");
        //bc.addTask("отковырять прыщь","кувалдой");
       // bc.addTask("пройти холлоу найт","сотый раз");


        visual.start(stage,troveControls);

        visual.showTasks(bc.getPendingTasks());
    }

    @Override
    public void stop() {
        // Сохраняем данные при завершении приложения
        bc.saveGroups();
    }

    public static void main(String[] args) {
        launch(args);
    }

    Visual visual = new Visual();
    BusinessLogic bc = new BusinessLogic();
    TroveControls troveControls;
}





//
//
//
//package org.example.Controller;
//
//import org.example.BusinessLogic.BusinessLogic;
//import org.example.Visual.Visual;
//
//import javax.swing.*;
//
//public class MainController {
//    public void start()
//    {
//        bc.addTask("go to the university");
//        bc.addTask("eat");
//        bc.addTask("play video game");
//
//        bc.completeTask(0);
//
//        SwingUtilities.invokeLater(() -> {
//            visual.setVisible(true); // Отображаем UI
//        });
//
//        visual.showPendingTasks(bc.getPendingTasks());
//        visual.showCompletedTasks(bc.getCompletedTasks());
//    }
//
//    private BusinessLogic bc=new BusinessLogic();
//    private Visual visual = new Visual();
//}
