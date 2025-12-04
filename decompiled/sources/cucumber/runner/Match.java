package cucumber.runner;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
class Match {
    public static final Match UNDEFINED = new Match(Collections.emptyList(), null);
    private final List arguments;
    private final String location;

    Match(List list, String str) {
        Objects.requireNonNull(list, "argument may not be null");
        this.arguments = list;
        this.location = str;
    }

    public List getArguments() {
        return this.arguments;
    }

    public String getLocation() {
        return this.location;
    }
}
