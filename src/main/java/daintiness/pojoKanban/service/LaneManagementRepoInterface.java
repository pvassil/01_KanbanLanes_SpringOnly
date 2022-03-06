package daintiness.pojoKanban.service;

import java.util.List;

import daintiness.pojoKanban.model.KanbanCard;
import daintiness.pojoKanban.model.KanbanLane;

public interface LaneManagementRepoInterface {
	
	/**
	 * Adds a new Lane to the Lane Management Repo
	 * 
	 * @param laneName a String with the name of the new Lane
	 * @return true if added, false otherwise (e.g., the name already existed)
	 * @throws NullPointerException
	 */
	public boolean addLane(String laneName) throws NullPointerException;

	
	/**
	 * Removes a Lane from the Lane Management Repo
	 * 
	 * @param laneName a String with the name of the requested Lane
	 * @return true if removed indeed, false otherwise (e.g., the name did not exist in the repo)
	 * @throws NullPointerException
	 */
	public boolean removeLane(String laneName) throws NullPointerException;

	
	/**
	 * Adds a card to a Lane
	 * 
	 * @param cardName a String with the name of the new Card
	 * @param cardDeadline a String with the deadline of the new Card
	 * @param cardText a String with the text of the body of the card
	 * @param laneName a String with the name of the Lane that already exists in the repo
	 * @return true if both the lane exists and the new Card is a new valid Card; false otherwise
	 * @throws NullPointerException
	 */
	public boolean addCardToLane(String cardName, String cardDeadline, String cardText, String laneName)
			throws NullPointerException;

	
	/**
	 * Given a String with the Lane name, returns the respective Lane object from the repo
	 * @param laneName a String with the Lane name
	 * @return a KanbanLane object, if the repo contains such an object; null otherwise
	 */
	public KanbanLane getKanbanLane(String laneName);

	
	/**
	 * Given a String with the card name, returns a KanbanCard with the card name
	 * @param cardName a String with the card name requested
	 * @return a KanbanCard object, if the repo contains such an object; null otherwise
	 */
	public KanbanCard getKanbanCard(String cardName);

	
	/**
	 * Returns a list of the lanes of the repo
	 * @return a List<KanbanLane> with the lanes of the repo (possibly empty, if no Lanes exist)
	 */
	public List<KanbanLane> getListOfLanes();

}