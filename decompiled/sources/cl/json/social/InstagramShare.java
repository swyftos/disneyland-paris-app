package cl.json.social;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.media3.common.MimeTypes;
import cl.json.ShareFile;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes2.dex */
public class InstagramShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public InstagramShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        if (!ShareIntent.hasValidKey("type", readableMap)) {
            Log.e("RNShare", "No type provided");
            return;
        }
        String string = readableMap.getString("type");
        if (string.startsWith("text")) {
            openInstagramIntentChooserForText(this.chooserTitle);
            return;
        }
        if (!ShareIntent.hasValidKey("url", readableMap)) {
            Log.e("RNShare", "No url provided");
            return;
        }
        String string2 = readableMap.getString("url");
        if (string2.startsWith("instagram://")) {
            openInstagramUrlScheme(string2);
            return;
        }
        String extension = getExtension(string);
        openInstagramIntentChooserForMedia(string2, this.chooserTitle, Boolean.valueOf(string.startsWith(MimeTypes.BASE_TYPE_IMAGE)), extension);
    }

    protected void openInstagramUrlScheme(String str) throws ActivityNotFoundException {
        Uri uri = Uri.parse(str);
        getIntent().setAction("android.intent.action.VIEW");
        getIntent().setData(uri);
        super.openIntentChooser();
    }

    private String getExtension(String str) {
        return str.split("/")[r0.length - 1];
    }

    protected void openInstagramIntentChooserForText(String str) throws ActivityNotFoundException {
        getIntent().setPackage("com.instagram.android");
        getIntent().setType("text/plain");
        getIntent().setAction("android.intent.action.SEND");
        super.openIntentChooser();
    }

    protected void openInstagramIntentChooserForMedia(String str, String str2, Boolean bool, String str3) {
        ShareFile shareFile;
        Boolean boolValueOf = Boolean.valueOf(ShareIntent.hasValidKey("useInternalStorage", this.options) && this.options.getBoolean("useInternalStorage"));
        if (bool.booleanValue()) {
            shareFile = new ShareFile(str, "image/" + str3, MimeTypes.BASE_TYPE_IMAGE, boolValueOf, this.reactContext);
        } else {
            shareFile = new ShareFile(str, "video/" + str3, MimeTypes.BASE_TYPE_VIDEO, boolValueOf, this.reactContext);
        }
        Uri uri = shareFile.getURI();
        Intent intent = new Intent("android.intent.action.SEND");
        if (bool.booleanValue()) {
            intent.setType("image/*");
        } else {
            intent.setType("video/*");
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setPackage("com.instagram.android");
        Intent intent2 = new Intent("com.instagram.share.ADD_TO_STORY");
        intent2.setDataAndType(uri, str3);
        intent2.addFlags(1);
        intent2.setPackage("com.instagram.android");
        Intent intentCreateChooser = Intent.createChooser(intent, str2);
        intentCreateChooser.addFlags(268435456);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent2});
        this.reactContext.getCurrentActivity().grantUriPermission("com.instagram.android", uri, 1);
        this.reactContext.startActivity(intentCreateChooser);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("success", true);
        writableMapCreateMap.putString("message", getIntent().getPackage());
        TargetChosenReceiver.callbackResolve(writableMapCreateMap);
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.instagram.android";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return "https://play.google.com/store/apps/details?id=com.instagram.android";
    }
}
