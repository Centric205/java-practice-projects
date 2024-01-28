
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  Flow {
	static long startTime = 0;
	static int frameX;
	static int frameY;
	static FlowPanel fp;

	// start timer
	private static void tick(){
		startTime = System.currentTimeMillis();
	}
	
	// stop timer, return time elapsed in seconds
	private static float tock(){
		return (System.currentTimeMillis() - startTime) / 1000.0f; 
	}
	
	public static void setupGUI(int frameX,int frameY,Terrain landdata) {
		
		Dimension fsize = new Dimension(800, 800);
    	JFrame frame = new JFrame("Waterflow"); 
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().setLayout(new BorderLayout());
    	
      	JPanel g = new JPanel();
        g.setLayout(new BoxLayout(g, BoxLayout.PAGE_AXIS));
   
		fp = new FlowPanel(landdata);
		fp.setPreferredSize(new Dimension(frameX,frameY));
		g.add(fp);


		// to do: add a MouseListener, buttons and ActionListeners on those buttons
		JTextArea textArea = new JTextArea(1,3);
		//TextArea textArea = new TextArea(1,3);
		textArea.setFont(new Font("TimesRoman",Font.BOLD,15));
		textArea.setText("Hey there");
		textArea.setBackground(Color.GRAY);
		textArea.setMargin(new Insets(3,3,3,3));
	//	JScrollPane scrollPane = new JScrollPane(textArea);
	//	scrollPane.setPreferredSize(new Dimension(10,1));
	//	scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel label = new JLabel("COUNTER");
		label.setFont(new Font("TimesRoman",Font.BOLD,15));

		JPanel b = new JPanel();
	    b.setLayout(new BoxLayout(b, BoxLayout.LINE_AXIS));

	    JButton resetB = new JButton("Reset");
	    JButton pauseB = new JButton("Pause");
	    JButton playB = new JButton("Play");
		JButton endB = new JButton("End");

		// add the listener to the jbutton to handle the "pressed" event

        playB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new Water()).simualtion();
            }
        });

		resetB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// clears picture
				landdata.createEmptyImage();
			}
		});



		// end Button
		endB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// to do ask threads to stop
				frame.dispose();
			}
		});

		// add buttons to the Frame's panel.
		b.add(Box.createRigidArea(new Dimension(5,0)));
		b.add(resetB);
		b.add(Box.createRigidArea(new Dimension(5,0)));
		b.add(pauseB);
		b.add(Box.createRigidArea(new Dimension(5,0)));
		b.add(playB);
		b.add(Box.createRigidArea(new Dimension(5,0)));
		b.add(endB);
		b.add(Box.createRigidArea(new Dimension(5,0)));
		b.add(label);
		b.add(Box.createRigidArea(new Dimension(5,0)));
		//b.add(scrollPane);
		b.add(textArea);
		b.add(Box.createRigidArea(new Dimension(10,0)));

		g.add(b);
    	
		frame.setSize(frameX, frameY+50);	// a little extra space at the bottom for buttons
      	frame.setLocationRelativeTo(null);  // center window on screen
      	frame.add(g); //add contents to window
        frame.setContentPane(g);
        frame.setVisible(true);
        Thread fpt = new Thread(fp);
        fpt.start();
	}
	
		
	public static void main(String[] args) {
		Terrain landdata = new Terrain();
		Water waterdata = new Water();
		
		// check that number of command line arguments is correct
//		if(args.length != 1)
//		{
//			System.out.println("Incorrect number of command line arguments. Should have form: java -jar flow.java intputfilename");
//			System.exit(0);
//		}
				
		// landscape information from file supplied as argument
		// 
		landdata.readData("medsample_in.txt");
		waterdata.readData("medsample_in.txt");
		
		frameX = landdata.getDimX();
		frameY = landdata.getDimY();
		SwingUtilities.invokeLater(()->setupGUI(frameX, frameY, landdata));
		
		// to do: initialise and start simulation
	}
}
