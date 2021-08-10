package binarySearch.findPeakElement;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Wang
 */
public class FindPeakElementTest {

    private FindPeakElement solution = new FindPeakElement();

    @Test
    public void findPeakElement() {
        assertEquals(0, solution.findPeakElement(new int[]{0}));
        assertEquals(1, solution.findPeakElement(new int[]{1, 2}));
        assertEquals(1, solution.findPeakElement(new int[]{1, 2, 1}));
        assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3}));
        assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3, 1}));
        assertEquals(1, solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}