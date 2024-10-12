package org.example.excitinglifejx.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.excitinglifejx.BusinessLogic.BusinessLogic;
import org.example.excitinglifejx.Visual.Visual;

public abstract class  Control implements EventHandler<ActionEvent>
{
    public Control(BusinessLogic bc, Visual visual)
    {
        this.bc = bc;
        this.visual=visual;
    }

    @Override
    final public void handle(ActionEvent event)
    {
        this.performe(event);
    }
    public abstract void performe(ActionEvent event);

    Visual visual;
    BusinessLogic bc;
}
