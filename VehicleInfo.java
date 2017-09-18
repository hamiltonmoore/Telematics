import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleInfo {

    private int vin;
    private double odometer;
    private double consumption;
    private double engineSize;
    private double lastOilChange;

    public VehicleInfo(int vin, double odometer, double consumption, double engineSize, double lastOilChange) {
        this.vin = vin;
        this.odometer = odometer;
        this.consumption = consumption;
        this.engineSize = engineSize;
        this.lastOilChange = lastOilChange;
    }

    public VehicleInfo() {
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getLastOilChange() {
        return lastOilChange;
    }

    public void setLastOilChange(double lastOilChange) {
        this.lastOilChange = lastOilChange;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}