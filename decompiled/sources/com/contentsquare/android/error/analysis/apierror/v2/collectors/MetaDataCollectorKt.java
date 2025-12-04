package com.contentsquare.android.error.analysis.apierror.v2.collectors;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.encryption.AsymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.v2.AggregatedRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000¨\u0006\n"}, d2 = {"collectMetaDataV2", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "aggregatedRules", "Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "asymmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/AsymmetricCryptor;", "config", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMetaDataCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MetaDataCollector.kt\ncom/contentsquare/android/error/analysis/apierror/v2/collectors/MetaDataCollectorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
/* loaded from: classes2.dex */
public final class MetaDataCollectorKt {
    @NotNull
    public static final NetworkEvent collectMetaDataV2(NetworkEvent networkEvent, AggregatedRules aggregatedRules, SymmetricCryptor symmetricCryptor, AsymmetricCryptor asymmetricCryptor, JsonConfig.ProjectConfiguration projectConfiguration) {
        Integer encryptionPublicKeyId;
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(aggregatedRules, "aggregatedRules");
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(asymmetricCryptor, "asymmetricCryptor");
        boolean zAnyValuesEncrypted = aggregatedRules.anyValuesEncrypted();
        List<String> matchingBodyContents = aggregatedRules.getMatchingBodyContents();
        return NetworkEvent.copy$default(networkEvent, 0L, null, null, 0, 0L, 0L, null, null, null, null, null, null, null, null, null, zAnyValuesEncrypted ? symmetricCryptor.getIvSpec().getIV() : null, zAnyValuesEncrypted ? asymmetricCryptor.encrypt(symmetricCryptor.getKeySpec().getEncoded()) : null, (!zAnyValuesEncrypted || projectConfiguration == null || (encryptionPublicKeyId = projectConfiguration.getEncryptionPublicKeyId()) == null) ? null : Long.valueOf(encryptionPublicKeyId.intValue()), null, null, "native", matchingBodyContents.isEmpty() ? null : matchingBodyContents, null, null, null, null, null, null, 265060351, null);
    }
}
