package tests;
import java.util.Scanner;

import characters.CombatCharacter;
import combats.CombatSystem;

public class TestsCombats {

        public static Scanner s = new Scanner(System.in);

        public static void main(String[] args) {

        CombatCharacter TCharacter1 = new CombatCharacter("Dani¨", 7, 14,3,5,23); // = CharacterCreation.Character.create("TesTestCharacter1;TestCharacter1; 5; 5; 5; 5; 25");
        CombatCharacter TCharacter2 = new CombatCharacter("Isi", 4, 6,10,0,20); // = CharacterCreation.Character.create("TesTestCharacter1;TestCharacter1; 5; 5; 5; 5; 25");
        
        System.out.println(TCharacter1);
        System.out.println(TCharacter2);  
        CombatSystem.complexCombatSystem(TCharacter1, TCharacter2);
        //CombatSystem.turnAction(TCharacter1, TCharacter2);
        }


           




    
    
}

