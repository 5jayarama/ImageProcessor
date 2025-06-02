package model;

/**
 * The Model interface contains all classes and methods related to using Images as models.
 */
public interface Model {

  /**
   * The insert method places an ImageModel into our ImageLibrary.
   * @param name the name of the image
   * @param image the pixel map that makes up the image
   */
  void insert(String name, Pixel[][] image);

  /**
   * Gets the width of an image.
   * @return the width as an int.
   */
  int width(String name);

  /**
   * Gets the height of an image.
   * @return the height as an int.
   */
  int height(String name);

  /**
   * Gets the Maximum Value of an image.
   * @return the maxValue as an int.
   */
  int maxValue(String name);

  /**
   * Gets the Pixel at the specified value.
   * @param row the row of the Pixel
   * @param col the column of the Pixel
   * @return the Pixel at the specified location
   */
  Pixel getPixelAt(String name, int row, int col);

  /**
   * This method determines if the given imageName is contained in the ImageLibrary.
   * @param imageName is the image being checked in the library.
   * @return boolean  if it is true.
   */
  public boolean inLibrary(String imageName);

  /**
   * Gets the double array of pixels that makes up the given image.
   * @param imageName the name of the given image
   * @return the double array of pixels that makes up the given image
   */
  Pixel[][]getLibraryImagePixels(String imageName);

}