

import java.util.*;

public class Run {
    public static void run(){
        VendingMachine vm = new VendingMachine();
        Scanner keyboard = new Scanner(System.in);
        boolean go_on = true;
        vm.reset();
        while(go_on != false){
            System.out.println("Balance: $" + vm.getBalance());
            System.out.println("Please Enter Your Selection \n1. Add $0.25 "
                    + "\n2. Add $1.00 \n3. Select Soda \n4. Refund \n5.Quit");
            String choice = keyboard.next();
            if(choice.equals("1"))
                vm.process(choice);
            else if(choice.equals("2"))
                vm.process(choice);
            else if(choice.equals("3"))
                vm.process(choice);
            else if(choice.equals("4"))
                vm.process(choice);
            else if(choice.equals("5"))
                go_on = false;
            else
                System.out.println("Please enter valid input");
        }
        System.out.println("Goodbye!");
        keyboard.close();
    }
}