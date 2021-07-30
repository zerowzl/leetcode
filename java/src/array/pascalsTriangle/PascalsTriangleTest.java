package array.pascalsTriangle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dave Wang
 */
public class PascalsTriangleTest {

    private PascalsTriangle solution = new PascalsTriangle();

    @Test
    public void generate() {
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(2));
        System.out.println(solution.generate(3));
        System.out.println(solution.generate(4));
        System.out.println(solution.generate(5));
        System.out.println(solution.generate(6));
        System.out.println(solution.generate(7));
        System.out.println(solution.generate(8));
        System.out.println(solution.generate(9));
        System.out.println(solution.generate(10));
    }
}