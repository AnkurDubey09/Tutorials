package mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import steps.ZomatoLocationSteps;
import steps.ZomatoSearchSteps;


public class ZomaLocation extends JUnitStories{

	public ZomaLocation() {
		super();
		//this.configuredEmbedder().candidateSteps().add(new ZomatoLocationSteps());
		
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		List l = new ArrayList();
		l.add(new ZomatoLocationSteps());
		l.add(new ZomatoSearchSteps());
		return new InstanceStepsFactory(configuration(), l);
	}
	
	
	  @Override public Configuration configuration() { return new
	  MostUsefulConfiguration().useStoryLoader(new
	  LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new
	  StoryReporterBuilder().withFormats(Format.CONSOLE, Format.STATS,
	  Format.HTML)); }
	  
	  @Override public List<CandidateSteps> candidateSteps(){ return new
	  InstanceStepsFactory(configuration(), this).createCandidateSteps(); }
	 
	


	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		//return Arrays.asList("**/*.story");
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),"**/*.story","");
	}
	
	
}
