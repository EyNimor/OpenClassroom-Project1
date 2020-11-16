package com.hemebiotech.analytics;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CountSymptomDataFromFle implements ISymptomCounter {

    @Override
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
