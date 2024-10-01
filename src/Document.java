public class Document {
  private String title;
  private String author;
  private int quantity;

  public Document(String title, String author, int quantity) {
    this.title = title;
    this.author = author;
    this.quantity = quantity;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void printInfo() {
    System.out.println("Title: " + title + ", Author: " + author + ", Quantity: " + quantity);
  }
}
