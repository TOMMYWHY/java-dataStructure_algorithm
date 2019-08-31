package s01.AtmSyst;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        AtmService service = new AtmService();
        Scanner input = new Scanner(System.in);

        System.out.println("welcome to use ATM system \n please enter username");
        String name = input.nextLine();
        System.out.println("please enter password");
        String password = input.nextLine();
        int loginResult = service.login(name,password);
        if(loginResult == 1){
            System.out.println("login successfully~! welcome : " + name);
            boolean loop = true;
            while(loop){
                System.out.println("");
                System.out.println("1:  query balance");
                System.out.println("2:  fast withdrawal.");
                System.out.println("3:  transfer");
                System.out.println("0:  exit");
                char option = input.nextLine().charAt(0);

                switch (option) {
                    case '1':
                        Float balance = service.queryBalance(name);
                        System.out.println(name + " - balance : "+ balance);
                        break;
                    case '2':
                        service.withdrawal(name,100f);
                        System.out.println("withdrawal : 100; your balance:"+service.queryBalance(name));
                    case '3':

                        break;
                    case '0':
                        loop = false;
                        System.out.println("Exit~! thanks");
                        break;
                    default:
                        break;
                }
            }



        }else {
            System.out.println("username or password error~!");
        }




    }
}
