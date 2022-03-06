package daintiness.pojoKanban._context;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import service.LaneManagementRepoFactory;
import daintiness.pojoKanban.service.LaneManagementRepoInterface;
//import service.LaneReporterFactory;
import daintiness.pojoKanban.service.LaneReporterInterface;

@Configuration
@ComponentScan(basePackages = { "daintiness.pojoKanban" })
class SpringContext {
}

public class LaunchJavaContext {

  

  public static Logger logger = Logger.getLogger(LaunchJavaContext.class);

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        SpringContext.class);

    LaneManagementRepoInterface repo = context.getBean(LaneManagementRepoInterface.class);
	repo.addLane("Done");
	repo.addLane("CompletedButNotTested");
	repo.addLane("InProgress");
	repo.addLane("Upcoming");
	repo.addLane("InBrainStormMode");

	repo.addCardToLane("Buy Stakes", "DL: MON", "no more than 15E/kg", "Done");
	repo.addCardToLane("DeFreeze Stakes", "DL: WED", "all night long", "Done");
	repo.addCardToLane("Prepare Pan", "DL: THU", "Put the pan on fire till it's super hot", "Done");
	repo.addCardToLane("Prepare Stakes", "DL: THU", "Shower Stakes with Oil, Pepper, Salt, Garlic", "Done");
	repo.addCardToLane("Fry Stakes", "DL: THU", "to give them heat and make them encompass it; remember to turn them upside down at least once", "CompletedButNotTested");
	repo.addCardToLane("Cook Stakes", "DL: THU", "by letting them rest quietly for 30 min.", "InProgress");
	repo.addCardToLane("Make a Salad", "DL: THU", "kai mh bariesai", "InProgress");
	repo.addCardToLane("Eat Lunch", "DL: THU", "quietly", "Upcoming");
	repo.addCardToLane("Decide tomorrow's lunch", "DL: FRI", "cook or maybe order?", "InBrainStormMode");
    
    LaneReporterInterface textReporter = context.getBean(LaneReporterInterface.class);
	System.out.println("\n *** ");
	System.out.println(textReporter.reportLaneLong("Done"));
	System.out.println("\n *** ");
	System.out.println(textReporter.reportLaneLong("CompletedButNotTested"));
	System.out.println("\n *** ");
	System.out.println(textReporter.reportLaneLong("InProgress"));
	System.out.println("\n *** ");
	System.out.println(textReporter.reportLaneLong("Upcoming"));
	System.out.println("\n *** ");
	System.out.println(textReporter.reportLaneLong("InBrainStormMode"));
    
    //BusinessService service = context.getBean(BusinessService.class);
  //  logger.debug(service.calculateSum(DUMMY_USER));
    
    ((ConfigurableApplicationContext)context ).close();
  }
}
