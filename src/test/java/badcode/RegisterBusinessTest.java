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

    @Test
    @DisplayName("Test Register Failure , result = DomainEmailInvalidException")
    public void case04(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(DomainEmailInvalidException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Arsom");
            speaker.setLastName("Mahatthanamongkol");
            speaker.setEmail("arsom");
            business.register(null,speaker);
        });
    }

    @Test
    @DisplayName("Test Register Failure , result = Can't save a speaker.")
    public void case05(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Arsom");
            speaker.setLastName("Mahatthanamongkol");
            speaker.setEmail("arsomm@gmail.com");
            business.register(null,speaker);
        });
        assertEquals("Can't save a speaker.",exception.getMessage());
    }

    @Test
    @DisplayName("Test Register Failure,email not match domain , result = Speaker doesn't meet our standard rules.")
    public void case06(){
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Arsom");
            speaker.setLastName("Mahatthanamongkol");
            speaker.setEmail("arsomm@hotmail.com");
            business.register(null,speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.",exception.getMessage());
    }

    @Test
    @DisplayName("Test Register ,exp 1 , result 1")
    public void case07(){
        SpeakerRepository repository  = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        };
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Arsom");
        speaker.setLastName("Mahatthanamongkol");
        speaker.setEmail("arsomm@gmail.com");
        speaker.setExp(1);
        Integer result = business.register(repository,speaker);
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Test Register ,exp 2 , result = 1")
    public void case08(){
        SpeakerRepository repository  = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        };
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Arsom");
        speaker.setLastName("Mahatthanamongkol");
        speaker.setEmail("arsomm@gmail.com");
        speaker.setExp(2);
        Integer result = business.register(repository,speaker);
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Test Register ,exp 3 , result = 1")
    public void case09(){
        SpeakerRepository repository  = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        };
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Arsom");
        speaker.setLastName("Mahatthanamongkol");
        speaker.setEmail("arsomm@gmail.com");
        speaker.setExp(3);
        Integer result = business.register(repository,speaker);
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Test Register ,exp 5 , result = 1")
    public void case10(){
        SpeakerRepository repository  = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        };
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Arsom");
        speaker.setLastName("Mahatthanamongkol");
        speaker.setEmail("arsomm@gmail.com");
        speaker.setExp(5);
        Integer result = business.register(repository,speaker);
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Test Register ,exp 9 , result = 1")
    public void case11(){
        SpeakerRepository repository  = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        };
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Arsom");
        speaker.setLastName("Mahatthanamongkol");
        speaker.setEmail("arsomm@gmail.com");
        speaker.setExp(9);
        Integer result = business.register(repository,speaker);
        assertEquals(1,result);
    }
}