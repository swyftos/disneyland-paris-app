package coil3.network;

import ch.qos.logback.core.CoreConstants;
import coil3.annotation.ExperimentalCoilApi;
import coil3.network.internal.DefaultCacheStrategy;
import coil3.request.Options;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00112\u00020\u0001:\u0003\u000f\u0010\u0011J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ0\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, m1836d2 = {"Lcoil3/network/CacheStrategy;", "", "read", "Lcoil3/network/CacheStrategy$ReadResult;", "cacheResponse", "Lcoil3/network/NetworkResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "options", "Lcoil3/request/Options;", "(Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/request/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "Lcoil3/network/CacheStrategy$WriteResult;", "networkResponse", "(Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/network/NetworkResponse;Lcoil3/request/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ReadResult", "WriteResult", "Companion", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@ExperimentalCoilApi
public interface CacheStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final CacheStrategy DEFAULT = new DefaultCacheStrategy();

    @Nullable
    Object read(@NotNull NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull Options options, @NotNull Continuation<? super ReadResult> continuation);

    @Nullable
    Object write(@Nullable NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull NetworkResponse networkResponse2, @NotNull Options options, @NotNull Continuation<? super WriteResult> continuation);

    @Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m1836d2 = {"Lcoil3/network/CacheStrategy$ReadResult;", "", "request", "Lcoil3/network/NetworkRequest;", "<init>", "(Lcoil3/network/NetworkRequest;)V", "response", "Lcoil3/network/NetworkResponse;", "(Lcoil3/network/NetworkResponse;)V", "getRequest", "()Lcoil3/network/NetworkRequest;", "getResponse", "()Lcoil3/network/NetworkResponse;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class ReadResult {
        private final NetworkRequest request;
        private final NetworkResponse response;

        @Nullable
        public final NetworkRequest getRequest() {
            return this.request;
        }

        @Nullable
        public final NetworkResponse getResponse() {
            return this.response;
        }

        public ReadResult(@NotNull NetworkRequest networkRequest) {
            this.request = networkRequest;
            this.response = null;
        }

        public ReadResult(@NotNull NetworkResponse networkResponse) {
            this.request = null;
            this.response = networkResponse;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ReadResult) {
                ReadResult readResult = (ReadResult) other;
                if (Intrinsics.areEqual(this.request, readResult.request) && Intrinsics.areEqual(this.response, readResult.response)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            NetworkRequest networkRequest = this.request;
            int iHashCode = (networkRequest != null ? networkRequest.hashCode() : 0) * 31;
            NetworkResponse networkResponse = this.response;
            return iHashCode + (networkResponse != null ? networkResponse.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ReadResult(request=" + this.request + ", response=" + this.response + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0012¢\u0006\u0004\b\u0004\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m1836d2 = {"Lcoil3/network/CacheStrategy$WriteResult;", "", "response", "Lcoil3/network/NetworkResponse;", "<init>", "(Lcoil3/network/NetworkResponse;)V", "()V", "getResponse", "()Lcoil3/network/NetworkResponse;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class WriteResult {

        @JvmField
        @NotNull
        public static final WriteResult DISABLED = new WriteResult();
        private final NetworkResponse response;

        @Nullable
        public final NetworkResponse getResponse() {
            return this.response;
        }

        public WriteResult(@NotNull NetworkResponse networkResponse) {
            this.response = networkResponse;
        }

        private WriteResult() {
            this.response = null;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WriteResult) && Intrinsics.areEqual(this.response, ((WriteResult) other).response);
        }

        public int hashCode() {
            NetworkResponse networkResponse = this.response;
            if (networkResponse != null) {
                return networkResponse.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "WriteResult(response=" + this.response + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, m1836d2 = {"Lcoil3/network/CacheStrategy$Companion;", "", "<init>", "()V", "DEFAULT", "Lcoil3/network/CacheStrategy;", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
