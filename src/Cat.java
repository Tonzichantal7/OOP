public class Cat extends Animal{
    public Cat(String name, String sound, int legs) {
        super(name, sound,legs);
    }
    @Override
    public void display(){
        System.out.println(name+" and sounds "+ sound);
    }

}

