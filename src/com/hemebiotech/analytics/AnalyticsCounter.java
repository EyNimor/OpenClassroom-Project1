package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class symptomsCount {
    public int headacheCountInFile(List<String> resultList) {

        int headache = 0;
        String symptoms;
        boolean isHeadache;

        for(int i = 0; i<resultList.size(); i++)
        {
            System.out.println(resultList.get(i));
            symptoms = resultList.get(i);
            isHeadache = symptoms.equals("headache");
            if(isHeadache==true)
            {
                headache++;
            }
        }

        return headache;
    }
    public int rashCountInFile(List<String> resultList) {
        
        int rash = 0;
        String symptoms;
        boolean isRash;

        for(int i = 0; i<resultList.size(); i++)
        {
            symptoms = resultList.get(i);
            isRash = symptoms.equals("rash");
            if(isRash==true)
            {
                rash++;
            }
        }

        return rash;
    }
    public int dPupilsCountInFile(List<String> resultList) {
        
        int dPupils = 0;
        String symptoms;
        boolean isDPupils;

        for(int i = 0; i<resultList.size(); i++)
        {
            symptoms = resultList.get(i);
            isDPupils = symptoms.equals("dialated pupils");
            if(isDPupils==true)
            {
                dPupils++;
            }
        }

        return dPupils;
    }
}

class writerClass {

    public writerClass() throws IOException {
        
    }

    FileWriter writer = new FileWriter("result.out");

    public String addValuesToFile(int head, int rash, int pupils) {
        try {
            writer.write("Headache : " + head + "\n");
            writer.write("Rash : " + rash + "\n");
            writer.write("Dialated Pupils : " + pupils + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	static List<String> result = new ArrayList<String>();

    public final static String filepath = "symptoms.txt";
	
	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile readerClass = new ReadSymptomDataFromFile(filepath);
        result = readerClass.GetSymptoms();

        symptomsCount countClass = new symptomsCount();
        headacheCount = countClass.headacheCountInFile(result);
        rashCount = countClass.rashCountInFile(result);
        pupilCount = countClass.dPupilsCountInFile(result);
		
		writerClass writerClass = new writerClass();
        writerClass.addValuesToFile(headacheCount, rashCount, pupilCount);
	}
}
