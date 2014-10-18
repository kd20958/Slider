import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

class Slider extends JFrame implements  ChangeListener {
	private	JSlider	scrollerR;
	private	JSlider scrollerG;
	private	JSlider scrollerB;
    private JLabel labelR;
    private JLabel labelG;
    private JLabel labelB;
    private JLabel labelColor;
    private JPanel topPanel;
    private JPanel textPanel;


	public Slider() {
		setTitle("Slider"); //set panel info
		setSize(300, 200);
		setBackground(Color.gray);
		
		labelColor = new JLabel("Color"); // set color panel info
		labelColor.setOpaque(true);
		labelColor.setForeground(new Color(0, 0, 0));
		add(labelColor, BorderLayout.CENTER);

		topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setDoubleBuffered(false);

		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(3,2));
		add(topPanel, BorderLayout.SOUTH);
		
		// Create the labels and sliders
		labelR = new JLabel("Red");
		labelR.setBounds(20, 15, 250, 20);
		topPanel.add(labelR);
		
		scrollerR = new JSlider(SwingConstants.HORIZONTAL,0, 255, 0 );
		scrollerR.setBounds(0, 15, 290, 40);
		scrollerR.setPaintLabels(true);
		scrollerR.addChangeListener(this);
        topPanel.add(scrollerR);

		labelG = new JLabel("Green");
		labelG.setBounds(20, 75, 250, 20);
		topPanel.add(labelG);
		
		scrollerG = new JSlider(SwingConstants.HORIZONTAL,0, 255, 0);
		scrollerG.setBounds(20, 95, 290, 40);
		scrollerG.setPaintLabels(true);
		scrollerG.addChangeListener(this);
        topPanel.add(scrollerG);

		labelB = new JLabel( "Blue" );
		labelB.setBounds(20, 135, 250, 20);
		topPanel.add( labelB );

		scrollerB = new JSlider(SwingConstants.HORIZONTAL,0, 255, 0);
		scrollerB.setBounds(20, 155, 290, 40);
		scrollerB.setPaintLabels(true);
		scrollerB.addChangeListener(this);
        topPanel.add(scrollerB);
	}

	public void stateChanged(ChangeEvent event) {
		if( event.getSource() == scrollerR || event.getSource() == scrollerG || event.getSource() == scrollerB ) {
			// Get the current color settings
			int iRed = scrollerR.getValue();
			int iGreen = scrollerG.getValue();
			int iBlue = scrollerB.getValue();

			labelColor.setForeground(new Color(iRed,iGreen,iBlue));
		}
	}
	
	public static void main(String args[]) {
		Slider mainFrame = new Slider();
		mainFrame.setVisible(true);
	}

	
}