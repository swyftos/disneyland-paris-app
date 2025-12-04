package com.disney.id.android;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.util.Base64;
import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.core.os.CancellationSignal;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.contentsquare.android.api.Currencies;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
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
import org.picocontainer.Characteristics;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J.\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\"\u0010.\u001a\u00020/2\u0006\u0010#\u001a\u00020$2\u0006\u00100\u001a\u0002012\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u00102\u001a\u0002032\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u00104\u001a\u000205H\u0002J\u001c\u00106\u001a\u0004\u0018\u00010-2\u0006\u0010#\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u00010-H\u0016J\"\u00108\u001a\u00020-2\u0006\u0010#\u001a\u00020$2\u0006\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010-H\u0016J\u0016\u0010;\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u001a\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>2\b\u0010:\u001a\u0004\u0018\u00010-H\u0016J\b\u0010?\u001a\u00020\"H\u0016J\b\u0010@\u001a\u00020\"H\u0003J\u0014\u0010A\u001a\u0004\u0018\u00010-2\b\u0010B\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\"H\u0002JD\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020(2\u0006\u00109\u001a\u00020-2\u0006\u0010H\u001a\u00020-2\u0006\u0010%\u001a\u00020&2\b\u0010I\u001a\u0004\u0018\u00010-2\b\u0010J\u001a\u0004\u0018\u00010-2\u0006\u0010K\u001a\u00020\"H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006M"}, d2 = {"Lcom/disney/id/android/OneIDBiometricSupport;", "Lcom/disney/id/android/BiometricSupport;", "()V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "scalpController", "Lcom/disney/id/android/SCALPController;", "getScalpController$OneID_release", "()Lcom/disney/id/android/SCALPController;", "setScalpController$OneID_release", "(Lcom/disney/id/android/SCALPController;)V", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "authenticateAndDecryptPassword", "", "lightboxActivity", "Lcom/disney/id/android/lightbox/LightboxActivity;", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "credentialsJson", "Lorg/json/JSONObject;", "authenticateAndEnableCipher", "Ljavax/crypto/Cipher;", "passedInCipher", "loginId", "", "createBiometricPrompt", "Landroidx/biometric/BiometricPrompt;", "authFuture", "Lcom/disney/id/android/OneIDAuthenticationFuture;", "createPromptInfo", "Landroidx/biometric/BiometricPrompt$PromptInfo;", "deleteKey", "", "encryptAfterAuthenticate", "plainText", "getBridgeBiometricResponse", "stateKeyToUse", "conversationID", "getCipher", "isBiometricEnabled", "context", "Landroid/content/Context;", "isOptedOut", "isSupported", "maskEmailAddress", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, "retrieveKey", "Ljavax/crypto/SecretKey;", "createIfMissing", "updateBridgeResponseAndCompleteTrackingWithError", "response", BluetoothManager.BLE_STATUS_PARAM, "errorCategory", "errorCode", OneIDTrackerEvent.EVENT_PARAM_PROBLEM, "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneIDBiometricSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDBiometricSupport.kt\ncom/disney/id/android/OneIDBiometricSupport\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,840:1\n37#2,2:841\n37#2,2:843\n*S KotlinDebug\n*F\n+ 1 OneIDBiometricSupport.kt\ncom/disney/id/android/OneIDBiometricSupport\n*L\n244#1:841,2\n588#1:843,2\n*E\n"})
/* loaded from: classes3.dex */
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

    @Override // com.disney.id.android.BiometricSupport
    public boolean isOptedOut() {
        return Intrinsics.areEqual(getScalpController$OneID_release().getBundleVersion(), "v2") ? isSupported() && Intrinsics.areEqual(getStorage$OneID_release().get("touchOptOut"), Characteristics.TRUE) : isSupported() && Intrinsics.areEqual(getStorage$OneID_release().get("biometricsOptOut"), Characteristics.TRUE);
    }

    @Override // com.disney.id.android.BiometricSupport
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
            Logger logger$OneID_release = this.getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.e(TAG2, "Unable to retrieve instance of cipher", e);
            if (trackerEventKey != null && (event2 = this.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                event2.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e.getMessage() + ")");
            }
            return null;
        } catch (NoSuchPaddingException e2) {
            Logger logger$OneID_release2 = this.getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.e(TAG3, "Unable to retrieve instance of cipher", e2);
            if (trackerEventKey != null && (event = this.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                event.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_CRYPTOGRAPHY_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e2.getMessage() + ")");
            }
            return null;
        }
    }

    private final void updateBridgeResponseAndCompleteTrackingWithError(JSONObject response, String stateKeyToUse, String state, TrackerEventKey trackerEventKey, String errorCategory, String errorCode, boolean problem) throws JSONException {
        try {
            response.put(stateKeyToUse, state);
        } catch (JSONException e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.e(TAG2, "Invalid json", e);
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0204  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean authenticateAndDecryptPassword(com.disney.id.android.lightbox.LightboxActivity r32, com.disney.id.android.tracker.TrackerEventKey r33, org.json.JSONObject r34) throws javax.crypto.BadPaddingException, org.json.JSONException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException, java.io.IOException, java.security.InvalidKeyException, java.security.KeyStoreException, java.security.cert.CertificateException, java.security.NoSuchProviderException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneIDBiometricSupport.authenticateAndDecryptPassword(com.disney.id.android.lightbox.LightboxActivity, com.disney.id.android.tracker.TrackerEventKey, org.json.JSONObject):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    @Override // com.disney.id.android.BiometricSupport
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getBridgeBiometricResponse(@org.jetbrains.annotations.NotNull com.disney.id.android.lightbox.LightboxActivity r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.Nullable java.lang.String r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneIDBiometricSupport.getBridgeBiometricResponse(com.disney.id.android.lightbox.LightboxActivity, java.lang.String, java.lang.String):java.lang.String");
    }

    @Override // com.disney.id.android.BiometricSupport
    @Nullable
    public String encryptAfterAuthenticate(@NotNull LightboxActivity lightboxActivity, @Nullable String plainText) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, InvalidKeyException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
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
                            logger$OneID_release2.i(TAG2, "Failed to reset key.  Disabling encryption.", e);
                            deleteKey();
                            secretKeyRetrieveKey2 = null;
                            cipher = null;
                        }
                    } catch (InvalidKeyException e2) {
                        Logger logger$OneID_release3 = getLogger$OneID_release();
                        String TAG3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        logger$OneID_release3.e(TAG3, "Unable to initialize cipher", e2);
                        cipher = null;
                    }
                    z = false;
                } else {
                    z = false;
                }
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
                logger$OneID_release4.e(TAG4, "Encryption failed.", e3);
                return null;
            } catch (IllegalBlockSizeException e4) {
                Logger logger$OneID_release5 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                logger$OneID_release5.e(TAG5, "Encryption failed.", e4);
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
            Logger logger$OneID_release = this.getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.wtf(TAG2, "Authentication future failed.", e);
            if (trackerEventKey != null && (event2 = this.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                event2.appendCodes$OneID_release(OneIDTrackerEvent.ERROR_CODE_BIOMETRICS_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e.getMessage() + ")");
            }
            return null;
        } catch (ExecutionException e2) {
            Logger logger$OneID_release2 = this.getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.wtf(TAG3, "Authentication future failed.", e2);
            if (trackerEventKey != null && (event = this.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
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

    private final SecretKey retrieveKey(boolean createIfMissing) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
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
                logger$OneID_release.e(TAG2, "Unable to load keystore", e);
                return secretKey;
            } catch (InvalidAlgorithmParameterException e2) {
                e = e2;
                secretKey = secretKey2;
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger$OneID_release2.e(TAG3, "Unable to generate key", e);
                return secretKey;
            } catch (KeyStoreException e3) {
                e = e3;
                secretKey = secretKey2;
                Logger logger$OneID_release3 = getLogger$OneID_release();
                String TAG4 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                logger$OneID_release3.e(TAG4, "Error accessing keystore", e);
                return secretKey;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                secretKey = secretKey2;
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                logger$OneID_release4.e(TAG5, "Unable to load keystore", e);
                return secretKey;
            } catch (NoSuchProviderException e5) {
                e = e5;
                secretKey = secretKey2;
                Logger logger$OneID_release5 = getLogger$OneID_release();
                String TAG6 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                logger$OneID_release5.e(TAG6, "Unable to generate key", e);
                return secretKey;
            } catch (UnrecoverableKeyException e6) {
                e = e6;
                secretKey = secretKey2;
                Logger logger$OneID_release6 = getLogger$OneID_release();
                String TAG7 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                logger$OneID_release6.e(TAG7, "Unable to retrieve key", e);
                return secretKey;
            } catch (CertificateException e7) {
                e = e7;
                secretKey = secretKey2;
                Logger logger$OneID_release7 = getLogger$OneID_release();
                String TAG8 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                logger$OneID_release7.e(TAG8, "Unable to load keystore", e);
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

    private final void deleteKey() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            Intrinsics.checkNotNullExpressionValue(keyStore, "getInstance(...)");
            keyStore.load(null);
            keyStore.deleteEntry("OneIDSecure");
        } catch (IOException e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.e(TAG2, "Unable to load keystore.  Key not deleted.", e);
        } catch (KeyStoreException e2) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.e(TAG3, "Error accessing keystore.  Key not deleted.", e2);
        } catch (NoSuchAlgorithmException e3) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            logger$OneID_release3.e(TAG4, "Unable to load keystore.  Key not deleted.", e3);
        } catch (CertificateException e4) {
            Logger logger$OneID_release4 = getLogger$OneID_release();
            String TAG5 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            logger$OneID_release4.e(TAG5, "Unable to load keystore.  Key not deleted.", e4);
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
