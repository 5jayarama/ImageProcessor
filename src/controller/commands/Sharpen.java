package controller.commands;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import controller.Commands;
import model.Model;
import model.Pixel;

import static utils.ImageUtil.readImage;
import static utils.ImageUtil.writeBuffered;

/**
 * The Sharpen class represents the function object for the Sharpen command and applys
 * the sharpen filter to the desired image.
 */
public class Sharpen extends AbstractCommand implements Commands {

  String refName;
  String newName;

  public Sharpen(String refName, String newName) {
    this.refName = refName;
    this.newName = newName;
  }

  @Override
  public void operateOn(Model image) {
    BufferedImage bufferedImage = writeBuffered(image.getLibraryImagePixels(refName));
    Kernel sharpenFilter = new Kernel(3, 3,
            new float[]{-0.125f, -0.125f, -0.125f, -0.125f, -0.125f,
                        -0.125f, 0.25f, 0.25f, 0.25f, -0.125f,
                        -0.125f, 0.25f, 1.0f, 0.25f, -0.125f,
                        -0.125f, 0.25f, 0.25f, 0.25f, -0.125f,
                        -0.125f, -0.125f, -0.125f, -0.125f, -0.125f});
    ConvolveOp cop =
            new ConvolveOp(sharpenFilter, ConvolveOp.EDGE_NO_OP, null);
    BufferedImage newBufferedImage = cop.filter(bufferedImage, null);
    Pixel[][] pixels = readImage(newBufferedImage);
    image.insert(newName, pixels);
  }
}