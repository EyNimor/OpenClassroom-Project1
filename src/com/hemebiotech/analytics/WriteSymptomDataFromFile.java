package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataFromFile implements ISymptomWriter {

    private static String filepath;

    private FileWriter writer;

    /**
     * 
     * @param filepath a full or partial path to the file we have to write
     */
    public WriteSymptomDataFromFile(String filepath) {
        WriteSymptomDataFromFile.filepath = filepath;
    }

    @Override
    /**
     * Made a file "result.out" with every symptoms listed and their occurences
     * 
     * @param symptomsList List of symptoms finded in the .txt file.
     * @param symptomsCount List containing how many times every symptoms appear in the .txt file.
     */
    public void symptomsWriter(Map<String, Integer> symptomsList) {
        try {
            writer = new FileWriter(filepath);

            for(Map.Entry<String, Integer> entry : symptomsList.entrySet()) {
                writer.write( entry.getKey() + " : " + entry.getValue() + "\n" );
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                System.out.println("Closing Writer...");
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Error : Writer not open !");
            }
        }

    }

}
