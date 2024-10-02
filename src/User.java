import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

  public void borrowDocument(Document document, int quantity) {
    for (int i = 0; i < quantity; i++) {
      borrowedDocuments.add(document);
    }
    System.out.println(name + " borrowed " + quantity + " copies of " + document.getTitle());
  }

  public void returnDocument(Document document, int quantity) {
    int count = 0;
    Iterator<Document> iterator = borrowedDocuments.iterator();
    while (iterator.hasNext() && count < quantity) {
      Document doc = iterator.next();
      if (doc.equals(document)) {
        iterator.remove();
        count++;
      }
    }
    System.out.println(name + " returned " + count + " copies of " + document.getTitle());
  }

  public void displayInfo() {
    System.out.println("User: " + name);
    System.out.println("Borrowed Documents:");
    Map<String, Integer> documentCount = new HashMap<>();
    for (Document doc : borrowedDocuments) {
      documentCount.put(doc.getTitle(), documentCount.getOrDefault(doc.getTitle(), 0) + 1);
    }
    for (Map.Entry<String, Integer> entry : documentCount.entrySet()) {
      System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " copies");
    }
  }

  // Thêm phương thức để thêm người dùng
  public static User createUser(String name) {
    return new User(name);
  }
}
