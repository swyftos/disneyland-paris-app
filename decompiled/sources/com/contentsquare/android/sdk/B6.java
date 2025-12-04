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

@SourceDebugExtension({"SMAP\nSrmHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrmHttpClient.kt\ncom/contentsquare/android/internal/features/srm/SrmHttpClient\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,86:1\n113#2:87\n96#3:88\n*S KotlinDebug\n*F\n+ 1 SrmHttpClient.kt\ncom/contentsquare/android/internal/features/srm/SrmHttpClient\n*L\n44#1:87\n52#1:88\n*E\n"})
/* loaded from: classes2.dex */
public final class B6 {

    @NotNull
    public final HttpConnection a;

    @NotNull
    public final Configuration b;

    @NotNull
    public final Logger c;

    @NotNull
    public final Lazy d;

    @JvmOverloads
    public B6(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        HttpConnection httpConnection = new HttpConnection();
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.a = httpConnection;
        this.b = configuration;
        this.c = new Logger("SrmHttpClient");
        this.d = LazyKt.lazy(new A6(this));
    }
}
