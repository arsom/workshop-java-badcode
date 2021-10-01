package badcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RegisterBusinessGetFreeTest {
    @ParameterizedTest
    @CsvSource({
            "0,500",
            "1,500",
            "2,250",
            "3,250",
            "4,100",
            "5,100",
            "8,50",
            "9,50",
            "10,0",
    })
    public void getFree(int exp,int free){
        Speaker speaker = new Speaker();
        int actualFree = speaker.getFee(exp);
        Assertions.assertEquals(free,actualFree);
    }
}
