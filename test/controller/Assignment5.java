package controller;

import org.junit.Before;
import org.junit.Test;

import controller.commands.Blur;
import controller.commands.Greyscale;
import controller.commands.Load;
import controller.commands.LoadPPM;
import controller.commands.Save;
import controller.commands.SavePPM;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import model.ImageModel;
import model.Pixel;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is used for testing new commands.
 */
public class Assignment5 {

  private ImageModel m;
  private ImageModel m2;
  Commands sepia;
  Commands save;
  Commands load;
  Commands load2;
  Commands greyscale;
  Commands blur;
  Commands sharpen;
  Commands saveSepia;
  Commands loadTest;
  Commands sepiaTest;
  Commands saveGrey;
  Commands saveBlur;
  Commands saveSharp;
  Commands save2;


  @Before
  public void setup() {
    this.m = new ImageModel();
    this.m2 = new ImageModel();
    this.save = new SavePPM("Images/slash.ppm", "slash");
    this.save2 = new Save("Images/slash.ppm", "slash");
    this.saveSepia = new SavePPM("Images/testSepiaImage.ppm", "sepia-test");
    this.saveGrey = new SavePPM("Images/testGreyImage.ppm", "grey-test");
    this.saveBlur = new SavePPM("Images/testBlurImage.ppm", "blur-test");
    this.saveSharp = new SavePPM("Images/testSharpenImage.ppm", "sharp-test");
    this.loadTest = new LoadPPM("Images/testImage.ppm", "test");
    this.load = new LoadPPM("Images/slash.ppm", "slash");
    this.load2 = new Load("Images/slash.png", "slash");
    this.sepia = new Sepia("slash", "sepia-slash");
    this.sepiaTest = new Sepia("test", "sepia-test");
    this.greyscale = new Greyscale("test", "test-slash");
    this.blur = new Blur("test", "blur-test");
    this.sharpen = new Sharpen("test", "sharp-test");
  }


  @Test
  public void testLoadPPM() {
    load.operateOn(m);
    assertTrue(m.inLibrary("test"));
  }

  @Test
  public void testLoad() {
    load2.operateOn(m);
    assertTrue(m.inLibrary("slash"));
  }

  @Test
  public void testSavePPM() {
    load.operateOn(m);
    load.operateOn(m2);
    save.operateOn(m2);
    assertEquals(m, m2);
  }

  @Test
  public void testSave() {
    load.operateOn(m);
    load.operateOn(m2);
    save2.operateOn(m2);
    assertEquals(m, m2);
  }

  @Test
  public void testSepia() {

    loadTest.operateOn(m);
    Pixel pixel1 = m.getPixelAt("test", 0, 0);
    Pixel pixel2 = m.getPixelAt("test", 1, 0);
    Pixel pixel3 = m.getPixelAt("test", 0, 1);
    Pixel pixel4 = m.getPixelAt("test", 1, 1);
    Pixel sepiaPixel1 = new Pixel(0, 0, (int)((0.393 * (pixel1.getRed())) +
            (0.769 * (pixel1.getGreen())) + (0.189 * (pixel1.getBlue()))),
            (int)((0.349 * (pixel1.getRed())) + (0.686 * (pixel1.getGreen())) +
                    (0.186 * (pixel1.getBlue()))),
            (int)((0.272 * (pixel1.getRed())) + (0.534 * (pixel1.getGreen())) +
                    (0.131 * (pixel1.getBlue()))));
    Pixel sepiaPixel2 = new Pixel(0, 1, (int)((0.393 * (pixel2.getRed())) +
            (0.769 * (pixel2.getGreen())) + (0.189 * (pixel2.getBlue()))),
            (int)((0.349 * (pixel2.getRed())) +
                    (0.686 * (pixel2.getGreen())) + (0.186 * (pixel2.getBlue()))),
            (int)((0.272 * (pixel2.getRed())) + (0.534 * (pixel2.getGreen())) +
                    (0.131 * (pixel2.getBlue()))));
    Pixel sepiaPixel3 = new Pixel(1, 0, (int)((0.393 * (pixel3.getRed())) +
            (0.769 * (pixel3.getGreen())) + (0.189 * (pixel3.getBlue()))),
            (int)((0.349 * (pixel3.getRed())) + (0.686 * (pixel3.getGreen())) +
                    (0.186 * (pixel3.getBlue()))),
            (int)((0.272 * (pixel3.getRed())) + (0.534 * (pixel3.getGreen())) +
                    (0.131 * (pixel3.getBlue()))));
    Pixel sepiaPixel4 = new Pixel(1, 1, (int)((0.393 * (pixel4.getRed())) +
            (0.769 * (pixel4.getGreen())) + (0.189 * (pixel4.getBlue()))),
            (int)((0.349 * (pixel4.getRed())) + (0.686 * (pixel4.getGreen())) +
                    (0.186 * (pixel4.getBlue()))),
            (int)((0.272 * (pixel4.getRed())) + (0.534 * (pixel4.getGreen())) +
                    (0.131 * (pixel4.getBlue()))));
    sepiaTest.operateOn(m);
    saveSepia.operateOn(m);
    pixel1 = m.getPixelAt("sepia-test", 0, 0);
    pixel2 = m.getPixelAt("sepia-test", 1, 0);
    pixel3 = m.getPixelAt("sepia-test", 0, 1);
    pixel4 = m.getPixelAt("sepia-test", 1, 1);


    //pixel 1
    assertEquals(pixel1.getRed(), sepiaPixel1.getRed());
    assertEquals(pixel1.getGreen(), sepiaPixel1.getGreen());
    assertEquals(pixel1.getBlue(), sepiaPixel1.getBlue());

    //pixel 2
    assertEquals(pixel2.getRed(), sepiaPixel2.getRed());
    assertEquals(pixel2.getGreen(), sepiaPixel2.getGreen());
    assertEquals(pixel2.getBlue(), sepiaPixel2.getBlue());

    //pixel 3
    assertEquals(pixel3.getRed(), sepiaPixel3.getRed());
    assertEquals(pixel3.getGreen(), sepiaPixel3.getGreen());
    assertEquals(pixel3.getBlue(), sepiaPixel3.getBlue());

    //pixel 4
    assertEquals(pixel4.getRed(), sepiaPixel4.getRed());
    assertEquals(pixel4.getGreen(), sepiaPixel4.getGreen());
    assertEquals(pixel4.getBlue(), sepiaPixel4.getBlue());


  }

  @Test
  public void testGreyscale() {

    loadTest.operateOn(m);
    Pixel pixel1 = m.getPixelAt("test", 0, 0);
    Pixel pixel2 = m.getPixelAt("test", 1, 0);
    Pixel pixel3 = m.getPixelAt("test", 0, 1);
    Pixel pixel4 = m.getPixelAt("test", 1, 1);

    Pixel greyPixel1 = new Pixel(0, 0, (int) (0.2126 * pixel1.getRed()),
            (int) 0.7152 * pixel1.getGreen(),
            (int) 0.0722 * pixel1.getBlue());
    Pixel greyPixel2 = new Pixel(0, 1, (int) (0.2126 * pixel2.getRed()),
            (int) 0.7152 * pixel2.getGreen(),
            (int) 0.0722 * pixel2.getBlue());
    Pixel greyPixel3 = new Pixel(1, 0, (int) (0.2126 * pixel3.getRed()),
            (int) 0.7152 * pixel3.getGreen(),
            (int) 0.0722 * pixel3.getBlue());
    Pixel greyPixel4 = new Pixel(1, 1, (int) (0.2126 * pixel4.getRed()),
            (int) 0.7152 * pixel4.getGreen(),
            (int) 0.0722 * pixel4.getBlue());


    greyscale.operateOn(m);
    saveGrey.operateOn(m);
    pixel1 = m.getPixelAt("grey-test", 0, 0);
    pixel2 = m.getPixelAt("grey-test", 1, 0);
    pixel3 = m.getPixelAt("grey-test", 0, 1);
    pixel4 = m.getPixelAt("grey-test", 1, 1);


    //pixel 1
    assertEquals(pixel1.getRed(), greyPixel1.getRed());
    assertEquals(pixel1.getGreen(), greyPixel1.getGreen());
    assertEquals(pixel1.getBlue(), greyPixel1.getBlue());

    //pixel 2
    assertEquals(pixel2.getRed(), greyPixel2.getRed());
    assertEquals(pixel2.getGreen(), greyPixel2.getGreen());
    assertEquals(pixel2.getBlue(), greyPixel2.getBlue());

    //pixel 3
    assertEquals(pixel3.getRed(), greyPixel3.getRed());
    assertEquals(pixel3.getGreen(), greyPixel3.getGreen());
    assertEquals(pixel3.getBlue(), greyPixel3.getBlue());

    //pixel 4
    assertEquals(pixel4.getRed(), greyPixel4.getRed());
    assertEquals(pixel4.getGreen(), greyPixel4.getGreen());
    assertEquals(pixel4.getBlue(), greyPixel4.getBlue());
  }

  @Test
  public void testBlur() {

    loadTest.operateOn(m);
    Pixel pixel1 = m.getPixelAt("test", 0, 0);
    Pixel pixel2 = m.getPixelAt("test", 1, 0);
    Pixel pixel3 = m.getPixelAt("test", 0, 1);
    Pixel pixel4 = m.getPixelAt("test", 1, 1);

    Pixel blurPixel1 = new Pixel(0, 0, (int) ((1 / 4) * pixel1.getRed()),
            (1 / 4) * pixel1.getGreen(),
            (1 / 4) * pixel1.getBlue());
    Pixel blurPixel2 = new Pixel(0, 1, (int) ((1 / 8) * pixel1.getRed()),
            (1 / 8) * pixel1.getGreen(),
            (1 / 8) * pixel1.getBlue());
    Pixel blurPixel3 = new Pixel(1, 0, (int) ((1 / 8) * pixel1.getRed()),
            (1 / 8) * pixel1.getGreen(),
            (1 / 8) * pixel1.getBlue());
    Pixel blurPixel4 = new Pixel(1, 1, (int) ((1 / 16) * pixel1.getRed()),
            (1 / 16) * pixel1.getGreen(),
            (1 / 16) * pixel1.getBlue());


    blur.operateOn(m);
    saveBlur.operateOn(m);
    pixel1 = m.getPixelAt("blur-test", 0, 0);
    pixel2 = m.getPixelAt("blur-test", 1, 0);
    pixel3 = m.getPixelAt("blur-test", 0, 1);
    pixel4 = m.getPixelAt("blur-test", 1, 1);


    //pixel 1
    assertEquals(pixel1.getRed(), blurPixel1.getRed());
    assertEquals(pixel1.getGreen(), blurPixel1.getGreen());
    assertEquals(pixel1.getBlue(), blurPixel1.getBlue());

    //pixel 2
    assertEquals(pixel2.getRed(), blurPixel2.getRed());
    assertEquals(pixel2.getGreen(), blurPixel2.getGreen());
    assertEquals(pixel2.getBlue(), blurPixel2.getBlue());

    //pixel 3
    assertEquals(pixel3.getRed(), blurPixel3.getRed());
    assertEquals(pixel3.getGreen(), blurPixel3.getGreen());
    assertEquals(pixel3.getBlue(), blurPixel3.getBlue());

    //pixel 4
    assertEquals(pixel4.getRed(), blurPixel4.getRed());
    assertEquals(pixel4.getGreen(), blurPixel4.getGreen());
    assertEquals(pixel4.getBlue(), blurPixel4.getBlue());
  }

  @Test
  public void testSharpen() {

    loadTest.operateOn(m);
    Pixel pixel1 = m.getPixelAt("test", 0, 0);
    Pixel pixel2 = m.getPixelAt("test", 1, 0);
    Pixel pixel3 = m.getPixelAt("test", 0, 1);
    Pixel pixel4 = m.getPixelAt("test", 1, 1);

    Pixel sharpPixel1 = new Pixel(0, 0, (int) (1) * pixel1.getRed(),
            (1) * pixel1.getGreen(),
            (1) * pixel1.getBlue());
    Pixel sharpPixel2 = new Pixel(0, 1, (int) ((1 / 4) * pixel1.getRed()),
            (1 / 4) * pixel1.getGreen(),
            (1 / 4) * pixel1.getBlue());
    Pixel sharpPixel3 = new Pixel(1, 0, (int) ((1 / 4) * pixel1.getRed()),
            (1 / 4) * pixel1.getGreen(),
            (1 / 4) * pixel1.getBlue());
    Pixel sharpPixel4 = new Pixel(1, 1, (int) ((1 / 4) * pixel1.getRed()),
            (1 / 4) * pixel1.getGreen(),
            (1 / 4) * pixel1.getBlue());


    sharpen.operateOn(m);
    sharpen.operateOn(m);
    pixel1 = m.getPixelAt("sharp-test", 0, 0);
    pixel2 = m.getPixelAt("sharp-test", 1, 0);
    pixel3 = m.getPixelAt("sharp-test", 0, 1);
    pixel4 = m.getPixelAt("sharp-test", 1, 1);


    //pixel 1
    assertEquals(pixel1.getRed(), sharpPixel1.getRed());
    assertEquals(pixel1.getGreen(), sharpPixel1.getGreen());
    assertEquals(pixel1.getBlue(), sharpPixel1.getBlue());

    //pixel 2
    assertEquals(pixel2.getRed(), sharpPixel2.getRed());
    assertEquals(pixel2.getGreen(), sharpPixel2.getGreen());
    assertEquals(pixel2.getBlue(), sharpPixel2.getBlue());

    //pixel 3
    assertEquals(pixel3.getRed(), sharpPixel3.getRed());
    assertEquals(pixel3.getGreen(), sharpPixel3.getGreen());
    assertEquals(pixel3.getBlue(), sharpPixel3.getBlue());

    //pixel 4
    assertEquals(pixel4.getRed(), sharpPixel4.getRed());
    assertEquals(pixel4.getGreen(), sharpPixel4.getGreen());
    assertEquals(pixel4.getBlue(), sharpPixel4.getBlue());
  }
}


