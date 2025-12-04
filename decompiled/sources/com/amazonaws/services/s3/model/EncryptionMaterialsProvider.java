package com.amazonaws.services.s3.model;

@Deprecated
/* loaded from: classes2.dex */
public interface EncryptionMaterialsProvider extends EncryptionMaterialsAccessor {
    EncryptionMaterials getEncryptionMaterials();

    void refresh();
}
