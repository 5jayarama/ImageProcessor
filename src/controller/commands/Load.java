package controller.commands;

import controller.Commands;
import model.Model;
import static utils.ImageUtil.readImage;

/**
 * Class contains the command object Load that takes the image and loads it
 * as an image into our Image Library.
 */
public class Load implements Commands {

  private String imagePath;
  private String imageName;

  /**
   * This constructor allows us to take in the name the user wants the image saved as in the
   * Image library, and the path that it comes from.
   *
   * @param imagePath the path of the image/the name of the file we want to load
   * @param imageName the name that the user wants to refer to the photo as from now on
   */
  public Load(String imagePath, String imageName) {
    this.imagePath = imagePath;
    this.imageName = imageName;
  }

  @Override
  public void operateOn(Model image) {
    image.insert(imageName, readImage(imagePath));
    System.out.println("Image Loaded");
  }
}
