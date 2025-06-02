package model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains the ImageModel which is used as our Model in the MVC format.
 */
public class ImageModel implements Model {

  private Map<String, Pixel[][]> imageLibrary; // consider if we need to make a class
  private int maxValue;


  /**
   * This constructor represents the Image Model object. This object is represented by the
   * filename, as well as a 2D array of Pixels.
   */
  public ImageModel() {
    this.imageLibrary = new HashMap<String, Pixel[][]>();
  }

  @Override
  public void insert(String name, Pixel[][] image) {
    imageLibrary.put(name, image);
  }

  @Override
  public int width(String name) {
    return getLibraryImagePixels(name).length;
  }

  /**
   * Returns the height of the given image.
   * @param name the name of the image
   * @return the height of the given image
   */
  public int height(String name) {
    return getLibraryImagePixels(name)[0].length;
  }

  @Override
  public int maxValue(String name) {
    return this.maxValue;
  }

  @Override
  public Pixel getPixelAt(String name, int row, int col) {
    Pixel[][] pixelArray = getLibraryImagePixels(name);
    return pixelArray[col][row];
  }


  private String getPixelVals(Pixel pixel) {
    StringBuilder sb = new StringBuilder();
    sb.append("Red Value: " + Integer.toString(pixel.getRed()) + "\n");
    sb.append("Green Value: " + Integer.toString(pixel.getGreen()) + "\n");
    sb.append("Blue Value: " + Integer.toString(pixel.getBlue()) + "\n");
    return sb.toString();
  }

  @Override
  public boolean inLibrary(String imageName) {
    return imageLibrary.containsKey(imageName);
  }

  @Override
  public Pixel[][] getLibraryImagePixels(String imageName) {
    if (inLibrary(imageName)) {
      return imageLibrary.get(imageName);
    } else {
      System.out.println("Image could not be found");
      return null;
    }
  }
}