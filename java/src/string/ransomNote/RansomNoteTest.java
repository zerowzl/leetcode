package string.ransomNote;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class RansomNoteTest {

    private RansomNote solution = new RansomNote();

    @Test
    public void canConstruct() {
        assertFalse(solution.canConstruct("aa", "ab"));
        assertTrue(solution.canConstruct("aa", "aab"));
    }
}