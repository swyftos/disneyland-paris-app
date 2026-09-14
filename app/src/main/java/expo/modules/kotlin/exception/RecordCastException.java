package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1836d2 = {"Lexpo/modules/kotlin/exception/RecordCastException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "recordType", "Lkotlin/reflect/KType;", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "(Lkotlin/reflect/KType;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RecordCastException extends DecoratedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordCastException(@NotNull KType recordType, @NotNull CodedException cause) {
        super("Cannot create a record of the type: '" + recordType + "'.", cause);
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
