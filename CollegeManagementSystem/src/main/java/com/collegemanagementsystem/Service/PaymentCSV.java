package com.collegemanagementsystem.Service;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PaymentCSV {

    public void createCsv(Map details, List complete) {

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter("C:\\Users\\RAM BABU SINGH\\Desktop\\transaction.csv");
            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"Transaction History"});
            data.add(new String[]{" "});
            data.add(new String[]{"Start Date:", (String) details.get("Start Date:")});
            data.add(new String[]{"End Date:", (String) details.get("End Date:")});
            data.add(new String[]{" "});
            writer.writeAll(data);
            writer.writeAll(complete);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
