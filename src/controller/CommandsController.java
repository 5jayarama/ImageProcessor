package controller;

import java.util.Scanner;

import controller.commands.Blur;
import controller.commands.Greyscale;
import controller.commands.LoadPPM;
import controller.commands.Mosaic;
import controller.commands.Save;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import model.ImageModel;
import controller.commands.Blue;
import controller.commands.Brighten;
import controller.commands.Green;
import controller.commands.HorizontalFlip;
import controller.commands.Intensity;
import controller.commands.Load;
import controller.commands.Luma;
import controller.commands.Red;
import controller.commands.SavePPM;
import controller.commands.Value;
import controller.commands.VerticalFlip;
import utils.ImageUtil;


/**
 * The main of the program, allows the user to perform commands on ImageModel objects.
 */
public class CommandsController extends ImageUtil {
  /**
   * This main method runs and scans for commands. It then handles the inputs accordingly.
   * @param args represent the arguments the user is inputing. These include the command,
   *             image model, file name and file path.
   */
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Commands cmd;
    ImageModel m = new ImageModel();
    System.out.println("Enter Command: ");
    while (s.hasNext()) {
      String in = s.next().toLowerCase();
      try {
        switch (in) {
          case "q":
          case "quit":
            return;
          case "load":
            cmd = new Load(s.next(),s.next());
            break;
          case "load-ppm":
            cmd = new LoadPPM(s.next(),s.next());
            break;
          case "save-ppm":
            cmd = new SavePPM(s.next(),s.next());
            break;
          case "save":
            cmd = new Save(s.next(),s.next());
            System.out.println("Image Saved");
            break;
          case "red-component":
            cmd = new Red(s.next(), s.next());
            break;
          case "blue-component":
            cmd = new Blue(s.next(), s.next());
            break;
          case "green-component":
            cmd = new Green(s.next(), s.next());
            break;
          case "value-component":
            cmd = new Value(s.next(), s.next());
            break;
          case "luma-component":
            cmd = new Luma(s.next(), s.next());
            break;
          case "intensity-component":
            cmd = new Intensity(s.next(), s.next());
            break;
          case "brighten":
            cmd = new Brighten(Integer.parseInt(s.next()),
                    s.next(), s.next());
            break;
          case "horizontal-flip":
            cmd = new HorizontalFlip(s.next(), s.next());
            break;
          case "vertical-flip":
            cmd = new VerticalFlip(s.next(), s.next());
            break;
          case "blur":
            cmd = new Blur(s.next(), s.next());
            System.out.println("Blurred Image Created");
            break;
          case "sharpen":
            cmd = new Sharpen(s.next(), s.next());
            System.out.println("Sharpened Image Created");
            break;
          case "greyscale":
            cmd = new Greyscale(s.next(), s.next());
            break;
          case "sepia":
            cmd = new Sepia(s.next(), s.next());
            break;
          case "mosaic":
            cmd = new Mosaic(Integer.parseInt(s.next()), s.next(), s.next());
            System.out.println("Mosaic Image Created");
            break;
          default:
            System.out.println(String.format("Unknown command %s", in));
            cmd = null;
            m = null;
            break;
        }
        if (cmd != null) {
          cmd.operateOn(m);
        }
      }
      catch (IllegalArgumentException ime) { // make sure we need this
        System.out.println("Illegal" + in);
      }
    }
  }
}
