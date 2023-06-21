package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Teams;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addNewTeam(Teams team) {
		String mesg="Team add failed!!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.persist(team);
			tx.commit();
			mesg="New team added successfully!!";
		}catch (RuntimeException e) {
			if(tx!=null)
					tx.rollback();
			throw e;
		}
		
		return mesg;
	}

	@Override
	public List<Teams> getAllTeams() {
		String jpql="select new pojos.Teams(id,abbrevation) from Teams t";
		List<Teams> teams=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			teams=session.createQuery(jpql,Teams.class).getResultList();
			tx.commit();
			
		}catch (RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
		throw e;
		}
		
		return teams;
	}

	@Override
	public Teams getTeamDetails(long teamid) {
		Teams team;
		Session session=getFactory().getCurrentSession();
		System.out.println("hello");
		Transaction tx=session.beginTransaction();
		try{
			System.out.println(teamid);
			team=session.get(Teams.class, teamid);
			System.out.println(team);
			tx.commit();
			
		}catch (RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
		throw e;
		}
		
		return team;
		
		
	}
	
	

}
