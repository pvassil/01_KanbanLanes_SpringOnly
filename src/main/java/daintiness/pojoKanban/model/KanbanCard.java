package daintiness.pojoKanban.model;

import java.util.Objects;

import daintiness.pojoKanban.utils.Paragraph;

/**
 * @author pvassil
 * 
 */
public class KanbanCard {
	private final String cardName;
	private final String cardDeadline;
	private final String cardText;
	private KanbanLane lane;		//for the moment: not final
	
	/**
	 * Assigns values to the fields of the object and checks whether the important parameters are not null
	 * @param cardName
	 * @param cardDeadline
	 * @param cardText
	 * @param lane
	 * 
	 * @throws NullPointerException if any argument is null
	 */
	public KanbanCard(String cardName, String cardDeadline, String cardText, KanbanLane lane) throws NullPointerException  {
		super();
		this.cardName = Objects.requireNonNull(cardName, "KanbanCard: card name cannot be null");
		this.cardDeadline = cardDeadline;
		this.cardText = cardText;
		this.lane = Objects.requireNonNull(lane, "KanbanCard: lane name cannot be null");
	}
	
	public String getStatus() {
		return this.lane.toString();
	}
	
	public String selfDescribeShort() {
		return this.cardName + "(" +this.cardDeadline + ")\n";
	}
	
	public Paragraph selfDescribeFull() {
		return new Paragraph(this.cardName + " (" +this.cardDeadline + ") @ " + this.lane.toString(), this.cardText);
	}

	public String getCardName() {
		return cardName;
	}

//	public String getCardDeadline() {
//		return cardDeadline;
//	}
//
//	public String getCardText() {
//		return cardText;
//	}

	
}//end class
