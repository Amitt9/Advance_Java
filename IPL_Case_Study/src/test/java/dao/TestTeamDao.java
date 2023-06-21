package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Teams;
import utils.HibernateUtils;

class TestTeamDao {
private static TeamDao dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//build sf n create dao instance
		HibernateUtils.getFactory();
		dao=new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}

	/*
	 * @Test void test() { //create team instance Teams newTeam=new
	 * Teams("Chennai Super Kings", "CSK", "Owner2", 37, 58, 28); String
	 * msg=dao.addNewTeam(newTeam); System.out.println(msg); assertEquals(2,
	 * newTeam.getId()); }
	 */

	@Test
	void test() {
		//create team instance
		List<Teams> teams=dao.getAllTeams();
		teams.forEach(t->System.out.println(t.getId()+" "+t.getAbbrevation()));
		assertEquals(2, teams.size());
	}

}
