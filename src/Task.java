/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/11/14
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.Collection;

public class Task {
    private Collection<Task> dependents;
    private Collection<Task> dependencies;
    private String name;

    public Task( String name ){
       this.name = name;
    }

    public Collection<Task> getDependents(){
       return new ArrayList<Task>(this.dependents);
    }

    public Collection<Task> getDependencies(){
       return new ArrayList<Task>(this.dependencies);
    }

    public String getName(){
        return this.name;
    }

    public void removeDependent(Task dependent){
        this.dependents.remove(dependent);
    }

    public void addDependents( Collection<Task> dependents ){
        this.dependents.addAll( dependents );

        for( Task dependent : dependents ){
            dependent.addDependency( this );
        }
    }

    public void addDependency( Task dependency ){
        this.dependencies.add(dependency);
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object other){
       if( other.getClass().getName() != "Task")
           return false;

       return this.getName() == ((Task) other).getName();
    }
}
