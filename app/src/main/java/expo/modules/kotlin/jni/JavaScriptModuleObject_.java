package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: expo.modules.kotlin.jni.JavaScriptModuleObject, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u000bH\u0082 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086 J\b\u0010\u0014\u001a\u00020\u0011H\u0004J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0017"}, m1836d2 = {"Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "Lexpo/modules/kotlin/jni/Destructible;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "name", "", "<init>", "(Lexpo/modules/kotlin/jni/JNIDeallocator;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "isValid", "", "()Z", "decorate", "", "decorator", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "finalize", "deallocate", "toString", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
public final class JavaScriptModuleObject_ implements Destructible {

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData;

    /* JADX INFO: renamed from: name, reason: from kotlin metadata and from toString */
    private final String JavaScriptModuleObject_;

    private final native HybridData initHybrid();

    public final native void decorate(@NotNull JSDecoratorsBridgingObject decorator);

    public JavaScriptModuleObject_(@NotNull JNIDeallocator jniDeallocator, @NotNull String name) {
        Intrinsics.checkNotNullParameter(jniDeallocator, "jniDeallocator");
        Intrinsics.checkNotNullParameter(name, "name");
        this.JavaScriptModuleObject_ = name;
        this.mHybridData = initHybrid();
        jniDeallocator.addReference(this);
    }

    @NotNull
    /* JADX INFO: renamed from: getName, reason: from getter */
    public final String getJavaScriptModuleObject_() {
        return this.JavaScriptModuleObject_;
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    @NotNull
    public String toString() {
        return "JavaScriptModuleObject_" + this.JavaScriptModuleObject_;
    }
}
