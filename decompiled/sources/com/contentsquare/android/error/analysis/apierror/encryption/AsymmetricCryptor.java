package com.contentsquare.android.error.analysis.apierror.encryption;

import android.util.Base64;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/encryption/AsymmetricCryptor;", "", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "privateKey", "", "(Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;[B)V", "Ljava/security/PrivateKey;", "decrypt", "data", "encrypt", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsymmetricCryptor {

    @NotNull
    private static final String MGF1 = "MGF1";

    @NotNull
    private static final String RSA_ALGORITHM = "RSA";

    @NotNull
    private static final String SHA256 = "SHA-256";

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @Nullable
    private final PrivateKey privateKey;

    public AsymmetricCryptor(ErrorAnalysisLibraryInterface libraryInterface, byte[] bArr) throws InvalidKeySpecException {
        PrivateKey privateKeyGeneratePrivate;
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        this.libraryInterface = libraryInterface;
        if (bArr != null) {
            privateKeyGeneratePrivate = KeyFactory.getInstance(RSA_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(bArr, 0)));
        } else {
            privateKeyGeneratePrivate = null;
        }
        this.privateKey = privateKeyGeneratePrivate;
    }

    @Nullable
    public final byte[] decrypt(byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.privateKey == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, this.privateKey, new OAEPParameterSpec("SHA-256", MGF1, MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        return cipher.doFinal(data);
    }

    @Nullable
    public final byte[] encrypt(byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        JsonConfig.ProjectConfiguration projectConfig;
        Configuration configuration = this.libraryInterface.getConfiguration();
        String encryptionPublicKey = (configuration == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : projectConfig.getEncryptionPublicKey();
        if (encryptionPublicKey == null || data == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(1, KeyFactory.getInstance(RSA_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(encryptionPublicKey, 0))), new OAEPParameterSpec("SHA-256", MGF1, MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        return cipher.doFinal(data);
    }

    public /* synthetic */ AsymmetricCryptor(ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorAnalysisLibraryInterface, (i & 2) != 0 ? null : bArr);
    }
}
