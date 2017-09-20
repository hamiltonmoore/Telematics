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

    void report(VehicleInfo vehicleInfo) throws IOException {

        try {
            File outputFile = new File(Integer.toString(vehicleInfo.getVin()) + ".json");  //creates file, with file name of vin-puts that in outputFile
            FileWriter fileWriter = new FileWriter(outputFile);  //passes new File into fileWriter, to make a FileWriter

            fileWriter.write(vehicleInfo.toJson());  //fileWriter comes from above with new FileWriter and writes to file

            fileWriter.close(); //writing stopped

            /*
    convert json to an object
    store object in a list
    return list to be used for insertion into html
     */

            List<vehicleList> vehicleList = new ArrayList<>();  //establishes an array list called vehicleList
            File file = new File(".");   //this is instantiating a new File object, from file imported
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".json")) {
                    Scanner findFile = new Scanner(f);  //this finds file via scanner, f has been passed in
                    String json = findFile.nextLine();
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vehicleInfo = mapper.readValue(json, VehicleInfo.class);
                }
            }

            //write out dashboard
            vehicleInfo   //I believe this somehow needs to be passed in 
                    String html = "some random string #replace-me and don't replace me here.";
            System.out.println(html.replace("#reaplce-me", "SOMETHING-NEW"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }







