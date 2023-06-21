package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Players;
import pojos.Teams;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Players player, long teamid) {
		String mesg="Adding new player failed!!!";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Teams team=session.get(Teams.class, teamid);
			if(team!=null)
			{
				team.addPlayer(player);
				session.persist(player);
				tx.commit();
			}
		mesg="Player added Successfully";	
		}catch (RuntimeException e) {
			// TODO: handle exception
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
