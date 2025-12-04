package androidx.test.espresso.core.internal.deps.guava.collect;

import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;

/* loaded from: classes2.dex */
public final class Collections2 {
    static StringBuilder newStringBuilderForCollection(int i) {
        CollectPreconditions.checkNonnegative(i, TCEventPropertiesNames.TCP_SIZE);
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }
}
