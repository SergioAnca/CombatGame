package characters;
import java.util.Random;

import auxiliar.MultipleInt.IntQuartet;
import auxiliar.MultipleInt.IntTrio;

public class CombatCharacter {
    private String name;
    private Integer attack;
    private Integer defense;
    private Integer iq;
    private Integer resistance; 
    private Integer health_points;
    private Boolean state;      //Alive or not
    private Integer iqTurnsToUse;//Number of turns to use an iq attack
    private Integer iqTurnsLeft; //Turns left to be able to use iq  atack

  @Override
    public String toString() {
        return "["+"name=" + name + ", attack=" + attack + ", health_points=" + health_points + "state = "+state+"]";
    }
public CombatCharacter(String name, Integer attack, Integer defense, Integer iq, Integer resistance, Integer health_points) {
        this.name = name;
        this.attack = attack;
        this.defense = 10 + defense;
        this.iq = iq;
        this.resistance = resistance;
        this.health_points = health_points;
        this.state = true; 
        
        this.iqTurnsToUse = iq<=5?3:iq<8?2:iq>=8?1:0;   
        this.iqTurnsLeft= 0;

    }

    //Getters & setters
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAttack() {
        return attack;
    }
    public void setAttack(Integer attack) {
        this.attack = attack;
    }
    public Integer getDefense() {
        return defense;
    }
    public void setDefense(Integer defense) {
        this.defense = defense;
    }
    public Integer getIq() {
        return iq;
    }
    public void setIq(Integer iq) {
        this.iq = iq;
    }
    public Integer getResistance() {
        return resistance;
    }
    public void setResistance(Integer resistance) {
        this.resistance = resistance;
    }
    public Integer getHealth_points() {
        return health_points;
    }
    public void setHealth_points(Integer health_points) {
        this.health_points = health_points;
    }
    public Boolean getState() {
        return state;
    }
    public void setState(Boolean state) {
        this.state = state;
    }
    public Integer getIqTurnsToUse() {
        return iqTurnsToUse;
    }
    public Integer getIqTurnsLeft() {
        return iqTurnsLeft;
    }
    public void setIqTurnsLeft(Integer iqTurnsLeft) {
        this.iqTurnsLeft = iqTurnsLeft;
    }
    /**********************/
    /***COMBAT FUNCTIONS***/
    /**********************/

    //Simple
    public Integer damage(){
        return this.attack;
    }
    public void recieveds(Integer recieved_damage){
        this.health_points = this.health_points -  recieved_damage;
        if(this.health_points <= 0){
            System.out.println("La vida ha llegado a 0");
            this.setState(false);
        }
    }





    //Complex combat 
    public IntTrio basicAttack(){
        Integer dice = dice(20);
        Integer basicAttack = dice + this.attack;
        return IntTrio.of(dice, this.attack, basicAttack); 
    }
    public Integer basicDefense(){
        return this.defense;
    }
    public static Boolean takesDamage(Integer attack, Integer defense){
        return attack>=defense?true:false;
    }
    public static Integer basicDamage(Integer d , Integer p){
        return dice(d)+p;
    }        
    public IntQuartet basicResistance(){
        Integer dice = dice(12);
        Integer basicResistance = dice + this.resistance;
        Integer damageReduced = basicResistance == 10?1:basicResistance==11?2:basicResistance>=12?3:0;
        return IntQuartet.of(dice, this.resistance, basicResistance , damageReduced); 
    }
    public IntTrio basicIQ(){
        Integer dice = dice(20);
        Integer basicIq = dice +this.iq;
        return IntTrio.of(dice, this.iq, basicIq);
    }
    public void recieved(Integer recieved_damage){
        this.health_points = this.health_points -  recieved_damage;
        if(this.health_points <= 0){
            System.out.println("La vida ha llegado a 0");
            this.state = false;
        }
    }
    
        /**************/
        /***AUXILIAR***/
        /**************/
   
    public static Integer dice(Integer d){
        Random rnd = new Random();
        return rnd.nextInt(d)+1;
    }
    
}