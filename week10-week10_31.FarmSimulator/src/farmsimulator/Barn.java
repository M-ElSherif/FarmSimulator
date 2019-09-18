package farmsimulator;

/**
 *
 * @author thesh Cows are kept (and in this case milked) in barns. The original
 * barns have room for one milking robot. Note that when milking robots are
 * installed, they are connected to a specific barn's bulk tank. If a barn does
 * not have a milking robot, it can't be used to handle the cow, either.
 */
import java.util.*;

public class Barn {

    private BulkTank barnTank;
    private boolean installed;  // boolean variable indicating if mlkingRobot is installed

    public Barn(BulkTank tank) {
        this.barnTank = tank;
    }

    // GETTER. Returns the barn's bulk tank
    public BulkTank getBulkTank() {
        return this.barnTank;
    }

    // METHOD. installs a milking robot and connects it to the barn bulk tank
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        milkingRobot.setBulkTank(barnTank); // connects milkingRobot to barn tank
        installed = true;
    }

    // METHOD. Milks the parameter cows with the help of the milking robot, the
    // method throws an IllegalStateException if the milking robot hasn't been installed
    public void takeCareOf(Cow cow) {
        if (!this.installed) {
            throw new IllegalStateException("The MilkingRobot has not been installed.");
        }
        double milkedAmount = cow.milk();
        this.barnTank.addToTank(milkedAmount);
    }

    // METHOD. Milks the parameter cows with the help of the milking robot, the
    // method throws an IllegalStateException if the milking robot hasn't been installed
    public void takeCareOf(Collection<Cow> cows) {
        if (!this.installed) {
            throw new IllegalStateException("The MilkingRobot has not been installed.");
        }
        for (Cow cow : cows) {
            double milkedAmount = cow.milk();
            this.barnTank.addToTank(milkedAmount);
        }
    }

    // METHOD. Returns the state of the bulk tank contained by the barn
    public String toString() {
        return this.barnTank.toString();
    }
}
