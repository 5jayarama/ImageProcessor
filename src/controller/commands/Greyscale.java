package controller.commands;

import controller.Commands;
import model.Model;


/**
 * The Greyscale class represents the function object for the greyscale command and applies
 * the grey-scale filter to the desired image.
 */
public class Greyscale extends AbstractCommand implements Commands {

  private String oldImageName;
  private String newImageName;


  /**
   * This constructor allows us to take in the name the user wants the image saved as in the
   * Image library, and the path that it comes from.
   */
  public Greyscale(String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
    this.matrix = new double[][]{
            {0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}
    };
  }

  @Override
  public void operateOn(Model image) {
    componentChanger(image, oldImageName, newImageName); //test
    System.out.println("Greyscale Image Created");
  }
}
