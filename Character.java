package rpg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ICL
 */
public abstract class Character {
     Dice dice = new Dice ();
    protected String name;
    protected int strength, dexterity, intelligence, maxLife, currentLife;

    
    
    public Character (String name, int strength, int dexterity, int intelligence){
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence; 
        this.maxLife = 50 + strength;
        this.currentLife = maxLife;
        
        
    }
    public abstract int attack(int attack);
   
    public void wound (int damage){
        this.currentLife = currentLife - damage;
        
    }
    public int heal (int heal){  
        return currentLife = currentLife + heal;     
    }
    public String getName(){
        return name;
    }
    public int getStrength(){
        return strength;
    }
    public int getDexterity(){
        return dexterity;
       
    }
    public int getIntelligence(){
        return intelligence;
        
    }
    public int getCurrentLife(){
        if(currentLife > maxLife){
            return maxLife;}
        else{
        return currentLife;}
    }
    public int getMaxLife(){
        return maxLife;
    }
    
}
