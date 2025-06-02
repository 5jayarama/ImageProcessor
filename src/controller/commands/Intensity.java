package controller.commands;

import controller.Commands;
import model.Model;
import model.Pixel;

/**
 * Class contains the command object Intensity that takes the image and loads a new
 * greyscale image set to the intensity value into our Image Library.
 */
public class Intensity extends AbstractCommand implements Commands {

  private String oldImageName;
  private String newImageName;

  /**
   * This constructor allows us to take in the name the user wants the image saved as in the
   * Image library, and the path that it comes from.
   * @param newImageName the name that the user wants to refer to the photo as from now on
   */
  public Intensity(String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
  }

  @Override
  public Pixel colorSetter(Pixel pixel) {
    int intenseVal = pixel.intensity();
    return new Pixel(pixel.getRow(), pixel.getCol(), intenseVal, intenseVal, intenseVal);
  }

  @Override
  public void operateOn(Model image) {
    System.out.println("Image Created");
    componentChanger(image, oldImageName, newImageName);
  }
}