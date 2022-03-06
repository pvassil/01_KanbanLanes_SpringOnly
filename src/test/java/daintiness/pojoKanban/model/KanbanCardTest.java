/**
 * 
 */
package daintiness.pojoKanban.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 * @author pvassil
 *
 */
public class KanbanCardTest {
	private static KanbanCard card = null; 
	private static KanbanLane doneLane = null;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		doneLane = new KanbanLane("Done");
//		KanbanLane completedLane = new KanbanLane("CompletedButNotTested");
//		KanbanLane inProgressLane = new KanbanLane("InProgress");
//		KanbanLane upcomingLane = new KanbanLane("Upcoming");
//		KanbanLane brainstormLane = new KanbanLane("InBrainStormMode");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.model.KanbanCard#getStatus()}.
	 */
	@Test
	void testGetStatusHappyDay() {
		card = new KanbanCard("Buy Stake", "DL: -1", "Mpritzoles phges na pareis aneprokope?", doneLane);
		assertEquals("Done", card.getStatus());
	}

	@Test
	void testGetStatusNull() {
		Exception exception = assertThrows(NullPointerException.class, () -> {
			   card = new KanbanCard("Buy Stake", "DL: -1", "Mpritzoles phges na pareis aneprokope?", null);
		 });
		assertEquals("KanbanCard: lane name cannot be null", exception.getMessage());
		System.out.println(exception.getMessage());
	}
	
	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.model.KanbanCard#selfDescribeShort()}.
	 */
	@Test
	void testSelfDescribeShort() {
		card = new KanbanCard("Buy Stake", "DL: -1", "Mpritzoles phges na pareis aneprokope?", doneLane);
		assertEquals("Buy Stake(DL: -1)\n", card.selfDescribeShort());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.model.KanbanCard#selfDescribeFull()}.
	 */
	@Test
	void testSelfDescribeFullHappyDay() {
		card = new KanbanCard("Buy Stake", "DL: -1", "Mpritzoles phges na pareis aneprokope?", doneLane);
		assertEquals("Buy Stake (DL: -1) @ Done", card.selfDescribeFull().getHeader());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.model.KanbanCard#getCardName()}.
	 */
	@Test
	void testGetCardNameHappyDay() {
		card = new KanbanCard("Buy Stake", "DL: -1", "Mpritzoles phges na pareis aneprokope?", doneLane);
		assertEquals("Buy Stake", card.getCardName());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.model.KanbanCard#getCardName()}.
	 */
	@Test
	void testGetCardNameNull() {
		Exception exception = assertThrows(NullPointerException.class, () -> {
			card = new KanbanCard(null, "DL: -1", "Mpritzoles phges na pareis aneprokope?", doneLane);
		 });
		assertEquals("KanbanCard: card name cannot be null", exception.getMessage());
		System.out.println(exception.getMessage());
	}
	
	
}//end class
