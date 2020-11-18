package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @see ISymptomReader
 * @see ISymptomCounter
 * @see ISymptomWriter
 */
public class AnalyticsCounter {

    static List<String> result = new ArrayList<String>();
    static Map<String, Integer> symptomsList = new TreeMap<String, Integer>();

    // We declare the path to the file to read, and to the file to write
    public final static String readerFilepath = "symptoms.txt";
    public final static String writerFilepath = "result.out";
    
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readerClass = new ReadSymptomDataFromFile(readerFilepath);
        result = readerClass.getSymptoms();
        
        CountSymptomDataFromFile countClass = new CountSymptomDataFromFile();
        symptomsList = countClass.symptomsList(result);

        WriteSymptomDataFromFile writerClass = new WriteSymptomDataFromFile(writerFilepath);
        writerClass.symptomsWriter(symptomsList);
	}
}