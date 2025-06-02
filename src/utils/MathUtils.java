package utils;

/**
 * A Utilities Class for math functions.
 */
public class MathUtils {

  /**
   * The Logic for 3x3 x 1x3 matrix multiplication.
   * @param matrix array of doubles containing the numbers to multiply by
   * @param rgb array of doubles containing the pixels rgb values
   * @return an array of doubles containing the new RGB values for the new pixel
   */
  public static double[][] matrixMulti(double[][] matrix, double[][] rgb) {
    double[][] newRGBArray = new double[0][];
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        double red = matrix[0][0] * rgb[0][0] +  matrix[0][1] * rgb[1][0]
                + matrix[0][2] * rgb[2][0];
        double green = matrix[1][0] * rgb[0][0] +  matrix[1][1] * rgb[1][0]
                + matrix[1][2] * rgb[2][0];
        double blue = matrix[2][0] * rgb[0][0] +  matrix[2][1] * rgb[1][0]
                + matrix[2][2] * rgb[2][0];
        newRGBArray = new double[][]{ {red}, {green}, {blue}};
      }
    }
    return newRGBArray;
  }
}
