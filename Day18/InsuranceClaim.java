class Claim{
    final int policyNumber;
    Claim(int policyNumber){
        this.policyNumber=policyNumber;
    }
    final void verify(){
        System.out.println("Policy "+policyNumber+" verified.");
    }
}
public class InsuranceClaim{
    public static void main(String[] args){
        Claim c=new Claim(1001);
        c.verify();
        System.out.println("A final class cannot be inherited, improving security.");
    }
}
