package com.disney.id.android.services;

import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'J0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006H'¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/services/BundlerService;", "", "getSiteConfig", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "url", "", "transactionId", "requestBundle", "ifNoneMatchValue", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BundlerService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String HEADER_NAME_IF_NONE_MATCH = "If-None-Match";

    @NotNull
    public static final String HEADER_NAME_TRANSACTION_ID = "transaction-id";

    @GET
    @NotNull
    Call<ResponseBody> getSiteConfig(@Url @NotNull String url, @Header("transaction-id") @Nullable String transactionId);

    @Streaming
    @GET
    @NotNull
    Call<ResponseBody> requestBundle(@Url @NotNull String url, @Header("transaction-id") @Nullable String transactionId, @Header("If-None-Match") @Nullable String ifNoneMatchValue);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/disney/id/android/services/BundlerService$Companion;", "", "()V", "HEADER_NAME_IF_NONE_MATCH", "", "HEADER_NAME_TRANSACTION_ID", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String HEADER_NAME_IF_NONE_MATCH = "If-None-Match";

        @NotNull
        public static final String HEADER_NAME_TRANSACTION_ID = "transaction-id";

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call requestBundle$default(BundlerService bundlerService, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestBundle");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return bundlerService.requestBundle(str, str2, str3);
        }

        public static /* synthetic */ Call getSiteConfig$default(BundlerService bundlerService, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSiteConfig");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return bundlerService.getSiteConfig(str, str2);
        }
    }
}
