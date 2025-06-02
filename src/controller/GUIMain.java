package controller;

import javax.swing.JFrame;
import model.ImageModel;
import model.Model;
import view.SwingGuiView;

/**
 * The class that holds the Main to run the GUI.
 */
public class GUIMain {


  /**
   * Runs the GUI display.
   * @param args the inputs to the main.
   */
  public static void main(String[] args) {
    Model model = new ImageModel();
    SwingGuiView.setDefaultLookAndFeelDecorated(false);
    SwingGuiView frame = new SwingGuiView(model);
    GUIController controller = new CommandsControllerGUIImpl( frame);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}

