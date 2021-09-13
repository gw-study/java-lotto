package calculator;

import java.util.Scanner;

public class InputView {
    public static String inputString(Scanner scanner) {
        System.out.print("덧셈할 문자열을 입력하세요 : ");
        return scanner.next();
    }
}
