package cucumber.runner;

import cucumber.runtime.CucumberException;
import gherkin.pickles.PickleStep;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class AmbiguousStepDefinitionsException extends CucumberException {
    private final List matches;

    AmbiguousStepDefinitionsException(PickleStep pickleStep, List list) {
        super(createMessage(pickleStep, list));
        this.matches = list;
    }

    private static String createMessage(PickleStep pickleStep, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append(quoteText(pickleStep.getText()));
        sb.append(" matches more than one step definition:\n");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PickleStepDefinitionMatch pickleStepDefinitionMatch = (PickleStepDefinitionMatch) it.next();
            sb.append("  ");
            sb.append(quoteText(pickleStepDefinitionMatch.getPattern()));
            sb.append(" in ");
            sb.append(pickleStepDefinitionMatch.getLocation());
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String quoteText(String str) {
        return "\"" + str + "\"";
    }

    public List<PickleStepDefinitionMatch> getMatches() {
        return this.matches;
    }
}
