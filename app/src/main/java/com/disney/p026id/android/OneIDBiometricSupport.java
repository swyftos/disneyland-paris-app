package com.disney.p026id.android;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.util.Base64;
import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.core.os.CancellationSignal;
import com.amazonaws.services.p017s3.internal.crypto.JceEncryptionConstants;
import com.contentsquare.android.api.Currencies;
import com.disney.p026id.android.dagger.OneIDDagger;
import com.disney.p026id.android.extensions.JSONExtensionsKt;
import com.disney.p026id.android.lightbox.LightboxActivity;
import com.disney.p026id.android.localdata.LocalStorage;
import com.disney.p026id.android.logging.Logger;
import com.disney.p026id.android.tracker.EventAction;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.disney.p026id.android.tracker.Tracker;
import com.disney.p026id.android.tracker.TrackerEventKey;
import com.dlp.BluetoothManager;
import gherkin.GherkinLanguageConstants;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J.\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\"\u0010.\u001a\u00020/2\u0006\u0010#\u001a\u00020$2\u0006\u00100\u001a\u0002012\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u00102\u001a\u0002032\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u00104\u001a\u000205H\u0002J\u001c\u00106\u001a\u0004\u0018\u00010-2\u0006\u0010#\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u00010-H\u0016J\"\u00108\u001a\u00020-2\u0006\u0010#\u001a\u00020$2\u0006\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010-H\u0016J\u0016\u0010;\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u001a\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>2\b\u0010:\u001a\u0004\u0018\u00010-H\u0016J\b\u0010?\u001a\u00020\"H\u0016J\b\u0010@\u001a\u00020\"H\u0003J\u0014\u0010A\u001a\u0004\u0018\u00010-2\b\u0010B\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\"H\u0002JD\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020(2\u0006\u00109\u001a\u00020-2\u0006\u0010H\u001a\u00020-2\u0006\u0010%\u001a\u00020&2\b\u0010I\u001a\u0004\u0018\u00010-2\b\u0010J\u001a\u0004\u0018\u00010-2\u0006\u0010K\u001a\u00020\"H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006M"}, m1836d2 = {"Lcom/disney/id/android/OneIDBiometricSupport;", "Lcom/disney/id/android/BiometricSupport;", "()V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "scalpController", "Lcom/disney/id/android/SCALPController;", "getScalpController$OneID_release", "()Lcom/disney/id/android/SCALPController;", "setScalpController$OneID_release", "(Lcom/disney/id/android/SCALPController;)V", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "authenticateAndDecryptPassword", "", "lightboxActivity", "Lcom/disney/id/android/lightbox/LightboxActivity;", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "credentialsJson", "Lorg/json/JSONObject;", "authenticateAndEnableCipher", "Ljavax/crypto/Cipher;", "passedInCipher", "loginId", "", "createBiometricPrompt", "Landroidx/biometric/BiometricPrompt;", "authFuture", "Lcom/disney/id/android/OneIDAuthenticationFuture;", "createPromptInfo", "Landroidx/biometric/BiometricPrompt$PromptInfo;", "deleteKey", "", "encryptAfterAuthenticate", "plainText", "getBridgeBiometricResponse", "stateKeyToUse", "conversationID", "getCipher", "isBiometricEnabled", "context", "Landroid/content/Context;", "isOptedOut", "isSupported", "maskEmailAddress", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, "retrieveKey", "Ljavax/crypto/SecretKey;", "createIfMissing", "updateBridgeResponseAndCompleteTrackingWithError", "response", BluetoothManager.BLE_STATUS_PARAM, "errorCategory", "errorCode", OneIDTrackerEvent.EVENT_PARAM_PROBLEM, "Companion", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nOneIDBiometricSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDBiometricSupport.kt\ncom/disney/id/android/OneIDBiometricSupport\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,840:1\n37#2,2:841\n37#2,2:843\n*S KotlinDebug\n*F\n+ 1 OneIDBiometricSupport.kt\ncom/disney/id/android/OneIDBiometricSupport\n*L\n244#1:841,2\n588#1:843,2\n*E\n"})
public final class OneIDBiometricSupport implements BiometricSupport {
    private static final String TAG = OneIDBiometricSupport.class.getSimpleName();

    @Inject
    public Logger logger;

    @Inject
    public SCALPController scalpController;

    @Inject
    public LocalStorage storage;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;

    private final boolean isSupported() {
        return true;
    }

    public OneIDBiometricSupport() {
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final LocalStorage getStorage$OneID_release() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage$OneID_release(@NotNull LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final SCALPController getScalpController$OneID_release() {
        SCALPController sCALPController = this.scalpController;
        if (sCALPController != null) {
            return sCALPController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scalpController");
        return null;
    }

    public final void setScalpController$OneID_release(@NotNull SCALPController sCALPController) {
        Intrinsics.checkNotNullParameter(sCALPController, "<set-?>");
        this.scalpController = sCALPController;
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    @NotNull
    public final SWID getSwid$OneID_release() {
        SWID swid = this.swid;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    public final void setSwid$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swid = swid;
    }

    @Override // com.disney.p026id.android.BiometricSupport
    public boolean isOptedOut() {
        if (Intrinsics.areEqual(getScalpController$OneID_release().getBundleVersion(), "v2")) {
            return isSupported() && Intrinsics.areEqual(getStorage$OneID_release().get("touchOptOut"), "true");
        }
        return isSupported() && Intrinsics.areEqual(getStorage$OneID_release().get("biometricsOptOut"), "true");
    }

    @Override // com.disney.p026id.android.BiometricSupport
    public boolean isBiometricEnabled(@NotNull Context context, @Nullable String conversationID) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = BiometricManager.from(context).canAuthenticate(15) == 0;
        if (!z && BiometricManager.from(context).canAuthenticate(255) == 0) {
            Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), conversationID, false, EventAction.LOG_BIOMETRIC_WEAK, getSwid$OneID_release().get(), null, null, null, null, false, Currencies.MDL, null);
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "The device has Biometric Class 2 (Weak) but not Strong, meaning it does not support biometrics for OneID purposes.", null, 4, null);
        }
        return isSupported() && z && getScalpController$OneID_release().isBiometricEnabled();
    }

    static /* synthetic */ Cipher getCipher$default(OneIDBiometricSupport oneIDBiometricSupport, TrackerEventKey trackerEventKey, int i, Object obj) {
        if ((i & 1) != 0) {
            trackerEventKey = null;
        }
        return oneIDBiometricSupport.getCipher(trackerEventKey);
    }

    private final Cipher getCipher(TrackerEventKey trackerEventKey) {
        OneIDTrackerEvent event;
        OneIDTrackerEvent event2;
        try {
            return Cipher.getInstance("AES/CBC/PKCS7Padding");
        } catch (NoSuchAlgorithmException e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.mo1257e(TAG2, "Unable to retrieve instance of cipher", e);
            if (trackerEventKey != null && (event2 = getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                event2.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e.getMessage() + ")");
            }
            return null;
        } catch (NoSuchPaddingException e2) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.mo1257e(TAG3, "Unable to retrieve instance of cipher", e2);
            if (trackerEventKey != null && (event = getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                event.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e2.getMessage() + ")");
            }
            return null;
        }
    }

    private final void updateBridgeResponseAndCompleteTrackingWithError(JSONObject response, String stateKeyToUse, String state, TrackerEventKey trackerEventKey, String errorCategory, String errorCode, boolean problem) {
        try {
            response.put(stateKeyToUse, state);
        } catch (JSONException e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.mo1257e(TAG2, "Invalid json", e);
            OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKey);
            if (event != null) {
                event.appendCodes$OneID_release("INVALID_JSON", OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e.getMessage() + ")");
            }
        }
        Tracker tracker$OneID_release = getTracker$OneID_release();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "state(%s)", Arrays.copyOf(new Object[]{state}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, problem, errorCode, errorCategory, str, false, 32, null);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:19:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d0 A[Catch: InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00ce, KeyPermanentlyInvalidatedException -> 0x011c, TryCatch #4 {KeyPermanentlyInvalidatedException -> 0x011c, InvalidAlgorithmParameterException -> 0x00ce, InvalidKeyException -> 0x00cc, blocks: (B:20:0x00c4, B:26:0x00d8, B:25:0x00d0), top: B:70:0x00bf }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0204  */
    private final boolean authenticateAndDecryptPassword(LightboxActivity lightboxActivity, TrackerEventKey trackerEventKey, JSONObject credentialsJson) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        Cipher cipherAuthenticateAndEnableCipher;
        byte[] bArrDecode;
        String str5 = "Decryption failed.";
        SecretKey secretKeyRetrieveKey = retrieveKey(false);
        if (secretKeyRetrieveKey != null) {
            Cipher cipher = getCipher(trackerEventKey);
            String strOptString = credentialsJson.optString(HintConstants.AUTOFILL_HINT_PASSWORD);
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() > 0) {
                str5 = null;
                String[] strArr = (String[]) StringsKt.split$default((CharSequence) strOptString, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (strArr.length == 2) {
                    String str6 = strArr[0];
                    String str7 = strArr[1];
                    str3 = str6;
                    str2 = OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR;
                    str4 = str7;
                    str = "TAG";
                } else {
                    Logger logger$OneID_release = getLogger$OneID_release();
                    String str8 = TAG;
                    str = "TAG";
                    Intrinsics.checkNotNullExpressionValue(str8, str);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str9 = String.format("Encrypted password is invalid.  Aborting. [%s]", Arrays.copyOf(new Object[]{strOptString}, 1));
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    Logger.DefaultImpls.wtf$default(logger$OneID_release, str8, str9, null, 4, null);
                    OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKey);
                    if (event != null) {
                        str2 = OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR;
                        event.appendCodes$OneID_release(str2, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "invalid(cipherPieces)");
                    } else {
                        str2 = OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR;
                    }
                    cipher = null;
                    str3 = null;
                }
                if (cipher != null) {
                    try {
                        if (str3 != null) {
                            bArrDecode = Base64.decode(str3, 0);
                            Intrinsics.checkNotNull(bArrDecode);
                        } else {
                            bArrDecode = new byte[cipher.getBlockSize()];
                        }
                        cipher.init(2, secretKeyRetrieveKey, new IvParameterSpec(bArrDecode));
                    } catch (KeyPermanentlyInvalidatedException unused) {
                        Logger logger$OneID_release2 = getLogger$OneID_release();
                        String str10 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str10, str);
                        Logger.DefaultImpls.e$default(logger$OneID_release2, str10, "Key permanently invalidated.  Decryption is not possible.", null, 4, null);
                        credentialsJson.remove("username");
                        OneIDTrackerEvent event2 = getTracker$OneID_release().getEvent(trackerEventKey);
                        if (event2 != null) {
                            event2.appendCodes$OneID_release(str2, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "invalid(keyPermanently)");
                        }
                        cipher = null;
                    } catch (InvalidAlgorithmParameterException e) {
                        Logger logger$OneID_release3 = getLogger$OneID_release();
                        String str11 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str11, str);
                        logger$OneID_release3.mo1257e(str11, "Unable to initialize cipher.  Decryption is not possible", e);
                        OneIDTrackerEvent event3 = getTracker$OneID_release().getEvent(trackerEventKey);
                        if (event3 != null) {
                            event3.appendCodes$OneID_release(str2, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "invalid(algorithmParameter)");
                        }
                        cipher = null;
                    } catch (InvalidKeyException e2) {
                        Logger logger$OneID_release4 = getLogger$OneID_release();
                        String str12 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str12, str);
                        logger$OneID_release4.mo1257e(str12, "Unable to initialize cipher.  Decryption is not possible", e2);
                        OneIDTrackerEvent event4 = getTracker$OneID_release().getEvent(trackerEventKey);
                        if (event4 != null) {
                            event4.appendCodes$OneID_release(str2, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "invalid(key)");
                        }
                        cipher = null;
                    }
                    if (cipher == null && (cipherAuthenticateAndEnableCipher = authenticateAndEnableCipher(lightboxActivity, cipher, maskEmailAddress(JSONExtensionsKt.getStringSafely(credentialsJson, "username")), trackerEventKey)) != null) {
                        if (str4 != null) {
                            z = false;
                            try {
                                byte[] bArrDoFinal = cipherAuthenticateAndEnableCipher.doFinal(Base64.decode(str4, 0));
                                Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                                try {
                                    credentialsJson.put(HintConstants.AUTOFILL_HINT_PASSWORD, new String(bArrDoFinal, Charsets.UTF_8));
                                } catch (JSONException e3) {
                                    OneIDTrackerEvent event5 = getTracker$OneID_release().getEvent(trackerEventKey);
                                    if (event5 != null) {
                                        event5.appendCodes$OneID_release("INVALID_JSON", OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e3.getMessage() + ")");
                                    }
                                }
                            } catch (BadPaddingException e4) {
                                Logger logger$OneID_release5 = getLogger$OneID_release();
                                String str13 = TAG;
                                Intrinsics.checkNotNullExpressionValue(str13, str);
                                logger$OneID_release5.mo1257e(str13, str5, e4);
                                OneIDTrackerEvent event6 = getTracker$OneID_release().getEvent(trackerEventKey);
                                if (event6 != null) {
                                    event6.appendCodes$OneID_release(str2, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e4.getMessage() + ")");
                                }
                            } catch (IllegalBlockSizeException e5) {
                                String str14 = str5;
                                Logger logger$OneID_release6 = getLogger$OneID_release();
                                String str15 = TAG;
                                Intrinsics.checkNotNullExpressionValue(str15, str);
                                logger$OneID_release6.mo1257e(str15, str14, e5);
                                OneIDTrackerEvent event7 = getTracker$OneID_release().getEvent(trackerEventKey);
                                if (event7 != null) {
                                    event7.appendCodes$OneID_release(str2, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e5.getMessage() + ")");
                                }
                            }
                        }
                        return true;
                    }
                    z = false;
                } else {
                    z = false;
                }
            } else {
                str = "TAG";
                str2 = OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR;
                str3 = null;
            }
            str4 = str3;
            if (cipher != null) {
                if (str3 != null) {
                    bArrDecode = Base64.decode(str3, 0);
                    Intrinsics.checkNotNull(bArrDecode);
                } else {
                    bArrDecode = new byte[cipher.getBlockSize()];
                }
                cipher.init(2, secretKeyRetrieveKey, new IvParameterSpec(bArrDecode));
                if (cipher == null) {
                    z = false;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        } else {
            z = false;
            credentialsJson.remove("username");
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0090  */
    @Override // com.disney.p026id.android.BiometricSupport
    @NotNull
    public String getBridgeBiometricResponse(@NotNull LightboxActivity lightboxActivity, @NotNull String stateKeyToUse, @Nullable String conversationID) throws JSONException {
        Intrinsics.checkNotNullParameter(lightboxActivity, "lightboxActivity");
        Intrinsics.checkNotNullParameter(stateKeyToUse, "stateKeyToUse");
        if (!isBiometricEnabled(lightboxActivity, conversationID)) {
            return "";
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), conversationID, EventAction.LOG_BIOMETRIC_CHECK, getSwid$OneID_release().get(), null, null, 24, null);
        JSONObject jSONObject = new JSONObject();
        if (isOptedOut()) {
            updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "opted_out", trackerEventKeyStartConversationEvent$default, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false);
        } else {
            JSONObject jSONObjectPut = new JSONObject().put("username", getStorage$OneID_release().get("username")).put(HintConstants.AUTOFILL_HINT_PASSWORD, getStorage$OneID_release().get(HintConstants.AUTOFILL_HINT_PASSWORD));
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
            String strOptString = jSONObjectPut.optString("username");
            String strOptString2 = jSONObjectPut.optString(HintConstants.AUTOFILL_HINT_PASSWORD);
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() == 0) {
                updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "not_initialized", trackerEventKeyStartConversationEvent$default, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false);
            } else {
                Intrinsics.checkNotNull(strOptString2);
                if (strOptString2.length() == 0) {
                    updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "not_initialized", trackerEventKeyStartConversationEvent$default, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false);
                } else {
                    try {
                        jSONObject.put("username", strOptString);
                    } catch (JSONException unused) {
                        updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "not_initialized", trackerEventKeyStartConversationEvent$default, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "INVALID_JSON", true);
                    }
                    if (authenticateAndDecryptPassword(lightboxActivity, trackerEventKeyStartConversationEvent$default, jSONObjectPut)) {
                        String strOptString3 = jSONObjectPut.optString(HintConstants.AUTOFILL_HINT_PASSWORD);
                        Intrinsics.checkNotNull(strOptString3);
                        if (strOptString3.length() > 0) {
                            try {
                                jSONObject.put(HintConstants.AUTOFILL_HINT_PASSWORD, strOptString3);
                                jSONObject.put(stateKeyToUse, OneIDTrackerEvent.EVENT_PARAM_SUCCESS);
                            } catch (JSONException unused2) {
                                updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "not_initialized", trackerEventKeyStartConversationEvent$default, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "INVALID_JSON", true);
                            }
                            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                        } else {
                            updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "not_initialized", trackerEventKeyStartConversationEvent$default, "UNKNOWN_ERROR", "INVALID_JSON", true);
                        }
                    } else if (!jSONObjectPut.has("username")) {
                        jSONObject.remove("username");
                        updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "not_initialized", trackerEventKeyStartConversationEvent$default, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false);
                    } else {
                        updateBridgeResponseAndCompleteTrackingWithError(jSONObject, stateKeyToUse, "cancelled_by_user", trackerEventKeyStartConversationEvent$default, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false);
                    }
                }
            }
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.disney.p026id.android.BiometricSupport
    @Nullable
    public String encryptAfterAuthenticate(@NotNull LightboxActivity lightboxActivity, @Nullable String plainText) {
        Cipher cipher$default;
        Cipher cipherAuthenticateAndEnableCipher;
        Intrinsics.checkNotNullParameter(lightboxActivity, "lightboxActivity");
        if (plainText != null) {
            SecretKey secretKeyRetrieveKey = retrieveKey(true);
            if (secretKeyRetrieveKey == null || (cipher$default = getCipher$default(this, null, 1, null)) == null) {
                return null;
            }
            Cipher cipher = cipher$default;
            boolean z = false;
            SecretKey secretKeyRetrieveKey2 = secretKeyRetrieveKey;
            do {
                if (cipher != null) {
                    try {
                        cipher.init(1, secretKeyRetrieveKey2);
                    } catch (KeyPermanentlyInvalidatedException e) {
                        Logger logger$OneID_release = getLogger$OneID_release();
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        Logger.DefaultImpls.i$default(logger$OneID_release, TAG2, "Key permanently invalidated.  Resetting key.", null, 4, null);
                        if (!z) {
                            deleteKey();
                            secretKeyRetrieveKey2 = retrieveKey(true);
                            z = true;
                        } else {
                            Logger logger$OneID_release2 = getLogger$OneID_release();
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            logger$OneID_release2.mo1258i(TAG2, "Failed to reset key.  Disabling encryption.", e);
                            deleteKey();
                            secretKeyRetrieveKey2 = null;
                            cipher = null;
                        }
                    } catch (InvalidKeyException e2) {
                        Logger logger$OneID_release3 = getLogger$OneID_release();
                        String TAG3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        logger$OneID_release3.mo1257e(TAG3, "Unable to initialize cipher", e2);
                        cipher = null;
                    }
                }
                z = false;
            } while (z);
            if (cipher == null || (cipherAuthenticateAndEnableCipher = authenticateAndEnableCipher(lightboxActivity, cipher, null, null)) == null) {
                return null;
            }
            try {
                String strEncodeToString = Base64.encodeToString(cipherAuthenticateAndEnableCipher.getIV(), 2);
                byte[] bytes = plainText.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return strEncodeToString + ":" + Base64.encodeToString(cipherAuthenticateAndEnableCipher.doFinal(bytes), 2);
            } catch (BadPaddingException e3) {
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG4 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                logger$OneID_release4.mo1257e(TAG4, "Encryption failed.", e3);
                return null;
            } catch (IllegalBlockSizeException e4) {
                Logger logger$OneID_release5 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                logger$OneID_release5.mo1257e(TAG5, "Encryption failed.", e4);
                return null;
            }
        }
        Logger logger$OneID_release6 = getLogger$OneID_release();
        String TAG6 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
        Logger.DefaultImpls.w$default(logger$OneID_release6, TAG6, "Fingerprint authentication not available.  No encryption possible.", null, 4, null);
        return null;
    }

    private final String maskEmailAddress(String emailAddress) {
        String str;
        if (emailAddress == null || !StringsKt.contains$default((CharSequence) emailAddress, (CharSequence) GherkinLanguageConstants.TAG_PREFIX, false, 2, (Object) null)) {
            return null;
        }
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) emailAddress, new String[]{GherkinLanguageConstants.TAG_PREFIX}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (strArr.length != 2 || strArr[0].length() <= 0) {
            return null;
        }
        String str2 = strArr[0];
        int length = str2.length();
        if (length == 1) {
            str = "*";
        } else {
            String strSubstring = str2.substring(0, length > 4 ? 3 : 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            str = strSubstring + "****";
        }
        return str + GherkinLanguageConstants.TAG_PREFIX + strArr[1];
    }

    private final Cipher authenticateAndEnableCipher(LightboxActivity lightboxActivity, final Cipher passedInCipher, String loginId, TrackerEventKey trackerEventKey) {
        OneIDTrackerEvent event;
        OneIDTrackerEvent event2;
        OneIDAuthenticationFuture oneIDAuthenticationFuture = new OneIDAuthenticationFuture(new CancellationSignal());
        final BiometricPrompt biometricPromptCreateBiometricPrompt = createBiometricPrompt(lightboxActivity, oneIDAuthenticationFuture, trackerEventKey);
        final BiometricPrompt.PromptInfo promptInfoCreatePromptInfo = createPromptInfo(loginId);
        lightboxActivity.runOnUiThread(new Runnable() { // from class: com.disney.id.android.OneIDBiometricSupport$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OneIDBiometricSupport.authenticateAndEnableCipher$lambda$0(biometricPromptCreateBiometricPrompt, promptInfoCreatePromptInfo, passedInCipher);
            }
        });
        try {
            return oneIDAuthenticationFuture.get();
        } catch (InterruptedException e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.wtf(TAG2, "Authentication future failed.", e);
            if (trackerEventKey != null && (event2 = getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                event2.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_BIOMETRICS_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e.getMessage() + ")");
            }
            return null;
        } catch (ExecutionException e2) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.wtf(TAG3, "Authentication future failed.", e2);
            if (trackerEventKey != null && (event = getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                event.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_BIOMETRICS_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e2.getMessage() + ")");
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authenticateAndEnableCipher$lambda$0(BiometricPrompt biometricPrompt, BiometricPrompt.PromptInfo promptInfo, Cipher passedInCipher) {
        Intrinsics.checkNotNullParameter(biometricPrompt, "$biometricPrompt");
        Intrinsics.checkNotNullParameter(promptInfo, "$promptInfo");
        Intrinsics.checkNotNullParameter(passedInCipher, "$passedInCipher");
        biometricPrompt.authenticate(promptInfo, new BiometricPrompt.CryptoObject(passedInCipher));
    }

    private final SecretKey retrieveKey(boolean createIfMissing) {
        SecretKey secretKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey("OneIDSecure", null);
            SecretKey secretKey2 = key instanceof SecretKey ? (SecretKey) key : null;
            if (secretKey2 != null || !createIfMissing) {
                return secretKey2;
            }
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, "AndroidKeyStore");
                KeyGenParameterSpec.Builder userAuthenticationRequired = new KeyGenParameterSpec.Builder("OneIDSecure", 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setUserAuthenticationRequired(true);
                Intrinsics.checkNotNullExpressionValue(userAuthenticationRequired, "setUserAuthenticationRequired(...)");
                keyGenerator.init(userAuthenticationRequired.build());
                keyGenerator.generateKey();
                Key key2 = keyStore.getKey("OneIDSecure", null);
                Intrinsics.checkNotNull(key2, "null cannot be cast to non-null type javax.crypto.SecretKey");
                return (SecretKey) key2;
            } catch (IOException e) {
                e = e;
                secretKey = secretKey2;
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.mo1257e(TAG2, "Unable to load keystore", e);
                return secretKey;
            } catch (InvalidAlgorithmParameterException e2) {
                e = e2;
                secretKey = secretKey2;
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger$OneID_release2.mo1257e(TAG3, "Unable to generate key", e);
                return secretKey;
            } catch (KeyStoreException e3) {
                e = e3;
                secretKey = secretKey2;
                Logger logger$OneID_release3 = getLogger$OneID_release();
                String TAG4 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                logger$OneID_release3.mo1257e(TAG4, "Error accessing keystore", e);
                return secretKey;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                secretKey = secretKey2;
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                logger$OneID_release4.mo1257e(TAG5, "Unable to load keystore", e);
                return secretKey;
            } catch (NoSuchProviderException e5) {
                e = e5;
                secretKey = secretKey2;
                Logger logger$OneID_release5 = getLogger$OneID_release();
                String TAG6 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                logger$OneID_release5.mo1257e(TAG6, "Unable to generate key", e);
                return secretKey;
            } catch (UnrecoverableKeyException e6) {
                e = e6;
                secretKey = secretKey2;
                Logger logger$OneID_release6 = getLogger$OneID_release();
                String TAG7 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                logger$OneID_release6.mo1257e(TAG7, "Unable to retrieve key", e);
                return secretKey;
            } catch (CertificateException e7) {
                e = e7;
                secretKey = secretKey2;
                Logger logger$OneID_release7 = getLogger$OneID_release();
                String TAG8 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                logger$OneID_release7.mo1257e(TAG8, "Unable to load keystore", e);
                return secretKey;
            }
        } catch (IOException e8) {
            e = e8;
        } catch (InvalidAlgorithmParameterException e9) {
            e = e9;
        } catch (KeyStoreException e10) {
            e = e10;
        } catch (NoSuchAlgorithmException e11) {
            e = e11;
        } catch (NoSuchProviderException e12) {
            e = e12;
        } catch (UnrecoverableKeyException e13) {
            e = e13;
        } catch (CertificateException e14) {
            e = e14;
        }
    }

    private final void deleteKey() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            Intrinsics.checkNotNullExpressionValue(keyStore, "getInstance(...)");
            keyStore.load(null);
            keyStore.deleteEntry("OneIDSecure");
        } catch (IOException e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.mo1257e(TAG2, "Unable to load keystore.  Key not deleted.", e);
        } catch (KeyStoreException e2) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.mo1257e(TAG3, "Error accessing keystore.  Key not deleted.", e2);
        } catch (NoSuchAlgorithmException e3) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            logger$OneID_release3.mo1257e(TAG4, "Unable to load keystore.  Key not deleted.", e3);
        } catch (CertificateException e4) {
            Logger logger$OneID_release4 = getLogger$OneID_release();
            String TAG5 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            logger$OneID_release4.mo1257e(TAG5, "Unable to load keystore.  Key not deleted.", e4);
        }
    }

    private final BiometricPrompt createBiometricPrompt(LightboxActivity lightboxActivity, final OneIDAuthenticationFuture authFuture, final TrackerEventKey trackerEventKey) {
        Executor mainExecutor = ContextCompat.getMainExecutor(lightboxActivity);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
        return new BiometricPrompt(lightboxActivity, mainExecutor, new BiometricPrompt.AuthenticationCallback() { // from class: com.disney.id.android.OneIDBiometricSupport$createBiometricPrompt$callback$1
            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationError(int errorCode, @NotNull CharSequence errString) {
                OneIDTrackerEvent event;
                OneIDTrackerEvent event2;
                Intrinsics.checkNotNullParameter(errString, "errString");
                super.onAuthenticationError(errorCode, errString);
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDBiometricSupport.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, errorCode + " :: " + ((Object) errString), null, 4, null);
                if (errorCode == 13) {
                    Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                    String str2 = OneIDBiometricSupport.TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release2, str2, "User cancelled biometric authentication prompt", null, 4, null);
                    if (trackerEventKey != null && (event2 = this.this$0.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                        OneIDTrackerEvent.appendCodes$OneID_release$default(event2, "USER_CANCELLED", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, 4, null);
                    }
                } else {
                    Logger logger$OneID_release3 = this.this$0.getLogger$OneID_release();
                    String str3 = OneIDBiometricSupport.TAG;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str4 = String.format(Locale.US, "Unrecoverable authentication error: %d\n%s", Arrays.copyOf(new Object[]{Integer.valueOf(errorCode), errString}, 2));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    Logger.DefaultImpls.e$default(logger$OneID_release3, str3, str4, null, 4, null);
                    if (trackerEventKey != null && (event = this.this$0.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                        event.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_BIOMETRICS_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "errorcode(" + errorCode + "),errorstring(" + ((Object) errString) + ")");
                    }
                }
                authFuture.complete(null);
            }

            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDBiometricSupport.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Biometric read failed.", null, 4, null);
            }

            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationSucceeded(@NotNull BiometricPrompt.AuthenticationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onAuthenticationSucceeded(result);
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDBiometricSupport.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Authentication was successful", null, 4, null);
                OneIDAuthenticationFuture oneIDAuthenticationFuture = authFuture;
                BiometricPrompt.CryptoObject cryptoObject = result.getCryptoObject();
                oneIDAuthenticationFuture.complete(cryptoObject != null ? cryptoObject.getCipher() : null);
            }
        });
    }

    private final BiometricPrompt.PromptInfo createPromptInfo(String loginId) {
        BiometricPrompt.PromptInfo promptInfoBuild = new BiometricPrompt.PromptInfo.Builder().setTitle(getScalpController$OneID_release().getMessage("FINGERPRINT_DIALOG_SIGN_IN")).setDescription(loginId).setConfirmationRequired(false).setNegativeButtonText(getScalpController$OneID_release().getMessage("FINGERPRINT_DIALOG_CANCEL")).build();
        Intrinsics.checkNotNullExpressionValue(promptInfoBuild, "build(...)");
        return promptInfoBuild;
    }
}
