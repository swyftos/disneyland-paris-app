package com.urbanairship.wallet;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.config.UrlBuilder;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestSession;
import com.urbanairship.http.Response;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import com.urbanairship.wallet.PassRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class PassRequest {
    private static final Executor DEFAULT_REQUEST_EXECUTOR = AirshipExecutors.newSerialExecutor();
    private final String apiKey;
    private final String externalId;
    private final Collection fields;
    private final Collection headers;
    private CancelableCallback requestCallback;
    private final Executor requestExecutor;
    private final RequestSession session;
    private final String tag;
    private final String templateId;
    private final String userName;

    PassRequest(Builder builder, RequestSession requestSession, Executor executor) {
        this.apiKey = builder.apiKey;
        this.userName = builder.userName;
        this.templateId = builder.templateId;
        this.fields = builder.fields;
        this.headers = builder.headers;
        this.tag = builder.tag;
        this.externalId = builder.externalId;
        this.session = requestSession;
        this.requestExecutor = executor;
    }

    PassRequest(Builder builder) {
        this(builder, UAirship.shared().getRuntimeConfig().getRequestSession(), DEFAULT_REQUEST_EXECUTOR);
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @SuppressLint({"NewApi"})
    public void execute(@NonNull Callback callback) {
        execute(callback, null);
    }

    @SuppressLint({"NewApi"})
    public void execute(@NonNull Callback callback, @Nullable Looper looper) {
        if (this.requestCallback != null) {
            throw new IllegalStateException("PassRequest can only be executed once.");
        }
        this.requestCallback = new CancelableCallback(callback, looper);
        this.requestExecutor.execute(new AnonymousClass1());
    }

    /* renamed from: com.urbanairship.wallet.PassRequest$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JsonMap jsonMapBuild;
            UALog.i("Requesting pass %s", PassRequest.this.templateId);
            Uri passUrl = PassRequest.this.getPassUrl();
            if (passUrl == null) {
                UALog.e("PassRequest - Invalid pass URL", new Object[0]);
                PassRequest.this.requestCallback.setResult(-1, null);
                return;
            }
            JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
            for (Field field : PassRequest.this.fields) {
                builderNewBuilder.putOpt(field.getName(), field.getJsonValue());
            }
            if (PassRequest.this.headers.isEmpty()) {
                jsonMapBuild = null;
            } else {
                JsonMap.Builder builderNewBuilder2 = JsonMap.newBuilder();
                for (Field field2 : PassRequest.this.headers) {
                    builderNewBuilder2.putOpt(field2.getName(), field2.getJsonValue());
                }
                jsonMapBuild = builderNewBuilder2.build();
            }
            JsonMap jsonMapBuild2 = JsonMap.newBuilder().putOpt("headers", jsonMapBuild).put("fields", builderNewBuilder.build()).putOpt("tag", PassRequest.this.tag).put("publicURL", JsonMap.newBuilder().put("type", "multiple").build()).putOpt("externalId", PassRequest.this.externalId).build();
            HashMap map = new HashMap();
            map.put("Api-Revision", "1.2");
            Request request = new Request(passUrl, "POST", (PassRequest.this.userName == null || PassRequest.this.apiKey == null) ? null : new RequestAuth.BasicAuth(PassRequest.this.userName, PassRequest.this.apiKey), new RequestBody.Json(jsonMapBuild2), map);
            UALog.d("Requesting pass %s with payload: %s", passUrl, jsonMapBuild2);
            try {
                Response responseExecute = PassRequest.this.session.execute(request, new ResponseParser() { // from class: com.urbanairship.wallet.PassRequest$1$$ExternalSyntheticLambda0
                    @Override // com.urbanairship.http.ResponseParser
                    public final Object parseResponse(int i, Map map2, String str) {
                        return PassRequest.AnonymousClass1.lambda$run$0(i, map2, str);
                    }
                });
                UALog.d("Pass %s request finished with status %s", PassRequest.this.templateId, Integer.valueOf(responseExecute.getStatus()));
                PassRequest.this.requestCallback.setResult(responseExecute.getStatus(), (Pass) responseExecute.getResult());
            } catch (RequestException e) {
                UALog.e(e, "PassRequest - Request failed", new Object[0]);
                PassRequest.this.requestCallback.setResult(-1, null);
            }
            PassRequest.this.requestCallback.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Pass lambda$run$0(int i, Map map, String str) {
            if (UAHttpStatusUtil.inSuccessRange(i)) {
                return Pass.parsePass(JsonValue.parseString(str));
            }
            return null;
        }
    }

    public void cancel() {
        CancelableCallback cancelableCallback = this.requestCallback;
        if (cancelableCallback != null) {
            cancelableCallback.cancel();
        }
    }

    Uri getPassUrl() {
        UrlBuilder urlBuilderAppendEncodedPath = UAirship.shared().getRuntimeConfig().getWalletUrl().appendEncodedPath("v1/pass").appendEncodedPath(this.templateId);
        if (this.userName == null) {
            urlBuilderAppendEncodedPath.appendQueryParameter("api_key", this.apiKey);
        }
        return urlBuilderAppendEncodedPath.build();
    }

    @NonNull
    public String toString() {
        return "PassRequest{ templateId: " + this.templateId + ", fields: " + this.fields + ", tag: " + this.tag + ", externalId: " + this.externalId + ", headers: " + this.headers + " }";
    }

    public static class Builder {
        private String apiKey;
        private String externalId;
        private final List fields = new ArrayList();
        private final List headers = new ArrayList();
        private String tag;
        private String templateId;
        private String userName;

        @NonNull
        public Builder setAuth(@NonNull String str, @NonNull String str2) {
            this.apiKey = str2;
            this.userName = str;
            return this;
        }

        @NonNull
        public Builder setTemplateId(@NonNull @Size(min = 1) String str) {
            this.templateId = str;
            return this;
        }

        @NonNull
        public Builder addField(@NonNull Field field) {
            this.fields.add(field);
            return this;
        }

        @NonNull
        public Builder setExpirationDate(@NonNull String str, @NonNull String str2) {
            this.headers.add(Field.newBuilder().setName("expirationDate").setValue(str).setLabel(str2).build());
            return this;
        }

        @NonNull
        public Builder setBarcodeValue(@NonNull String str, @NonNull String str2) {
            this.headers.add(Field.newBuilder().setName("barcode_value").setValue(str).setLabel(str2).build());
            return this;
        }

        @NonNull
        public Builder setBarcodeAltText(@NonNull String str, @NonNull String str2) {
            this.headers.add(Field.newBuilder().setName("barcodeAltText").setValue(str).setLabel(str2).build());
            return this;
        }

        @NonNull
        public Builder setTag(@Nullable String str) {
            this.tag = str;
            return this;
        }

        @NonNull
        public Builder setExternalId(@Nullable String str) {
            this.externalId = str;
            return this;
        }

        @NonNull
        public PassRequest build() {
            if (TextUtils.isEmpty(this.apiKey) || TextUtils.isEmpty(this.templateId)) {
                throw new IllegalStateException("The apiKey or templateId is missing.");
            }
            return new PassRequest(this);
        }
    }
}
