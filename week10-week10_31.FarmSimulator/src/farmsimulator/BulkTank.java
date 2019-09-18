
package farmsimulator;

/**
 *
 * @author Mohamed El Sherif 04/06/2019
 * Milk has to be stored in bulk tanks in good conditions. 
 * Bulk tanks are produced both with a standard capacity of 2000 litres, and with customer specific capacity. 
 * Create the class BulkTank, with the following constructors and methods.
 */
public class BulkTank {
    
    private double capacity;    // tank total capacity
    private double volume;      // tank occupied volume
    
    // DEFAULT CONSTRUCTOR
    public BulkTank() {
        this.capacity = 2000;
    }
    
    // INITIAL CONSTRUCTOR
    public BulkTank(double capacity) {
        this.capacity = capacity;
    }
    
    // GETTER METHOD. Gets the tank capacity
    public double getCapacity() {
        return this.capacity;
    }
    
    // GETTER METHOD. Gets the tank occupied volume
    public double getVolume() {
        return this.volume;
    }
    
    // METHOD. Returns how much remaining free space in the tank
    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }
    
    // METHOD. Adds to the tank only as mich milk that fits.
    // additional milk will not be added
    public void addToTank(double amount) {
        double freeSpace = this.howMuchFreeSpace(); // current avaialable space
        if (amount <= freeSpace) {
            this.volume += amount;
        }
        else if (amount > freeSpace) {
            this.volume += freeSpace;
        }
    }
    
    // METHOD. Takes from the milk tank amount, or all if amount exceeds
    // total volume available
    public double getFromTank(double amount) {
        if (amount <= this.volume) {
            this.volume -= amount;
            return amount;
        }
        else {
            double volume = this.volume;
            this.volume = 0;
            return volume;
        }
    }
    
    // METHOD
    public String toString() {
        return "" + Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
    
}

