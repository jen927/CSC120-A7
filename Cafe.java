/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors,
            int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * decreases the number of ingridents per coffee
     * 
     * @param size              number of ounces used
     * @param nSugarPacketsUsed number of sugar packets used
     * @param nCreamsUsed       number of creams used
     */
    public void sellCoffee(int size, int nSugarPacketsUsed, int nCreamsUsed) {
        if ((nCoffeeOunces < size) || (nSugarPackets < nSugarPacketsUsed) || (nCreams < nCreamsUsed) || (nCups < 1)) {
            restock(100, 50, 200, 10);
        }
        nCoffeeOunces -= size;
        nSugarPackets -= nSugarPacketsUsed;
        nCreams -= nCreamsUsed;
        nCups -= 1;

    }

    /**
     * Adds to the size of each ingredient.
     * 
     * @param nCoffeeOunces number ounces of coffee added
     * @param nSugarPackets number of sugar packets added
     * @param nCreams       number of creams added
     * @param nCups         number of cups added
     */
    private void restock(int nCoffeeOuncesAdded, int nSugarPacketsAdded, int nCreamsAdded, int nCupsAdded) {
        nCoffeeOunces += nCoffeeOuncesAdded;
        nSugarPackets += nSugarPacketsAdded;
        nCreams += nCreamsAdded;
        nCups += nCupsAdded;
    }

    public String toString() {
        String desc = super.toString();
        desc = "CAFE: " + desc;
        return desc;
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Center Cafe",
                "123 W St", 1, 100, 20, 50, 10);
        System.out.println(myCafe.toString());
        myCafe.sellCoffee(10, 1, 5);
    }

}
