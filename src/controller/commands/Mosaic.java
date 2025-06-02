package controller.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.Commands;
import model.Model;
import model.Pixel;
import model.Seed;

/**
 * Represents a Mosaic filter.
 */
public class Mosaic extends AbstractCommand implements Commands {
  private String oldImageName;
  private String newImageName;
  private int numSeeds;
  private List<Seed> seeds;
  private Random rand;

  /**
   * Constructs a mosaic filter with a given number of seeds and the names of the old and
   * new images.
   * @param numSeeds the given number of seeds
   * @param oldImageName the name of the old image
   * @param newImageName the name of the new image
   */
  public Mosaic(int numSeeds, String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
    this.numSeeds = numSeeds;
    this.seeds = new ArrayList<>();
    this.rand = new Random();
  }

  /**
   * Constructs a mosaic filter with a given number of seeds and the names of the old and
   * new images.
   * @param numSeeds the given number of seeds
   * @param oldImageName the name of the old image
   * @param newImageName the name of the new image
   */
  public Mosaic(int randSeed, int numSeeds, String oldImageName, String newImageName) {
    this.oldImageName = oldImageName;
    this.newImageName = newImageName;
    this.numSeeds = numSeeds;
    this.seeds = new ArrayList<>();
    this.rand = new Random(randSeed);
  }

  /**
   * Gets the cluster average color and sets this pixel color to the cluster's color.
   * @param pixel The pixel that you want to get the values from.
   * @return the new Pixel
   */
  @Override
  public Pixel colorSetter(Pixel pixel) {
    int[] avgColor = null;
    for (Seed s : seeds) {
      if (s.pixelInCluster(pixel)) {
        avgColor = s.getAverageColor();
      }
    }

    int redVal = 0;
    int blueVal = 0;
    int greenVal = 0;
    if (avgColor != null) {
      redVal = avgColor[0];
      greenVal = avgColor[1];
      blueVal = avgColor[2];
    }

    return new Pixel(pixel.getRow(), pixel.getCol(), redVal, greenVal, blueVal);
  }

  /**
   * Performs the desired operation(mosaic) on the image.
   * @param image represents the image that is being operated on.
   */
  @Override
  public void operateOn(Model image) {
    int width = image.width(oldImageName);
    int height = image.height(oldImageName);
    System.out.println(width);
    System.out.println(height);
    // array of every width and height
    int[] widths = new int[numSeeds];
    int[] heights = new int[numSeeds];
    // choose a set of random pixels to create a list of seeds
    for (int i = 0; i < numSeeds; i++) {
      widths[i] = rand.nextInt(width);
      heights[i] = rand.nextInt(height);
      // count each time previous sets of (x,y) are equal to this (x,y)
      int count = 0;
      for (int j = 0; j < i; j++) {
        if (widths[j] == widths[i] && heights[j] == heights[i]) {
          count++;
        }
      }
      // if any previous set is equal to this set, do not make seed, do not increment i.
      // otherwise add seed to list, and increment i.
      if (count == 0) {
        seeds.add(new Seed(heights[i], widths[i]));
      }
      else {
        i--;
      }
    }
    // assigns the closest seed to the designated cluster
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        Pixel p = image.getPixelAt(oldImageName, r, c);
        int minDist = Integer.MAX_VALUE;
        Seed closestSeed = null;
        for (Seed s : seeds) {
          int dist = s.getDist(p);
          //System.out.println("Dist: " + dist);
          if (dist < minDist) {
            minDist = dist;
            closestSeed = s;
          }
        }
        if (closestSeed != null) {
          closestSeed.addToCluster(p);
        }
      }
    }
    componentChanger(image, oldImageName, newImageName);
  }
}
