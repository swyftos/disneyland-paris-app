package org.picocontainer;

import java.util.Map;
import java.util.Properties;

/* loaded from: classes6.dex */
public final class Characteristics {
    public static final Properties AUTOMATIC;
    public static final Properties CACHE;
    public static final Properties EMJECTION_ENABLED;
    public static final Properties ENABLE_CIRCULAR;
    public static final String FALSE = "false";
    public static final Properties GUARD;
    public static final Properties HIDE_IMPL;
    public static final Properties LOCK;
    public static final Properties NONE;
    public static final Properties NO_CACHE;
    public static final Properties NO_HIDE_IMPL;
    public static final Properties NO_LOCK;
    public static final Properties NO_PROPERTY_APPLYING;
    public static final Properties NO_SINGLE;
    public static final Properties NO_SYNCHRONIZE;
    public static final Properties PROPERTY_APPLYING;
    public static final Properties SINGLE;
    public static final Properties SYNCHRONIZE;
    public static final String TRUE = "true";
    public static final Properties USE_NAMES;
    public static final Properties CDI = immutable("injection", "constructor");
    public static final Properties SDI = immutable("injection", "setter");
    public static final Properties METHOD_INJECTION = immutable("injection", "method");

    static {
        Properties propertiesImmutable = immutable("cache", "false");
        NO_CACHE = propertiesImmutable;
        Properties propertiesImmutable2 = immutable("cache", TRUE);
        CACHE = propertiesImmutable2;
        SYNCHRONIZE = immutable("synchronizing", TRUE);
        NO_SYNCHRONIZE = immutable("synchronizing", "false");
        LOCK = immutable("locking", TRUE);
        NO_LOCK = immutable("locking", "false");
        SINGLE = propertiesImmutable2;
        NO_SINGLE = propertiesImmutable;
        HIDE_IMPL = immutable("hide-impl", TRUE);
        NO_HIDE_IMPL = immutable("hide-impl", "false");
        ENABLE_CIRCULAR = immutable("enable-circular", TRUE);
        NONE = immutable("none", "");
        PROPERTY_APPLYING = immutable("property-applying", TRUE);
        NO_PROPERTY_APPLYING = immutable("property-applying", "false");
        AUTOMATIC = immutable("automatic", TRUE);
        USE_NAMES = immutable("use-parameter-names", TRUE);
        EMJECTION_ENABLED = immutable("emjection_enabled", TRUE);
        GUARD = immutable("guard", "guard");
    }

    public static final Properties GUARD(String str) {
        return immutable("guard", str);
    }

    public static Properties immutable(String str, String str2) {
        return new ImmutableProperties(str, str2);
    }

    public static class ImmutableProperties extends Properties {
        private boolean sealed;

        public ImmutableProperties(String str, String str2) {
            this.sealed = false;
            super.setProperty(str, str2);
            this.sealed = true;
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object remove(Object obj) {
            throw new UnsupportedOperationException("immutable properties are read only");
        }

        @Override // java.util.Properties
        public synchronized Object setProperty(String str, String str2) {
            throw new UnsupportedOperationException("immutable properties are read only");
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized void clear() {
            throw new UnsupportedOperationException("immutable properties are read only");
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public synchronized Object put(Object obj, Object obj2) {
            if (!this.sealed) {
            } else {
                throw new UnsupportedOperationException("immutable properties are read only");
            }
            return super.put(obj, obj2);
        }

        @Override // java.util.Hashtable, java.util.Map
        public synchronized void putAll(Map<? extends Object, ? extends Object> map) {
            throw new UnsupportedOperationException("immutable properties are read only");
        }
    }
}
