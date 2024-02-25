import java.util.Scanner;

public class ControlDemo2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the No1");
        int no1=sc.nextInt();
        System.out.println("Enter the no2");
        int no2=sc.nextInt();

        if(no1>no2){
            System.out.println("No1 is Greater than No2");
        }else if(no2>no1){
            System.out.println("No2 Is Greater Than no1");
        }else{
            System.out.println("both are equal");
        }
    }
    
}
