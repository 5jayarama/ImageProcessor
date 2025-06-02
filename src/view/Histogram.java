package view;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import model.Model;
import model.Pixel;

/**
 * This class represents our Histogram of the current image.
 */
public class Histogram extends JPanel {

  private Map<Integer, Integer> redVals;
  private Map<Integer, Integer> greenVals;
  private Map<Integer, Integer> blueVals;

  /**
   * The histogram object.
   * @param model Takes in the model so it can reference the image being used.
   */
  public Histogram(Model model) {
    this.redVals = new HashMap<Integer, Integer>();
    this.greenVals = new HashMap<Integer, Integer>();
    this.blueVals = new HashMap<Integer, Integer>();

    for (int i = 0; i < 255; i++) {

      Pixel[][] pixels = model.getLibraryImagePixels("image");
      this.redVals.put(i, 0);

      for (int x = 0; x < pixels.length; x++) {
        for (int y = 0; y < pixels[0].length; y++) {
          Integer k = this.redVals.replace(model.getPixelAt("image", y, x).getRed(),
                  redVals.get(model.getPixelAt("image", y, x).getRed() + 1));
          this.redVals.put(i, k);
        }
      }
    }
    for (int i = 0; i < 255; i++) {
      this.greenVals.put(i, 0);
      Pixel[][] pixels = model.getLibraryImagePixels("image");
      for (int x = 0; x < pixels.length; x++) {
        for (int y = 0; y < pixels[0].length; y++) {
          Integer k = this.greenVals.replace(model.getPixelAt("image", y, x).getGreen(),
                  greenVals.get(model.getPixelAt("image", y, x).getGreen() + 1));
          this.greenVals.put(i, k);
        }
      }
    }
    for (int i = 0; i < 255; i++) {
      this.blueVals.put(i, 0);
      Pixel[][] pixels = model.getLibraryImagePixels("image");
      for (int x = 0; x < pixels.length; x++) {
        for (int y = 0; y < pixels[0].length; y++) {
          Integer k = this.blueVals.replace(model.getPixelAt("image", y, x).getBlue(),
                  blueVals.get(model.getPixelAt("image", y, x).getBlue() + 1));
          this.blueVals.put(i, k);
        }
      }
    }
  }

  //takes in values?
  private int getMax() {
    int max = 0;
    for (Integer redVals : redVals.values()) {
      if (redVals > max) {
        max = redVals;
      }
    }

    for (Integer greenVals : greenVals.values()) {
      if (greenVals > max) {
        max = greenVals;

      }
    }
    for (Integer blueVals : blueVals.values()) {
      if (blueVals > max) {
        max = blueVals;
      }
    }
    return max;
  }


  /**
   * Paints an individual component for the red, green, and blue histograms.
   * @param g the <code>Graphics</code> object to protect the Graphic it takes in.
   */
  //second value in map is height
  public void paintComponent(Graphics g) {
    super.paintComponents(g);

    for (Map.Entry<Integer, Integer> vals : this.redVals.entrySet()) {
      g.fillRect(30 + vals.getKey(), this.getMax() - vals.getValue(),
              1, vals.getValue());
    }
    for (Map.Entry<Integer, Integer> vals : this.greenVals.entrySet()) {
      g.fillRect(30 + vals.getKey(), this.getMax() - vals.getValue(),
              1, vals.getValue());
    }
    for (Map.Entry<Integer, Integer> vals : this.blueVals.entrySet()) {
      g.fillRect(30 + vals.getKey(), this.getMax() - vals.getValue(),
              1, vals.getValue());
    }
  }


}
