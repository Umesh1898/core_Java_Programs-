import java.util.Scanner;

public class controlDemo3 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enetr a number");
        int num=sc.nextInt();
        if(num>0){
        if(num%2==0){
            System.out.println(num +"is even");
        }else{
            System.out.println(num +"is odd");
        }
    }
}
}
