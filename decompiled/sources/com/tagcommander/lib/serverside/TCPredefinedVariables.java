package com.tagcommander.lib.serverside;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.view.WindowManager;
import com.tagcommander.lib.core.ITCDynamicStore;
import com.tagcommander.lib.core.TCCoreVariables;
import com.tagcommander.lib.core.TCDynamicStore;
import com.tagcommander.lib.core.TCEventManager;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCSharedPreferences;
import com.tagcommander.lib.core.TCUser;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes4.dex */
public class TCPredefinedVariables implements ITCDynamicStore, TCEventManager.TCLifecycleListener {
    private static volatile TCPredefinedVariables INSTANCE;
    Context appContext;
    public long deltaBackground;
    public long deltaForeground;
    PackageInfo info;
    public long lastTime;
    TCLifeCycleCallbacks lifecycle;
    PackageManager manager;
    public long totalBackgroundTime;
    public long totalForegroundTime;
    public int visitDuration;
    public long startUsage = 0;
    public final TCDynamicStore dynamicStore = new TCDynamicStore();
    int totalForegroundTransitions = 1;

    private TCPredefinedVariables() {
        addData(TCServerSideConstants.kTCPredefinedVariable_ForegroundTransitions, String.valueOf(1));
        this.visitDuration = 1800000;
        this.totalForegroundTime = 0L;
        this.deltaForeground = 0L;
        this.totalBackgroundTime = 0L;
        this.deltaBackground = 0L;
        this.lastTime = 0L;
        addData(TCServerSideConstants.kTCPredefinedVariable_BackgroundTime, "0");
        addData(TCServerSideConstants.kTCPredefinedVariable_DeltaBackgroundTime, "0");
        addData(TCServerSideConstants.kTCPredefinedVariable_ApplicationPreviousVersion, "0");
    }

    public void setContext(Context context) throws NumberFormatException {
        if (this.appContext == null) {
            this.appContext = context.getApplicationContext();
            this.lifecycle = new TCLifeCycleCallbacks(this.appContext);
            this.manager = this.appContext.getPackageManager();
            TCEventManager.getInstance().registerLifecycleListener(this);
            try {
                this.info = this.manager.getPackageInfo(this.appContext.getPackageName(), 0);
            } catch (Exception unused) {
                TCLogger.getInstance().logMessage("Error in getting PackageInfo", 6);
            }
            this.lastTime = getNowMs();
            TCCoreVariables.getInstance().setContext(this.appContext);
            initializeAllPredefinedVariables();
            addData(TCCoreVariables.getInstance().dynStore);
        }
    }

    public static TCPredefinedVariables getInstance() {
        if (INSTANCE == null) {
            synchronized (TCPredefinedVariables.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCPredefinedVariables();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public void initializeAllPredefinedVariables() throws NumberFormatException {
        String nowMsString = getNowMsString();
        initIsFirstVisit();
        initLastCallLastVisit();
        initLanguage();
        initCurrencyCode();
        initCurrencySymbol();
        initLocalModel();
        initLocalSysName();
        initDevice();
        initLocalSysVersion();
        initLocalUniqueID();
        initScreenResolution();
        initLocalCharSet();
        initManufacturer();
        initTagCommanderVersion();
        initApplicationBuild();
        initApplicationVersion(nowMsString);
        initColdStartNumber();
        setTimestamps(nowMsString);
        initComScoreSession(nowMsString);
        getBackReferrer();
        initBundleIdentifier();
        initApplicationRuntimeName();
        initIsJailBroken();
        initApplicationName();
    }

    private void initIsFirstVisit() {
        if (TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, this.appContext).isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_IsFirstVisit, "TRUE");
        } else {
            addData(TCServerSideConstants.kTCPredefinedVariable_IsFirstVisit, "FALSE");
        }
    }

    public void firstExecute() {
        if (getData(TCServerSideConstants.kTCPredefinedVariable_FirstExecute) == null) {
            addData(TCServerSideConstants.kTCPredefinedVariable_FirstExecute, "TRUE");
        } else {
            addData(TCServerSideConstants.kTCPredefinedVariable_FirstExecute, "FALSE");
        }
    }

    private void getBackReferrer() {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences("loggingReferrer", this.appContext);
        if (strRetrieveInfoFromSharedPreferences == null || strRetrieveInfoFromSharedPreferences.isEmpty()) {
            return;
        }
        TCReferrerReceiver.cutReferrer(strRetrieveInfoFromSharedPreferences);
    }

    private void initLastCallLastVisit() {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_LastCallMs, this.appContext);
        if (strRetrieveInfoFromSharedPreferences == null || strRetrieveInfoFromSharedPreferences.isEmpty()) {
            return;
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_LastSessionLastHitMs, strRetrieveInfoFromSharedPreferences);
    }

    private void initNavTimestampCalls(long j) {
        String strValueOf = String.valueOf(j);
        if (getData(TCServerSideConstants.kTCPredefinedVariable_LastCallMs) == null) {
            if (!TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_LastCallMs, this.appContext).isEmpty()) {
                addData(TCServerSideConstants.kTCPredefinedVariable_LastCallMs, TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_LastCallMs, this.appContext));
            } else {
                addData(TCServerSideConstants.kTCPredefinedVariable_LastCallMs, strValueOf);
            }
        } else {
            addData(TCServerSideConstants.kTCPredefinedVariable_LastCallMs, getData(TCServerSideConstants.kTCPredefinedVariable_CurrentCallMs));
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_CurrentCallMs, strValueOf);
        TCSharedPreferences.saveInfoToSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_LastCallMs, strValueOf, this.appContext);
    }

    private void initLanguage() {
        try {
            Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            addData(TCServerSideConstants.kTCPredefinedVariable_Language, locale.getLanguage());
            addData(TCServerSideConstants.kTCPredefinedVariable_Region, locale.getCountry());
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("Unable to getData Locale: " + e.getMessage(), 3);
            addData(TCServerSideConstants.kTCPredefinedVariable_Language, "");
            addData(TCServerSideConstants.kTCPredefinedVariable_Region, "");
        }
    }

    private void initCurrencyCode() {
        try {
            addData(TCServerSideConstants.kTCPredefinedVariable_CurrencyCode, Currency.getInstance(Locale.getDefault()).getCurrencyCode());
        } catch (Exception e) {
            addData(TCServerSideConstants.kTCPredefinedVariable_CurrencyCode, "-");
            TCLogger.getInstance().logMessage("Unable to getData currency code: " + e.getMessage(), 3);
        }
    }

    private void initCurrencySymbol() {
        try {
            addData(TCServerSideConstants.kTCPredefinedVariable_CurrencySymbol, Currency.getInstance(Locale.getDefault()).getSymbol());
        } catch (Exception e) {
            addData(TCServerSideConstants.kTCPredefinedVariable_CurrencySymbol, "-");
            TCLogger.getInstance().logMessage("Unable to getData currency symbol: " + e.getMessage(), 6);
        }
    }

    private void initLocalModel() {
        String str = Build.MODEL;
        addData(TCServerSideConstants.kTCPredefinedVariable_Model, str);
        addData(TCServerSideConstants.kTCPredefinedVariable_ModelAndVersion, str);
    }

    private void initLocalSysName() {
        addData(TCServerSideConstants.kTCPredefinedVariable_SystemName, "android-" + Build.VERSION.RELEASE);
    }

    private void initDevice() {
        addData(TCServerSideConstants.kTCPredefinedVariable_Device, Build.DEVICE);
    }

    private void initLocalSysVersion() {
        addData(TCServerSideConstants.kTCPredefinedVariable_SystemVersion, Build.VERSION.RELEASE);
    }

    public void useLegacyUniqueIDForAnonymousID() {
        TCUser.getInstance().anonymous_id = getUniqueIdentifier();
    }

    public void useLegacyUniqueIDForConsentID() {
        TCUser.getInstance().consentID = getUniqueIdentifier();
    }

    private void initLocalUniqueID() {
        try {
            addData(TCServerSideConstants.kTCPredefinedVariable_UniqueID, Settings.Secure.getString(this.appContext.getContentResolver(), "android_id").replaceAll(" ", ""));
        } catch (Exception e) {
            addData(TCServerSideConstants.kTCPredefinedVariable_UniqueID, "-");
            TCLogger.getInstance().logMessage("Unable to getData client id: " + e.getMessage(), 3);
        }
    }

    private void initScreenResolution() {
        int i;
        int i2;
        try {
            WindowManager windowManager = (WindowManager) this.appContext.getSystemService("window");
            if (windowManager != null) {
                Point point = new Point();
                windowManager.getDefaultDisplay().getSize(point);
                i = point.x;
                i2 = point.y;
            } else {
                i = 0;
                i2 = 0;
            }
            addData(TCServerSideConstants.kTCPredefinedVariable_ScreenWidth, "" + i);
            addData(TCServerSideConstants.kTCPredefinedVariable_ScreenHeight, "" + i2);
            addData(TCServerSideConstants.kTCPredefinedVariable_ScreenDensity, "" + this.appContext.getResources().getDisplayMetrics().density);
            addData(TCServerSideConstants.kTCPredefinedVariable_ScreenResolution, i + "x" + i2);
        } catch (Exception e) {
            addData(TCServerSideConstants.kTCPredefinedVariable_ScreenResolution, "-");
            TCLogger.getInstance().logMessage("Unable to getData client display: " + e.getMessage(), 3);
        }
    }

    private void initLocalCharSet() {
        try {
            addData(TCServerSideConstants.kTCPredefinedVariable_Charset, Charset.defaultCharset().name());
        } catch (Exception e) {
            addData(TCServerSideConstants.kTCPredefinedVariable_Charset, "-");
            TCLogger.getInstance().logMessage("Unable to getData default charset: " + e.getMessage(), 3);
        }
    }

    private void initManufacturer() {
        addData(TCServerSideConstants.kTCPredefinedVariable_Manufacturer, Build.MANUFACTURER);
    }

    private void initTagCommanderVersion() {
        addData(TCServerSideConstants.kTCPredefinedVariable_TagCommanderVersion, ServerSideGenerated.kTCServerSideVersion);
    }

    private void initApplicationBuild() {
        if (this.info != null) {
            addData(TCServerSideConstants.kTCPredefinedVariable_ApplicationBuild, "" + this.info.versionCode);
        }
    }

    private void initApplicationVersion(String str) {
        String str2 = this.info.versionName;
        if (str2 == null) {
            addData(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, "0");
            str2 = "";
        }
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, this.appContext);
        if (!strRetrieveInfoFromSharedPreferences.isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, strRetrieveInfoFromSharedPreferences);
        }
        if (!str2.isEmpty()) {
            String strRetrieveInfoFromSharedPreferences2 = TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_ApplicationVersion, this.appContext);
            if (strRetrieveInfoFromSharedPreferences2.isEmpty()) {
                addData(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, str);
                TCSharedPreferences.saveInfoToSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, str, this.appContext);
            }
            if (!strRetrieveInfoFromSharedPreferences2.isEmpty() && !strRetrieveInfoFromSharedPreferences2.equals(str2)) {
                TCSharedPreferences.saveInfoToSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_ApplicationPreviousVersion, strRetrieveInfoFromSharedPreferences2, this.appContext);
                addData(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, str);
                TCSharedPreferences.saveInfoToSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_CurVersionFirstVisitMs, str, this.appContext);
            }
            TCSharedPreferences.saveInfoToSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_ApplicationVersion, str2, this.appContext);
        }
        String strRetrieveInfoFromSharedPreferences3 = TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_ApplicationPreviousVersion, this.appContext);
        if (!strRetrieveInfoFromSharedPreferences3.isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_ApplicationPreviousVersion, strRetrieveInfoFromSharedPreferences3);
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_ApplicationVersion, str2);
    }

    private void initColdStartNumber() {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_ColdStarts, this.appContext);
        int i = strRetrieveInfoFromSharedPreferences.isEmpty() ? 1 : 1 + Integer.parseInt(strRetrieveInfoFromSharedPreferences);
        addData(TCServerSideConstants.kTCPredefinedVariable_ColdStarts, String.valueOf(i));
        TCSharedPreferences.saveInfoToSharedPreferences(TCServerSideConstants.kTCPredefinedVariable_ColdStarts, String.valueOf(i), this.appContext);
    }

    private void initApplicationName() {
        String packageName = this.appContext.getPackageName();
        PackageManager packageManager = this.appContext.getPackageManager();
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0));
            if (applicationLabel != null) {
                addData(TCServerSideConstants.kTCPredefinedVariable_ApplicationName, applicationLabel.toString());
            }
        } catch (PackageManager.NameNotFoundException unused) {
            addData(TCServerSideConstants.kTCPredefinedVariable_ApplicationName, "(unknown)");
        }
    }

    private void initIsJailBroken() {
        addData(TCServerSideConstants.kTCPredefinedVariable_JailBroken, "0");
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            addData(TCServerSideConstants.kTCPredefinedVariable_JailBroken, "1");
        }
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                addData(TCServerSideConstants.kTCPredefinedVariable_JailBroken, "1");
            }
        } catch (Exception unused) {
            TCLogger.getInstance().logMessage("Error defining if the phone is JailBroken", 6);
        }
    }

    private void initBundleIdentifier() {
        addData(TCServerSideConstants.kTCPredefinedVariable_BundleID, this.appContext.getPackageName());
    }

    private void setTimestamps(String str) {
        String propertyFromSharedPreferences = getPropertyFromSharedPreferences("tc_date_first_visit");
        String strValueOf = String.valueOf(Process.myPid());
        if (propertyFromSharedPreferences.isEmpty()) {
            setFirstVisitUserDefaults(str, strValueOf);
            return;
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_FirstVisitMs, propertyFromSharedPreferences);
        if (!getPropertyFromSharedPreferences("tc_last_pid").equals(strValueOf)) {
            newVisitUserDefaults(str, propertyFromSharedPreferences, strValueOf);
        } else {
            updateVisitUserDefaults();
        }
    }

    private void updateVisitUserDefaults() {
        String propertyFromSharedPreferences = getPropertyFromSharedPreferences("tc_date_last_visit");
        String propertyFromSharedPreferences2 = getPropertyFromSharedPreferences("tc_date_current_visit");
        String propertyFromSharedPreferences3 = getPropertyFromSharedPreferences("tc_number_coldStarts");
        String propertyFromSharedPreferences4 = getPropertyFromSharedPreferences("tc_number_visits");
        if (!propertyFromSharedPreferences.isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_LastVisitMs, propertyFromSharedPreferences);
        }
        if (!propertyFromSharedPreferences2.isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_CurrentVisitMs, propertyFromSharedPreferences2);
            addData(TCServerSideConstants.kTCPredefinedVariable_CurrentSessionMs, propertyFromSharedPreferences2);
        }
        if (!propertyFromSharedPreferences3.isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_NumberVisit, propertyFromSharedPreferences3);
        }
        if (propertyFromSharedPreferences4.isEmpty()) {
            return;
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_NumberSession, propertyFromSharedPreferences4);
    }

    private void updateVariablesForNewSession() {
        addData(TCServerSideConstants.kTCPredefinedVariable_LastSessionLastHitMs, getData(TCServerSideConstants.kTCPredefinedVariable_CurrentCallMs));
        String propertyFromSharedPreferences = getPropertyFromSharedPreferences("tc_number_visits");
        if (propertyFromSharedPreferences == null || propertyFromSharedPreferences.isEmpty()) {
            setFirstVisitUserDefaults(getNowMsString(), String.valueOf(Process.myPid()));
            propertyFromSharedPreferences = "1";
        }
        String str = (Integer.parseInt(propertyFromSharedPreferences) + 1) + "";
        addData(TCServerSideConstants.kTCPredefinedVariable_NumberSession, str);
        savePropertyIntoShredPreferences("tc_number_visits", str);
        addData(TCServerSideConstants.kTCPredefinedVariable_CurrentSessionMs, getNowMsString());
        savePropertyIntoShredPreferences("tc_date_current_visit", getData(TCServerSideConstants.kTCPredefinedVariable_CurrentSessionMs));
        addData(TCServerSideConstants.kTCPredefinedVariable_SessionID, UUID.randomUUID().toString());
        addData(TCServerSideConstants.kTCPredefinedVariable_IsNewSession, "1");
    }

    void resetNewSession() {
        addData(TCServerSideConstants.kTCPredefinedVariable_IsNewSession, "0");
    }

    private void newVisitUserDefaults(String str, String str2, String str3) {
        String propertyFromSharedPreferences = getPropertyFromSharedPreferences("tc_date_last_visit");
        String propertyFromSharedPreferences2 = getPropertyFromSharedPreferences("tc_date_current_visit");
        savePropertyIntoShredPreferences("tc_last_pid", str3);
        if (propertyFromSharedPreferences2.isEmpty()) {
            propertyFromSharedPreferences2 = str2;
        }
        if (propertyFromSharedPreferences.isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_LastVisitMs, str2);
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_LastVisitMs, propertyFromSharedPreferences2);
        savePropertyIntoShredPreferences("tc_date_last_visit", propertyFromSharedPreferences2);
        addData(TCServerSideConstants.kTCPredefinedVariable_CurrentVisitMs, str);
        addData(TCServerSideConstants.kTCPredefinedVariable_CurrentSessionMs, str);
        savePropertyIntoShredPreferences("tc_date_current_visit", str);
        String propertyFromSharedPreferences3 = getPropertyFromSharedPreferences("tc_number_coldStarts");
        if (propertyFromSharedPreferences3.isEmpty()) {
            propertyFromSharedPreferences3 = "0";
        }
        String str4 = (Integer.parseInt(propertyFromSharedPreferences3) + 1) + "";
        addData(TCServerSideConstants.kTCPredefinedVariable_NumberVisit, str4);
        savePropertyIntoShredPreferences("tc_number_coldStarts", str4);
        String propertyFromSharedPreferences4 = getPropertyFromSharedPreferences("tc_number_visits");
        String str5 = (Integer.parseInt(propertyFromSharedPreferences4.isEmpty() ? "0" : propertyFromSharedPreferences4) + 1) + "";
        addData(TCServerSideConstants.kTCPredefinedVariable_NumberSession, str5);
        savePropertyIntoShredPreferences("tc_number_visits", str5);
    }

    private void setFirstVisitUserDefaults(String str, String str2) {
        addData(TCServerSideConstants.kTCPredefinedVariable_FirstVisitMs, str);
        addData(TCServerSideConstants.kTCPredefinedVariable_LastVisitMs, str);
        addData(TCServerSideConstants.kTCPredefinedVariable_CurrentVisitMs, str);
        addData(TCServerSideConstants.kTCPredefinedVariable_CurrentSessionMs, str);
        addData(TCServerSideConstants.kTCPredefinedVariable_NumberVisit, "1");
        addData(TCServerSideConstants.kTCPredefinedVariable_NumberSession, "1");
        savePropertyIntoShredPreferences("tc_date_first_visit", str);
        savePropertyIntoShredPreferences("tc_date_last_visit", str);
        savePropertyIntoShredPreferences("tc_date_current_visit", str);
        savePropertyIntoShredPreferences("tc_number_coldStarts", "1");
        savePropertyIntoShredPreferences("tc_number_visits", "1");
        savePropertyIntoShredPreferences("tc_last_pid", str2);
    }

    private void computeDeltaSinceLastLaunch(String str) {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences("ExitTimestamp", this.appContext);
        String strRetrieveInfoFromSharedPreferences2 = TCSharedPreferences.retrieveInfoFromSharedPreferences("LastBackgroundTime", this.appContext);
        String strRetrieveInfoFromSharedPreferences3 = TCSharedPreferences.retrieveInfoFromSharedPreferences("TimeSinceLastMeasurement", this.appContext);
        String strRetrieveInfoFromSharedPreferences4 = TCSharedPreferences.retrieveInfoFromSharedPreferences("LastForegroundTime", this.appContext);
        addData(TCServerSideConstants.kTCPredefinedVariable_TimeSinceLastExit, "0");
        addData(TCServerSideConstants.kTCPredefinedVariable_LastForegroundTimeWithoutMeasurement, "0");
        if (strRetrieveInfoFromSharedPreferences.isEmpty() || strRetrieveInfoFromSharedPreferences3.isEmpty() || strRetrieveInfoFromSharedPreferences2.isEmpty() || strRetrieveInfoFromSharedPreferences4.isEmpty()) {
            return;
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_TimeSinceLastExit, String.valueOf(Long.parseLong(str) - Long.parseLong(strRetrieveInfoFromSharedPreferences)));
        addData(TCServerSideConstants.kTCPredefinedVariable_LastForegroundTimeWithoutMeasurement, strRetrieveInfoFromSharedPreferences3);
    }

    private void computeStartUsageTime(boolean z) throws NumberFormatException {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences("UsageDuration", this.appContext);
        if (!strRetrieveInfoFromSharedPreferences.isEmpty()) {
            this.startUsage = Long.parseLong(strRetrieveInfoFromSharedPreferences);
        }
        long j = Long.parseLong(getData(TCServerSideConstants.kTCPredefinedVariable_LastForegroundTimeWithoutMeasurement));
        long j2 = Long.parseLong(getData(TCServerSideConstants.kTCPredefinedVariable_TimeSinceLastExit));
        if (z) {
            j = 0;
        }
        this.startUsage += j2 + j;
    }

    private void initComScoreSession(String str) throws NumberFormatException {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences("SessionStartTimestamp", this.appContext);
        addData(TCServerSideConstants.kTCPredefinedVariable_SessionID, UUID.randomUUID().toString());
        addData(TCServerSideConstants.kTCPredefinedVariable_IsNewSession, "1");
        if (strRetrieveInfoFromSharedPreferences.isEmpty()) {
            TCSharedPreferences.saveInfoToSharedPreferences("SessionStartTimestamp", str, this.appContext);
            TCSharedPreferences.saveInfoToSharedPreferences("LastSessionStartTimestamp", "0", this.appContext);
            TCSharedPreferences.saveInfoToSharedPreferences("UsageDuration", "0", this.appContext);
            addData(TCServerSideConstants.kTCPredefinedVariable_LastSessionStartMs, "0");
            addData(TCServerSideConstants.kTCPredefinedVariable_LastSessionLastHitMs, "0");
            addData(TCServerSideConstants.kTCPredefinedVariable_LastForegroundTimeWithoutMeasurement, "0");
            addData(TCServerSideConstants.kTCPredefinedVariable_TimeSinceLastExit, "0");
            computeDeltaSinceLastLaunch(str);
            computeStartUsageTime(true);
        } else if (Long.parseLong(str) - Long.parseLong(strRetrieveInfoFromSharedPreferences) > this.visitDuration) {
            TCSharedPreferences.saveInfoToSharedPreferences("SessionStartTimestamp", str, this.appContext);
            TCSharedPreferences.saveInfoToSharedPreferences("LastSessionStartTimestamp", strRetrieveInfoFromSharedPreferences, this.appContext);
            addData(TCServerSideConstants.kTCPredefinedVariable_LastSessionStartMs, strRetrieveInfoFromSharedPreferences);
            computeDeltaSinceLastLaunch(str);
            computeStartUsageTime(true);
        } else {
            computeDeltaSinceLastLaunch(str);
            computeStartUsageTime(false);
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_LastSessionStartMs, TCSharedPreferences.retrieveInfoFromSharedPreferences("LastSessionStartTimestamp", this.appContext));
    }

    private String getPropertyFromSharedPreferences(String str) {
        return TCSharedPreferences.retrieveInfoFromSharedPreferences(str, this.appContext);
    }

    private void savePropertyIntoShredPreferences(String str, String str2) {
        TCSharedPreferences.saveInfoToSharedPreferences(str, str2, this.appContext);
    }

    public void computeTimeChangingVariables() {
        long nowMs = getNowMs();
        setSessionDuration(nowMs);
        initNavTimestampCalls(nowMs);
        if (TCLifeCycleCallbacks.state == ETCApplicationState.FOREGROUND) {
            long j = nowMs - this.lastTime;
            this.deltaForeground += j;
            this.totalForegroundTime += j;
            this.lastTime = nowMs;
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_ForegroundTime, String.valueOf(this.totalForegroundTime));
        addData(TCServerSideConstants.kTCPredefinedVariable_DeltaForegroundTime, String.valueOf(this.deltaForeground));
        if (TCLifeCycleCallbacks.state == ETCApplicationState.BACKGROUND) {
            long j2 = nowMs - this.lastTime;
            this.totalBackgroundTime += j2;
            this.deltaBackground += j2;
            this.lastTime = nowMs;
        }
        addData(TCServerSideConstants.kTCPredefinedVariable_BackgroundTime, String.valueOf(this.totalBackgroundTime));
        addData(TCServerSideConstants.kTCPredefinedVariable_DeltaBackgroundTime, String.valueOf(this.deltaBackground));
        TCSharedPreferences.saveInfoToSharedPreferences("UsageDuration", String.valueOf(this.deltaBackground + this.deltaForeground + this.startUsage), this.appContext);
        if (this.deltaBackground > 0) {
            this.deltaBackground = 0L;
        }
        if (this.deltaForeground > 0) {
            this.deltaForeground = 0L;
        }
    }

    private void setSessionDuration(long j) {
        String data = getData(TCServerSideConstants.kTCPredefinedVariable_CurrentVisitMs);
        if (!data.isEmpty()) {
            addData(TCServerSideConstants.kTCPredefinedVariable_SessionDurationMs, String.valueOf((j - Long.parseLong(data)) + this.startUsage));
        } else {
            TCLogger.getInstance().logMessage("Error with timestamp kTCDateCurrentVisitFormat", 6);
        }
    }

    private void initApplicationRuntimeName() {
        addData(TCServerSideConstants.kTCPredefinedVariable_RuntimeName, "android");
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public void addData(TCDynamicStore tCDynamicStore) {
        this.dynamicStore.addData(tCDynamicStore);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public void addData(String str, String str2) {
        this.dynamicStore.addData(str, str2);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public String getData(String str) {
        return this.dynamicStore.getData(str);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public String removeData(String str) {
        return this.dynamicStore.removeData(str);
    }

    public String getPhoneModel() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_Model);
    }

    public String getSystemName() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_SystemName);
    }

    public String getSystemVersion() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_SystemVersion);
    }

    public String getTagCommanderVersion() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_TagCommanderVersion);
    }

    public String getApplicationVersion() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_ApplicationVersion);
    }

    public String getLanguage() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_Language);
    }

    public String getCharset() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_Charset);
    }

    public String getCurrencyCode() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_CurrencyCode);
    }

    public String getCurrencySymbol() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_CurrencySymbol);
    }

    public String getUniqueIdentifier() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_UniqueID);
    }

    public String getScreenSize() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_ScreenResolution);
    }

    public long getNowMs() {
        return System.currentTimeMillis();
    }

    public String getNowMsString() {
        return String.valueOf(getNowMs());
    }

    public long getNav_NumberVisit() {
        return Long.parseLong(getData(TCServerSideConstants.kTCPredefinedVariable_NumberVisit));
    }

    public long getNumberVisit() {
        return Long.parseLong(getData(TCServerSideConstants.kTCPredefinedVariable_NumberSession));
    }

    public long getNav_TimestampCurrentVisit() {
        return Long.parseLong(getData(TCServerSideConstants.kTCPredefinedVariable_CurrentVisitMs));
    }

    public String getFirstVisit() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_FirstVisitMs);
    }

    public String getLastVisit() {
        return getData(TCServerSideConstants.kTCPredefinedVariable_LastVisitMs);
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLifecycleListener
    public void onGoingBackground() {
        long nowMs = getNowMs();
        long j = nowMs - this.lastTime;
        TCSharedPreferences.saveInfoToSharedPreferences("TimeSinceLastMeasurement", String.valueOf(j), this.appContext);
        TCSharedPreferences.saveInfoToSharedPreferences("ExitTimestamp", String.valueOf(nowMs), this.appContext);
        TCSharedPreferences.saveInfoToSharedPreferences("LastForegroundTime", String.valueOf(this.totalForegroundTime), this.appContext);
        TCSharedPreferences.saveInfoToSharedPreferences("LastBackgroundTime", String.valueOf(this.totalBackgroundTime), this.appContext);
        this.deltaForeground += j;
        this.totalForegroundTime += j;
        this.lastTime = nowMs;
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLifecycleListener
    public void onGoingForeground() {
        long nowMs = getNowMs();
        int i = this.totalForegroundTransitions + 1;
        this.totalForegroundTransitions = i;
        addData(TCServerSideConstants.kTCPredefinedVariable_ForegroundTransitions, String.valueOf(i));
        long j = nowMs - this.lastTime;
        this.deltaBackground = j;
        this.totalBackgroundTime += j;
        if (j > this.visitDuration) {
            updateVariablesForNewSession();
        }
        this.lastTime = nowMs;
    }
}
