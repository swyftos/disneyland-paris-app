package com.urbanairship.push;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import androidx.media3.exoplayer.offline.DownloadService;
import com.urbanairship.R;
import com.urbanairship.UALog;
import com.urbanairship.push.notifications.NotificationActionButton;
import com.urbanairship.push.notifications.NotificationActionButtonGroup;
import com.urbanairship.util.UAStringUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
abstract class ActionButtonGroupsParser {
    public static Map fromXml(Context context, int i) {
        try {
            return parseGroups(context, context.getResources().getXml(i));
        } catch (Resources.NotFoundException | IOException | NullPointerException | XmlPullParserException e) {
            UALog.e(e, "Failed to parse NotificationActionButtonGroups.", new Object[0]);
            return new HashMap();
        }
    }

    private static Map parseGroups(Context context, XmlResourceParser xmlResourceParser) throws XmlPullParserException {
        HashMap map = new HashMap();
        String str = null;
        NotificationActionButtonGroup.Builder builderNewBuilder = null;
        while (xmlResourceParser.next() != 1) {
            int eventType = xmlResourceParser.getEventType();
            String name = xmlResourceParser.getName();
            if (eventType == 2 && "UrbanAirshipActionButtonGroup".equals(name)) {
                String attributeValue = xmlResourceParser.getAttributeValue(null, "id");
                if (UAStringUtil.isEmpty(attributeValue)) {
                    UALog.e("%s missing id.", "UrbanAirshipActionButtonGroup");
                } else {
                    builderNewBuilder = NotificationActionButtonGroup.newBuilder();
                    str = attributeValue;
                }
            } else if (!UAStringUtil.isEmpty(str)) {
                if (eventType == 2 && "UrbanAirshipActionButton".equals(name)) {
                    String attributeValue2 = xmlResourceParser.getAttributeValue(null, "id");
                    if (UAStringUtil.isEmpty(attributeValue2)) {
                        UALog.e("%s missing id.", "UrbanAirshipActionButton");
                    } else {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.UrbanAirshipActionButton);
                        NotificationActionButton.Builder description = NotificationActionButton.newBuilder(attributeValue2).setPerformsInForeground(xmlResourceParser.getAttributeBooleanValue(null, DownloadService.KEY_FOREGROUND, true)).setIcon(typedArrayObtainStyledAttributes.getResourceId(R.styleable.UrbanAirshipActionButton_android_icon, 0)).setDescription(xmlResourceParser.getAttributeValue(null, "description"));
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.UrbanAirshipActionButton_android_label, 0);
                        if (resourceId != 0) {
                            description.setLabel(resourceId);
                        } else {
                            description.setLabel(typedArrayObtainStyledAttributes.getString(R.styleable.UrbanAirshipActionButton_android_label));
                        }
                        builderNewBuilder.addNotificationActionButton(description.build());
                        typedArrayObtainStyledAttributes.recycle();
                    }
                } else if (eventType == 3 && "UrbanAirshipActionButtonGroup".equals(name)) {
                    NotificationActionButtonGroup notificationActionButtonGroupBuild = builderNewBuilder.build();
                    if (notificationActionButtonGroupBuild.getNotificationActionButtons().isEmpty()) {
                        UALog.e("%s %s missing action buttons.", "UrbanAirshipActionButtonGroup", str);
                    } else {
                        map.put(str, notificationActionButtonGroupBuild);
                    }
                }
            }
        }
        return map;
    }
}
