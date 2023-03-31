package org.casique.goal;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutableGoal {

    final String goal;
    final List<String> tasks;

    public ImmutableGoal(String goal, List<String> tasks){
        this.goal = goal;
        this.tasks = tasks;
    }

    public String getGoal(){
        return this.goal;
    }

    public List<String> getTasks(){
        List<String> resultGoal =  new ArrayList<>();
        /*for(String val: tasks){
            resultGoal.add(val);
        }
        return resultGoal;*/
        resultGoal.addAll(this.tasks);
        return resultGoal;
        //return tasks.stream().collect(ImmutableList.toImmutableList());
    }

    public static void main(String ...args){
        ImmutableGoal test = new ImmutableGoal("test 1", List.of("uno", "dos"));
        test.getTasks().stream().forEach(System.out::println);
        test.getTasks().add("tres");
        test.getTasks().stream().forEach(System.out::println);
    }

}
