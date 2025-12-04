package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class ScenarioOutline extends ScenarioDefinition {
    private final List examples;
    private final List tags;

    public ScenarioOutline(List<Tag> list, Location location, String str, String str2, String str3, List<Step> list2, List<Examples> list3) {
        super(location, str, str2, str3, list2);
        this.tags = Collections.unmodifiableList(list);
        this.examples = Collections.unmodifiableList(list3);
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public List<Examples> getExamples() {
        return this.examples;
    }
}
