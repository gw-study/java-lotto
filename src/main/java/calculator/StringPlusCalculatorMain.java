package calculator;

import java.util.Scanner;

public class StringPlusCalculatorMain {

    public static void main(String[] args) {
        ResultView.resultView(new StringPlusCalculator(), InputView.inputString(new Scanner(System.in)));
    }
}
