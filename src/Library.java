import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
  private List<Document> documents = new ArrayList<>();
  private List<User> users = new ArrayList<>();

  public void addDocument(Document doc) {
    documents.add(doc);
  }

  public boolean removeDocument(String title) {
    Iterator<Document> iterator = documents.iterator();
    while (iterator.hasNext()) {
      Document doc = iterator.next();
      if (doc.getTitle().equals(title)) {
        iterator.remove(); // Sử dụng iterator để xóa tài liệu
        return true;
      }
    }
    return false; // Document not found
  }

  public void displayDocuments() {
    if (documents.isEmpty()) {
      System.out.println("No documents found.");
      return;
    }
    for (Document doc : documents) {
      doc.printInfo();
    }
  }

  public void addUser(User user) {
    users.add(user);
  }

  public User findUser(String name) {
    for (User user : users) {
      if (user.getName().equals(name)) {
        return user;
      }
    }
    return null; // User not found
  }

  // Tìm tài liệu theo tiêu đề
  public Document findDocument(String title) {
    for (Document doc : documents) {
      if (doc.getTitle().equals(title)) {
        return doc;
      }
    }
    return null; // Document not found
  }

  // Cập nhật thông tin tài liệu
  public boolean updateDocument(String title, int newQuantity) {
    Document doc = findDocument(title);
    if (doc != null) {
      doc.setQuantity(newQuantity);
      return true;
    }
    return false; // Document not found
  }

  // Phương thức mượn tài liệu
  public void borrowDocument(String userName, String title, int quantity) {
    User user = findUser(userName);
    Document document = findDocument(title);

    if (user != null && document != null && document.getQuantity() >= quantity) {
      user.borrowDocument(document, quantity);
      document.setQuantity(document.getQuantity() - quantity);
      System.out.println(userName + " borrowed " + quantity + " copies of " + title + " successfully!");
    } else if (user == null) {
      System.out.println("User not found!");
    } else if (document == null) {
      System.out.println("Document not found!");
    } else {
      System.out.println("Not enough copies available for borrowing.");
    }
  }

  // Phương thức trả tài liệu
  public void returnDocument(String userName, String title, int quantity) {
    User user = findUser(userName);
    Document document = findDocument(title);

    if (user != null && document != null) {
      user.returnDocument(document, quantity);
      document.setQuantity(document.getQuantity() + quantity);
      System.out.println(userName + " returned " + quantity + " copies of " + title + " successfully!");
    } else if (user == null) {
      System.out.println("User not found!");
    } else if (document == null) {
      System.out.println("Document not found!");
    }
  }
}
