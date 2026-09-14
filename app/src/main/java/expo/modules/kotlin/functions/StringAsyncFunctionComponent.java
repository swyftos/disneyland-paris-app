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
@Metadata(m1835d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012+\u0010\u0007\u001a'\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\f\b\n\u0012\b\b\u0003\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m1836d2 = {"Lexpo/modules/kotlin/functions/StringAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/UntypedAsyncFunctionComponent;", "", "name", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", RateAppAction.BODY_KEY, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "args", "<init>", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function1;)V", "callUserImplementation", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "appContext", "Lexpo/modules/kotlin/AppContext;", "callUserImplementation$expo_modules_core_release", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;Lexpo/modules/kotlin/AppContext;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class StringAsyncFunctionComponent extends UntypedAsyncFunctionComponent<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringAsyncFunctionComponent(@NotNull String name, @NotNull AnyType[] desiredArgsTypes, @NotNull Function1<? super Object[], String> body) {
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
        promise.resolve(getBody().invoke(convertArgs(args, appContext)));
    }
}
