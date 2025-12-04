package com.tagcommander.lib.serverside.events.video;

import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.ETCVideoContentMode;
import com.tagcommander.lib.serverside.events.base.TCVideoEvent;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCVideoContentEvent extends TCVideoEvent {
    public String airDate;
    public int bitrate;
    public String channel;
    public String contentAssetID;
    public String contentPodID;
    public String episode;
    public Float framerate;
    public boolean fullEpisode;
    public List<String> keywords;
    public boolean livestream;
    public String program;
    public String season;
    public String videoCategory;
    public String videoDescription;

    public TCVideoContentEvent(ETCVideoContentMode eTCVideoContentMode, String str) {
        this.name = eTCVideoContentMode.name();
        this.videoSessionID = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCVideoEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.contentPodID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CONTENT_POD_ID, this.contentPodID);
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
            if (testString(this.program)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_PROGRAM, this.program);
            }
            if (testString(this.channel)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CHANNEL, this.channel);
            }
            if (testString(this.contentAssetID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CONTENT_ASSET_ID, this.contentAssetID);
            }
            if (testString(this.videoCategory)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_CATEGORY, this.videoCategory);
            }
            if (testString(this.airDate)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AIRDATE, this.airDate);
            }
            TCUtils.setList(this.keywords, TCVideoEventPropertiesNames.TCV_KEYWORDS, jsonObject);
            TCUtils.setBool(TCVideoEventPropertiesNames.TCV_FULL_EPISODE, Boolean.valueOf(this.fullEpisode), jsonObject);
            TCUtils.setBool(TCVideoEventPropertiesNames.TCV_LIVESTREAM, Boolean.valueOf(this.livestream), jsonObject);
            TCUtils.setInteger(TCVideoEventPropertiesNames.TCV_BITRATE, Integer.valueOf(this.bitrate), jsonObject);
            TCUtils.setFloat(TCVideoEventPropertiesNames.TCV_FRAMERATE, this.framerate, jsonObject);
            TCUtils.setInteger(TCVideoEventPropertiesNames.TCV_TOTAL_LENGTH, this.totalLength, jsonObject);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCPurchaseEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return (this.videoSessionID != null) & (this.contentAssetID != null) & (this.cursorPosition != null) & (this.totalLength != null);
    }
}
