package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.exceptions.AlStorageException;
import com.allegion.alsecurity.AlSecureStorage;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.altranslation.AlJsonUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import java.io.Serializable;

/* loaded from: classes2.dex */
class AlStorageService implements IAlStorageService {
    AlStorageService() {
    }

    @Override // com.allegion.accesssdk.actions.IAlStorageService
    public boolean contains(String str) {
        AlObjects.requireNonNull(str, "Key must not be null", AlErrorCode.SDK_STORAGE_ERROR);
        return new AlSecureStorage(AlSdkConfiguration.getConfig().getContext(), AlSdkConfiguration.getConfig().getKeyManagement()).contains(str);
    }

    @Override // com.allegion.accesssdk.actions.IAlStorageService
    public void remove(String str) {
        AlObjects.requireNonNull(str, "Key must not be null", AlErrorCode.SDK_STORAGE_ERROR);
        new AlSecureStorage(AlSdkConfiguration.getConfig().getContext(), AlSdkConfiguration.getConfig().getKeyManagement()).remove(str);
    }

    @Override // com.allegion.accesssdk.actions.IAlStorageService
    public <T extends Serializable> T retrieve(String str, Class<T> cls) {
        AlObjects.requireNonNull(str, "Key must not be null", AlErrorCode.SDK_STORAGE_ERROR);
        try {
            return (T) new AlJsonUtility().fromJson(new AlSecureStorage(AlSdkConfiguration.getConfig().getContext(), AlSdkConfiguration.getConfig().getKeyManagement()).retrieve(str), cls);
        } catch (AlSecurityException | AlTranslationComponentException e) {
            throw new AlStorageException(e);
        }
    }

    @Override // com.allegion.accesssdk.actions.IAlStorageService
    public <T extends Serializable> void store(String str, T t) {
        AlObjects.requireNonNull(str, "Key must not be null", AlErrorCode.SDK_STORAGE_ERROR);
        try {
            new AlSecureStorage(AlSdkConfiguration.getConfig().getContext(), AlSdkConfiguration.getConfig().getKeyManagement()).store(str, new AlJsonUtility().toJson(t));
        } catch (AlSecurityException | AlTranslationComponentException e) {
            throw new AlStorageException(e);
        }
    }
}
