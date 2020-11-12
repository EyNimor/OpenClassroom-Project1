package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Classe pour compter les symptômes recherchés (Headache, Rash, Dialated Pupils) dans ceux retournés par le FileReader
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

//Classe pour écrire le nombre de Symptôme recherché dans un fichier result.out
class writerClass {

    FileWriter writer;

    public writerClass() {
        try {
            this.writer = new FileWriter("result.out");

        } catch (IOException e) {

        }

    }

    public void addValuesToFile(int head, int rash, int pupils) {
        try {
            writer.write("Headache : " + head + "\n");
            writer.write("Rash : " + rash + "\n");
            writer.write("Dialated Pupils : " + pupils + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
    }

}

public class AnalyticsCounter {

	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	static List<String> result = new ArrayList<String>();

	//Chemin d'accés du fichier contenant les Symptômes
    public final static String filepath = "symptoms.txt";
	
	public static void main(String args[]) throws Exception {
		
		/** 
		 * 	On instancie la classe ReadSymptomDataFromFile pour utiliser la liste GetSymptoms et pouvoir lire le fichier
		 * 	contenant les symptômes. 
		 * 
		 *  On mets les symptômes obtenus par la liste GetSymptoms dans une liste result.
		 */
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
