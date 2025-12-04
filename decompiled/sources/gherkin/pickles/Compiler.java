package gherkin.pickles;

import gherkin.SymbolCounter;
import gherkin.ast.Background;
import gherkin.ast.DataTable;
import gherkin.ast.DocString;
import gherkin.ast.Examples;
import gherkin.ast.Feature;
import gherkin.ast.GherkinDocument;
import gherkin.ast.Location;
import gherkin.ast.Node;
import gherkin.ast.Scenario;
import gherkin.ast.ScenarioDefinition;
import gherkin.ast.ScenarioOutline;
import gherkin.ast.Step;
import gherkin.ast.TableCell;
import gherkin.ast.TableRow;
import gherkin.ast.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class Compiler {
    public List<Pickle> compile(GherkinDocument gherkinDocument) {
        ScenarioDefinition next;
        ArrayList arrayList = new ArrayList();
        Feature feature = gherkinDocument.getFeature();
        if (feature == null) {
            return arrayList;
        }
        String language = feature.getLanguage();
        List<Tag> tags = feature.getTags();
        List arrayList2 = new ArrayList();
        Iterator<ScenarioDefinition> it = feature.getChildren().iterator();
        while (true) {
            List list = arrayList2;
            while (it.hasNext()) {
                next = it.next();
                if (next instanceof Background) {
                    break;
                }
                if (next instanceof Scenario) {
                    compileScenario(arrayList, list, (Scenario) next, tags, language);
                } else {
                    compileScenarioOutline(arrayList, list, (ScenarioOutline) next, tags, language);
                }
            }
            return arrayList;
            arrayList2 = pickleSteps(next);
        }
    }

    private void compileScenario(List list, List list2, Scenario scenario, List list3, String str) {
        ArrayList arrayList = new ArrayList();
        if (!scenario.getSteps().isEmpty()) {
            arrayList.addAll(list2);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list3);
        arrayList2.addAll(scenario.getTags());
        arrayList.addAll(pickleSteps(scenario));
        list.add(new Pickle(scenario.getName(), str, arrayList, pickleTags(arrayList2), Collections.singletonList(pickleLocation(scenario.getLocation()))));
    }

    private void compileScenarioOutline(List list, List list2, ScenarioOutline scenarioOutline, List list3, String str) {
        Iterator<Examples> it = scenarioOutline.getExamples().iterator();
        while (it.hasNext()) {
            Examples next = it.next();
            if (next.getTableHeader() != null) {
                List<TableCell> cells = next.getTableHeader().getCells();
                for (TableRow tableRow : next.getTableBody()) {
                    List<TableCell> cells2 = tableRow.getCells();
                    ArrayList arrayList = new ArrayList();
                    if (!scenarioOutline.getSteps().isEmpty()) {
                        arrayList.addAll(list2);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(list3);
                    arrayList2.addAll(scenarioOutline.getTags());
                    arrayList2.addAll(next.getTags());
                    for (Step step : scenarioOutline.getSteps()) {
                        arrayList.add(new PickleStep(interpolate(step.getText(), cells, cells2), createPickleArguments(step.getArgument(), cells, cells2), Arrays.asList(pickleLocation(tableRow.getLocation()), pickleStepLocation(step))));
                        it = it;
                    }
                    list.add(new Pickle(interpolate(scenarioOutline.getName(), cells, cells2), str, arrayList, pickleTags(arrayList2), Arrays.asList(pickleLocation(tableRow.getLocation()), pickleLocation(scenarioOutline.getLocation()))));
                    it = it;
                }
            }
        }
    }

    private List createPickleArguments(Node node) {
        List listEmptyList = Collections.emptyList();
        return createPickleArguments(node, listEmptyList, listEmptyList);
    }

    private List createPickleArguments(Node node, List list, List list2) {
        ArrayList arrayList = new ArrayList();
        if (node == null) {
            return arrayList;
        }
        if (node instanceof DataTable) {
            List<TableRow> rows = ((DataTable) node).getRows();
            ArrayList arrayList2 = new ArrayList(rows.size());
            Iterator<TableRow> it = rows.iterator();
            while (it.hasNext()) {
                List<TableCell> cells = it.next().getCells();
                ArrayList arrayList3 = new ArrayList();
                for (TableCell tableCell : cells) {
                    arrayList3.add(new PickleCell(pickleLocation(tableCell.getLocation()), interpolate(tableCell.getValue(), list, list2)));
                }
                arrayList2.add(new PickleRow(arrayList3));
            }
            arrayList.add(new PickleTable(arrayList2));
        } else if (node instanceof DocString) {
            DocString docString = (DocString) node;
            arrayList.add(new PickleString(pickleLocation(docString.getLocation()), interpolate(docString.getContent(), list, list2), docString.getContentType() == null ? null : interpolate(docString.getContentType(), list, list2)));
        } else {
            throw new RuntimeException("Unexpected argument type: " + node);
        }
        return arrayList;
    }

    private List pickleSteps(ScenarioDefinition scenarioDefinition) {
        ArrayList arrayList = new ArrayList();
        Iterator<Step> it = scenarioDefinition.getSteps().iterator();
        while (it.hasNext()) {
            arrayList.add(pickleStep(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private PickleStep pickleStep(Step step) {
        return new PickleStep(step.getText(), createPickleArguments(step.getArgument()), Collections.singletonList(pickleStepLocation(step)));
    }

    private String interpolate(String str, List list, List list2) {
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            TableCell tableCell = (TableCell) it.next();
            int i2 = i + 1;
            TableCell tableCell2 = (TableCell) list2.get(i);
            String value = tableCell.getValue();
            str = str.replace("<" + value + ">", tableCell2.getValue());
            i = i2;
        }
        return str;
    }

    private PickleLocation pickleStepLocation(Step step) {
        return new PickleLocation(step.getLocation().getLine(), step.getLocation().getColumn() + (step.getKeyword() != null ? SymbolCounter.countSymbols(step.getKeyword()) : 0));
    }

    private PickleLocation pickleLocation(Location location) {
        return new PickleLocation(location.getLine(), location.getColumn());
    }

    private List pickleTags(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(pickleTag((Tag) it.next()));
        }
        return arrayList;
    }

    private PickleTag pickleTag(Tag tag) {
        return new PickleTag(pickleLocation(tag.getLocation()), tag.getName());
    }
}
