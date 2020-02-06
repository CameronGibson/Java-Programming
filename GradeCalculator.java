/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecalculator;

import java.util.Scanner;

/**
 *
 * @author Cameron Gibson
 * June 23rd 2019
 * Calculates the letter grade based off of user input.
 * I pledge that this work is my own.
 */
public class GradeCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please enter three numeric grades on one line.");
        Scanner s = new Scanner(System.in);
        String numericGrades = s.nextLine();
        String sOne = numericGrades.substring(0, 2);
        String sTwo = numericGrades.substring(3, 5);
        String sThree = numericGrades.substring(6, 8);
        double numOne = Double.parseDouble(sOne);
        double numTwo = Double.parseDouble(sTwo);
        double numThree = Double.parseDouble(sThree);
        double averageGrade = (numOne + numTwo + numThree) / 3;
        
        if (averageGrade >= 90.0){ //wtf
            System.out.printf("Your grade of %.1f is an A.",averageGrade);
        }else if(averageGrade < 90.0 && averageGrade >= 80.0){
            System.out.printf("Your grade of %.1f is an B.",averageGrade);
        }else if(averageGrade < 80.0 && averageGrade >= 70.0){
            System.out.printf("Your grade of %.1f is an C.",averageGrade);
        }else if(averageGrade < 70.0 && averageGrade >= 60.0){
            System.out.printf("Your grade of %.1f is an D.",averageGrade);
        }else{
            System.out.printf("Your grade of %.1f is an F.",averageGrade);
        }
        
    }
    
}
