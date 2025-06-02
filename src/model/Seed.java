package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a seed, which is a random pixel in an image with an associated cluster
 * of nearby pixels.
 */
public class Seed {
  Set<Pixel> cluster;
  int[] averageColor;
  int row;
  int col;

  /**
   * Constructs a new seed with a given row and column.
   * @param row the given row
   * @param col the given column
   */
  public Seed(int row, int col) {
    this.cluster = new HashSet<>();
    this.row = row;
    this.col = col;
    this.averageColor = null;
  }

  /**
   * Adds a pixel to this seed's cluster.
   * @param pixel the pixel to add
   */
  public void addToCluster(Pixel pixel) {
    this.cluster.add(pixel);
  }

  /**
   * Return true if pixel is contained in this cluster.
   * @param p the given pixel
   * @return true if cluster contains pixel
   */
  public boolean pixelInCluster(Pixel p) {
    return this.cluster.contains(p);
  }

  /**
   * Calculates the distance between this seed and the given pixel.
   * @param p the given pixel
   * @return the distance between the seed and pixel
   */
  public int getDist(Pixel p) {
    int dRow = this.row - p.getRow();
    int dCol = this.col - p.getCol();
    return dRow * dRow + dCol * dCol;
  }

  /**
   * Calculates the average color in this seed's cluster.
   * @return the average color of the cluster
   */
  public int[] getAverageColor() {
    if (averageColor == null) {
      averageColor = new int[3];
      for (Pixel p : cluster) {
        averageColor[0] += p.getRed();
        averageColor[1] += p.getGreen();
        averageColor[2] += p.getBlue();
      }
      averageColor[0] /= cluster.size();
      averageColor[1] /= cluster.size();
      averageColor[2] /= cluster.size();
    }
    return averageColor;
  }
}
