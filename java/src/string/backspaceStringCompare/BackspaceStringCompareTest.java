package string.backspaceStringCompare;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class BackspaceStringCompareTest {

    private BackspaceStringCompare solution = new BackspaceStringCompare();

    @Test
    public void backspaceCompare() {
        assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
        assertTrue(solution.backspaceCompare("ab##", "c#d#"));
        assertTrue(solution.backspaceCompare("a##c", "#a#c"));
        assertFalse(solution.backspaceCompare("a#c", "b"));
        assertFalse(solution.backspaceCompare("a####c", "b"));
        assertTrue(solution.backspaceCompare("a####b", "b"));
        assertTrue(solution.backspaceCompare("#a#b", "b"));
    }
}