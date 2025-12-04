package cucumber.runtime.java;

import cucumber.runtime.snippets.Snippet;
import io.cucumber.datatable.DataTable;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes5.dex */
abstract class AbstractJavaSnippet implements Snippet {
    AbstractJavaSnippet() {
    }

    @Override // cucumber.runtime.snippets.Snippet
    public final String arguments(Map map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(getArgType((Type) entry.getValue()));
            sb.append(" ");
            sb.append((String) entry.getKey());
        }
        return sb.toString();
    }

    private String getArgType(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.equals(DataTable.class)) {
                return cls.getName();
            }
            return cls.getSimpleName();
        }
        return type.toString();
    }

    @Override // cucumber.runtime.snippets.Snippet
    public final String tableHint() {
        return "    // For automatic transformation, change DataTable to one of\n    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or\n    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,\n    // Double, Byte, Short, Long, BigInteger or BigDecimal.\n    //\n    // For other transformations you can register a DataTableType.\n";
    }

    @Override // cucumber.runtime.snippets.Snippet
    public final String escapePattern(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
