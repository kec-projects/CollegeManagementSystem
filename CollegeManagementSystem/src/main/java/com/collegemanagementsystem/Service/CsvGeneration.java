package com.collegemanagementsystem.Service;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CsvGeneration {

    public void createCsv(Map details,List complete) {

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter("C:\\Users\\MonAmour\\Desktop\\attendance.csv");
            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"Subject Name", (String) details.get("Subject Name")});
            data.add(new String[]{"Teacher", (String) details.get("Teacher Name")});
            data.add(new String[]{"Semester", (String) details.get("Semester")});
            data.add(new String[]{"Batch", (String) details.get("Batch")});
            data.add(new String[]{"Department", (String) details.get("Branch")});
            data.add(new String[]{"Total class", (String) details.get("Total Class")});
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
