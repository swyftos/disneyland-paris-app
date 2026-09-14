package com.disney.p026id.android.services;

import com.appdynamics.eumagent.runtime.networkrequests.OkHttp3;
import com.disney.p026id.android.dagger.OneIDDagger;
import com.disney.p026id.android.logging.Logger;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.disney.p026id.android.tracker.Tracker;
import com.disney.p026id.android.tracker.TrackerEventKey;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m1836d2 = {"Lcom/disney/id/android/services/ReportingInterceptor;", "Lokhttp3/Interceptor;", "()V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nHTTPInterceptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HTTPInterceptors.kt\ncom/disney/id/android/services/ReportingInterceptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,295:1\n1#2:296\n*E\n"})
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

    /* JADX WARN: Code duplicated, block: B:20:0x0057  */
    /* JADX WARN: Code duplicated, block: B:23:0x0076  */
    /* JADX WARN: Code duplicated, block: B:25:0x007d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0084  */
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String reportBase64;
        String transactionId$OneID_release;
        Request.Builder builderNewBuilder;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Intrinsics.checkNotNullExpressionValue(request, "request(...)");
        String str = request.headers().get("replaceWithConversationId");
        String str2 = null;
        if (str != null) {
            String str3 = request.headers().get("deleteMe");
            if (str3 != null) {
                Tracker tracker$OneID_release = getTracker$OneID_release();
                Intrinsics.checkNotNull(str3);
                OneIDTrackerEvent event = tracker$OneID_release.getEvent(new TrackerEventKey(str, str3));
                String conversationId$OneID_release = event != null ? event.getConversationId$OneID_release() : null;
                transactionId$OneID_release = event != null ? event.getTransactionId$OneID_release() : null;
                reportBase64 = event != null ? event.getReportBase64() : null;
                str2 = conversationId$OneID_release;
            } else {
                reportBase64 = null;
            }
            if (str == null) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                Logger.DefaultImpls.wtf$default(logger$OneID_release, TAG2, "A service call was made without adding the CONVERSATION-ID", null, 4, null);
            }
            builderNewBuilder = request.newBuilder();
            builderNewBuilder.removeHeader("replaceWithConversationId");
            builderNewBuilder.removeHeader("deleteMe");
            if (str2 != null) {
                builderNewBuilder.addHeader("CONVERSATION-ID", str2);
            }
            if (transactionId$OneID_release != null) {
                builderNewBuilder.addHeader("CORRELATION-ID", transactionId$OneID_release);
            }
            if (reportBase64 != null) {
                builderNewBuilder.addHeader("OneID-Reporting", reportBase64);
            }
            OkHttp3.Request.Builder.build.Enter(builderNewBuilder);
            Request requestBuild = builderNewBuilder.build();
            Intrinsics.checkNotNullExpressionValue(requestBuild, "with(...)");
            Response responseProceed = chain.proceed(requestBuild);
            Intrinsics.checkNotNullExpressionValue(responseProceed, "proceed(...)");
            return responseProceed;
        }
        str = null;
        reportBase64 = null;
        transactionId$OneID_release = reportBase64;
        if (str == null) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.wtf$default(logger$OneID_release2, TAG3, "A service call was made without adding the CONVERSATION-ID", null, 4, null);
        }
        builderNewBuilder = request.newBuilder();
        builderNewBuilder.removeHeader("replaceWithConversationId");
        builderNewBuilder.removeHeader("deleteMe");
        if (str2 != null) {
            builderNewBuilder.addHeader("CONVERSATION-ID", str2);
        }
        if (transactionId$OneID_release != null) {
            builderNewBuilder.addHeader("CORRELATION-ID", transactionId$OneID_release);
        }
        if (reportBase64 != null) {
            builderNewBuilder.addHeader("OneID-Reporting", reportBase64);
        }
        OkHttp3.Request.Builder.build.Enter(builderNewBuilder);
        Request requestBuild2 = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(requestBuild2, "with(...)");
        Response responseProceed2 = chain.proceed(requestBuild2);
        Intrinsics.checkNotNullExpressionValue(responseProceed2, "proceed(...)");
        return responseProceed2;
    }
}
