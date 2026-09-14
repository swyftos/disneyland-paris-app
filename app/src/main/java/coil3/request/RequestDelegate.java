package coil3.request;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/request/RequestDelegate;", "", "assertActive", "", ViewProps.START, "awaitStarted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "dispose", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface RequestDelegate {
    default void assertActive() {
    }

    @Nullable
    default Object awaitStarted(@NotNull Continuation<? super Unit> continuation) {
        return awaitStarted$suspendImpl(this, continuation);
    }

    default void complete() {
    }

    default void dispose() {
    }

    default void start() {
    }

    static /* synthetic */ Object awaitStarted$suspendImpl(RequestDelegate requestDelegate, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
