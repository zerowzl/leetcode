package recursion.letterCombinationsOfAPhoneNumber;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void letterCombinations() {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
    }
}