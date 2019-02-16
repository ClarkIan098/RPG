/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;
import java.util.Scanner;
/**
 *
 * @author ICL
 */
public class TestCharacterDuel {
     static Scanner scan = new Scanner(System.in); 
            Dice dice = new Dice();
            
            Archer player1 =  new Archer("Ashe", dice.Roll(), dice.Roll(), dice.Roll());
            Wizard player2 =  new Wizard("Kass", dice.Roll(), dice.Roll(), dice.Roll());
            
        
            int p2Roll, p1Roll;
            int round;
        
       
        
        public void testBattle(){
           
            for(round = 1; player1.getCurrentLife() > 0 && player2.getCurrentLife() > 0 ; round++){
           
            p1Roll = dice.Roll();
            p2Roll = dice.Roll();

            System.out.println("\t*****Round " + round + " *****");
                System.out.println("");
            System.out.println(player1.getName() + ": " + player1.getCurrentLife() + " MP :" + player1.getCurrentMagic());
            System.out.println(player2.getName() + ": " + player2.getCurrentLife() + " MP :" + player2.getCurrentMagic());
                System.out.println("");
            System.out.println("player1 Move : ");
            System.out.println("(a)NormalAttack\t(h)Heal\t(f)FrostArrows");
            String choicePlayer1 = scan.next();
                System.out.println("");
            switch(choicePlayer1){
                case "a" :
                    System.out.println(player1.getName() + " deals " + player1.attack(p1Roll) + " Damage");
                     player2.wound(player1.attack(p1Roll));
                    break;
                case "h" :
                    int h = player1.castHeal(p1Roll);
                    System.out.println(player1.getName() + " heals for " + h );
                    player1.heal(h);
                    break;
                case "f" :
                    int f = player1.castFrostArrows(p1Roll);
                    System.out.println(player1.getName() + " deals " + f + " Damage");
                     player2.wound(f);
                     break;
                default :
                    System.out.println("Skillset not Found!-----lose turn");
                    break;
            }
                System.out.println("");
            System.out.println("player2 Move : ");
                if(player2.getCurrentMagic() >= 5 && player2.getCurrentLife() > player1.getCurrentLife()){
                    int l = player2.castLightningBolt(p2Roll);
                    System.out.println(player2.getName()  + " deals " + l + " Damage");
                    player1.wound(l);
                    
                }
                else if(player2.getCurrentMagic() >= 8 && player2.getCurrentLife() < 10){
                     int h = player2.castHeal(p2Roll);
                     System.out.println(player1.getName() + " heals for " + h );
                     player2.heal(h);
                     
                            }
                else{
                    int a = player2.attack(p2Roll);
                    System.out.println(player2.getName() + " deals " + a);
                    player1.wound(a);
                }
            
            
//            System.out.println("(a)NormalAttack\t(h)Heal\t(l)LightningBolt");
//            String choicePlayer2 = scan.next();
//            System.out.println("");
//            switch(choicePlayer2){
//                case "a" :
//                    System.out.println(player2.getName() + " deals " + player2.attack(p2Roll) + " Damage");
//                     player1.wound(player2.attack(p2Roll));
//                    break;
//                case "h" :
//                    System.out.println(player2.getName() + " heals for " + player2.castHeal(p2Roll));
//                    player2.heal(player2.castHeal(p2Roll));
//                    break;
//                case "l" :
//                    System.out.println(player2.getName() + " deals " + player2.castLightningBolt(p2Roll) + " Damage");
//                     player1.wound(player2.castLightningBolt(p2Roll));
//                     break;
//                default :
//                    System.out.println("Skillset not Found!-----lose turn");
//                    break;
//            }
           
                System.out.println("");
            
            }
            if(player1.getCurrentLife() > player2.getCurrentLife() && player2.getCurrentLife() <= 0){
                System.out.println("Winner is : " + player1.getName() + " HP " + player1.getCurrentLife());
            }
            else if(player2.getCurrentLife() > player1.getCurrentLife() && player1.getCurrentLife() <= 0){
                System.out.println("Winner is : " + player2.getName() + " HP " + player2.getCurrentLife());
            }else if (player1.getCurrentLife() <= 0 && player2.getCurrentLife() <= 0 && player1.getCurrentLife() == player2.getCurrentLife()){
                 System.out.println("Draw : " + player1.getName() + " : " + player1.getCurrentLife() + 
                                                "\t" + player2.getName() + " : " + player2.getCurrentLife());
            }
               
        
        } 
}
