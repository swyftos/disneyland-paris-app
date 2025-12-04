package com.disney.id.android.services;

import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/disney/id/android/services/ReportingInterceptor;", "Lokhttp3/Interceptor;", "()V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHTTPInterceptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HTTPInterceptors.kt\ncom/disney/id/android/services/ReportingInterceptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,295:1\n1#2:296\n*E\n"})
/* loaded from: classes3.dex */
public final class ReportingInterceptor implements Interceptor {
    private static final String TAG = ReportingInterceptor.class.getSimpleName();

    @Inject
    public Logger logger;

    @Inject
    public Tracker tracker;

    public ReportingInterceptor() {
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    @Override // okhttp3.Interceptor
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r15) throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            okhttp3.Request r0 = r15.request()
            java.lang.String r1 = "request(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            okhttp3.Headers r1 = r0.headers()
            java.lang.String r2 = "replaceWithConversationId"
            java.lang.String r1 = r1.get(r2)
            java.lang.String r3 = "deleteMe"
            r4 = 0
            if (r1 == 0) goto L52
            okhttp3.Headers r5 = r0.headers()
            java.lang.String r5 = r5.get(r3)
            if (r5 == 0) goto L50
            com.disney.id.android.tracker.Tracker r6 = r14.getTracker$OneID_release()
            com.disney.id.android.tracker.TrackerEventKey r7 = new com.disney.id.android.tracker.TrackerEventKey
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r7.<init>(r1, r5)
            com.disney.id.android.tracker.OneIDTrackerEvent r5 = r6.getEvent(r7)
            if (r5 == 0) goto L3e
            java.lang.String r6 = r5.getConversationId$OneID_release()
            goto L3f
        L3e:
            r6 = r4
        L3f:
            if (r5 == 0) goto L46
            java.lang.String r7 = r5.getTransactionId$OneID_release()
            goto L47
        L46:
            r7 = r4
        L47:
            if (r5 == 0) goto L4d
            java.lang.String r4 = r5.getReportBase64()
        L4d:
            r5 = r4
            r4 = r6
            goto L55
        L50:
            r5 = r4
            goto L54
        L52:
            r1 = r4
            r5 = r1
        L54:
            r7 = r5
        L55:
            if (r1 != 0) goto L6a
            com.disney.id.android.logging.Logger r8 = r14.getLogger$OneID_release()
            java.lang.String r9 = com.disney.id.android.services.ReportingInterceptor.TAG
            java.lang.String r14 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r14)
            r12 = 4
            r13 = 0
            java.lang.String r10 = "A service call was made without adding the CONVERSATION-ID"
            r11 = 0
            com.disney.id.android.logging.Logger.DefaultImpls.wtf$default(r8, r9, r10, r11, r12, r13)
        L6a:
            okhttp3.Request$Builder r14 = r0.newBuilder()
            r14.removeHeader(r2)
            r14.removeHeader(r3)
            if (r4 == 0) goto L7b
            java.lang.String r0 = "CONVERSATION-ID"
            r14.addHeader(r0, r4)
        L7b:
            if (r7 == 0) goto L82
            java.lang.String r0 = "CORRELATION-ID"
            r14.addHeader(r0, r7)
        L82:
            if (r5 == 0) goto L89
            java.lang.String r0 = "OneID-Reporting"
            r14.addHeader(r0, r5)
        L89:
            com.appdynamics.eumagent.runtime.networkrequests.OkHttp3.Request.Builder.build.Enter(r14)
            okhttp3.Request r14 = r14.build()
            java.lang.String r0 = "with(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)
            okhttp3.Response r14 = r15.proceed(r14)
            java.lang.String r15 = "proceed(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.services.ReportingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
