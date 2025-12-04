package com.disney.id.android;

import androidx.annotation.Keep;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.extensions.JSONExtensionsKt;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 =2\u00020\u0001:\u0003=>?BE\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010+R<\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010.R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b0\u00101R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u00102\u001a\u0004\b3\u00104R(\u00105\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010+R(\u00107\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00058F@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R(\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00058F@BX\u0086\u000e¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:¨\u0006@"}, d2 = {"Lcom/disney/id/android/OptionalConfigs;", "", "Lorg/json/JSONObject;", "providedProfile", "", "", "reportingValues", "", "allowSkip", "", "overrideActivityFlagValue", "Lcom/disney/id/android/OptionalConfigs$DisplayOptions;", "displayOptions", "<init>", "(Lorg/json/JSONObject;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/disney/id/android/OptionalConfigs$DisplayOptions;)V", "json", "(Lorg/json/JSONObject;)V", "overlayOptions", "merge$OneID_release", "(Lcom/disney/id/android/OptionalConfigs;)Lcom/disney/id/android/OptionalConfigs;", "merge", "toJSON$OneID_release", "()Lorg/json/JSONObject;", "toJSON", "getReportingValuesJson$OneID_release", "getReportingValuesJson", ETCPaymentMethod.OTHER, ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcom/disney/id/android/logging/Logger;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "<set-?>", "Lorg/json/JSONObject;", "getProvidedProfile", "Ljava/lang/Boolean;", "getAllowSkip", "()Ljava/lang/Boolean;", "Ljava/util/Map;", "getReportingValues", "()Ljava/util/Map;", "Ljava/lang/Integer;", "getOverrideActivityFlagValue", "()Ljava/lang/Integer;", "Lcom/disney/id/android/OptionalConfigs$DisplayOptions;", "getDisplayOptions", "()Lcom/disney/id/android/OptionalConfigs$DisplayOptions;", "suppressCreateAccount", "getSuppressCreateAccount", "reportingSource", "Ljava/lang/String;", "getReportingSource", "()Ljava/lang/String;", "reportingContext", "getReportingContext", "Companion", "DisplayOptions", "OptionalConfigsBuilder", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOptionalConfigs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OptionalConfigs.kt\ncom/disney/id/android/OptionalConfigs\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,353:1\n1#2:354\n*E\n"})
/* loaded from: classes3.dex */
public final class OptionalConfigs {
    private Boolean allowSkip;
    private DisplayOptions displayOptions;

    @Inject
    public Logger logger;
    private Integer overrideActivityFlagValue;
    private JSONObject providedProfile;
    private Map reportingValues;
    private Boolean suppressCreateAccount;

    public OptionalConfigs(@Nullable JSONObject jSONObject, @NotNull Map<String, String> reportingValues, @Nullable Boolean bool, @Nullable Integer num, @Nullable DisplayOptions displayOptions) {
        Intrinsics.checkNotNullParameter(reportingValues, "reportingValues");
        OneIDDagger.getComponent().inject(this);
        this.providedProfile = jSONObject;
        this.reportingValues = reportingValues;
        this.allowSkip = bool;
        this.overrideActivityFlagValue = num;
        this.displayOptions = displayOptions;
        this.suppressCreateAccount = displayOptions != null ? displayOptions.getSuppressCreateAccount() : null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OptionalConfigs(@NotNull JSONObject json) throws JSONException {
        this(null, new HashMap(), null, null, null);
        Intrinsics.checkNotNullParameter(json, "json");
        this.providedProfile = json.optJSONObject("providedProfile");
        JSONObject jSONObjectOptJSONObject = json.optJSONObject(OneIDTrackerEvent.EVENT_PARAM_REPORTING);
        if (jSONObjectOptJSONObject != null) {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                String string = jSONObjectOptJSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                map.put(next, string);
            }
            this.reportingValues = map;
        }
        this.allowSkip = JSONExtensionsKt.getBooleanSafely(json, "allowSkip");
        this.overrideActivityFlagValue = JSONExtensionsKt.getIntSafely(json, "overrideActivityFlagValue");
        JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("displayOptions");
        if (jSONObjectOptJSONObject2 != null) {
            this.suppressCreateAccount = JSONExtensionsKt.getBooleanSafely(jSONObjectOptJSONObject2, "suppressCreateAccountOpt");
            this.displayOptions = new DisplayOptions(jSONObjectOptJSONObject2.getBoolean("darkMode"), JSONExtensionsKt.getStringSafely(jSONObjectOptJSONObject2, "cssContext"), this.suppressCreateAccount);
        }
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @Nullable
    public final JSONObject getProvidedProfile() {
        return this.providedProfile;
    }

    @Nullable
    public final Boolean getAllowSkip() {
        return this.allowSkip;
    }

    @NotNull
    public final Map<String, String> getReportingValues() {
        return this.reportingValues;
    }

    @Nullable
    public final Integer getOverrideActivityFlagValue() {
        return this.overrideActivityFlagValue;
    }

    @Nullable
    public final DisplayOptions getDisplayOptions() {
        return this.displayOptions;
    }

    @Nullable
    public final String getReportingSource() {
        return (String) this.reportingValues.get("source");
    }

    @Nullable
    public final String getReportingContext() {
        return (String) this.reportingValues.get("context");
    }

    @Nullable
    public final Boolean getSuppressCreateAccount() {
        return this.suppressCreateAccount;
    }

    @NotNull
    public final OptionalConfigs merge$OneID_release(@Nullable OptionalConfigs overlayOptions) {
        if (overlayOptions == null) {
            return this;
        }
        JSONObject jSONObject = overlayOptions.providedProfile;
        if (jSONObject == null) {
            jSONObject = this.providedProfile;
        }
        JSONObject jSONObject2 = jSONObject;
        Map map = !overlayOptions.reportingValues.isEmpty() ? overlayOptions.reportingValues : this.reportingValues;
        Boolean bool = overlayOptions.allowSkip;
        if (bool == null) {
            bool = this.allowSkip;
        }
        Boolean bool2 = bool;
        Integer num = overlayOptions.overrideActivityFlagValue;
        if (num == null) {
            num = this.overrideActivityFlagValue;
        }
        Integer num2 = num;
        DisplayOptions displayOptions = overlayOptions.displayOptions;
        return new OptionalConfigs(jSONObject2, map, bool2, num2, displayOptions == null ? this.displayOptions : displayOptions);
    }

    @NotNull
    public final JSONObject toJSON$OneID_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = this.providedProfile;
        if (jSONObject2 != null) {
            jSONObject.put("providedProfile", jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        for (Map.Entry entry : this.reportingValues.entrySet()) {
            jSONObject3.put((String) entry.getKey(), (String) entry.getValue());
        }
        if (jSONObject3.length() > 0) {
            jSONObject.put(OneIDTrackerEvent.EVENT_PARAM_REPORTING, jSONObject3);
        }
        Boolean bool = this.allowSkip;
        if (bool != null) {
            jSONObject.put("allowSkip", bool.booleanValue());
        }
        Integer num = this.overrideActivityFlagValue;
        if (num != null) {
            jSONObject.put("overrideActivityFlagValue", num.intValue());
        }
        if (this.displayOptions != null) {
            JSONObject jSONObject4 = new JSONObject();
            DisplayOptions displayOptions = this.displayOptions;
            jSONObject4.put("darkMode", displayOptions != null ? Boolean.valueOf(displayOptions.getDarkMode()) : null);
            DisplayOptions displayOptions2 = this.displayOptions;
            jSONObject4.put("cssContext", displayOptions2 != null ? displayOptions2.getCssContext() : null);
            DisplayOptions displayOptions3 = this.displayOptions;
            jSONObject4.put("suppressCreateAccountOpt", displayOptions3 != null ? displayOptions3.getSuppressCreateAccount() : null);
            jSONObject.put("displayOptions", jSONObject4);
        }
        return jSONObject;
    }

    @NotNull
    public final JSONObject getReportingValuesJson$OneID_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!this.reportingValues.isEmpty()) {
            for (Map.Entry entry : this.reportingValues.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(OptionalConfigs.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.disney.id.android.OptionalConfigs");
        OptionalConfigs optionalConfigs = (OptionalConfigs) other;
        return Intrinsics.areEqual(this.providedProfile, optionalConfigs.providedProfile) && Intrinsics.areEqual(this.allowSkip, optionalConfigs.allowSkip) && Intrinsics.areEqual(this.reportingValues, optionalConfigs.reportingValues) && Intrinsics.areEqual(this.overrideActivityFlagValue, optionalConfigs.overrideActivityFlagValue) && Intrinsics.areEqual(this.displayOptions, optionalConfigs.displayOptions);
    }

    public int hashCode() {
        JSONObject jSONObject = this.providedProfile;
        int iHashCode = (jSONObject != null ? jSONObject.hashCode() : 0) * 31;
        Boolean bool = this.allowSkip;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Integer num = this.overrideActivityFlagValue;
        int iHashCode3 = (((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.reportingValues.hashCode()) * 31;
        DisplayOptions displayOptions = this.displayOptions;
        return iHashCode3 + (displayOptions != null ? displayOptions.hashCode() : 0);
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ+\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018H\u0002J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018J\u001a\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180)R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/disney/id/android/OptionalConfigs$OptionalConfigsBuilder;", "", "()V", "allowSkip", "", "Ljava/lang/Boolean;", "displayOptions", "Lcom/disney/id/android/OptionalConfigs$DisplayOptions;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "overrideActivityFlagValue", "", "Ljava/lang/Integer;", "pattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "providedProfile", "Lorg/json/JSONObject;", "reportingValues", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "build", "Lcom/disney/id/android/OptionalConfigs;", "darkMode", "cssContext", "suppressCreateAccount", "(ZLjava/lang/String;Ljava/lang/Boolean;)Lcom/disney/id/android/OptionalConfigs$OptionalConfigsBuilder;", "isReportingSizeInLimit", "existingSize", "additionalSize", "isReportingValueValid", "key", "value", "overrideActivityFlag", "reportingValue", "name", "", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nOptionalConfigs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OptionalConfigs.kt\ncom/disney/id/android/OptionalConfigs$OptionalConfigsBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,353:1\n1#2:354\n*E\n"})
    public static final class OptionalConfigsBuilder {
        private static final String TAG = OptionalConfigs.class.getSimpleName();
        private Boolean allowSkip;
        private DisplayOptions displayOptions;

        @Inject
        public Logger logger;
        private Integer overrideActivityFlagValue;
        private JSONObject providedProfile;
        private final HashMap reportingValues = new HashMap();
        private final Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");

        public OptionalConfigsBuilder() {
            OneIDDagger.getComponent().inject(this);
        }

        @NotNull
        public final Logger getLogger$OneID_release() {
            Logger logger = this.logger;
            if (logger != null) {
                return logger;
            }
            Intrinsics.throwUninitializedPropertyAccessException("logger");
            return null;
        }

        public final void setLogger$OneID_release(@NotNull Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "<set-?>");
            this.logger = logger;
        }

        @NotNull
        public final OptionalConfigs build() {
            return new OptionalConfigs(this.providedProfile, this.reportingValues, this.allowSkip, this.overrideActivityFlagValue, this.displayOptions);
        }

        @NotNull
        public final OptionalConfigsBuilder providedProfile(@NotNull JSONObject providedProfile) {
            Intrinsics.checkNotNullParameter(providedProfile, "providedProfile");
            this.providedProfile = providedProfile;
            return this;
        }

        @NotNull
        public final OptionalConfigsBuilder allowSkip(boolean allowSkip) {
            this.allowSkip = Boolean.valueOf(allowSkip);
            return this;
        }

        @NotNull
        public final OptionalConfigsBuilder overrideActivityFlag(int overrideActivityFlagValue) {
            this.overrideActivityFlagValue = Integer.valueOf(overrideActivityFlagValue);
            return this;
        }

        @NotNull
        public final OptionalConfigsBuilder reportingValue(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            if (isReportingSizeInLimit(this.reportingValues.size(), 1) && isReportingValueValid(name, value)) {
                this.reportingValues.put(name, value);
            }
            return this;
        }

        @NotNull
        public final OptionalConfigsBuilder reportingValues(@NotNull Map<String, String> reportingValues) {
            Intrinsics.checkNotNullParameter(reportingValues, "reportingValues");
            if (isReportingSizeInLimit(this.reportingValues.size(), reportingValues.size())) {
                for (Map.Entry<String, String> entry : reportingValues.entrySet()) {
                    if (!isReportingValueValid(entry.getKey(), entry.getValue())) {
                        return this;
                    }
                }
                this.reportingValues.putAll(reportingValues);
            }
            return this;
        }

        public static /* synthetic */ OptionalConfigsBuilder displayOptions$default(OptionalConfigsBuilder optionalConfigsBuilder, boolean z, String str, Boolean bool, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                bool = null;
            }
            return optionalConfigsBuilder.displayOptions(z, str, bool);
        }

        @NotNull
        public final OptionalConfigsBuilder displayOptions(boolean darkMode, @Nullable String cssContext, @Nullable Boolean suppressCreateAccount) {
            this.displayOptions = new DisplayOptions(darkMode, cssContext, suppressCreateAccount);
            return this;
        }

        private final boolean isReportingSizeInLimit(int existingSize, int additionalSize) {
            if (existingSize + additionalSize <= 10) {
                return true;
            }
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "There cannot be more than 10 reporting values.", null, 4, null);
            return false;
        }

        private final boolean isReportingValueValid(String key, String value) {
            if (key.length() > 30 || key.length() == 0) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "A reporting key must not be empty and must be less than 30 characters.", null, 4, null);
                return false;
            }
            if (value.length() > 100) {
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "A reporting value must be less than 100 characters.", null, 4, null);
                return false;
            }
            boolean zMatches = this.pattern.matcher(key).matches();
            if (!zMatches) {
                Logger logger$OneID_release3 = getLogger$OneID_release();
                String TAG4 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                Logger.DefaultImpls.e$default(logger$OneID_release3, TAG4, "A reporting key can only contain alphanumerics and underscores", null, 4, null);
            }
            return zMatches;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/disney/id/android/OptionalConfigs$DisplayOptions;", "", "darkMode", "", "cssContext", "", "suppressCreateAccount", "(ZLjava/lang/String;Ljava/lang/Boolean;)V", "getCssContext", "()Ljava/lang/String;", "getDarkMode", "()Z", "getSuppressCreateAccount", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(ZLjava/lang/String;Ljava/lang/Boolean;)Lcom/disney/id/android/OptionalConfigs$DisplayOptions;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DisplayOptions {

        @Nullable
        private final String cssContext;
        private final boolean darkMode;

        @Nullable
        private final Boolean suppressCreateAccount;

        public static /* synthetic */ DisplayOptions copy$default(DisplayOptions displayOptions, boolean z, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                z = displayOptions.darkMode;
            }
            if ((i & 2) != 0) {
                str = displayOptions.cssContext;
            }
            if ((i & 4) != 0) {
                bool = displayOptions.suppressCreateAccount;
            }
            return displayOptions.copy(z, str, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getCssContext() {
            return this.cssContext;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Boolean getSuppressCreateAccount() {
            return this.suppressCreateAccount;
        }

        @NotNull
        public final DisplayOptions copy(boolean darkMode, @Nullable String cssContext, @Nullable Boolean suppressCreateAccount) {
            return new DisplayOptions(darkMode, cssContext, suppressCreateAccount);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DisplayOptions)) {
                return false;
            }
            DisplayOptions displayOptions = (DisplayOptions) other;
            return this.darkMode == displayOptions.darkMode && Intrinsics.areEqual(this.cssContext, displayOptions.cssContext) && Intrinsics.areEqual(this.suppressCreateAccount, displayOptions.suppressCreateAccount);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.darkMode) * 31;
            String str = this.cssContext;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.suppressCreateAccount;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "DisplayOptions(darkMode=" + this.darkMode + ", cssContext=" + this.cssContext + ", suppressCreateAccount=" + this.suppressCreateAccount + ")";
        }

        public DisplayOptions(boolean z, @Nullable String str, @Nullable Boolean bool) {
            this.darkMode = z;
            this.cssContext = str;
            this.suppressCreateAccount = bool;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        @Nullable
        public final String getCssContext() {
            return this.cssContext;
        }

        @Nullable
        public final Boolean getSuppressCreateAccount() {
            return this.suppressCreateAccount;
        }
    }
}
