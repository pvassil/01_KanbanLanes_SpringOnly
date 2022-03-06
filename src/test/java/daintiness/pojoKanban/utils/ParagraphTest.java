package daintiness.pojoKanban.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



/**
 * @author pvassil
 *
 */
public class ParagraphTest {
	public static Paragraph paragraph = null;
	
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
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.utils.Paragraph#getHeader()}.
	 */
	@Test
	void testGetHeaderHappyDay() {
		paragraph = new Paragraph("Buy Stakes (DL:-1) @ Done", "Go and buy some nice beef stakes from the butcher");
		assertEquals("Buy Stakes (DL:-1) @ Done", paragraph.getHeader());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.utils.Paragraph#getBody()}.
	 */
	@Test
	void testGetBodyHappyDay() {
		paragraph = new Paragraph("Buy Stakes (DL:-1) @ Done", "Go and buy some nice beef stakes from the butcher");
		assertEquals("Go and buy some nice beef stakes from the butcher", paragraph.getBody());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.utils.Paragraph#toString()}.
	 */
	@Test
	void testToStringHappyDay() {
		paragraph = new Paragraph("Buy Stakes (DL:-1) @ Done", "Go and buy some nice beef stakes from the butcher");
		assertEquals("Buy Stakes (DL:-1) @ Done\nGo and buy some nice beef stakes from the butcher\n", paragraph.toString());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.utils.Paragraph#getHeader()}.
	 */
	@Test
	void testGetHeaderNullHeader() {
		paragraph = new Paragraph(null, "Go and buy some nice beef stakes from the butcher");
		assertEquals(null, paragraph.getHeader());
	}

	/**
	 * Test method for {@link main.java.gr.uoi.cs.daintiness.pojoKanban.utils.Paragraph#getBody()}.
	 */
	@Test
	void testGetBodyNullBody() {
		paragraph = new Paragraph("Buy Stakes (DL:-1) @ Done", null);
		assertEquals(null, paragraph.getBody());
	}	
	
}//end class
