package expo.modules.kotlin.jni;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m1836d2 = {"Lexpo/modules/kotlin/jni/JNIUtils;", "", "<init>", "()V", "Companion", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class JNIUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final native void emitEvent(@NotNull JavaScriptModuleObject_ javaScriptModuleObject_, @NotNull JSIContext jSIContext, @NotNull String str, @Nullable Map<String, ? extends Object> map);

    @JvmStatic
    public static final native void emitEvent(@NotNull JavaScriptObject javaScriptObject, @NotNull JSIContext jSIContext, @NotNull String str, @NotNull Object[] objArr);

    @JvmStatic
    public static final native void emitEvent(@NotNull JavaScriptWeakObject javaScriptWeakObject, @NotNull JSIContext jSIContext, @NotNull String str, @NotNull Object[] objArr);

    @Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0087 J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0087 J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010H\u0087 ¨\u0006\u0011"}, m1836d2 = {"Lexpo/modules/kotlin/jni/JNIUtils$Companion;", "", "<init>", "()V", "emitEvent", "", "jsiThis", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "jsiContext", "Lexpo/modules/kotlin/jni/JSIContext;", "eventName", "", "eventBody", "", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void emitEvent(@NotNull JavaScriptModuleObject_ jsiThis, @NotNull JSIContext jsiContext, @NotNull String eventName, @Nullable Map<String, ? extends Object> eventBody) {
            JNIUtils.emitEvent(jsiThis, jsiContext, eventName, eventBody);
        }

        @JvmStatic
        public final void emitEvent(@NotNull JavaScriptObject javaScriptObject, @NotNull JSIContext jSIContext, @NotNull String str, @NotNull Object[] objArr) {
            JNIUtils.emitEvent(javaScriptObject, jSIContext, str, objArr);
        }

        @JvmStatic
        public final void emitEvent(@NotNull JavaScriptWeakObject javaScriptWeakObject, @NotNull JSIContext jSIContext, @NotNull String str, @NotNull Object[] objArr) {
            JNIUtils.emitEvent(javaScriptWeakObject, jSIContext, str, objArr);
        }

        private Companion() {
        }
    }
}
