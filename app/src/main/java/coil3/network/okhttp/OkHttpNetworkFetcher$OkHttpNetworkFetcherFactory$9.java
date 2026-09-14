package coil3.network.okhttp;

import coil3.PlatformContext;
import coil3.network.ConnectivityChecker;
import coil3.network.ConnectivityCheckerKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$9 extends FunctionReferenceImpl implements Function1 {
    public static final OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$9 INSTANCE = new OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$9();

    OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$9() {
        super(1, ConnectivityCheckerKt.class, "ConnectivityChecker", "ConnectivityChecker(Lcoil3/PlatformContext;)Lcoil3/network/ConnectivityChecker;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ConnectivityChecker invoke(PlatformContext platformContext) {
        return ConnectivityCheckerKt.ConnectivityChecker(platformContext);
    }
}
