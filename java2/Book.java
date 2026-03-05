class Book {

    
    private String title;
    private String author;
    private double price;

    
    public Book(String title) {
        this.title = title;
        this.author = "Unknown";
        this.price = 0.0;
    }

   
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
    }

    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

   
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("----------------------");
    }

    
    public static void main(String[] args) {

        
        Book b1 = new Book("Java Programming");
        Book b2 = new Book("Python Basics", "John Smith");
        Book b3 = new Book("Data Structures", "Amit Kumar", 499.99);

        
        b1.displayDetails();
        b2.displayDetails();
        b3.displayDetails();
    }
}