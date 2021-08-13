package string.findAllAnagramsInAString;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class FindAllAnagramsInAStringTest {

    private FindAllAnagramsInAString solution = new FindAllAnagramsInAString();

    @Test
    public void findAnagrams() {
        List<Integer> anagrams = solution.findAnagrams2("ab", "ab");
        Integer[] ans = anagrams.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{0}, ans);
    }

    @Test
    public void findAnagrams1() {
        List<Integer> anagrams = solution.findAnagrams2("aba", "ab");
        Integer[] ans = anagrams.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{0, 1}, ans);
    }

    @Test
    public void findAnagrams2() {
        List<Integer> anagrams = solution.findAnagrams2("bacbca", "bac");
        Integer[] ans = anagrams.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{0, 1, 3}, ans);
    }

}