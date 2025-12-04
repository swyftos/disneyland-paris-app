package gherkin.pickles;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class PickleStep {
    private final List arguments;
    private final List locations;
    private final String text;

    public PickleStep(String str, List<Argument> list, List<PickleLocation> list2) {
        this.text = str;
        this.arguments = Collections.unmodifiableList(list);
        this.locations = Collections.unmodifiableList(list2);
    }

    public String getText() {
        return this.text;
    }

    public List<PickleLocation> getLocations() {
        return this.locations;
    }

    public List<Argument> getArgument() {
        return this.arguments;
    }
}
