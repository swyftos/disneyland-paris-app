package expo.modules.kotlin.functions;

import com.facebook.react.bridge.BaseJavaModule;
import com.urbanairship.actions.RateAppAction;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012+\u0010\b\u001a'\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\f\b\u000b\u0012\b\b\u0003\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u00020\u00102\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0010¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m1836d2 = {"Lexpo/modules/kotlin/functions/DoubleAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/UntypedAsyncFunctionComponent;", "", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", RateAppAction.BODY_KEY, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "args", "<init>", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function1;)V", "callUserImplementation", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "appContext", "Lexpo/modules/kotlin/AppContext;", "callUserImplementation$expo_modules_core_release", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;Lexpo/modules/kotlin/AppContext;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DoubleAsyncFunctionComponent extends UntypedAsyncFunctionComponent<Double> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoubleAsyncFunctionComponent(@NotNull String name, @NotNull AnyType[] desiredArgsTypes, @NotNull Function1<? super Object[], Double> body) {
        super(name, desiredArgsTypes, body);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(body, "body");
    }

    @Override // expo.modules.kotlin.functions.UntypedAsyncFunctionComponent, expo.modules.kotlin.functions.AsyncFunctionComponent
    public void callUserImplementation$expo_modules_core_release(@NotNull Object[] args, @NotNull Promise promise, @NotNull AppContext appContext) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        promise.resolve(getBody().invoke(convertArgs(args, appContext)).doubleValue());
    }
}
