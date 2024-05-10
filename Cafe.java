/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean hasElavator; // Whether Building has a Elavator

    /* Default constructor */
    public Cafe(String name, String address, int nFloors,
            int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /* Overloaded constructor */
    public Cafe(String name, String address) {
        this(name, address, 1, 100, 50, 100, 50);
    }

    /**
     * Overrides goToFloor(). Does not allow travel to other floors.
     * 
     */
    public void goToFloor(int floorNum) {
        if (!this.hasElavator) {
            throw new RuntimeException("This building does not have an elevator.");
        }
        System.out.println("Access to floors other than 1 is not premitted.");
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

        System.out.println("A " + size + " ounce coffee with " + nSugarPacketsUsed + " sugars and " + nCreamsUsed
                + " creams sold!");

    }

    /**
     * decreases the number of ingridents per coffee.
     * 
     */
    public void sellCoffee() {
        sellCoffee(6, 2, 3);

        System.out.println("A 6 ounce coffee with 2 sugars and 3 creams sold!");
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

    /**
     * Prints available actions one can take related to the building
     * 
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee()");
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
        myCafe.showOptions();
        myCafe.enter();
        myCafe.sellCoffee(10, 2, 4);
    }

}
