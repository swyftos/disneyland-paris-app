package com.urbanairship.featureflag;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.json.JsonMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class VariableResult {
    private final JsonMap data;
    private final JsonMap reportingMetadata;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VariableResult)) {
            return false;
        }
        VariableResult variableResult = (VariableResult) obj;
        return Intrinsics.areEqual(this.data, variableResult.data) && Intrinsics.areEqual(this.reportingMetadata, variableResult.reportingMetadata);
    }

    public int hashCode() {
        JsonMap jsonMap = this.data;
        int iHashCode = (jsonMap == null ? 0 : jsonMap.hashCode()) * 31;
        JsonMap jsonMap2 = this.reportingMetadata;
        return iHashCode + (jsonMap2 != null ? jsonMap2.hashCode() : 0);
    }

    public String toString() {
        return "VariableResult(data=" + this.data + ", reportingMetadata=" + this.reportingMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public VariableResult(JsonMap jsonMap, JsonMap jsonMap2) {
        this.data = jsonMap;
        this.reportingMetadata = jsonMap2;
    }

    public final JsonMap getData() {
        return this.data;
    }

    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }
}
