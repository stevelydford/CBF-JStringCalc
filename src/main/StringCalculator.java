package main;

public class StringCalculator {

    public int add(String number) {
        if(number == "")
            return 0;

        String[] numbers = splitByNewlineAndComma(number);

        int total = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            total += Integer.parseInt(numbers[i]);
        }

        return total;
    }

    private String[] splitByNewlineAndComma(String number) {
        return number.split("[\n,]");
    }
}
