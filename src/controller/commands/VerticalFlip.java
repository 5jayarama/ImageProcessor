package controller.commands;

import controller.Commands;
import model.Model;

/**
 * Class contains the command object HorizontalFlip that takes the image and loads a new
 * copy of the image that has been flipped horizontally into our Image Library.
 */
public class VerticalFlip extends AbstractCommand implements Commands {

  private String oldImageName;
  private String newImageName;

  /**
   * This constructor allows us to take in the name the user wants the image saved as in the
   * Image library, and the path that it comes from.
   * @param newImageName the name that the user wants to refer to the photo as from now on
   */
  public VerticalFlip(String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
  }


  @Override
  public void operateOn(Model image) {
    vertical(image, oldImageName, newImageName);
    System.out.println("Flipped Image Created");
  }

}
