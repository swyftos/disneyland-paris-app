package com.disney.id.android.services;

import com.allegion.accesssdk.BuildConfig;
import com.disney.id.android.Session;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.extensions.JSONExtensionsKt;
import com.disney.id.android.tracker.Tracker;
import dagger.Lazy;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/disney/id/android/services/GuestControllerResponseInterceptor;", "Lokhttp3/Interceptor;", "()V", BuildConfig.SESSION_KEY_REFERENCE, "Ldagger/Lazy;", "Lcom/disney/id/android/Session;", "getSession$OneID_release", "()Ldagger/Lazy;", "setSession$OneID_release", "(Ldagger/Lazy;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "keyError", "Lorg/json/JSONObject;", "keyErrorCategory", "", "errors", "Lorg/json/JSONArray;", "validateResponse", "request", "Lokhttp3/Request;", "response", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHTTPInterceptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HTTPInterceptors.kt\ncom/disney/id/android/services/GuestControllerResponseInterceptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,295:1\n1#2:296\n*E\n"})
/* loaded from: classes3.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[Catch: JSONException -> 0x00a3, TryCatch #0 {JSONException -> 0x00a3, blocks: (B:10:0x002b, B:12:0x0038, B:14:0x0040, B:16:0x0048, B:18:0x0054, B:20:0x005c, B:22:0x0064, B:24:0x006c, B:26:0x0074, B:28:0x0089, B:30:0x008f), top: B:38:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final okhttp3.Response validateResponse(okhttp3.Request r7, okhttp3.Response r8) throws java.io.IOException {
        /*
            r6 = this;
            okhttp3.ResponseBody r0 = r8.body()
            r1 = 0
            if (r0 == 0) goto La4
            okhttp3.ResponseBody r0 = r8.body()
            if (r0 == 0) goto L19
            long r2 = r0.get$contentLength()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L19
            goto La4
        L19:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            okhttp3.ResponseBody r0 = r8.peekBody(r2)
            java.lang.String r2 = "peekBody(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.String r0 = r0.string()
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> La3
            r2.<init>(r0)     // Catch: org.json.JSONException -> La3
            java.lang.String r0 = "error"
            org.json.JSONObject r0 = r2.optJSONObject(r0)     // Catch: org.json.JSONException -> La3
            if (r0 == 0) goto La2
            java.lang.String r2 = "keyCategory"
            java.lang.String r2 = com.disney.id.android.extensions.JSONExtensionsKt.getStringSafely(r0, r2)     // Catch: org.json.JSONException -> La3
            if (r2 == 0) goto La2
            java.lang.String r3 = "GUEST_BLOCKED"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)     // Catch: org.json.JSONException -> La3
            if (r3 != 0) goto L64
            java.lang.String r3 = "errors"
            org.json.JSONArray r0 = r0.optJSONArray(r3)     // Catch: org.json.JSONException -> La3
            org.json.JSONObject r0 = r6.keyError(r2, r0)     // Catch: org.json.JSONException -> La3
            if (r0 == 0) goto L5b
            java.lang.String r2 = "code"
            java.lang.String r0 = com.disney.id.android.extensions.JSONExtensionsKt.getStringSafely(r0, r2)     // Catch: org.json.JSONException -> La3
            goto L5c
        L5b:
            r0 = r1
        L5c:
            java.lang.String r2 = "AUTHORIZATION_INVALID_REFRESH_TOKEN"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)     // Catch: org.json.JSONException -> La3
            if (r0 == 0) goto La2
        L64:
            java.lang.String r0 = "replaceWithConversationId"
            java.lang.String r0 = r7.header(r0)     // Catch: org.json.JSONException -> La3
            if (r0 == 0) goto L8e
            java.lang.String r2 = "deleteMe"
            java.lang.String r7 = r7.header(r2)     // Catch: org.json.JSONException -> La3
            if (r7 == 0) goto L8e
            com.disney.id.android.tracker.Tracker r2 = r6.getTracker$OneID_release()     // Catch: org.json.JSONException -> La3
            com.disney.id.android.tracker.TrackerEventKey r3 = new com.disney.id.android.tracker.TrackerEventKey     // Catch: org.json.JSONException -> La3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: org.json.JSONException -> La3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: org.json.JSONException -> La3
            r3.<init>(r0, r7)     // Catch: org.json.JSONException -> La3
            com.disney.id.android.tracker.OneIDTrackerEvent r7 = r2.getEvent(r3)     // Catch: org.json.JSONException -> La3
            if (r7 == 0) goto L8e
            java.lang.String r7 = r7.getConversationId$OneID_release()     // Catch: org.json.JSONException -> La3
            goto L8f
        L8e:
            r7 = r1
        L8f:
            dagger.Lazy r6 = r6.getSession$OneID_release()     // Catch: org.json.JSONException -> La3
            java.lang.Object r6 = r6.get()     // Catch: org.json.JSONException -> La3
            java.lang.String r0 = "get(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch: org.json.JSONException -> La3
            com.disney.id.android.Session r6 = (com.disney.id.android.Session) r6     // Catch: org.json.JSONException -> La3
            r0 = 1
            com.disney.id.android.Session.DefaultImpls.end$default(r6, r1, r7, r0, r1)     // Catch: org.json.JSONException -> La3
        La2:
            return r8
        La3:
            return r1
        La4:
            okhttp3.ResponseBody r6 = r8.body()
            if (r6 == 0) goto Lae
            okhttp3.MediaType r1 = r6.get$contentType()
        Lae:
            java.lang.String r6 = "{}"
            okhttp3.ResponseBody r6 = okhttp3.ResponseBody.create(r1, r6)
            okhttp3.Response$Builder r7 = r8.newBuilder()
            okhttp3.Response$Builder r6 = r7.body(r6)
            okhttp3.Response r6 = r6.build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.services.GuestControllerResponseInterceptor.validateResponse(okhttp3.Request, okhttp3.Response):okhttp3.Response");
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
