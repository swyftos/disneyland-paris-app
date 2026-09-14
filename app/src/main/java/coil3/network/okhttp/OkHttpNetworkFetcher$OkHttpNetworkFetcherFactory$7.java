package coil3.network.okhttp;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7 extends FunctionReferenceImpl implements Function0 {
    public static final OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7 INSTANCE = new OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7();

    OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7() {
        super(0, OkHttpClient.class, "<init>", "<init>()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final OkHttpClient invoke() {
        return new OkHttpClient();
    }
}
