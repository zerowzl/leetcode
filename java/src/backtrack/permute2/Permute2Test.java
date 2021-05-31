package backtrack.permute2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class Permute2Test {

    @Test
    public void permuteUnique() {
        Permute2 permute2 = new Permute2();
        System.out.println(permute2.permuteUnique(new int[]{1, 2, 3}));
    }

    @Test
    public void permuteUnique2() {
        Permute2 permute2 = new Permute2();
        System.out.println(permute2.permuteUnique(new int[]{1, 2, 1}));
    }



}