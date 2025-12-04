package com.disney.id.android.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import com.disney.id.android.crypto.AesCbcWithIntegrity;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/disney/id/android/crypto/BasicCrypto;", "Lcom/disney/id/android/crypto/Crypto;", "context", "Landroid/content/Context;", "entity", "", "(Landroid/content/Context;Ljava/lang/String;)V", "keys", "Lcom/disney/id/android/crypto/AesCbcWithIntegrity$SecretKeys;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "decrypt", "", "cipherBytes", "encrypt", "plainBytes", "isAvailable", "", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BasicCrypto implements Crypto {

    @NotNull
    public static final String KEY_STORAGE_FILE_PREFIX = "bc_keys_";

    @NotNull
    public static final String KEY_STORAGE_KEY = "key";
    private AesCbcWithIntegrity.SecretKeys keys;

    @Inject
    public Logger logger;
    private static final String TAG = BasicCrypto.class.getSimpleName();

    public BasicCrypto(@NotNull Context context, @NotNull String entity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        OneIDDagger.getComponent().inject(this);
        if (entity.length() == 0) {
            throw new IllegalArgumentException("Entity must be a non-blank value");
        }
        if (entity.length() > 100 || !new Regex("^[a-zA-Z0-9_.\\-]+$").matches(entity)) {
            throw new IllegalArgumentException("Entity must be 100 characters or less and contain only letters, numbers, underscore, hyphen, or period.");
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_STORAGE_FILE_PREFIX + entity, 0);
        if (sharedPreferences.contains("key")) {
            try {
                this.keys = AesCbcWithIntegrity.keys(sharedPreferences.getString("key", ""));
            } catch (IllegalArgumentException e) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "Unable to recreate keys.  Generating new keys.", e);
            }
        }
        if (this.keys == null) {
            try {
                this.keys = AesCbcWithIntegrity.generateKey();
                sharedPreferences.edit().putString("key", AesCbcWithIntegrity.keyString(this.keys)).apply();
            } catch (GeneralSecurityException unused) {
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "Unable to generate keys.  Disable crypto.", null, 4, null);
            }
        }
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

    @Override // com.disney.id.android.crypto.Crypto
    public boolean isAvailable() {
        return this.keys != null;
    }

    @Override // com.disney.id.android.crypto.Crypto
    @Nullable
    public byte[] encrypt(@NotNull byte[] plainBytes) throws GeneralSecurityException {
        Intrinsics.checkNotNullParameter(plainBytes, "plainBytes");
        AesCbcWithIntegrity.SecretKeys secretKeys = this.keys;
        if (secretKeys == null) {
            return null;
        }
        String string = AesCbcWithIntegrity.encrypt(plainBytes, secretKeys).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Charset charsetForName = Charset.forName("UTF8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        byte[] bytes = string.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @Override // com.disney.id.android.crypto.Crypto
    @Nullable
    public byte[] decrypt(@NotNull byte[] cipherBytes) throws GeneralSecurityException {
        Intrinsics.checkNotNullParameter(cipherBytes, "cipherBytes");
        if (this.keys == null) {
            return null;
        }
        Charset charsetForName = Charset.forName("UTF8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        return AesCbcWithIntegrity.decrypt(new AesCbcWithIntegrity.CipherTextIvMac(new String(cipherBytes, charsetForName)), this.keys);
    }
}
