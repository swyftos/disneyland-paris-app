package cl.json.social;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes2.dex */
public class WhatsAppBusinessShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public WhatsAppBusinessShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws InterruptedException, ActivityNotFoundException {
        super.open(readableMap);
        if (readableMap.hasKey("whatsAppNumber")) {
            try {
                getIntent().setComponent(new ComponentName("com.whatsapp.w4b", "com.whatsapp.Conversation"));
                openIntentChooser();
                Thread.sleep(10L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getIntent().setComponent(null);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.whatsapp.w4b";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return "market://details?id=com.whatsapp.w4b";
    }
}
