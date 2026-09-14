package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.B6 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSrmHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrmHttpClient.kt\ncom/contentsquare/android/internal/features/srm/SrmHttpClient\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,86:1\n113#2:87\n96#3:88\n*S KotlinDebug\n*F\n+ 1 SrmHttpClient.kt\ncom/contentsquare/android/internal/features/srm/SrmHttpClient\n*L\n44#1:87\n52#1:88\n*E\n"})
public final class C2453B6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final HttpConnection f1445a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Configuration f1446b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1447c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Lazy f1448d;

    @JvmOverloads
    public C2453B6(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        HttpConnection httpConnection = new HttpConnection();
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f1445a = httpConnection;
        this.f1446b = configuration;
        this.f1447c = new Logger("SrmHttpClient");
        this.f1448d = LazyKt.lazy(new C2443A6(this));
    }
}
