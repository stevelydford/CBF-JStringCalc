package main;

public class StringCalculator {

    public int add(String number) throws Exception {
        if(number == "")
            return 0;

        String[] numbers;

        if(number.startsWith("//")){
            numbers = splitByCustomSeparator(number);
        }
        else {
            numbers = splitByNewlineAndComma(number);
        }

        int total = 0;
        String negativeNumbers = "";

        for (int i = 0; i < numbers.length; i++)
        {
            if(Integer.parseInt(numbers[i]) < 0)
            {
                negativeNumbers += " " + Integer.parseInt(numbers[i]);
            }
            total += Integer.parseInt(numbers[i]);
        }

        if(negativeNumbers.length() > 0)
            throw new IllegalArgumentException("negatives not allowed:" + negativeNumbers);

        return total;
    }

    private String[] splitByCustomSeparator(String number) {
        char customSeparator = number.charAt(2);
        number = number.substring(4);
        return number.split("[\n" + customSeparator + "]");
    }

    private String[] splitByNewlineAndComma(String number) {
        return number.split("[\n,]");
    }
}
