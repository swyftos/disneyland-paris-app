package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
final class MutableSoftReference {
    public volatile SoftReference reference = new SoftReference(null);

    public final synchronized Object getOrSetWithLock(Function0 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Object obj = this.reference.get();
        if (obj != null) {
            return obj;
        }
        Object objInvoke = factory.invoke();
        this.reference = new SoftReference(objInvoke);
        return objInvoke;
    }
}
