import java.util.Scanner;

public class LibraryApp {
  private static Library library = new Library();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("Welcome to My Application!");
      System.out.println("[0] Exit");
      System.out.println("[1] Add Document");
      System.out.println("[2] Remove Document");
      System.out.println("[3] Update Document");
      System.out.println("[4] Find Document");
      System.out.println("[5] Display Document");
      System.out.println("[6] Add User");
      System.out.println("[7] Borrow Document");
      System.out.println("[8] Return Document");
      System.out.println("[9] Display User Info");
      System.out.print("Choose an option: ");

      while (!scanner.hasNextInt()) {
        System.out.println("Action is not supported");
        scanner.next();  // clear invalid input
      }

      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addDocument(scanner);
          break;
        case 2:
          removeDocument(scanner);
          break;
        case 3:
          updateDocument(scanner);
          break;
        case 4:
          findDocument(scanner);
          break;
        case 5:
          library.displayDocuments();
          break;
        case 6:
          addUser(scanner);
          break;
        case 7:
          borrowDocument(scanner);
          break;
        case 8:
          returnDocument(scanner);
          break;
        case 9:
          displayUserInfo(scanner);
          break;
        case 0:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Action is not supported");
      }
    } while (choice != 0);

    scanner.close();
  }

  // Các phương thức cho các thao tác tương ứng như addDocument, removeDocument, ...

  private static void addDocument(Scanner scanner) {
    // Logic thêm tài liệu
    System.out.print("Enter document title: ");
    String title = scanner.next();
    System.out.print("Enter document author: ");
    String author = scanner.next();
    System.out.print("Enter document quantity: ");
    int quantity = scanner.nextInt();

    Document newDocument = new Document(title, author, quantity);
    library.addDocument(newDocument);
    System.out.println("Document added successfully!");
  }

  private static void removeDocument(Scanner scanner) {
    // Logic xóa tài liệu
    System.out.print("Enter document title to remove: ");
    String title = scanner.next();

    boolean removed = library.removeDocument(title);
    if (removed) {
      System.out.println("Document removed successfully!");
    } else {
      System.out.println("Document not found!");
    }
  }

  private static void updateDocument(Scanner scanner) {
    // Logic cập nhật tài liệu
    System.out.print("Enter document title to update: ");
    String title = scanner.next();

    Document document = library.findDocument(title);
    if (document != null) {
      System.out.print("Enter new quantity: ");
      int newQuantity = scanner.nextInt();
      document.setQuantity(newQuantity);
      System.out.println("Document updated successfully!");
    } else {
      System.out.println("Document not found!");
    }
  }

  private static void findDocument(Scanner scanner) {
    // Logic tìm tài liệu
    System.out.print("Enter document title to find: ");
    String title = scanner.next();

    Document document = library.findDocument(title);
    if (document != null) {
      document.printInfo();
    }
  }

  private static void addUser(Scanner scanner) {
    // Logic thêm người dùng
    System.out.print("Enter user name: ");
    String name = scanner.next();
    User newUser = User.createUser(name);
    library.addUser(newUser);
    System.out.println("User added successfully!");

  }

  private static void borrowDocument(Scanner scanner) {
    System.out.print("Enter user name: ");
    String userName = scanner.next();
    System.out.print("Enter document title to borrow: ");
    String title = scanner.next();
    System.out.print("Enter quantity to borrow: ");
    int quantity = scanner.nextInt();
    library.borrowDocument(userName, title, quantity);
  }

  private static void returnDocument(Scanner scanner) {
    System.out.print("Enter user name: ");
    String userName = scanner.next();
    System.out.print("Enter document title to return: ");
    String title = scanner.next();
    System.out.print("Enter quantity to return: ");
    int quantity = scanner.nextInt();
    library.returnDocument(userName, title, quantity);
  }

  private static void displayUserInfo(Scanner scanner) {
    // Logic hiển thị thông tin người dùng
    System.out.print("Enter user name: ");
    String userName = scanner.next();
    User user = library.findUser(userName);

    if (user != null) {
      user.displayInfo();
    } else {
      System.out.println("User not found!");
    }
  }
}
