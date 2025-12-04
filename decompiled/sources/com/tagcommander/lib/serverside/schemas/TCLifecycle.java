package com.tagcommander.lib.serverside.schemas;

import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.TCPredefinedVariables;
import com.tagcommander.lib.serverside.TCServerSideConstants;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCLifecycle extends TCAdditionalProperties {
    private static volatile TCLifecycle INSTANCE;
    String backgroundTime;
    String currentSession;
    String currentVersionFirstVisit;
    String currentVisit;
    Boolean firstExecute;
    String firstVisit;
    String foregroundTime;
    String foregroundTransitions;
    Boolean isFirstVisit;
    Boolean isNewSession;
    String lastCall;
    String lastSessionLastHit;
    String lastSessionStart;
    String lastVisit;
    String sessionDuration;
    String sessionID;
    String sessionNumber;
    String visitNumber;

    private TCLifecycle() {
    }

    public static TCLifecycle getInstance() {
        if (INSTANCE == null) {
            synchronized (TCLifecycle.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCLifecycle();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    private void refreshContent() {
        TCPredefinedVariables tCPredefinedVariables = TCPredefinedVariables.getInstance();
        this.sessionID = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_SessionID);
        this.isNewSession = Boolean.valueOf(tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_IsNewSession).equals("1"));
        this.sessionDuration = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_SessionDurationMs);
        this.currentSession = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_CurrentSessionMs);
        this.visitNumber = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_NumberVisit);
        this.currentVisit = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_CurrentVisitMs);
        this.currentVersionFirstVisit = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs);
        this.sessionNumber = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_NumberSession);
        this.firstVisit = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_FirstVisitMs);
        this.lastVisit = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_LastVisitMs);
        this.lastCall = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_LastCallMs);
        this.lastSessionStart = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_LastSessionStartMs);
        this.lastSessionLastHit = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_LastSessionLastHitMs);
        this.foregroundTransitions = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ForegroundTransitions);
        this.foregroundTime = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ForegroundTime);
        this.backgroundTime = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_BackgroundTime);
        boolean z = false;
        this.firstExecute = Boolean.valueOf(tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_FirstExecute) != null && tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_FirstExecute).equals("TRUE"));
        if (tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_IsFirstVisit) != null && tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_IsFirstVisit).equals("TRUE")) {
            z = true;
        }
        this.isFirstVisit = Boolean.valueOf(z);
    }

    public JSONObject getJsonObject() {
        refreshContent();
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setString(TCEventPropertiesNames.TCL_SESSION_ID, this.sessionID, jSONObject);
            TCUtils.setBool(TCEventPropertiesNames.TCL_NEW_SESSION, this.isNewSession, jSONObject);
            TCUtils.setBool(TCEventPropertiesNames.TCL_FIRST_EXECUTE, this.firstExecute, jSONObject);
            TCUtils.setBool(TCEventPropertiesNames.TCL_IS_FIRST_VISIT, this.isFirstVisit, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_SESSION_DURATION, this.sessionDuration, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_CURRENT_SESSION, this.currentSession, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_CURRENT_VISIT, this.currentVisit, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_CUR_VER_FIRST_VISIT, this.currentVersionFirstVisit, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_FIRST_VISIT, this.firstVisit, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_LAST_VISIT, this.lastVisit, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_LAST_CALL, this.lastCall, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_LAST_SESSION_START, this.lastSessionStart, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_LAST_SESSION_LAST_HIT, this.lastSessionLastHit, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_FOREGROUND_TIME, this.foregroundTime, jSONObject);
            TCUtils.setBigDecimalFromString(TCEventPropertiesNames.TCL_BACKGROUND_TIME, this.backgroundTime, jSONObject);
            TCUtils.setIntFromString(TCEventPropertiesNames.TCL_FOREGROUND_TRANSITIONS, this.foregroundTransitions, jSONObject);
            TCUtils.setIntFromString(TCEventPropertiesNames.TCL_SESSION_NUMBER, this.sessionNumber, jSONObject);
            TCUtils.setIntFromString(TCEventPropertiesNames.TCL_VISIT_NUMBER, this.visitNumber, jSONObject);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCLifecycle: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jSONObject;
    }
}
