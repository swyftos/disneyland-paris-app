package com.contentsquare.android.api.model;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b \u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/contentsquare/android/api/model/DynamicVarValidator;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "Companion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DynamicVarValidator {

    @NotNull
    private static final String DEFAULT_KEY_VALUE = "cs-empty";
    private static final int KEY_MAX_LENGTH = 512;

    @NotNull
    private final String key;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static Logger logger = new Logger("DynamicVar");

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/contentsquare/android/api/model/DynamicVarValidator$Companion;", "", "()V", "DEFAULT_KEY_VALUE", "", "KEY_MAX_LENGTH", "", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "getLogger$library_release", "()Lcom/contentsquare/android/core/features/logging/Logger;", "setLogger$library_release", "(Lcom/contentsquare/android/core/features/logging/Logger;)V", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Logger getLogger$library_release() {
            return DynamicVarValidator.logger;
        }

        public final void setLogger$library_release(@NotNull Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "<set-?>");
            DynamicVarValidator.logger = logger;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DynamicVarValidator(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.length() == 0) {
            logger.i("Dynamic Variable key is empty. Dynamic Variable is sent but the key is set to \"cs-empty\"");
            key = DEFAULT_KEY_VALUE;
        } else if (key.length() > 512) {
            logger.i("Dynamic Variable key is too long: the current input has a length of " + key.length() + " while the limit is 512. Dynamic Variable is sent but the key truncated");
            key = key.substring(0, 512);
            Intrinsics.checkNotNullExpressionValue(key, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        this.key = key;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
