package org.example.excitinglifejx.BusinessLogic.Task;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable
{
    public Group(String name)
    {
        this.name=name;
    }
    public void addTask(Task task)
    {
        this.tasks.add(task);
    }

    public ArrayList<Task> getTasks()
    {
        return this.tasks;
    }
    public void remove(String id)
    {
        tasks.remove(findTaskById(id));
    }

    public Task findTaskById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task; // Возвращаем задачу, если id совпадает
            }
        }
        return null; // Возвращаем null, если задача с таким id не найдена
    }

    private ArrayList<Task> tasks = new ArrayList<>();

    private String name=null;
    private static final long serialVersionUID = 1L;

}
