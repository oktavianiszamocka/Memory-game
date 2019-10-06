package project2;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class ScoreBoard extends JFrame
{
	private ArrayList<Score> highscore;
	private String highscore_file = "D:\\GameScores.txt";
	ObjectOutputStream output = null;
	ObjectInputStream input =null;
	JList list;
	DefaultListModel<String> thescore;
	
	ScoreBoard()
	{
		super();
		setTitle("High Score");
		setLayout(new BorderLayout());
		setSize(400, 400);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		highscore = new ArrayList<Score>();
		thescore = new DefaultListModel();
		
		addElement();
	
		setLocationRelativeTo(null);
		setVisible(true);
		//pack();
	}
	
	void loadFile()
	{
		//reading the file n send to highscore array
		try 
		{
			input = new ObjectInputStream(new FileInputStream(highscore_file));
			highscore = (ArrayList<Score>) input.readObject();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Sorry the input file is not exist");
		}
			catch (IOException e) 
		{
			JOptionPane.showMessageDialog(this, "Sorry there exists IO error");
		}  catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(this, "Sorry there exist unfound class in program");
		}finally
		{
			if(output != null)
			{
				try {
					output.flush();
					output.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "Sorry there exists IO error");
				}	
			}
		}
	}
	void updateFile()
	{
		//writing file by the array
		try {
			output = new ObjectOutputStream(new FileOutputStream(highscore_file)); 		//write primitive data types and Java objects to an OutputStream
			output.writeObject(highscore);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Sorry the output file is not exist");
		}
			catch (IOException e) 
		{
				JOptionPane.showMessageDialog(this, "Sorry there exists IO error");
		} finally
		{
			if(output != null)
			{
				try {
					output.flush();
					output.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "Sorry there exists IO error");
				}	
			}
		}
	}
	
	void sort()
	{
		Collections.sort(highscore);
	}
	
	void addScore(String playerNick, double playerScore, String time, String grid) {
		
		loadFile();
		highscore.add(new Score(playerNick, playerScore, time, grid));
		updateFile();
		
	}
	
	ArrayList<Score> getScores()
	{
		loadFile();
		sort();
		return highscore;
	}
	
	void getHighScore()
	{
		String thisScore= "";
		highscore = getScores();
	
		for(int i=0;i<highscore.size();i++)
		{
			thisScore = (i+1)+". "+ highscore.get(i).getNick()+ " (Time:  " +highscore.get(i).getTime()+ ", grid "+highscore.get(i).getGrid()+")";
			thescore.addElement(thisScore);
		}
	}
	
	void addElement() {
		getHighScore();
		JLabel h = new JLabel("The Winner List", SwingConstants.CENTER);
		h.setFont(new Font("Cambria", Font.BOLD, 28));
		add(h, BorderLayout.NORTH);
		
		list = new JList(thescore);
		list.setFont(new Font("Arial", Font.BOLD, 16));
		list.setBackground(Color.YELLOW);
		add(list, BorderLayout.CENTER);
		
		JScrollBar roll = new JScrollBar();
		roll.setBounds(100, 100, 10, 100);
		add(roll, BorderLayout.EAST);
	}
}
