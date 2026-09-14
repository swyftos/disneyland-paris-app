package expo.modules.filesystem;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003JF\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, m1836d2 = {"Lexpo/modules/filesystem/DownloadOptions;", "Lexpo/modules/kotlin/records/Record;", "md5", "", "cache", "headers", "", "", "sessionType", "Lexpo/modules/filesystem/SessionType;", "<init>", "(ZLjava/lang/Boolean;Ljava/util/Map;Lexpo/modules/filesystem/SessionType;)V", "getMd5$annotations", "()V", "getMd5", "()Z", "getCache$annotations", "getCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHeaders$annotations", "getHeaders", "()Ljava/util/Map;", "getSessionType$annotations", "getSessionType", "()Lexpo/modules/filesystem/SessionType;", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Boolean;Ljava/util/Map;Lexpo/modules/filesystem/SessionType;)Lexpo/modules/filesystem/DownloadOptions;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "expo-file-system_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class DownloadOptions implements Record {

    @Nullable
    private final Boolean cache;

    @Nullable
    private final Map<String, String> headers;
    private final boolean md5;

    @NotNull
    private final SessionType sessionType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadOptions copy$default(DownloadOptions downloadOptions, boolean z, Boolean bool, Map map, SessionType sessionType, int i, Object obj) {
        if ((i & 1) != 0) {
            z = downloadOptions.md5;
        }
        if ((i & 2) != 0) {
            bool = downloadOptions.cache;
        }
        if ((i & 4) != 0) {
            map = downloadOptions.headers;
        }
        if ((i & 8) != 0) {
            sessionType = downloadOptions.sessionType;
        }
        return downloadOptions.copy(z, bool, map, sessionType);
    }

    @Field
    public static /* synthetic */ void getCache$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getMd5$annotations() {
    }

    @Field
    public static /* synthetic */ void getSessionType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getMd5() {
        return this.md5;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getCache() {
        return this.cache;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.headers;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SessionType getSessionType() {
        return this.sessionType;
    }

    @NotNull
    public final DownloadOptions copy(boolean md5, @Nullable Boolean cache, @Nullable Map<String, String> headers, @NotNull SessionType sessionType) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        return new DownloadOptions(md5, cache, headers, sessionType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadOptions)) {
            return false;
        }
        DownloadOptions downloadOptions = (DownloadOptions) other;
        return this.md5 == downloadOptions.md5 && Intrinsics.areEqual(this.cache, downloadOptions.cache) && Intrinsics.areEqual(this.headers, downloadOptions.headers) && this.sessionType == downloadOptions.sessionType;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.md5) * 31;
        Boolean bool = this.cache;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Map<String, String> map = this.headers;
        return ((iHashCode2 + (map != null ? map.hashCode() : 0)) * 31) + this.sessionType.hashCode();
    }

    @NotNull
    public String toString() {
        return "DownloadOptions(md5=" + this.md5 + ", cache=" + this.cache + ", headers=" + this.headers + ", sessionType=" + this.sessionType + ")";
    }

    public DownloadOptions(boolean z, @Nullable Boolean bool, @Nullable Map<String, String> map, @NotNull SessionType sessionType) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        this.md5 = z;
        this.cache = bool;
        this.headers = map;
        this.sessionType = sessionType;
    }

    public final boolean getMd5() {
        return this.md5;
    }

    @Nullable
    public final Boolean getCache() {
        return this.cache;
    }

    @Nullable
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final SessionType getSessionType() {
        return this.sessionType;
    }

    public /* synthetic */ DownloadOptions(boolean z, Boolean bool, Map map, SessionType sessionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, bool, map, (i & 8) != 0 ? SessionType.BACKGROUND : sessionType);
    }
}
