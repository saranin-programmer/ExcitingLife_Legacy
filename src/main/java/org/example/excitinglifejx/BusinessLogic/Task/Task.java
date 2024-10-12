package org.example.excitinglifejx.BusinessLogic.Task;

public interface Task extends TaskInf {


    void complete();
    void setName(String name);
    boolean isCompleted();


}
