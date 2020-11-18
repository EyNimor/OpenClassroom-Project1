package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomCounter {
    /**
     * 
     * 
     * @param result list coming directly from the reader
     * @return a list of symptoms presents in the result list
     */
    Map<String, Integer>symptomsList(List<String> result);
}
