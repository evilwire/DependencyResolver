/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/11/14
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;
import java.util.ArrayList;

public class Task {
    private List<Task> dependents;
    private List<Task> dependencies;
    private String name;

    public Task( String name ){
       this.name = name;
    }

    public List<Task> getDependents(){
       return (List<Task>)
               ((ArrayList<Task>) this.dependents).clone();
    }

    public List<Task> getDependencies(){
        return (List<Task>)
               ((ArrayList<Task>) this.dependencies).clone();
    }

    public String getName(){
        return this.name;
    }

    public void removeDependent(Task dependent){
        this.dependents.remove(dependent);
    }

    @Override
    public String toString(){

    }

    @Override
    public boolean equals(Object other){
       if( other.getClass().getName() != "Task")
           return false;

       return this.getName() == ((Task) other).getName();
    }
}
