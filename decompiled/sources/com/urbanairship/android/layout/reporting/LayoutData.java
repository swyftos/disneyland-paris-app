package com.urbanairship.android.layout.reporting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class LayoutData implements JsonSerializable {
    private static LayoutData EMPTY = new LayoutData(null, null, null);
    private final String buttonIdentifier;
    private final FormInfo formInfo;
    private final PagerData pagerData;

    public LayoutData(@Nullable FormInfo formInfo, @Nullable PagerData pagerData, @Nullable String str) {
        this.formInfo = formInfo;
        this.pagerData = pagerData;
        this.buttonIdentifier = str;
    }

    public static LayoutData form(@Nullable FormInfo formInfo) {
        return new LayoutData(formInfo, null, null);
    }

    public static LayoutData pager(@Nullable PagerData pagerData) {
        return new LayoutData(null, pagerData, null);
    }

    public static LayoutData button(@Nullable String str) {
        return new LayoutData(null, null, str);
    }

    public static LayoutData empty() {
        return EMPTY;
    }

    @Nullable
    public FormInfo getFormInfo() {
        return this.formInfo;
    }

    @Nullable
    public PagerData getPagerData() {
        return this.pagerData;
    }

    @Nullable
    public String getButtonIdentifier() {
        return this.buttonIdentifier;
    }

    public String toString() {
        return "LayoutData{formInfo=" + this.formInfo + ", pagerData=" + this.pagerData + ", buttonIdentifier='" + this.buttonIdentifier + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonMap.newBuilder().putOpt("formInfo", this.formInfo).putOpt("pagerData", this.pagerData).putOpt("buttonIdentifier", this.buttonIdentifier).build().toJsonValue();
    }
}
