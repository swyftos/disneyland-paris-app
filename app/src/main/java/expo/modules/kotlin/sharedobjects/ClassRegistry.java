package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.jni.JavaScriptObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0010J\u0014\u0010\u0011\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u0013R*\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1836d2 = {"Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "", "<init>", "()V", "pairs", "", "Ljava/lang/Class;", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "getPairs$expo_modules_core_release", "()Ljava/util/Map;", "setPairs$expo_modules_core_release", "(Ljava/util/Map;)V", "add", "", "native", "js", "add$expo_modules_core_release", "delete", "toJavaScriptObject", "toJavaScriptObject$expo_modules_core_release", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ClassRegistry {
    private Map pairs = new LinkedHashMap();

    @NotNull
    public final Map<Class<?>, JavaScriptObject> getPairs$expo_modules_core_release() {
        return this.pairs;
    }

    public final void setPairs$expo_modules_core_release(@NotNull Map<Class<?>, JavaScriptObject> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.pairs = map;
    }

    public final void add$expo_modules_core_release(@NotNull final Class<?> cls, @NotNull JavaScriptObject js) {
        Intrinsics.checkNotNullParameter(cls, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        js.defineDeallocator$expo_modules_core_release(new Function0() { // from class: expo.modules.kotlin.sharedobjects.ClassRegistry$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ClassRegistry.add$lambda$0(this.f$0, cls);
            }
        });
        this.pairs.put(cls, js);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit add$lambda$0(ClassRegistry classRegistry, Class cls) {
        classRegistry.delete(cls);
        return Unit.INSTANCE;
    }

    private final void delete(Class cls) {
        this.pairs.remove(cls);
    }

    @Nullable
    public final JavaScriptObject toJavaScriptObject$expo_modules_core_release(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "native");
        return (JavaScriptObject) this.pairs.get(cls);
    }
}
