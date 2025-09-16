public class Animal {
    public String name;
    public String sound;
    public int legs;
    public Animal(){
        this.legs= 2;
        this.name="you";
        this.sound ="none";

    }
    public Animal(String AnimalName, String AnimalSound, int AnimalLeg){
        this.legs= AnimalLeg;
        this.name=AnimalName;
        this.sound = AnimalSound;

    }
    public void display(){

        System.out.println(name+ " has legs"+ legs + " and sounds "+ sound);
    }
}
