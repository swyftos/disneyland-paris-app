package com.amazonaws.services.p017s3.model;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface EncryptionMaterialsProvider extends EncryptionMaterialsAccessor {
    EncryptionMaterials getEncryptionMaterials();

    void refresh();
}
