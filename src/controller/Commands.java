package controller;

import model.Model;

/**
 * This interface handles the operateOn() command, and is implemented by command objects.
 */
public interface Commands {

  /**
   * This method executes, or operates on, the given model. It is operating on the model by
   * implementing one of the given commands inputted by the user.
   * @param image represents the image that is being operated on.
   */
  void operateOn(Model image);
}
