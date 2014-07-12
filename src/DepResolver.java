import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/11/14
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */

public class DepResolver {
    private List<Task> tasks;
    private boolean processedTaskList = false;
    private List<Task> assignedTasks = null;

    public DepResolver(List<Task> tasks){
       this.tasks = tasks;
    }

    public List<Task> getTasks(){
       return new ArrayList<Task>(tasks);
    }

    public boolean hasProcessedTaskList(){
        return this.processedTaskList;
    }

    public List<Task> getAssignedTasks(){
       if( !this.hasProcessedTaskList() ){
           List<Task> unassignedTask = new ArrayList<Task>( this.tasks );
           while( !unassignedTask.isEmpty() ){
              Task task = unassignedTask.get(0);
              unassignedTask.remove(0);
              for( Task dependentTask : task.getDependents() )
              {
                  dependentTask.removeDependent( task );
              }
              this.assignedTasks.add(task);
              Collections.sort( unassignedTask );
           }

           this.processedTaskList = true;
       }

       return this.assignedTasks;
    }
}
