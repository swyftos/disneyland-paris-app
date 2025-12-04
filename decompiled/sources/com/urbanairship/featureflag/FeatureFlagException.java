package com.urbanairship.featureflag;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\bB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "FailedToFetch", "Lcom/urbanairship/featureflag/FeatureFlagException$FailedToFetch;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FeatureFlagException extends Exception {
    private final String message;

    public /* synthetic */ FeatureFlagException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagException$FailedToFetch;", "Lcom/urbanairship/featureflag/FeatureFlagException;", "message", "", "(Ljava/lang/String;)V", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FailedToFetch extends FeatureFlagException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToFetch(@NotNull String message) {
            super(message, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    private FeatureFlagException(String str) {
        super(str);
        this.message = str;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }
}
