package com.tagcommander.lib.serverside.events.video;

import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.serverside.events.ETCVideoPlaybackMode;
import com.tagcommander.lib.serverside.events.base.TCVideoEvent;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCVideoPlaybackEvent extends TCVideoEvent {
    public List<String> adAssetID;
    public Boolean adEnabled;
    public List<String> adPodID;
    public String adtype;
    public Integer bitrate;
    public List<String> contentAssetID;
    public List<String> contentPodID;
    public Float framerate;
    public Boolean fullScreen;
    public String imageQuality;
    public String interruptionMethod;
    public Boolean livestream;
    public Integer seekPosition;
    public Integer sound;
    public String videoCategory;
    public String videoPlayer;

    public TCVideoPlaybackEvent(ETCVideoPlaybackMode eTCVideoPlaybackMode, String str) {
        this.name = eTCVideoPlaybackMode.name();
        this.videoSessionID = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        boolean z = (this.videoSessionID != null) & (this.contentAssetID != null);
        if (!this.name.equals(ETCVideoPlaybackMode.video_buffer_start.name()) && !this.name.equals(ETCVideoPlaybackMode.video_buffer_complete.name())) {
            z &= this.cursorPosition != null;
        }
        return z & (this.totalLength != null);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCVideoEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (this.contentAssetID.size() > 0) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CONTENT_ASSET_ID, getListAsJson(this.contentAssetID));
            }
            if (this.contentPodID.size() > 0) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CONTENT_POD_ID, getListAsJson(this.contentPodID));
            }
            if (this.adAssetID.size() > 0) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_ASSET_ID, getListAsJson(this.adAssetID));
            }
            if (this.adPodID.size() > 0) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_POD_ID, getListAsJson(this.adPodID));
            }
            if (testString(this.adtype)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_TYPE, this.adtype);
            }
            Integer num = this.seekPosition;
            if (num != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_SEEK_POSITION, num);
            }
            Integer num2 = this.bitrate;
            if (num2 != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_BITRATE, num2);
            }
            Float f = this.framerate;
            if (f != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_FRAMERATE, f);
            }
            if (testString(this.videoPlayer)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_PLAYER, this.videoPlayer);
            }
            Integer num3 = this.sound;
            if (num3 != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_SOUND, num3);
            }
            Boolean bool = this.fullScreen;
            if (bool != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_FULL_SCREEN, bool);
            }
            Boolean bool2 = this.adEnabled;
            if (bool2 != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_ENABLED, bool2);
            }
            if (testString(this.imageQuality)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_IMAGE_QUALITY, this.imageQuality);
            }
            if (testString(this.interruptionMethod)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_INTERRUPTION_METHOD, this.interruptionMethod);
            }
            if (testString(this.videoCategory)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_CATEGORY, this.videoCategory);
            }
            Boolean bool3 = this.livestream;
            if (bool3 != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_LIVESTREAM, bool3);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCVideoPlaybackEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
