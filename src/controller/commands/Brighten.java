package controller.commands;


import controller.Commands;
import model.Model;
import model.Pixel;

/**
 * Class contains the command object Brighten that takes the image and loads a brighter
 * copy image of the original into our Image Library.
 */
public class Brighten extends AbstractCommand implements Commands {

  private int increment;
  private String oldImageName;
  private String newImageName;

  /**
   * This method brightens the image by the specified increment.
   * @param increment indicates the degree in which the image is being brightened.
   */
  public Brighten(int increment, String oldImageName, String newImageName) {
    this.increment = increment;
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
  }

  @Override
  public Pixel colorSetter(Pixel pixel) {
    int redVal = pixel.getRed() + increment;
    int blueVal = pixel.getBlue() + increment;
    int greenVal = pixel.getGreen() + increment;
    return new Pixel(pixel.getRow(), pixel.getCol(), redVal, greenVal, blueVal);
  }

  @Override
  public void operateOn(Model image) {
    componentChanger(image, oldImageName, newImageName);
    System.out.println("Brightened Image Created");
  }
}
