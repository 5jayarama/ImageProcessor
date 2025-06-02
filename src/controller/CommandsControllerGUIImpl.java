package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.commands.Blue;
import controller.commands.Blur;
import controller.commands.Brighten;
import controller.commands.Green;
import controller.commands.Greyscale;
import controller.commands.HorizontalFlip;
import controller.commands.Intensity;
import controller.commands.Load;
import controller.commands.LoadPPM;
import controller.commands.Luma;
import controller.commands.Mosaic;
import controller.commands.Red;
import controller.commands.Save;
import controller.commands.SavePPM;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import controller.commands.Value;
import controller.commands.VerticalFlip;
import view.ImageProcessorGuiView;

/**
 * This is the GUI Controller that handles incoming requests and instructs the view and model.
 */
public class CommandsControllerGUIImpl implements ActionListener, GUIController {

  private ImageProcessorGuiView view;

  /**
   * This Implementation of the controller allows it to control the GUI through action events.
   *
   * @param view the view is what is outputted to the user
   */
  public CommandsControllerGUIImpl(ImageProcessorGuiView view) {
    this.view = view;
    this.view.setListeners(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JLabel inputDisplay;
    switch (e.getActionCommand()) {
      case "Load file":
        final JFileChooser fChooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, PNG, PPM, JPEG, & GIF Images",
                "jpg", "gif", "png", "ppm", "jpeg");
        fChooser.setFileFilter(filter);
        int retvalue = fChooser.showOpenDialog(null);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fChooser.getSelectedFile();
          view.setLoadText(f.getAbsolutePath());
          if (f.getAbsolutePath().endsWith("ppm")) {
            view.setFeatures(new LoadPPM(f.getAbsolutePath(),
                    "image"));
            view.makeImage("image");
          } else {
            view.setFeatures(new Load(f.getAbsolutePath(),
                    "image"));
            view.makeImage("image");
          }
        }
        break;
      case "Save file":
        System.out.println("here");
        final JFileChooser fchooser = new JFileChooser(".");
        int retValue = fchooser.showSaveDialog(null);
        if (retValue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          view.setSaveText(f.getAbsolutePath());
          if (f.getAbsolutePath().endsWith("ppm")) {
            view.setFeatures(new SavePPM(f.getAbsolutePath(),
                    "image"));
            view.operateSave();
          } else {
            view.setFeatures(new Save(f.getAbsolutePath(),
                    "image"));
            view.operateSave();
          }
        }
        break;
      case "Red":
        view.setRadioText("Greyscale-Red was selected");
        view.setFeatures(new Red("image", "image"));
        view.makeImage("image");
        break;
      case "Green":
        view.setRadioText("Greyscale-Green was selected");
        view.setFeatures(new Green("image", "image"));
        view.makeImage("image");
        break;
      case "Blue":
        view.setRadioText("Greyscale-Blue was selected");
        view.setFeatures(new Blue("image", "image"));
        view.makeImage("image");
        break;
      case "Brighten":
        view.setRadioText("Brighten was selected");
        inputDisplay = new JLabel();
        inputDisplay.setText(JOptionPane.showInputDialog("Please enter amount "
                + "to change brightness"));
        try {
          view.setFeatures(new Brighten(Integer.parseInt(inputDisplay.getText()),
                  "image", "image"));
        } catch (NumberFormatException eg) {
          JOptionPane.showMessageDialog(null,
                  "Must be an integer.", "No Number found",
                  JOptionPane.ERROR_MESSAGE);
        }
        view.makeImage("image");
        break;
      case "Value":
        view.setRadioText("Value was selected");
        view.setFeatures(new Value("image", "image"));
        view.makeImage("image");
        break;
      case "Intensity":
        view.setRadioText("Intensity was selected");
        view.setFeatures(new Intensity("image", "image"));
        view.makeImage("image");
        break;
      case "Luma":
        view.setRadioText("Luma was selected");
        view.setFeatures(new Luma("image", "image"));
        view.makeImage("image");
        break;
      case "Vertical":
        view.setRadioText("Vertical Flip was selected");
        view.setFeatures(new VerticalFlip("image", "image"));
        view.makeImage("image");
        break;
      case "Horizontal":
        view.setRadioText("Horizontal Flip was selected");
        view.setFeatures(new HorizontalFlip("image", "image"));
        view.makeImage("image");
        break;
      case "Greyscale":
        view.setRadioText("Greyscale was selected");
        view.setFeatures(new Greyscale("image", "image"));
        view.makeImage("image");
        break;
      case "Sepia":
        view.setRadioText("Sepia was selected");
        view.setFeatures(new Sepia("image", "image"));
        view.makeImage("image");
        break;
      case "Blur":
        view.setRadioText("Blur was selected");
        view.setFeatures(new Blur("image", "image"));
        view.makeImage("image");
        break;
      case "Sharpen":
        view.setRadioText("Sharpen was selected");
        view.setFeatures(new Sharpen("image", "image"));
        view.makeImage("image");
        break;
      case "Mosaic":
        view.setRadioText("Mosaic was selected");
        inputDisplay = new JLabel();
        inputDisplay.setText(JOptionPane.showInputDialog("Enter number of seeds to generate: "));
        try {
          view.setFeatures(new Mosaic(Integer.parseInt(inputDisplay.getText()),
                  "image", "image"));
        } catch (NumberFormatException eg) {
          JOptionPane.showMessageDialog(null,
                  "Must be an integer.", "No Number found",
                  JOptionPane.ERROR_MESSAGE);
        }
        view.makeImage("image");
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
    }
  }
}
