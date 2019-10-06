package project2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JFrame
{
	NewGame() 
	{
		super("Choosing size");
		setSize(300, 300);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		combo();
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	void combo()
	{
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel sel = new JLabel("Please select the size of the card!");
		c.gridx=0;
		c.gridy=1;
		p.add(sel, c);
		
		String size []= {"easy : 4 x 3", "Medium : 4 x 5", "Hard : 5 x 8"};
		JComboBox jb = new JComboBox(size);
		jb.setBounds(10,10,10,20);
		
		c.gridx=0;
		c.gridy=2;
		c.insets= new Insets(10,0,0,0);
		p.add(jb, c);
		
		JButton y = new JButton("Play");
		c.gridx=0;
		c.gridy=3;
		c.insets= new Insets(10,0,0,0);
		y.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) 
			{	
				Card c = new Card();
				c.setPanel(jb);
				setVisible(false);
			}
	
		});
		p.add(y, c);
		
		add(p, BorderLayout.CENTER);
		
	}
	
	
	

}
