package com.facebook.react.devsupport;

import com.appdynamics.eumagent.runtime.networkrequests.OkHttp3;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/devsupport/PackagerStatusCheck;", "", "<init>", "()V", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "run", "", "host", "", "callback", "Lcom/facebook/react/devsupport/interfaces/PackagerStatusCallback;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PackagerStatusCheck {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;

    @NotNull
    private static final String PACKAGER_OK_STATUS = "packager-status:running";

    @NotNull
    private static final String PACKAGER_STATUS_URL_TEMPLATE = "http://%s/status";

    @NotNull
    private final OkHttpClient client;

    public PackagerStatusCheck() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.client = builder.connectTimeout(5000L, timeUnit).readTimeout(0L, timeUnit).writeTimeout(0L, timeUnit).build();
    }

    public PackagerStatusCheck(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    public final void run(@NotNull String host, @NotNull final PackagerStatusCallback callback) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Request.Builder builderUrl = new Request.Builder().url(Companion.createPackagerStatusURL(host));
        OkHttp3.Request.Builder.build.Enter(builderUrl);
        this.client.newCall(builderUrl.build()).enqueue(new Callback() { // from class: com.facebook.react.devsupport.PackagerStatusCheck.run.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                FLog.w(ReactConstants.TAG, "The packager does not seem to be running as we got an IOException requesting its status: " + e.getMessage());
                callback.onPackagerStatusFetched(false);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    FLog.e(ReactConstants.TAG, "Got non-success http code from packager when requesting status: " + response.getCode());
                    callback.onPackagerStatusFetched(false);
                    return;
                }
                ResponseBody body = response.getBody();
                if (body == null) {
                    FLog.e(ReactConstants.TAG, "Got null body response from packager when requesting status");
                    callback.onPackagerStatusFetched(false);
                    return;
                }
                String strString = body.string();
                if (!Intrinsics.areEqual(PackagerStatusCheck.PACKAGER_OK_STATUS, strString)) {
                    FLog.e(ReactConstants.TAG, "Got unexpected response from packager when requesting status: " + strString);
                    callback.onPackagerStatusFetched(false);
                    return;
                }
                callback.onPackagerStatusFetched(true);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/devsupport/PackagerStatusCheck$Companion;", "", "<init>", "()V", "PACKAGER_OK_STATUS", "", "HTTP_CONNECT_TIMEOUT_MS", "", "PACKAGER_STATUS_URL_TEMPLATE", "createPackagerStatusURL", "host", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String createPackagerStatusURL(String host) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, PackagerStatusCheck.PACKAGER_STATUS_URL_TEMPLATE, Arrays.copyOf(new Object[]{host}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }
}
