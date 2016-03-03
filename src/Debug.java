import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


import canvas.Canvas;




public class Debug {

	private static Explorer exp;
	private static ListListener nameList;
	public static Agence.Jeu jeu;

	public static void create() {
		JFrame mainFrame = new JFrame("Arbres");		
//		Container contentPane = mainFrame.getContentPane();
		
//		contentPane.setLayout(new FlowLayout());
		Box vbox = Box.createVerticalBox();
				
		final Canvas canvas = new Canvas(800, 300);
		exp = new Explorer(canvas);
	
		JScrollPane scrollPane = new JScrollPane(   canvas);

				scrollPane.setSize(800, 600);
		
		Box hbox = Box.createHorizontalBox();
		JButton button = new JButton("Zoom +");
		button.addActionListener(new AbstractAction(){

			public void actionPerformed(ActionEvent arg0) {
				canvas.multScale(1.2);				
			}
		}
		);
		hbox.add(button);
		button = new JButton("Normal");
		button.addActionListener(new AbstractAction(){

			public void actionPerformed(ActionEvent arg0) {
				canvas.setScale(1);				
			}
		}
		);
		hbox.add(button);

		button = new JButton("Zoom -");
		button.addActionListener(new AbstractAction(){

			public void actionPerformed(ActionEvent arg0) {
				canvas.multScale(0.8);				
			}
		}
		);
		hbox.add(button);
		
		hbox.add(Box.createGlue());
		
		hbox.add(new JLabel("S�lection "));
		

		nameList = new ListListener(exp);
//		canvas.set
		canvas.addSelectionListener(nameList);
		hbox.add(nameList);

		vbox.add(hbox);

/*		scrollPane.setBackground(Color.lightGray);
		canvas.setBackground(Color.lightGray);
		*/

		scrollPane.setBorder(BorderFactory.createTitledBorder("M�moire"));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		vbox.add(scrollPane);
		
		mainFrame.add(vbox);

		

		//mainFrame.setMinimumSize(new Dimension(800,800));
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
		

	public static void target(Agence.Jeu jeu) {
		Debug.jeu = jeu;
		exp.read(jeu,"jeu");
		exp.refresh();
		nameList.update();		
	}

	public static void update() {
		exp.read(jeu,"jeu");
		exp.refresh();
		nameList.update();	
	}

}
