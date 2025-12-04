package com.urbanairship.featureflag;

import com.amazonaws.services.s3.model.InstructionFileId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagEvaluationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "ConnectionError", "OutOfDate", "StaleNotAllowed", "Lcom/urbanairship/featureflag/FeatureFlagEvaluationException$ConnectionError;", "Lcom/urbanairship/featureflag/FeatureFlagEvaluationException$OutOfDate;", "Lcom/urbanairship/featureflag/FeatureFlagEvaluationException$StaleNotAllowed;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FeatureFlagEvaluationException extends Exception {
    private final String message;

    public /* synthetic */ FeatureFlagEvaluationException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagEvaluationException$ConnectionError;", "Lcom/urbanairship/featureflag/FeatureFlagEvaluationException;", "statusCode", "", "errorDescription", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getErrorDescription", "()Ljava/lang/String;", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConnectionError extends FeatureFlagEvaluationException {
        private static final Companion Companion = new Companion(null);
        private final String errorDescription;
        private final Integer statusCode;

        public ConnectionError() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ ConnectionError(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
        }

        @Nullable
        public final Integer getStatusCode() {
            return this.statusCode;
        }

        @Nullable
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public ConnectionError(@Nullable Integer num, @Nullable String str) {
            super(Companion.makeMessage(num, str), null);
            this.statusCode = num;
            this.errorDescription = str;
        }

        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final String makeMessage(Integer num, String str) {
                String str2;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to fetch data");
                if (num != null) {
                    str2 = " (" + num + ").";
                } else {
                    str2 = InstructionFileId.DOT;
                }
                sb.append(str2);
                String string = sb.toString();
                if (str == null) {
                    return string;
                }
                return string + ' ' + str;
            }
        }
    }

    private FeatureFlagEvaluationException(String str) {
        super(str);
        this.message = str;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagEvaluationException$OutOfDate;", "Lcom/urbanairship/featureflag/FeatureFlagEvaluationException;", "()V", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OutOfDate extends FeatureFlagEvaluationException {
        public OutOfDate() {
            super("Remote data is outdated", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagEvaluationException$StaleNotAllowed;", "Lcom/urbanairship/featureflag/FeatureFlagEvaluationException;", "()V", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StaleNotAllowed extends FeatureFlagEvaluationException {
        public StaleNotAllowed() {
            super("Stale data is not allowed", null);
        }
    }
}
