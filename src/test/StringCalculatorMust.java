package test;

import main.StringCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorMust {

    StringCalculator stringCalculator;

    @Before
    public void before(){
        stringCalculator  = new StringCalculator();
    }

    @Test
    public void returnZeroForEmptyString(){
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void returnParseIntForSingleNumber(){
        Assert.assertEquals(4, stringCalculator.add("4"));
    }

    @Test
    public void returnTheSumOfTwoNumber(){
        Assert.assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void returnTheSumOfMultipleNumbers(){
        Assert.assertEquals(45, stringCalculator.add("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    public void handleNewlinesAsSeparators(){
        Assert.assertEquals(6, stringCalculator.add("1\n2,3"));
    }
}
