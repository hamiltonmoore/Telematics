import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter VIN Number");
        int vin = scanner.nextInt();

        System.out.println("Enter you odometer reading");
        double odometer = scanner.nextDouble();

        System.out.println("Enter your fuel consumption");
        double consumption = scanner.nextDouble();

        System.out.println("What is your engine size?");
        double engineSize = scanner.nextDouble();

        System.out.println("How many miles did you have on your last oil change?");
        double lastOilChange = scanner.nextDouble();

        VehicleInfo vehicleInfo = new VehicleInfo(vin, odometer, consumption, engineSize, lastOilChange);


        TelematicsServices service = new TelematicsServices();

        service.report(vehicleInfo);

    }

}
