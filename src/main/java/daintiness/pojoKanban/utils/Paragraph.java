package daintiness.pojoKanban.utils;


/**
 * @author pvassil
 *
 */
public class Paragraph {
	private final String header;
	private final String body;
	
	public Paragraph(String header, String body) {
		super();
		this.header = header;
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public String getBody() {
		return body;
	}
	
	@Override
	public String toString() {
		return header + "\n" + body + "\n";
	}
}