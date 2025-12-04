package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class GherkinDocument extends Node {
    private final List comments;
    private final Feature feature;

    public GherkinDocument(Feature feature, List<Comment> list) {
        super(null);
        this.feature = feature;
        this.comments = Collections.unmodifiableList(list);
    }

    public Feature getFeature() {
        return this.feature;
    }

    public List<Comment> getComments() {
        return this.comments;
    }
}
