import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TelematicsServices {

    ArrayList<VehicleInfo> vehicleList = new ArrayList<>();

    void report(VehicleInfo vehicleInfo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(vehicleInfo);
            File file = new File(Integer.toString(vehicleInfo.getVin()) + ".json");
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
            /*
    convert json to an object
    store object in a list
    return list to be used for insertion into html
     */

        File file = new File(".");   //this is instantiating a new File object, from file imported
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                Scanner scanner = new Scanner(f);  //this finds file via scanner, f has been passed in
                String json = scanner.next();
                VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);

                vehicleList.add(vi);
            }
        }
        String html = htmlMerge();

        //write out dashboard

        File file1 = new File("Dashboard.html");
        try (FileWriter fw = new FileWriter(file1)) {
            fw.write(html);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //generate the entire HTML
    private String htmlMerge() {
        String topHTML = "<html>\n" +
                "<title>Vehicle Telematics Dashboard</title>\n" +
                "<body>\n" +
                "<h1 align=\"center\">Averages for # vehicles</h1>\n" +
                "<table align=\"center\">\n" +
                "    <tr>\n" +
                "        <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<h1 align=\"center\">History</h1>\n" +
                "<table align=\"center\" border=\"1\">";
        String midHTML = "";
        for (VehicleInfo v : vehicleList) {

            midHTML += " <tr>\n" +
                    "            <td align=\"center\">#VIN</td><td align=\"center\">#Odom</td><td align=\"center\">#Consume</td><td align=\"center\">LastOilChange</td align=\"center\"><td align=\"center\">#EngineSize</td>\n" +
                    "        </tr>";
            midHTML = midHTML.replaceFirst("#VIN", String.valueOf(v.getVin()))
                    .replaceFirst("#Odom", String.valueOf(v.getOdometer()))
                    .replaceFirst("#consume", String.valueOf(v.getConsumption()))
                    .replaceFirst("#LastOilChange", String.valueOf(v.getLastOilChange()))
                    .replaceFirst("#EngineSize", String.valueOf(v.getEngineSize()));
        }
        String bottomHTML = "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        return topHTML + midHTML + bottomHTML;
        //(3)


    }

}









