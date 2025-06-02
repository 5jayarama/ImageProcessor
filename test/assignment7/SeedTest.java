package assignment7;

import org.junit.Before;
import org.junit.Test;

import model.Pixel;
import model.Seed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the seed class.
 */
public class SeedTest {
  private Seed seed;
  private Pixel pixel1;

  @Before
  public void setup() {
    this.seed = new Seed(8, 9);
    this.pixel1 = new Pixel(3, 5, 50, 30, 20);
  }

  @Test
  public void testAddingToCluster() {
    assertFalse(this.seed.pixelInCluster(this.pixel1));
    this.seed.addToCluster(this.pixel1);
    assertTrue(this.seed.pixelInCluster(this.pixel1));

    Pixel copy = new Pixel(3, 5, 50, 30, 20);
    assertTrue(this.seed.pixelInCluster(copy));
  }

  @Test
  public void testDistanceToCluster() {
    this.seed.addToCluster(this.pixel1);

    assertEquals(41, this.seed.getDist(this.pixel1));

    Pixel origin = new Pixel(8, 9, 50, 30, 20);
    assertEquals(0, this.seed.getDist(origin));

    Pixel close = new Pixel(8, 10, 50, 30, 20);
    assertEquals(1, this.seed.getDist(close));

  }

  @Test
  public void testGetAverageColor() {
    this.seed.addToCluster(this.pixel1);
    assertEquals(0, this.seed.getAverageColor());

    Pixel pixel2 = new Pixel(8, 9, 30, 0, 130);
    Pixel pixel3 = new Pixel(8, 10, 15, 3, 90);

    Seed newSeed = new Seed(1, 2);
    newSeed.addToCluster(this.pixel1);
    newSeed.addToCluster(pixel2);
    newSeed.addToCluster(pixel3);
    assertEquals(0, this.seed.getAverageColor());

  }
}