package tests;
import characters.CharacterCreation;

public class TestsCharacterCreation {
    public static void main(String[] args) {

        
        CharacterCreation.Character minotaur = CharacterCreation.Character.create("Minotaur; A fabulous monster of Crete that had the body of a man and the head of a bull.; 0; 5; 0; 5; 4");
        CharacterCreation.Character Cthulhu = CharacterCreation.Character.create("Cthulhu;A monster of vaguely anthropoid outline, but with an octopus-like head whose face was a mass of feelers, a scaly, rubbery-looking body, prodigious claws on hind and fore feet, and long, narrow wings behind.;4;2;2;3;5 "); 
        System.out.println(minotaur);
        System.out.println(Cthulhu);
        
            
 
        System.out.println("---------------------------------------------");
        System.out.println("TESTS CharacterData class");
        System.out.println("---------------------------------------------");
        System.out.println(CharacterCreation.CharacterList);    //Character List before initializing data
        CharacterCreation.Character.iniData("./data/CombatGameCharacters.csv");/*TO DO change route */
        System.out.println(CharacterCreation.CharacterList);    //Character List after initializing data


    }
}