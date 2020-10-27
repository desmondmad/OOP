package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OOPCA1Test extends TestCase {
    public void testMain() {
    }
    @Test
    public void testSelect5Grades() {
        System.out.println("Select 5 Grades");
        int [] subject = {1,2,3,4,5,12,42,46};
        int [] mark = {65,58,45,60,50,48,42,60};
        OOPCA1 instance = new OOPCA1();
        int[] expResult = {65,58,45,60,60};
        int[] result = instance.selectFiveGrades(subject,mark);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(expResult,result);
    }

    @Test
    public void testCalcAvg() {
        System.out.println("Calculate Average");
        int [] topMarks = {65,58,45,60,60};
        OOPCA1 instance = new OOPCA1();
        double expResult = 57.5;
        double result = instance.calculateAverage(topMarks);

        assertEquals(expResult,result,0.5);
    }
}
