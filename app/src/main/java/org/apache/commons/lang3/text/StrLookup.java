package org.apache.commons.lang3.text;

import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class StrLookup<V> {
    private static final StrLookup NONE_LOOKUP = new MapStrLookup(null);
    private static final StrLookup SYSTEM_PROPERTIES_LOOKUP = new SystemPropertiesStrLookup();

    public abstract String lookup(String str);

    private static final class MapStrLookup extends StrLookup {
        private final Map map;

        MapStrLookup(Map map) {
            this.map = map;
        }

        @Override // org.apache.commons.lang3.text.StrLookup
        public String lookup(String str) {
            Map map = this.map;
            if (map == null) {
                return null;
            }
            return Objects.toString(map.get(str), null);
        }
    }

    private static final class SystemPropertiesStrLookup extends StrLookup {
        private SystemPropertiesStrLookup() {
        }

        @Override // org.apache.commons.lang3.text.StrLookup
        public String lookup(String str) {
            return SystemProperties.getProperty(str);
        }
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup(map);
    }

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    protected StrLookup() {
    }
}
