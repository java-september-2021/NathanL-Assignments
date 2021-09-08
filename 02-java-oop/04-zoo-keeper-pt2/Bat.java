public class Bat extends Mammal{
    private int batEnergy = 300;
    public Bat(int energyLevel){
	this.energyLevel = batEnergy;
	}

    public Bat(){
        this.energyLevel = batEnergy;
        }

    public void fly(){
        System.out.println("flap flpa flap");
        this.energyLevel -=50;
    }

    public void eatHumans(){
        this.energyLevel +=25;
        if(this.energyLevel > 300){
            this.energyLevel =300;
        }
    }

    public void attackTown(){
        System.out.println("burning town sounds");
        this.energyLevel -=100;
    }
}