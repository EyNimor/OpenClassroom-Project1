package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {

    static List<String> result = new ArrayList<String>();
    static List<String> symptomsList = new ArrayList<String>();
    static List<Integer> symptomsCount = new ArrayList<Integer>();

    public final static String readerFilepath = "symptoms.txt";
    public final static String writerFilepath = "result.out";
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readerClass = new ReadSymptomDataFromFile(readerFilepath);
        result = readerClass.GetSymptoms();
        
        CountSymptomDataFromFle countClass = new CountSymptomDataFromFle();
        symptomsList = countClass.symptomsList(result);
        symptomsCount = countClass.symptomsCount(result, symptomsList);

        WriteSymptomDataFromFile writerClass = new WriteSymptomDataFromFile(writerFilepath);
        writerClass.symptomsWriter(symptomsList, symptomsCount);
	}
}
