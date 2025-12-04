package com.disney.id.android.localdata;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.disney.id.android.crypto.BasicCrypto;
import com.disney.id.android.crypto.Crypto;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.channel.AttributeMutation;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0002J\u001f\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u000f\u0012\u0002\b\u00030\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020%H\u0016J\u001c\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0016J(\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010(2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/disney/id/android/localdata/EncryptedSharedPreferences;", "Landroid/content/SharedPreferences;", "wrappedPrefs", "crypto", "Lcom/disney/id/android/crypto/Crypto;", "(Landroid/content/SharedPreferences;Lcom/disney/id/android/crypto/Crypto;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "contains", "", "key", "", "decrypt", "Any", "cipher", "(Ljava/lang/String;)Ljava/lang/Object;", "edit", "Landroid/content/SharedPreferences$Editor;", "encrypt", "type", "", "plainBytes", "", "value", "getAll", "", "getBoolean", "defValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "", "defValues", "", "registerOnSharedPreferenceChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "Companion", "EncryptedEditor", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EncryptedSharedPreferences implements SharedPreferences {

    @NotNull
    public static final String STORAGE_VERSION_KEY = "version";
    private final Crypto crypto;

    @Inject
    public Logger logger;
    private final SharedPreferences wrappedPrefs;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = EncryptedSharedPreferences.class.getSimpleName();

    public EncryptedSharedPreferences(@NotNull SharedPreferences wrappedPrefs, @Nullable Crypto crypto) {
        Intrinsics.checkNotNullParameter(wrappedPrefs, "wrappedPrefs");
        this.wrappedPrefs = wrappedPrefs;
        this.crypto = crypto;
        OneIDDagger.getComponent().inject(this);
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

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/disney/id/android/localdata/EncryptedSharedPreferences$Companion;", "", "()V", "STORAGE_VERSION_CURRENT", "", "STORAGE_VERSION_KEY", "", "TAG", "kotlin.jvm.PlatformType", "TYPE_BOOL", "", "TYPE_FLOAT", "TYPE_INT", "TYPE_LONG", "TYPE_STRING", "getSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "name", "upgradeStorage", "", "unencryptedName", "esp", "upgradeStorage$OneID_release", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final SharedPreferences getSharedPreferences(@NotNull Context context, @Nullable String name) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (name == null) {
                throw new IllegalArgumentException("Shared preferences name cannot be null.");
            }
            BasicCrypto basicCrypto = new BasicCrypto(context, name);
            boolean zIsAvailable = basicCrypto.isAvailable();
            if (!zIsAvailable) {
                if (zIsAvailable) {
                    throw new NoWhenBranchMatchedException();
                }
                basicCrypto = null;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(name + "_enc", 0);
            Intrinsics.checkNotNull(sharedPreferences);
            EncryptedSharedPreferences encryptedSharedPreferences = new EncryptedSharedPreferences(sharedPreferences, basicCrypto);
            upgradeStorage$OneID_release(context, name, encryptedSharedPreferences);
            return encryptedSharedPreferences;
        }

        public final void upgradeStorage$OneID_release(@NotNull Context context, @NotNull String unencryptedName, @NotNull SharedPreferences esp) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(unencryptedName, "unencryptedName");
            Intrinsics.checkNotNullParameter(esp, "esp");
            SharedPreferences sharedPreferences = context.getSharedPreferences(unencryptedName, 0);
            Map<String, ?> all = sharedPreferences.getAll();
            Intrinsics.checkNotNull(all);
            if (!all.isEmpty()) {
                SharedPreferences.Editor editorEdit = esp.edit();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        editorEdit.putString(key, (String) value);
                    } else if (value instanceof Set) {
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                        editorEdit.putStringSet(key, (Set) value);
                    } else if (value instanceof Integer) {
                        editorEdit.putInt(key, ((Number) value).intValue());
                    } else if (value instanceof Boolean) {
                        editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Long) {
                        editorEdit.putLong(key, ((Number) value).longValue());
                    } else if (value instanceof Float) {
                        editorEdit.putFloat(key, ((Number) value).floatValue());
                    }
                }
                editorEdit.putInt("version", 1);
                editorEdit.apply();
                sharedPreferences.edit().clear().apply();
                return;
            }
            if (esp.contains("version")) {
                return;
            }
            SharedPreferences.Editor editorEdit2 = esp.edit();
            editorEdit2.putInt("version", 1);
            editorEdit2.apply();
        }
    }

    @Override // android.content.SharedPreferences
    @NotNull
    public Map<String, ?> getAll() {
        Map<String, ?> all = this.wrappedPrefs.getAll();
        HashMap map = new HashMap();
        if (all != null && !all.isEmpty()) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    Object objDecrypt = decrypt((String) value);
                    if (objDecrypt != null) {
                        Intrinsics.checkNotNull(key);
                        map.put(key, objDecrypt);
                    } else {
                        Logger logger$OneID_release = getLogger$OneID_release();
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        Logger.DefaultImpls.wtf$default(logger$OneID_release, TAG2, "Impossible to decrypt value: " + value, null, 4, null);
                    }
                } else {
                    Logger logger$OneID_release2 = getLogger$OneID_release();
                    String TAG3 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    Logger.DefaultImpls.wtf$default(logger$OneID_release2, TAG3, "Non-string entry found for key: " + key, null, 4, null);
                }
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(@NotNull String key, @Nullable String defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        String str = (String) decrypt(this.wrappedPrefs.getString(key, null));
        return str == null ? defValue : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.HashSet] */
    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(@NotNull String key, @Nullable Set<String> defValues) {
        Intrinsics.checkNotNullParameter(key, "key");
        Set<String> stringSet = this.wrappedPrefs.getStringSet(key, null);
        if (stringSet != null) {
            defValues = new HashSet<>(stringSet.size());
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                Object objDecrypt = decrypt(it.next());
                Intrinsics.checkNotNull(objDecrypt, "null cannot be cast to non-null type kotlin.String");
                defValues.add((String) objDecrypt);
            }
        }
        return defValues;
    }

    @Override // android.content.SharedPreferences
    public int getInt(@NotNull String key, int defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Integer num = (Integer) decrypt(this.wrappedPrefs.getString(key, null));
        return num != null ? num.intValue() : defValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(@NotNull String key, long defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Long l = (Long) decrypt(this.wrappedPrefs.getString(key, null));
        return l != null ? l.longValue() : defValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(@NotNull String key, float defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Float f = (Float) decrypt(this.wrappedPrefs.getString(key, null));
        return f != null ? f.floatValue() : defValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(@NotNull String key, boolean defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Boolean bool = (Boolean) decrypt(this.wrappedPrefs.getString(key, null));
        return bool != null ? bool.booleanValue() : defValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.wrappedPrefs.contains(key);
    }

    @Override // android.content.SharedPreferences
    @NotNull
    public SharedPreferences.Editor edit() {
        return new EncryptedEditor();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.wrappedPrefs.registerOnSharedPreferenceChangeListener(listener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(@NotNull SharedPreferences.OnSharedPreferenceChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.wrappedPrefs.unregisterOnSharedPreferenceChangeListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String encrypt(String value) {
        byte[] bArr = null;
        if (value != null) {
            try {
                Charset charsetForName = Charset.forName("UTF8");
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                byte[] bytes = value.getBytes(charsetForName);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                bArr = bytes;
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return encrypt((byte) 0, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String encrypt(byte type, byte[] plainBytes) {
        byte[] bArrEncrypt;
        if (plainBytes == null) {
            return null;
        }
        byte[] bArr = new byte[plainBytes.length + 1];
        bArr[0] = type;
        System.arraycopy(plainBytes, 0, bArr, 1, plainBytes.length);
        Crypto crypto = this.crypto;
        if (crypto != null) {
            try {
                bArrEncrypt = crypto.encrypt(bArr);
            } catch (GeneralSecurityException e) {
                Logger logger$OneID_release = this.getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "CryptoProvider error during encryption", e);
                bArrEncrypt = null;
            }
            if (bArrEncrypt != null) {
                return Base64.encodeToString(bArrEncrypt, 0);
            }
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    private final Object decrypt(String cipher) {
        byte[] bArrDecode;
        if (cipher != null) {
            try {
                Charset charsetForName = Charset.forName("UTF8");
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                byte[] bytes = cipher.getBytes(charsetForName);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                bArrDecode = Base64.decode(bytes, 0);
            } catch (UnsupportedEncodingException unused) {
            } catch (IllegalArgumentException e) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "Failed to decode bytes", e);
            }
        } else {
            bArrDecode = null;
        }
        Crypto crypto = this.crypto;
        if (crypto != null && bArrDecode != null) {
            try {
                bArrDecode = crypto.decrypt(bArrDecode);
            } catch (GeneralSecurityException e2) {
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger$OneID_release2.e(TAG3, "CryptoProvider error during decryption", e2);
                bArrDecode = null;
            }
        }
        if (bArrDecode == null) {
            return null;
        }
        byte b = bArrDecode[0];
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDecode, 1, bArrDecode.length);
        if (b == 1) {
            try {
                return Integer.valueOf(ByteBuffer.wrap(bArrCopyOfRange).getInt());
            } catch (BufferUnderflowException e3) {
                Logger logger$OneID_release3 = getLogger$OneID_release();
                String TAG4 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                logger$OneID_release3.e(TAG4, "Failed to get int value", e3);
                return null;
            }
        }
        if (b == 2) {
            try {
                return Long.valueOf(ByteBuffer.wrap(bArrCopyOfRange).getLong());
            } catch (BufferUnderflowException e4) {
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                logger$OneID_release4.e(TAG5, "Failed to get long value", e4);
                return null;
            }
        }
        if (b == 3) {
            try {
                return Float.valueOf(ByteBuffer.wrap(bArrCopyOfRange).getFloat());
            } catch (BufferUnderflowException e5) {
                Logger logger$OneID_release5 = getLogger$OneID_release();
                String TAG6 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                logger$OneID_release5.e(TAG6, "Failed to get float value", e5);
                return null;
            }
        }
        if (b == 4) {
            return Boolean.valueOf(bArrCopyOfRange[0] == 1);
        }
        if (b == 0) {
            try {
                Intrinsics.checkNotNull(bArrCopyOfRange);
                Charset charsetForName2 = Charset.forName("UTF8");
                Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(...)");
                return new String(bArrCopyOfRange, charsetForName2);
            } catch (UnsupportedEncodingException e6) {
                Logger logger$OneID_release6 = getLogger$OneID_release();
                String TAG7 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                logger$OneID_release6.wtf(TAG7, "Failed to convert bytes", e6);
                return null;
            }
        }
        Logger logger$OneID_release7 = getLogger$OneID_release();
        String TAG8 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
        Logger.DefaultImpls.e$default(logger$OneID_release7, TAG8, "Decryption returned data of an unknown type. " + Byte.toString(b), null, 4, null);
        return null;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0001¢\u0006\u0002\u0010\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/disney/id/android/localdata/EncryptedSharedPreferences$EncryptedEditor;", "Landroid/content/SharedPreferences$Editor;", "(Lcom/disney/id/android/localdata/EncryptedSharedPreferences;)V", "editor", "apply", "", "clear", "commit", "", "putBoolean", "key", "", "value", "putFloat", "", "putInt", "", "putLong", "", "putString", "putStringSet", "values", "", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class EncryptedEditor implements SharedPreferences.Editor {
        private final SharedPreferences.Editor editor;

        @SuppressLint({"CommitPrefEdits"})
        public EncryptedEditor() {
            SharedPreferences.Editor editorEdit = EncryptedSharedPreferences.this.wrappedPrefs.edit();
            Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
            this.editor = editorEdit;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putString(@NotNull String key, @Nullable String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.editor.putString(key, EncryptedSharedPreferences.this.encrypt(value));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putStringSet(@NotNull String key, @Nullable Set<String> values) {
            HashSet hashSet;
            Intrinsics.checkNotNullParameter(key, "key");
            if (values != null) {
                hashSet = new HashSet(values.size());
                Iterator<String> it = values.iterator();
                while (it.hasNext()) {
                    hashSet.add(String.valueOf(EncryptedSharedPreferences.this.encrypt(it.next())));
                }
            } else {
                hashSet = null;
            }
            this.editor.putStringSet(key, hashSet);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putInt(@NotNull String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.editor.putString(key, EncryptedSharedPreferences.this.encrypt((byte) 1, ByteBuffer.allocate(4).putInt(value).array()));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putLong(@NotNull String key, long value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.editor.putString(key, EncryptedSharedPreferences.this.encrypt((byte) 2, ByteBuffer.allocate(8).putLong(value).array()));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putFloat(@NotNull String key, float value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.editor.putString(key, EncryptedSharedPreferences.this.encrypt((byte) 3, ByteBuffer.allocate(4).putFloat(value).array()));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor putBoolean(@NotNull String key, boolean value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.editor.putString(key, EncryptedSharedPreferences.this.encrypt((byte) 4, new byte[]{value ? (byte) 1 : (byte) 0}));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor remove(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.editor.remove(key);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @NotNull
        public SharedPreferences.Editor clear() {
            this.editor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.editor.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.editor.apply();
        }
    }
}
