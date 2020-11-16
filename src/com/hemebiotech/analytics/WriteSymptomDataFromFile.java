package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteSymptomDataFromFile implements ISymptomWriter {

    private static String filepath;

    /**
     * 
     * @param filepath a full or partial path to the file we have to write
     */
    public WriteSymptomDataFromFile(String filepath) {
        WriteSymptomDataFromFile.filepath = filepath;
    }

    @Override
    public void symptomsWriter(List<String> symptomsList, List<Integer> symptomsCount) {
        try {
            FileWriter writer = new FileWriter(filepath);

            String line;
            Integer count;
            for(int i = 0; i<symptomsList.size(); i++) {
                line = symptomsList.get(i);
                count = symptomsCount.get(i);

                writer.write(line + " : " + count + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
