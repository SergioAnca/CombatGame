package combats;
import java.util.Scanner;


import auxiliar.MultipleInt.IntQuartet;
import auxiliar.MultipleInt.IntTrio;
import characters.CombatCharacter;

public class CombatSystem {
    
            /*************************/
            /***Simple combat sytem***/
            /*************************/
    public static void complexCombatSystem(CombatCharacter TC1, CombatCharacter TC2){
        Integer turn = 1; 
        System.out.println("-----------------------------------------\n-------TESTS complex combat system-------\n-----------------------------------------");
        System.out.println("\nCharacter "+TC1.getName()+" is going to start\n");
        System.out.println("--------------------------------\n----------COMBAT MENU-----------\n--------------------------------\n");
        do{                                                             //Combat loop
            System.out.println("-------------------------------------------------------------------------");        
            System.out.println("Turn" +turn);turn++;                    //Turn starts    
            turnAction(TC1, TC2);                                       //The first character choose an action(attack, iq, nothing)
            System.out.println("\n--------------------------------------\n");
            turnAction(TC2, TC1);                                       //The second character choose an action
        }while( (TC1.getState() && TC2.getState()) && turn<30);         //The combat ends if a character is with 0 hp or if it lasts 30 turns
        System.out.println("Combat ends");
    }

    public static Scanner s = new Scanner(System.in);

    private static void turnAction(CombatCharacter attacker, CombatCharacter defender){ //This function help to choose the character action

        System.out.println("Character "+attacker.getName()+" choose an action (Bassic Attack 1 - Iq Attack 2 - Nothing 3)"); 
        Integer option = Integer.parseInt(s.nextLine());//System.out.println(option);
        switch(option){
            case 1:                                    //The character choosed a basic attack
                basic(attacker, defender, 0);             //A basic attack is executed
                break;                                 //Attack ends
            case 2: //iq attack
                iqAttack(attacker, defender, false);
                break;
            case 3:  //nothing
                break;/*TO DO  SI no hace nada el contador de iq del rival baja a 0*/ 


        }
        System.out.println("\n"+attacker.getName()+ " hp is: "+attacker.getHealth_points());   //both hp are shown
        System.out.println( defender.getName()+ " hp is: "+defender.getHealth_points());
        System.out.println("Now is your enemy turn.");
        
    }

    private static void basic(CombatCharacter attacker, CombatCharacter defender, Integer option){      //Basic atack
        IntTrio attack = attacker.basicAttack();        //Attack dice roll attack calculated
            Integer defense = defender.basicDefense();      //Defender defense 
            System.out.println(option==1?"":String.format("%s attack dice roll: %d + %d = %d ",attacker.getName(), attack.f(), attack.s(), attack.t()));//Only shows attack if the defense isn´t affected by iq
            System.out.println(option==1?"":String.format("%s defense is: %d", defender.getName(), defense) );//Only shows defense if it isn´t affected by iq
            if(CombatCharacter.takesDamage(attack.t(),defense) || option==1){    //If attack>defense or iq affects defense it hits
                Integer damage = CombatCharacter.basicDamage(4, 0); //Damage calculated
                IntQuartet resistance =  option==2? IntQuartet.of(0,0,0,0):defender.basicResistance();     //Resistance dice roll calculated, if its affected by iq, its value is 0                
                Integer realDamage = damage-resistance.fo();            //Damage - resisted
                realDamage = realDamage<=0?1:realDamage;                //If the new damage is 0 or less it deals 1 damage
                System.out.println(String.format("The attack has hit dealing %s damage", damage));
                String resistanceString = realDamage!=damage?String.format("so the damage is reduced by %d. The new damage is: %d (1 is min dama1ge)",resistance.fo(), realDamage):" so it doesn`t affects";//If damage is reduced, it syso the new damage
                System.out.println(option==2?"":String.format("The %s resistance dice roll is: %d + %d = %d %s ",defender.getName(), resistance.f(),resistance.s(),resistance.t(),  resistanceString));//If iq affects resistance, it doesn´t shows the resistance dice roll
                defender.recieved(damage);                          //Defender takes damage
            }else{                                                  //Else it fails
                System.out.println("The attack has failed");
            }
    }

    public static Scanner i = new Scanner(System.in);
   
    private static void iqAttack(CombatCharacter attacker, CombatCharacter defender, Boolean nothing){ //iqAttack 
        //Caculates if you can use an iq attack

        if(attacker.getIqTurnsLeft()!=0){    //If you cant use your iq yet
            System.out.println(String.format("You can only use an iq attack every %d turns. You have to wait %d turns for using it again. So your attack is basic.", +attacker.getIqTurnsToUse()+1,attacker.getIqTurnsLeft() ) );
            attacker.setIqTurnsLeft(attacker.getIqTurnsLeft()-1);   //One less turn to use iq
            basic(attacker, defender, 0);
        }else{     
            attacker.setIqTurnsLeft(attacker.getIqTurnsToUse());//If your attack is with iq, you have to waits "turnToUse" to use it again
            IntTrio attackerIq = attacker.basicIQ();    //calculate both qi dice roll
            IntTrio defenderIq = defender.basicIQ();
            System.out.println(String.format("%s iq dice roll is: %d + %d = %d ", attacker.getName(),attackerIq.f(), attackerIq.s(), attackerIq.t()));
            System.out.println(String.format("%s iq dice roll is: %d + %d = %d ", defender.getName(),defenderIq.f(), defenderIq.s(), defenderIq.t()));

            if(attackerIq.t()>defenderIq.t()){
                System.out.println("Your iq dice roll is higher, choose wich stat you want to overpass (defense 1 - resitance 2)");
                Integer option = Integer.parseInt(s.nextLine());//System.out.println(option);
                switch(option){
                    case 1: System.out.println(String.format("This turn %s defense is overpassed",defender.getName()));//User choosed to overpass defens
                        basic(attacker, defender, option);//Ignore defense                           
                        break;
                    case 2: System.out.println(String.format("This turn %s resistance is overpassed",defender.getName()));//User choosed to overpass resistance
                        basic(attacker, defender, option);//Ignore resitance     
                        break;
                }


            }else{
                System.out.println("Your iq dice roll is lower. You attack is basic\n");
                basic(attacker, defender, 0);
            }   
        }
    }

        /*Menos de 6= 1si y 3 no
6,7,8= 1si 2no
9 o más= 1si 1no/





            /*************************/
            /***Simple combat sytem***/
            /*************************/  
        /*
            private static void simpleCombatSystem(CombatCharacter TCharacter1, CombatCharacter TCharacter2){
                System.out.println("-------------------------------\n--------TESTS simple combat system---------\n------------------------------");
                System.out.println("--------------------------------\n--------COMBAT MENU--------\n--------------------------------");
                Integer turn = 0;
                do{
                    System.out.println("Turn: "+turn );turn++;            
                    System.out.println("Which character would attack? (1-2)"+"(TC1-TC2)");
                    Integer recieved_damage = 0; 
                    Integer option = 0; 
                    option = Integer.parseInt(s.nextLine());//System.out.println(option);                
                    switch(option){
                        case 1: 
                            recieved_damage = TCharacter1.damage(); 
                            System.out.println("TC1 attacked TC2 dealing "+recieved_damage);
                            TCharacter2.recieveds(recieved_damage);
                            break;
                        case 2: 
                            recieved_damage = TCharacter2.damage(); 
                            System.out.println("TC2 attacked TC1 dealing "+recieved_damage);
                            TCharacter1.recieved(recieved_damage);
                            break;
                    }
                    System.out.println("TC1 hp is: "+TCharacter1.getHealth_points());
                    System.out.println("TC2 hp is: "+TCharacter2.getHealth_points());
                }while(TCharacter1.getState() && TCharacter2.getState()|| turn>=20);
                System.out.println("Combat ends");
            }*/
}
