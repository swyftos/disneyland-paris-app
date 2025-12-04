package com.contentsquare.android.error.analysis.network;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/contentsquare/android/error/analysis/network/OkHttpNetworkInstrumentation;", "", "()V", "addInterceptor", "", "builder", "Lokhttp3/OkHttpClient$Builder;", "removeExcessInterceptors", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOkHttpNetworkInstrumentation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpNetworkInstrumentation.kt\ncom/contentsquare/android/error/analysis/network/OkHttpNetworkInstrumentation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1774#2,4:36\n*S KotlinDebug\n*F\n+ 1 OkHttpNetworkInstrumentation.kt\ncom/contentsquare/android/error/analysis/network/OkHttpNetworkInstrumentation\n*L\n26#1:36,4\n*E\n"})
/* loaded from: classes2.dex */
public final class OkHttpNetworkInstrumentation {

    @NotNull
    public static final OkHttpNetworkInstrumentation INSTANCE = new OkHttpNetworkInstrumentation();

    private OkHttpNetworkInstrumentation() {
    }

    @JvmStatic
    public static final void addInterceptor(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.addInterceptor(new ErrorAnalysisInterceptor());
    }

    @JvmStatic
    public static final void removeExcessInterceptors(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Iterator<Interceptor> it = builder.interceptors().iterator();
        List<Interceptor> listInterceptors = builder.interceptors();
        int i = 0;
        if (listInterceptors == null || !listInterceptors.isEmpty()) {
            Iterator<T> it2 = listInterceptors.iterator();
            while (it2.hasNext()) {
                if ((((Interceptor) it2.next()) instanceof ErrorAnalysisInterceptor) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        while (it.hasNext() && i > 1) {
            if (it.next() instanceof ErrorAnalysisInterceptor) {
                it.remove();
                i--;
            }
        }
    }
}
