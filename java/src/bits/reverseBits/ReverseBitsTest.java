package bits.reverseBits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class ReverseBitsTest {
    private ReverseBits solution = new ReverseBits();

    @Test
    public void reverseBits() {
        assertEquals(1073741824, solution.reverseBits(2));
        assertEquals(964176192, solution.reverseBits(43261596));
        assertEquals(-1073741825, solution.reverseBits(-3));
    }
}