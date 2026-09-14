package com.amazonaws.services.p017s3.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ExtraMaterialsDescription implements Serializable {
    public static final ExtraMaterialsDescription NONE = new ExtraMaterialsDescription(Collections.EMPTY_MAP);
    private final Map extra;
    private final ConflictResolution resolve;

    public enum ConflictResolution {
        FAIL_FAST,
        OVERRIDE,
        OVERRIDDEN
    }

    public ExtraMaterialsDescription(Map<String, String> map) {
        this(map, ConflictResolution.FAIL_FAST);
    }

    public ExtraMaterialsDescription(Map<String, String> map, ConflictResolution conflictResolution) {
        if (map == null || conflictResolution == null) {
            throw new IllegalArgumentException();
        }
        this.extra = Collections.unmodifiableMap(new HashMap(map));
        this.resolve = conflictResolution;
    }

    public Map<String, String> getMaterialDescription() {
        return this.extra;
    }

    public ConflictResolution getConflictResolution() {
        return this.resolve;
    }

    public Map<String, String> mergeInto(Map<String, String> map) {
        if (this.extra.size() == 0) {
            return map;
        }
        if (map == null || map.size() == 0) {
            return this.extra;
        }
        int i = C20281.f386xb3b15629[this.resolve.ordinal()];
        if (i == 1) {
            int size = map.size() + this.extra.size();
            HashMap map2 = new HashMap(map);
            map2.putAll(this.extra);
            if (size != map2.size()) {
                throw new IllegalArgumentException("The supplemental material descriptions contains conflicting entries");
            }
            return Collections.unmodifiableMap(map2);
        }
        if (i == 2) {
            HashMap map3 = new HashMap(this.extra);
            map3.putAll(map);
            return Collections.unmodifiableMap(map3);
        }
        if (i == 3) {
            HashMap map4 = new HashMap(map);
            map4.putAll(this.extra);
            return Collections.unmodifiableMap(map4);
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: com.amazonaws.services.s3.model.ExtraMaterialsDescription$1 */
    static /* synthetic */ class C20281 {

        /* JADX INFO: renamed from: $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution */
        static final /* synthetic */ int[] f386xb3b15629;

        static {
            int[] iArr = new int[ConflictResolution.values().length];
            f386xb3b15629 = iArr;
            try {
                iArr[ConflictResolution.FAIL_FAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f386xb3b15629[ConflictResolution.OVERRIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f386xb3b15629[ConflictResolution.OVERRIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
