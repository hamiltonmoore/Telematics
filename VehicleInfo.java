public class VehicleInfo {

    private int vin;
    private double odometer;
    private double consumption;
    private double engineSize;
    private double lastOilChange;

    //Vin
    public int getVin() {
        return this.vin;
    }

    public void setVin(int vin){
        this.vin = vin;
    }

    //odometer
    public double getOdometer() {
        return this.odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    //gas consumption
    public double getConsumption() {
        return this.consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    //engine size
    public double getEngineSize() {
        return this.engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getLastOilChange() {
        return this.lastOilChange;
    }

    public void setLastOilChange(double lastOilChange) {
        this.lastOilChange = lastOilChange;
    }
}

