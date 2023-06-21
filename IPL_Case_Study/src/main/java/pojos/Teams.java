package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// team_id|name|abbrevation | owner  | max_age | batting_avg | wickets_taken |
@Entity
@Table(name="teams")
public class Teams extends BaseEntity {
	
	@Column(name="team_name",length=50,unique=true)
	private String name;
	@Column(length=10,unique=true)
	private String abbrevation;
	@Column(length=50)
	private String owner;
	@Column(name="max_age")
	private int maxAge;
	@Column(name="batting_avg")
	private double minBattingAvg;
	@Column(name="wickets_taken")
	private int minWicketsTaken;
	@OneToMany(mappedBy ="team",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Players> playerlist=new ArrayList<Players>();
	
	public Teams()
	{
		
	}
	
	

	


	public Teams(Long id,String abbrevation) {
		super.setId(id);
		this.abbrevation = abbrevation;
	}






	public Teams(String name, String abbrevation, String owner, int maxAge, double minBattingAvg, int minWicketsTaken) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}






	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAbbrevation() {
		return abbrevation;
	}


	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public int getMaxAge() {
		return maxAge;
	}


	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}


	public double getMinBattingAvg() {
		return minBattingAvg;
	}


	public void setMinBattingAvg(double battingAvg) {
		this.minBattingAvg = battingAvg;
	}


	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}


	public void setMinWicketsTaken(int wicketsTaken) {
		this.minWicketsTaken = wicketsTaken;
	}
	
	


	public List<Players> getPlayerlist() {
		return playerlist;
	}






	public void setPlayerlist(List<Players> playerlist) {
		this.playerlist = playerlist;
	}






	@Override
	public String toString() {
		return "Teams [teamid=" + getId() + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + minBattingAvg + ", wicketsTaken=" + minWicketsTaken + "]";
	}
	
	
	//add 2 helper methods
	public void addPlayer(Players player) {
		playerlist.add(player);
		player.setTeam(this);
	}
	
	public void removePlayer(Players player)
	{
		playerlist.remove(player);
		player.setTeam(null);
	}
	
	
	

}
