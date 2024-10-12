package org.example.excitinglifejx.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.excitinglifejx.BusinessLogic.BusinessLogic;
import org.example.excitinglifejx.Visual.Visual;

public class AddTaskControl extends Control
{
    public AddTaskControl(BusinessLogic bc, Visual visual)
    {
        super(bc,visual);
    }

    @Override
    public void performe(ActionEvent event)
    {
        String name = visual.getMainActivity().getTitleField().getText();
        String description = visual.getMainActivity().getDescriptionField().getText();

        visual.getMainActivity().getTitleField().clear();
        visual.getMainActivity().getDescriptionField().clear();


        bc.addTask(name,description);

        visual.getMainActivity().closeEmbeddedPopup();
        visual.showTasks(bc.getPendingTasks());
    }
}
