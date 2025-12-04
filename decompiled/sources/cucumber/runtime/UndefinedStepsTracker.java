package cucumber.runtime;

import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.SnippetsSuggestedEvent;
import cucumber.api.event.TestSourceRead;
import gherkin.AstBuilder;
import gherkin.GherkinDialect;
import gherkin.GherkinDialectProvider;
import gherkin.IGherkinDialectProvider;
import gherkin.Parser;
import gherkin.ParserException;
import gherkin.TokenMatcher;
import gherkin.ast.Background;
import gherkin.ast.GherkinDocument;
import gherkin.ast.ScenarioDefinition;
import gherkin.ast.Step;
import gherkin.pickles.PickleLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class UndefinedStepsTracker implements EventListener {
    private final List snippets = new ArrayList();
    private final IGherkinDialectProvider dialectProvider = new GherkinDialectProvider();
    private final Map pathToSourceMap = new HashMap();
    private final Map pathToStepMap = new HashMap();
    private boolean hasUndefinedSteps = false;
    private EventHandler testSourceReadHandler = new EventHandler() { // from class: cucumber.runtime.UndefinedStepsTracker.1
        @Override // cucumber.api.event.EventHandler
        public void receive(TestSourceRead testSourceRead) {
            UndefinedStepsTracker.this.pathToSourceMap.put(testSourceRead.uri, testSourceRead.source);
        }
    };
    private EventHandler snippetsSuggestedHandler = new EventHandler() { // from class: cucumber.runtime.UndefinedStepsTracker.2
        @Override // cucumber.api.event.EventHandler
        public void receive(SnippetsSuggestedEvent snippetsSuggestedEvent) {
            UndefinedStepsTracker.this.handleSnippetsSuggested(snippetsSuggestedEvent.uri, snippetsSuggestedEvent.stepLocations, snippetsSuggestedEvent.snippets);
        }
    };

    @Override // cucumber.api.event.EventListener
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestSourceRead.class, this.testSourceReadHandler);
        eventPublisher.registerHandlerFor(SnippetsSuggestedEvent.class, this.snippetsSuggestedHandler);
    }

    public boolean hasUndefinedSteps() {
        return this.hasUndefinedSteps;
    }

    public List<String> getSnippets() {
        return this.snippets;
    }

    void handleSnippetsSuggested(String str, List list, List list2) {
        this.hasUndefinedSteps = true;
        String strGivenWhenThenKeyword = givenWhenThenKeyword(str, list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String strReplace = ((String) it.next()).replace("**KEYWORD**", strGivenWhenThenKeyword);
            if (!this.snippets.contains(strReplace)) {
                this.snippets.add(strReplace);
            }
        }
    }

    private String givenWhenThenKeyword(String str, List list) {
        String keywordFromSource = (list.isEmpty() || !this.pathToSourceMap.containsKey(str)) ? null : getKeywordFromSource(str, list);
        return keywordFromSource != null ? keywordFromSource : getFirstGivenKeyword(this.dialectProvider.getDefaultDialect());
    }

    private String getKeywordFromSource(String str, List list) {
        if (!this.pathToStepMap.containsKey(str)) {
            createFeatureStepMap(str);
        }
        if (!this.pathToStepMap.containsKey(str)) {
            return null;
        }
        GherkinDialect gherkinDialect = ((FeatureStepMap) this.pathToStepMap.get(str)).dialect;
        List<String> givenWhenThenKeywords = getGivenWhenThenKeywords(gherkinDialect);
        Map map = ((FeatureStepMap) this.pathToStepMap.get(str)).stepMap;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PickleLocation pickleLocation = (PickleLocation) it.next();
            if (map.containsKey(Integer.valueOf(pickleLocation.getLine()))) {
                for (StepNode stepNode = (StepNode) map.get(Integer.valueOf(pickleLocation.getLine())); stepNode != null; stepNode = stepNode.previous) {
                    for (String str2 : givenWhenThenKeywords) {
                        if (!str2.equals("* ") && str2 == stepNode.step.getKeyword()) {
                            return convertToCodeKeyword(str2);
                        }
                    }
                }
            }
        }
        return getFirstGivenKeyword(gherkinDialect);
    }

    private void createFeatureStepMap(String str) {
        if (this.pathToSourceMap.containsKey(str)) {
            try {
                GherkinDocument gherkinDocument = (GherkinDocument) new Parser(new AstBuilder()).parse((String) this.pathToSourceMap.get(str), new TokenMatcher());
                HashMap map = new HashMap();
                StepNode stepNode = null;
                for (ScenarioDefinition scenarioDefinition : gherkinDocument.getFeature().getChildren()) {
                    StepNode stepNodeProcessScenarioDefinition = processScenarioDefinition(map, stepNode, scenarioDefinition);
                    if (scenarioDefinition instanceof Background) {
                        stepNode = stepNodeProcessScenarioDefinition;
                    }
                }
                this.pathToStepMap.put(str, new FeatureStepMap(new GherkinDialectProvider(gherkinDocument.getFeature().getLanguage()).getDefaultDialect(), map));
            } catch (ParserException unused) {
            }
        }
    }

    private StepNode processScenarioDefinition(Map map, StepNode stepNode, ScenarioDefinition scenarioDefinition) {
        for (Step step : scenarioDefinition.getSteps()) {
            StepNode stepNode2 = new StepNode(step, stepNode);
            map.put(Integer.valueOf(step.getLocation().getLine()), stepNode2);
            stepNode = stepNode2;
        }
        return stepNode;
    }

    private List getGivenWhenThenKeywords(GherkinDialect gherkinDialect) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(gherkinDialect.getGivenKeywords());
        arrayList.addAll(gherkinDialect.getWhenKeywords());
        arrayList.addAll(gherkinDialect.getThenKeywords());
        return arrayList;
    }

    private String getFirstGivenKeyword(GherkinDialect gherkinDialect) {
        for (String str : gherkinDialect.getGivenKeywords()) {
            if (!str.equals("* ")) {
                return convertToCodeKeyword(str);
            }
        }
        return null;
    }

    private String convertToCodeKeyword(String str) {
        return str.replaceAll("[\\s',!]", "");
    }

    private static final class FeatureStepMap {
        final GherkinDialect dialect;
        final Map stepMap;

        FeatureStepMap(GherkinDialect gherkinDialect, Map map) {
            this.dialect = gherkinDialect;
            this.stepMap = map;
        }
    }

    private static final class StepNode {
        final StepNode previous;
        final Step step;

        StepNode(Step step, StepNode stepNode) {
            this.step = step;
            this.previous = stepNode;
        }
    }
}
