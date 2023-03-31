package org.casique.goal;

import java.util.ArrayList;
import java.util.List;

public class Goal {

    String goal;
    List<String> tasks;

    public Goal(){
        this.tasks = new ArrayList<String>();
    }

    public void setGoal(String goal){
        this.goal = goal;
    }

    public String getGoal(){
        return this.goal;
    }

    public void setTasks(List<String> tasks){
        this.tasks = tasks;
    }

    public List<String> getTasks(){
        return this.tasks;
    }

    public void addTask(String task){
        this.tasks.add(task);
    }

    public boolean removeTask(String task){
        return this.tasks.remove(task);
    }

}
