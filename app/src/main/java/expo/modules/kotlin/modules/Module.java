package expo.modules.kotlin.modules;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.actions.RateAppAction;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.providers.AppContextProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010*0)J3\u0010#\u001a\u00020$\"\u0012\b\u0000\u0010+*\u00020,*\b\u0012\u0004\u0012\u0002H+0-2\u0006\u0010.\u001a\u0002H+2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010/JA\u0010#\u001a\u00020$\"\u0012\b\u0000\u0010+*\u00020,*\b\u0012\u0004\u0012\u0002H+0-2\u0006\u0010.\u001a\u0002H+2\u0018\b\u0002\u0010'\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010)¢\u0006\u0002\u00100J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u000204H&R\"\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00065"}, m1836d2 = {"Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/kotlin/providers/AppContextProvider;", "<init>", "()V", "_runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "get_runtimeContext$expo_modules_core_release$annotations", "get_runtimeContext$expo_modules_core_release", "()Lexpo/modules/kotlin/RuntimeContext;", "set_runtimeContext$expo_modules_core_release", "(Lexpo/modules/kotlin/RuntimeContext;)V", "runtimeContext", "getRuntimeContext", "appContext", "Lexpo/modules/kotlin/AppContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "moduleEventEmitter", "Lexpo/modules/kotlin/events/EventEmitter;", "getModuleEventEmitter", "()Lexpo/modules/kotlin/events/EventEmitter;", "moduleEventEmitter$delegate", "Lkotlin/Lazy;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "coroutineScopeDelegate", "Lkotlin/Lazy;", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScopeDelegate$annotations", "getCoroutineScopeDelegate", "()Lkotlin/Lazy;", "setCoroutineScopeDelegate", "(Lkotlin/Lazy;)V", "sendEvent", "", "name", "", RateAppAction.BODY_KEY, "Landroid/os/Bundle;", "", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/types/Enumerable;", "", "enum", "(Ljava/lang/Enum;Landroid/os/Bundle;)V", "(Ljava/lang/Enum;Ljava/util/Map;)V", "converters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Module.kt\nexpo/modules/kotlin/modules/Module\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public abstract class Module implements AppContextProvider {
    private RuntimeContext _runtimeContext;
    public Lazy<? extends CoroutineScope> coroutineScopeDelegate;

    /* JADX INFO: renamed from: moduleEventEmitter$delegate, reason: from kotlin metadata */
    private final Lazy moduleEventEmitter = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.modules.Module$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Module.moduleEventEmitter_delegate$lambda$2(this.f$0);
        }
    });

    @PublishedApi
    public static /* synthetic */ void getCoroutineScopeDelegate$annotations() {
    }

    public static /* synthetic */ void get_runtimeContext$expo_modules_core_release$annotations() {
    }

    @Nullable
    public TypeConverterProvider converters() {
        return null;
    }

    @NotNull
    public abstract ModuleDefinitionData definition();

    @Nullable
    /* JADX INFO: renamed from: get_runtimeContext$expo_modules_core_release, reason: from getter */
    public final RuntimeContext get_runtimeContext() {
        return this._runtimeContext;
    }

    public final void set_runtimeContext$expo_modules_core_release(@Nullable RuntimeContext runtimeContext) {
        this._runtimeContext = runtimeContext;
    }

    @NotNull
    public final RuntimeContext getRuntimeContext() {
        RuntimeContext runtimeContext = this._runtimeContext;
        if (runtimeContext != null) {
            return runtimeContext;
        }
        throw new IllegalArgumentException("The module wasn't created! You can't access the runtime context.");
    }

    @Override // expo.modules.kotlin.providers.AppContextProvider
    @NotNull
    public AppContext getAppContext() {
        RuntimeContext runtimeContext = this._runtimeContext;
        AppContext appContext = runtimeContext != null ? runtimeContext.getAppContext() : null;
        if (appContext != null) {
            return appContext;
        }
        throw new IllegalArgumentException("You attempted to access the app context before the module was created. Defer accessing the context until after the module initializes.");
    }

    private final EventEmitter getModuleEventEmitter() {
        return (EventEmitter) this.moduleEventEmitter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventEmitter moduleEventEmitter_delegate$lambda$2(Module module) {
        return module.getAppContext().eventEmitter(module);
    }

    @NotNull
    public final ModuleRegistry getRegistry() {
        return getRuntimeContext().getRegistry();
    }

    @NotNull
    public final Lazy<CoroutineScope> getCoroutineScopeDelegate() {
        Lazy lazy = this.coroutineScopeDelegate;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineScopeDelegate");
        return null;
    }

    public final void setCoroutineScopeDelegate(@NotNull Lazy<? extends CoroutineScope> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.coroutineScopeDelegate = lazy;
    }

    public static /* synthetic */ void sendEvent$default(Module module, String str, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            bundle = Bundle.EMPTY;
        }
        module.sendEvent(str, bundle);
    }

    public final void sendEvent(@NotNull String name, @Nullable Bundle body) {
        Intrinsics.checkNotNullParameter(name, "name");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, body);
        }
    }

    public final void sendEvent(@NotNull String name, @NotNull Map<String, ? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, body);
        }
    }

    public static /* synthetic */ void sendEvent$default(Module module, Enum r1, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            bundle = Bundle.EMPTY;
        }
        module.sendEvent(r1, bundle);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Landroid/os/Bundle;)V */
    public final void sendEvent(@NotNull Enum r2, @Nullable Bundle body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(ModuleUtilsKt.convertEnumToString(r2), body);
        }
    }

    public static /* synthetic */ void sendEvent$default(Module module, Enum r1, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        module.sendEvent(r1, map);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Ljava/util/Map<Ljava/lang/String;+Ljava/lang/Object;>;)V */
    public final void sendEvent(@NotNull Enum r2, @Nullable Map body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(ModuleUtilsKt.convertEnumToString(r2), (Map<?, ?>) body);
        }
    }
}
