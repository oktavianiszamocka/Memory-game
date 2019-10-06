package project2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MemoryGame extends JFrame
{
	GridBagConstraints c;
	
	MemoryGame ()
	{
		super();
		setTitle("Memory Game");
		setSize(650, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1));

		head();
		Button();
		
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
	void head()
	{
		JLabel welcome = new JLabel("<html><center>Wonderful Indonesia Memory Game<br/>S17874</html>", SwingConstants.CENTER);
		
		welcome.setFont(new Font("Calibri", Font.BOLD, 28));
		welcome.setForeground(Color.BLUE);
		ImageIcon i = new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\6.jpg");
		JLabel pic = new JLabel(i);
		pic.setPreferredSize(new Dimension(200,150));
		add(welcome);
		
		add(pic);	
	}
	
	void Button()
	{
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();	//spesify constaints for gridbaglayout
		
		JButton n1 = new JButton("New Game");
		n1.setPreferredSize(new Dimension(100,30));
		c.gridx = 0;
		c.gridy = 1;
		c.insets= new Insets(5,10,10,10); //padding
		n1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) {	
						NewGame n = new NewGame();
						n.setVisible(true);
					}
				});
		p.add(n1, c);
		
		JButton n2 = new JButton("High Score");
		n2.setPreferredSize(new Dimension(100,30));
		c.gridx = 0;
		c.gridy = 2;
		c.insets= new Insets(5,10,10,10);
		n2.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						ScoreBoard sb = new ScoreBoard();
						
					}
				}
			);
		
		p.add(n2,c);
		
		JButton n3 = new JButton("Exit");
		n3.setPreferredSize(new Dimension(100,30));
		c.gridx = 0;
		c.gridy = 3;
		c.insets= new Insets(5,10,10,10);
		n3.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						System.exit(0); //terminating, argument is exit status, non zero is abnormal, zero normal
					}
			
		});
		p.add(n3,c);
		
		add(p);
	}
	

}
