package org.example;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;

public class OOPCA1 {
    public static void main(String[] args) {
        Scanner scan = null;
        try {
            String studentNum = null,
                subjectCode1 = null,
                subjectCode2 = null,
                subjectCode3 = null,
                subjectCode4 = null,
                subjectCode5 = null,
                subjectCode6 = null,
                subjectCode7 = null,
                subjectCode8 = null;

            Double mark1 = null,
                    mark2 = null,
                    mark3 = null,
                    mark4 = null,
                    mark5 = null,
                    mark6 = null,
                    mark7 = null,
                    mark8 = null;

            scan = new Scanner(new File("JC_Results.txt"));
            scan.useDelimiter(",|\r\n");

            while(scan.hasNext())
            {
                int studentResults[] = new int[17];
                studentNum = scan.next();
                subjectCode1 = scan.next();
                mark1 = scan.nextDouble();
                subjectCode2 = scan.next();
                mark2 = scan.nextDouble();
                subjectCode3 = scan.next();
                mark3 = scan.nextDouble();
                subjectCode4 = scan.next();
                mark4 = scan.nextDouble();
                subjectCode5 = scan.next();
                mark5 = scan.nextDouble();
                subjectCode6 = scan.next();
                mark6 = scan.nextDouble();
                subjectCode7 = scan.next();
                mark7 = scan.nextDouble();
                subjectCode8 = scan.next();
                mark8 = scan.nextDouble();

                scan.nextLine();

                System.out.println("Student Number: " + studentNum + "\nSubject 1: " + subjectCode1 + " Mark: " + mark1 + "\n"
                        + "Subject 2: " + subjectCode2 + " Mark: " + mark2 + "\n"
                        + "Subject 3: " + subjectCode3 + " Mark: " + mark3 + "\n"
                        + "Subject 4: " + subjectCode4 + " Mark: " + mark4 + "\n"
                        + "Subject 5: " + subjectCode5 + " Mark: " + mark5 + "\n"
                        + "Subject 6: " + subjectCode6 + " Mark: " + mark6 + "\n"
                        + "Subject 7: " + subjectCode7 + " Mark: " + mark7 + "\n"
                        + "Subject 8: " + subjectCode8 + " Mark: " + mark8);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
