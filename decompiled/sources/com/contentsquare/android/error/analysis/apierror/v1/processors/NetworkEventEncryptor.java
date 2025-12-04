package com.contentsquare.android.error.analysis.apierror.v1.processors;

import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.encryption.AsymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.NoSuchPaddingException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventEncryptor;", "", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "asymmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/AsymmetricCryptor;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "(Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;Lcom/contentsquare/android/error/analysis/apierror/encryption/AsymmetricCryptor;Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;)V", "encrypt", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "rawEvent", "encryptDetail", "", ErrorBundle.DETAIL_ENTRY, "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkEventEncryptor {

    @NotNull
    private final AsymmetricCryptor asymmetricCryptor;

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @NotNull
    private final SymmetricCryptor symmetricCryptor;

    public NetworkEventEncryptor(SymmetricCryptor symmetricCryptor, AsymmetricCryptor asymmetricCryptor, ErrorAnalysisLibraryInterface libraryInterface) {
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(asymmetricCryptor, "asymmetricCryptor");
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        this.symmetricCryptor = symmetricCryptor;
        this.asymmetricCryptor = asymmetricCryptor;
        this.libraryInterface = libraryInterface;
    }

    private final byte[] encryptDetail(byte[] details) {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = "…".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        if (Arrays.equals(details, bytes)) {
            return details;
        }
        byte[] bytes2 = "".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        return Arrays.equals(details, bytes2) ? details : this.symmetricCryptor.encrypt(details);
    }

    @NotNull
    public final NetworkEvent encrypt(NetworkEvent rawEvent) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        JsonConfig.ProjectConfiguration projectConfig;
        Integer encryptionPublicKeyId;
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        byte[] bArrEncryptDetail = encryptDetail(rawEvent.getRequestBody());
        byte[] bArrEncryptDetail2 = encryptDetail(rawEvent.getResponseBody());
        byte[] bArrEncryptDetail3 = encryptDetail(rawEvent.getCustomRequestHeaders());
        byte[] bArrEncryptDetail4 = encryptDetail(rawEvent.getCustomResponseHeaders());
        byte[] bArrEncryptDetail5 = encryptDetail(rawEvent.getQueryParameters());
        byte[] iv = this.symmetricCryptor.getIvSpec().getIV();
        byte[] bArrEncrypt = this.asymmetricCryptor.encrypt(this.symmetricCryptor.getKeySpec().getEncoded());
        Configuration configuration = this.libraryInterface.getConfiguration();
        return NetworkEvent.copy$default(rawEvent, 0L, null, null, 0, 0L, 0L, bArrEncryptDetail, null, bArrEncryptDetail2, null, null, null, bArrEncryptDetail3, bArrEncryptDetail4, bArrEncryptDetail5, iv, bArrEncrypt, Long.valueOf((configuration == null || (projectConfig = configuration.getProjectConfig()) == null || (encryptionPublicKeyId = projectConfig.getEncryptionPublicKeyId()) == null) ? 0L : encryptionPublicKeyId.intValue()), null, null, null, null, null, null, null, null, null, null, 268177087, null);
    }
}
