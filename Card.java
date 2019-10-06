package project2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Card extends JFrame
{	
	private int gridHeight=0;
	private int gridWeight=0;
	private int numButton=0;
	private int numOfClick=0;
	private int oddClickIndex=0;
	private int currentIndex=0;
	private static JButton cards[];
	private ImageIcon icon[];
	private Timer timer;
	private ImageIcon closed;
	private Random random;
	private Timers t;
	private int match=0;
	private double timeResult=0;
	private int sizeGrid=0;
	private String sizeOfGrid="";
	private double point = 0;
	private String playernick="";
	private JTextField nick;
	ScoreBoard sc;
	private String timefinal="";
	static JPanel p;
	
	
	Card()
	{		
		super("Play");
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	
		setTimer();
		
		setVisible(true);	
		//pack();		//Window to be sized to fit the preferred size and layouts of its subcomponents.
		
	}
	void setTimer()
	{
		t = new Timers();
		add(t, BorderLayout.SOUTH);
	}
	
	void setPanel (JComboBox jb)
	{
		
		closed= new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\closed.jpg");
		ImageIcon img []= {
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\21.jpeg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\2.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\3.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\4.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\5.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\6.jpg")
		
		};
		
		ImageIcon img2[]= {
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\1.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\2.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\3.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\4.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\5.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\6.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\7.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\8.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\9.jpg"),
					new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\10.jpg")
				
		};

		ImageIcon img3[]= {
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\1.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\2.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\3.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\4.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\5.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\6.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\7.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\8.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\9.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\10.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\11.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\12.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\13.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\14.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\15.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\16.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\17.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\18.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\19.jpg"),
				new ImageIcon("D:\\Documents\\PJATK\\2nd\\GUI\\p2\\20.jpg")
		};
		
		p = new JPanel();
		
		
		String s = (String) jb.getItemAt(jb.getSelectedIndex());
		if(s.equals("easy : 4 x 3"))
		{
			setSize(700, 700);
			setLocationRelativeTo(null);
			gridHeight=4;
			gridWeight=3;
			sizeGrid=gridHeight*gridWeight;
			sizeOfGrid=gridHeight+"x"+gridWeight;
			p.setLayout(new GridLayout(gridHeight,gridWeight));
			setcard(img);			
		}
		else if(s.equals("Medium : 4 x 5"))
		{
			setSize(1000, 780);
			setLocationRelativeTo(null);
			gridHeight=4;
			gridWeight=5;
			sizeGrid=gridHeight*gridWeight;
			sizeOfGrid=gridHeight+"x"+gridWeight;
			p.setLayout(new GridLayout(gridHeight,gridWeight));
			setcard(img2);	
		}
		else
		{
			setSize(1500, 780);
			setLocationRelativeTo(null);
			gridHeight=5;
			gridWeight=8;
			sizeGrid=gridHeight*gridWeight;
			sizeOfGrid=gridHeight+"x"+gridWeight;
			p.setLayout(new GridLayout(gridHeight,gridWeight));
			setcard(img3);	
		}
	
	}
	
	void setcard(ImageIcon img[])
	{
		
		numButton = img.length*2;
		cards = new JButton[numButton];
		icon=new ImageIcon[numButton];
		for(int i=0, j=0;i<img.length;i++)
		{
			Image pic = img[i].getImage();			//abstract superclass of all classes that represent graphical images
			Image renew = pic.getScaledInstance(230, 150, java.awt.Image.SCALE_SMOOTH); 	//change the scale
			icon[j]=new ImageIcon(renew);
			cards[j] = new JButton();
			cards[j].setIcon(closed);
			cards[j].setSize(10, 10);
			cards[j].setBackground(Color.WHITE);
			cards[j].addActionListener(new ImageListener());
			p.add(cards[j]);
			j++;
			
			icon[j]=icon[j-1];
			cards[j]=new JButton();
			cards[j].setIcon(closed);
			cards[j].setSize(10, 10);
			cards[j].setBackground(Color.WHITE);
			cards[j].addActionListener(new ImageListener());
			p.add(cards[j]);
			j++;	
			
		}
		
		randomIt();
		
		add(p, BorderLayout.CENTER);
		timer2s();
	}
	
	void timer2s()
	{
		timer = new Timer(2000, new ActionListener()		//perform some action after some delay
		{
			public void actionPerformed(ActionEvent e) 
			{
				cards[currentIndex].setIcon(closed);
				cards[oddClickIndex].setIcon(closed);
				timer.stop();
			}
	
		});
	}
	
	void randomIt()
	{
		
		random = new Random();
		for(int i =0; i<numButton; i++)
		{
			int rand = random.nextInt(numButton);
			ImageIcon tmp = icon[i];
			icon[i]=icon[rand];
			icon[rand]=tmp;	
		}
		
	}
	
	
	void openAll()
	{
			if(match==(numButton/2))	
			{
				t.state=false;
				t.t.stop();
				t.setzero();
				JPanel panel = new JPanel();
				String [] options= {"OK"};
				JLabel enter = new JLabel("Your name", SwingConstants.CENTER);
				nick = new JTextField(10);
				panel.add(enter);
				panel.add(nick);
				int selectedOption = JOptionPane.showOptionDialog(null, panel," You r win", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				//.showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue)
				if(selectedOption == 0)
				{
					playernick = nick.getText();
					setVisible(false);
					theScore();
					
				}
				
			}
	}
	
	void theScore()
	{
		String minutes = t.minute.getText();
		String seconds = t.second.getText();
		timefinal=minutes+":"+seconds;
		double min = Double.parseDouble(minutes);
		double sec = Double.parseDouble(seconds);
		if(min>=1){
			min=min*60;
		}
		timeResult= min+sec;
	//	System.out.println(timeResult);
		point = sizeGrid/timeResult;
	//.out.println(point);
		sc = new ScoreBoard();
		sc.addScore(playernick, point, timefinal, sizeOfGrid);
		sc.setVisible(false);
	}
private class ImageListener implements ActionListener
{
		public void actionPerformed(ActionEvent e) 
		{
			
			if(timer.isRunning())
				return;
	
			numOfClick++;
			for(int i=0;i<numButton;i++)
			{
				if(e.getSource() == cards[i])
				{
					cards[i].setIcon(icon[i]);
					currentIndex=i;
				}		
			}
			if(numOfClick % 2 == 0)
			{
				if(currentIndex==oddClickIndex)
				{
					numOfClick--;
					return;
				}
				if(icon[currentIndex] != icon[oddClickIndex])
				{
					timer.start();
				}
				else {
					
					match++;
					openAll();
					}
			}
			else
			{
				oddClickIndex=currentIndex;
			}
		}

}
	
}
