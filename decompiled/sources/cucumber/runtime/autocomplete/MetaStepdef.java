package cucumber.runtime.autocomplete;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class MetaStepdef {
    private static final Gson GSON = new GsonBuilder().create();
    public String flags;
    private transient Pattern pattern;
    public String source;
    public final SortedSet<MetaStep> steps = new TreeSet();

    public static class MetaArgument {
        public int offset;
        public String val;
    }

    public boolean matches(String str) {
        Matcher matcher = pattern().matcher(str);
        return matcher.matches() || matcher.hitEnd();
    }

    private Pattern pattern() {
        if (this.pattern == null) {
            this.pattern = Pattern.compile(this.source);
        }
        return this.pattern;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MetaStepdef metaStepdef = (MetaStepdef) obj;
        return this.flags.equals(metaStepdef.flags) && this.source.equals(metaStepdef.source) && this.steps.equals(metaStepdef.steps);
    }

    public int hashCode() {
        return (((this.steps.hashCode() * 31) + this.source.hashCode()) * 31) + this.flags.hashCode();
    }

    public String toString() {
        return GSON.toJson(this);
    }

    public static class MetaStep implements Comparable<MetaStep> {
        public final List<MetaArgument> args = new ArrayList();
        public String name;

        @Override // java.lang.Comparable
        public int compareTo(MetaStep metaStep) {
            return this.name.compareTo(metaStep.name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MetaStep metaStep = (MetaStep) obj;
            return this.args.equals(metaStep.args) && this.name.equals(metaStep.name);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.args.hashCode();
        }
    }
}
