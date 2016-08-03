package org.fundacionjala.pivotal.jbehave;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;


/**
 * Created by Zeus on 03/08/2016.
 */
public class PivotalScenario extends JUnitStory {

    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // where to find the stories
//                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryLoader(new LoadFromRelativeFile(CodeLocations.codeLocationFromClass(this.getClass())));
                // CONSOLE and TXT reporting
//                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(StoryReporterBuilder.Format.CONSOLE, StoryReporterBuilder.Format.TXT, StoryReporterBuilder.Format.HTML, StoryReporterBuilder.Format.XML));
    }

    // Here we specify the steps classes
    @Override
    public List<CandidateSteps> candidateSteps() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new ApiResourcesSteps()).createCandidateSteps();
    }

//    @Override
//    protected List<String> storyPaths() {
//        StoryFinder finder = new StoryFinder();
//        return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), Arrays.asList(""));
//    }
//
}


