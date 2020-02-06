/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaldriver;

import java.util.Scanner;

/**
 *
 * @author Cameron
 */
public class Tiger extends Animal{
         private int stripes;
         
    public Tiger(String name, int age, double weight, int stripes){
        super(name,age,weight);
        this.stripes = stripes;
    }
    public void getStripeCount(){
        System.out.println("how many stripes does your tiger have? ");
        Scanner s = new Scanner(System.in);
        this.stripes = s.nextInt();
        System.out.println("Your tiger has " + this.stripes + " stripes");
    }
}
