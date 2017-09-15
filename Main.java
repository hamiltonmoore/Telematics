import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int vin = promptForInt("what is your vin number");

        double odometer = promptForDouble("Enter your odometer reading");

        double consumption = promptForDouble("Enter your fuel consumption");

        double engineSize = promptForDouble("what is your engine size?");

        double lastOilChange = promptForDouble("How many miles did you have on your last oil change?")

        VehicleInfo vehicleInfo = new VehicleInfo(vin, odometer, consumption, engineSize, lastOilChange);
    }

    private static double promptForDouble(String prompt) {
        return Double.parseDouble(scanner.nextLine());
    }

    private static int promptForInt(String prompt) {
        return Integer.parseInt(scanner.nextLine());
    }

}
