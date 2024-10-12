package org.example.excitinglifejx.BusinessLogic;

import org.example.excitinglifejx.BusinessLogic.Task.DefaultTask;
import org.example.excitinglifejx.BusinessLogic.Task.Group;
import org.example.excitinglifejx.BusinessLogic.Task.Task;
import org.example.excitinglifejx.BusinessLogic.Task.TaskInf;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BusinessLogic {

    public BusinessLogic()
    {
        File saveDirectory = new File(SAVES);
        if (!saveDirectory.exists()) {
            saveDirectory.mkdirs(); // Создаёт папку только если её нет
            System.out.println("Папка " + SAVES + " создана.");
        }

        loadGroups();

        if(groups.isEmpty())
        {
            groups.put(0,new Group("default"));
        }
    }

    public void addTask(String name, String description)
    {

        groups.get(0).addTask(new DefaultTask(name,description));
       // saveGroups();
    }

    public void completeTask(String id)
    {
        groups.get(0).findTaskById(id).complete();
      //  saveGroups();
    }

    public void removeTask(String id)
    {
        groups.get(0).remove(id);
      //  saveGroups();
    }

    public void editTask(int id, String newName)
    {
        groups.get(0).getTasks().get(id).setName(newName);
        saveGroups();
    }

    public ArrayList<TaskInf> getAllTasks()
    {

        ArrayList<Task> taskList = groups.get(0).getTasks();
        ArrayList<TaskInf> taskInfList = new ArrayList<>();

        if (taskList != null) {
            // Преобразуем Task в TaskInf
            for (Task task : taskList) {
                taskInfList.add(task); // Task автоматически приводится к TaskInf
            }
        }

        return taskInfList;
    }

    public ArrayList<TaskInf> getPendingTasks()
    {
        ArrayList<Task> taskList = groups.get(0).getTasks();
        ArrayList<TaskInf> taskInfList = new ArrayList<>();

        if (taskList != null) {
            // Преобразуем Task в TaskInf
            for (Task task : taskList)
            {
                if (!task.isCompleted())
                {
                    taskInfList.add(task);
                }
            }
        }

        return taskInfList;
    }

    public ArrayList<TaskInf> getCompletedTasks()
    {
        ArrayList<Task> taskList = groups.get(0).getTasks();
        ArrayList<TaskInf> taskInfList = new ArrayList<>();

        if (taskList != null) {
            // Преобразуем Task в TaskInf
            for (Task task : taskList)
            {
                if (task.isCompleted())
                {
                    taskInfList.add(task);
                }
            }
        }

        return taskInfList;
    }


    public void saveGroups() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_GROUPS))) {
            oos.writeObject(groups);
            System.out.println("Данные сохранены успешно.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadGroups() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_GROUPS))) {
            groups = (HashMap<Integer, Group>) ois.readObject();
            System.out.println("Данные загружены успешно.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }

    HashMap<Integer, Group> groups = new HashMap<>();

    private final String SAVES=System.getenv("APPDATA") + File.separator + "ExcitingLifeLegacy";
    private final String SAVE_GROUPS=SAVES+ File.separator + "groupsData.ser";
}
