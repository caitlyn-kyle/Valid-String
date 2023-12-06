import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ValidateStringTest {

    @Test
    public void testIsValidSentence() {
        assertTrue(ValidateString.isValidSentence("The quick brown fox said “hello Mr lazy dog”."));
        assertFalse(ValidateString.isValidSentence("the quick brown fox said “hello Mr lazy dog\"."));

    }

    @Test
    public void testStartsWithUpperCase() {
        assertTrue(ValidateString.startsWithUpperCase("Hello."));
        assertFalse(ValidateString.startsWithUpperCase("this is not valid."));

    }

    @Test
    public void testEvenQuotation() {
        assertTrue(ValidateString.evenQuotation("Like he said \"Test it again\", she said. "));
        assertFalse(ValidateString.evenQuotation("How do you do a \"quotation."));

    }

    @Test
    public void testFinalCharIsValid() {
        assertTrue(ValidateString.finalCharIsValid("There are 3 valid termination characters."));
        assertTrue(ValidateString.finalCharIsValid("There are 3 valid termination characters!"));
        assertTrue(ValidateString.finalCharIsValid("There are 3 valid termination characters?"));
        assertFalse(ValidateString.finalCharIsValid("That ends in a comma,"));

    }

    @Test
    public void testPeriodLastCharacterOnly() {
        assertTrue(ValidateString.periodLastCharacterOnly("This has one period."));
        assertFalse(ValidateString.periodLastCharacterOnly("Hello. It's nice to meet you."));

    }

    @Test
    public void testExtractIntegers() {
        List<Integer> integers = ValidateString.extractIntegers("There are 8 planets and Jupiter has 95 moons.");
        assertEquals(List.of(8, 95), integers);

    }

    @Test
    public void testCheckNumUnder13IsWord() {
        assertTrue(ValidateString.checkNumUnder13IsWord(27));
        assertFalse(ValidateString.checkNumUnder13IsWord(3));

    }
}
