package com.tagcommander.lib.serverside.events.video;

import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.ETCAdLoadType;
import com.tagcommander.lib.serverside.events.ETCAdType;
import com.tagcommander.lib.serverside.events.ETCVideoAdMode;
import com.tagcommander.lib.serverside.events.base.TCVideoEvent;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCVideoAdEvent extends TCVideoEvent {
    public String adAssetID;
    public String adPodID;
    public Integer adQuartile;
    public ETCAdType adType;
    public ETCAdLoadType loadType;
    public Integer podLength;
    public Integer podPosition;

    public TCVideoAdEvent(ETCVideoAdMode eTCVideoAdMode, String str) {
        this.name = eTCVideoAdMode.name();
        this.videoSessionID = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCVideoEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.adAssetID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_ASSET_ID, this.adAssetID);
            }
            if (testString(this.adPodID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_POD_ID, this.adPodID);
            }
            if (testString(this.adType.toString())) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_AD_TYPE, this.adType.toString());
            }
            if (testString(this.videoTitle)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_TITLE, this.videoTitle);
            }
            if (testString(this.loadType.name())) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_LOAD_TYPE, this.loadType.name());
            }
            TCUtils.setInteger(TCVideoEventPropertiesNames.TCV_POD_POSITION, this.podPosition, jsonObject);
            TCUtils.setInteger(TCVideoEventPropertiesNames.TCV_POD_LENGTH, this.podLength, jsonObject);
            TCUtils.setInteger(TCVideoEventPropertiesNames.TCV_AD_QUARTILE, this.adQuartile, jsonObject);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCPurchaseEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return (this.videoSessionID != null) & (this.adAssetID != null) & (this.adPodID != null) & (this.cursorPosition != null) & (this.totalLength != null);
    }
}
