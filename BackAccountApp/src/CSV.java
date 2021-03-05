/**
 * Author: Adam C Wojdyla
 * Description: Bank Account Application
 * Personal Project
 */

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    /**
     * @param filename - CSV file name
     * @return Linked list of String arrays. (every row in the .csv file)
     * @throws IOException
     */
    public static List<String[]> read(String filename) throws IOException {
        List<String[]> data = new LinkedList<>();

        String dataRow;
        BufferedReader br = new BufferedReader(new FileReader(filename));

        while ((dataRow = br.readLine()) != null) {
            String[] dataPerRow = dataRow.split(",");
            data.add(dataPerRow);
        }
        return data;
    }
}
