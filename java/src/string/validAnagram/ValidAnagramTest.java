package string.validAnagram;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class ValidAnagramTest {

    private ValidAnagram validAnagram = new ValidAnagram();

    @Test
    public void isAnagram() {
        assertTrue(validAnagram.isAnagram("anagram", "nagaram"));
        assertFalse(validAnagram.isAnagram("car", "ret"));
    }
}