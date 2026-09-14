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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Q8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nWebViewTagDownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewTagDownloader.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewTagDownloader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n1#2:143\n*E\n"})
public final class C2605Q8 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final HttpConnection f2046a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final BuildConfigInstantiable f2047b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f2048c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final CoroutineScope f2049d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Logger f2050e;

    public C2605Q8() {
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
        this.f2046a = httpConnection;
        this.f2047b = buildConfig;
        this.f2048c = path;
        this.f2049d = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(ioDispatcher), new CoroutineName("WebViewTagDownloader"));
        this.f2050e = new Logger("WebViewTagDownloader");
    }
}
