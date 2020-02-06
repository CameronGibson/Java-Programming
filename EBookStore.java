/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookstore;

import java.util.Scanner;

/**
 *
 * @author Cameron Gibson Description: Calculates the total charges of
 * downloading Ebooks. THIS IS THE REVISED VERSION WITH METHODS. Due: 7/7/2019 I
 * pledge that this work is my own.
 */
public class EBookStore {

    //Constants that were needed for the project.
    public static final double TAX_RATE = .055;
    public static final double GOLD_MEMBER = .20;
    public static final double SILVER_MEMBER = .15;
    public static final double BRONZE_MEMBER = .10;
    public static final double NON_MEMBER = 0;
    public static final double SERVICE_CHARGE_1 = .07;
    public static final double SERVICE_CHARGE_2 = .05;
    public static final double SERVICE_CHARGE_3 = .03;
    public static final double SERVICE_CHARGE_4 = 0;
    //American National Standard Colors.
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    //All other veriables.
    public static String firstName, lastName;
    public static int booksPurchased = 0, membershipStatus = 0;
    public static double costPerBook = 0, baseCharge = 0, serviceCharge = 0,
            productCharge = 0, discount = 0, subTotal = 0, tax = 0, afterTax = 0;
    public static final int MAX = 2147483647;
    public static final int MIN = 1;
    public static Scanner s;
    public static boolean okay;
    public static double cpb = 0; //cost per book
    public static double cpbTotal = 0; //cost per book total
    public static int bookNum = 1;
    public static String yesOrNo;
    public static int users = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating a scanner object.
        s = new Scanner(System.in);
        System.out.print("Please provide your first name" + inputPrompt());
        //asks the user for their first name.
        firstName = s.nextLine();
        System.out.print("Please provide your last name as well"
                + inputPrompt());
        //asks the user for their last name.
        lastName = s.nextLine();
        System.out.print("Okay " + firstName + ", how many E-Books did "
                + "you download" + inputPrompt());
        //prompts the user to enter the amount of books purchased.

        booksPurchased = scanInt(booksPurchased, MAX, MIN);
        System.out.print("Now, please enter the cost per E-Book"
                + inputPrompt() + "\n");
        for (int i = 0; i < booksPurchased; i++) {
            System.out.printf("Book#%d:", bookNum);
            inputPrompt();
            costPerBook = scanDouble(costPerBook, MAX, MIN);
            cpbTotal = cpbTotal + costPerBook;
            bookNum++;
        }
        System.out.println("The combined total of all of "
                + "your books purchased is: " + cpbTotal);
        System.out.println("Now that we have that taken care of, lets take a"
                + " look at any discounts you may qualify for.");
        System.out.println("Please enter your membership status");
        System.out.println("(3) represents gold membership");
        System.out.println("(2) represents silver membership");
        System.out.println("(1) represents bronze membership");
        System.out.print("(0) represents no membership\n" + inputPrompt());
        //asks the user to enter the appropriate number/membership status 
        baseCharge = calcBaseCharge(booksPurchased, cpbTotal);
        serviceCharge = calcServiceCharge(booksPurchased,baseCharge);
        productCharge = baseCharge + serviceCharge;
        scanMS(membershipStatus, MAX, MIN);
        discount = calcDiscount(membershipStatus,productCharge);
        //this discount is then factored in.
        subTotal = productCharge - discount;
        //tax is calculated and added to the grand total.
        tax = subTotal * TAX_RATE;
        afterTax = subTotal + tax;

        //This is what would be a reciept for the individual making the purchase
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println("Number of E-Books downloaded: " + booksPurchased);
        System.out.printf("Base Charge:" + ANSI_GREEN
                + "$%.2f\n" + ANSI_RESET, baseCharge);
        System.out.printf("Service Charge:" + ANSI_RED
                + "+$%.2f\n" + ANSI_RESET, serviceCharge);
        System.out.printf("Product Charge:" + ANSI_GREEN
                + "$%.2f\n" + ANSI_RESET, productCharge);
        System.out.printf("Discount:" + ANSI_GREEN
                + "-$%.2f\n" + ANSI_RESET, discount);
        System.out.printf("Subtotal: " + ANSI_GREEN
                + "$%.2f\n" + ANSI_RESET, subTotal);
        System.out.printf("Tax:" + ANSI_RED + "+$%.2f\n" + ANSI_RESET, tax);
        System.out.printf("Total Charge:" + ANSI_GREEN
                + "$%.2f\n" + ANSI_RESET, afterTax);
        System.out.println("Is there another customer? (y/n)");
        yesOrNo = s.next();
        if (yesOrNo.contains("y")) {
            System.out.println("\n\n\n");
            users++;
            main(args);
        } else {
            System.out.println("Thank you! Have a good day!");
            System.exit(0);
        }
    }

    public static String inputPrompt() {
        StringBuilder str = new StringBuilder();
        str.append(" --> ");
        return str.toString();
    }

    /**
     *
     * @param booksPurchased is the amount of books the user purchased.
     * @param cpbTotal is the total of books cost.
     * @return this method returns the base charge by multiplying the amount of
     * books purchased and the cost per book.
     */
    public static double calcBaseCharge(int booksPurchased, double cpbTotal) {
        baseCharge = cpbTotal;
        return baseCharge;
    }

    //passing cbtTotal to have calculations done is not happening.
    /**
     *
     * @param booksPurchased the amount of books purchased by the user.
     * @param baseCharge
     * @return this method returns the service charge which is determined by the
     * amount of E-books the user has entered.
     */
    public static double calcServiceCharge(int booksPurchased,double baseCharge) {
        if (booksPurchased >= 8) {
            serviceCharge = baseCharge * SERVICE_CHARGE_1;
        } else if (booksPurchased < 8 && booksPurchased >= 15) {
            serviceCharge = baseCharge * SERVICE_CHARGE_2;
        } else if (booksPurchased < 15 && booksPurchased > 20) {
            serviceCharge = baseCharge * SERVICE_CHARGE_3;
        } else {
            serviceCharge = SERVICE_CHARGE_4;
        }
        return serviceCharge;
    }

    /**
     *
     * @param membershipStatus the level of membership status.
     * @param productCharge the product charge is the amount of cost after
     * service charge has been calculated.
     * @return this method returns the discount based upon the membership status
     * of the user.
     */
    public static double calcDiscount(int membershipStatus,double productCharge) {
        if (membershipStatus == 3) {
            discount = productCharge * GOLD_MEMBER;
        } else if (membershipStatus == 2) {
            discount = productCharge * SILVER_MEMBER;
        } else if (membershipStatus == 1) {
            discount = productCharge * BRONZE_MEMBER;
        } else {
            discount = NON_MEMBER;
        }
        return discount;
    }

    public static int scanInt(int number, int MAX, int MIN) {
        number = s.nextInt();
        if (number > MAX || number < MIN) {
            System.out.println("incorrect input. try again.");
            number = s.nextInt();
        } else {
            System.out.println("Great!");
        }
        return number;
    }

    public static double scanDouble(double number, int MAX, int MIN) {
        number = s.nextDouble();
        if (number > MAX || number < MIN) {
            System.out.println("incorrect input. try again.");
            number = s.nextDouble();
        } else {
            System.out.println("Great!");
        }
        return number;
    }

    public static int scanMS(int number, int MAX, int MIN) {
        number = s.nextInt();
        if (number > 3 || number < 0) {
            System.out.println("incorrect input. try again.");
            number = s.nextInt();
        }
        return number;
    }

}
