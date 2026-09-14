package com.disney.p026id.android.services;

import com.allegion.accesssdk.BuildConfig;
import com.disney.p026id.android.Session;
import com.disney.p026id.android.dagger.OneIDDagger;
import com.disney.p026id.android.extensions.JSONExtensionsKt;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.disney.p026id.android.tracker.Tracker;
import com.disney.p026id.android.tracker.TrackerEventKey;
import com.google.firebase.messaging.Constants;
import dagger.Lazy;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, m1836d2 = {"Lcom/disney/id/android/services/GuestControllerResponseInterceptor;", "Lokhttp3/Interceptor;", "()V", BuildConfig.SESSION_KEY_REFERENCE, "Ldagger/Lazy;", "Lcom/disney/id/android/Session;", "getSession$OneID_release", "()Ldagger/Lazy;", "setSession$OneID_release", "(Ldagger/Lazy;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "keyError", "Lorg/json/JSONObject;", "keyErrorCategory", "", "errors", "Lorg/json/JSONArray;", "validateResponse", "request", "Lokhttp3/Request;", "response", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nHTTPInterceptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HTTPInterceptors.kt\ncom/disney/id/android/services/GuestControllerResponseInterceptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,295:1\n1#2:296\n*E\n"})
public final class GuestControllerResponseInterceptor implements Interceptor {

    @Inject
    public Lazy<Session> session;

    @Inject
    public Tracker tracker;

    public GuestControllerResponseInterceptor() {
        OneIDDagger.getComponent().inject(this);
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

    @NotNull
    public final Lazy<Session> getSession$OneID_release() {
        Lazy<Session> lazy = this.session;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException(BuildConfig.SESSION_KEY_REFERENCE);
        return null;
    }

    public final void setSession$OneID_release(@NotNull Lazy<Session> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.session = lazy;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws InterruptedException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response element = chain.proceed(request);
        for (int i = 0; i < 3; i++) {
            Intrinsics.checkNotNull(request);
            Intrinsics.checkNotNullExpressionValue(element, "element");
            Response responseValidateResponse = validateResponse(request, element);
            if (responseValidateResponse != null) {
                return responseValidateResponse;
            }
            Thread.sleep(2000L);
            element = chain.proceed(request);
        }
        Intrinsics.checkNotNullExpressionValue(element, "element");
        return element;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0064 A[Catch: JSONException -> 0x00a3, TryCatch #0 {JSONException -> 0x00a3, blocks: (B:10:0x002b, B:12:0x0038, B:14:0x0040, B:16:0x0048, B:18:0x0054, B:20:0x005c, B:22:0x0064, B:24:0x006c, B:26:0x0074, B:28:0x0089, B:30:0x008f), top: B:38:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    private final Response validateResponse(Request request, Response response) throws IOException {
        ResponseBody responseBodyBody;
        String stringSafely;
        String strHeader;
        String conversationId$OneID_release;
        String strHeader2;
        if (response.body() == null || ((responseBodyBody = response.body()) != null && responseBodyBody.get$contentLength() == 0)) {
            ResponseBody responseBodyBody2 = response.body();
            return response.newBuilder().body(ResponseBody.create(responseBodyBody2 != null ? responseBodyBody2.get$contentType() : null, "{}")).build();
        }
        ResponseBody responseBodyPeekBody = response.peekBody(Long.MAX_VALUE);
        Intrinsics.checkNotNullExpressionValue(responseBodyPeekBody, "peekBody(...)");
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(responseBodyPeekBody.string()).optJSONObject(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (jSONObjectOptJSONObject != null && (stringSafely = JSONExtensionsKt.getStringSafely(jSONObjectOptJSONObject, "keyCategory")) != null) {
                if (!Intrinsics.areEqual(stringSafely, OneIDTrackerEvent.ERROR_CATEGORY_GUEST_BLOCKED)) {
                    JSONObject jSONObjectKeyError = keyError(stringSafely, jSONObjectOptJSONObject.optJSONArray("errors"));
                    if (Intrinsics.areEqual(jSONObjectKeyError != null ? JSONExtensionsKt.getStringSafely(jSONObjectKeyError, "code") : null, OneIDTrackerEvent.ERROR_CODE_AUTHORIZATION_INVALID_REFRESH_TOKEN)) {
                        strHeader = request.header("replaceWithConversationId");
                        if (strHeader != null) {
                            conversationId$OneID_release = null;
                        } else {
                            conversationId$OneID_release = null;
                        }
                        Session session = getSession$OneID_release().get();
                        Intrinsics.checkNotNullExpressionValue(session, "get(...)");
                        Session.DefaultImpls.end$default(session, null, conversationId$OneID_release, 1, null);
                    }
                } else {
                    strHeader = request.header("replaceWithConversationId");
                    if (strHeader != null || (strHeader2 = request.header("deleteMe")) == null) {
                        conversationId$OneID_release = null;
                    } else {
                        Tracker tracker$OneID_release = getTracker$OneID_release();
                        Intrinsics.checkNotNull(strHeader);
                        Intrinsics.checkNotNull(strHeader2);
                        OneIDTrackerEvent event = tracker$OneID_release.getEvent(new TrackerEventKey(strHeader, strHeader2));
                        if (event != null) {
                            conversationId$OneID_release = event.getConversationId$OneID_release();
                        } else {
                            conversationId$OneID_release = null;
                        }
                    }
                    Session session2 = getSession$OneID_release().get();
                    Intrinsics.checkNotNullExpressionValue(session2, "get(...)");
                    Session.DefaultImpls.end$default(session2, null, conversationId$OneID_release, 1, null);
                }
            }
            return response;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject keyError(String keyErrorCategory, JSONArray errors) throws JSONException {
        if (errors != null) {
            int length = errors.length();
            for (int i = 0; i < length; i++) {
                Object obj = errors.get(i);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                if (Intrinsics.areEqual(JSONExtensionsKt.getStringSafely(jSONObject, "category"), keyErrorCategory)) {
                    return jSONObject;
                }
            }
        }
        return null;
    }
}
