// Name: Eugene
// ID: 1351553

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XProcess {
    public static void main(String[] args) throws IOException {
        // check if we have inputted a file
        if(args.length != 1) {
            System.err.println("No filename!");
            return;
        }
        try{
            BankBST smalltest = new BankBST();
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String s;
            // while we are reading the file
            while(br.ready()) {
                s = br.readLine();
                String[] token;
                token = s.split(" ");
                if(token.length == 3
                        && token[0].matches("\\d+")
                        && token[1].matches("[a-z]")
                        && token[2].matches("(-*)\\d+\\.*\\d*")) {
                    int key = Integer.parseInt(token[0]);
                    String type = token[1];
                    double amount = Double.parseDouble(token[2]);
                    boolean hasChecked = false;
                    Account acc = smalltest.find(key);

                    // check if an account exist
                    // if not we create the account and set
                    // balance
                    if(acc == null) {
                        // if the transaction is a deposit
                        // add the account
                        if(type.matches("d")) {
                            smalltest.addAccount(new Account(key, amount));
                            System.out.print(" DEPOSIT");
                        }
                        // if the transaction is a deposit
                        // add the account
                        else if(type.matches("w")) {
                            smalltest.addAccount(new Account(key, amount * -1));
                            System.out.print(" WITHDRAW");
                        }
                        // if the transaction is a deposit
                        // add the account
                        else if(type.matches("c")) {
                            smalltest.removeAccount(key);
                            System.out.print(" CLOSE");
                        }
                        hasChecked = true;
                        System.out.println(" ");

                    }
                    // check if we have already
                    if(hasChecked == false) {
                        if(type.matches("d")) {
                            acc.setBalance(amount);
                            System.out.print(" DEPOSIT");
                        }
                        else if(type.matches("w")) {
                            acc.setBalance(amount * -1);
                            System.out.print(" WITHDRAW");
                        }
                        else if(type.matches("c")) {
                            smalltest.removeAccount(key);
                            System.out.print(" CLOSE");
                        }
                        System.out.println(" ");
                    }
                }
                else{
                    System.out.println("");
                }
            }
            System.out.println("RESULT");
            smalltest.traverse();
        }catch (Exception ex) {
            System.err.println("Trouble reading file somewhere! Abort!");
            System.err.println("Exception: " + ex);
        }
    }

}
