package utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import model.Pixel;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  private static Pixel[][] pixels;

  /**
   * Reads an image and returns the pixel map.
   *
   * @param filename the path to the file
   * @return an array of pixels
   */
  public static Pixel[][] readImage(String filename) {
    try {
      BufferedImage image = ImageIO.read(new FileInputStream(filename));
      int height = image.getHeight();
      int width = image.getWidth();
      Pixel[][] array = new Pixel[width][height];

      for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
          int color = image.getRGB(col, row);
          int blue = color & 0xff;
          int green = (color & 0xff00) >> 8;
          int red = (color & 0xff0000) >> 16;
          array[col][row] = new Pixel(row, col, red, green, blue);
        }
      }
      return array;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Works the same as the other readImage but takes in a BufferedImage.
   * @param image a buffered image
   * @return a pixel array
   */
  public static Pixel[][] readImage(BufferedImage image) {
    int height = image.getHeight();
    int width = image.getWidth();
    Pixel[][] array = new Pixel[width][height];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        int color = image.getRGB(col, row);
        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        array[col][row] = new Pixel(row, col, red, green, blue);
      }
    }
    return array;
  }

  /**
   * Writes a buffered image from a pixel array.
   * @param pixels an array of pixels
   * @return a buffered image with the picture
   */
  public static BufferedImage writeBuffered(Pixel[][] pixels) {
    ImageUtil.pixels = pixels;
    BufferedImage image = new BufferedImage(pixels.length, pixels[0].length,
            BufferedImage.TYPE_INT_RGB);
    for (int row = 0; row < pixels[0].length; row++) {
      for (int col = 0; col < pixels.length; col++) {
        int r = pixels[col][row].getRed();
        int g = pixels[col][row].getGreen();
        int b = pixels[col][row].getBlue();
        int p = (r << 16) | (g << 8) | b;
        image.setRGB(col, row, p);
      }
    }
    return image;
  }

  /**
   * Read an image file and format it into a Pixel[][].
   *
   * @param filename the path of the file.
   */
  public static Pixel[][] readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filename + " not found!");
      return null;

    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    Pixel[][] array = new Pixel[width][height];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        array[col][row] = new Pixel(row, col, r, g, b);

      }
    }
    return array;
  }

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static String readPPMAsString(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      return ("File " + filename + " not found!");

    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    System.out.println("Width of image: " + width);
    int height = sc.nextInt();
    System.out.println("Height of image: " + height);
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Color of pixel (" + j + "," + i + "): " + r + "," + g + "," + b);
      }
    }
    return builder.toString();
  }
}