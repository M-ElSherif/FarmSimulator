package farmsimulator;

/**
 *
 * @author Mohamed El Sherif 04/06/2019 f we want to produce milk, we also need
 * cows. Cows have got names and udders. Udder capacity is a random value
 * between 15 and 40; the class Random can be used to raffle off the numers, for
 * instance, int num = 15 + new Random().nextInt(26);
 */
import java.util.*;

public class Cow implements Alive, Milkable {

    private String name;
    private double udderCapacity;      // milk capacity of cow
    private double amount;     // amount of milk in cow's udders
    private int liveHours;  // amount of hours cow is alive

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    // CONSTRUCTOR. Selects a name randomly from list
    public Cow() {
        int num = new Random().nextInt(32);
        this.name = NAMES[num];
        this.udderCapacity = 15 + new Random().nextInt(26);
    }

    public Cow(String name) {
        this.name = name;
        this.udderCapacity = 15 + new Random().nextInt(26);
    }

    // GETTER. Return cow's name
    public String getName() {
        return this.name;
    }

    // GET. Returns cow's capacity
    public double getCapacity() {
        return this.udderCapacity;
    }

    // GETTER. Returns amount of milk remaining in cow's udders.
    public double getAmount() {
        return this.amount;
    }

    // INTERFACE METHOD. The method increases the number of cow's live hours
    // by 1 and increases amount of milk in cow's udder by a random amount
    public void liveHour() {
        this.liveHours++;
        Random r = new Random();
        double num = 0.7 + (2.0 - 0.7) * r.nextDouble();
        this.amount += num;
        // if the new amount exceeds the capacity, then the amount is the capacity
        if (this.amount > this.udderCapacity) {
            this.amount = this.udderCapacity;
        }
    }

    // INTEFACE METHOD. Drains milk amount in cow's udders and returns the amount
    public double milk() {
        double milkedAmount = this.amount;
        this.amount = 0;
        return milkedAmount;
    }

    // METHOD. Prints cow description
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" +  Math.ceil(this.udderCapacity);
    }
    
}
