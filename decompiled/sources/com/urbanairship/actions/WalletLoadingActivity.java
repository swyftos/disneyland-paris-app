package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.Autopilot;
import com.urbanairship.R;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.WalletLoadingActivity;
import com.urbanairship.activity.ThemedActivity;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.Response;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.Map;

/* loaded from: classes4.dex */
public class WalletLoadingActivity extends ThemedActivity {
    private final MutableLiveData liveData = new MutableLiveData();

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ua_activity_wallet_loading);
        Autopilot.automaticTakeOff(getApplication());
        Uri data = getIntent().getData();
        if (data == null) {
            UALog.w("User URI null, unable to process link.", new Object[0]);
            finish();
        } else {
            this.liveData.observe(this, new Observer() { // from class: com.urbanairship.actions.WalletLoadingActivity$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$onCreate$0((WalletLoadingActivity.Result) obj);
                }
            });
            resolveWalletUrl(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Result result) {
        if (result.exception != null || result.uri == null) {
            finish();
        } else {
            startActivity(new Intent("android.intent.action.VIEW", result.uri));
        }
    }

    private void resolveWalletUrl(final Uri uri) {
        AirshipExecutors.threadPoolExecutor().submit(new Runnable() { // from class: com.urbanairship.actions.WalletLoadingActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resolveWalletUrl$2(uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resolveWalletUrl$2(Uri uri) {
        try {
            UALog.d("Runner starting", new Object[0]);
            Response responseExecute = UAirship.shared().getRuntimeConfig().getRequestSession().execute(new Request(uri, "GET", false), new ResponseParser() { // from class: com.urbanairship.actions.WalletLoadingActivity$$ExternalSyntheticLambda2
                @Override // com.urbanairship.http.ResponseParser
                public final Object parseResponse(int i, Map map, String str) {
                    return WalletLoadingActivity.lambda$resolveWalletUrl$1(i, map, str);
                }
            });
            if (responseExecute.getResult() != null) {
                this.liveData.postValue(new Result(Uri.parse((String) responseExecute.getResult()), null));
            } else {
                UALog.w("No result found for Wallet URL, finishing action.", new Object[0]);
                this.liveData.postValue(new Result(null, null));
            }
        } catch (RequestException e) {
            this.liveData.postValue(new Result(null, e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$resolveWalletUrl$1(int i, Map map, String str) {
        if (UAHttpStatusUtil.inRedirectionRange(i)) {
            return (String) map.get("Location");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Result {
        Exception exception;
        Uri uri;

        public Result(Uri uri, Exception exc) {
            this.uri = uri;
            this.exception = exc;
        }
    }
}
