import junit.framework.*;
import junit.textui.TestRunner;

public class LitreProblemTest extends TestCase
{
	public static void main(String[] args) 
	{
		TestRunner.runAndWait(new TestSuite(LitreProblemTest.class));
	}

	public void testSolver() throws Exception 
	{
		int[] initialCapacity = new int[] {8,0,0};
		int[] expectedAnswer = new int[] {4,4,0};
		assertEquals(expectedAnswer[0], LitreProblemSolver.solve(initialCapacity)[0]);
		assertEquals(expectedAnswer[1], LitreProblemSolver.solve(initialCapacity)[1]);
		assertEquals(expectedAnswer[2], LitreProblemSolver.solve(initialCapacity)[2]);
	}
}