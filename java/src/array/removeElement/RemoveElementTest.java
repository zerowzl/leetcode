package array.removeElement;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class RemoveElementTest {

    @Test
    public void removeElement() {
        RemoveElement solution = new RemoveElement();
        assertEquals(4, solution.removeElement(new int[]{1, 2, 3, 3, 2, 1}, 1));
        assertEquals(0, solution.removeElement(new int[]{1, 1}, 1));
        assertEquals(2, solution.removeElement(new int[]{1, 1}, 2));
    }
}