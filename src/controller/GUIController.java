package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface that contains the Controller for the GUI display.
 */
public interface GUIController extends ActionListener {

  /**
   * Takes in an event and performs the associated action.
   * @param e the event to be processed
   */
  void actionPerformed(ActionEvent e);
}
