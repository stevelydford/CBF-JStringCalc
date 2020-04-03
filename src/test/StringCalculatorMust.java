package test;

import main.StringCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorMust {

    StringCalculator stringCalculator;

    @Before
    public void before(){
        stringCalculator  = new StringCalculator();
    }

    @Test
    public void returnZeroForEmptyString() throws Exception {
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void returnParseIntForSingleNumber() throws Exception {
        Assert.assertEquals(4, stringCalculator.add("4"));
    }

    @Test
    public void returnTheSumOfTwoNumber() throws Exception {
        Assert.assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void returnTheSumOfMultipleNumbers() throws Exception {
        Assert.assertEquals(45, stringCalculator.add("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    public void handleNewlinesAsSeparators() throws Exception {
        Assert.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void handleCustomSeparators() throws Exception {
        Assert.assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void handleCustomArbitrarySeparators() throws Exception {
        Assert.assertEquals(3, stringCalculator.add("//*\n1*2"));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void disallowNegativeNumbers() throws Exception {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("negatives not allowed: -2 -3");
        stringCalculator.add("1,-2,-3");
    }
}
