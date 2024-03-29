package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    // Reads data from csv file - returns data as a list
    public static List<String[]> read(String file){
        // Used linkedlist because it's easy to add data
        List<String[]> data =  new LinkedList<String[]>();
        String dataRow;

        //
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        }
        catch (FileNotFoundException e){
            // TODO: Auto-generated catch block
            System.out.println("COULD NOT FIND FILE");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("COULD NOT READ FILE");
            e.printStackTrace();
        }

        return data;

    }
}
