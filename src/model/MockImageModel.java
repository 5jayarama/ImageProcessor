package model;

import java.util.Objects;

import static utils.ImageUtil.readPPMAsString;


/**
 * This class represents a MockModel used for testing.
 */
public class MockImageModel implements Model {


  final StringBuilder log;


  public MockImageModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  @Override
  public void insert(String name, Pixel[][] image) {
    log.append("File Name: " + name + ", File Information: " + readPPMAsString(name));
  }

  @Override
  public int width(String name) {
    return 0;
  }

  @Override
  public int height(String name) {
    return 0;
  }

  @Override
  public int maxValue(String name) {
    return 0;
  }

  @Override
  public Pixel getPixelAt(String name, int row, int col) {
    return null;
  }

  @Override
  public boolean inLibrary(String imageName) {
    return false;
  }

  @Override
  public Pixel[][] getLibraryImagePixels(String imageName) {
    return new Pixel[0][];
  }
}