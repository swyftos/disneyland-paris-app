package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.altranslation.AlCborUtility;
import com.allegion.altranslation.interfaces.IAlCborUtility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\b\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "protocolVersion", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "getProtocolVersion$AccessBleCredential_release", "()Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "setProtocolVersion$AccessBleCredential_release", "(Lcom/allegion/accessblecredential/enums/AlProtocolVersion;)V", "Ljava/io/ByteArrayOutputStream;", "stream", "Ljava/io/ByteArrayOutputStream;", "getStream$AccessBleCredential_release", "()Ljava/io/ByteArrayOutputStream;", "Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "generator", "Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "getGenerator$AccessBleCredential_release", "()Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "setGenerator$AccessBleCredential_release", "(Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;)V", "Lcom/allegion/altranslation/interfaces/IAlCborUtility;", "cborUtility", "Lcom/allegion/altranslation/interfaces/IAlCborUtility;", "getCborUtility$AccessBleCredential_release", "()Lcom/allegion/altranslation/interfaces/IAlCborUtility;", "<init>", "(Lcom/allegion/altranslation/interfaces/IAlCborUtility;)V", "Companion", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public abstract class AlCBORMessage {

    @NotNull
    public static final String CHALLENGE_MSG = "challenge";

    @NotNull
    public static final String CRED_BLOB = "credBlob";

    @NotNull
    public static final String DEVICE_AUTH_KEY = "devAuthKey";

    @NotNull
    public static final String DEVICE_AUTH_SIG = "devAuthSig";

    @NotNull
    public static final String ENC_PAYLOAD = "encPayload";

    @NotNull
    public static final String GEN_MSG_TYPE = "genMsgType";

    @NotNull
    public static final String KEY_ID = "keyId";

    @NotNull
    public static final String MAX_SIZE = "genMaxSz";

    @NotNull
    public static final String MOBILE_SIG = "mobileSig";

    @NotNull
    public static final String NONCE = "nonce";

    @NotNull
    public static final String REPLY_MSG = "reply";

    @NotNull
    public static final String SESSION_END = "sessionEnd";

    @NotNull
    public static final String SESSION_NONCE = "sNonce";

    @NotNull
    public static final String SESSION_START = "sessionStart";

    @NotNull
    public static final String SIGNATURE = "signature";

    @NotNull
    public static final String SIGNATURES = "signatures";

    @NotNull
    public static final String SIGNED_CMD = "signedCmd";

    @NotNull
    public static final String TEMP_KEY = "tmpKey";

    @NotNull
    private final IAlCborUtility cborUtility;

    @NotNull
    private CBORGenerator generator;

    @JsonIgnore
    @Nullable
    private AlProtocolVersion protocolVersion;

    @NotNull
    private final ByteArrayOutputStream stream;

    @JvmOverloads
    protected AlCBORMessage() throws AlBleComponentException {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    protected AlCBORMessage(@NotNull IAlCborUtility cborUtility) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(cborUtility, "cborUtility");
        this.cborUtility = cborUtility;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.stream = byteArrayOutputStream;
        this.generator = cborUtility.getCborGenerator(byteArrayOutputStream);
    }

    @NotNull
    /* renamed from: getCborUtility$AccessBleCredential_release, reason: from getter */
    public final IAlCborUtility getCborUtility() {
        return this.cborUtility;
    }

    @NotNull
    /* renamed from: getGenerator$AccessBleCredential_release, reason: from getter */
    public final CBORGenerator getGenerator() {
        return this.generator;
    }

    @Nullable
    /* renamed from: getProtocolVersion$AccessBleCredential_release, reason: from getter */
    public final AlProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    @NotNull
    /* renamed from: getStream$AccessBleCredential_release, reason: from getter */
    public final ByteArrayOutputStream getStream() {
        return this.stream;
    }

    public final void setGenerator$AccessBleCredential_release(@NotNull CBORGenerator cBORGenerator) {
        Intrinsics.checkParameterIsNotNull(cBORGenerator, "<set-?>");
        this.generator = cBORGenerator;
    }

    public final void setProtocolVersion$AccessBleCredential_release(@Nullable AlProtocolVersion alProtocolVersion) {
        this.protocolVersion = alProtocolVersion;
    }

    public /* synthetic */ AlCBORMessage(IAlCborUtility iAlCborUtility, int i, DefaultConstructorMarker defaultConstructorMarker) throws AlBleComponentException {
        this((i & 1) != 0 ? new AlCborUtility() : iAlCborUtility);
    }
}
