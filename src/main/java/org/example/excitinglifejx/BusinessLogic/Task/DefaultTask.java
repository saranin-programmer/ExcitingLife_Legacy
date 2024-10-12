package org.example.excitinglifejx.BusinessLogic.Task;

import java.util.UUID;

public class DefaultTask implements Task{

    public DefaultTask(String name, String description)
    {
        UUID uniqueID = UUID.randomUUID();
        this.id= uniqueID.toString();
        this.name=name;
        this.description=description;
    }

    public void complete()
    {
        isComplete=true;
    }

    public boolean isCompleted()
    {
        return this.isComplete;
    }

    public String getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    String id;
    String name=null;
    String description=null;

    boolean isComplete=false;


}
