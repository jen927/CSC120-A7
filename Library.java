/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors); // is a building
    // with...
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
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

  /**
   * Checks if book exists in collection
   * 
   * @param title title of book
   * @return true or false
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * Checks if book is available
   * 
   * @param title title of book
   * @return true or false
   */
  public boolean isAvailable(String title) {
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

  public static void main(String[] args) {
    Library mylibrary = new Library("Neilson Libarary", "123 W ST", 4);
    mylibrary.addTitle("Clear and Muddy Loss of Love");
    mylibrary.addTitle("Grandmaster of Demonic Cultivation");
    mylibrary.printCollection();
    mylibrary.checkOut("Clear and Muddy Loss of Love");
    mylibrary.printCollection();
    mylibrary.addTitle("Clear and Muddy Loss of Love");
  }

}