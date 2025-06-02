package controller.commands;

import controller.Commands;
import model.Model;



/**
 * Class contains the command object Red that takes the image and loads a new
 * greyscale image set to the red value into our Image Library.
 */
public class Red extends AbstractCommand implements Commands {

  private String oldImageName;
  private String newImageName;


  /**
   * This constructor allows us to take in the name the user wants the image saved as in the
   * Image library, and the path that it comes from.
   */
  public Red(String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
    this.matrix = new double[][] {
            {1,0,0}, {1,0,0},{1,0,0}
    };
  }

  @Override
  public void operateOn(Model image) {
    componentChanger(image, oldImageName, newImageName);
    System.out.println("Greyscale-Red Image Created");
  }
}