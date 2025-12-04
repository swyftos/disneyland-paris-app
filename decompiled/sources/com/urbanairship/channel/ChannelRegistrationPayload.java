package com.urbanairship.channel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.facebook.react.modules.appstate.AppStateModule;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ChannelRegistrationPayload implements JsonSerializable {

    @NonNull
    public static final String AMAZON_DEVICE_TYPE = "amazon";

    @NonNull
    public static final String ANDROID_DEVICE_TYPE = "android";
    public final String accengageDeviceId;
    public final Integer apiVersion;
    public final String appVersion;
    public final boolean backgroundEnabled;
    public final String carrier;
    public final String contactId;
    public final String country;
    public final String deliveryType;
    public final String deviceModel;
    public final String deviceType;
    public final boolean isActive;
    public final String language;
    public final Boolean locationSettings;
    public final boolean optIn;
    public final Map<String, String> permissions;
    public final String pushAddress;
    public final String sdkVersion;
    public final boolean setTags;
    public final JsonMap tagChanges;
    public final Set<String> tags;
    public final String timezone;
    public final String userId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceType {
    }

    public static class Builder {
        private String accengageDeviceId;
        private Integer apiVersion;
        private String appVersion;
        private boolean backgroundEnabled;
        private String carrier;
        private String contactId;
        private String country;
        private String deliveryType;
        private String deviceModel;
        private String deviceType;
        private boolean isActive;
        private String language;
        private Boolean locationSettings;
        private boolean optIn;
        private Map permissions;
        private String pushAddress;
        private String sdkVersion;
        private boolean setTags;
        private JsonMap tagChanges;
        private Set tags;
        private String timezone;
        private String userId;

        public Builder() {
        }

        public Builder(@NonNull ChannelRegistrationPayload channelRegistrationPayload) {
            this.optIn = channelRegistrationPayload.optIn;
            this.backgroundEnabled = channelRegistrationPayload.backgroundEnabled;
            this.deviceType = channelRegistrationPayload.deviceType;
            this.pushAddress = channelRegistrationPayload.pushAddress;
            this.setTags = channelRegistrationPayload.setTags;
            this.tags = channelRegistrationPayload.tags;
            this.tagChanges = channelRegistrationPayload.tagChanges;
            this.userId = channelRegistrationPayload.userId;
            this.timezone = channelRegistrationPayload.timezone;
            this.language = channelRegistrationPayload.language;
            this.country = channelRegistrationPayload.country;
            this.locationSettings = channelRegistrationPayload.locationSettings;
            this.appVersion = channelRegistrationPayload.appVersion;
            this.sdkVersion = channelRegistrationPayload.sdkVersion;
            this.deviceModel = channelRegistrationPayload.deviceModel;
            this.apiVersion = channelRegistrationPayload.apiVersion;
            this.carrier = channelRegistrationPayload.carrier;
            this.accengageDeviceId = channelRegistrationPayload.accengageDeviceId;
            this.deliveryType = channelRegistrationPayload.deliveryType;
            this.contactId = channelRegistrationPayload.contactId;
            this.isActive = channelRegistrationPayload.isActive;
            this.permissions = channelRegistrationPayload.permissions;
        }

        @NonNull
        public Builder setOptIn(boolean z) {
            this.optIn = z;
            return this;
        }

        @NonNull
        public Builder setBackgroundEnabled(boolean z) {
            this.backgroundEnabled = z;
            return this;
        }

        @NonNull
        public Builder setDeviceType(@Nullable String str) {
            this.deviceType = str;
            return this;
        }

        @NonNull
        public Builder setContactId(@Nullable String str) {
            this.contactId = str;
            return this;
        }

        @NonNull
        public Builder setTimezone(@Nullable String str) {
            this.timezone = str;
            return this;
        }

        @NonNull
        public Builder setLanguage(@Nullable String str) {
            this.language = str;
            return this;
        }

        @NonNull
        public Builder setCountry(@Nullable String str) {
            this.country = str;
            return this;
        }

        @NonNull
        public Builder setPushAddress(@Nullable String str) {
            this.pushAddress = str;
            return this;
        }

        @NonNull
        public Builder setTags(boolean z, @Nullable Set<String> set) {
            this.setTags = z;
            this.tags = set;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setTagChanges(JsonMap jsonMap) {
            this.tagChanges = jsonMap;
            return this;
        }

        @NonNull
        public Builder setUserId(@Nullable String str) {
            if (UAStringUtil.isEmpty(str)) {
                str = null;
            }
            this.userId = str;
            return this;
        }

        @NonNull
        public Builder setLocationSettings(@Nullable Boolean bool) {
            this.locationSettings = bool;
            return this;
        }

        @NonNull
        public Builder setAppVersion(@Nullable String str) {
            this.appVersion = str;
            return this;
        }

        @NonNull
        public Builder setSdkVersion(@Nullable String str) {
            this.sdkVersion = str;
            return this;
        }

        @NonNull
        public Builder setDeviceModel(@Nullable String str) {
            this.deviceModel = str;
            return this;
        }

        @NonNull
        public Builder setApiVersion(@Nullable Integer num) {
            this.apiVersion = num;
            return this;
        }

        @NonNull
        public Builder setCarrier(@Nullable String str) {
            this.carrier = str;
            return this;
        }

        @NonNull
        public Builder setIsActive(boolean z) {
            this.isActive = z;
            return this;
        }

        @NonNull
        public Builder setPermissions(Map<String, String> map) {
            this.permissions = map;
            return this;
        }

        @NonNull
        public Builder setAccengageDeviceId(@Nullable String str) {
            this.accengageDeviceId = str;
            return this;
        }

        @NonNull
        public Builder setDeliveryType(@Nullable String str) {
            this.deliveryType = str;
            return this;
        }

        @NonNull
        public ChannelRegistrationPayload build() {
            return new ChannelRegistrationPayload(this);
        }
    }

    private ChannelRegistrationPayload(Builder builder) {
        this.optIn = builder.optIn;
        this.backgroundEnabled = builder.backgroundEnabled;
        this.deviceType = builder.deviceType;
        this.pushAddress = builder.pushAddress;
        this.setTags = builder.setTags;
        this.tags = builder.setTags ? builder.tags : null;
        this.tagChanges = builder.tagChanges;
        this.userId = builder.userId;
        this.timezone = builder.timezone;
        this.language = builder.language;
        this.country = builder.country;
        this.locationSettings = builder.locationSettings;
        this.appVersion = builder.appVersion;
        this.sdkVersion = builder.sdkVersion;
        this.deviceModel = builder.deviceModel;
        this.apiVersion = builder.apiVersion;
        this.carrier = builder.carrier;
        this.accengageDeviceId = builder.accengageDeviceId;
        this.deliveryType = builder.deliveryType;
        this.contactId = builder.contactId;
        this.isActive = builder.isActive;
        this.permissions = builder.permissions;
    }

    @NonNull
    public ChannelRegistrationPayload minimizedPayload(@Nullable ChannelRegistrationPayload channelRegistrationPayload) {
        Set<String> set;
        if (channelRegistrationPayload == null) {
            return this;
        }
        Builder builder = new Builder(this);
        builder.setUserId(null);
        builder.setAccengageDeviceId(null);
        if (channelRegistrationPayload.setTags && this.setTags && (set = channelRegistrationPayload.tags) != null) {
            if (!set.equals(this.tags)) {
                try {
                    builder.setTagChanges(getTagChanges(channelRegistrationPayload.tags));
                } catch (JsonException e) {
                    UALog.d(e, "ChannelRegistrationPayload - Failed to wrap tag changes to JsonMap", new Object[0]);
                }
            } else {
                builder.setTags(false, null);
            }
        }
        String str = this.contactId;
        if (str == null || UAStringUtil.equals(channelRegistrationPayload.contactId, str)) {
            if (UAStringUtil.equals(channelRegistrationPayload.country, this.country)) {
                builder.setCountry(null);
            }
            if (UAStringUtil.equals(channelRegistrationPayload.language, this.language)) {
                builder.setLanguage(null);
            }
            if (UAStringUtil.equals(channelRegistrationPayload.timezone, this.timezone)) {
                builder.setTimezone(null);
            }
            Boolean bool = channelRegistrationPayload.locationSettings;
            if (bool != null && bool.equals(this.locationSettings)) {
                builder.setLocationSettings(null);
            }
            if (UAStringUtil.equals(channelRegistrationPayload.appVersion, this.appVersion)) {
                builder.setAppVersion(null);
            }
            if (UAStringUtil.equals(channelRegistrationPayload.sdkVersion, this.sdkVersion)) {
                builder.setSdkVersion(null);
            }
            if (UAStringUtil.equals(channelRegistrationPayload.deviceModel, this.deviceModel)) {
                builder.setDeviceModel(null);
            }
            if (UAStringUtil.equals(channelRegistrationPayload.carrier, this.carrier)) {
                builder.setCarrier(null);
            }
            Integer num = channelRegistrationPayload.apiVersion;
            if (num != null && num.equals(this.apiVersion)) {
                builder.setApiVersion(null);
            }
        }
        Map<String, String> map = this.permissions;
        if (map != null && map != channelRegistrationPayload.permissions) {
            builder.setPermissions(map);
        }
        return builder.build();
    }

    private JsonMap getTagChanges(Set set) {
        HashSet hashSet = new HashSet();
        for (String str : this.tags) {
            if (!set.contains(str)) {
                hashSet.add(str);
            }
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!this.tags.contains(str2)) {
                hashSet2.add(str2);
            }
        }
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        if (!hashSet.isEmpty()) {
            builderNewBuilder.put("add", JsonValue.wrap(hashSet));
        }
        if (!hashSet2.isEmpty()) {
            builderNewBuilder.put(AttributeMutation.ATTRIBUTE_ACTION_REMOVE, JsonValue.wrap(hashSet2));
        }
        return builderNewBuilder.build();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        JsonMap jsonMap;
        Set<String> set;
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("device_type", this.deviceType).put("set_tags", this.setTags).put("opt_in", this.optIn).put("push_address", this.pushAddress).put(AppStateModule.APP_STATE_BACKGROUND, this.backgroundEnabled).put(TCEventPropertiesNames.TCD_TIMEZONE, this.timezone).put("locale_language", this.language).put("locale_country", this.country).put("app_version", this.appVersion).put(OneIDTrackerEvent.EVENT_PARAM_SDK_VERSION, this.sdkVersion).put("device_model", this.deviceModel).put("carrier", this.carrier).put(DeferredApiClient.KEY_CONTACT_ID, this.contactId).put("is_activity", this.isActive);
        if ("android".equals(this.deviceType) && this.deliveryType != null) {
            builderPut.put("android", JsonMap.newBuilder().put("delivery_type", this.deliveryType).build());
        }
        Boolean bool = this.locationSettings;
        if (bool != null) {
            builderPut.put("location_settings", bool.booleanValue());
        }
        Integer num = this.apiVersion;
        if (num != null) {
            builderPut.put("android_api_version", num.intValue());
        }
        if (this.setTags && (set = this.tags) != null) {
            builderPut.put(FetchDeviceInfoAction.TAGS_KEY, JsonValue.wrapOpt(set).getList());
        }
        if (this.setTags && (jsonMap = this.tagChanges) != null) {
            builderPut.put("tag_changes", JsonValue.wrapOpt(jsonMap).getMap());
        }
        if (this.permissions != null) {
            JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
            for (String str : this.permissions.keySet()) {
                builderNewBuilder.put(str, JsonValue.wrap(this.permissions.get(str)));
            }
            builderPut.put("permissions", builderNewBuilder.build());
        }
        JsonMap.Builder builderPut2 = JsonMap.newBuilder().put("user_id", this.userId).put("accengage_device_id", this.accengageDeviceId);
        JsonMap.Builder builderPut3 = JsonMap.newBuilder().put(TCVideoEventPropertiesNames.TCV_CHANNEL, builderPut.build());
        JsonMap jsonMapBuild = builderPut2.build();
        if (!jsonMapBuild.isEmpty()) {
            builderPut3.put("identity_hints", jsonMapBuild);
        }
        return builderPut3.build().toJsonValue();
    }

    public boolean equals(@Nullable ChannelRegistrationPayload channelRegistrationPayload, boolean z) {
        if (channelRegistrationPayload == null) {
            return false;
        }
        return (!z || channelRegistrationPayload.isActive == this.isActive) && this.optIn == channelRegistrationPayload.optIn && this.backgroundEnabled == channelRegistrationPayload.backgroundEnabled && this.setTags == channelRegistrationPayload.setTags && ObjectsCompat.equals(this.deviceType, channelRegistrationPayload.deviceType) && ObjectsCompat.equals(this.pushAddress, channelRegistrationPayload.pushAddress) && ObjectsCompat.equals(this.tags, channelRegistrationPayload.tags) && ObjectsCompat.equals(this.tagChanges, channelRegistrationPayload.tagChanges) && ObjectsCompat.equals(this.userId, channelRegistrationPayload.userId) && ObjectsCompat.equals(this.timezone, channelRegistrationPayload.timezone) && ObjectsCompat.equals(this.language, channelRegistrationPayload.language) && ObjectsCompat.equals(this.country, channelRegistrationPayload.country) && ObjectsCompat.equals(this.locationSettings, channelRegistrationPayload.locationSettings) && ObjectsCompat.equals(this.appVersion, channelRegistrationPayload.appVersion) && ObjectsCompat.equals(this.sdkVersion, channelRegistrationPayload.sdkVersion) && ObjectsCompat.equals(this.deviceModel, channelRegistrationPayload.deviceModel) && ObjectsCompat.equals(this.apiVersion, channelRegistrationPayload.apiVersion) && ObjectsCompat.equals(this.carrier, channelRegistrationPayload.carrier) && ObjectsCompat.equals(this.accengageDeviceId, channelRegistrationPayload.accengageDeviceId) && ObjectsCompat.equals(this.deliveryType, channelRegistrationPayload.deliveryType) && ObjectsCompat.equals(this.contactId, channelRegistrationPayload.contactId) && ObjectsCompat.equals(this.permissions, channelRegistrationPayload.permissions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((ChannelRegistrationPayload) obj, true);
    }

    public int hashCode() {
        return ObjectsCompat.hash(Boolean.valueOf(this.optIn), Boolean.valueOf(this.backgroundEnabled), this.deviceType, this.pushAddress, Boolean.valueOf(this.setTags), this.tags, this.tagChanges, this.userId, this.timezone, this.language, this.country, this.locationSettings, this.appVersion, this.sdkVersion, this.deviceModel, this.apiVersion, this.carrier, this.accengageDeviceId, this.deliveryType, this.contactId, this.permissions);
    }

    @NonNull
    public String toString() {
        return "ChannelRegistrationPayload{optIn=" + this.optIn + ", backgroundEnabled=" + this.backgroundEnabled + ", deviceType='" + this.deviceType + CoreConstants.SINGLE_QUOTE_CHAR + ", pushAddress='" + this.pushAddress + CoreConstants.SINGLE_QUOTE_CHAR + ", setTags=" + this.setTags + ", tags=" + this.tags + ", tagChanges=" + this.tagChanges + ", userId='" + this.userId + CoreConstants.SINGLE_QUOTE_CHAR + ", timezone='" + this.timezone + CoreConstants.SINGLE_QUOTE_CHAR + ", language='" + this.language + CoreConstants.SINGLE_QUOTE_CHAR + ", country='" + this.country + CoreConstants.SINGLE_QUOTE_CHAR + ", locationSettings=" + this.locationSettings + ", appVersion='" + this.appVersion + CoreConstants.SINGLE_QUOTE_CHAR + ", sdkVersion='" + this.sdkVersion + CoreConstants.SINGLE_QUOTE_CHAR + ", deviceModel='" + this.deviceModel + CoreConstants.SINGLE_QUOTE_CHAR + ", apiVersion=" + this.apiVersion + ", carrier='" + this.carrier + CoreConstants.SINGLE_QUOTE_CHAR + ", accengageDeviceId='" + this.accengageDeviceId + CoreConstants.SINGLE_QUOTE_CHAR + ", deliveryType='" + this.deliveryType + CoreConstants.SINGLE_QUOTE_CHAR + ", contactId='" + this.contactId + CoreConstants.SINGLE_QUOTE_CHAR + ", isActive=" + this.isActive + ", permissions=" + this.permissions + '}';
    }

    static ChannelRegistrationPayload fromJson(JsonValue jsonValue) throws JsonException {
        HashMap map;
        JsonMap jsonMapOptMap = jsonValue.optMap();
        JsonMap jsonMapOptMap2 = jsonMapOptMap.opt(TCVideoEventPropertiesNames.TCV_CHANNEL).optMap();
        JsonMap jsonMapOptMap3 = jsonMapOptMap.opt("identity_hints").optMap();
        if (jsonMapOptMap2.isEmpty() && jsonMapOptMap3.isEmpty()) {
            throw new JsonException("Invalid channel payload: " + jsonValue);
        }
        HashSet hashSet = new HashSet();
        Iterator<JsonValue> it = jsonMapOptMap2.opt(FetchDeviceInfoAction.TAGS_KEY).optList().iterator();
        while (it.hasNext()) {
            JsonValue next = it.next();
            if (next.isString()) {
                hashSet.add(next.getString());
            } else {
                throw new JsonException("Invalid tag: " + next);
            }
        }
        JsonMap jsonMapOptMap4 = jsonMapOptMap2.opt("tag_changes").optMap();
        Boolean boolValueOf = jsonMapOptMap2.containsKey("location_settings") ? Boolean.valueOf(jsonMapOptMap2.opt("location_settings").getBoolean(false)) : null;
        Integer numValueOf = jsonMapOptMap2.containsKey("android_api_version") ? Integer.valueOf(jsonMapOptMap2.opt("android_api_version").getInt(-1)) : null;
        String string = jsonMapOptMap2.opt("android").optMap().opt("delivery_type").getString();
        if (jsonMapOptMap2.containsKey("permissions")) {
            map = new HashMap();
            for (Map.Entry<String, JsonValue> entry : jsonMapOptMap2.opt("permissions").optMap().getMap().entrySet()) {
                map.put(entry.getKey(), entry.getValue().getString());
            }
        } else {
            map = null;
        }
        Builder tags = new Builder().setOptIn(jsonMapOptMap2.opt("opt_in").getBoolean(false)).setBackgroundEnabled(jsonMapOptMap2.opt(AppStateModule.APP_STATE_BACKGROUND).getBoolean(false)).setDeviceType(jsonMapOptMap2.opt("device_type").getString()).setPushAddress(jsonMapOptMap2.opt("push_address").getString()).setLanguage(jsonMapOptMap2.opt("locale_language").getString()).setCountry(jsonMapOptMap2.opt("locale_country").getString()).setTimezone(jsonMapOptMap2.opt(TCEventPropertiesNames.TCD_TIMEZONE).getString()).setTags(jsonMapOptMap2.opt("set_tags").getBoolean(false), hashSet);
        if (jsonMapOptMap4.isEmpty()) {
            jsonMapOptMap4 = null;
        }
        return tags.setTagChanges(jsonMapOptMap4).setUserId(jsonMapOptMap3.opt("user_id").getString()).setAccengageDeviceId(jsonMapOptMap3.opt("accengage_device_id").getString()).setLocationSettings(boolValueOf).setAppVersion(jsonMapOptMap2.opt("app_version").getString()).setSdkVersion(jsonMapOptMap2.opt(OneIDTrackerEvent.EVENT_PARAM_SDK_VERSION).getString()).setDeviceModel(jsonMapOptMap2.opt("device_model").getString()).setApiVersion(numValueOf).setCarrier(jsonMapOptMap2.opt("carrier").getString()).setDeliveryType(string).setContactId(jsonMapOptMap2.opt(DeferredApiClient.KEY_CONTACT_ID).getString()).setIsActive(jsonMapOptMap2.opt("is_activity").getBoolean(false)).setPermissions(map).build();
    }
}
