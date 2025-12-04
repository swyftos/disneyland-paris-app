package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
final class ClassValueReferences extends ClassValue {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassValue
    public MutableSoftReference computeValue(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new MutableSoftReference();
    }
}
