package farmsimulator;

/**
 *
 * @author thesh Farms have got an owner, a barn and a herd of cows. Farm also
 * implements our old interface Alive: calling the method liveHour makes all the
 * cows of the farm live for an hour. You also have to create method manageCows
 * which calls Barn's method takeCareOf so that all cows are milked.
 */
import java.util.*;

public class Farm implements Alive {

    private String owner;   // farm owner
    private Barn barn;      // farm's barn
    private List<Cow> herd;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.herd = new ArrayList<Cow>();
    }

    // GETTER. Gets owner's name
    public String getOwner() {
        return this.owner;
    }

    // METHOD. Adds a cow to the farm's herd
    public void addCow(Cow cow) {
        this.herd.add(cow);
    }

    // INTERFACE METHOD. Every cow in the herd has its live hours increased
    // by 1
    public void liveHour() {
        for (Cow cow : this.herd) {
            cow.liveHour();
        }
    }

    // METHOD. Calls Barn class method to milk cow's and add to milk to the
    // barn's bulk tank
    public void manageCows() {
        this.barn.takeCareOf(herd);
    }

    // METHOD. Calls Barn class method to installs a milking robot in the farm's barn 
    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

    // METHOD. Prints cows and their milk 
    public String printCows() {
        String cows = "";
        if (this.herd.isEmpty()) {
            cows = "No cows.";
        }
        for (Cow cow : this.herd) {
            cows = cows + "        " + cow.toString() + "\n";
        }
        return cows;
    }

    // METHOD. 
    public String toString() {

        String str = "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn.toString() + "\n"
                + "Animals: \n" + this.printCows();
        return str;
    }

}
