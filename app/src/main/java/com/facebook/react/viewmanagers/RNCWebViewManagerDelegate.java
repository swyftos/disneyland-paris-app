package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCWebViewManagerInterface;
import com.google.common.base.Ascii;
import kotlin.p163io.encoding.Base64;
import okio.Utf8;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PacketTags;

/* JADX INFO: loaded from: classes3.dex */
public class RNCWebViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCWebViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCWebViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2014672109:
                if (str.equals("allowFileAccessFromFileURLs")) {
                    b = 0;
                }
                break;
            case -1843391113:
                if (str.equals("sharedCookiesEnabled")) {
                    b = 1;
                }
                break;
            case -1821622534:
                if (str.equals("allowsPictureInPictureMediaPlayback")) {
                    b = 2;
                }
                break;
            case -1737229888:
                if (str.equals("allowsProtectedMedia")) {
                    b = 3;
                }
                break;
            case -1725560121:
                if (str.equals("saveFormDataDisabled")) {
                    b = 4;
                }
                break;
            case -1714115364:
                if (str.equals("textInteractionEnabled")) {
                    b = 5;
                }
                break;
            case -1646494270:
                if (str.equals("injectedJavaScriptBeforeContentLoaded")) {
                    b = 6;
                }
                break;
            case -1642362548:
                if (str.equals("directionalLockEnabled")) {
                    b = 7;
                }
                break;
            case -1607633676:
                if (str.equals("javaScriptEnabled")) {
                    b = 8;
                }
                break;
            case -1562001507:
                if (str.equals("messagingEnabled")) {
                    b = 9;
                }
                break;
            case -1555578679:
                if (str.equals("dataDetectorTypes")) {
                    b = 10;
                }
                break;
            case -1547082335:
                if (str.equals("menuItems")) {
                    b = Ascii.f3535VT;
                }
                break;
            case -1423657812:
                if (str.equals("incognito")) {
                    b = Ascii.f3524FF;
                }
                break;
            case -1397361343:
                if (str.equals("allowingReadAccessToURL")) {
                    b = Ascii.f3522CR;
                }
                break;
            case -1321236988:
                if (str.equals("overScrollMode")) {
                    b = Ascii.f3532SO;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    b = Ascii.f3531SI;
                }
                break;
            case -1150480790:
                if (str.equals("keyboardDisplayRequiresUserAction")) {
                    b = Ascii.DLE;
                }
                break;
            case -1146673624:
                if (str.equals("domStorageEnabled")) {
                    b = 17;
                }
                break;
            case -1138577980:
                if (str.equals("allowsLinkPreview")) {
                    b = Ascii.DC2;
                }
                break;
            case -1009029441:
                if (str.equals("useSharedProcessPool")) {
                    b = 19;
                }
                break;
            case -1003454816:
                if (str.equals("textZoom")) {
                    b = Ascii.DC4;
                }
                break;
            case -922092170:
                if (str.equals("showsVerticalScrollIndicator")) {
                    b = Ascii.NAK;
                }
                break;
            case -906998080:
                if (str.equals("forceDarkOn")) {
                    b = Ascii.SYN;
                }
                break;
            case -800676066:
                if (str.equals("minimumFontSize")) {
                    b = Ascii.ETB;
                }
                break;
            case -735485938:
                if (str.equals("hideKeyboardAccessoryView")) {
                    b = Ascii.CAN;
                }
                break;
            case -728016272:
                if (str.equals("allowUniversalAccessFromFileURLs")) {
                    b = Ascii.f3523EM;
                }
                break;
            case -726941883:
                if (str.equals("mediaCapturePermissionGrantType")) {
                    b = Ascii.SUB;
                }
                break;
            case -600226341:
                if (str.equals("newSource")) {
                    b = Ascii.ESC;
                }
                break;
            case -572048675:
                if (str.equals("hasOnFileDownload")) {
                    b = Ascii.f3525FS;
                }
                break;
            case -553792443:
                if (str.equals("cacheMode")) {
                    b = Ascii.f3526GS;
                }
                break;
            case -502352363:
                if (str.equals("pagingEnabled")) {
                    b = Ascii.f3530RS;
                }
                break;
            case -389349956:
                if (str.equals("contentMode")) {
                    b = Ascii.f3534US;
                }
                break;
            case -380199621:
                if (str.equals("messagingModuleName")) {
                    b = 32;
                }
                break;
            case -305041273:
                if (str.equals("hasOnOpenWindowEvent")) {
                    b = 33;
                }
                break;
            case -227577491:
                if (str.equals("javaScriptCanOpenWindowsAutomatically")) {
                    b = 34;
                }
                break;
            case -181845559:
                if (str.equals("setDisplayZoomControls")) {
                    b = 35;
                }
                break;
            case -128312874:
                if (str.equals("allowsFullscreenVideo")) {
                    b = 36;
                }
                break;
            case -127745027:
                if (str.equals("nestedScrollEnabled")) {
                    b = 37;
                }
                break;
            case -104290151:
                if (str.equals("injectedJavaScriptBeforeContentLoadedForMainFrameOnly")) {
                    b = 38;
                }
                break;
            case 70220358:
                if (str.equals("hasOnScroll")) {
                    b = 39;
                }
                break;
            case 70310635:
                if (str.equals("bounces")) {
                    b = 40;
                }
                break;
            case 97678726:
                if (str.equals("setSupportMultipleWindows")) {
                    b = 41;
                }
                break;
            case 138148216:
                if (str.equals("lackPermissionToDownloadMessage")) {
                    b = 42;
                }
                break;
            case 215255965:
                if (str.equals("injectedJavaScript")) {
                    b = 43;
                }
                break;
            case 226157789:
                if (str.equals("automaticallyAdjustContentInsets")) {
                    b = 44;
                }
                break;
            case 311430650:
                if (str.equals("userAgent")) {
                    b = 45;
                }
                break;
            case 368381276:
                if (str.equals("allowsInlineMediaPlayback")) {
                    b = 46;
                }
                break;
            case 397237599:
                if (str.equals("cacheEnabled")) {
                    b = 47;
                }
                break;
            case 441950324:
                if (str.equals("injectedJavaScriptForMainFrameOnly")) {
                    b = 48;
                }
                break;
            case 475851404:
                if (str.equals("webviewDebuggingEnabled")) {
                    b = 49;
                }
                break;
            case 496513340:
                if (str.equals("injectedJavaScriptObject")) {
                    b = 50;
                }
                break;
            case 590869196:
                if (str.equals("applicationNameForUserAgent")) {
                    b = 51;
                }
                break;
            case 760962753:
                if (str.equals("mixedContentMode")) {
                    b = 52;
                }
                break;
            case 811343908:
                if (str.equals("contentInset")) {
                    b = 53;
                }
                break;
            case 830951634:
                if (str.equals("allowsBackForwardNavigationGestures")) {
                    b = 54;
                }
                break;
            case 1076208106:
                if (str.equals("allowsAirPlayForMediaPlayback")) {
                    b = 55;
                }
                break;
            case 1138246185:
                if (str.equals("allowFileAccess")) {
                    b = 56;
                }
                break;
            case 1170796208:
                if (str.equals("limitsNavigationsToAppBoundDomains")) {
                    b = 57;
                }
                break;
            case 1177556938:
                if (str.equals("setBuiltInZoomControls")) {
                    b = 58;
                }
                break;
            case 1219945382:
                if (str.equals("pullToRefreshEnabled")) {
                    b = 59;
                }
                break;
            case 1244240887:
                if (str.equals("refreshControlLightMode")) {
                    b = 60;
                }
                break;
            case 1309684816:
                if (str.equals("fraudulentWebsiteWarningEnabled")) {
                    b = Base64.padSymbol;
                }
                break;
            case 1344414299:
                if (str.equals("geolocationEnabled")) {
                    b = 62;
                }
                break;
            case 1359182925:
                if (str.equals("downloadingMessage")) {
                    b = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 1512859629:
                if (str.equals("basicAuthCredential")) {
                    b = 64;
                }
                break;
            case 1523258769:
                if (str.equals("enableApplePay")) {
                    b = 65;
                }
                break;
            case 1774874798:
                if (str.equals("mediaPlaybackRequiresUserAction")) {
                    b = 66;
                }
                break;
            case 1812525393:
                if (str.equals("thirdPartyCookiesEnabled")) {
                    b = 67;
                }
                break;
            case 1813472596:
                if (str.equals("autoManageStatusBarEnabled")) {
                    b = 68;
                }
                break;
            case 1850310268:
                if (str.equals("androidLayerType")) {
                    b = 69;
                }
                break;
            case 1868864108:
                if (str.equals("suppressMenuItems")) {
                    b = 70;
                }
                break;
            case 1915931784:
                if (str.equals("showsHorizontalScrollIndicator")) {
                    b = 71;
                }
                break;
            case 2074641374:
                if (str.equals("scalesPageToFit")) {
                    b = 72;
                }
                break;
            case 2129019807:
                if (str.equals("decelerationRate")) {
                    b = 73;
                }
                break;
            case 2146755107:
                if (str.equals("contentInsetAdjustmentBehavior")) {
                    b = 74;
                }
                break;
        }
        switch (b) {
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
            case 8:
                ((RNCWebViewManagerInterface) this.mViewManager).setJavaScriptEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 9:
                ((RNCWebViewManagerInterface) this.mViewManager).setMessagingEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 10:
                ((RNCWebViewManagerInterface) this.mViewManager).setDataDetectorTypes(t, (ReadableArray) obj);
                break;
            case 11:
                ((RNCWebViewManagerInterface) this.mViewManager).setMenuItems(t, (ReadableArray) obj);
                break;
            case 12:
                ((RNCWebViewManagerInterface) this.mViewManager).setIncognito(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
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
            case 32:
                ((RNCWebViewManagerInterface) this.mViewManager).setMessagingModuleName(t, obj != null ? (String) obj : null);
                break;
            case 33:
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnOpenWindowEvent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 34:
                ((RNCWebViewManagerInterface) this.mViewManager).setJavaScriptCanOpenWindowsAutomatically(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 35:
                ((RNCWebViewManagerInterface) this.mViewManager).setSetDisplayZoomControls(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 36:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsFullscreenVideo(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 37:
                ((RNCWebViewManagerInterface) this.mViewManager).setNestedScrollEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 38:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 39:
                ((RNCWebViewManagerInterface) this.mViewManager).setHasOnScroll(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 40:
                ((RNCWebViewManagerInterface) this.mViewManager).setBounces(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 41:
                ((RNCWebViewManagerInterface) this.mViewManager).setSetSupportMultipleWindows(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 42:
                ((RNCWebViewManagerInterface) this.mViewManager).setLackPermissionToDownloadMessage(t, obj != null ? (String) obj : null);
                break;
            case 43:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScript(t, obj != null ? (String) obj : null);
                break;
            case 44:
                ((RNCWebViewManagerInterface) this.mViewManager).setAutomaticallyAdjustContentInsets(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 45:
                ((RNCWebViewManagerInterface) this.mViewManager).setUserAgent(t, obj != null ? (String) obj : null);
                break;
            case 46:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsInlineMediaPlayback(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 47:
                ((RNCWebViewManagerInterface) this.mViewManager).setCacheEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 48:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptForMainFrameOnly(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 49:
                ((RNCWebViewManagerInterface) this.mViewManager).setWebviewDebuggingEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 50:
                ((RNCWebViewManagerInterface) this.mViewManager).setInjectedJavaScriptObject(t, obj != null ? (String) obj : null);
                break;
            case 51:
                ((RNCWebViewManagerInterface) this.mViewManager).setApplicationNameForUserAgent(t, obj != null ? (String) obj : null);
                break;
            case 52:
                ((RNCWebViewManagerInterface) this.mViewManager).setMixedContentMode(t, (String) obj);
                break;
            case EACTags.SEX /* 53 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setContentInset(t, (ReadableMap) obj);
                break;
            case EACTags.CURRENCY_EXPONENT /* 54 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsBackForwardNavigationGestures(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 55:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowsAirPlayForMediaPlayback(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 56:
                ((RNCWebViewManagerInterface) this.mViewManager).setAllowFileAccess(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 57:
                ((RNCWebViewManagerInterface) this.mViewManager).setLimitsNavigationsToAppBoundDomains(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 58:
                ((RNCWebViewManagerInterface) this.mViewManager).setSetBuiltInZoomControls(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setPullToRefreshEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 60:
                ((RNCWebViewManagerInterface) this.mViewManager).setRefreshControlLightMode(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 61:
                ((RNCWebViewManagerInterface) this.mViewManager).setFraudulentWebsiteWarningEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case PacketTags.EXPERIMENTAL_3 /* 62 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setGeolocationEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 63:
                ((RNCWebViewManagerInterface) this.mViewManager).setDownloadingMessage(t, obj != null ? (String) obj : null);
                break;
            case 64:
                ((RNCWebViewManagerInterface) this.mViewManager).setBasicAuthCredential(t, (ReadableMap) obj);
                break;
            case EACTags.ELEMENT_LIST /* 65 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setEnableApplePay(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case EACTags.ADDRESS /* 66 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setMediaPlaybackRequiresUserAction(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 67:
                ((RNCWebViewManagerInterface) this.mViewManager).setThirdPartyCookiesEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 68:
                ((RNCWebViewManagerInterface) this.mViewManager).setAutoManageStatusBarEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case EACTags.DISPLAY_IMAGE /* 69 */:
                ((RNCWebViewManagerInterface) this.mViewManager).setAndroidLayerType(t, (String) obj);
                break;
            case 70:
                ((RNCWebViewManagerInterface) this.mViewManager).setSuppressMenuItems(t, (ReadableArray) obj);
                break;
            case 71:
                ((RNCWebViewManagerInterface) this.mViewManager).setShowsHorizontalScrollIndicator(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 72:
                ((RNCWebViewManagerInterface) this.mViewManager).setScalesPageToFit(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 73:
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
    /* JADX INFO: renamed from: receiveCommand */
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
