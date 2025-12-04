package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;

/* loaded from: classes2.dex */
public class FacebookStoriesShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public FacebookStoriesShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        setIntent(new Intent("com.facebook.stories.ADD_TO_STORY"));
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException, IllegalArgumentException {
        super.open(readableMap);
        shareStory(readableMap);
        openIntentChooser(readableMap);
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.facebook.katana";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return "market://details?id=com.facebook.katana";
    }

    private void shareStory(ReadableMap readableMap) {
        String string;
        if (!ShareIntent.hasValidKey("appId", readableMap)) {
            throw new IllegalArgumentException("appId was not provided.");
        }
        if (!ShareIntent.hasValidKey("backgroundImage", readableMap) && !ShareIntent.hasValidKey("backgroundVideo", readableMap) && !ShareIntent.hasValidKey("stickerImage", readableMap)) {
            throw new IllegalArgumentException("Invalid background or sticker assets provided.");
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null) {
            this.intent.putExtra("com.facebook.platform.extra.APPLICATION_ID", readableMap.getString("appId"));
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
            boolean z = ShareIntent.hasValidKey("backgroundImage", readableMap) || ShareIntent.hasValidKey("backgroundVideo", readableMap);
            if (z) {
                if (ShareIntent.hasValidKey("backgroundImage", readableMap)) {
                    string = readableMap.getString("backgroundImage");
                } else if (!ShareIntent.hasValidKey("backgroundVideo", readableMap)) {
                    string = "";
                } else {
                    string = readableMap.getString("backgroundVideo");
                }
                ShareFile shareFile = new ShareFile(string, "image/jpeg", AppStateModule.APP_STATE_BACKGROUND, boolValueOf, this.reactContext);
                this.intent.setDataAndType(shareFile.getURI(), shareFile.getType());
                this.intent.setFlags(1);
            }
            if (ShareIntent.hasValidKey("stickerImage", readableMap)) {
                ShareFile shareFile2 = new ShareFile(readableMap.getString("stickerImage"), "image/png", "sticker", boolValueOf, this.reactContext);
                if (!z) {
                    this.intent.setType("image/*");
                }
                this.intent.putExtra("interactive_asset_uri", shareFile2.getURI());
                currentActivity.grantUriPermission("com.facebook.katana", shareFile2.getURI(), 1);
                return;
            }
            return;
        }
        TargetChosenReceiver.callbackReject("Something went wrong");
    }
}
