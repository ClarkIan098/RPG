/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;
import java.lang.Math;
/**
 *
 * @author ICL
 */
public class Wizard extends Character implements Weapon, Armor{
    Dice dice = new Dice();    
    private int maxMagic = 25 + intelligence;
    private int currentMagic = maxMagic;
    
    
    public Wizard(String name, int str, int dex, int intel){
        super(name, str, dex, intel);
    
    }
    public int castLightningBolt(int roll) {
        if(currentMagic >= 5){
            currentMagic = currentMagic - 5;
            return roll + super.intelligence;
        }
        else 
            return 0;
    }
     public int castHeal(int roll){
         if(currentMagic >= 8 && currentLife < maxLife){
             currentMagic -= 8;
            return useArmor(roll) + intelligence;
         }else if(currentMagic < 8){
             System.out.println("no Mana");
             return 0;
         }else {
             currentMagic -= 8;
            return 0;}
     }
     
     public int getCurrentMagic(){
         return currentMagic;
     }
     
     public int getMaxmagic(){
         return maxMagic;
     }

    @Override
    public int useWeapon(int roll) {
        return roll + strength;
    }
    

    @Override
    public int useArmor(int roll) {
        
       return roll + strength;
    }

    @Override
    public int attack(int attack) {
       return useWeapon(attack);
    }
     
     
    }
    

