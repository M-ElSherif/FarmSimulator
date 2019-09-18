package farmsimulator;

/**
 *
 * @author thesh
 * In modern dairy farms, milking robots handle the milking. The milking robot 
 * has to be connected to the bulk tank in order to milk an udder
 */
public class MilkingRobot {

    private BulkTank tank;

    public MilkingRobot() {
        
    }

    // GETTER. Gets installed bulk tank, or null reference if tank not installed
    public BulkTank getBulkTank() {
        return this.tank;
    }

    // SETTER. Installs the parameter bulk tank to the milking robot
    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }

    // METHOD. Milks the cow and fills the connected bulk tank. Method returns an 
    // IllegalStateException if no tank has been fixed
    public void milk(Milkable milkable) {
        if (this.tank == null) {
            throw new IllegalStateException("The MilkingRobot has not been installed");
        }
        double milkedAmount = milkable.milk();
        this.tank.addToTank(milkedAmount);
    }
}
