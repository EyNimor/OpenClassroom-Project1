package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomCounter {
    /**
     * 
     * 
     * @param result list coming directly from the reader
     * @return a list of symptoms presents in the result list
     */
    List<String>symptomsList(List<String> result);

    /**
     * 
     * 
     * @param result list coming directly from the reader
     * @param symptomsList list containing every symptoms of the .txt file without duplications
     * @return a list with the number of occurence for each symptoms of the source list
     */
    List<Integer>symptomsCount(List<String> result, List<String> symptomsList);
    
}
