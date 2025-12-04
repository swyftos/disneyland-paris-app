package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors;

import androidx.autofill.HintConstants;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonValue;

/* loaded from: classes5.dex */
public enum JsonValueFormat {
    COLOR("color"),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL("email"),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE(HintConstants.AUTOFILL_HINT_PHONE),
    REGEX("regex"),
    STYLE("style"),
    TIME("time"),
    URI(ReactNativeBlobUtilConst.DATA_ENCODE_URI),
    UTC_MILLISEC("utc-millisec");

    private final String _desc;

    JsonValueFormat(String str) {
        this._desc = str;
    }

    @Override // java.lang.Enum
    @JsonValue
    public String toString() {
        return this._desc;
    }
}
