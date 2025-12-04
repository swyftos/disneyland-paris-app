package com.urbanairship.android.layout.reporting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.json.JsonMap;
import com.urbanairship.util.UAStringUtil;

/* loaded from: classes5.dex */
public class AttributeName {
    private final String channel;
    private final String contact;

    public AttributeName(@Nullable String str, @Nullable String str2) {
        this.channel = str;
        this.contact = str2;
    }

    @Nullable
    public static AttributeName fromJson(@NonNull JsonMap jsonMap) {
        String string = jsonMap.opt(TCVideoEventPropertiesNames.TCV_CHANNEL).getString();
        String string2 = jsonMap.opt("contact").getString();
        if (string == null && string2 == null) {
            return null;
        }
        return new AttributeName(string, string2);
    }

    @Nullable
    public static AttributeName attributeNameFromJson(@NonNull JsonMap jsonMap) {
        return fromJson(jsonMap.opt("attribute_name").optMap());
    }

    @Nullable
    public String getChannel() {
        return this.channel;
    }

    @Nullable
    public String getContact() {
        return this.contact;
    }

    public boolean isChannel() {
        return !UAStringUtil.isEmpty(this.channel);
    }

    public boolean isContact() {
        return !UAStringUtil.isEmpty(this.contact);
    }

    @NonNull
    public String toString() {
        return "AttributeName{channel='" + this.channel + CoreConstants.SINGLE_QUOTE_CHAR + ", contact='" + this.contact + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AttributeName attributeName = (AttributeName) obj;
        return ObjectsCompat.equals(this.channel, attributeName.channel) && ObjectsCompat.equals(this.contact, attributeName.contact);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.channel, this.contact);
    }
}
