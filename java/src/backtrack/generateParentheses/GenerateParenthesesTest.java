package backtrack.generateParentheses;

import org.junit.Test;

import java.util.List;

/**
 * @author Dave Wang
 */
public class GenerateParenthesesTest {

    private GenerateParentheses generateParentheses = new GenerateParentheses();

    @Test
    public void generateParenthesis() {
        List<String> res = generateParentheses.generateParenthesis(1);
        for (String s : res) {
            System.out.println(s);
        }
    }

    @Test
    public void generateParenthesis2() {
        List<String> res = generateParentheses.generateParenthesis(2);
        for (String s : res) {
            System.out.println(s);
        }
    }

    @Test
    public void generateParenthesis3() {
        List<String> res = generateParentheses.generateParenthesis(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}