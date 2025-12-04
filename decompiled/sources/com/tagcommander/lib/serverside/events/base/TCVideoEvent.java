package com.tagcommander.lib.serverside.events.base;

import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class TCVideoEvent extends TCEvent {
    public Integer cursorPosition;
    public String publisher;
    public Integer totalLength;
    public String videoSessionID;
    public String videoTitle;

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.videoSessionID)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_SESSION_ID, this.videoSessionID);
            }
            Integer num = this.cursorPosition;
            if (num != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_CURSOR_POSITION, num);
            }
            Integer num2 = this.totalLength;
            if (num2 != null) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_TOTAL_LENGTH, num2);
            }
            if (testString(this.videoTitle)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_VIDEO_TITLE, this.videoTitle);
            }
            if (testString(this.publisher)) {
                jsonObject.put(TCVideoEventPropertiesNames.TCV_PUBLISHER, this.publisher);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCVideoEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
