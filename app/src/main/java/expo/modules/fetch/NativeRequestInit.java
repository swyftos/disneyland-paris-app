package expo.modules.fetch;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR.\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m1836d2 = {"Lexpo/modules/fetch/NativeRequestInit;", "Lexpo/modules/kotlin/records/Record;", "credentials", "Lexpo/modules/fetch/NativeRequestCredentials;", "headers", "", "Lkotlin/Pair;", "", TCEventPropertiesNames.TCE_METHOD, "<init>", "(Lexpo/modules/fetch/NativeRequestCredentials;Ljava/util/List;Ljava/lang/String;)V", "getCredentials$annotations", "()V", "getCredentials", "()Lexpo/modules/fetch/NativeRequestCredentials;", "getHeaders$annotations", "getHeaders", "()Ljava/util/List;", "getMethod$annotations", "getMethod", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "expo_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class NativeRequestInit implements Record {

    @NotNull
    private final NativeRequestCredentials credentials;

    @NotNull
    private final List<Pair<String, String>> headers;

    @NotNull
    private final String method;

    public NativeRequestInit() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NativeRequestInit copy$default(NativeRequestInit nativeRequestInit, NativeRequestCredentials nativeRequestCredentials, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            nativeRequestCredentials = nativeRequestInit.credentials;
        }
        if ((i & 2) != 0) {
            list = nativeRequestInit.headers;
        }
        if ((i & 4) != 0) {
            str = nativeRequestInit.method;
        }
        return nativeRequestInit.copy(nativeRequestCredentials, list, str);
    }

    @Field
    public static /* synthetic */ void getCredentials$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getMethod$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NativeRequestCredentials getCredentials() {
        return this.credentials;
    }

    @NotNull
    public final List<Pair<String, String>> component2() {
        return this.headers;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final NativeRequestInit copy(@NotNull NativeRequestCredentials credentials, @NotNull List<Pair<String, String>> headers, @NotNull String method) {
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(method, "method");
        return new NativeRequestInit(credentials, headers, method);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeRequestInit)) {
            return false;
        }
        NativeRequestInit nativeRequestInit = (NativeRequestInit) other;
        return this.credentials == nativeRequestInit.credentials && Intrinsics.areEqual(this.headers, nativeRequestInit.headers) && Intrinsics.areEqual(this.method, nativeRequestInit.method);
    }

    public int hashCode() {
        return (((this.credentials.hashCode() * 31) + this.headers.hashCode()) * 31) + this.method.hashCode();
    }

    @NotNull
    public String toString() {
        return "NativeRequestInit(credentials=" + this.credentials + ", headers=" + this.headers + ", method=" + this.method + ")";
    }

    public NativeRequestInit(@NotNull NativeRequestCredentials credentials, @NotNull List<Pair<String, String>> headers, @NotNull String method) {
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(method, "method");
        this.credentials = credentials;
        this.headers = headers;
        this.method = method;
    }

    public /* synthetic */ NativeRequestInit(NativeRequestCredentials nativeRequestCredentials, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? NativeRequestCredentials.INCLUDE : nativeRequestCredentials, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? "GET" : str);
    }

    @NotNull
    public final NativeRequestCredentials getCredentials() {
        return this.credentials;
    }

    @NotNull
    public final List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }
}
