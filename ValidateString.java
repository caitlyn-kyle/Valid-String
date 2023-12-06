import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidateString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please provide a sentence to test: \n");
        String str = sc.nextLine();

        if (str != null && !str.isEmpty()) { // ensure there is a string to work with
            if (isValidSentence(str)) {
                System.out.println("The sentence is valid.");
            } else {
                System.out.println("The sentence is invalid.");
            }

            sc.close();
        }
    }

    public static boolean isValidSentence(String str) {
        return startsWithUpperCase(str)
                && evenQuotation(str)
                && finalCharIsValid(str)
                && periodLastCharacterOnly(str)
                && checkExtractedInt(str);
    }

    public static List<Integer> extractIntegers(String str) {
        List<Integer> extractedIntegers = new ArrayList<>();
        StringBuilder numericInput = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                numericInput.append(c);
            } else if (numericInput.length() > 0) {
                // If a non-digit character is encountered after extracting digits,
                // this will try to parse the current numericInput and add it to the list.
                try {
                    extractedIntegers.add(Integer.parseInt(numericInput.toString()));
                } catch (NumberFormatException e) {
                    // Handle parsing failure if needed
                }
                numericInput.setLength(0); // Reset the StringBuilder for the next number
            }
        }

        // Check for any remaining numericInput after the loop
        if (numericInput.length() > 0) {
            try {
                extractedIntegers.add(Integer.parseInt(numericInput.toString()));
            } catch (NumberFormatException e) {
                // Handle parsing failure if needed
            }
        }

        return extractedIntegers;
    }

    private static boolean checkExtractedInt(String str) { // runs checkNumUnder13IsWord on extracted integers
        List<Integer> extractedIntegers = extractIntegers(str);

        for (Integer extractedInt : extractedIntegers) {
            boolean checkNumUnder13IsWordResult = checkNumUnder13IsWord(extractedInt);
            if (checkNumUnder13IsWordResult == false) {
                System.out.println(
                        "checkNumUnder13IsWord result for " + extractedInt + ": " + checkNumUnder13IsWordResult);
                return false;
            }

        }
        return true;
    }

    public static boolean startsWithUpperCase(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean evenQuotation(String str) {
        int count = 0;
        char quotation = '"'; // assuming quotation marks only refers to the standard double "" quotation
                              // marks
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == quotation) {
                count++;
            }
        }

        if (count % 2 == 0 && count != 0) {
            return true;
        }
        if (count == 0) {
            System.out.println("There are no quotation marks in this string.");
            return true;
        } else {
            return false;
        }
    }

    public static boolean finalCharIsValid(String str) {
        if (str.endsWith(".") || str.endsWith("?") || str.endsWith("!")) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean periodLastCharacterOnly(String str) {
        char period = '.';

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == period) {
                return false; // period found before end of string
            }
        }
        return true;
    }

    public static boolean checkNumUnder13IsWord(Integer extractedInt) {
        if (extractedInt != null && extractedInt < 13) {
            System.out.println("This integer " + extractedInt + " is less than 13 and should be written as a word.");
            return false;
        }
        return true;
    }
}