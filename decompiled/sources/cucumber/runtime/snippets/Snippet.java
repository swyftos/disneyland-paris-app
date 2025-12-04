package cucumber.runtime.snippets;

import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes5.dex */
public interface Snippet {
    String arguments(Map<String, Type> map);

    String escapePattern(String str);

    String tableHint();

    String template();
}
