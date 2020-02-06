/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaldriver;

/**
 *
 * @author Cameron
 */
public class AnimalDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Panther p = new Panther("",5,0,0,"white");
        p.furColor();
        Tiger t = new Tiger("",0,0,0);
        t.getStripeCount();
    }
    
}
