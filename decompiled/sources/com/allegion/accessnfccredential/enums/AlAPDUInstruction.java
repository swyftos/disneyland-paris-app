package com.allegion.accessnfccredential.enums;

import androidx.media3.extractor.ts.TsExtractor;
import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.api.Currencies;
import com.facebook.imageutils.JfifUtil;
import com.google.mlkit.common.MlKitException;
import kotlin.Metadata;
import org.bouncycastle.bcpg.SecretKeyPacket;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b5\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7¨\u00068"}, d2 = {"Lcom/allegion/accessnfccredential/enums/AlAPDUInstruction;", "", "byte", "", "(Ljava/lang/String;IB)V", "getByte", "()B", "toByte", "ACTIVATE_FILE", "APPEND_RECORD", "CHANGE_REFERENCE_DATA", "CREATE_FILE", "DEACTIVATE_FILE", "DELETE_FILE", "DISABLE_VERIFICATION_REQUIREMENT", "ENABLE_VERIFICATION_REQUIREMENT", "ENVELOPE", "ERASE_BINARY_ALL", "ERASE_BINARY_OFFSET", "ERASE_RECORD", "MUTUAL_AUTHENTICATE", "GENERAL_AUTHENTICATE_1", "GENERAL_AUTHENTICATE_2", "GENERATE_ASYMMETRIC_KEY_PAIR", "GET_CHALLENGE", "GET_DATA", "GET_RESPONSE", "INTERNAL_AUTHENTICATE", "MANAGE_CHANNEL", "MANAGE_SECURITY_ENVIRONMENT", "PERFORM_SCQL_OPERATION", "PERFORM_SECURITY_OPERATION", "PERFORM_TRANSACTION_OPERATION", "PERFORM_USER_OPERATION", "PUT_DATA", "READ_BINARY_ALL", "READ_BINARY_OFFSET", "READ_RECORD_ALL", "READ_RECORD_OFFSET", "RESET_RETRY_COUNTER", "SEARCH_BINARY_ALL", "SEARCH_BINARY_OFFSET", "SEARCH_RECORD", "SELECT", "TERMINATE_CARD_USAGE", "TERMINATE_DF", "TERMINATE_EF", "UPDATE_BINARY_ALL", "UPDATE_BINARY_OFFSET", "UPDATE_RECORD_ALL", "UPDATE_RECORD_OFFSET", "VERIFY", "VERIFY_SENSOR", "WRITE_BINARY_ALL", "WRITE_BINARY_OFFSET", "WRITE_RECORD", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum AlAPDUInstruction {
    ACTIVATE_FILE((byte) 68),
    APPEND_RECORD((byte) 226),
    CHANGE_REFERENCE_DATA((byte) 36),
    CREATE_FILE((byte) 224),
    DEACTIVATE_FILE((byte) 4),
    DELETE_FILE((byte) 228),
    DISABLE_VERIFICATION_REQUIREMENT((byte) 38),
    ENABLE_VERIFICATION_REQUIREMENT((byte) 40),
    ENVELOPE((byte) 194),
    ERASE_BINARY_ALL((byte) 15),
    ERASE_BINARY_OFFSET((byte) 14),
    ERASE_RECORD((byte) 12),
    MUTUAL_AUTHENTICATE((byte) TsExtractor.TS_STREAM_TYPE_HDMV_DTS),
    GENERAL_AUTHENTICATE_1((byte) TsExtractor.TS_STREAM_TYPE_SPLICE_INFO),
    GENERAL_AUTHENTICATE_2((byte) TsExtractor.TS_STREAM_TYPE_E_AC3),
    GENERATE_ASYMMETRIC_KEY_PAIR((byte) 70),
    GET_CHALLENGE((byte) Currencies.CVE),
    GET_DATA((byte) MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED),
    GET_RESPONSE((byte) 192),
    INTERNAL_AUTHENTICATE((byte) 136),
    MANAGE_CHANNEL((byte) SyslogConstants.LOG_ALERT),
    MANAGE_SECURITY_ENVIRONMENT((byte) 34),
    PERFORM_SCQL_OPERATION((byte) 16),
    PERFORM_SECURITY_OPERATION((byte) 42),
    PERFORM_TRANSACTION_OPERATION((byte) 18),
    PERFORM_USER_OPERATION((byte) 20),
    PUT_DATA((byte) JfifUtil.MARKER_SOS),
    READ_BINARY_ALL((byte) SyslogConstants.LOG_LOCAL6),
    READ_BINARY_OFFSET((byte) 177),
    READ_RECORD_ALL((byte) 178),
    READ_RECORD_OFFSET((byte) 179),
    RESET_RETRY_COUNTER((byte) 44),
    SEARCH_BINARY_ALL((byte) 160),
    SEARCH_BINARY_OFFSET((byte) 161),
    SEARCH_RECORD((byte) 162),
    SELECT((byte) 164),
    TERMINATE_CARD_USAGE((byte) SecretKeyPacket.USAGE_SHA1),
    TERMINATE_DF((byte) Currencies.ETB),
    TERMINATE_EF((byte) Currencies.ERN),
    UPDATE_BINARY_ALL((byte) Currencies.DOP),
    UPDATE_BINARY_OFFSET((byte) JfifUtil.MARKER_RST7),
    UPDATE_RECORD_ALL((byte) 220),
    UPDATE_RECORD_OFFSET((byte) 221),
    VERIFY((byte) 32),
    VERIFY_SENSOR((byte) 33),
    WRITE_BINARY_ALL((byte) 208),
    WRITE_BINARY_OFFSET((byte) 209),
    WRITE_RECORD((byte) 210);

    private final byte byte;

    AlAPDUInstruction(byte b) {
        this.byte = b;
    }

    public final byte getByte() {
        return this.byte;
    }

    public final byte toByte() {
        return this.byte;
    }
}
