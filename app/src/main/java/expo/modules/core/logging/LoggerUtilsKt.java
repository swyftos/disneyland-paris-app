package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1836d2 = {"localizedMessageWithCauseLocalizedMessage", "", "", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class LoggerUtilsKt {
    @NotNull
    public static final String localizedMessageWithCauseLocalizedMessage(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        String localizedMessage = th.getLocalizedMessage();
        Throwable cause = th.getCause();
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{localizedMessage, cause != null ? localizedMessageWithCauseLocalizedMessage(cause) : null}), ": ", null, null, 0, null, null, 62, null);
    }
}
