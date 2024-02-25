import java.util.Scanner;

public class ControlDemo5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double total=0;
        int qty=sc.nextInt();
        double price=sc.nextDouble();
        double amt=qty*price;
        if(amt<5000)total=amt-((5/100)*amt);
        else if (amt > 5000 && amt<1000)total=amt-((10/100)*amt);
        else total=amt-((15/100)*amt);
        System.out.println("after discounted price:"+total);
    }
    
}
