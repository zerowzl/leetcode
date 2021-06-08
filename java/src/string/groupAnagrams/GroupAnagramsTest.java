package string.groupAnagrams;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    public void groupAnagrams() {
        List<List<String>> res = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }
}