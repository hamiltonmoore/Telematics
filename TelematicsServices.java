import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

package com.mkyong.json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TelematicsServices {

    void report(VehicleInfo vehicleInfo) {

        // Write the VehicleInfo to a file as json
        writeJsonFile();

        // Find all the files that end with ".json" and convert back to VehicleInfo object.
        collectAllJson();

        // Update a dashboard.html
        writeOutDashboard();

    }

    private void writeJsonFile(VehicleInfo vehicleInfo) {
        try {
            File outputFile = new File(Integer.toString(vehicleInfo.getVin()) + ".json");   //also tried (vehicleInfo.vin)
            FileWriter fileWriter = new FileWriter(outputFile);

            fileWriter.write(vehicleInfo.toJson());

            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
    convert json to an object
    store object in a list
    return list to be used for insertion into html
     */
    private ArrayList<VehicleInfo> collectAllJson() throws IOException {
        String[] list;
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                Scanner findFile = new Scanner(f);
                String json = findFile.nextLine();
                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo vehicleInfo = mapper.readValue(json, VehicleInfo.class);
            }
            }
        return list = { VehicleInfo };
    }
    }
    
/*

*/

    public String writeOutDashboard() {





