import java.util.Scanner;

public class ControlDemo4 {
    public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter your loan amount:");
    double loanAmount=sc.nextDouble();
    sc.close();
    double interestRate;
    if(loanAmount>100000){
        interestRate=0.08;
    }else{
        interestRate=0.12;
    }
      double finalAmount=loanAmount+(loanAmount*interestRate);
      System.out.println("final amount after applying interest:"+finalAmount);
    
}
}