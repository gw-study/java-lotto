package calculator;

public class ResultView {
    public static void resultView(StringPlusCalculator stringPlusCalculator, String expression) {
        System.out.println(stringPlusCalculator.splitAndSum(expression));
    }
}
