package calculator;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    public int splitAndSum(String expression) {
        if (isBlank(expression)) {
            return 0;
        }

        return add(splitExpression(expression));
    }

    private String[] splitExpression(String expression) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);

        if (matcher.find()) {
            return splitWithSign(matcher.group(2), matcher.group(1));
        }
        return splitWithSign(expression, ",|:");
    }
    private  String[] splitWithSign(String expression, String sign) {
        return expression.split(sign);
    }

    private int add(String[] numbers) {
        if (!isAllPositive(numbers)) {
            throw new RuntimeException();
        }
        return Arrays.stream(numbers).mapToInt(num -> Integer.parseInt(num)).sum();
    }

    private boolean isAllPositive(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(num -> Integer.parseInt(num)).allMatch(num -> num > 0);
    }

    private boolean isBlank(String expression) {
        if (expression == null || expression.isEmpty() || expression == " ") {
            return true;
        }
        return false;
    }
}
