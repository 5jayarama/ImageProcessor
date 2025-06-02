package model;


import java.util.Objects;

/**
 * Pixels are individual units that contain an rbg.
 */
public class Pixel {
  private int row;
  private int col;
  private int red;
  private int blue;
  private int green;


  /**
   * This constructor represents the rgb values of the pixel.
   * @param red   represents the red value of the pixel.
   * @param green represents the green value.
   * @param blue  represents the blue value.
   * @param row represents the pixel row.
   * @param col  represents the pixel col.
   */
  public Pixel(int row, int col, int red, int green, int blue) { // cap values somehow
    if (red <= 255) {
      if (red >= 0) {
        this.red = red;
      } else {
        this.red = 255;
      }
    } else {
      this.red = 0;
    }
    if (green <= 255) {
      if (green >= 0) {
        this.green = green;
      } else {
        this.green = 255;
      }
    } else {
      this.green = 0;
    }
    if (blue <= 255) {
      if (blue >= 0) {
        this.blue = blue;
      } else {
        this.blue = 255;
      }
    } else {
      this.blue = 0;
    }

    this.row = row;
    this.col = col;
  }

  /**
   * Get this pixel red.
   * @return this red
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Get this pixel blue.
   * @return this blue
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * Get this pixel green.
   * @return this green
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Get the max value of the pixel components.
   * @return the max value of the pixel components
   */
  public int getValue() {
    return Math.max(Math.max(this.red, this.blue), this.green);
  }

  /**
   * Get the average value of the pixel components.
   * @return the average value of the pixel components
   */
  public int intensity() {
    return ((this.red + this.blue + this.green) / 3);
  }

  public int getLuma() { // typecasting is used to turn luna double to a usable int
    return (int)((0.2126 * this.red) + (0.7152 * this.green) + (0.0722 * this.blue));
  }

  /**
   * Get the average value of the pixel components.
   * @return the average value of the pixel components
   */
  public int getPixelValAvg() {
    return (this.red + this.green + this.blue) / 3;
  }

  /**
   * Get this pixel row.
   * @return this row
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Get this pixel col.
   * @return this col
   */
  public int getCol() {
    return this.col;
  }

  /**
   * Checks if two not null objects are equal.
   * @param o the given object.
   * @return true if objects are not null and equal.
   */
  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }

    if (! (o instanceof Pixel)) {
      return false;
    }

    Pixel p = (Pixel) o;

    return p.getRow() == this.row && p.getCol() == this.col;
  }

  /**
   * Produce the hashcode of the pixel row and column.
   * @return the hashcode of the pixel row and column
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.row, this.col);
  }
}
