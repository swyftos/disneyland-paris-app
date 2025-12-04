package com.urbanairship;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/urbanairship/AirshipDispatchers;", "", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "newSerialDispatcher", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class AirshipDispatchers {

    @NotNull
    public static final AirshipDispatchers INSTANCE = new AirshipDispatchers();
    private static final CoroutineDispatcher IO = ExecutorsKt.from(AirshipExecutors.threadPoolExecutor());

    private AirshipDispatchers() {
    }

    @NotNull
    public final CoroutineDispatcher getIO() {
        return IO;
    }

    @NotNull
    public final CoroutineDispatcher newSerialDispatcher() {
        return ExecutorsKt.from(AirshipExecutors.newSerialExecutor());
    }
}
