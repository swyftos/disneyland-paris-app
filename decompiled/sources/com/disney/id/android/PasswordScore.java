package com.disney.id.android;

import androidx.annotation.VisibleForTesting;
import com.disney.id.android.OneIDError;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.validation.PasswordValidation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/disney/id/android/PasswordScore;", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "(Lcom/disney/id/android/OneIDError;)V", FirebaseAnalytics.Param.SCORE, "", "errorReport", "Lcom/disney/id/android/validation/PasswordValidation$ErrorReport;", "(ILcom/disney/id/android/validation/PasswordValidation$ErrorReport;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "getScore$OneID_release$annotations", "()V", "getScore$OneID_release", "()I", "strength", "Lcom/disney/id/android/PasswordStrength;", "getStrength", "()Lcom/disney/id/android/PasswordStrength;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PasswordScore {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = PasswordScore.class.getSimpleName();
    private final OneIDError error;

    @Inject
    public Logger logger;
    private final int score;
    private final PasswordStrength strength;

    @VisibleForTesting
    public static /* synthetic */ void getScore$OneID_release$annotations() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/disney/id/android/PasswordScore$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$OneID_release", "()Ljava/lang/String;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$OneID_release() {
            return PasswordScore.TAG;
        }
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    /* renamed from: getScore$OneID_release, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    @NotNull
    public final PasswordStrength getStrength() {
        return this.strength;
    }

    @Nullable
    public final OneIDError getError() {
        return this.error;
    }

    public PasswordScore(@NotNull OneIDError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.score = -1;
        this.strength = PasswordStrength.NONE;
        this.error = error;
    }

    public PasswordScore(int i, @NotNull PasswordValidation.ErrorReport errorReport) {
        OneIDError oneIDErrorBuildPasswordIsTooShort$OneID_release;
        Intrinsics.checkNotNullParameter(errorReport, "errorReport");
        this.score = i;
        OneIDDagger.getComponent().inject(this);
        if (i == 0) {
            this.strength = PasswordStrength.NONE;
            this.error = OneIDError.INSTANCE.buildPasswordIsEmpty$OneID_release();
            return;
        }
        if (i == 1) {
            this.strength = PasswordStrength.NONE;
            OneIDError.Companion companion = OneIDError.INSTANCE;
            this.error = companion.buildPasswordIsMissingSpecialCharacters$OneID_release(companion.buildPasswordIsTooShort$OneID_release());
            return;
        }
        if (i == 2) {
            this.strength = PasswordStrength.NONE;
            if (errorReport.getInvalidValuePasswordMissingExpectedChars()) {
                oneIDErrorBuildPasswordIsTooShort$OneID_release = OneIDError.Companion.buildPasswordIsMissingSpecialCharacters$OneID_release$default(OneIDError.INSTANCE, null, 1, null);
            } else {
                oneIDErrorBuildPasswordIsTooShort$OneID_release = OneIDError.INSTANCE.buildPasswordIsTooShort$OneID_release();
            }
            this.error = oneIDErrorBuildPasswordIsTooShort$OneID_release;
            return;
        }
        if (i == 3) {
            this.strength = PasswordStrength.LOW;
            this.error = null;
            return;
        }
        if (4 <= i && i < 6) {
            this.strength = PasswordStrength.MEDIUM;
            this.error = null;
            return;
        }
        if (i == 6) {
            this.strength = PasswordStrength.STRONG;
            this.error = null;
            return;
        }
        if (i == 7) {
            this.strength = PasswordStrength.NONE;
            this.error = OneIDError.INSTANCE.buildPasswordIsTooLong$OneID_release();
            return;
        }
        this.strength = PasswordStrength.NONE;
        this.error = OneIDError.INSTANCE.buildPasswordIsInvalid$OneID_release();
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Unknown password strength score: " + i, null, 4, null);
    }
}
