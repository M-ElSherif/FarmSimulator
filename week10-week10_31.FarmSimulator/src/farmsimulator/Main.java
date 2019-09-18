package farmsimulator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));

        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());

        farm.liveHour();
        farm.liveHour();
        System.out.println(farm);
    }

}
