package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class writerClass {

    public writerClass() throws IOException {
        
    }

    FileWriter writer = new FileWriter("result.out");

    public String addValuesToFile(int head, int rash, int pupil) {
        try {
            writer.write("Headache : " + head + "\n");
            writer.write("Rash : " + rash + "\n");
            writer.write("Dilated Pupils : " + pupil + "\n");
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
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		writerClass writerClass = new writerClass();
        writerClass.addValuesToFile(headacheCount, rashCount, pupilCount);
	}
}
