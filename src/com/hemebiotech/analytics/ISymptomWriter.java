package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomWriter {
    /**
     * Made a file "result.out" with every symptoms listed and their occurences
     * 
     * @param symptomsList List of symptoms finded in the .txt file.
     * @param symptomsCount List containing how many times every symptoms appear in the .txt file.
     */
    void symptomsWriter(List<String> symptomsList, List<Integer> symptomsCount);
    
}
