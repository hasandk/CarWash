
import java.util.ArrayList;
import java.util.Scanner;


public class CarWash {
 //lave en arraylist,  
    ArrayList<Customer> cl;
    ArrayList<WashCard> wcl;
    Customer c1, c2, c3;
    WashCard wc1 = null;
    WashCard wc2 = null;
    WashCard wc3 = null;
    Scanner scanner = new Scanner(System.in);
   //trin 1
    private void register() {
        cl = new ArrayList<>();
        wcl = new ArrayList<>();
        //lav customers
        c1 = new Customer(1, "Hasan", "Haidari", "4444444");
        c2 = new Customer(2, "Daniel", "Ha", "354656");
        c3 = new Customer(3, "Mama", "ghahwei", "8880987");
        cl.add(c1);
        cl.add(c2);
        cl.add(c3);
        //lav Cards
        wc1 = new WashCard(1, "Hasan", 500);
        wc2 = new WashCard(2, "Daniel", 2000);
        wc3 = new WashCard(3, "Mama", 2000);
        wcl.add(wc1);
        wcl.add(wc2);
        wcl.add(wc3);

        System.out.print("\n Customers are registered and wash card is published.\n");
    }
    
    //trin 2
    // lave forloops for at kunne finde rette personer, id'er
    private void login(int cpr) {
        boolean result = false;
        int i = 0; // Counter used to determine customers
        for (Customer c : cl) { // For hver customer i listen
            if (cpr == c.getCpr()) { // check om de er eksisternede
                result = true;
                while (result) {
                    System.out.print("\n *************Hello " + c.getName() + "**************\n");
                    System.out.print("1. add balance 2. wash your car 3. Logout\t "
                            + "\n Enter a number: \t");
                     //trin 3
                    int nummer = scanner.nextInt();
                    if (nummer == 1) {
                        System.out.print("\n Insert cash: \t");
                        int amount = scanner.nextInt();
                        int x = 0;
                        for (WashCard wc : wcl) {
                            if (wc.cardId == c.getCpr()) {
                                wc.addBalance(amount);
                                System.out.print("\n balance is added \n");
                                System.out.println("\n your balance is:" + wc.getBalance());
                            } else {
                                x++;
                            }
                        }
                    } else if (nummer == 2) {
                        int x = 0;
                        for (WashCard wc : wcl) {
                            if (wc.cardId == c.getCpr()) {
                                if (wc.getBalance() > 200) { //prisen på vasken
                                    int amount = 200;
                                    wc.minusBalance(amount); //træker den fra
                                    System.out.print("\n Washing cost is: 200 DKK\n");
                                    System.out.print("\n your balance is " + wc.getBalance() + " now.\n");
                                } else {
                                    System.out.print("\n you do not have sufficient money in your account. \n");
                                }
                            } else {
                                x++;
                            }
                        }
                    } else if (nummer == 3) {
                        System.out.print("\n You are logged out. \n");
                        result = false;
                    }
                }
            } else {
                i++; 
                if (i == cl.size() && cpr != c.getCpr()) {
                    System.out.print("\n User not found.\n");
                }
            }
        }

    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarWash cw = new CarWash();

        boolean run = true;
        while (run) {
            System.out.print("\n-----------Welcome to The CarWash-----------\t");
            System.out.print("\n1. Register 2. Login 3. Exit"
                    + "\n Enter a number:\t");

            int number = sc.nextInt(); //istedet for if else statement
            switch (number) {
                case 1:
                    cw.register();
                    break;
                case 2:
                    System.out.print("\n Enter your CPR Number:\t");
                    int cpr = sc.nextInt();
                    cw.login(cpr);
                    break;
                case 3:
                    run = false;
                    System.out.print("\n ****Byeeeee*** \n");
                    break;
                default:
                    System.out.print("\n Select a valid number please.\n");
                    break;
            }
        }
    }

}
