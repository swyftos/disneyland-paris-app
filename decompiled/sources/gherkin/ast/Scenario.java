package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class Scenario extends ScenarioDefinition {
    private final List tags;

    public Scenario(List<Tag> list, Location location, String str, String str2, String str3, List<Step> list2) {
        super(location, str, str2, str3, list2);
        this.tags = Collections.unmodifiableList(list);
    }

    public List<Tag> getTags() {
        return this.tags;
    }
}
