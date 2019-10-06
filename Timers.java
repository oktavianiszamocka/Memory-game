package project2;
import javax.swing.*;
import java.awt.*;


public class Timers extends JPanel 
{
	static int seconds;
	static int minutes;
	static boolean state=true;
	Thread t;
	JLabel minute;
	JLabel second;
	
	Timers()
	{
		setLayout(new FlowLayout());
		
		time();
		setVisible(true);
		
	}
	
	void time()
	{
		minute = new JLabel("00");
		add(minute);
		JLabel s = new JLabel(":");
		add(s);
		second = new JLabel("00");
		add(second);
		
		walking(minute, second);
		setzero();
		
	}
	
	void walking(JLabel minute, JLabel second)
	{
		state=true;
		t = new Thread()
		{
			public void run()
			{
				while(true)
				{
					if(state==true)
					{
						try 
						{
							t.sleep(1000);
							seconds++;
							if(seconds>60)
							{
								seconds=0;
								minutes++;
							}
										
							second.setText(""+ seconds);
							minute.setText(""+minutes);
										
						} catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
					else
						break;
				}
								
			}
			};
			t.start();
	}
			

	void setzero()
	{
		seconds=0;
		minutes=0;
	}
	
	
}
