package expo.modules.kotlin.jni;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.jni.HybridData;
import expo.modules.core.interfaces.DoNotStrip;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\t\u0010\b\u001a\u00020\tH\u0086 J\t\u0010\n\u001a\u00020\u0007H\u0086 J\t\u0010\u000b\u001a\u00020\u0007H\u0086 J\t\u0010\f\u001a\u00020\u0007H\u0086 J\t\u0010\r\u001a\u00020\u0007H\u0086 J\t\u0010\u000e\u001a\u00020\u0007H\u0086 J\t\u0010\u000f\u001a\u00020\u0007H\u0086 J\t\u0010\u0010\u001a\u00020\u0007H\u0086 J\t\u0010\u0011\u001a\u00020\u0007H\u0086 J\t\u0010\u0012\u001a\u00020\u0007H\u0086 J\t\u0010\u0013\u001a\u00020\u0007H\u0086 J\t\u0010\u0014\u001a\u00020\u0007H\u0086 J\t\u0010\u0015\u001a\u00020\u0016H\u0086 J\t\u0010\u0017\u001a\u00020\tH\u0086 J\t\u0010\u0018\u001a\u00020\u0019H\u0086 J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u001bH\u0086 ¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u001eH\u0086 J\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H!0 \"\n\b\u0000\u0010!*\u0004\u0018\u00010\"H\u0082 J\u001a\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0 \"\n\b\u0000\u0010!*\u0004\u0018\u00010\"H\u0001J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u0002H%0 \"\f\b\u0000\u0010%\u0018\u0001*\u0004\u0018\u00010\"H\u0086\bJ\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020&0 H\u0007¢\u0006\u0002\b'J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020&H\u0004J\b\u0010/\u001a\u00020&H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m1836d2 = {"Lexpo/modules/kotlin/jni/JavaScriptValue;", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "isValid", "", "kind", "", "isNull", "isUndefined", "isBool", "isNumber", "isString", "isSymbol", "isFunction", "isArray", "isTypedArray", "isObject", "getBool", "getDouble", "", "getString", "getObject", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "getArray", "", "()[Lexpo/modules/kotlin/jni/JavaScriptValue;", "getTypedArray", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "jniGetFunction", "Lexpo/modules/kotlin/jni/JavaScriptFunction;", ExifInterface.GPS_DIRECTION_TRUE, "", "internalJniGetFunction", "getFunction", "ReturnType", "", "getVoidFunction", "getInt", "", "getLong", "", "getFloat", "", "finalize", "deallocate", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
public final class JavaScriptValue implements Destructible {

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData;

    private final native <T> JavaScriptFunction<T> jniGetFunction();

    @NotNull
    public final native JavaScriptValue[] getArray();

    public final native boolean getBool();

    public final native double getDouble();

    @NotNull
    public final native JavaScriptObject getObject();

    @NotNull
    public final native String getString();

    @NotNull
    public final native JavaScriptTypedArray getTypedArray();

    public final native boolean isArray();

    public final native boolean isBool();

    public final native boolean isFunction();

    public final native boolean isNull();

    public final native boolean isNumber();

    public final native boolean isObject();

    public final native boolean isString();

    public final native boolean isSymbol();

    public final native boolean isTypedArray();

    public final native boolean isUndefined();

    @NotNull
    public final native String kind();

    @DoNotStrip
    private JavaScriptValue(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    @PublishedApi
    @NotNull
    public final <T> JavaScriptFunction<T> internalJniGetFunction() {
        return jniGetFunction();
    }

    public final /* synthetic */ <ReturnType> JavaScriptFunction<ReturnType> getFunction() {
        JavaScriptFunction<ReturnType> javaScriptFunctionInternalJniGetFunction = internalJniGetFunction();
        Intrinsics.reifiedOperationMarker(6, "ReturnType");
        javaScriptFunctionInternalJniGetFunction.setReturnType(null);
        return javaScriptFunctionInternalJniGetFunction;
    }

    @JvmName(name = "getVoidFunction")
    @NotNull
    public final JavaScriptFunction<Unit> getVoidFunction() {
        JavaScriptFunction<Unit> javaScriptFunctionInternalJniGetFunction = internalJniGetFunction();
        javaScriptFunctionInternalJniGetFunction.setReturnType(Reflection.typeOf(Unit.class));
        return javaScriptFunctionInternalJniGetFunction;
    }

    public final int getInt() {
        return (int) getDouble();
    }

    public final long getLong() {
        return (long) getDouble();
    }

    public final float getFloat() {
        return (float) getDouble();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }
}
