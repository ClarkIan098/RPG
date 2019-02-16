package rpg;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ICL
 */
public class Dice {
    private Random r = new Random();
    
    public Dice(){
       
    }
     public int Roll(){
       return r.nextInt(6)+1;
    }
}
