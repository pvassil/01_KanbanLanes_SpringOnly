/**
 * 
 */
package daintiness.pojoKanban.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import daintiness.pojoKanban.model.KanbanLane;
import daintiness.pojoKanban.utils.Paragraph;

/**
 * A Text Reporter. 
 * 
 * Visibility: package, not to be used outside the package.
 * Instead, use Factory + Interface to new reporters, and get their job done, respectively.
 * 
 * Registered as @Service
 * Refers to a repo, via autowiring
 * 
 * @author pvassil
 *
 */
@Service
@Qualifier("LaneReporterText")
class LaneReporterText implements LaneReporterInterface {
	
	private final LaneManagementRepoInterface repo;
	
	@Autowired
	public LaneReporterText(@Qualifier("LaneManagementRepoService") LaneManagementRepoInterface repo) throws NullPointerException{
		this.repo = Objects.requireNonNull(repo);
	}
	
	@Override
	public String reportLaneLong(String laneName) {
		String result = "";
		KanbanLane lane = this.repo.getKanbanLane(laneName);
		if (lane == null)
			return "Lane " + laneName + " does not exist. No reporting.";
		
		//result = lane.selfDescribeShort().toString();
		List<Paragraph> paragraphs = lane.selfDescribeLong();
		for(Paragraph p: paragraphs) {
			result = result + "\n" + p.toString();
		}
		return result;
	}
}
