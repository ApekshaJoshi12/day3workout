class Product {
    private String productName;
    private double price;

   
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    
    public double calculateDiscount() {
        return 0; 
    }
}


class Electronics extends Product {

    public Electronics(String productName, double price) {
        super(productName, price);
    }

    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }
}


class Clothing extends Product {

    public Clothing(String productName, double price) {
        super(productName, price);
    }

    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }
}


public class Main7 {
    public static void main(String[] args) {

       
        Product p1 = new Electronics("Laptop", 50000);
        Product p2 = new Clothing("Jacket", 3000);

        System.out.println("Product: " + p1.getProductName());
        System.out.println("Original Price: " + p1.getPrice());
        System.out.println("Discount: " + p1.calculateDiscount());
        System.out.println("Final Price: " + (p1.getPrice() - p1.calculateDiscount()));

        System.out.println("-----------------------");

        System.out.println("Product: " + p2.getProductName());
        System.out.println("Original Price: " + p2.getPrice());
        System.out.println("Discount: " + p2.calculateDiscount());
        System.out.println("Final Price: " + (p2.getPrice() - p2.calculateDiscount()));
    }
}