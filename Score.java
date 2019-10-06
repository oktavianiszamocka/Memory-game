package project2;

import java.io.Serializable;

public class Score implements Serializable, Comparable<Score> {
	//writing the state of an object into a byte stream
	private String nickname;
	private double score;
	private String time;
	private String grid;
	
	public Score(String nickname, double score, String time, String grid)
	{
		this.nickname=nickname;
		this.score=score;
		this.time=time;
		this.grid=grid;
		
	}
	public String getNick() {
		return nickname;
	}
	public String getTime() {
		return time;
	}
	public String getGrid() {
		return grid;
	}
	public double getScore(){
		return score;
	}
	
	
	

	@Override
	public int compareTo(Score sc) {
		if(score<sc.score)
			return 1;
		else if(score==sc.score)
			return 0;
		else
			return -1;
	}
	public String toString()
	{
		return nickname + " "+score;
	}
}
