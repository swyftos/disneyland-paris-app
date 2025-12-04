package com.tagcommander.lib.serverside;

import com.tagcommander.lib.core.ETCConsentState;
import com.tagcommander.lib.core.TCCoreConstants;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUser;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import com.tagcommander.lib.serverside.schemas.TCApp;
import com.tagcommander.lib.serverside.schemas.TCDevice;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCPostData {
    public static String getPostParameters(TCEvent tCEvent, ETCConsentState eTCConsentState) throws JSONException {
        JSONObject jsonObject = tCEvent.getJsonObject();
        try {
            JSONObject jSONObject = jsonObject.getJSONObject("context");
            if (eTCConsentState == ETCConsentState.WAITING_FOR_CONSENT) {
                jsonObject.put(TCEventPropertiesNames.TCE_USER, TCCoreConstants.TC_WAITING_FOR_CONSENT);
            } else {
                jsonObject.put(TCEventPropertiesNames.TCE_USER, TCUser.getInstance().getJsonObject());
            }
            jSONObject.put("device", TCDevice.getInstance().getJsonObject());
            jSONObject.put(TCEventPropertiesNames.TCA_APP, TCApp.getInstance().getJsonObject());
            jSONObject.put(TCEventPropertiesNames.TC_EVENTTIMESTAMP, TCUtils.stringToPreciseDouble(TCPredefinedVariables.getInstance().getData(TCServerSideConstants.kTCPredefinedVariable_CurrentCallMs)));
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("Error forming post parameters: " + e.getMessage(), 6);
        }
        return jsonObject.toString();
    }
}
