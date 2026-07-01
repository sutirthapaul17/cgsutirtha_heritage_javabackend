class Discount{
    void calculateDiscount(double amount){
        System.out.println("Discount: "+amount*0.05);
    }
    void calculateDiscount(double amount,String customerType){
        double d=customerType.equalsIgnoreCase("Premium")?0.15:0.10;
        System.out.println("Discount: "+amount*d);
    }
    void calculateDiscount(double amount,String customerType,boolean festival){
        double d=customerType.equalsIgnoreCase("Premium")?0.15:0.10;
        if(festival)d+=0.05;
        System.out.println("Discount: "+amount*d);
    }
}
public class ECommerceDiscount{
    public static void main(String[] args){
        Discount d=new Discount();
        d.calculateDiscount(1000);
        d.calculateDiscount(1000,"Premium");
        d.calculateDiscount(1000,"Regular",true);
    }
}
