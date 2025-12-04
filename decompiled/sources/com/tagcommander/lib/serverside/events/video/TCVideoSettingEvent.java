package com.tagcommander.lib.serverside.events.video;

import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.ETCVideoSettingMode;
import com.tagcommander.lib.serverside.events.base.TCVideoEvent;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCVideoSettingEvent extends TCVideoEvent {
    public String adAssetID;
    public Boolean adEnabled;
    public String adPodID;
    public String adType;
    public String airdate;
    public Integer bitrate;
    public String channel;
    public String contentAssetID;
    public String contentPodID;
    public String episode;
    public Float framerate;
    public Boolean fullEpisode;
    public Boolean fullScreen;
    public String imageQuality;
    public List<String> keywords;
    public Boolean livestream;
    public String program;
    public String season;
    public Integer sound;
    public String videoCategory;
    public String videoDescription;

    public TCVideoSettingEvent(ETCVideoSettingMode eTCVideoSettingMode, String str) {
        this.name = eTCVideoSettingMode.name();
        this.videoSessionID = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCVideoEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.contentPodID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CONTENT_POD_ID, this.contentPodID);
            }
            if (testString(this.contentAssetID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CONTENT_ASSET_ID, this.contentAssetID);
            }
            if (testString(this.adAssetID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_ASSET_ID, this.adAssetID);
            }
            if (testString(this.adPodID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_POD_ID, this.adPodID);
            }
            if (testString(this.adType)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_TYPE, this.adType);
            }
            if (testString(this.videoDescription)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_DESCRIPTION, this.videoDescription);
            }
            if (testString(this.season)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_SEASON, this.season);
            }
            if (testString(this.episode)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_EPISODE, this.episode);
            }
            if (testString(this.videoCategory)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_CATEGORY, this.videoCategory);
            }
            if (testString(this.program)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_PROGRAM, this.program);
            }
            if (testString(this.channel)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CHANNEL, this.channel);
            }
            if (testString(this.airdate)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AIRDATE, this.airdate);
            }
            if (testString(this.imageQuality)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_IMAGE_QUALITY, this.imageQuality);
            }
            TCUtils.setList(this.keywords, TCVideoEventPropertiesNames.TCV_KEYWORDS, jsonObject);
            TCUtils.setBool(TCVideoEventPropertiesNames.TCV_FULL_EPISODE, this.fullEpisode, jsonObject);
            TCUtils.setBool(TCVideoEventPropertiesNames.TCV_LIVESTREAM, this.livestream, jsonObject);
            TCUtils.setBool(TCVideoEventPropertiesNames.TCV_FULL_SCREEN, this.fullScreen, jsonObject);
            TCUtils.setBool(TCVideoEventPropertiesNames.TCV_AD_ENABLED, this.adEnabled, jsonObject);
            TCUtils.setInteger(TCVideoEventPropertiesNames.TCV_BITRATE, this.bitrate, jsonObject);
            TCUtils.setInteger(TCVideoEventPropertiesNames.TCV_SOUND, this.sound, jsonObject);
            TCUtils.setFloat(TCVideoEventPropertiesNames.TCV_FRAMERATE, this.framerate, jsonObject);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCPurchaseEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        boolean z = (this.videoSessionID != null) & (this.contentAssetID != null) & (this.cursorPosition != null) & (this.bitrate != null);
        if (this.name.equals(ETCVideoSettingMode.video_volume.name())) {
            z &= this.sound != null;
        }
        if (this.name.equals(ETCVideoSettingMode.video_fullscreen_on.name()) || this.name.equals(ETCVideoSettingMode.video_fullscreen_off.name())) {
            z &= this.fullScreen != null;
        }
        if (this.name.equals(ETCVideoSettingMode.video_quality.name())) {
            return z & (this.imageQuality != null);
        }
        return z;
    }
}
