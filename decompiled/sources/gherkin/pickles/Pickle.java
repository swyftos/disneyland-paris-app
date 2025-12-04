package gherkin.pickles;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class Pickle {
    private final String language;
    private final List locations;
    private final String name;
    private final List steps;
    private final List tags;

    public Pickle(String str, String str2, List<PickleStep> list, List<PickleTag> list2, List<PickleLocation> list3) {
        this.name = str;
        this.language = str2;
        this.steps = Collections.unmodifiableList(list);
        this.tags = list2;
        this.locations = Collections.unmodifiableList(list3);
    }

    public String getName() {
        return this.name;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<PickleStep> getSteps() {
        return this.steps;
    }

    public List<PickleLocation> getLocations() {
        return this.locations;
    }

    public List<PickleTag> getTags() {
        return this.tags;
    }
}
