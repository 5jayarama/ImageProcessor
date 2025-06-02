package view;

import controller.Commands;
import controller.GUIController;

/**
 * This interface represents a GUI view for the game of marble solitaire.
 */
public interface ImageProcessorGuiView {
  /**
   * Refresh the screen. This is called when the something on the
   * screen is updated and therefore it must be redrawn.
   */
  void refresh();

  void setFeatures(Commands controller);

  void setListeners(GUIController controller);

  void makeImage(String name);

  void setRadioText(String text);

  void setLoadText(String text);

  void setSaveText(String text);

  void operateSave();
}
