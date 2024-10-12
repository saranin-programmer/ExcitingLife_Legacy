package org.example.excitinglifejx.Controller;

import org.example.excitinglifejx.BusinessLogic.BusinessLogic;
import org.example.excitinglifejx.Visual.Visual;

public class TroveControls
{
    public TroveControls(BusinessLogic bc, Visual visual)
    {
        addTaskControl=new AddTaskControl(bc,visual);
        completeTaskControll=new CompleteTaskControll(bc,visual);
    }



    public Control getAddTaskControl()
    {
        return addTaskControl;
    }
    public Control getCompleteTaskControll()
    {
        return completeTaskControll;
    }

    AddTaskControl addTaskControl ;
    CompleteTaskControll completeTaskControll;
}
