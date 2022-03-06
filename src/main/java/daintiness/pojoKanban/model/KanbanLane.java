/**
 * 
 */
package daintiness.pojoKanban.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import daintiness.pojoKanban.utils.Paragraph;

/**
 * @author pvassil
 *
 */
public class KanbanLane {
	private final String laneName;
	private final List<KanbanCard> cards;

	/**
	 * TODO: what if more than one cards with the same name?
	 * Apart from the list, you also need a map!
	 *  
	 */

	
	public KanbanLane(String laneName) throws NullPointerException {
		super();
		this.laneName =  Objects.requireNonNull(laneName, "KanbanLane: lane name cannot be null");
		this.cards = new ArrayList<KanbanCard>();
	}
	
	@Override
	public String toString() {
		return this.laneName;
	}
	
	public String listAllCards() {
		String result = "";
		for(KanbanCard card: this.cards)
			result = result + card.selfDescribeShort();
		return result;
	}
	
	public Paragraph selfDescribeShort() {
		return new Paragraph(this.laneName, "(" + this.cards.size() + ")");
	}
	
	public List<Paragraph> selfDescribeLong() {
		List<Paragraph> paragraphs = new ArrayList<Paragraph>();
		paragraphs.add(this.selfDescribeShort());
		for(KanbanCard card: this.cards)
			paragraphs.add(card.selfDescribeFull());
			
		return paragraphs;
	}
	
	public boolean addCard(KanbanCard card) {
		return this.cards.add(card);
	}
	
	public boolean remove(String name) {
		KanbanCard cardToRemove = null;
		for(KanbanCard card: this.cards) {
			if(name.equals(card.getCardName())) {
				cardToRemove = card;
				break;
			}
		}
		if(cardToRemove !=null)
			return this.cards.remove(cardToRemove);
		return false;
	}
	
}//end class
