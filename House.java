/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElavator;

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElavator) {
    super(name, address, nFloors); // is a building
    // with...
    this.hasDiningRoom = hasDiningRoom;
    this.hasElavator = hasElavator;
    this.residents = new ArrayList<String>();

  }

  /**
   * Overrides goToFloor(). Travels directly to specific floor number
   * 
   */
  public void goToFloor(int floorNum) {
    if (!this.hasElavator) {
      throw new RuntimeException("This building does not have an elevator. Please take the stairs.");
    }
    super.goToFloor(floorNum);
  }

  /**
   * Getter for boolean of hasDiningRoom
   * 
   * @return True or False
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Getter for number of residents in house
   * 
   * @return the number of residents
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Adds name to the residents list
   * 
   * @param name name of resident
   */
  public void moveIn(String name) {
    if (isResident(name)) {
      throw new RuntimeException(name + " is already a resident!");
    }
    residents.add(name);
  }

  /**
   * Removes name from residents list
   * 
   * @param name name of resident
   * @return the name removed
   */
  public String moveOut(String name) { // return the name of the person who moved out
    if (!isResident(name)) {
      throw new RuntimeException(name + " is not a resident!");
    }
    residents.remove(name);
    return name;
  }

  /**
   * returns whether person is a resident
   * 
   * @param person name of resident
   * @return true or false
   */
  public boolean isResident(String person) {
    return residents.contains(name);
  }

  /**
   * Overrides showOptions(). Prints actions available at the House.
   * 
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(name)\n + moveOut(name)\n");
  }

  public String toString() {
    String desc = super.toString();
    desc = "RESIDENCE HALL: " + desc;
    if (hasDiningRoom == true) {
      desc += ". It has a dining room. ";
    }
    return desc;
  }

  public static void main(String[] args) {
    House myHouse = new House("Morrow", "3 Elm St", 4, false, false);
    System.out.println(myHouse);
    myHouse.showOptions();
    myHouse.moveIn("Jen");
  }

}