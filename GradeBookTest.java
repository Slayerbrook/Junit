package Lab4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() throws Exception {
        // Create two GradeBook objects with a capacity of 5
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        // Add scores to both GradeBook objects
        g1.addScore(50);
        g1.addScore(75);

        g2.addScore(30);
        g2.addScore(80);
        g2.addScore(90);
    }

    @After
    public void tearDown() throws Exception {
        // Set GradeBook objects to null
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        // Check if scores are correctly added using toString
        assertTrue(g1.toString().equals("Scores: 50.0, 75.0"));
        assertTrue(g2.toString().equals("Scores: 30.0, 80.0, 90.0"));

        // Check if the scoreSize is correctly updated
        assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        // Check sum calculations
        assertEquals(125, g1.sum(), 0.0001);
        assertEquals(200, g2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        // Check minimum calculations
        assertEquals(50, g1.minimum(), 0.0001);
        assertEquals(30, g2.minimum(), 0.0001);
    }

    @Test
    public void testFinalScore() {
        // Check finalScore calculations (sum minus minimum score)
        assertEquals(75, g1.finalScore(), 0.0001);
        assertEquals(170, g2.finalScore(), 0.0001);
    }
}