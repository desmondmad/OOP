//Desmond Madden D00154375
package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class OOPCA1 {
    public static void main(String[] args) {
        //Declare scanner as null
        Scanner scan = null;
        try {
            //Declare studentNum as null String,
            //subjectCode,mark as int arrays with length of 8,
            //topMarks as a null array,
            //avg as double
            String studentNum = null;
            int subjectCode[] = new int[8];
            int mark[] = new int[8];
            int topMarks[] = null;
            double avg;
            //Initialise scan to read the txt file and use a delimiter so it ignores the , in the txt file
            scan = new Scanner(new File("JC_Results.txt"));
            scan.useDelimiter(",|\r\n");

            //Start a while loop for while the scan has more to read
            while(scan.hasNext())
            {
                //studentNum becomes the first bit of data on a line in the file and then prints out the studentNum
                studentNum = scan.next();
                System.out.println("Student Number: " + studentNum);
                //Start a for loop, to add the correct elements into the subjectCode and mark arrays and then print them out
                for(int i = 0; i < mark.length; i++){
                    subjectCode[i] = scan.nextInt();
                    mark[i] = scan.nextInt();

                    System.out.println("Subject " + (i + 1) + ": " + subjectCode[i] + " Mark: " + mark[i] + "\n");
                }
                //return the selected 5 grades from the method selectFiveGrades() into the topMarks array using the parameters of subjectCode and mark
                topMarks = selectFiveGrades(subjectCode, mark);
                //Print out the selected 5 grades
                System.out.println("Students top marks were: " + Arrays.toString(topMarks));
                //return the average of the selected 5 grades from the method calculateAverage() into avg using topMarks as the parameter
                avg = calculateAverage(topMarks);
                //Print out the average
                System.out.println("The average mark of the student is: " + avg);
                //Print out some spaces for formatting and easier to read
                System.out.println();
                System.out.println("------------------------------------------------");
                //Go to the next line in the file
                scan.nextLine();
            }
            //close the file if it has not been closed already
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
            //If subjectCode is Maths,English,Irish or CSPE, don't add it to the nonMandatory array
            if(codes[i] != 1 && codes[i] != 2 && codes[i] != 3 && codes[i] != 218){
                nonMandatory[countN] = grades[i];
                countN++;
            }
        }
        //Sort the array so the largest grades are at the end of the array and are easier to find
        Arrays.sort(nonMandatory);
        for(int i = 0; i < topMarks.length;i++){
            //Make the first 3 selected grades English,Irish,Maths
            if (i < 3){
                topMarks[i] = mandatoryMarks[i];
            }
            //Make the 4th selected grade the second largest result in the nonMandatory array
            else if(i == 3){
                topMarks[i] = nonMandatory[nonMandatory.length - 2];
            }
            //Make the 5th selected grade the largest result in the nonMandatory array
            else{
                topMarks[i] = nonMandatory[nonMandatory.length - 1];
            }
        }
        //return the array topMarks
        return topMarks;
    }
//--------------------------------------------------------------------------
    public static double calculateAverage(int[] selectedGrades){
        int total = 0;
        double average;
        for (int i = 0; i < selectedGrades.length;i++){
            total += selectedGrades[i];
        }
        average = (double)total / selectedGrades.length;
        return average;
    }
}
