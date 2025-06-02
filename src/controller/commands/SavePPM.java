package controller.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import controller.Commands;
import model.Model;
import model.Pixel;


/**
 * Class contains the command object SavePPM that takes the image and
 * saves it to a user specified location.
 */
public class SavePPM implements Commands {

  private String imagePath;
  private String fileName;

  /**
   * This constructor is used so that we can allow the user to choose where the image is saved to.
   *
   * @param imagePath where the user wants the image saved
   */
  public SavePPM(String imagePath, String fileName) {
    this.imagePath = imagePath;
    this.fileName = fileName;
  }

  @Override
  public void operateOn(Model image) {
    Appendable builder = new StringBuilder();
    int width = image.width(fileName);
    int height = image.height(fileName);
    try {
      builder.append("P3\n" + width + " " + height + "\n255\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    for (int row = 0; row < image.height(fileName); row++) {
      for (int col = 0; col < image.width(fileName); col++) {
        Pixel p = image.getPixelAt(fileName, row, col);
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();
        try {
          builder.append(r + " \n" + g + " \n" + b + " \n");
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
    try {
      Files.writeString(Path.of(imagePath), builder.toString());
      System.out.println("Image Saved");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}