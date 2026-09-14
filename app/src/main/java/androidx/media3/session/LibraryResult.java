package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.core.app.BundleCompat;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LibraryResult<V> {
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

    @Nullable
    public final MediaLibraryService.LibraryParams params;
    public final int resultCode;

    @Nullable
    @UnstableApi
    public final SessionError sessionError;

    @Nullable
    public final V value;
    private final int valueType;
    private static final String FIELD_RESULT_CODE = Util.intToStringMaxRadix(0);
    private static final String FIELD_COMPLETION_TIME_MS = Util.intToStringMaxRadix(1);
    private static final String FIELD_PARAMS = Util.intToStringMaxRadix(2);
    private static final String FIELD_VALUE = Util.intToStringMaxRadix(3);
    private static final String FIELD_VALUE_TYPE = Util.intToStringMaxRadix(4);
    private static final String FIELD_SESSION_ERROR = Util.intToStringMaxRadix(5);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    public static LibraryResult<Void> ofVoid() {
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), null, null, null, 1);
    }

    public static LibraryResult<Void> ofVoid(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), libraryParams, null, null, 1);
    }

    public static LibraryResult<MediaItem> ofItem(MediaItem mediaItem, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyMediaItem(mediaItem);
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), libraryParams, null, mediaItem, 2);
    }

    public static LibraryResult<ImmutableList<MediaItem>> ofItemList(List<MediaItem> list, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        Iterator<MediaItem> it = list.iterator();
        while (it.hasNext()) {
            verifyMediaItem(it.next());
        }
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), libraryParams, null, ImmutableList.copyOf((Collection) list), 3);
    }

    public static <V> LibraryResult<V> ofError(int i) {
        return ofError(new SessionError(i, "no error message provided", Bundle.EMPTY));
    }

    public static <V> LibraryResult<V> ofError(int i, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        return new LibraryResult<>(i, SystemClock.elapsedRealtime(), libraryParams, new SessionError(i, "no error message provided", Bundle.EMPTY), null, 4);
    }

    @UnstableApi
    public static <V> LibraryResult<V> ofError(SessionError sessionError) {
        return new LibraryResult<>(sessionError.code, SystemClock.elapsedRealtime(), null, sessionError, null, 4);
    }

    @UnstableApi
    public static <V> LibraryResult<V> ofError(SessionError sessionError, MediaLibraryService.LibraryParams libraryParams) {
        return new LibraryResult<>(sessionError.code, SystemClock.elapsedRealtime(), libraryParams, sessionError, null, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LibraryResult(int i, long j, MediaLibraryService.LibraryParams libraryParams, SessionError sessionError, Object obj, int i2) {
        this.resultCode = i;
        this.completionTimeMs = j;
        this.params = libraryParams;
        this.sessionError = sessionError;
        this.value = obj;
        this.valueType = i2;
    }

    private static void verifyMediaItem(MediaItem mediaItem) {
        Assertions.checkNotEmpty(mediaItem.mediaId, "mediaId must not be empty");
        Assertions.checkArgument(mediaItem.mediaMetadata.isBrowsable != null, "mediaMetadata must specify isBrowsable");
        Assertions.checkArgument(mediaItem.mediaMetadata.isPlayable != null, "mediaMetadata must specify isPlayable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r2 != 4) goto L22;
     */
    @UnstableApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_RESULT_CODE, this.resultCode);
        bundle.putLong(FIELD_COMPLETION_TIME_MS, this.completionTimeMs);
        MediaLibraryService.LibraryParams libraryParams = this.params;
        if (libraryParams != null) {
            bundle.putBundle(FIELD_PARAMS, libraryParams.toBundle());
        }
        SessionError sessionError = this.sessionError;
        if (sessionError != null) {
            bundle.putBundle(FIELD_SESSION_ERROR, sessionError.toBundle());
        }
        bundle.putInt(FIELD_VALUE_TYPE, this.valueType);
        V v = this.value;
        if (v == null) {
            return bundle;
        }
        int i = this.valueType;
        if (i != 1) {
            if (i == 2) {
                bundle.putBundle(FIELD_VALUE, ((MediaItem) v).toBundle());
            } else if (i == 3) {
                BundleCompat.putBinder(bundle, FIELD_VALUE, new BundleListRetriever(BundleCollectionUtil.toBundleList((ImmutableList) this.value, new Function() { // from class: androidx.media3.session.LibraryResult$$ExternalSyntheticLambda0
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return ((MediaItem) obj).toBundle();
                    }
                })));
            }
            return bundle;
        }
        throw new IllegalStateException();
    }

    @UnstableApi
    public static LibraryResult<Void> fromVoidBundle(Bundle bundle) {
        return fromUnknownBundle(bundle);
    }

    @UnstableApi
    public static LibraryResult<MediaItem> fromItemBundle(Bundle bundle) {
        return fromBundle(bundle, 2);
    }

    @UnstableApi
    public static LibraryResult<ImmutableList<MediaItem>> fromItemListBundle(Bundle bundle) {
        return fromBundle(bundle, 3);
    }

    @UnstableApi
    public static LibraryResult<?> fromUnknownBundle(Bundle bundle) {
        return fromBundle(bundle, null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x0077  */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:40:0x008c  */
    private static LibraryResult fromBundle(Bundle bundle, Integer num) {
        SessionError sessionError;
        SessionError sessionError2;
        int i;
        Bundle bundle2;
        IBinder binder;
        int i2 = bundle.getInt(FIELD_RESULT_CODE, 0);
        long j = bundle.getLong(FIELD_COMPLETION_TIME_MS, SystemClock.elapsedRealtime());
        Bundle bundle3 = bundle.getBundle(FIELD_PARAMS);
        Object objFromBundle = null;
        MediaLibraryService.LibraryParams libraryParamsFromBundle = bundle3 == null ? null : MediaLibraryService.LibraryParams.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(FIELD_SESSION_ERROR);
        if (bundle4 != null) {
            sessionError2 = SessionError.fromBundle(bundle4);
        } else {
            if (i2 != 0) {
                sessionError2 = new SessionError(i2, "no error message provided");
            } else {
                sessionError = null;
            }
            i = bundle.getInt(FIELD_VALUE_TYPE);
            if (i != 1) {
                if (i != 2) {
                    Assertions.checkState(num != null || num.intValue() == 2);
                    bundle2 = bundle.getBundle(FIELD_VALUE);
                    if (bundle2 != null) {
                        objFromBundle = MediaItem.fromBundle(bundle2);
                    }
                } else if (i != 3) {
                    Assertions.checkState(num != null || num.intValue() == 3);
                    binder = BundleCompat.getBinder(bundle, FIELD_VALUE);
                    if (binder != null) {
                        objFromBundle = BundleCollectionUtil.fromBundleList(new LibraryResult$$ExternalSyntheticLambda1(), BundleListRetriever.getList(binder));
                    }
                } else if (i != 4) {
                    throw new IllegalStateException();
                }
            }
            return new LibraryResult(i2, j, libraryParamsFromBundle, sessionError, objFromBundle, i);
        }
        sessionError = sessionError2;
        i = bundle.getInt(FIELD_VALUE_TYPE);
        if (i != 1) {
            if (i != 2) {
                Assertions.checkState(num != null || num.intValue() == 2);
                bundle2 = bundle.getBundle(FIELD_VALUE);
                if (bundle2 != null) {
                    objFromBundle = MediaItem.fromBundle(bundle2);
                }
            } else if (i != 3) {
                Assertions.checkState(num != null || num.intValue() == 3);
                binder = BundleCompat.getBinder(bundle, FIELD_VALUE);
                if (binder != null) {
                    objFromBundle = BundleCollectionUtil.fromBundleList(new LibraryResult$$ExternalSyntheticLambda1(), BundleListRetriever.getList(binder));
                }
            } else if (i != 4) {
                throw new IllegalStateException();
            }
        }
        return new LibraryResult(i2, j, libraryParamsFromBundle, sessionError, objFromBundle, i);
    }
}
