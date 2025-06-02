package controller.commands;

import controller.Commands;
import model.Model;



/**
 * Class contains the command object Luma that takes the image and loads a new
 * greyscale image set to the luma value into our Image Library.
 */
public class Luma extends AbstractCommand implements Commands {

  private String oldImageName;
  private String newImageName;


  /**
   * This constructor allows us to take in the name the user wants the image saved as in the
   * Image library, and the path that it comes from.
   * @param newImageName the name that the user wants to refer to the photo as from now on
   */
  public Luma(String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
    this.matrix = new double[][]{
            {0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}
    };
  }

  @Override
  public void operateOn(Model image) {
    componentChanger(image, oldImageName, newImageName);
    System.out.println("Image Created");
  }
}