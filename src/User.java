import java.util.ArrayList;
import java.util.List;

public class User {
  private String name;
  private List<Document> borrowedDocuments = new ArrayList<>();

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Document> getBorrowedDocuments() {
    return borrowedDocuments;
  }

  public void borrowDocument(Document document) {
    borrowedDocuments.add(document);
    System.out.println(name + " borrowed " + document.getTitle());
  }

  public void returnDocument(Document document) {
    borrowedDocuments.remove(document);
    System.out.println(name + " returned " + document.getTitle());
  }

  public void displayInfo() {
    System.out.println("User: " + name);
    System.out.println("Borrowed Documents:");
    for (Document doc : borrowedDocuments) {
      System.out.println("- " + doc.getTitle());
    }
  }

  // Thêm phương thức để thêm người dùng
  public static User createUser(String name) {
    return new User(name);
  }
}
