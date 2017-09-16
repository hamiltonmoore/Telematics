import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelematicsServices {

    void report(VehicleInfo vehicleInfo) {

//        public static void main(String[] args) {
            try {
                File file = new File(Integer.toString(vehicleInfo.getVin()));   //also tried (vehicleInfo.vin)
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write();
                fileWriter.write();
                fileWriter.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

