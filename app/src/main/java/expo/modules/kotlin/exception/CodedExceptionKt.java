package expo.modules.kotlin.exception;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0086\b\u001a\u0015\u0010\u0003\u001a\u00020\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0001H\u0086\b¨\u0006\u0006"}, m1836d2 = {"toCodedException", "Lexpo/modules/kotlin/exception/CodedException;", "", "errorCodeOf", "", ExifInterface.GPS_DIRECTION_TRUE, "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class CodedExceptionKt {
    @NotNull
    public static final CodedException toCodedException(@Nullable Throwable th) {
        CodedException unexpectedException;
        if (th == null) {
            return new UnexpectedException("Unknown error");
        }
        if (th instanceof CodedException) {
            return (CodedException) th;
        }
        if (th instanceof expo.modules.core.errors.CodedException) {
            expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
            String code = codedException.getCode();
            Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
            unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
        } else {
            unexpectedException = new UnexpectedException(th);
        }
        return unexpectedException;
    }

    public static final /* synthetic */ <T extends CodedException> String errorCodeOf() {
        CodedException.Companion companion = CodedException.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return companion.inferCode(CodedException.class);
    }
}
