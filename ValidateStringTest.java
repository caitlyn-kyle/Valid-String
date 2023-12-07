import org.junit.*;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ValidateStringTest {

    @Test
    public void testIsValidSentence() {
        assertTrue(ValidateString.isValidSentence("This sentence is valid."));
        assertTrue(ValidateString.isValidSentence("The quick brown fox said \"hello Mr lazy dog\"."));
        assertTrue(ValidateString.isValidSentence("Let's party like it's 1999!"));
        assertTrue(ValidateString.isValidSentence("What do you mean?"));
        assertTrue(ValidateString.isValidSentence("To quote the Mandalorian, \"This is the way\"!"));
        assertFalse(ValidateString.isValidSentence("the quick brown fox said “hello Mr lazy dog\"."));
        assertFalse(ValidateString.isValidSentence("You say \"No but I say \"Yes\"!"));
        assertFalse(ValidateString.isValidSentence("!"));
        assertFalse(ValidateString.isValidSentence("Dr. Brown will see you now."));
        assertFalse(ValidateString.isValidSentence("13"));
        assertFalse(ValidateString.isValidSentence("2."));
        assertFalse(ValidateString.isValidSentence("14."));
        assertFalse(ValidateString.isValidSentence("There's 14"));
        assertFalse(ValidateString.isValidSentence("What is 5!"));
        assertFalse(ValidateString.isValidSentence("run 2 meters!"));
        assertFalse(ValidateString.isValidSentence("The average person has 2.4 children in the UK!"));

    }

    @Test
    public void testStartsWithUpperCase() {
        assertTrue(ValidateString.startsWithUpperCase("Hello."));
        assertTrue(ValidateString.startsWithUpperCase("Just testing that it starts with at least 1 uppercase"));
        assertTrue(ValidateString.startsWithUpperCase("UK!"));
        assertFalse(ValidateString.startsWithUpperCase("this is not valid."));

    }

    @Test
    public void testEvenQuotation() {
        assertTrue(ValidateString.evenQuotation("Like he said \"Test it again\", she said. "));
        assertTrue(ValidateString.evenQuotation("Even with no quotations this is still true"));
        assertFalse(ValidateString.evenQuotation("How do you do a \"quotation?"));
        assertFalse(ValidateString.evenQuotation("\"\"\""));

    }

    @Test
    public void testFinalCharIsValid() {
        assertTrue(ValidateString.finalCharIsValid("."));
        assertTrue(ValidateString.finalCharIsValid("!"));
        assertTrue(ValidateString.finalCharIsValid("?"));
        assertTrue(ValidateString.finalCharIsValid("There are 3 valid termination characters!"));
        assertFalse(ValidateString.finalCharIsValid("That ends in a comma,"));
        assertFalse(ValidateString.finalCharIsValid("there is no termination character"));

    }

    @Test
    public void testPeriodLastCharacterOnly() {
        assertTrue(ValidateString.periodLastCharacterOnly("This has one period."));
        assertTrue(ValidateString.periodLastCharacterOnly("What! That is impossible."));
        assertTrue(ValidateString.periodLastCharacterOnly("There is no period!"));
        assertTrue(ValidateString.periodLastCharacterOnly("There are a lot of test cases, don't you think?"));
        assertFalse(ValidateString.periodLastCharacterOnly("Hello. It's nice to meet you."));
        assertFalse(ValidateString.periodLastCharacterOnly("Hello. How do you do?"));
        assertFalse(ValidateString.periodLastCharacterOnly("I'm going for a run.."));

    }

    @Test
    public void testExtractIntegers() {
        List<Integer> integers = ValidateString.extractIntegers("There are 8 planets and Jupiter has 95 moons.");
        List<Integer> noNumberTest = ValidateString.extractIntegers("There are no numbers");
        List<Integer> splitNumTest = ValidateString.extractIntegers("0 1!");
        assertEquals(List.of(8, 95), integers);
        assertTrue(noNumberTest.isEmpty());
        assertEquals(List.of(0, 1), splitNumTest);

    }

    @Test
    public void testCheckNumUnder13IsWord() {
        assertTrue(ValidateString.checkNumUnder13IsWord(27));
        assertTrue(ValidateString.checkNumUnder13IsWord(13));
        assertTrue(ValidateString.checkNumUnder13IsWord(14));
        assertFalse(ValidateString.checkNumUnder13IsWord(3));
        assertFalse(ValidateString.checkNumUnder13IsWord(12));

    }
}
