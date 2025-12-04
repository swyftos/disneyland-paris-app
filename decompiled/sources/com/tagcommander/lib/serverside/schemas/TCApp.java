package com.tagcommander.lib.serverside.schemas;

import com.tagcommander.lib.core.CoreGenerated;
import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCCoreConstants;
import com.tagcommander.lib.core.TCCoreVariables;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.ServerSideGenerated;
import com.tagcommander.lib.serverside.TCPredefinedVariables;
import com.tagcommander.lib.serverside.TCServerSideConstants;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCApp extends TCAdditionalProperties {
    private static volatile TCApp INSTANCE;
    public String build;
    public String consentVersion;
    public String coreVersion;
    public String name;
    public String nameSpace;
    public String serverSideVersion;
    public String version;

    private TCApp() {
        TCPredefinedVariables tCPredefinedVariables = TCPredefinedVariables.getInstance();
        this.name = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ApplicationName);
        this.version = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ApplicationVersion);
        this.build = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ApplicationBuild);
        this.nameSpace = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_BundleID);
        this.coreVersion = CoreGenerated.kTCCoreVersion;
        this.serverSideVersion = ServerSideGenerated.kTCServerSideVersion;
        this.consentVersion = "";
    }

    public static TCApp getInstance() {
        if (INSTANCE == null) {
            synchronized (TCApp.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCApp();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        this.consentVersion = TCCoreVariables.getInstance().getData(TCCoreConstants.TC_ConsentVersion);
        try {
            TCUtils.setString("name", this.name, jSONObject);
            TCUtils.setString("version", this.version, jSONObject);
            TCUtils.setString("build", this.build, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCA_NAMESPACE, this.nameSpace, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCA_COREVERSION, this.coreVersion, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCA_SERVERSIDEVERSION, this.serverSideVersion, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCA_CONSENTVERSION, this.consentVersion, jSONObject);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCApp: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jSONObject;
    }
}
