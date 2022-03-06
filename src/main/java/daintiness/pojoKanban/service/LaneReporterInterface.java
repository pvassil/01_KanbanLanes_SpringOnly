package daintiness.pojoKanban.service;

public interface LaneReporterInterface {

	/**
	 * Returns a String containing the entire description of a Lane
	 * 
	 * @param laneName a String with the name of the lane to be reported
	 * @return a String containing the description of a Lane; an error-reporting string if no such lane exists
	 */
	public String reportLaneLong(String laneName);

}