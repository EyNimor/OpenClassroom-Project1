package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountSymptomDataFromFile implements ISymptomCounter {

    @Override
    /**
     * Take the list coming from the reader and create a new map with symptoms and their number of occurences
     * 
     * In the map, the keys are the symptoms and the values are the number of time that symptom appears in the result list
     * 
     * @param result list coming directly from the reader
     * @return a map of symptoms and their number of appearence presents in the result list
     */
    public Map<String, Integer> symptomsList(List<String> result) {
        Map<String, Integer> symptomsList = new TreeMap<String, Integer>();

        Integer count; 
        String line;
        boolean ifContains;
        for(int i = 0; i<result.size(); i++) {
            line = result.get(i);
            ifContains = symptomsList.containsKey(line);
            if(ifContains == false) {
                symptomsList.put(line, 1);
            }
            else {
                count = symptomsList.get(line) + 1;
                symptomsList.put(line, count);
            }
        }

        return symptomsList;
    }
  
}
