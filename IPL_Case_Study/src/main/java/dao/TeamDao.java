package dao;

import java.util.List;

import pojos.Teams;

public interface TeamDao {
	//add a method
	String addNewTeam(Teams team);
	//get all teams
	List<Teams> getAllTeams();
	//add a method to get team details
	Teams getTeamDetails(long teamid);

}
