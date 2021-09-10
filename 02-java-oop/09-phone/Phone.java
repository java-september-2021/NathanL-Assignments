public abstract class Phone {
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;

    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }

    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();
    // getters and setters removed for brevity. Please implement them yourself

    public String getVersion() {
        String vers = this.versionNumber;
        return vers;
    }

    public int getBatteryPercentage() {
        int val = this.batteryPercentage;
        return val;
    }

    public String getCarrier() {
        String carrier = this.carrier;
        return carrier;
    }

    public String getRingTone() {
        String tone = this.ringTone;
        return tone;
    }

}
