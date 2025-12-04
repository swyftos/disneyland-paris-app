package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import com.amazonaws.services.cognitoidentityprovider.model.MFAOptionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CognitoUserSettings {
    private Map userSettings;

    public CognitoUserSettings() {
        this(null);
    }

    protected CognitoUserSettings(List<MFAOptionType> list) {
        this.userSettings = new HashMap();
        if (list != null) {
            for (MFAOptionType mFAOptionType : list) {
                this.userSettings.put(mFAOptionType.getAttributeName().toString(), mFAOptionType.getDeliveryMedium().toString());
            }
        }
    }

    protected List<MFAOptionType> getSettingsList() {
        ArrayList arrayList = new ArrayList();
        Map map = this.userSettings;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                MFAOptionType mFAOptionType = new MFAOptionType();
                mFAOptionType.setAttributeName((String) entry.getKey());
                mFAOptionType.setDeliveryMedium((String) entry.getValue());
                arrayList.add(mFAOptionType);
            }
        }
        return arrayList;
    }

    public Map<String, String> getSettings() {
        return this.userSettings;
    }

    public void setSettings(String str, String str2) {
        this.userSettings.put(str, str2);
    }
}
