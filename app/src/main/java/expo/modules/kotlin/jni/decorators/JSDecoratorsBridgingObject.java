package expo.modules.kotlin.jni.decorators;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.urbanairship.actions.RateAppAction;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.jni.Destructible;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.JNINoArgsFunctionBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0007H\u0082 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086 J<\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0086 ¢\u0006\u0002\u0010\u0018J<\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u001aH\u0086 ¢\u0006\u0002\u0010\u001bJV\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0086 ¢\u0006\u0002\u0010#J\u001b\u0010$\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010%H\u0086 J\u0019\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0000H\u0086 JR\u0010(\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0086 ¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0004R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m1836d2 = {"Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "Lexpo/modules/kotlin/jni/Destructible;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "<init>", "(Lexpo/modules/kotlin/jni/JNIDeallocator;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "registerConstants", "", "constants", "Lcom/facebook/react/bridge/NativeMap;", "registerSyncFunction", "name", "", "takesOwner", "", "enumerable", "desiredTypes", "", "Lexpo/modules/kotlin/jni/ExpectedType;", RateAppAction.BODY_KEY, "Lexpo/modules/kotlin/jni/JNIFunctionBody;", "(Ljava/lang/String;ZZ[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "registerAsyncFunction", "Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;", "(Ljava/lang/String;ZZ[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;)V", "registerProperty", "getterTakesOwner", "getterExpectedType", "getter", "setterTakesOwner", "setterExpectedType", "setter", "(Ljava/lang/String;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "registerConstant", "Lexpo/modules/kotlin/jni/JNINoArgsFunctionBody;", "registerObject", "jsDecoratorsBridgingObject", "registerClass", "prototypeDecorator", "ownerClass", "Ljava/lang/Class;", "isSharedRef", "(Ljava/lang/String;Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;ZLjava/lang/Class;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "deallocate", "finalize", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class JSDecoratorsBridgingObject implements Destructible {

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData;

    private final native HybridData initHybrid();

    public final native void registerAsyncFunction(@NotNull String name, boolean takesOwner, boolean enumerable, @NotNull ExpectedType[] desiredTypes, @NotNull JNIAsyncFunctionBody body);

    public final native void registerClass(@NotNull String name, @NotNull JSDecoratorsBridgingObject prototypeDecorator, boolean takesOwner, @Nullable Class<?> ownerClass, boolean isSharedRef, @NotNull ExpectedType[] desiredTypes, @NotNull JNIFunctionBody body);

    public final native void registerConstant(@NotNull String name, @Nullable JNINoArgsFunctionBody getter);

    public final native void registerConstants(@NotNull NativeMap constants);

    public final native void registerObject(@NotNull String name, @NotNull JSDecoratorsBridgingObject jsDecoratorsBridgingObject);

    public final native void registerProperty(@NotNull String name, boolean getterTakesOwner, @NotNull ExpectedType[] getterExpectedType, @Nullable JNIFunctionBody getter, boolean setterTakesOwner, @NotNull ExpectedType[] setterExpectedType, @Nullable JNIFunctionBody setter);

    public final native void registerSyncFunction(@NotNull String name, boolean takesOwner, boolean enumerable, @NotNull ExpectedType[] desiredTypes, @NotNull JNIFunctionBody body);

    public JSDecoratorsBridgingObject(@NotNull JNIDeallocator jniDeallocator) {
        Intrinsics.checkNotNullParameter(jniDeallocator, "jniDeallocator");
        this.mHybridData = initHybrid();
        jniDeallocator.addReference(this);
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }
}
