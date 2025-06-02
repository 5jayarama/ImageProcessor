package controller.commands;

import controller.Commands;
import model.Model;


/**
 * The Sepia class represents the function object for the Sepia command and applies
 * the sepia filter to the desired image.
 */
public class Sepia extends AbstractCommand implements Commands {

  private String oldImageName;
  private String newImageName;


  /**
   * This constructor allows us to take in the name the user wants the image saved as in the
   * Image library, and the path that it comes from.
   */
  public Sepia(String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
    this.matrix = new double[][]{
            {0.393, 0.769, 0.189}, {0.349, 0.686, 0.168}, {0.272, 0.534, 0.131}
    };
  }

  @Override
  public void operateOn(Model image) {
    componentChanger(image, oldImageName, newImageName);
    System.out.println("Sepia Image Created");
  }
}


