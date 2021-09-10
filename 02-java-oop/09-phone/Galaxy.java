public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        String ring = getRingTone();
        String name = getClass().getName();
        String vers = getVersion();
        String msg = name + " " + vers + " says " + ring;
        return msg;
    }

    @Override
    public String unlock() {
        String msg = "Unlocking via finger print";
        return msg;
    }

    @Override
    public void displayInfo() {
        String name = getClass().getName();
        String vers = getVersion();
        String carrier = getCarrier();
        System.out.println(name + " " + vers + " from " + carrier);

    }
}
