/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdownrevised;

import java.util.Scanner;

/**
 *
 * @author Cameron
 */
public class CountdownRevised {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a number i should count to before"
                + " blastoff!");
        int blastoff = s.nextInt();
        countdown(blastoff);
    }

    public static void countdown(int blastoff) {
        int count = 1;
        while (count != blastoff) {
            System.out.println(count);
            count++;
        }
        System.out.println("Blastoff!");

    }

}
