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
public class Panther extends Animal{
       private int teeth;
       private String color;
    public Panther(String name, int age, double weight, int teeth,String color){
        super(name,age,weight);
        this.teeth = teeth;
        this.color = color;
    }
    
    public void furColor(){
    System.out.println("enter color of fur: ");
    Scanner s = new Scanner(System.in);
    this.color = s.next();
    System.out.println("you have chosen " + this.color + " to be the fur color");
    }
    
}
