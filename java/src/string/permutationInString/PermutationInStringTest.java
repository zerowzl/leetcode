package string.permutationInString;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dave Wang
 */
public class PermutationInStringTest {

    private PermutationInString solution = new PermutationInString();


    @Test
    public void checkInclusion() {
        assertTrue(solution.checkInclusion("ab", "eidbaooo"));
        assertFalse(solution.checkInclusion("ab", "eidboaoo"));
        assertTrue(solution.checkInclusion("ab", "ab"));
        assertTrue(solution.checkInclusion("ab", "ba"));
        assertTrue(solution.checkInclusion("ab", "ccaccbccab"));
        assertTrue(solution.checkInclusion("ab", "ccaccbccba"));
    }

    @Test
    public void checkInclusion_2() {
        assertTrue(solution.checkInclusion2("ab", "eidbaooo"));
        assertFalse(solution.checkInclusion2("ab", "eidboaoo"));
        assertTrue(solution.checkInclusion2("ab", "ab"));
        assertTrue(solution.checkInclusion2("ab", "ba"));
        assertTrue(solution.checkInclusion2("ab", "ccaccbccab"));
        assertTrue(solution.checkInclusion2("ab", "ccaccbccba"));
    }
}