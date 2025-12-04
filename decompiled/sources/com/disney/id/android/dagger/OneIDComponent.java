package com.disney.id.android.dagger;

import com.allegion.accesssdk.BuildConfig;
import com.disney.id.android.Config;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.OneID;
import com.disney.id.android.OneIDBiometricSupport;
import com.disney.id.android.OneIDConnectivity;
import com.disney.id.android.OneIDMigrationHandler;
import com.disney.id.android.OneIDRecoveryContext;
import com.disney.id.android.OneIDSCALPBundle;
import com.disney.id.android.OneIDSCALPController;
import com.disney.id.android.OneIDSession;
import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.PasswordScore;
import com.disney.id.android.PeriodicSCALPBundlerWorker;
import com.disney.id.android.SWIDController;
import com.disney.id.android.bundler.OneIDBundler;
import com.disney.id.android.crypto.BasicCrypto;
import com.disney.id.android.lightbox.BrowserPromptDialog;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.lightbox.LightboxConfig;
import com.disney.id.android.lightbox.OneIDWebView;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.disney.id.android.lightbox.WebViewBridgeV2;
import com.disney.id.android.lightbox.WebViewBridgeV4;
import com.disney.id.android.localdata.EncryptedSharedPreferences;
import com.disney.id.android.localdata.OneIDExposedStorage;
import com.disney.id.android.localdata.OneIDLocalStorage;
import com.disney.id.android.scalp.SiteConfigAndL10nProvider;
import com.disney.id.android.services.AuthorizationInterceptor;
import com.disney.id.android.services.GuestControllerResponseInterceptor;
import com.disney.id.android.services.ReportingInterceptor;
import com.disney.id.android.tracker.CircularEventTrackingQueue;
import com.disney.id.android.tracker.LogGoSender;
import com.disney.id.android.tracker.OneIDEventQueue;
import com.disney.id.android.tracker.OneIDTracker;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(modules = {OneIDModule.class})
@Singleton
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020*H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u000201H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u000202H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u000204H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u000208H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020:H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020DH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010E\u001a\u00020FH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010G\u001a\u00020HH&¨\u0006I"}, d2 = {"Lcom/disney/id/android/dagger/OneIDComponent;", "", "inject", "", "config", "Lcom/disney/id/android/Config;", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "oneID", "Lcom/disney/id/android/OneID;", "biometricSupport", "Lcom/disney/id/android/OneIDBiometricSupport;", "conn", "Lcom/disney/id/android/OneIDConnectivity;", "migrationHandler", "Lcom/disney/id/android/OneIDMigrationHandler;", OneIDRecoveryContext.RECOVERY_CONTEXT, "Lcom/disney/id/android/OneIDRecoveryContext;", "scalpBundle", "Lcom/disney/id/android/OneIDSCALPBundle;", "scalpController", "Lcom/disney/id/android/OneIDSCALPController;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/disney/id/android/OneIDSession;", "oc", "Lcom/disney/id/android/OptionalConfigs;", "ocb", "Lcom/disney/id/android/OptionalConfigs$OptionalConfigsBuilder;", "passwordScore", "Lcom/disney/id/android/PasswordScore;", "periodicWorker", "Lcom/disney/id/android/PeriodicSCALPBundlerWorker;", "swidController", "Lcom/disney/id/android/SWIDController;", "bundler", "Lcom/disney/id/android/bundler/OneIDBundler;", "basicCrypto", "Lcom/disney/id/android/crypto/BasicCrypto;", "bpd", "Lcom/disney/id/android/lightbox/BrowserPromptDialog;", "lba", "Lcom/disney/id/android/lightbox/LightboxActivity;", "Lcom/disney/id/android/lightbox/LightboxConfig;", "wv", "Lcom/disney/id/android/lightbox/OneIDWebView;", "wvf", "Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "bridge", "Lcom/disney/id/android/lightbox/WebToNativeBridgeBase;", "Lcom/disney/id/android/lightbox/WebViewBridgeV2;", "Lcom/disney/id/android/lightbox/WebViewBridgeV4;", "encryptedSharedPreferences", "Lcom/disney/id/android/localdata/EncryptedSharedPreferences;", "osp", "Lcom/disney/id/android/localdata/OneIDExposedStorage;", "ols", "Lcom/disney/id/android/localdata/OneIDLocalStorage;", "siteConfigAndL10nProvider", "Lcom/disney/id/android/scalp/SiteConfigAndL10nProvider;", "ai", "Lcom/disney/id/android/services/AuthorizationInterceptor;", "guestControllerResponseInterceptor", "Lcom/disney/id/android/services/GuestControllerResponseInterceptor;", "ri", "Lcom/disney/id/android/services/ReportingInterceptor;", "cetq", "Lcom/disney/id/android/tracker/CircularEventTrackingQueue;", "logGo", "Lcom/disney/id/android/tracker/LogGoSender;", "eventQueue", "Lcom/disney/id/android/tracker/OneIDEventQueue;", "tracker", "Lcom/disney/id/android/tracker/OneIDTracker;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OneIDComponent {
    void inject(@NotNull Config config);

    void inject(@NotNull ConfigHandler configHandler);

    void inject(@NotNull OneID oneID);

    void inject(@NotNull OneIDBiometricSupport biometricSupport);

    void inject(@NotNull OneIDConnectivity conn);

    void inject(@NotNull OneIDMigrationHandler migrationHandler);

    void inject(@NotNull OneIDRecoveryContext recoveryContext);

    void inject(@NotNull OneIDSCALPBundle scalpBundle);

    void inject(@NotNull OneIDSCALPController scalpController);

    void inject(@NotNull OneIDSession session);

    void inject(@NotNull OptionalConfigs.OptionalConfigsBuilder ocb);

    void inject(@NotNull OptionalConfigs oc);

    void inject(@NotNull PasswordScore passwordScore);

    void inject(@NotNull PeriodicSCALPBundlerWorker periodicWorker);

    void inject(@NotNull SWIDController swidController);

    void inject(@NotNull OneIDBundler bundler);

    void inject(@NotNull BasicCrypto basicCrypto);

    void inject(@NotNull BrowserPromptDialog bpd);

    void inject(@NotNull LightboxActivity lba);

    void inject(@NotNull LightboxConfig config);

    void inject(@NotNull OneIDWebView wv);

    void inject(@NotNull OneIDWebViewFactory wvf);

    void inject(@NotNull WebToNativeBridgeBase bridge);

    void inject(@NotNull WebViewBridgeV2 bridge);

    void inject(@NotNull WebViewBridgeV4 bridge);

    void inject(@NotNull EncryptedSharedPreferences encryptedSharedPreferences);

    void inject(@NotNull OneIDExposedStorage osp);

    void inject(@NotNull OneIDLocalStorage ols);

    void inject(@NotNull SiteConfigAndL10nProvider siteConfigAndL10nProvider);

    void inject(@NotNull AuthorizationInterceptor ai);

    void inject(@NotNull GuestControllerResponseInterceptor guestControllerResponseInterceptor);

    void inject(@NotNull ReportingInterceptor ri);

    void inject(@NotNull CircularEventTrackingQueue cetq);

    void inject(@NotNull LogGoSender logGo);

    void inject(@NotNull OneIDEventQueue eventQueue);

    void inject(@NotNull OneIDTracker tracker);
}
