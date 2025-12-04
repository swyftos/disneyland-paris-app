package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public final class SessionResult {
    public static final int RESULT_ERROR_BAD_VALUE = -3;
    public static final int RESULT_ERROR_INVALID_STATE = -2;
    public static final int RESULT_ERROR_IO = -5;
    public static final int RESULT_ERROR_NOT_SUPPORTED = -6;
    public static final int RESULT_ERROR_PERMISSION_DENIED = -4;
    public static final int RESULT_ERROR_SESSION_AUTHENTICATION_EXPIRED = -102;
    public static final int RESULT_ERROR_SESSION_CONCURRENT_STREAM_LIMIT = -104;
    public static final int RESULT_ERROR_SESSION_DISCONNECTED = -100;
    public static final int RESULT_ERROR_SESSION_NOT_AVAILABLE_IN_REGION = -106;
    public static final int RESULT_ERROR_SESSION_PARENTAL_CONTROL_RESTRICTED = -105;
    public static final int RESULT_ERROR_SESSION_PREMIUM_ACCOUNT_REQUIRED = -103;
    public static final int RESULT_ERROR_SESSION_SETUP_REQUIRED = -108;
    public static final int RESULT_ERROR_SESSION_SKIP_LIMIT_REACHED = -107;
    public static final int RESULT_ERROR_UNKNOWN = -1;
    public static final int RESULT_INFO_SKIPPED = 1;
    public static final int RESULT_SUCCESS = 0;
    public final long completionTimeMs;
    public final Bundle extras;
    public final int resultCode;

    @Nullable
    @UnstableApi
    public final SessionError sessionError;
    private static final String FIELD_RESULT_CODE = Util.intToStringMaxRadix(0);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(1);
    private static final String FIELD_COMPLETION_TIME_MS = Util.intToStringMaxRadix(2);
    private static final String FIELD_SESSION_ERROR = Util.intToStringMaxRadix(3);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    public SessionResult(int i) {
        this(i, Bundle.EMPTY);
    }

    public SessionResult(int i, Bundle bundle) {
        this(i, bundle, SystemClock.elapsedRealtime(), null);
    }

    @UnstableApi
    public SessionResult(SessionError sessionError) {
        this(sessionError.code, Bundle.EMPTY, SystemClock.elapsedRealtime(), sessionError);
    }

    @UnstableApi
    public SessionResult(SessionError sessionError, Bundle bundle) {
        this(sessionError.code, bundle, SystemClock.elapsedRealtime(), sessionError);
    }

    private SessionResult(int i, Bundle bundle, long j, SessionError sessionError) {
        Assertions.checkArgument(sessionError == null || i < 0);
        this.resultCode = i;
        this.extras = new Bundle(bundle);
        this.completionTimeMs = j;
        if (sessionError == null && i < 0) {
            sessionError = new SessionError(i, "no error message provided");
        }
        this.sessionError = sessionError;
    }

    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_RESULT_CODE, this.resultCode);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        bundle.putLong(FIELD_COMPLETION_TIME_MS, this.completionTimeMs);
        SessionError sessionError = this.sessionError;
        if (sessionError != null) {
            bundle.putBundle(FIELD_SESSION_ERROR, sessionError.toBundle());
        }
        return bundle;
    }

    @UnstableApi
    public static SessionResult fromBundle(Bundle bundle) {
        SessionError sessionError;
        int i = bundle.getInt(FIELD_RESULT_CODE, -1);
        Bundle bundle2 = bundle.getBundle(FIELD_EXTRAS);
        long j = bundle.getLong(FIELD_COMPLETION_TIME_MS, SystemClock.elapsedRealtime());
        Bundle bundle3 = bundle.getBundle(FIELD_SESSION_ERROR);
        if (bundle3 != null) {
            sessionError = SessionError.fromBundle(bundle3);
        } else {
            sessionError = i != 0 ? new SessionError(i, "no error message provided") : null;
        }
        SessionError sessionError2 = sessionError;
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionResult(i, bundle2, j, sessionError2);
    }
}
