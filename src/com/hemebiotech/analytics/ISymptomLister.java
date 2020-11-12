package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomLister {

    List<String>symptomsList(List<String> result);
    List<Integer>symptomsCount(List<String> result, List<String> symptomsList);
    
}
