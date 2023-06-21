package beans;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.TeamDaoImpl;
import dao.PlayerDaoImpl;
import pojos.Players;
import pojos.Teams;

//myTeam=2&fn=dfdf&ln=fd&dob=2023-06-22&avg=45.00&wickets=54
public class IPLBean {

	private long myTeam;
	private String fn;
	private String ln;
	private String dob;
	private String battingAvg;
	private String wicketsTaken;
	
	//state : dep : dao
		private TeamDaoImpl teamDao;
		private PlayerDaoImpl playerDao;
	public IPLBean() {
		//dao instace
		teamDao=new TeamDaoImpl();
		playerDao=new PlayerDaoImpl();
		System.out.println("IPL bean created...");
		
	}
	//getters n setters
	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}
	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
		
		
		
	}
	
	
	public long getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(long myTeam) {
		this.myTeam = myTeam;
	}
	public PlayerDaoImpl getPlayerDao() {
		return playerDao;
	}
	public void setPlayerDao(PlayerDaoImpl playerDao) {
		this.playerDao = playerDao;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(String battingAvg) {
		this.battingAvg = battingAvg;
	}
	public String getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(String wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	
	//add B.L method to ret list of all teams to the caller(JSP)
	public List<Teams> fetchAllTeams() 
	{
		//invoke dao's method
		return teamDao.getAllTeams();
	}
	
	public Teams fetchTeamDetails(long teamid)
	{
		return teamDao.getTeamDetails(teamid);
	}
	
	
	//myTeam=2&fn=dfdf&ln=fd&dob=2023-06-22&avg=45.00&wickets=54
	//Add a B.L method to first validate n add player
	 public String validateAndAddPlayer() {
		String msg="Player not added!!!";
		System.out.println(myTeam);
		 Teams team=teamDao.getTeamDetails(myTeam);
		 Players newPlayer = null;
		 if(team!=null)
		 {
			 System.out.println("hi");
			 if(team.getMinBattingAvg()<Double.parseDouble(battingAvg)&&team.getMinWicketsTaken()<Integer.parseInt(wicketsTaken)&&Period.between(LocalDate.parse(dob),LocalDate.now()).getYears()<41)
			 {
				newPlayer=new Players(fn, ln, LocalDate.parse(dob), Double.parseDouble(battingAvg),Integer.parseInt(wicketsTaken) );			 }
			 	playerDao.addNewPlayer(newPlayer, team.getId());
			 	msg="player added successfully!!";
		 }
		 
		 
		 return msg;
	 }
	
	
}
