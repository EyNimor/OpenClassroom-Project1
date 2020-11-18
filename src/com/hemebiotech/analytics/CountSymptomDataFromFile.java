package com.hemebiotech.analytics;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CountSymptomDataFromFile implements ISymptomCounter {

    @Override
    /**
     * Take the list coming from the reader and create a new list by remove the possible symptoms duplications
     * 
     * @param result list coming directly from the reader
     * @return a list of symptoms presents in the result list
     */
    public List<String> symptomsList(List<String> result) {
        List<String> symptomsList = new ArrayList<>();

        String line;
        boolean ifContains;
        for(int i = 0; i<result.size(); i++) {
            line = result.get(i);
            ifContains = symptomsList.contains(line);
            if(ifContains == false) {
                symptomsList.add(line);
            }
        }
        Collections.sort(symptomsList);

        return symptomsList;
    }

    @Override
    /**
     * Count the number of time that a symptoms appear in the list coming from the reader
     * 
     * @param result list coming directly from the reader
     * @param symptomsList list containing every symptoms of the .txt file without duplications
     * @return a list with the number of occurence for each symptoms of the source list
     */
    public List<Integer> symptomsCount(List<String> result, List<String> symptomsList) {
        List<Integer> symptomsCount = new ArrayList<>();

        String researchedLine;
        String actualLine;
        boolean ifEquals;
        Integer count;
        for(int i = 0; i<symptomsList.size(); i++) {
            count = 0;
            researchedLine = symptomsList.get(i);
            for(int u = 0; u<result.size(); u++) {
                actualLine = result.get(u);
                ifEquals = actualLine.equals(researchedLine);
                if(ifEquals == true) {
                    count++;
                }
            }
            symptomsCount.add(count);
        }

        return symptomsCount;
    }
  
}
