package expo.modules.kotlin.functions;

import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0010J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m1836d2 = {"Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/AnyFunction;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "<init>", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "queue", "Lexpo/modules/kotlin/functions/FunctionQueue;", "getQueue", "()Lexpo/modules/kotlin/functions/FunctionQueue;", "setQueue", "(Lexpo/modules/kotlin/functions/FunctionQueue;)V", "runOnQueue", "Lexpo/modules/kotlin/functions/Queues;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public abstract class BaseAsyncFunctionComponent extends AnyFunction {
    private FunctionQueue queue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAsyncFunctionComponent(@NotNull String name, @NotNull AnyType[] desiredArgsTypes) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        this.queue = Queues.DEFAULT;
    }

    @NotNull
    protected final FunctionQueue getQueue() {
        return this.queue;
    }

    protected final void setQueue(@NotNull FunctionQueue functionQueue) {
        Intrinsics.checkNotNullParameter(functionQueue, "<set-?>");
        this.queue = functionQueue;
    }

    @NotNull
    public final BaseAsyncFunctionComponent runOnQueue(@NotNull Queues queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        this.queue = queue;
        return this;
    }

    @NotNull
    public final BaseAsyncFunctionComponent runOnQueue(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.queue = new CustomQueue(scope);
        return this;
    }
}
