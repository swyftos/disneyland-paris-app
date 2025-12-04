package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class ScenarioDefinition extends Node {
    private final String description;
    private final String keyword;
    private final String name;
    private final List steps;

    public ScenarioDefinition(Location location, String str, String str2, String str3, List<Step> list) {
        super(location);
        this.keyword = str;
        this.name = str2;
        this.description = str3;
        this.steps = Collections.unmodifiableList(list);
    }

    public String getName() {
        return this.name;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Step> getSteps() {
        return this.steps;
    }
}
