public class Gorilla extends Mammal{
    public Gorilla(int energyLevel) {
		super(energyLevel);
	}

    public void throwSomething(){
        System.out.println("The gorilla has thrown something");
        this.energyLevel -=5;
    }

    public void eatBananas(){
        System.out.println("Banana yummy!");
        this.energyLevel +=10;
        if(this.energyLevel > 100){
            this.energyLevel =100;
        }
    }

    public void climb(){
        System.out.println("The gorilla is climbing something");
        this.energyLevel -=10;
    }
}