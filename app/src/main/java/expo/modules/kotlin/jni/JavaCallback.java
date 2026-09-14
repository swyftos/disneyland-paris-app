package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.JSTypeConverterHelperKt;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0082 ¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\fH\u0082 ¢\u0006\u0004\b\u0007\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH\u0082 ¢\u0006\u0004\b\u0007\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0013J \u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0016J&\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0019H\u0082 ¢\u0006\u0004\b\u0007\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001bH\u0082 ¢\u0006\u0004\b\u0007\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001dH\u0082 ¢\u0006\u0004\b\u0007\u0010\u001eJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0082 ¢\u0006\u0004\b\u0007\u0010!J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\"H\u0082 ¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020%H\u0082 ¢\u0006\u0004\b&\u0010'J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020(H\u0082 ¢\u0006\u0004\b)\u0010*J\u0018\u0010,\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020+H\u0082 ¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0015H\u0086\u0002¢\u0006\u0004\b/\u00100J\u0010\u0010/\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b/\u0010\bJ\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b/\u0010\u000bJ\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\fH\u0086\u0002¢\u0006\u0004\b/\u0010\rJ\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b/\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\b/\u0010\u0011J\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0004\b/\u0010\u0013J \u0010/\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0086\u0002¢\u0006\u0004\b/\u0010\u0016J&\u0010/\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017H\u0086\u0002¢\u0006\u0004\b/\u0010\u0018J \u0010/\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0086\u0002¢\u0006\u0004\b/\u0010!J\u000f\u00101\u001a\u00020\u0006H\u0004¢\u0006\u0004\b1\u0010\bJ\u000f\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103¨\u00064"}, m1836d2 = {"Lexpo/modules/kotlin/jni/JavaCallback;", "Lexpo/modules/kotlin/jni/Destructible;", "Lcom/facebook/jni/HybridData;", "mHybridData", "<init>", "(Lcom/facebook/jni/HybridData;)V", "", "invokeNative", "()V", "", "result", "(I)V", "", "(Z)V", "", "(D)V", "", "(F)V", "", "(Ljava/lang/String;)V", "", "", "(Ljava/util/Collection;)V", "", "(Ljava/util/Map;)V", "Lcom/facebook/react/bridge/WritableNativeArray;", "(Lcom/facebook/react/bridge/WritableNativeArray;)V", "Lcom/facebook/react/bridge/WritableNativeMap;", "(Lcom/facebook/react/bridge/WritableNativeMap;)V", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "(Lexpo/modules/kotlin/sharedobjects/SharedObject;)V", "code", "errorMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "", "invokeIntArray", "([I)V", "", "invokeLongArray", "([J)V", "", "invokeFloatArray", "([F)V", "", "invokeDoubleArray", "([D)V", "value", "invoke", "(Ljava/lang/Object;)V", "finalize", "deallocate", "Lcom/facebook/jni/HybridData;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
@SourceDebugExtension({"SMAP\nJavaCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaCallback.kt\nexpo/modules/kotlin/jni/JavaCallback\n*L\n1#1,121:1\n99#1,12:122\n99#1,12:134\n99#1,12:146\n99#1,12:158\n99#1,12:170\n99#1,12:182\n99#1,12:194\n99#1,12:206\n99#1,12:218\n99#1,12:230\n*S KotlinDebug\n*F\n+ 1 JavaCallback.kt\nexpo/modules/kotlin/jni/JavaCallback\n*L\n16#1:122,12\n44#1:134,12\n48#1:146,12\n52#1:158,12\n56#1:170,12\n60#1:182,12\n64#1:194,12\n68#1:206,12\n72#1:218,12\n76#1:230,12\n*E\n"})
public final class JavaCallback implements Destructible {

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData;

    private final native void invokeDoubleArray(double[] result);

    private final native void invokeFloatArray(float[] result);

    private final native void invokeIntArray(int[] result);

    private final native void invokeLongArray(long[] result);

    private final native void invokeNative();

    private final native void invokeNative(double result);

    private final native void invokeNative(float result);

    private final native void invokeNative(int result);

    private final native void invokeNative(WritableNativeArray result);

    private final native void invokeNative(WritableNativeMap result);

    private final native void invokeNative(SharedObject result);

    private final native void invokeNative(String result);

    private final native void invokeNative(String code, String errorMessage);

    private final native void invokeNative(Collection<? extends Object> result);

    private final native void invokeNative(Map<String, ? extends Object> result);

    private final native void invokeNative(boolean result);

    @DoNotStrip
    public JavaCallback(@NotNull HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }

    public final void invoke(@Nullable Object value) {
        try {
            Object objConvertToJSValue$default = JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, value, null, true, 2, null);
            if (objConvertToJSValue$default == null) {
                invokeNative();
                return;
            }
            if (objConvertToJSValue$default instanceof Integer) {
                invokeNative(((Number) objConvertToJSValue$default).intValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Boolean) {
                invokeNative(((Boolean) objConvertToJSValue$default).booleanValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Double) {
                invokeNative(((Number) objConvertToJSValue$default).doubleValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Float) {
                invokeNative(((Number) objConvertToJSValue$default).floatValue());
                return;
            }
            if (objConvertToJSValue$default instanceof String) {
                invokeNative((String) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof Collection) {
                invokeNative((Collection<? extends Object>) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof Map) {
                invokeNative((Map<String, ? extends Object>) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof WritableNativeArray) {
                invokeNative((WritableNativeArray) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof WritableNativeMap) {
                invokeNative((WritableNativeMap) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof SharedObject) {
                invokeNative((SharedObject) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof int[]) {
                invokeIntArray((int[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof long[]) {
                invokeLongArray((long[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof float[]) {
                invokeFloatArray((float[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof double[]) {
                invokeDoubleArray((double[]) objConvertToJSValue$default);
                return;
            }
            throw new UnexpectedException("Unknown type: " + objConvertToJSValue$default.getClass());
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke() {
        try {
            invokeNative();
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(int result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(boolean result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(double result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(float result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(@NotNull Collection<? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(JSTypeConverterHelperKt.toJSValueExperimental(result));
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(@NotNull Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(JSTypeConverterHelperKt.toJSValueExperimental(result));
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(@NotNull String code, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        try {
            invokeNative(code, errorMessage);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }
}
