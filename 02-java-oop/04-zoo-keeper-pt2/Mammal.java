public class Mammal {
    protected int energyLevel;
    private int mamalEnergy = 100;
    public int displayEnergy(){
        System.out.println(energyLevel);
        return energyLevel;
    }

    public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
    }

    public Mammal() {
      this.energyLevel = mamalEnergy;
      }
}
