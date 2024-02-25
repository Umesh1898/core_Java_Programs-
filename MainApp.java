 class Mobile{
    static class RAM{
        int RAM_SIZE=16;
             
         void display(){
        System.out.println("The size of RAM: " + RAM_SIZE);
         }
    }

    class Brand{
        String BrandName="Apple";

        void  info(){
            System.out.println("The name of the Brand: " + BrandName);
        }
    }
}

public class MainApp {
    public static void main(String[] args) {
         
         Mobile m1=new Mobile();
         Mobile.RAM r1=new Mobile.RAM();
         r1.display();

         Mobile.Brand b1= m1.new Brand();
         b1.info();
    }
    
}
