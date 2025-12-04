package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class Feature extends Node {
    private final List children;
    private final String description;
    private final String keyword;
    private final String language;
    private final String name;
    private final List tags;

    public Feature(List<Tag> list, Location location, String str, String str2, String str3, String str4, List<ScenarioDefinition> list2) {
        super(location);
        this.tags = Collections.unmodifiableList(list);
        this.language = str;
        this.keyword = str2;
        this.name = str3;
        this.description = str4;
        this.children = Collections.unmodifiableList(list2);
    }

    public List<ScenarioDefinition> getChildren() {
        return this.children;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Tag> getTags() {
        return this.tags;
    }
}
