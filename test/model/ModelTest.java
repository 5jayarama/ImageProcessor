package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static utils.ImageUtil.readPPM;

/**
 * This class tests the functionality of the model.
 */
public class ModelTest {

  Model m;
  Model m2;

  @Before
  public void setup() {
    this.m = new ImageModel();
    this.m2 = new ImageModel();
  }

  @Test
  public void testInsert() {
    assertEquals(false, m.inLibrary("2x2test"));
    m.insert("2x2test", readPPM("images/2x2test.ppm"));
    assertEquals(true, m.inLibrary("2x2test"));
  }

  @Test
  public void testWidth() {
    assertEquals(2, m.width("test"));
  }

  @Test
  public void testHeight() {
    assertEquals(2, m.height("test"));
  }

  @Test
  public void testMaxValue() {
    assertEquals(255, m.maxValue("test"));
  }

  @Test
  public void testInLibrary() {
    assertEquals(false, m.inLibrary("2x2test"));
    m.insert("2x2test", readPPM("images/2x2test.ppm"));
    assertEquals(true, m.inLibrary("2x2test"));
  }

  @Test
  public void testGetLibraryImagePixels() {
    m.insert("2x2test", readPPM("images/2x2test.ppm"));
    assertEquals(readPPM("images/2x2test.ppm"),
            m.getLibraryImagePixels("2x2test"));
  }
}
