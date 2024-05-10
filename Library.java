/* This is a stub for the Library class */

import java.util.ArrayList;
import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElavator;

  public Library(String name, String address, int nFloors, boolean hasElavator) {
    super(name, address, nFloors); // is a building
    // with...
    this.collection = new Hashtable<String, Boolean>();
    this.hasElavator = hasElavator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloads constructor. Adds default number of floors to 1 and hasElavator to
   * false.
   * 
   */
  public Library(String name, String address) {
    this(name, address, 1, false);
  }

  /**
   * Overrides goToFloor(). Allows direct travel to floor number if elavator
   * exists.
   * 
   */
  public void goToFloor(int floorNum) {
    if (!this.hasElavator) {
      throw new RuntimeException("This building does not have an elevator. Please take the stairs.");
    }
    super.goToFloor(floorNum);
  }

  /**
   * adds title to library collection
   * 
   * @param title title of book
   */
  public void addTitle(String title) {
    if (containsTitle(title)) {
      throw new RuntimeException(title + " is already in collection.");
    }
    collection.put(title, true);
  }

  /**
   * Removes book from collection
   * 
   * @param title title of book
   * @return the title that was removed
   */
  public String removeTitle(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " is not in collection.");
    }
    collection.remove(title);
    return title + " is removed from library.";
  }

  /**
   * Checks out book from collection
   * 
   * @param title title of book
   */
  public void checkOut(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " is not in collection.");
    }
    if (!collection.get(title).equals(true)) {
      throw new RuntimeException(title + " is not available.");
    }
    collection.replace(title, true, false);
  }

  /**
   * Returns book to collection
   * 
   * @param title title of book
   */
  public void returnBook(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " is not in collection and cannot be returned.");
    }
    if (!collection.get(title).equals(true)) {
      throw new RuntimeException(title + " is already available.");
    }
    collection.replace(title, false, true);
  }

  public void returnBook(ArrayList<String> Books){
    for (int i = 0; i < Books.size(); i++){
      if (!containsTitle(Books.get(i))) {
        throw new RuntimeException(Books.get(i) + " is not in collection and cannot be returned.");
      }
      if (!collection.get(Books.get(i)).equals(true)) {
        throw new RuntimeException(Books.get(i) + " is already available.");
      }
      collection.replace(Books.get(i), false, true);
    }
  }

  /**
   * Checks if book exists in collection
   * 
   * @param title title of book
   * @return true or false
   */
  private boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * Checks if book is available
   * 
   * @param title title of book
   * @return true or false
   */
  private boolean isAvailable(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " is not in collection.");
    }
    return collection.get(title).equals(true);
  }

  /**
   * Prints the title and status of each book in collection
   */
  public void printCollection() {
    System.out.println("List of books in collection:");
    collection.forEach((key, value) -> {
      if (isAvailable(key)) {
        String status = "In";
        System.out.println("Title: " + key + "\t Availability: " + status);
      } else {
        String status = "Out";
        System.out.println("Title: " + key + "\t Availability: " + status);
      }
    });

  }

  /**
   * Overrides showOptions(). Prints the available action at the Library.
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + checkOut(title)\n + returnBook(title)\n + isAvailable(title)");
  }

  public static void main(String[] args) {
    Library mylibrary = new Library("Neilson Libarary", "123 W ST", 4, true);
    mylibrary.addTitle("Clear and Muddy Loss of Love");
    mylibrary.addTitle("Grandmaster of Demonic Cultivation");
    mylibrary.printCollection();
    mylibrary.checkOut("Clear and Muddy Loss of Love");
    mylibrary.printCollection();

    mylibrary.showOptions();
  }

}