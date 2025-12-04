package com.contentsquare.android.sdk;

import android.app.Application;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.BuildConfigInstantiable;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nWebViewTagDownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewTagDownloader.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewTagDownloader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n1#2:143\n*E\n"})
/* loaded from: classes2.dex */
public final class Q8 {

    @NotNull
    public final HttpConnection a;

    @NotNull
    public final BuildConfigInstantiable b;

    @Nullable
    public final String c;

    @NotNull
    public final CoroutineScope d;

    @NotNull
    public final Logger e;

    public Q8() {
        Application application;
        File filesDir;
        HttpConnection httpConnection = new HttpConnection();
        BuildConfigInstantiable buildConfig = new BuildConfigInstantiable();
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        String path = (csApplicationModule == null || (application = csApplicationModule.getApplication()) == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getPath();
        CoroutineDispatcher ioDispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.a = httpConnection;
        this.b = buildConfig;
        this.c = path;
        this.d = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(ioDispatcher), new CoroutineName("WebViewTagDownloader"));
        this.e = new Logger("WebViewTagDownloader");
    }
}
