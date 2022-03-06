package daintiness.pojoKanban.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import daintiness.pojoKanban.model.KanbanCard;
import daintiness.pojoKanban.model.KanbanLane;

/**
 * A Repo Manager
 *  
 * Visibility: package, not to be outside the package.
 * Instead, use Factory + Interface to new a repo manager, and get its job done, respectively.
 * 
 * Characterized as a @Repository component
 * 
 * @author pvassil
 *
 */
@Repository
@Qualifier("LaneManagementRepoService")
class LaneManagementRepoService implements LaneManagementRepoInterface {

	private final Map<String, KanbanLane> lanes;
	private final Map<String, KanbanCard> cards;
	
	public LaneManagementRepoService() {
		super();
		this.lanes= new HashMap<String, KanbanLane>();
		this.cards = new HashMap<String, KanbanCard>();
	}
	
	@Override
	public boolean addLane(String laneName) throws NullPointerException {
		Objects.requireNonNull(laneName, "LaneMgtRepoSrvc.addLane(): lane name cannot be null");
		KanbanLane newLane = new KanbanLane(laneName);
		KanbanLane result = this.lanes.putIfAbsent(laneName, newLane);
		if (result == null)
			return false;
		else return true;
	}
	
	@Override
	public boolean removeLane(String laneName) throws NullPointerException {
		Objects.requireNonNull(laneName, "LaneMgtRepoSrvc.removeLane(): lane name cannot be null");
		KanbanLane result = this.lanes.remove(laneName);
		if (result == null)
			return false;
		else return true;
	}
	
	@Override
	public boolean addCardToLane(String cardName, String cardDeadline, String cardText, String laneName) throws NullPointerException {
		Objects.requireNonNull(cardName);
		Objects.requireNonNull(laneName);
		
		KanbanLane lane = null;
		if(this.lanes.containsKey(laneName))
			 lane = this.lanes.get(laneName);
		else
			return false;
		
		try {
			KanbanCard card = new KanbanCard(cardName, cardDeadline, cardText, lane); 
			this.cards.put(cardName, card);
			if (lane.addCard(card))
				return true;
		}catch(NullPointerException e) {
			return false;
		}
		return false;
	}
	
	@Override
	public KanbanLane getKanbanLane(String laneName) {
		return this.lanes.get(laneName);
	}
	
	@Override
	public KanbanCard getKanbanCard(String cardName) {
		return this.cards.get(cardName);
	}
	
	@Override
	public List<KanbanLane> getListOfLanes(){
		return new ArrayList<KanbanLane>(this.lanes.values());
	}
	
	//TODO: remove card completely, move card to another lane
	
}//end class
