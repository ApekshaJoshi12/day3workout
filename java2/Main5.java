abstract class Payment {
    
    
    abstract void pay(double amount);
}


class CreditCardPayment extends Payment {
    
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}


class UPIPayment extends Payment {
    
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}


class NetBankingPayment extends Payment {
    
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Net Banking.");
    }
}


public class Main5 {
    public static void main(String[] args) {
        
       
        Payment p;
        
        p = new CreditCardPayment();
        p.pay(5000);
        
        p = new UPIPayment();
        p.pay(2500);
        
        p = new NetBankingPayment();
        p.pay(10000);
    }
}