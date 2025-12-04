package com.urbanairship.android.layout.reporting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;

/* loaded from: classes5.dex */
public class FormInfo implements JsonSerializable {
    private final String formResponseType;
    private final String formType;
    private final String identifier;
    private final Boolean isFormSubmitted;

    public FormInfo(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Boolean bool) {
        this.identifier = str;
        this.formResponseType = str3;
        this.formType = str2;
        this.isFormSubmitted = bool;
    }

    @NonNull
    public String getIdentifier() {
        return this.identifier;
    }

    @NonNull
    public String getFormResponseType() {
        return this.formResponseType;
    }

    @NonNull
    public String getFormType() {
        return this.formType;
    }

    @Nullable
    public Boolean getFormSubmitted() {
        return this.isFormSubmitted;
    }

    public String toString() {
        return "FormInfo{identifier='" + this.identifier + CoreConstants.SINGLE_QUOTE_CHAR + ", formResponseType='" + this.formResponseType + CoreConstants.SINGLE_QUOTE_CHAR + ", formType='" + this.formType + CoreConstants.SINGLE_QUOTE_CHAR + ", isFormSubmitted=" + this.isFormSubmitted + '}';
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonMap.newBuilder().put("identifier", this.identifier).put("formResponseType", this.formResponseType).put("formType", this.formType).putOpt("isFormSubmitted", this.isFormSubmitted).build().toJsonValue();
    }
}
