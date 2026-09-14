package expo.modules.core.arguments;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class MapArguments implements ReadableArguments {
    private Map mMap;

    public MapArguments() {
        this.mMap = new HashMap();
    }

    public MapArguments(Map<String, Object> map) {
        this.mMap = map;
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public Collection<String> keys() {
        return this.mMap.keySet();
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public boolean containsKey(String str) {
        return this.mMap.containsKey(str);
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public Object get(String str) {
        return this.mMap.get(str);
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public boolean getBoolean(String str, boolean z) {
        Object obj = this.mMap.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public double getDouble(String str, double d) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public int getInt(String str, int i) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public String getString(String str, String str2) {
        Object obj = this.mMap.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public List getList(String str, List list) {
        Object obj = this.mMap.get(str);
        return obj instanceof List ? (List) obj : list;
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public Map getMap(String str, Map map) {
        Object obj = this.mMap.get(str);
        return obj instanceof Map ? (Map) obj : map;
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    @Override // expo.modules.core.arguments.ReadableArguments
    public int size() {
        return this.mMap.size();
    }
}
