package cucumber.runtime.formatter;

import cucumber.api.event.TestSourceRead;
import gherkin.AstBuilder;
import gherkin.Parser;
import gherkin.ParserException;
import gherkin.TokenMatcher;
import gherkin.ast.Examples;
import gherkin.ast.Feature;
import gherkin.ast.GherkinDocument;
import gherkin.ast.Node;
import gherkin.ast.ScenarioDefinition;
import gherkin.ast.ScenarioOutline;
import gherkin.ast.Step;
import gherkin.ast.TableRow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
final class TestSourcesModel {
    private final Map pathToReadEventMap = new HashMap();
    private final Map pathToAstMap = new HashMap();
    private final Map pathToNodeMap = new HashMap();

    TestSourcesModel() {
    }

    static String calculateId(AstNode astNode) {
        Node node = astNode.node;
        if (node instanceof ScenarioDefinition) {
            return calculateId(astNode.parent) + ";" + convertToId(((ScenarioDefinition) node).getName());
        }
        if (node instanceof ExamplesRowWrapperNode) {
            return calculateId(astNode.parent) + ";" + Integer.toString(((ExamplesRowWrapperNode) node).bodyRowIndex + 2);
        }
        if (node instanceof TableRow) {
            return calculateId(astNode.parent) + ";" + Integer.toString(1);
        }
        if (node instanceof Examples) {
            return calculateId(astNode.parent) + ";" + convertToId(((Examples) node).getName());
        }
        if (node instanceof Feature) {
            return convertToId(((Feature) node).getName());
        }
        return "";
    }

    static String convertToId(String str) {
        return str.replaceAll("[\\s'_,!]", "-").toLowerCase();
    }

    void addTestSourceReadEvent(String str, TestSourceRead testSourceRead) {
        this.pathToReadEventMap.put(str, testSourceRead);
    }

    Feature getFeature(String str) {
        if (!this.pathToAstMap.containsKey(str)) {
            parseGherkinSource(str);
        }
        if (this.pathToAstMap.containsKey(str)) {
            return ((GherkinDocument) this.pathToAstMap.get(str)).getFeature();
        }
        return null;
    }

    AstNode getAstNode(String str, int i) {
        if (!this.pathToNodeMap.containsKey(str)) {
            parseGherkinSource(str);
        }
        if (this.pathToNodeMap.containsKey(str)) {
            return (AstNode) ((Map) this.pathToNodeMap.get(str)).get(Integer.valueOf(i));
        }
        return null;
    }

    String getFeatureName(String str) {
        Feature feature = getFeature(str);
        if (feature != null) {
            return feature.getName();
        }
        return "";
    }

    private void parseGherkinSource(String str) {
        if (this.pathToReadEventMap.containsKey(str)) {
            try {
                GherkinDocument gherkinDocument = (GherkinDocument) new Parser(new AstBuilder()).parse(((TestSourceRead) this.pathToReadEventMap.get(str)).source, new TokenMatcher());
                this.pathToAstMap.put(str, gherkinDocument);
                HashMap map = new HashMap();
                AstNode astNode = new AstNode(gherkinDocument.getFeature(), null);
                Iterator<ScenarioDefinition> it = gherkinDocument.getFeature().getChildren().iterator();
                while (it.hasNext()) {
                    processScenarioDefinition(map, it.next(), astNode);
                }
                this.pathToNodeMap.put(str, map);
            } catch (ParserException unused) {
            }
        }
    }

    private void processScenarioDefinition(Map map, ScenarioDefinition scenarioDefinition, AstNode astNode) {
        AstNode astNode2 = new AstNode(scenarioDefinition, astNode);
        map.put(Integer.valueOf(scenarioDefinition.getLocation().getLine()), astNode2);
        for (Step step : scenarioDefinition.getSteps()) {
            map.put(Integer.valueOf(step.getLocation().getLine()), new AstNode(step, astNode2));
        }
        if (scenarioDefinition instanceof ScenarioOutline) {
            processScenarioOutlineExamples(map, (ScenarioOutline) scenarioDefinition, astNode2);
        }
    }

    private void processScenarioOutlineExamples(Map map, ScenarioOutline scenarioOutline, AstNode astNode) {
        for (Examples examples : scenarioOutline.getExamples()) {
            AstNode astNode2 = new AstNode(examples, astNode);
            TableRow tableHeader = examples.getTableHeader();
            map.put(Integer.valueOf(tableHeader.getLocation().getLine()), new AstNode(tableHeader, astNode2));
            for (int i = 0; i < examples.getTableBody().size(); i++) {
                TableRow tableRow = examples.getTableBody().get(i);
                map.put(Integer.valueOf(tableRow.getLocation().getLine()), new AstNode(new ExamplesRowWrapperNode(tableRow, i), astNode2));
            }
        }
    }

    class ExamplesRowWrapperNode extends Node {
        final int bodyRowIndex;

        ExamplesRowWrapperNode(Node node, int i) {
            super(node.getLocation());
            this.bodyRowIndex = i;
        }
    }

    class AstNode {
        final Node node;
        final AstNode parent;

        AstNode(Node node, AstNode astNode) {
            this.node = node;
            this.parent = astNode;
        }
    }
}
