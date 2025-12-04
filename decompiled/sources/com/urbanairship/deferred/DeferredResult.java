package com.urbanairship.deferred;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0005\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/deferred/DeferredResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "NotFound", "OutOfDate", "RetriableError", "Success", "TimedOut", "Lcom/urbanairship/deferred/DeferredResult$NotFound;", "Lcom/urbanairship/deferred/DeferredResult$OutOfDate;", "Lcom/urbanairship/deferred/DeferredResult$RetriableError;", "Lcom/urbanairship/deferred/DeferredResult$Success;", "Lcom/urbanairship/deferred/DeferredResult$TimedOut;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class DeferredResult<T> {
    public /* synthetic */ DeferredResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeferredResult() {
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/urbanairship/deferred/DeferredResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/deferred/DeferredResult;", "result", "(Ljava/lang/Object;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Success<T> extends DeferredResult<T> {
        private final Object result;

        public Success(T t) {
            super(null);
            this.result = t;
        }

        public final T getResult() {
            return (T) this.result;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/deferred/DeferredResult$RetriableError;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/deferred/DeferredResult;", "retryAfter", "", "statusCode", "", "errorDescription", "", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "getErrorDescription", "()Ljava/lang/String;", "getRetryAfter", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RetriableError<T> extends DeferredResult<T> {
        private final String errorDescription;
        private final Long retryAfter;
        private final Integer statusCode;

        public RetriableError() {
            this(null, null, null, 7, null);
        }

        public /* synthetic */ RetriableError(Long l, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str);
        }

        @Nullable
        public final Long getRetryAfter() {
            return this.retryAfter;
        }

        @Nullable
        public final Integer getStatusCode() {
            return this.statusCode;
        }

        @Nullable
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public RetriableError(@Nullable Long l, @Nullable Integer num, @Nullable String str) {
            super(null);
            this.retryAfter = l;
            this.statusCode = num;
            this.errorDescription = str;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/deferred/DeferredResult$TimedOut;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/deferred/DeferredResult;", "()V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimedOut<T> extends DeferredResult<T> {
        public TimedOut() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/deferred/DeferredResult$OutOfDate;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/deferred/DeferredResult;", "()V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OutOfDate<T> extends DeferredResult<T> {
        public OutOfDate() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/deferred/DeferredResult$NotFound;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/deferred/DeferredResult;", "()V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NotFound<T> extends DeferredResult<T> {
        public NotFound() {
            super(null);
        }
    }
}
