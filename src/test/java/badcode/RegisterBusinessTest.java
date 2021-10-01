package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    @Test
    @DisplayName("Test Register Failure , result = First name is required.")
    public void case01(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null,new Speaker());
        });
        assertEquals("First name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Test Register Failure , result = Last name is required.")
    public void case02(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Arsom");
            business.register(null,speaker);
        });
        assertEquals("Last name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Test Register Failure , result = Email is required.")
    public void case03(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Arsom");
            speaker.setLastName("Mahatthanamongkol");
            business.register(null,speaker);
        });
        assertEquals("Email is required.",exception.getMessage());
    }
}