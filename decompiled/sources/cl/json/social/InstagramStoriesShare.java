package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;

/* loaded from: classes2.dex */
public class InstagramStoriesShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public InstagramStoriesShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        setIntent(new Intent("com.instagram.share.ADD_TO_STORY"));
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        shareStory(readableMap);
        openIntentChooser(readableMap);
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.instagram.android";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return "https://play.google.com/store/apps/details?id=com.instagram.android";
    }

    private void shareStory(ReadableMap readableMap) {
        String string;
        String string2;
        String str;
        if (!ShareIntent.hasValidKey("backgroundImage", readableMap) && !ShareIntent.hasValidKey("backgroundVideo", readableMap) && !ShareIntent.hasValidKey("stickerImage", readableMap)) {
            throw new IllegalArgumentException("Invalid background or sticker assets provided.");
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.callbackReject("Something went wrong");
            return;
        }
        this.intent.putExtra("source_application", readableMap.getString("appId"));
        this.intent.putExtra("bottom_background_color", "#906df4");
        this.intent.putExtra("top_background_color", "#837DF4");
        if (ShareIntent.hasValidKey("attributionURL", readableMap)) {
            this.intent.putExtra("content_url", readableMap.getString("attributionURL"));
        }
        if (ShareIntent.hasValidKey("backgroundTopColor", readableMap)) {
            this.intent.putExtra("top_background_color", readableMap.getString("backgroundTopColor"));
        }
        if (ShareIntent.hasValidKey("backgroundBottomColor", readableMap)) {
            this.intent.putExtra("bottom_background_color", readableMap.getString("backgroundBottomColor"));
        }
        Boolean boolValueOf = Boolean.FALSE;
        if (ShareIntent.hasValidKey("useInternalStorage", readableMap)) {
            boolValueOf = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
        }
        if (ShareIntent.hasValidKey("linkUrl", readableMap)) {
            this.intent.putExtra("link_url", readableMap.getString("linkUrl"));
        }
        if (ShareIntent.hasValidKey("linkText", readableMap)) {
            this.intent.putExtra("link_text", readableMap.getString("linkText"));
        }
        boolean z = ShareIntent.hasValidKey("backgroundImage", readableMap) || ShareIntent.hasValidKey("backgroundVideo", readableMap);
        if (z) {
            if (ShareIntent.hasValidKey("backgroundImage", readableMap)) {
                string = readableMap.getString("backgroundImage");
            } else if (!ShareIntent.hasValidKey("backgroundVideo", readableMap)) {
                string = "";
            } else {
                string2 = readableMap.getString("backgroundVideo");
                str = "video/*";
                ShareFile shareFile = new ShareFile(string2, str, AppStateModule.APP_STATE_BACKGROUND, boolValueOf, this.reactContext);
                this.intent.setDataAndType(shareFile.getURI(), shareFile.getType());
                this.intent.setFlags(1);
            }
            str = "image/jpeg";
            string2 = string;
            ShareFile shareFile2 = new ShareFile(string2, str, AppStateModule.APP_STATE_BACKGROUND, boolValueOf, this.reactContext);
            this.intent.setDataAndType(shareFile2.getURI(), shareFile2.getType());
            this.intent.setFlags(1);
        }
        if (ShareIntent.hasValidKey("stickerImage", readableMap)) {
            ShareFile shareFile3 = new ShareFile(readableMap.getString("stickerImage"), "image/png", "sticker", boolValueOf, this.reactContext);
            if (!z) {
                this.intent.setType("image/*");
            }
            this.intent.putExtra("interactive_asset_uri", shareFile3.getURI());
            currentActivity.grantUriPermission("com.instagram.android", shareFile3.getURI(), 1);
        }
    }
}
