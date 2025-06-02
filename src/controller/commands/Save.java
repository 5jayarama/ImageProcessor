package controller.commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import controller.Commands;
import model.Model;
import model.Pixel;


import static utils.ImageUtil.writeBuffered;


/**
 * The Save class represents the function object for the Save command and saves
 * the non-ppm file to user specified location.
 */
public class Save implements Commands {

  private String imagePath;
  private String fileName;

  /**
   * This constructor is used so that we can allow the user to choose where the image is saved to.
   *
   * @param imagePath where the user wants the image saved
   */
  public Save(String imagePath, String fileName) {
    this.imagePath = imagePath;
    this.fileName = fileName;
  }

  @Override
  public void operateOn(Model image) {
    Pixel[][] pixels = image.getLibraryImagePixels(fileName);
    BufferedImage buffered = writeBuffered(pixels);
    File file = new File(imagePath);
    try {
      String type = imagePath.substring(imagePath.length() - 3); //make sure "-4" is correct
      ImageIO.write(buffered, type, file);
      System.out.println("Image Saved");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
