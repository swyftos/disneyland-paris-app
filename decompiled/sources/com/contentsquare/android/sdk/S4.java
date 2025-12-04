package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.ThreadExecutor;
import com.contentsquare.android.sdk.Z4;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class S4 {

    @NotNull
    public final ThreadExecutor a;

    @NotNull
    public final MutableStateFlow<Z4> b;

    @NotNull
    public final PreferencesStore c;

    @NotNull
    public final R4 d;

    @NotNull
    public final HttpConnection e;

    public static final class a {

        @NotNull
        public final Q4 a;

        @NotNull
        public final String b;

        public a(@NotNull Q4 screenCapture, @NotNull String servicePath) {
            Intrinsics.checkNotNullParameter(screenCapture, "screenCapture");
            Intrinsics.checkNotNullParameter(servicePath, "servicePath");
            this.a = screenCapture;
            this.b = servicePath;
        }
    }

    @SourceDebugExtension({"SMAP\nScreenCaptureProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenCaptureProcessor.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCaptureProcessor$ScreenRecordProcessorRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
    public final class b implements Callable<Boolean> {

        @NotNull
        public final a a;

        @NotNull
        public final HttpConnection b;

        @NotNull
        public final PreferencesStore c;

        @NotNull
        public final Logger d;
        public final /* synthetic */ S4 e;

        public b(S4 s4, @NotNull a processingData, @NotNull HttpConnection httpConnection, @NotNull PreferencesStore preferencesStore) {
            Intrinsics.checkNotNullParameter(processingData, "processingData");
            Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
            Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
            this.e = s4;
            this.a = processingData;
            this.b = httpConnection;
            this.c = preferencesStore;
            this.d = new Logger("ScreenRecordProcessorRunnable");
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() throws JSONException {
            Object objM2968constructorimpl;
            Throwable thM2971exceptionOrNullimpl;
            List<G2> list;
            a aVar = this.a;
            U4 u4 = aVar.a.n;
            HttpResponse httpResponsePerformPostWithJson$default = null;
            String screenName = u4 != null ? u4.b : null;
            if (screenName == null) {
                screenName = "";
            }
            boolean z = false;
            boolean z2 = this.c.getBoolean(PreferencesKey.CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE, false);
            R4 r4 = this.e.d;
            Q4 screenCapture = aVar.a;
            r4.getClass();
            Intrinsics.checkNotNullParameter(screenCapture, "screenCapture");
            screenCapture.a = r4.a.pixelsToDp(screenCapture.a);
            screenCapture.b = r4.a.pixelsToDp(screenCapture.b);
            U4 u42 = screenCapture.n;
            if (u42 != null && (list = u42.d) != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    r4.a((G2) it.next());
                }
            }
            Q4 q4 = aVar.a;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM2968constructorimpl = Result.m2968constructorimpl(q4.a(z2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM2968constructorimpl = Result.m2968constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m2973isFailureimpl(objM2968constructorimpl) && (thM2971exceptionOrNullimpl = Result.m2971exceptionOrNullimpl(objM2968constructorimpl)) != null) {
                Logger logger = this.d;
                String message = thM2971exceptionOrNullimpl.getMessage();
                logger.e(thM2971exceptionOrNullimpl, message != null ? message : "");
            }
            if (Result.m2973isFailureimpl(objM2968constructorimpl)) {
                objM2968constructorimpl = null;
            }
            JSONObject jSONObject = (JSONObject) objM2968constructorimpl;
            if (jSONObject != null) {
                try {
                    HttpConnection httpConnection = this.b;
                    String str = aVar.b;
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "serializedScreenObject.toString()");
                    httpResponsePerformPostWithJson$default = HttpConnection.performPostWithJson$default(httpConnection, str, string, null, 4, null);
                } catch (OutOfMemoryError e) {
                    Q2.a(this.d, "Failed to sent the screengraph data to the following service path: " + aVar.b, e);
                    S4 s4 = this.e;
                    Z4.b.f reason = Z4.b.f.a;
                    s4.getClass();
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    Intrinsics.checkNotNullParameter(screenName, "screenName");
                    s4.b.tryEmit(new Z4.a(reason, screenName));
                }
                if (httpResponsePerformPostWithJson$default != null) {
                    if (httpResponsePerformPostWithJson$default.success()) {
                        this.e.b.tryEmit(new Z4.h(screenName));
                        z = true;
                    } else {
                        Throwable exception = httpResponsePerformPostWithJson$default.getException();
                        String str2 = "Failed to sent the screengraph data to the following service path: " + aVar.b;
                        Logger logger2 = this.d;
                        if (exception == null) {
                            logger2.e(str2);
                        } else {
                            Q2.a(logger2, str2, exception);
                        }
                        S4 s42 = this.e;
                        Z4.b.c reason2 = Z4.b.c.a;
                        s42.getClass();
                        Intrinsics.checkNotNullParameter(reason2, "reason");
                        Intrinsics.checkNotNullParameter(screenName, "screenName");
                        s42.b.tryEmit(new Z4.a(reason2, screenName));
                    }
                }
            } else {
                S4 s43 = this.e;
                Z4.b.e reason3 = Z4.b.e.a;
                s43.getClass();
                Intrinsics.checkNotNullParameter(reason3, "reason");
                Intrinsics.checkNotNullParameter(screenName, "screenName");
                s43.b.tryEmit(new Z4.a(reason3, screenName));
                this.d.e("Problems serializing the ScreenCapture object");
            }
            return Boolean.valueOf(z);
        }
    }

    public S4(ThreadExecutor executorService, MutableStateFlow snapshotStateFlow, PreferencesStore preferencesStore, R4 screenCaptureConverter) {
        HttpConnection httpConnection = new HttpConnection();
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(screenCaptureConverter, "screenCaptureConverter");
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        this.a = executorService;
        this.b = snapshotStateFlow;
        this.c = preferencesStore;
        this.d = screenCaptureConverter;
        this.e = httpConnection;
    }
}
