package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCWebViewManagerInterface;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PacketTags;

/* loaded from: classes3.dex */
public class RNCWebViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCWebViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCWebViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2014672109:
                if (str.equals("allowFileAccessFromFileURLs")) {
                    c = 0;
                    break;
                }
                break;
            case -1843391113:
                if (str.equals("sharedCookiesEnabled")) {
                    c = 1;
                    break;
                }
                break;
            case -1821622534:
                if (str.equals("allowsPictureInPictureMediaPlayback")) {
                    c = 2;
                    break;
                }
                break;
            case -1737229888:
                if (str.equals("allowsProtectedMedia")) {
                    c = 3;
                    break;
                }
                break;
            case -1725560121:
                if (str.equals("saveFormDataDisabled")) {
                    c = 4;
                    break;
                }
                break;
            case -1714115364:
                if (str.equals("textInteractionEnabled")) {
                    c = 5;
                    break;
                }
                break;
            case -1646494270:
                if (str.equals("injectedJavaScriptBeforeContentLoaded")) {
                    c = 6;
                    break;
                }
                break;
            case -1642362548:
                if (str.equals("directionalLockEnabled")) {
                    c = 7;
                    break;
                }
                break;
            case -1607633676:
                if (str.equals("javaScriptEnabled")) {
                    c = '\b';
                    break;
                }
                break;
            case -1562001507:
                if (str.equals("messagingEnabled")) {
                    c = '\t';
                    break;
                }
                break;
            case -1555578679:
                if (str.equals("dataDetectorTypes")) {
                    c = '\n';
                    break;
                }
                break;
            case -1547082335:
                if (str.equals("menuItems")) {
                    c = 11;
                    break;
                }
                break;
            case -1423657812:
                if (str.equals("incognito")) {
                    c = '\f';
                    break;
                }
                break;
            case -1397361343:
                if (str.equals("allowingReadAccessToURL")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case -1321236988:
                if (str.equals("overScrollMode")) {
                    c = 14;
                    break;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    c = 15;
                    break;
                }
                break;
            case -1150480790:
                if (str.equals("keyboardDisplayRequiresUserAction")) {
                    c = 16;
                    break;
                }
                break;
            case -1146673624:
                if (str.equals("domStorageEnabled")) {
                    c = 17;
                    break;
                }
                break;
            case -1138577980:
                if (str.equals("allowsLinkPreview")) {
                    c = 18;
                    break;
                }
                break;
            case -1009029441:
                if (str.equals("useSharedProcessPool")) {
                    c = 19;
                    break;
                }
                break;
            case -1003454816:
                if (str.equals("textZoom")) {
                    c = 20;
                    break;
                }
                break;
            case -922092170:
                if (str.equals("showsVerticalScrollIndicator")) {
                    c = 21;
                    break;
                }
                break;
            case -906998080:
                if (str.equals("forceDarkOn")) {
                    c = 22;
                    break;
                }
                break;
            case -800676066:
                if (str.equals("minimumFontSize")) {
                    c = 23;
                    break;
                }
                break;
            case -735485938:
                if (str.equals("hideKeyboardAccessoryView")) {
                    c = 24;
                    break;
                }
                break;
            case -728016272:
                if (str.equals("allowUniversalAccessFromFileURLs")) {
                    c = 25;
                    break;
                }
                break;
            case -726941883:
                if (str.equals("mediaCapturePermissionGrantType")) {
                    c = 26;
                    break;
                }
                break;
            case -600226341:
                if (str.equals("newSource")) {
                    c = 27;
                    break;
                }
                break;
            case -572048675:
                if (str.equals("hasOnFileDownload")) {
                    c = 28;
                    break;
                }
                break;
            case -553792443:
                if (str.equals("cacheMode")) {
                    c = 29;
                    break;
                }
                break;
            case -502352363:
                if (str.equals("pagingEnabled")) {
                    c = 30;
                    break;
                }
                break;
            case -389349956:
                if (str.equals("contentMode")) {
                    c = 31;
                    break;
                }
                break;
            case -380199621:
                if (str.equals("messagingModuleName")) {
                    c = ' ';
                    break;
                }
                break;
            case -305041273:
                if (str.equals("hasOnOpenWindowEvent")) {
                    c = '!';
                    break;
                }
                break;
            case -227577491:
                if (str.equals("javaScriptCanOpenWindowsAutomatically")) {
                    c = '\"';
                    break;
                }
                break;
            case -181845559:
                if (str.equals("setDisplayZoomControls")) {
                    c = '#';
                    break;
                }
                break;
            case -128312874:
                if (str.equals("allowsFullscreenVideo")) {
                    c = '$';
                    break;
                }
                break;
            case -127745027:
                if (str.equals("nestedScrollEnabled")) {
                    c = CoreConstants.PERCENT_CHAR;
                    break;
                }
                break;
            case -104290151:
                if (str.equals("injectedJavaScriptBeforeContentLoadedForMainFrameOnly")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 70220358:
                if (str.equals("hasOnScroll")) {
                    c = CoreConstants.SINGLE_QUOTE_CHAR;
                    break;
                }
                break;
            case 70310635:
                if (str.equals("bounces")) {
                    c = CoreConstants.LEFT_PARENTHESIS_CHAR;
                    break;
                }
                break;
            case 97678726:
                if (str.equals("setSupportMultipleWindows")) {
                    c = CoreConstants.RIGHT_PARENTHESIS_CHAR;
                    break;
                }
                break;
            case 138148216:
                if (str.equals("lackPermissionToDownloadMessage")) {
                    c = '*';
                    break;
                }
                break;
            case 215255965:
                if (str.equals("injectedJavaScript")) {
                    c = '+';
                    break;
                }
                break;
            case 226157789:
                if (str.equals("automaticallyAdjustContentInsets")) {
                    c = ',';
                    break;
                }
                break;
            case 311430650:
                if (str.equals("userAgent")) {
                    c = '-';
                    break;
                }
                break;
            case 368381276:
                if (str.equals("allowsInlineMediaPlayback")) {
                    c = '.';
                    break;
                }
                break;
            case 397237599:
                if (str.equals("cacheEnabled")) {
                    c = '/';
                    break;
                }
                break;
            case 441950324:
                if (str.equals("injectedJavaScriptForMainFrameOnly")) {
                    c = '0';
                    break;
                }
                break;
            case 475851404:
                if (str.equals("webviewDebuggingEnabled")) {
                    c = '1';
                    break;
                }
                break;
            case 496513340:
                if (str.equals("injectedJavaScriptObject")) {
                    c = '2';
                    break;
                }
                break;
            case 590869196:
                if (str.equals("applicationNameForUserAgent")) {
                    c = '3';
                    break;
                }
                break;
            case 760962753:
                if (str.equals("mixedContentMode")) {
                    c = '4';
                    break;
                }
                break;
            case 811343908:
                if (str.equals("contentInset")) {
                    c = '5';
                    break;
                }
                break;
            case 830951634:
                if (str.equals("allowsBackForwardNavigationGestures")) {
                    c = '6';
                    break;
                }
                break;
            case 1076208106:
                if (str.equals("allowsAirPlayForMediaPlayback")) {
                    c = '7';
                    break;
                }
                break;
            case 1138246185:
                if (str.equals("allowFileAccess")) {
                    c = '8';
                    break;
                }
                break;
            case 1170796208:
                if (str.equals("limitsNavigationsToAppBoundDomains")) {
                    c = '9';
                    break;
                }
                break;
            case 1177556938:
                if (str.equals("setBuiltInZoomControls")) {
                    c = ':';
                    break;
                }
                break;
            case 1219945382:
                if (str.equals("pullToRefreshEnabled")) {
                    c = ';';
                    break;
                }
                break;
            case 1244240887:
                if (str.equals("refreshControlLightMode")) {
                    c = Typography.less;
                    break;
                }
                break;
            case 1309684816:
                if (str.equals("fraudulentWebsiteWarningEnabled")) {
                    c = '=';
                    break;
                }
                break;
            case 1344414299:
                if (str.equals("geolocationEnabled")) {
                    c = Typography.greater;
                    break;
                }
                break;
            case 1359182925:
                if (str.equals("downloadingMessage")) {
                    c = '?';
                    break;
                }
                break;
            case 1512859629:
                if (str.equals("basicAuthCredential")) {
                    c = '@';
                    break;
                }
                break;
            case 1523258769:
                if (str.equals("enableApplePay")) {
                    c = 'A';
                    break;
                }
                break;
            case 1774874798:
                if (str.equals("mediaPlaybackRequiresUserAction")) {
                    c = 'B';
                    break;
                }
                break;
            case 1812525393:
                if (str.equals("thirdPartyCookiesEnabled")) {
                    c = 'C';
                    break;
                }
                break;
            case 1813472596:
                if (str.equals("autoManageStatusBarEnabled")) {
                    c = 'D';
                    break;
                }
                break;
            case 1850310268:
                if (str.equals("androidLayerType")) {
                    c = 'E';
                    break;
                }
                break;
            case 1868864108:
                if (str.equals("suppressMenuItems")) {
                    c = 'F';
                    break;
                }
                break;
            case 1915931784:
                if (str.equals("showsHorizontalScrollIndicator")) {
                    c = 'G';
                    break;
                }
                break;
            case 2074641374:
                if (str.equals("scalesPageToFit")) {
                    c = 'H';
                    break;
                }
                break;
            case 2129019807:
                if (str.equals("decelerationRate")) {
                    c = 'I';
                    break;
                }
                break;
            case 2146755107:
                if (str.equals("contentInsetAdjustmentBehavior")) {
                    c = 'J';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowFileAccessFromFileURLs(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNCWebViewManagerInterface) this.mViewManager).setSharedCookiesEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 2:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsPictureInPictureMediaPlayback(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsProtectedMedia(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                ((RNCWebViewManagerInterface) this.mViewManager).setSaveFormDataDisabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNCWebViewManagerInterface) this.mViewManager).setTextInteractionEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 6:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptBeforeContentLoaded(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNCWebViewManagerInterface) this.mViewManager).setDirectionalLockEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '\b':
                ((RNCWebViewManagerInterface) this.mViewManager).setJavaScriptEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '\t':
                ((RNCWebViewManagerInterface) this.mViewManager).setMessagingEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\n':
                ((RNCWebViewManagerInterface) this.mViewManager).setDataDetectorTypes(t, (ReadableArray) obj);
                break;
            case 11:
                ((RNCWebViewManagerInterface) this.mViewManager).setMenuItems(t, (ReadableArray) obj);
                break;
            case '\f':
                ((RNCWebViewManagerInterface) this.mViewManager).setIncognito(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\r':
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowingReadAccessToURL(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNCWebViewManagerInterface) this.mViewManager).setOverScrollMode(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNCWebViewManagerInterface) this.mViewManager).setScrollEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 16:
                ((RNCWebViewManagerInterface) this.mViewManager).setKeyboardDisplayRequiresUserAction(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 17:
                ((RNCWebViewManagerInterface) this.mViewManager).setDomStorageEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 18:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsLinkPreview(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 19:
                ((RNCWebViewManagerInterface) this.mViewManager).setUseSharedProcessPool(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 20:
                ((RNCWebViewManagerInterface) this.mViewManager).setTextZoom(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 21:
                ((RNCWebViewManagerInterface) this.mViewManager).setShowsVerticalScrollIndicator(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 22:
                ((RNCWebViewManagerInterface) this.mViewManager).setForceDarkOn(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 23:
                ((RNCWebViewManagerInterface) this.mViewManager).setMinimumFontSize(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 24:
                ((RNCWebViewManagerInterface) this.mViewManager).setHideKeyboardAccessoryView(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 25:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowUniversalAccessFromFileURLs(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 26:
                ((RNCWebViewManagerInterface) this.mViewManager).setMediaCapturePermissionGrantType(t, (String) obj);
                break;
            case 27:
                ((RNCWebViewManagerInterface) this.mViewManager).setNewSource(t, (ReadableMap) obj);
                break;
            case 28:
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnFileDownload(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNCWebViewManagerInterface) this.mViewManager).setCacheMode(t, (String) obj);
                break;
            case 30:
                ((RNCWebViewManagerInterface) this.mViewManager).setPagingEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 31:
                ((RNCWebViewManagerInterface) this.mViewManager).setContentMode(t, (String) obj);
                break;
            case ' ':
                ((RNCWebViewManagerInterface) this.mViewManager).setMessagingModuleName(t, obj != null ? (String) obj : null);
                break;
            case '!':
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnOpenWindowEvent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\"':
                ((RNCWebViewManagerInterface) this.mViewManager).setJavaScriptCanOpenWindowsAutomatically(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '#':
                ((RNCWebViewManagerInterface) this.mViewManager).setSetDisplayZoomControls(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '$':
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsFullscreenVideo(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '%':
                ((RNCWebViewManagerInterface) this.mViewManager).setNestedScrollEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '&':
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '\'':
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnScroll(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '(':
                ((RNCWebViewManagerInterface) this.mViewManager).setBounces(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case ')':
                ((RNCWebViewManagerInterface) this.mViewManager).setSetSupportMultipleWindows(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '*':
                ((RNCWebViewManagerInterface) this.mViewManager).setLackPermissionToDownloadMessage(t, obj != null ? (String) obj : null);
                break;
            case '+':
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScript(t, obj != null ? (String) obj : null);
                break;
            case ',':
                ((RNCWebViewManagerInterface) this.mViewManager).setAutomaticallyAdjustContentInsets(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '-':
                ((RNCWebViewManagerInterface) this.mViewManager).setUserAgent(t, obj != null ? (String) obj : null);
                break;
            case '.':
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsInlineMediaPlayback(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '/':
                ((RNCWebViewManagerInterface) this.mViewManager).setCacheEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '0':
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptForMainFrameOnly(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '1':
                ((RNCWebViewManagerInterface) this.mViewManager).setWebviewDebuggingEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '2':
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptObject(t, obj != null ? (String) obj : null);
                break;
            case '3':
                ((RNCWebViewManagerInterface) this.mViewManager).setApplicationNameForUserAgent(t, obj != null ? (String) obj : null);
                break;
            case '4':
                ((RNCWebViewManagerInterface) this.mViewManager).setMixedContentMode(t, (String) obj);
                break;
            case EACTags.SEX /* 53 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setContentInset(t, (ReadableMap) obj);
                break;
            case EACTags.CURRENCY_EXPONENT /* 54 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsBackForwardNavigationGestures(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '7':
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsAirPlayForMediaPlayback(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '8':
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowFileAccess(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '9':
                ((RNCWebViewManagerInterface) this.mViewManager).setLimitsNavigationsToAppBoundDomains(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case ':':
                ((RNCWebViewManagerInterface) this.mViewManager).setSetBuiltInZoomControls(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setPullToRefreshEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '<':
                ((RNCWebViewManagerInterface) this.mViewManager).setRefreshControlLightMode(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '=':
                ((RNCWebViewManagerInterface) this.mViewManager).setFraudulentWebsiteWarningEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case PacketTags.EXPERIMENTAL_3 /* 62 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setGeolocationEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '?':
                ((RNCWebViewManagerInterface) this.mViewManager).setDownloadingMessage(t, obj != null ? (String) obj : null);
                break;
            case '@':
                ((RNCWebViewManagerInterface) this.mViewManager).setBasicAuthCredential(t, (ReadableMap) obj);
                break;
            case EACTags.ELEMENT_LIST /* 65 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setEnableApplePay(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case EACTags.ADDRESS /* 66 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setMediaPlaybackRequiresUserAction(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 'C':
                ((RNCWebViewManagerInterface) this.mViewManager).setThirdPartyCookiesEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 'D':
                ((RNCWebViewManagerInterface) this.mViewManager).setAutoManageStatusBarEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case EACTags.DISPLAY_IMAGE /* 69 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setAndroidLayerType(t, (String) obj);
                break;
            case 'F':
                ((RNCWebViewManagerInterface) this.mViewManager).setSuppressMenuItems(t, (ReadableArray) obj);
                break;
            case 'G':
                ((RNCWebViewManagerInterface) this.mViewManager).setShowsHorizontalScrollIndicator(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 'H':
                ((RNCWebViewManagerInterface) this.mViewManager).setScalesPageToFit(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 'I':
                ((RNCWebViewManagerInterface) this.mViewManager).setDecelerationRate(t, obj == null ? AudioStats.AUDIO_AMPLITUDE_NONE : ((Double) obj).doubleValue());
                break;
            case EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY /* 74 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setContentInsetAdjustmentBehavior(t, (String) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "goBack":
                ((RNCWebViewManagerInterface) this.mViewManager).goBack(t);
                break;
            case "stopLoading":
                ((RNCWebViewManagerInterface) this.mViewManager).stopLoading(t);
                break;
            case "reload":
                ((RNCWebViewManagerInterface) this.mViewManager).reload(t);
                break;
            case "clearCache":
                ((RNCWebViewManagerInterface) this.mViewManager).clearCache(t, readableArray.getBoolean(0));
                break;
            case "goForward":
                ((RNCWebViewManagerInterface) this.mViewManager).goForward(t);
                break;
            case "clearFormData":
                ((RNCWebViewManagerInterface) this.mViewManager).clearFormData(t);
                break;
            case "loadUrl":
                ((RNCWebViewManagerInterface) this.mViewManager).loadUrl(t, readableArray.getString(0));
                break;
            case "clearHistory":
                ((RNCWebViewManagerInterface) this.mViewManager).clearHistory(t);
                break;
            case "requestFocus":
                ((RNCWebViewManagerInterface) this.mViewManager).requestFocus(t);
                break;
            case "postMessage":
                ((RNCWebViewManagerInterface) this.mViewManager).postMessage(t, readableArray.getString(0));
                break;
            case "injectJavaScript":
                ((RNCWebViewManagerInterface) this.mViewManager).injectJavaScript(t, readableArray.getString(0));
                break;
        }
    }
}
