package assignment7;

import org.junit.Before;
import org.junit.Test;

import controller.commands.Mosaic;
import model.ImageModel;
import model.Model;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the added Mosaic feature extended onto the existing design.
 */
public class MosaicTest {
  private Model model;
  private Pixel[][] pixels;

  @Before
  public void setup() {
    this.model = new ImageModel();
    this.pixels = new Pixel[][]{{new Pixel(0, 0, 150, 200, 250),
        new Pixel(0, 1, 250, 200, 150)},
        {new Pixel(1, 0, 200, 200, 200),
        new Pixel(1, 1, 200, 200, 200)}};

    this.model.insert("imgTest", pixels);
  }


  @Test
  public void testMosaic1() {
    Pixel[][] expected = new Pixel[][]{{new Pixel(0, 0, 175, 200, 225),
            new Pixel(0, 1, 225, 200, 175)},
      {new Pixel(1, 0, 175, 200, 225),
        new Pixel(1, 1, 225, 200, 175)}};
    Mosaic mosaic = new Mosaic(3, 2, "imgTest", "imgTest");
    mosaic.operateOn(model);

    for (int r = 0; r < 2; r++) {
      for (int c = 0; c < 2; c++) {
        assertEquals(expected[r][c].getRed(), mosaic.colorSetter(this.pixels[r][c]).getRed());
        assertEquals(expected[r][c].getGreen(), mosaic.colorSetter(this.pixels[r][c]).getGreen());
        assertEquals(expected[r][c].getBlue(), mosaic.colorSetter(this.pixels[r][c]).getBlue());
      }
    }
  }

  @Test
  public void testMosaic2() {
    Pixel[][] expected = new Pixel[][]{{new Pixel(0, 0, 200, 200, 200),
            new Pixel(0, 1, 200, 200, 200)},
      {new Pixel(1, 0, 200, 200, 200),
        new Pixel(1, 1, 200, 200, 200)}};
    Mosaic mosaic = new Mosaic(3, 1, "imgTest", "imgTest");
    mosaic.operateOn(model);

    for (int r = 0; r < 2; r++) {
      for (int c = 0; c < 2; c++) {
        assertEquals(expected[r][c].getRed(), mosaic.colorSetter(this.pixels[r][c]).getRed());
        assertEquals(expected[r][c].getGreen(), mosaic.colorSetter(this.pixels[r][c]).getGreen());
        assertEquals(expected[r][c].getBlue(), mosaic.colorSetter(this.pixels[r][c]).getBlue());
      }
    }
  }
}
