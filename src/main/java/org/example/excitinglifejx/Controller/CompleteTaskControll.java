package org.example.excitinglifejx.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.example.excitinglifejx.BusinessLogic.BusinessLogic;
import org.example.excitinglifejx.Visual.Visual;

public class CompleteTaskControll extends Control
{

    public CompleteTaskControll(BusinessLogic bc, Visual visual)
    {
        super(bc,visual);
    }
    @Override
    public void performe(ActionEvent event)
    {
        System.out.println("performe CompleteTaskControll");

        Object userData = ((Button) event.getSource()).getUserData();
        if (userData instanceof String) {
            System.out.println("in");
            String id = (String) userData;

            bc.completeTask(id);

            visual.showTasks(bc.getPendingTasks());

        }
    }
}
