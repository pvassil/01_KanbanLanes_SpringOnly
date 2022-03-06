/**
 * 
 */
package daintiness.pojoKanban.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import daintiness.pojoKanban.model.KanbanLane;

/**
 * @author pvassil
 *
 */
class LaneManagementRepoServiceTest {
	private static LaneManagementRepoInterface repoSrvc = new LaneManagementRepoService();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.service.LaneManagementRepoService#addLane(java.lang.String)}.
	 */
	@Test
	void testAddLaneHappy() {
		repoSrvc = new LaneManagementRepoService();
		repoSrvc.addLane("Done");
		repoSrvc.addLane("CompletedButNotTested");
		assertEquals(2,repoSrvc.getListOfLanes().size());

	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.service.LaneManagementRepoService#addLane(java.lang.String)}.
	 */
	@Test
	void testAddLaneNull() {
		repoSrvc = new LaneManagementRepoService();
		Exception exception = assertThrows(NullPointerException.class, () -> {
			repoSrvc.addLane("Done");
			repoSrvc.addLane(null);
		 });
		assertEquals("LaneMgtRepoSrvc.addLane(): lane name cannot be null", exception.getMessage());
		System.out.println(exception.getMessage());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.service.LaneManagementRepoService#removeLane(java.lang.String)}.
	 */
	@Test
	void testRemoveLaneHappy() {
		repoSrvc = new LaneManagementRepoService();
		repoSrvc.addLane("Done");
		repoSrvc.addLane("CompletedButNotTested");
		repoSrvc.removeLane("Done");
		assertEquals(1,repoSrvc.getListOfLanes().size());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.service.LaneManagementRepoService#removeLane(java.lang.String)}.
	 */
	@Test
	void testRemoveLaneNull() {
		repoSrvc = new LaneManagementRepoService();
		Exception exception = assertThrows(NullPointerException.class, () -> {
			repoSrvc.addLane("Done");
			repoSrvc.addLane("CompletedButNotTested");
			repoSrvc.removeLane(null);
		 });
		assertEquals("LaneMgtRepoSrvc.removeLane(): lane name cannot be null", exception.getMessage());
		System.out.println(exception.getMessage());
	}
	
	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.service.LaneManagementRepoService#addCard(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddCardToLaneHappy() {
		repoSrvc = new LaneManagementRepoService();
		repoSrvc.addLane("Done");
		repoSrvc.addLane("CompletedButNotTested");
		boolean result = repoSrvc.addCardToLane("Leave Meat off Ice", "DL: -1", "Cannot throw it in the pan frozen", "Done");
		assertTrue(result);
		KanbanLane lane = repoSrvc.getKanbanLane("Done");
		assertEquals("Leave Meat off Ice(DL: -1)\n",lane.listAllCards());
	}	
	
	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.service.LaneManagementRepoService#addCard(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddCardToLaneNonExistentLane() {
		repoSrvc = new LaneManagementRepoService();
		repoSrvc.addLane("Done");
		repoSrvc.addLane("CompletedButNotTested");
		boolean result = repoSrvc.addCardToLane("Leave Meat off Ice", "DL: -1", "Cannot throw it in the pan frozen", "I DO NOT EXIST");
		assertEquals(false, result);
	}	
	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.service.LaneManagementRepoService#addCard(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddCardToLaneNonExistentCard() {
		repoSrvc = new LaneManagementRepoService();
		repoSrvc.addLane("Done");
		repoSrvc.addLane("CompletedButNotTested");

		Exception exception = assertThrows(NullPointerException.class, () -> {
			repoSrvc.addCardToLane(null, "DL: -1", "Cannot throw it in the pan frozen", "I DO NOT EXIST");
		 });
		assertEquals(null, exception.getMessage());


	}		
	
}//end class
