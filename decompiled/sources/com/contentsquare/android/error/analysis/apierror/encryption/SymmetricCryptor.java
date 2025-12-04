package com.contentsquare.android.error.analysis.apierror.encryption;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.GzipUtil;
import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003JO\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "", "key", "", "initializationVector", "([B[B)V", "ivSpec", "Ljavax/crypto/spec/IvParameterSpec;", "getIvSpec$error_analysis_release", "()Ljavax/crypto/spec/IvParameterSpec;", "keySpec", "Ljavax/crypto/spec/SecretKeySpec;", "getKeySpec$error_analysis_release", "()Ljavax/crypto/spec/SecretKeySpec;", "os", "Ljava/io/ByteArrayOutputStream;", "decrypt", "data", "encrypt", "gzip", "", "originalSize", "", "maxSize", "", "onMaxSizeExceeded", "Lkotlin/Function1;", "", "([BZLjava/lang/Integer;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)[B", "generateRandomBytes", TCEventPropertiesNames.TCP_SIZE, "value", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSymmetricCryptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SymmetricCryptor.kt\ncom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
/* loaded from: classes2.dex */
public final class SymmetricCryptor {
    private static final int RANDOM_BYTE_SIZE = 16;

    @NotNull
    private final IvParameterSpec ivSpec;

    @NotNull
    private final SecretKeySpec keySpec;

    @NotNull
    private final ByteArrayOutputStream os;

    public SymmetricCryptor() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final byte[] generateRandomBytes(int size) {
        byte[] bArr = new byte[size];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    private final byte[] gzip(byte[] value) {
        byte[] bArrCompress = null;
        if (value != null) {
            try {
                try {
                    bArrCompress = GzipUtil.INSTANCE.compress(value, this.os);
                } catch (IOException e) {
                    new Logger("NetworkEventCompressor").e("Error while gzipping api error details : " + e);
                }
            } finally {
                this.os.reset();
            }
        }
        return bArrCompress;
    }

    @Nullable
    public final byte[] decrypt(byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (data == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(2, this.keySpec, this.ivSpec);
        return cipher.doFinal(data);
    }

    @Nullable
    public final byte[] encrypt(byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (data == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(1, this.keySpec, this.ivSpec);
        return cipher.doFinal(data);
    }

    @NotNull
    /* renamed from: getIvSpec$error_analysis_release, reason: from getter */
    public final IvParameterSpec getIvSpec() {
        return this.ivSpec;
    }

    @NotNull
    /* renamed from: getKeySpec$error_analysis_release, reason: from getter */
    public final SecretKeySpec getKeySpec() {
        return this.keySpec;
    }

    public SymmetricCryptor(byte[] bArr, byte[] bArr2) {
        this.os = new ByteArrayOutputStream();
        this.keySpec = new SecretKeySpec(bArr == null ? generateRandomBytes(16) : bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        this.ivSpec = new IvParameterSpec(bArr2 == null ? generateRandomBytes(16) : bArr2);
    }

    @Nullable
    public final byte[] encrypt(byte[] data, boolean gzip, Integer originalSize, Long maxSize, Function1<? super Integer, Unit> onMaxSizeExceeded) {
        if (data == null) {
            return null;
        }
        if ((maxSize == null || data.length <= maxSize.longValue()) && !Arrays.equals(data, ApiErrorConstants.INSTANCE.getSUPPRESSED_MESSAGE_MARKER())) {
            if (gzip) {
                data = gzip(data);
            }
            return encrypt(data);
        }
        if (onMaxSizeExceeded != null) {
            onMaxSizeExceeded.invoke(Integer.valueOf(originalSize != null ? originalSize.intValue() : data.length));
        }
        return ApiErrorConstants.INSTANCE.getSUPPRESSED_MESSAGE_MARKER();
    }

    public /* synthetic */ SymmetricCryptor(byte[] bArr, byte[] bArr2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr, (i & 2) != 0 ? null : bArr2);
    }
}
