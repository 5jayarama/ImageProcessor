//package controller;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.StringReader;
//
//import controller.commands.Blue;
//import controller.commands.Brighten;
//import controller.commands.Green;
//import controller.commands.HorizontalFlip;
//import controller.commands.Intensity;
//import controller.commands.Load;
//import controller.commands.Luma;
//import controller.commands.Red;
//import controller.commands.SavePPM;
//import controller.commands.Value;
//import controller.commands.VerticalFlip;
//import model.ImageModel;
//import model.MockImageModel;
//import model.Model;
//import model.Pixel;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//
///**
// * This class is testing the functionality of the commands within the controller.
// */
//public class CommandsControllerTest {
//
//  Model m;
//  Model mRed;
//  Model mBlue;
//  Model mGreen;
//  Model mBrighter;
//  Model mHorizontal;
//  Model mVertical;
//  Model mLuma;
//  Model mValue;
//  Model mIntensity;
//  Model m2;
//  Model mmock;
//  Model m2mock;
//  File file;
//  StringBuilder log;
//  Controller load;
//  Controller save;
//  Controller blue;
//  Controller red;
//  Controller green;
//  Controller luma;
//  Controller intensity;
//  Controller value;
//  Controller horizontal;
//  Controller vertical;
//  Controller brighten;
//
//
//
//  @Before
//  public void setup() {
//    this.m = new ImageModel();
//    this.m2 = new ImageModel();
//    this.log = new StringBuilder();
//    this.mmock = new MockImageModel(log);
//    this.m2mock = new MockImageModel(log);
//    this.file = new File("Images/testImage.ppm");
//    this.save = new SavePPM("Images/testImage.ppm", "test");
//    this.load = new Load("Images/testImage.ppm", "test");
//    this.blue = new Blue("Images/testImage.ppm", "blue-test");
//    this.red = new Red("Images/testImage.ppm", "red-test");
//    this.green = new Green("Images/testImage.ppm", "green-test");
//    this.luma = new Luma("Images/testImage.ppm", "luma-test");
//    this.intensity = new Intensity("Images/testImage.ppm", "intensity-test");
//    this.value = new Value("Images/testImage.ppm", "value-test");
//    this.horizontal = new HorizontalFlip("Images/testImage.ppm", "horizontal-test");
//    this.vertical = new VerticalFlip("Images/testImage.ppm", "vertical-test");
//    this.brighten = new Brighten(20, "Images/testImage.ppm", "brighten-test");
//  }
//
//  @Test
//  public void testLoad() {
//    load.operateOn(m);
//    assertTrue(m.inLibrary("test"));
//  }
//
//  @Test
//  public void testSave() {
//    load.operateOn(m);
//    load.operateOn(m2);
//    save.operateOn(m2);
//  }
//
//  // I want to create a method to turn the pixel values into a string
//  so we can compare images based off that
//  @Test
//  public void testRed() {
//    load.operateOn(m);
//    red.operateOn(m);
//    assertEquals();
//  }
//
//  @Test
//  public void testBlue() {
//    load.operateOn(m);
//    load.operateOn(mBlue);
//    blue.operateOn(m);
//    save.operateOn(mBlue);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt("test", 0,0);
//    Pixel topRightPixel = m.getPixelAt("test",1,0);
//    Pixel bottomLeftPixel = m.getPixelAt("test",0,1);
//    Pixel bottomRightPixel = m.getPixelAt("test",1,1);
//
//
//
//    // pixels of blue image
//    Pixel topLeftBluePixel = mBlue.getPixelAt("blue-test",0,0);
//    Pixel topRightBluePixel = mBlue.getPixelAt("blue-test",1,0);
//    Pixel bottomLeftBluePixel = mBlue.getPixelAt("blue-test",0,0);
//    Pixel bottomRightBluePixel = mBlue.getPixelAt("blue-test",0,0);
//
//
//    // values of pixels from blue image
//    int topLeftBlueVals = topLeftBluePixel.getPixelValAvg();
//    int topRightBlueVals = topRightBluePixel.getPixelValAvg();
//    int bottomLeftBlueVals = bottomLeftBluePixel.getPixelValAvg();
//    int bottomRightBlueVals = bottomRightBluePixel.getPixelValAvg();
//
//
//    // see if values of pixels from blue image are equal to original blue value
//    assertEquals(topLeftBlueVals, topLeftPixel.getBlue());
//    assertEquals(topRightBlueVals, topRightPixel.getBlue());
//    assertEquals(bottomLeftBlueVals, bottomLeftPixel.getBlue());
//    assertEquals(bottomRightBlueVals, bottomRightPixel.getBlue());
//
//  }
//
//  @Test
//  public void testGreen() {
//    load.operateOn(m);
//    load.operateOn(mGreen);
//    green.operateOn(m);
//    save.operateOn(mGreen);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt(0,0);
//    Pixel topRightPixel = m.getPixelAt(1,0);
//    Pixel bottomLeftPixel = m.getPixelAt(0,1);
//    Pixel bottomRightPixel = m.getPixelAt(1,1);
//
//
//
//    // pixels of green image
//    Pixel topLeftGreenPixel = mGreen.getPixelAt(0,0);
//    Pixel topRightGreenPixel = mGreen.getPixelAt(1,0);
//    Pixel bottomLeftGreenPixel = mGreen.getPixelAt(0,0);
//    Pixel bottomRightGreenPixel = mGreen.getPixelAt(0,0);
//
//
//    // values of green pixels
//    int topLeftGreenVals = topLeftGreenPixel.getPixelValAvg();
//    int topRightGreenVals = topRightGreenPixel.getPixelValAvg();
//    int bottomLeftGreenVals = bottomLeftGreenPixel.getPixelValAvg();
//    int bottomRightGreenVals = bottomRightGreenPixel.getPixelValAvg();
//
//
//    // see if values of pixels from green image are equal to original green value
//    assertEquals(topLeftGreenVals, topLeftPixel.getGreen());
//    assertEquals(topRightGreenVals, topRightPixel.getGreen());
//    assertEquals(bottomLeftGreenVals, bottomLeftPixel.getGreen());
//    assertEquals(bottomRightGreenVals, bottomRightPixel.getGreen());
//
//  }
//
//  @Test
//  public void testLuma() {
//    load.operateOn(m);
//    load.operateOn(mLuma);
//    luma.operateOn(m);
//    save.operateOn(mLuma);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt(0,0);
//    Pixel topRightPixel = m.getPixelAt(1,0);
//    Pixel bottomLeftPixel = m.getPixelAt(0,1);
//    Pixel bottomRightPixel = m.getPixelAt(1,1);
//
//
//
//    // pixels of Luma image
//    Pixel topLeftLumaPixel = mLuma.getPixelAt(0,0);
//    Pixel topRightLumaPixel = mLuma.getPixelAt(1,0);
//    Pixel bottomLeftLumaPixel = mLuma.getPixelAt(0,1);
//    Pixel bottomRightLumaPixel = mLuma.getPixelAt(1,1);
//
//
//    // values of luma pixels
//    int topLeftLumaVals = topLeftLumaPixel.getPixelValAvg();
//    int topRightLumaVals = topRightLumaPixel.getPixelValAvg();
//    int bottomLeftLumaVals = bottomLeftLumaPixel.getPixelValAvg();
//    int bottomRightLumaVals = bottomRightLumaPixel.getPixelValAvg();
//
//
//    // see if values of luma pixels are equal to original luma value
//    assertEquals(topLeftLumaVals, topLeftPixel.getLuma());
//    assertEquals(topRightLumaVals, topRightPixel.getLuma());
//    assertEquals(bottomLeftLumaVals, bottomLeftPixel.getLuma());
//    assertEquals(bottomRightLumaVals, bottomRightPixel.getLuma());
//
//  }
//
//  @Test
//  public void testIntensity() {
//    load.operateOn(m);
//    load.operateOn(mIntensity);
//    intensity.operateOn(m);
//    save.operateOn(mIntensity);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt(0, 0);
//    Pixel topRightPixel = m.getPixelAt(1, 0);
//    Pixel bottomLeftPixel = m.getPixelAt(0, 1);
//    Pixel bottomRightPixel = m.getPixelAt(1, 1);
//
//
//    // pixels of intensity image
//    Pixel topLeftIntensityPixel = mIntensity.getPixelAt(0, 0);
//    Pixel topRightIntensityPixel = mIntensity.getPixelAt(1, 0);
//    Pixel bottomLeftIntensityPixel = mIntensity.getPixelAt(0, 1);
//    Pixel bottomRightIntensityPixel = mIntensity.getPixelAt(1, 1);
//
//
//    // values of intensity pixels
//    int topLeftIntensityVals = topLeftIntensityPixel.getPixelValAvg();
//    int topRightIntensityVals = topRightIntensityPixel.getPixelValAvg();
//    int bottomLeftIntensityVals = bottomLeftIntensityPixel.getPixelValAvg();
//    int bottomRightIntensityVals = bottomRightIntensityPixel.getPixelValAvg();
//
//
//    // see if values of intensity pixels are equal to original red value
//    assertEquals(topLeftIntensityVals, topLeftPixel.intensity());
//    assertEquals(topRightIntensityVals, topRightPixel.intensity());
//    assertEquals(bottomLeftIntensityVals, bottomLeftPixel.intensity());
//    assertEquals(bottomRightIntensityVals, bottomRightPixel.intensity());
//
//  }
//
//  @Test
//  public void testValue() {
//    load.operateOn(m);
//    load.operateOn(mValue);
//    value.operateOn(m);
//    save.operateOn(mValue);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt(0, 0);
//    Pixel topRightPixel = m.getPixelAt(1, 0);
//    Pixel bottomLeftPixel = m.getPixelAt(0, 1);
//    Pixel bottomRightPixel = m.getPixelAt(1, 1);
//
//
//    // pixels of maxvalue image
//    Pixel topLeftValuePixel = mValue.getPixelAt(0, 0);
//    Pixel topRightValuePixel = mValue.getPixelAt(1, 0);
//    Pixel bottomLeftValuePixel = mValue.getPixelAt(0, 1);
//    Pixel bottomRightValuePixel = mValue.getPixelAt(1, 1);
//
//
//    // values of maxvalue pixels
//    int topLeftValueVals = topLeftValuePixel.getPixelValAvg();
//    int topRightValueVals = topRightValuePixel.getPixelValAvg();
//    int bottomLeftValueVals = bottomLeftValuePixel.getPixelValAvg();
//    int bottomRightValueVals = bottomRightValuePixel.getPixelValAvg();
//
//
//    // see if values of maxvalue pixels are equal to original maxvalue
//    assertEquals(topLeftValueVals, topLeftPixel.getValue());
//    assertEquals(topRightValueVals, topRightPixel.getValue());
//    assertEquals(bottomLeftValueVals, bottomLeftPixel.getValue());
//    assertEquals(bottomRightValueVals, bottomRightPixel.getValue());
//
//  }
//
//  @Test
//  public void testHorizontalFlip() {
//    load.operateOn(m);
//    load.operateOn(mHorizontal);
//    horizontal.operateOn(m);
//    save.operateOn(mHorizontal);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt(0, 0);
//    Pixel topRightPixel = m.getPixelAt(1, 0);
//    Pixel bottomLeftPixel = m.getPixelAt(0, 1);
//    Pixel bottomRightPixel = m.getPixelAt(1, 1);
//
//
//    // pixels of flipped image
//    Pixel topLeftFlippedPixel = mHorizontal.getPixelAt(0, 0);
//    Pixel topRightFlippedPixel = mHorizontal.getPixelAt(1, 0);
//    Pixel bottomLeftFlippedPixel = mHorizontal.getPixelAt(0, 0);
//    Pixel bottomRightFlippedPixel = mHorizontal.getPixelAt(0, 0);
//
//
//    // values of horizontal flipped pixels
//    int topLeftFlippedVals = topLeftFlippedPixel.getPixelValAvg();
//    int topRightFlippedVals = topRightFlippedPixel.getPixelValAvg();
//    int bottomLeftFlippedVals = bottomLeftFlippedPixel.getPixelValAvg();
//    int bottomRightFlippedVals = bottomRightFlippedPixel.getPixelValAvg();
//
//    // values of og pixels
//    int topLeftVals = topLeftPixel.getPixelValAvg();
//    int topRightVals = topRightPixel.getPixelValAvg();
//    int bottomLeftVals = bottomLeftPixel.getPixelValAvg();
//    int bottomRightVals = bottomRightPixel.getPixelValAvg();
//
//
//    // see if values of green pixels are equal to original red value
//    assertEquals(topLeftFlippedVals, topRightVals);
//    assertEquals(topRightFlippedVals, topLeftVals);
//    assertEquals(bottomLeftFlippedVals, bottomRightVals);
//    assertEquals(bottomRightFlippedVals, bottomLeftVals);
//
//  }
//
//  @Test
//  public void testVerticalFlip() {
//    load.operateOn(m);
//    load.operateOn(mVertical);
//    horizontal.operateOn(m);
//    save.operateOn(mVertical);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt(0, 0);
//    Pixel topRightPixel = m.getPixelAt(1, 0);
//    Pixel bottomLeftPixel = m.getPixelAt(0, 1);
//    Pixel bottomRightPixel = m.getPixelAt(1, 1);
//
//
//    // pixels of flipped image
//    Pixel topLeftFlippedPixel = mVertical.getPixelAt(0, 0);
//    Pixel topRightFlippedPixel = mVertical.getPixelAt(1, 0);
//    Pixel bottomLeftFlippedPixel = mVertical.getPixelAt(0, 0);
//    Pixel bottomRightFlippedPixel = mVertical.getPixelAt(0, 0);
//
//
//    // values of vertical flipped pixels
//    int topLeftFlippedVals = topLeftFlippedPixel.getPixelValAvg();
//    int topRightFlippedVals = topRightFlippedPixel.getPixelValAvg();
//    int bottomLeftFlippedVals = bottomLeftFlippedPixel.getPixelValAvg();
//    int bottomRightFlippedVals = bottomRightFlippedPixel.getPixelValAvg();
//
//    // values of og pixels
//    int topLeftVals = topLeftPixel.getPixelValAvg();
//    int topRightVals = topRightPixel.getPixelValAvg();
//    int bottomLeftVals = bottomLeftPixel.getPixelValAvg();
//    int bottomRightVals = bottomRightPixel.getPixelValAvg();
//
//
//    // see if values of green pixels are equal to original red value
//    assertEquals(topLeftFlippedVals, bottomLeftVals);
//    assertEquals(topRightFlippedVals, bottomRightVals);
//    assertEquals(bottomLeftFlippedVals, topLeftVals);
//    assertEquals(bottomRightFlippedVals, topRightVals);
//
//  }
//
//  @Test
//  public void testBrighten() {
//    load.operateOn(m);
//    load.operateOn(mBrighter);
//    brighten.operateOn(m);
//    save.operateOn(mBrighter);
//    save.operateOn(m);
//    Readable testIn = new StringReader("load Images/2x2test.ppm test " +
//            "red-component test red-test save Images/2x2red-test.ppm red-test");
//
//
//    // pixels of saved image
//    Pixel topLeftPixel = m.getPixelAt(0, 0);
//    Pixel topRightPixel = m.getPixelAt(1, 0);
//    Pixel bottomLeftPixel = m.getPixelAt(0, 1);
//    Pixel bottomRightPixel = m.getPixelAt(1, 1);
//
//
//    // pixels of flipped image
//    Pixel topLeftBrighterPixel = mVertical.getPixelAt(0, 0);
//    Pixel topRightBrighterPixel = mVertical.getPixelAt(1, 0);
//    Pixel bottomLeftBrighterPixel = mVertical.getPixelAt(0, 0);
//    Pixel bottomRightBrighterPixel = mVertical.getPixelAt(0, 0);
//
//
//    // values of vertical flipped pixels
//    int topLeftBrighterVals = topLeftBrighterPixel.getPixelValAvg();
//    int topRightBrighterVals = topRightBrighterPixel.getPixelValAvg();
//    int bottomLeftBrighterVals = bottomLeftBrighterPixel.getPixelValAvg();
//    int bottomRightBrighterVals = bottomRightBrighterPixel.getPixelValAvg();
//
//    // values of og pixels
//    int topLeftVals = topLeftPixel.getPixelValAvg();
//    int topRightVals = topRightPixel.getPixelValAvg();
//    int bottomLeftVals = bottomLeftPixel.getPixelValAvg();
//    int bottomRightVals = bottomRightPixel.getPixelValAvg();
//
//
//    // see if values of brightened pixels are equal to pixels of the brightended file
//    assertEquals(topLeftBrighterVals, topLeftVals);
//    assertEquals(topRightBrighterVals, bottomRightVals);
//    assertEquals(bottomLeftBrighterVals, topLeftVals);
//    assertEquals(bottomRightBrighterVals, topRightVals);
//
//  }
//}