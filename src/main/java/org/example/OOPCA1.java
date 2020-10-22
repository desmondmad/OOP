//Desmond Madden SD2B
package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class OOPCA1 {
    public static void main(String[] args) {
        Scanner scan = null;
        try {
            String studentNum = null;
            int subjectCode[] = new int[8];
            int mark[] = new int[8];
            int topMarks[] = null;
            double avg;

            scan = new Scanner(new File("JC_Results.txt"));
            scan.useDelimiter(",|\r\n");

            while(scan.hasNext())
            {
                studentNum = scan.next();
                System.out.println("Student Number: " + studentNum);
                for(int i = 0; i < mark.length; i++){
                    subjectCode[i] = scan.nextInt();
                    mark[i] = scan.nextInt();

                    System.out.println("Subject " + (i + 1) + ": " + subjectCode[i] + " Mark: " + mark[i] + "\n");
                }
                topMarks = selectFiveGrades(subjectCode, mark);
                System.out.println("Students top marks were: " + Arrays.toString(topMarks));
                avg = calculateAverage(topMarks);
                System.out.println("The average mark of the student is: " + avg);
                System.out.println();
                System.out.println("------------------------------------------------");
                scan.nextLine();
            }
            scan.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//---------------------------------------------------------------------------
    public static int[] selectFiveGrades(int[] codes, int[] grades){
        int mandatoryMarks[] = new int[3];
        int nonMandatory[] = new int[5];
        int topMarks[] = new int[5];
        int countM = 0;
        int countN = 0;
        for(int i = 0; i < grades.length;i++){
            if(codes[i] == 1){
                mandatoryMarks[countM] = grades[i];
                countM++;
            } else if(codes[i] == 2){
                mandatoryMarks[countM] = grades[i];
                countM++;
            } else if(codes[i] == 3){
                mandatoryMarks[countM] = grades[i];
                countM++;
            }
            if(codes[i] != 1 && codes[i] != 2 && codes[i] != 3 && codes[i] != 218){
                nonMandatory[countN] = grades[i];
                countN++;
            }
        }
        Arrays.sort(nonMandatory);
        for(int i = 0; i < topMarks.length;i++){
            if (i < 3){
                topMarks[i] = mandatoryMarks[i];
            }
            else if(i == 3){
                topMarks[i] = nonMandatory[nonMandatory.length - 2];
            }
            else{
                topMarks[i] = nonMandatory[nonMandatory.length - 1];
            }
        }
        return topMarks;
    }
//--------------------------------------------------------------------------
    private static double calculateAverage(int[] selectedGrades){
        int total = 0;
        double average;
        for (int i = 0; i < selectedGrades.length;i++){
            total += selectedGrades[i];
        }
        average = (double)total / selectedGrades.length;
        return average;
    }
}
