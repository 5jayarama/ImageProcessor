package view;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import controller.Commands;
import controller.GUIController;
import model.Model;

import static utils.ImageUtil.writeBuffered;


/**
 * This class represents a GUI view that is implemented using Java
 * Swing.
 */
public class SwingGuiView extends JFrame implements ImageProcessorGuiView {

  private Model model;
  private Commands features;
  private JPanel imagePanel;
  private final JPanel leftPanel;
  private JScrollPane imageScrollPane;
  private JLabel fileOpenDisplay;
  private JLabel fileSaveDisplay;
  private JLabel radioDisplay;
  private JLabel imageLabel;
  private JRadioButton[] radioButtons;
  private JButton fileSaveButton;
  private JButton fileOpenButton;


  /**
   * This class represents our SwingGuiView for our Image Processor.
   * @param model yes, this is a model
   */
  public SwingGuiView(Model model) {
    super();
    this.model = model;
    setTitle("Image Processor");
    setSize(1450, 1000);
    JPanel mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new GridLayout(1, 2));
    //scroll bars around this main panel

    //Image Panel
    imagePanel = new JPanel();
    leftPanel = new JPanel();
    mainPanel.add(leftPanel);
    imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(500, 500));
    imagePanel.add(imageScrollPane);


    JScrollPane mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);


    // Options Panel
    JPanel optionsPanel = new JPanel();
    optionsPanel.setLayout(new GridLayout(3, 1));


    // Load
    JPanel loadPanel = new JPanel();
    loadPanel.setLayout(new BoxLayout(loadPanel, BoxLayout.X_AXIS));
    JPanel fileOpenPanel = new JPanel();
    fileOpenPanel.setLayout(new FlowLayout());
    optionsPanel.add(loadPanel); // add load panel to options panel
    loadPanel.add(fileOpenPanel); // add file opener to load panel
    fileOpenButton = new JButton("Load a file");
    fileOpenButton.setActionCommand("Load file");
    fileOpenPanel.add(fileOpenButton);
    fileOpenDisplay = new JLabel();
    fileOpenPanel.add(fileOpenDisplay);

    //radio buttons
    JPanel radioPanel = new JPanel();
    radioPanel.setBorder(BorderFactory.createTitledBorder("Radio buttons"));
    radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.PAGE_AXIS));

    //buttons groups are used to combine radio buttons. Only one radio
    // button in each group can be selected.
    ButtonGroup rGroup1 = new ButtonGroup();
    radioButtons = new JRadioButton[14];

    radioButtons[0] = new JRadioButton("Greyscale: Red-Component");
    radioButtons[0].setActionCommand("Red");
    radioButtons[1] = new JRadioButton("Greyscale: Green-Component");
    radioButtons[1].setActionCommand("Green");
    radioButtons[2] = new JRadioButton("Greyscale: Blue-Component");
    radioButtons[2].setActionCommand("Blue");
    radioButtons[3] = new JRadioButton("Brighten"); // add options to change amount
    radioButtons[3].setActionCommand("Brighten");
    radioButtons[4] = new JRadioButton("Value");
    radioButtons[4].setActionCommand("Value");
    radioButtons[5] = new JRadioButton("Intensity");
    radioButtons[5].setActionCommand("Intensity");
    radioButtons[6] = new JRadioButton("Luma");
    radioButtons[6].setActionCommand("Luma");
    radioButtons[7] = new JRadioButton("Horizontal Flip");
    radioButtons[7].setActionCommand("Horizontal");
    radioButtons[8] = new JRadioButton("Vertical Flip");
    radioButtons[8].setActionCommand("Vertical");
    radioButtons[9] = new JRadioButton("Greyscale Filter");
    radioButtons[9].setActionCommand("Greyscale");
    radioButtons[10] = new JRadioButton("Sepia Filter");
    radioButtons[10].setActionCommand("Sepia");
    radioButtons[11] = new JRadioButton("Blur");
    radioButtons[11].setActionCommand("Blur");
    radioButtons[12] = new JRadioButton("Sharpen");
    radioButtons[12].setActionCommand("Sharpen");
    radioButtons[13] = new JRadioButton("Mosaic");
    radioButtons[13].setActionCommand("Mosaic");
    for (int i = 0; i < 14; i++) {
      rGroup1.add(radioButtons[i]);
      radioPanel.add(radioButtons[i]);
    }

    radioDisplay = new JLabel("Select an option:");
    radioPanel.add(radioDisplay);
    optionsPanel.add(radioPanel);
    mainPanel.add(optionsPanel);

    //file save
    JPanel filesavePanel = new JPanel();
    filesavePanel.setLayout(new FlowLayout());
    optionsPanel.add(filesavePanel);
    fileSaveButton = new JButton("Save a file");
    fileSaveButton.setActionCommand("Save file");
    filesavePanel.add(fileSaveButton);
    fileSaveDisplay = new JLabel("File path will appear here");
    filesavePanel.add(fileSaveDisplay);
  }

  @Override
  public void setFeatures(Commands features) {
    this.features = features;
  }

  @Override
  public void makeImage(String name) {
    leftPanel.removeAll();
    features.operateOn(model);
    BufferedImage buffered = writeBuffered((model.getLibraryImagePixels("image")));
    imageLabel = new JLabel();
    imageLabel.setIcon(new ImageIcon(buffered));
    imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(500, 500));
    imagePanel.add(imageScrollPane);
    leftPanel.add(imageLabel);
    imageLabel.setVisible(false);
    imageLabel.setVisible(true);
  }


  @Override
  public void setRadioText(String text) {
    radioDisplay.setText(text);
  }

  @Override
  public void setLoadText(String text) {
    fileOpenDisplay.setText(text);
  }

  @Override
  public void setSaveText(String text) {
    fileSaveDisplay.setText(text);
  }

  @Override
  public void operateSave() {
    features.operateOn(model);
  }

  @Override
  public void setListeners(GUIController controller) {
    fileOpenButton.addActionListener(controller);
    fileSaveButton.addActionListener(controller);
    radioButtons[0].addActionListener(controller);
    radioButtons[1].addActionListener(controller);
    radioButtons[2].addActionListener(controller);
    radioButtons[3].addActionListener(controller);
    radioButtons[4].addActionListener(controller);
    radioButtons[5].addActionListener(controller);
    radioButtons[6].addActionListener(controller);
    radioButtons[7].addActionListener(controller);
    radioButtons[8].addActionListener(controller);
    radioButtons[9].addActionListener(controller);
    radioButtons[10].addActionListener(controller);
    radioButtons[11].addActionListener(controller);
    radioButtons[12].addActionListener(controller);
    radioButtons[13].addActionListener(controller);
  }

  @Override
  public void refresh() {
    imagePanel.repaint();
    this.repaint();
  }
}

