package finalKeyword;

class LoanAccount { 

    double principal; 
    double annualRate; 
    int months; 
    LoanAccount(double p, double r, int m) { 
        this.principal = p; 
        this.annualRate = r; 
        this.months = m; 
    }

    // FINAL — no subclass can change EMI calculation 
    final double calculateEMI() { 
        double r = annualRate / 12 / 100;  // Monthly rate 
        double emi = (principal * r * Math.pow(1 + r, months)) / (Math.pow(1 + r, months) - 1); 
        return Math.round(emi * 100.0) / 100.0; 
    } 

    // Non-final — can be overridden 
    void loanType() { 
        System.out.println("Generic Loan"); 
    } 
} 

class HomeLoan extends LoanAccount { 

    HomeLoan(double p, double r, int m) { 
        super(p, r, m); 
    } 

    @Override 
    void loanType() { 
        System.out.println("Home Loan");   // Allowed! 
    } 
    // @Override 
    // final double calculateEMI() { ... }  // COMPILE ERROR! 

} 

public class FinalMethod {
    public static void main(String[] args) { 
        HomeLoan loan = new HomeLoan(500000, 8.5, 240); 
        loan.loanType(); 
        System.out.println("Monthly EMI: Rs. " + loan.calculateEMI()); 
    }
}
