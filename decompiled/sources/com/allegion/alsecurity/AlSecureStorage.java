package com.allegion.alsecurity;

import android.content.Context;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.alsecurity.interfaces.IAlSecureStorage;
import com.urbanairship.channel.AttributeMutation;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/allegion/alsecurity/AlSecureStorage;", "Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "keyManagement", "Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "(Landroid/content/Context;Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;)V", "sharedPreferences", "Lcom/allegion/alsecurity/AlSharedPreferences;", "contains", "", "key", "", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "", "retrieve", "store", "data", "Companion", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlSecureStorage implements IAlSecureStorage {
    private final IAlKeyManagement keyManagement;
    private final AlSharedPreferences sharedPreferences;
    private static final String EXCEPTION_CONTEXT_NULL = "Context is null";
    private static final String EXCEPTION_REFERENCE_NULL = "Reference key is null";
    private static final String EXCEPTION_DATA_NULL = "Data is null";
    private static final String STORAGE_NAMESPACE = "com.allegion.storage.secure";
    private static final String EXT_LENGTH = ".length";

    public AlSecureStorage(@NotNull Context context) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Objects.requireNonNull(context, EXCEPTION_CONTEXT_NULL);
        this.sharedPreferences = new AlSharedPreferences(context, STORAGE_NAMESPACE);
        this.keyManagement = new AlKeyManagement(context, false, null, 4, null);
    }

    public AlSecureStorage(@NotNull Context context, @NotNull IAlKeyManagement keyManagement) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(keyManagement, "keyManagement");
        Objects.requireNonNull(context, EXCEPTION_CONTEXT_NULL);
        this.sharedPreferences = new AlSharedPreferences(context, STORAGE_NAMESPACE);
        Objects.requireNonNull(keyManagement, "Key Management cannot be null");
        Intrinsics.checkExpressionValueIsNotNull(keyManagement, "Objects.requireNonNull(k…nagement cannot be null\")");
        this.keyManagement = keyManagement;
    }

    @Override // com.allegion.alsecurity.interfaces.IAlSecureStorage
    public void store(@NotNull String key, @NotNull String data) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Objects.requireNonNull(key, EXCEPTION_REFERENCE_NULL);
        Objects.requireNonNull(data, EXCEPTION_DATA_NULL);
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrEncryptData = this.keyManagement.encryptData(bytes, STORAGE_NAMESPACE + '.' + key);
        this.sharedPreferences.storeInteger(bytes.length, key + EXT_LENGTH);
        this.sharedPreferences.storeByteArray(bArrEncryptData, key);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlSecureStorage
    public boolean contains(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Objects.requireNonNull(key, EXCEPTION_REFERENCE_NULL);
        return this.sharedPreferences.containsData(key);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlSecureStorage
    @NotNull
    public String retrieve(@NotNull String key) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Objects.requireNonNull(key, EXCEPTION_REFERENCE_NULL);
        byte[] bArrRetrieveByteArray = this.sharedPreferences.retrieveByteArray(key);
        try {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(this.keyManagement.decryptData(bArrRetrieveByteArray, STORAGE_NAMESPACE + '.' + key), 0, this.sharedPreferences.retrieveInteger(key + EXT_LENGTH));
            Intrinsics.checkExpressionValueIsNotNull(bArrCopyOfRange, "Arrays.copyOfRange(decryptedData, 0, length)");
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charsetName)");
            return new String(bArrCopyOfRange, charsetForName);
        } catch (UnsupportedEncodingException e) {
            throw new AlSecurityException(e);
        }
    }

    @Override // com.allegion.alsecurity.interfaces.IAlSecureStorage
    public void remove(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Objects.requireNonNull(key, EXCEPTION_REFERENCE_NULL);
        this.sharedPreferences.removeData(key + EXT_LENGTH);
        this.sharedPreferences.removeData(key);
    }
}
