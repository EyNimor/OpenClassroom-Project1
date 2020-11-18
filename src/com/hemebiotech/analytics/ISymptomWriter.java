package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomWriter {
    /**
     * 
     * 
     * @param symptomsList List of symptoms finded in the .txt file.
     * @param symptomsCount List containing how many times every symptoms appear in the .txt file.
     */
    void symptomsWriter(List<String> symptomsList, List<Integer> symptomsCount);
    
}
