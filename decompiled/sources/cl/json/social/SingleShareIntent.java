package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import cl.json.RNShareImpl;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.PrintStream;

/* loaded from: classes2.dex */
public abstract class SingleShareIntent extends ShareIntent {
    protected String appStoreURL;
    protected String playStoreURL;

    public SingleShareIntent(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.playStoreURL = null;
        this.appStoreURL = null;
    }

    @Override // cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        String playStoreLink;
        PrintStream printStream = System.out;
        printStream.println(getPackage());
        if (getPackage() != null || getDefaultWebLink() != null || getPlayStoreLink() != null) {
            if (ShareIntent.isPackageInstalled(getPackage(), this.reactContext)) {
                printStream.println("INSTALLED");
                if (getComponentClass() != null) {
                    getIntent().setComponent(new ComponentName(getPackage(), getComponentClass()));
                } else {
                    getIntent().setPackage(getPackage());
                }
                super.open(readableMap);
                return;
            }
            printStream.println("NOT INSTALLED");
            if (getDefaultWebLink() != null) {
                playStoreLink = getDefaultWebLink().replace("{url}", ShareIntent.urlEncode(readableMap.getString("url"))).replace("{message}", ShareIntent.urlEncode(readableMap.getString("message")));
            } else if (getPlayStoreLink() == null) {
                playStoreLink = "";
            } else {
                playStoreLink = getPlayStoreLink();
            }
            setIntent(new Intent(new Intent("android.intent.action.VIEW", Uri.parse(playStoreLink))));
        }
        super.open(readableMap);
    }

    @Override // cl.json.social.ShareIntent
    protected void openIntentChooser() throws ActivityNotFoundException {
        openIntentChooser(null);
    }

    protected void openIntentChooser(ReadableMap readableMap) throws ActivityNotFoundException {
        if (this.options.hasKey("forceDialog") && this.options.getBoolean("forceDialog")) {
            Activity currentActivity = this.reactContext.getCurrentActivity();
            if (currentActivity == null) {
                TargetChosenReceiver.callbackReject("Something went wrong");
                return;
            }
            if (readableMap != null && !ShareIntent.hasValidKey(NotificationCompat.CATEGORY_SOCIAL, readableMap)) {
                throw new IllegalArgumentException("social is empty");
            }
            if (TargetChosenReceiver.isSupported()) {
                Intent intentCreateChooser = Intent.createChooser(getIntent(), this.chooserTitle, TargetChosenReceiver.getSharingSenderIntent(this.reactContext));
                intentCreateChooser.addFlags(1073741824);
                currentActivity.startActivityForResult(intentCreateChooser, RNShareImpl.SHARE_REQUEST_CODE);
                return;
            }
            Intent intentCreateChooser2 = Intent.createChooser(getIntent(), this.chooserTitle);
            intentCreateChooser2.addFlags(1073741824);
            currentActivity.startActivityForResult(intentCreateChooser2, RNShareImpl.SHARE_REQUEST_CODE);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putBoolean("success", true);
            writableMapCreateMap.putString("message", "OK");
            TargetChosenReceiver.callbackResolve(writableMapCreateMap);
            return;
        }
        getIntent().addFlags(268435456);
        this.reactContext.startActivity(getIntent());
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putBoolean("success", true);
        writableMapCreateMap2.putString("message", getIntent().getPackage());
        TargetChosenReceiver.callbackResolve(writableMapCreateMap2);
    }
}
