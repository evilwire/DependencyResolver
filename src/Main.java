import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/11/14
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        Location locations [] = new Location[7];
        locations[0] = new Location(1, 2);
        locations[1] = new Location(1, 3);
        locations[2] = new Location(3, 1);
        locations[3] = new Location(2, 1);
        locations[4] = new Location(2, 3);
        locations[5] = new Location(5, 1);
        locations[6] = new Location(3, 1);

        List<Location> locationArray =
                new ArrayList<Location>(Arrays.asList(locations));

        for(Location location : locationArray){
            System.out.println( location );
        }

        System.out.println("Now sorting...");

        Collections.sort(locationArray);

        for(Location location : locationArray){
            System.out.println( location );
        }
    }

}
