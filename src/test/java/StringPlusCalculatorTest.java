import calculator.StringPlusCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringPlusCalculatorTest {

    private StringPlusCalculator stringPlusCalculator;

    @BeforeEach
    public void setup() {
        stringPlusCalculator = new StringPlusCalculator();
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = stringPlusCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringPlusCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringPlusCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringPlusCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringPlusCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringPlusCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringPlusCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
