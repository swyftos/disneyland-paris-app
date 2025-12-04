package com.urbanairship.push.notifications;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.UAStringUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.bouncycastle.i18n.ErrorBundle;

/* loaded from: classes5.dex */
public class StyleNotificationExtender implements NotificationCompat.Extender {
    private final Context context;
    private NotificationCompat.Style defaultStyle;
    private final PushMessage message;

    public StyleNotificationExtender(@NonNull Context context, @NonNull PushMessage pushMessage) {
        this.context = context.getApplicationContext();
        this.message = pushMessage;
    }

    @NonNull
    public StyleNotificationExtender setDefaultStyle(@Nullable NotificationCompat.Style style) {
        this.defaultStyle = style;
        return this;
    }

    @Override // androidx.core.app.NotificationCompat.Extender
    @NonNull
    public NotificationCompat.Builder extend(@NonNull NotificationCompat.Builder builder) {
        NotificationCompat.Style style;
        if (!applyStyle(builder) && (style = this.defaultStyle) != null) {
            builder.setStyle(style);
        }
        return builder;
    }

    private boolean applyStyle(NotificationCompat.Builder builder) {
        JsonMap jsonMapOptMap;
        String strOptString;
        String stylePayload = this.message.getStylePayload();
        if (stylePayload == null) {
            return false;
        }
        try {
            jsonMapOptMap = JsonValue.parseString(stylePayload).optMap();
            strOptString = jsonMapOptMap.opt("type").optString();
            strOptString.hashCode();
            switch (strOptString) {
                case "inbox":
                    applyInboxStyle(builder, jsonMapOptMap);
                    break;
                case "big_text":
                    applyBigTextStyle(builder, jsonMapOptMap);
                    break;
                case "big_picture":
                    break;
                default:
                    UALog.e("Unrecognized notification style type: %s", strOptString);
                    break;
            }
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse notification style payload.", new Object[0]);
            return false;
        }
        return false;
    }

    private boolean applyBigTextStyle(NotificationCompat.Builder builder, JsonMap jsonMap) {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        String string = jsonMap.opt("title").getString();
        String string2 = jsonMap.opt(ErrorBundle.SUMMARY_ENTRY).getString();
        String string3 = jsonMap.opt("big_text").getString();
        if (!UAStringUtil.isEmpty(string3)) {
            bigTextStyle.bigText(string3);
        }
        if (!UAStringUtil.isEmpty(string)) {
            bigTextStyle.setBigContentTitle(string);
        }
        if (!UAStringUtil.isEmpty(string2)) {
            bigTextStyle.setSummaryText(string2);
        }
        builder.setStyle(bigTextStyle);
        return true;
    }

    private boolean applyBigPictureStyle(NotificationCompat.Builder builder, JsonMap jsonMap) {
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        String string = jsonMap.opt("title").getString();
        String string2 = jsonMap.opt(ErrorBundle.SUMMARY_ENTRY).getString();
        try {
            Bitmap bitmapFetchBigImage = NotificationUtils.fetchBigImage(this.context, new URL(jsonMap.opt("big_picture").optString()));
            if (bitmapFetchBigImage == null) {
                return false;
            }
            bigPictureStyle.bigPicture(bitmapFetchBigImage);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            builder.setLargeIcon(bitmapFetchBigImage);
            if (!UAStringUtil.isEmpty(string)) {
                bigPictureStyle.setBigContentTitle(string);
            }
            if (!UAStringUtil.isEmpty(string2)) {
                bigPictureStyle.setSummaryText(string2);
            }
            builder.setStyle(bigPictureStyle);
            return true;
        } catch (MalformedURLException e) {
            UALog.e(e, "Malformed big picture URL.", new Object[0]);
            return false;
        }
    }

    private void applyInboxStyle(NotificationCompat.Builder builder, JsonMap jsonMap) {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String string = jsonMap.opt("title").getString();
        String string2 = jsonMap.opt(ErrorBundle.SUMMARY_ENTRY).getString();
        Iterator<JsonValue> it = jsonMap.opt("lines").optList().iterator();
        while (it.hasNext()) {
            String string3 = it.next().getString();
            if (!UAStringUtil.isEmpty(string3)) {
                inboxStyle.addLine(string3);
            }
        }
        if (!UAStringUtil.isEmpty(string)) {
            inboxStyle.setBigContentTitle(string);
        }
        if (!UAStringUtil.isEmpty(string2)) {
            inboxStyle.setSummaryText(string2);
        }
        builder.setStyle(inboxStyle);
    }
}
