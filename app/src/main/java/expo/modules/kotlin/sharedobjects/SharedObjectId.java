package expo.modules.kotlin.sharedobjects;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, m1836d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toNativeObject", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "toNativeObject-impl", "(ILexpo/modules/kotlin/RuntimeContext;)Lexpo/modules/kotlin/sharedobjects/SharedObject;", "toNativeObjectOrNull", "toNativeObjectOrNull-impl", "toJavaScriptObjectNull", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "toJavaScriptObjectNull-impl", "(ILexpo/modules/kotlin/RuntimeContext;)Lexpo/modules/kotlin/jni/JavaScriptObject;", "toWeakJavaScriptObjectNull", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "toWeakJavaScriptObjectNull-impl", "(ILexpo/modules/kotlin/RuntimeContext;)Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@JvmInline
public final class SharedObjectId {
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SharedObjectId m5243boximpl(int i) {
        return new SharedObjectId(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5244constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5245equalsimpl(int i, Object obj) {
        return (obj instanceof SharedObjectId) && i == ((SharedObjectId) obj).m5253unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5246equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5247hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5251toStringimpl(int i) {
        return "SharedObjectId(value=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m5245equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5247hashCodeimpl(this.value);
    }

    public String toString() {
        return m5251toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5253unboximpl() {
        return this.value;
    }

    private /* synthetic */ SharedObjectId(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    @NotNull
    /* JADX INFO: renamed from: toNativeObject-impl, reason: not valid java name */
    public static final SharedObject m5249toNativeObjectimpl(int i, @NotNull RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        return runtimeContext.getSharedObjectRegistry().m5258toNativeObjectkyJHjyY$expo_modules_core_release(i);
    }

    @Nullable
    /* JADX INFO: renamed from: toNativeObjectOrNull-impl, reason: not valid java name */
    public static final SharedObject m5250toNativeObjectOrNullimpl(int i, @NotNull RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        return runtimeContext.getSharedObjectRegistry().m5259toNativeObjectOrNullkyJHjyY$expo_modules_core_release(i);
    }

    @Nullable
    /* JADX INFO: renamed from: toJavaScriptObjectNull-impl, reason: not valid java name */
    public static final JavaScriptObject m5248toJavaScriptObjectNullimpl(int i, @NotNull RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        SharedObject sharedObjectM5250toNativeObjectOrNullimpl = m5250toNativeObjectOrNullimpl(i, runtimeContext);
        if (sharedObjectM5250toNativeObjectOrNullimpl == null) {
            return null;
        }
        return runtimeContext.getSharedObjectRegistry().toJavaScriptObjectOrNull$expo_modules_core_release(sharedObjectM5250toNativeObjectOrNullimpl);
    }

    @Nullable
    /* JADX INFO: renamed from: toWeakJavaScriptObjectNull-impl, reason: not valid java name */
    public static final JavaScriptWeakObject m5252toWeakJavaScriptObjectNullimpl(int i, @NotNull RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        SharedObject sharedObjectM5250toNativeObjectOrNullimpl = m5250toNativeObjectOrNullimpl(i, runtimeContext);
        if (sharedObjectM5250toNativeObjectOrNullimpl == null) {
            return null;
        }
        return runtimeContext.getSharedObjectRegistry().toWeakJavaScriptObjectOrNull$expo_modules_core_release(sharedObjectM5250toNativeObjectOrNullimpl);
    }
}
