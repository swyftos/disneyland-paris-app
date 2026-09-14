package expo.modules.core;

import androidx.camera.video.AudioStats;
import expo.modules.core.interfaces.Arguments;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class MapHelper implements Arguments {
    private Map mMap;

    public MapHelper(Map map) {
        this.mMap = map;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public boolean containsKey(String str) {
        return this.mMap.containsKey(str);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public Object get(String str) {
        return this.mMap.get(str);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public boolean getBoolean(String str, boolean z) {
        Object obj = this.mMap.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public double getDouble(String str) {
        return getDouble(str, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public double getDouble(String str, double d) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public int getInt(String str, int i) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public long getLong(String str) {
        return getLong(str, 0L);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public long getLong(String str, long j) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).longValue() : j;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public String getString(String str, String str2) {
        Object obj = this.mMap.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public List getList(String str) {
        return getList(str, null);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public List getList(String str, List list) {
        Object obj = this.mMap.get(str);
        return obj instanceof List ? (List) obj : list;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public Map getMap(String str) {
        return getMap(str, null);
    }

    @Override // expo.modules.core.interfaces.Arguments
    public Map getMap(String str, Map map) {
        Object obj = this.mMap.get(str);
        return obj instanceof Map ? (Map) obj : map;
    }

    @Override // expo.modules.core.interfaces.Arguments
    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    @Override // expo.modules.core.interfaces.Arguments
    public int size() {
        return this.mMap.size();
    }

    @Override // expo.modules.core.interfaces.Arguments
    public Arguments getArguments(String str) {
        Map map = getMap(str);
        if (map != null) {
            return new MapHelper(map);
        }
        return null;
    }
}
