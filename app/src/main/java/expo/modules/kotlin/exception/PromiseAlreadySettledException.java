package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/kotlin/exception/PromiseAlreadySettledException;", "Lexpo/modules/kotlin/exception/CodedException;", "functionName", "", "<init>", "(Ljava/lang/String;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class PromiseAlreadySettledException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromiseAlreadySettledException(@NotNull String functionName) {
        super("Promise passed to '" + functionName + "' was already settled. It will lead to a crash in the production environment!", null, 2, null);
        Intrinsics.checkNotNullParameter(functionName, "functionName");
    }
}
