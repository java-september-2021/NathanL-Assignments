public class Mammal {
  protected int energyLevel;
  private int mamalEnergy = 100;

  // constructor
  public Mammal(int instEnergyLevel) {
    this.energyLevel = instEnergyLevel;
  }

  // constructor
  public Mammal() {
    this.energyLevel = mamalEnergy;
  }

  public int displayEnergy() {
    System.out.println(energyLevel);
    return this.energyLevel;
  }
}
