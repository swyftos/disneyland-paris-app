package com.urbanairship.android.layout.reporting;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.info.ThomasChannelRegistration;
import com.urbanairship.android.layout.property.FormInputType;
import com.urbanairship.android.layout.reporting.ThomasFormFieldStatus;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.PreferenceCenterPayload;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u000e\u001f !\"#$%&'()*+,B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X \u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0007-./0123¨\u00064"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField;", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Type;", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$Type;)V", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "originalValue", "getOriginalValue", "()Ljava/lang/Object;", "status", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "getStatus$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "getType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$Type;", "formData", "Lcom/urbanairship/json/JsonMap;", "withState", "", "formData$urbanairship_layout_release", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "AsyncValueFetcher", "BaseForm", "CheckboxController", "Companion", "FieldType", "Form", "Nps", "RadioInputController", "Result", "Score", "ScoreInputController", "TextInput", "Toggle", "Type", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$CheckboxController;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$RadioInputController;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Score;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$ScoreInputController;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$TextInput;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Toggle;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThomasFormField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasFormField.kt\ncom/urbanairship/android/layout/reporting/ThomasFormField\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,424:1\n1#2:425\n*E\n"})
/* loaded from: classes5.dex */
public abstract class ThomasFormField<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Type type;

    public /* synthetic */ ThomasFormField(Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(type);
    }

    @NotNull
    public abstract FieldType<T> getFieldType$urbanairship_layout_release();

    @NotNull
    public abstract String getIdentifier();

    @Nullable
    public abstract T getOriginalValue();

    private ThomasFormField(Type type) {
        this.type = type;
    }

    @NotNull
    /* renamed from: getType$urbanairship_layout_release, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u001b\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0018\u00010\bHÆ\u0003JL\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "channels", "", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "attributes", "", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/Map;)V", "getAttributes", "()Ljava/util/Map;", "getChannels", "()Ljava/util/List;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/Map;)Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result<T> {
        private final Map attributes;
        private final List channels;
        private final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, Object obj, List list, Map map, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = result.value;
            }
            if ((i & 2) != 0) {
                list = result.channels;
            }
            if ((i & 4) != 0) {
                map = result.attributes;
            }
            return result.copy(obj, list, map);
        }

        public final T component1() {
            return (T) this.value;
        }

        @Nullable
        public final List<ThomasChannelRegistration> component2() {
            return this.channels;
        }

        @Nullable
        public final Map<AttributeName, JsonValue> component3() {
            return this.attributes;
        }

        @NotNull
        public final Result<T> copy(T value, @Nullable List<? extends ThomasChannelRegistration> channels, @Nullable Map<AttributeName, ? extends JsonValue> attributes) {
            return new Result<>(value, channels, attributes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.value, result.value) && Intrinsics.areEqual(this.channels, result.channels) && Intrinsics.areEqual(this.attributes, result.attributes);
        }

        public int hashCode() {
            Object obj = this.value;
            int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
            List list = this.channels;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            Map map = this.attributes;
            return iHashCode2 + (map != null ? map.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Result(value=" + this.value + ", channels=" + this.channels + ", attributes=" + this.attributes + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Result(T t, @Nullable List<? extends ThomasChannelRegistration> list, @Nullable Map<AttributeName, ? extends JsonValue> map) {
            this.value = t;
            this.channels = list;
            this.attributes = map;
        }

        public /* synthetic */ Result(Object obj, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : map);
        }

        public final T getValue() {
            return (T) this.value;
        }

        @Nullable
        public final List<ThomasChannelRegistration> getChannels() {
            return this.channels;
        }

        @Nullable
        public final Map<AttributeName, JsonValue> getAttributes() {
            return this.attributes;
        }
    }

    @NotNull
    public final ThomasFormFieldStatus<T> getStatus$urbanairship_layout_release() {
        ThomasFormFieldStatus<T> status;
        FieldType<T> fieldType$urbanairship_layout_release = getFieldType$urbanairship_layout_release();
        if (fieldType$urbanairship_layout_release instanceof FieldType.Async) {
            AsyncValueFetcher.PendingResult<T> value = ((FieldType.Async) fieldType$urbanairship_layout_release).getFetcher().getResults().getValue();
            return (value == null || (status = value.getStatus()) == null) ? new ThomasFormFieldStatus.Pending() : status;
        }
        if (!(fieldType$urbanairship_layout_release instanceof FieldType.Instant)) {
            throw new NoWhenBranchMatchedException();
        }
        Result<T> result = ((FieldType.Instant) fieldType$urbanairship_layout_release).getResult();
        return result != null ? new ThomasFormFieldStatus.Valid(result) : new ThomasFormFieldStatus.Invalid();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$Type;", "", "Lcom/urbanairship/json/JsonSerializable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "FORM", "NPS_FORM", "TOGGLE", "MULTIPLE_CHOICE", "SINGLE_CHOICE", "TEXT", "EMAIL", "SMS", "SCORE", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        private final String value;
        public static final Type FORM = new Type("FORM", 0, PreferenceCenterPayload.KEY_FORM);
        public static final Type NPS_FORM = new Type("NPS_FORM", 1, "nps");
        public static final Type TOGGLE = new Type("TOGGLE", 2, "toggle");
        public static final Type MULTIPLE_CHOICE = new Type("MULTIPLE_CHOICE", 3, "multiple_choice");
        public static final Type SINGLE_CHOICE = new Type("SINGLE_CHOICE", 4, "single_choice");
        public static final Type TEXT = new Type("TEXT", 5, "text_input");
        public static final Type EMAIL = new Type("EMAIL", 6, "email_input");
        public static final Type SMS = new Type("SMS", 7, "sms_input");
        public static final Type SCORE = new Type("SCORE", 8, FirebaseAnalytics.Param.SCORE);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{FORM, NPS_FORM, TOGGLE, MULTIPLE_CHOICE, SINGLE_CHOICE, TEXT, EMAIL, SMS, SCORE};
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i, String str2) {
            this.value = str2;
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.value);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    public static /* synthetic */ JsonMap formData$urbanairship_layout_release$default(ThomasFormField thomasFormField, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formData");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return thomasFormField.formData$urbanairship_layout_release(z);
    }

    @NotNull
    public JsonMap formData$urbanairship_layout_release(boolean withState) {
        T originalValue;
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        builderNewBuilder.put("type", this.type);
        if (withState) {
            builderNewBuilder.put("status", getStatus$urbanairship_layout_release().toJson(this.type));
            builderNewBuilder.put("value", JsonValue.wrapOpt(getOriginalValue()));
        } else {
            if (getStatus$urbanairship_layout_release() instanceof ThomasFormFieldStatus.Valid) {
                ThomasFormFieldStatus<T> status$urbanairship_layout_release = getStatus$urbanairship_layout_release();
                Intrinsics.checkNotNull(status$urbanairship_layout_release, "null cannot be cast to non-null type com.urbanairship.android.layout.reporting.ThomasFormFieldStatus.Valid<T of com.urbanairship.android.layout.reporting.ThomasFormField>");
                originalValue = ((ThomasFormFieldStatus.Valid) status$urbanairship_layout_release).getResult().getValue();
            } else {
                originalValue = getOriginalValue();
            }
            builderNewBuilder.put("value", JsonValue.wrapOpt(originalValue));
        }
        JsonMap jsonMapBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
        return jsonMapBuild;
    }

    @Nullable
    public final JsonValue jsonValue() {
        JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(getOriginalValue());
        if (Intrinsics.areEqual(jsonValueWrapOpt, JsonValue.NULL)) {
            return null;
        }
        return jsonValueWrapOpt;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0013J4\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$Toggle;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "", "identifier", "", "originalValue", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getOriginalValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component3$urbanairship_layout_release", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)Lcom/urbanairship/android/layout/reporting/ThomasFormField$Toggle;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Toggle extends ThomasFormField<Boolean> {
        private final FieldType fieldType;
        private final String identifier;
        private final Boolean originalValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Toggle copy$default(Toggle toggle, String str, Boolean bool, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = toggle.identifier;
            }
            if ((i & 2) != 0) {
                bool = toggle.originalValue;
            }
            if ((i & 4) != 0) {
                fieldType = toggle.fieldType;
            }
            return toggle.copy(str, bool, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Boolean getOriginalValue() {
            return this.originalValue;
        }

        @NotNull
        public final FieldType<Boolean> component3$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final Toggle copy(@NotNull String identifier, @Nullable Boolean originalValue, @NotNull FieldType<Boolean> fieldType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new Toggle(identifier, originalValue, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Toggle)) {
                return false;
            }
            Toggle toggle = (Toggle) other;
            return Intrinsics.areEqual(this.identifier, toggle.identifier) && Intrinsics.areEqual(this.originalValue, toggle.originalValue) && Intrinsics.areEqual(this.fieldType, toggle.fieldType);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            Boolean bool = this.originalValue;
            return ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "Toggle(identifier=" + this.identifier + ", originalValue=" + this.originalValue + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @Nullable
        public Boolean getOriginalValue() {
            return this.originalValue;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<Boolean> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Toggle(@NotNull String identifier, @Nullable Boolean bool, @NotNull FieldType<Boolean> fieldType) {
            super(Type.TOGGLE, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            this.identifier = identifier;
            this.originalValue = bool;
            this.fieldType = fieldType;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\bHÀ\u0003¢\u0006\u0002\b\u0013J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$CheckboxController;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "", "Lcom/urbanairship/json/JsonValue;", "identifier", "", "originalValue", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Ljava/lang/String;Ljava/util/Set;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getOriginalValue", "()Ljava/util/Set;", "component1", "component2", "component3", "component3$urbanairship_layout_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class CheckboxController extends ThomasFormField<Set<? extends JsonValue>> {
        private final FieldType fieldType;
        private final String identifier;
        private final Set originalValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CheckboxController copy$default(CheckboxController checkboxController, String str, Set set, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = checkboxController.identifier;
            }
            if ((i & 2) != 0) {
                set = checkboxController.originalValue;
            }
            if ((i & 4) != 0) {
                fieldType = checkboxController.fieldType;
            }
            return checkboxController.copy(str, set, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final Set<JsonValue> component2() {
            return this.originalValue;
        }

        @NotNull
        public final FieldType<Set<JsonValue>> component3$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final CheckboxController copy(@NotNull String identifier, @Nullable Set<? extends JsonValue> originalValue, @NotNull FieldType<Set<JsonValue>> fieldType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new CheckboxController(identifier, originalValue, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckboxController)) {
                return false;
            }
            CheckboxController checkboxController = (CheckboxController) other;
            return Intrinsics.areEqual(this.identifier, checkboxController.identifier) && Intrinsics.areEqual(this.originalValue, checkboxController.originalValue) && Intrinsics.areEqual(this.fieldType, checkboxController.fieldType);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            Set set = this.originalValue;
            return ((iHashCode + (set == null ? 0 : set.hashCode())) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "CheckboxController(identifier=" + this.identifier + ", originalValue=" + this.originalValue + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @Nullable
        public Set<? extends JsonValue> getOriginalValue() {
            return this.originalValue;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<Set<? extends JsonValue>> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckboxController(@NotNull String identifier, @Nullable Set<? extends JsonValue> set, @NotNull FieldType<Set<JsonValue>> fieldType) {
            super(Type.MULTIPLE_CHOICE, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            this.identifier = identifier;
            this.originalValue = set;
            this.fieldType = fieldType;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0012J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$RadioInputController;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "Lcom/urbanairship/json/JsonValue;", "identifier", "", "originalValue", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getOriginalValue", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component3$urbanairship_layout_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class RadioInputController extends ThomasFormField<JsonValue> {
        private final FieldType fieldType;
        private final String identifier;
        private final JsonValue originalValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RadioInputController copy$default(RadioInputController radioInputController, String str, JsonValue jsonValue, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = radioInputController.identifier;
            }
            if ((i & 2) != 0) {
                jsonValue = radioInputController.originalValue;
            }
            if ((i & 4) != 0) {
                fieldType = radioInputController.fieldType;
            }
            return radioInputController.copy(str, jsonValue, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getOriginalValue() {
            return this.originalValue;
        }

        @NotNull
        public final FieldType<JsonValue> component3$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final RadioInputController copy(@NotNull String identifier, @Nullable JsonValue originalValue, @NotNull FieldType<JsonValue> fieldType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new RadioInputController(identifier, originalValue, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RadioInputController)) {
                return false;
            }
            RadioInputController radioInputController = (RadioInputController) other;
            return Intrinsics.areEqual(this.identifier, radioInputController.identifier) && Intrinsics.areEqual(this.originalValue, radioInputController.originalValue) && Intrinsics.areEqual(this.fieldType, radioInputController.fieldType);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonValue jsonValue = this.originalValue;
            return ((iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "RadioInputController(identifier=" + this.identifier + ", originalValue=" + this.originalValue + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @Nullable
        public JsonValue getOriginalValue() {
            return this.originalValue;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<JsonValue> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RadioInputController(@NotNull String identifier, @Nullable JsonValue jsonValue, @NotNull FieldType<JsonValue> fieldType) {
            super(Type.SINGLE_CHOICE, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            this.identifier = identifier;
            this.originalValue = jsonValue;
            this.fieldType = fieldType;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0012J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$ScoreInputController;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "Lcom/urbanairship/json/JsonValue;", "identifier", "", "originalValue", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getOriginalValue", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component3$urbanairship_layout_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ScoreInputController extends ThomasFormField<JsonValue> {
        private final FieldType fieldType;
        private final String identifier;
        private final JsonValue originalValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScoreInputController copy$default(ScoreInputController scoreInputController, String str, JsonValue jsonValue, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = scoreInputController.identifier;
            }
            if ((i & 2) != 0) {
                jsonValue = scoreInputController.originalValue;
            }
            if ((i & 4) != 0) {
                fieldType = scoreInputController.fieldType;
            }
            return scoreInputController.copy(str, jsonValue, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getOriginalValue() {
            return this.originalValue;
        }

        @NotNull
        public final FieldType<JsonValue> component3$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final ScoreInputController copy(@NotNull String identifier, @Nullable JsonValue originalValue, @NotNull FieldType<JsonValue> fieldType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new ScoreInputController(identifier, originalValue, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScoreInputController)) {
                return false;
            }
            ScoreInputController scoreInputController = (ScoreInputController) other;
            return Intrinsics.areEqual(this.identifier, scoreInputController.identifier) && Intrinsics.areEqual(this.originalValue, scoreInputController.originalValue) && Intrinsics.areEqual(this.fieldType, scoreInputController.fieldType);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonValue jsonValue = this.originalValue;
            return ((iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "ScoreInputController(identifier=" + this.identifier + ", originalValue=" + this.originalValue + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @Nullable
        public JsonValue getOriginalValue() {
            return this.originalValue;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<JsonValue> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScoreInputController(@NotNull String identifier, @Nullable JsonValue jsonValue, @NotNull FieldType<JsonValue> fieldType) {
            super(Type.SCORE, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            this.identifier = identifier;
            this.originalValue = jsonValue;
            this.fieldType = fieldType;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÀ\u0003¢\u0006\u0002\b\u0015J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0002HÖ\u0001R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$TextInput;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "", "textInput", "Lcom/urbanairship/android/layout/property/FormInputType;", "identifier", "originalValue", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Lcom/urbanairship/android/layout/property/FormInputType;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getOriginalValue", "getTextInput", "()Lcom/urbanairship/android/layout/property/FormInputType;", "component1", "component2", "component3", "component4", "component4$urbanairship_layout_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class TextInput extends ThomasFormField<String> {
        private final FieldType fieldType;
        private final String identifier;
        private final String originalValue;
        private final FormInputType textInput;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FormInputType.values().length];
                try {
                    iArr[FormInputType.EMAIL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FormInputType.SMS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TextInput copy$default(TextInput textInput, FormInputType formInputType, String str, String str2, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                formInputType = textInput.textInput;
            }
            if ((i & 2) != 0) {
                str = textInput.identifier;
            }
            if ((i & 4) != 0) {
                str2 = textInput.originalValue;
            }
            if ((i & 8) != 0) {
                fieldType = textInput.fieldType;
            }
            return textInput.copy(formInputType, str, str2, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final FormInputType getTextInput() {
            return this.textInput;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getOriginalValue() {
            return this.originalValue;
        }

        @NotNull
        public final FieldType<String> component4$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final TextInput copy(@NotNull FormInputType textInput, @NotNull String identifier, @Nullable String originalValue, @NotNull FieldType<String> fieldType) {
            Intrinsics.checkNotNullParameter(textInput, "textInput");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new TextInput(textInput, identifier, originalValue, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextInput)) {
                return false;
            }
            TextInput textInput = (TextInput) other;
            return this.textInput == textInput.textInput && Intrinsics.areEqual(this.identifier, textInput.identifier) && Intrinsics.areEqual(this.originalValue, textInput.originalValue) && Intrinsics.areEqual(this.fieldType, textInput.fieldType);
        }

        public int hashCode() {
            int iHashCode = ((this.textInput.hashCode() * 31) + this.identifier.hashCode()) * 31;
            String str = this.originalValue;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "TextInput(textInput=" + this.textInput + ", identifier=" + this.identifier + ", originalValue=" + this.originalValue + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final FormInputType getTextInput() {
            return this.textInput;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @Nullable
        public String getOriginalValue() {
            return this.originalValue;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<String> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public TextInput(@NotNull FormInputType textInput, @NotNull String identifier, @Nullable String str, @NotNull FieldType<String> fieldType) {
            Type type;
            Intrinsics.checkNotNullParameter(textInput, "textInput");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            int i = WhenMappings.$EnumSwitchMapping$0[textInput.ordinal()];
            if (i == 1) {
                type = Type.EMAIL;
            } else if (i == 2) {
                type = Type.SMS;
            } else {
                type = Type.TEXT;
            }
            super(type, null);
            this.textInput = textInput;
            this.identifier = identifier;
            this.originalValue = str;
            this.fieldType = fieldType;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0013J4\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0002HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$Score;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "", "identifier", "", "originalValue", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getOriginalValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component3$urbanairship_layout_release", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)Lcom/urbanairship/android/layout/reporting/ThomasFormField$Score;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Score extends ThomasFormField<Integer> {
        private final FieldType fieldType;
        private final String identifier;
        private final Integer originalValue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Score copy$default(Score score, String str, Integer num, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = score.identifier;
            }
            if ((i & 2) != 0) {
                num = score.originalValue;
            }
            if ((i & 4) != 0) {
                fieldType = score.fieldType;
            }
            return score.copy(str, num, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Integer getOriginalValue() {
            return this.originalValue;
        }

        @NotNull
        public final FieldType<Integer> component3$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final Score copy(@NotNull String identifier, @Nullable Integer originalValue, @NotNull FieldType<Integer> fieldType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new Score(identifier, originalValue, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Score)) {
                return false;
            }
            Score score = (Score) other;
            return Intrinsics.areEqual(this.identifier, score.identifier) && Intrinsics.areEqual(this.originalValue, score.originalValue) && Intrinsics.areEqual(this.fieldType, score.fieldType);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            Integer num = this.originalValue;
            return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "Score(identifier=" + this.identifier + ", originalValue=" + this.originalValue + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @Nullable
        public Integer getOriginalValue() {
            return this.originalValue;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<Integer> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Score(@NotNull String identifier, @Nullable Integer num, @NotNull FieldType<Integer> fieldType) {
            super(Type.SCORE, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            this.identifier = identifier;
            this.originalValue = num;
            this.fieldType = fieldType;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00020\u00012\u00020\u0003BA\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0002\u0012\u0016\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0004J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0010¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0015\u001a\u00020\u0016R$\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00020\nX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0007X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f\u0082\u0001\u0002\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Type;", "identifier", "", "originalValue", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$Type;Ljava/lang/String;Ljava/util/Set;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getOriginalValue", "()Ljava/util/Set;", "responseType", "getResponseType", "childrenJson", "withState", "", "formData", "Lcom/urbanairship/json/JsonMap;", "formData$urbanairship_layout_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Form;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Nps;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class BaseForm extends ThomasFormField<Set<? extends ThomasFormField<?>>> implements JsonSerializable {
        private final FieldType fieldType;
        private final String identifier;
        private final Set originalValue;

        public /* synthetic */ BaseForm(Type type, String str, Set set, FieldType fieldType, DefaultConstructorMarker defaultConstructorMarker) {
            this(type, str, set, fieldType);
        }

        @Nullable
        protected abstract String getResponseType();

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public Set<? extends ThomasFormField<?>> getOriginalValue() {
            return this.originalValue;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<Set<? extends ThomasFormField<?>>> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        private BaseForm(Type type, String str, Set set, FieldType fieldType) {
            super(type, null);
            this.identifier = str;
            this.originalValue = set;
            this.fieldType = fieldType;
        }

        public static /* synthetic */ JsonSerializable childrenJson$default(BaseForm baseForm, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: childrenJson");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return baseForm.childrenJson(z);
        }

        @NotNull
        protected final JsonSerializable childrenJson(boolean withState) {
            JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
            for (ThomasFormField<?> thomasFormField : getOriginalValue()) {
                builderNewBuilder.putOpt(thomasFormField.getIdentifier(), thomasFormField.formData$urbanairship_layout_release(withState));
            }
            JsonMap jsonMapBuild = builderNewBuilder.build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public JsonMap formData$urbanairship_layout_release(boolean withState) {
            JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
            builderNewBuilder.put("type", getType());
            builderNewBuilder.put("value", childrenJson(withState));
            if (withState) {
                builderNewBuilder.put("status", getStatus$urbanairship_layout_release().toJson(getType()));
            }
            JsonMap jsonMapBuild = builderNewBuilder.build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            return toJsonValue(true);
        }

        public static /* synthetic */ JsonValue toJsonValue$default(BaseForm baseForm, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toJsonValue");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return baseForm.toJsonValue(z);
        }

        @NotNull
        public final JsonValue toJsonValue(boolean withState) {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(getIdentifier(), formData$urbanairship_layout_release(withState))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0016\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÄ\u0003J\u0013\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006HÆ\u0003J\u001e\u0010\u0015\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\tHÀ\u0003¢\u0006\u0002\b\u0016JM\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019H\u0010¢\u0006\u0002\b\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\tX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006#"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$Form;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "identifier", "", "responseType", "children", "", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "fieldType", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "getChildren", "()Ljava/util/Set;", "getFieldType$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getIdentifier", "()Ljava/lang/String;", "getResponseType", "component1", "component2", "component3", "component4", "component4$urbanairship_layout_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "formData", "Lcom/urbanairship/json/JsonMap;", "withState", "formData$urbanairship_layout_release", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Form extends BaseForm {
        private final Set children;
        private final FieldType fieldType;
        private final String identifier;
        private final String responseType;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Form copy$default(Form form, String str, String str2, Set set, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = form.identifier;
            }
            if ((i & 2) != 0) {
                str2 = form.responseType;
            }
            if ((i & 4) != 0) {
                set = form.children;
            }
            if ((i & 8) != 0) {
                fieldType = form.fieldType;
            }
            return form.copy(str, str2, set, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        protected final String getResponseType() {
            return this.responseType;
        }

        @NotNull
        public final Set<ThomasFormField<?>> component3() {
            return this.children;
        }

        @NotNull
        public final FieldType<Set<ThomasFormField<?>>> component4$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final Form copy(@NotNull String identifier, @Nullable String responseType, @NotNull Set<? extends ThomasFormField<?>> children, @NotNull FieldType<Set<ThomasFormField<?>>> fieldType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(children, "children");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new Form(identifier, responseType, children, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Form)) {
                return false;
            }
            Form form = (Form) other;
            return Intrinsics.areEqual(this.identifier, form.identifier) && Intrinsics.areEqual(this.responseType, form.responseType) && Intrinsics.areEqual(this.children, form.children) && Intrinsics.areEqual(this.fieldType, form.fieldType);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            String str = this.responseType;
            return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.children.hashCode()) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "Form(identifier=" + this.identifier + ", responseType=" + this.responseType + ", children=" + this.children + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm, com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm
        @Nullable
        protected String getResponseType() {
            return this.responseType;
        }

        @NotNull
        public final Set<ThomasFormField<?>> getChildren() {
            return this.children;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm, com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<Set<? extends ThomasFormField<?>>> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Form(@NotNull String identifier, @Nullable String str, @NotNull Set<? extends ThomasFormField<?>> children, @NotNull FieldType<Set<ThomasFormField<?>>> fieldType) {
            super(Type.FORM, identifier, children, fieldType, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(children, "children");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            this.identifier = identifier;
            this.responseType = str;
            this.children = children;
            this.fieldType = fieldType;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm, com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public JsonMap formData$urbanairship_layout_release(boolean withState) {
            return JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", getType()), TuplesKt.to("children", childrenJson(withState)), TuplesKt.to("response_type", getResponseType()));
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0016\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÄ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u001a\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\tHÀ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J^\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\tHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0014J\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010%R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b'\u0010\u0014R!\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u0017R*\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\t8\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0019¨\u0006,"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$Nps;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "", "identifier", "scoreId", "responseType", "", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "children", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "fieldType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)V", "", "withState", "Lcom/urbanairship/json/JsonMap;", "formData$urbanairship_layout_release", "(Z)Lcom/urbanairship/json/JsonMap;", "formData", "component1", "()Ljava/lang/String;", "component3", "component4", "()Ljava/util/Set;", "component5$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;)Lcom/urbanairship/android/layout/reporting/ThomasFormField$Nps;", "toString", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIdentifier", "getResponseType", "Ljava/util/Set;", "getChildren", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "getFieldType$urbanairship_layout_release", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Nps extends BaseForm {
        private final Set children;
        private final FieldType fieldType;
        private final String identifier;
        private final String responseType;
        private final String scoreId;

        public static /* synthetic */ Nps copy$default(Nps nps, String str, String str2, String str3, Set set, FieldType fieldType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nps.identifier;
            }
            if ((i & 2) != 0) {
                str2 = nps.scoreId;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = nps.responseType;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                set = nps.children;
            }
            Set set2 = set;
            if ((i & 16) != 0) {
                fieldType = nps.fieldType;
            }
            return nps.copy(str, str4, str5, set2, fieldType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        protected final String getResponseType() {
            return this.responseType;
        }

        @NotNull
        public final Set<ThomasFormField<?>> component4() {
            return this.children;
        }

        @NotNull
        public final FieldType<Set<ThomasFormField<?>>> component5$urbanairship_layout_release() {
            return this.fieldType;
        }

        @NotNull
        public final Nps copy(@NotNull String identifier, @NotNull String scoreId, @Nullable String responseType, @NotNull Set<? extends ThomasFormField<?>> children, @NotNull FieldType<Set<ThomasFormField<?>>> fieldType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(scoreId, "scoreId");
            Intrinsics.checkNotNullParameter(children, "children");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            return new Nps(identifier, scoreId, responseType, children, fieldType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Nps)) {
                return false;
            }
            Nps nps = (Nps) other;
            return Intrinsics.areEqual(this.identifier, nps.identifier) && Intrinsics.areEqual(this.scoreId, nps.scoreId) && Intrinsics.areEqual(this.responseType, nps.responseType) && Intrinsics.areEqual(this.children, nps.children) && Intrinsics.areEqual(this.fieldType, nps.fieldType);
        }

        public int hashCode() {
            int iHashCode = ((this.identifier.hashCode() * 31) + this.scoreId.hashCode()) * 31;
            String str = this.responseType;
            return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.children.hashCode()) * 31) + this.fieldType.hashCode();
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String toString() {
            return "Nps(identifier=" + this.identifier + ", scoreId=" + this.scoreId + ", responseType=" + this.responseType + ", children=" + this.children + ", fieldType=" + this.fieldType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm, com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm
        @Nullable
        protected String getResponseType() {
            return this.responseType;
        }

        @NotNull
        public final Set<ThomasFormField<?>> getChildren() {
            return this.children;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm, com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public FieldType<Set<? extends ThomasFormField<?>>> getFieldType$urbanairship_layout_release() {
            return this.fieldType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Nps(@NotNull String identifier, @NotNull String scoreId, @Nullable String str, @NotNull Set<? extends ThomasFormField<?>> children, @NotNull FieldType<Set<ThomasFormField<?>>> fieldType) {
            super(Type.NPS_FORM, identifier, children, fieldType, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(scoreId, "scoreId");
            Intrinsics.checkNotNullParameter(children, "children");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            this.identifier = identifier;
            this.scoreId = scoreId;
            this.responseType = str;
            this.children = children;
            this.fieldType = fieldType;
        }

        @Override // com.urbanairship.android.layout.reporting.ThomasFormField.BaseForm, com.urbanairship.android.layout.reporting.ThomasFormField
        @NotNull
        public JsonMap formData$urbanairship_layout_release(boolean withState) {
            return JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", getType()), TuplesKt.to("children", childrenJson(withState)), TuplesKt.to("score_id", this.scoreId), TuplesKt.to("response_type", getResponseType()));
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u00060\rj\u0002`\u000e\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0010\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$Companion;", "", "()V", "KEY_CHILDREN", "", "KEY_RESPONSE_TYPE", "KEY_SCORE_ID", "KEY_STATUS", "KEY_TYPE", "KEY_VALUE", "makeAttributes", "", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "name", "value", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Map<AttributeName, JsonValue> makeAttributes(@Nullable AttributeName name, @Nullable JsonValue value) {
            if (name == null || value == null) {
                return null;
            }
            return MapsKt.mapOf(TuplesKt.to(name, value));
        }
    }

    @NotNull
    public String toString() {
        return String.valueOf(formData$urbanairship_layout_release$default(this, false, 1, null).getJsonValue());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0006\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "cancel", "", "cancel$urbanairship_layout_release", "Async", "Companion", "Instant", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType$Async;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType$Instant;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class FieldType<T> {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ FieldType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004HÆ\u0003J!\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType$Instant;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "result", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;)V", "getResult", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Instant<T> extends FieldType<T> {
            private final Result result;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Instant copy$default(Instant instant, Result result, int i, Object obj) {
                if ((i & 1) != 0) {
                    result = instant.result;
                }
                return instant.copy(result);
            }

            @Nullable
            public final Result<T> component1() {
                return this.result;
            }

            @NotNull
            public final Instant<T> copy(@Nullable Result<T> result) {
                return new Instant<>(result);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Instant) && Intrinsics.areEqual(this.result, ((Instant) other).result);
            }

            public int hashCode() {
                Result result = this.result;
                if (result == null) {
                    return 0;
                }
                return result.hashCode();
            }

            @NotNull
            public String toString() {
                return "Instant(result=" + this.result + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Instant(@Nullable Result<T> result) {
                super(null);
                this.result = result;
            }

            @Nullable
            public final Result<T> getResult() {
                return this.result;
            }
        }

        private FieldType() {
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004HÆ\u0003J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType$Async;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "fetcher", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher;", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher;)V", "getFetcher", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Async<T> extends FieldType<T> {
            private final AsyncValueFetcher fetcher;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Async copy$default(Async async, AsyncValueFetcher asyncValueFetcher, int i, Object obj) {
                if ((i & 1) != 0) {
                    asyncValueFetcher = async.fetcher;
                }
                return async.copy(asyncValueFetcher);
            }

            @NotNull
            public final AsyncValueFetcher<T> component1() {
                return this.fetcher;
            }

            @NotNull
            public final Async<T> copy(@NotNull AsyncValueFetcher<T> fetcher) {
                Intrinsics.checkNotNullParameter(fetcher, "fetcher");
                return new Async<>(fetcher);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Async) && Intrinsics.areEqual(this.fetcher, ((Async) other).fetcher);
            }

            public int hashCode() {
                return this.fetcher.hashCode();
            }

            @NotNull
            public String toString() {
                return "Async(fetcher=" + this.fetcher + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Async(@NotNull AsyncValueFetcher<T> fetcher) {
                super(null);
                Intrinsics.checkNotNullParameter(fetcher, "fetcher");
                this.fetcher = fetcher;
            }

            @NotNull
            public final AsyncValueFetcher<T> getFetcher() {
                return this.fetcher;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Je\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType$Companion;", "", "()V", "just", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", ExifInterface.GPS_DIRECTION_TRUE, "value", "validator", "Lkotlin/Function1;", "", "channels", "", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "attributes", "", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/Map;)Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ FieldType just$default(Companion companion, Object obj, Function1 function1, List list, Map map, int i, Object obj2) {
                if ((i & 2) != 0) {
                    function1 = null;
                }
                if ((i & 4) != 0) {
                    list = null;
                }
                if ((i & 8) != 0) {
                    map = null;
                }
                return companion.just(obj, function1, list, map);
            }

            @NotNull
            public final <T> FieldType<T> just(T value, @Nullable Function1<? super T, Boolean> validator, @Nullable List<? extends ThomasChannelRegistration> channels, @Nullable Map<AttributeName, ? extends JsonValue> attributes) {
                if (validator == null || validator.invoke(value).booleanValue()) {
                    return new Instant(new Result(value, channels, attributes));
                }
                return new Instant(null);
            }
        }

        public final void cancel$urbanairship_layout_release() {
            if (this instanceof Async) {
                ((Async) this).getFetcher().cancel();
            } else {
                boolean z = this instanceof Instant;
            }
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 )*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002)*BG\u0012\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010%\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0003\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher;", ExifInterface.GPS_DIRECTION_TRUE, "", "fetchBlock", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult;", "processDelay", "Lkotlin/time/Duration;", "clock", "Lcom/urbanairship/util/Clock;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "(Lkotlin/jvm/functions/Function1;JLcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_resultsFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/jvm/functions/Function1;", "fetchJob", "Lkotlinx/coroutines/Deferred;", "lastAttemptTimestamp", "", "Ljava/lang/Long;", "nextBackOff", "J", "results", "Lkotlinx/coroutines/flow/StateFlow;", "getResults", "()Lkotlinx/coroutines/flow/StateFlow;", "cancel", "", "fetch", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "retryErrors", "", "(Lkotlinx/coroutines/CoroutineScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initiateFetching", "processBackOff", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResult", "result", "Companion", "PendingResult", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nThomasFormField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasFormField.kt\ncom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,424:1\n226#2,5:425\n1#3:430\n*S KotlinDebug\n*F\n+ 1 ThomasFormField.kt\ncom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher\n*L\n331#1:425,5\n*E\n"})
    public static final class AsyncValueFetcher<T> {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final long INITIAL_BACK_OFF;
        private static final long MAX_BACK_OFF;
        private final MutableStateFlow _resultsFlow;
        private final Clock clock;
        private final Function1 fetchBlock;
        private Deferred fetchJob;
        private Long lastAttemptTimestamp;
        private Duration nextBackOff;
        private final long processDelay;
        private final StateFlow results;
        private final TaskSleeper taskSleeper;

        public /* synthetic */ AsyncValueFetcher(Function1 function1, long j, Clock clock, TaskSleeper taskSleeper, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1, j, clock, taskSleeper);
        }

        private AsyncValueFetcher(Function1 fetchBlock, long j, Clock clock, TaskSleeper taskSleeper) {
            Intrinsics.checkNotNullParameter(fetchBlock, "fetchBlock");
            Intrinsics.checkNotNullParameter(clock, "clock");
            Intrinsics.checkNotNullParameter(taskSleeper, "taskSleeper");
            this.fetchBlock = fetchBlock;
            this.processDelay = j;
            this.clock = clock;
            this.taskSleeper = taskSleeper;
            MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
            this._resultsFlow = MutableStateFlow;
            this.results = FlowKt.asStateFlow(MutableStateFlow);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ AsyncValueFetcher(Function1 function1, long j, Clock DEFAULT_CLOCK, TaskSleeper taskSleeper, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                Duration.Companion companion = Duration.INSTANCE;
                j = DurationKt.toDuration(1, DurationUnit.SECONDS);
            }
            long j2 = j;
            if ((i & 4) != 0) {
                DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
                Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            }
            this(function1, j2, DEFAULT_CLOCK, (i & 8) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, null);
        }

        @NotNull
        public final StateFlow<PendingResult<T>> getResults() {
            return this.results;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$Companion;", "", "()V", "INITIAL_BACK_OFF", "Lkotlin/time/Duration;", "getINITIAL_BACK_OFF-UwyO8pc", "()J", "J", "MAX_BACK_OFF", "getMAX_BACK_OFF-UwyO8pc", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getINITIAL_BACK_OFF-UwyO8pc, reason: not valid java name */
            public final long m2737getINITIAL_BACK_OFFUwyO8pc() {
                return AsyncValueFetcher.INITIAL_BACK_OFF;
            }

            /* renamed from: getMAX_BACK_OFF-UwyO8pc, reason: not valid java name */
            public final long m2738getMAX_BACK_OFFUwyO8pc() {
                return AsyncValueFetcher.MAX_BACK_OFF;
            }
        }

        static {
            Duration.Companion companion = Duration.INSTANCE;
            DurationUnit durationUnit = DurationUnit.SECONDS;
            INITIAL_BACK_OFF = DurationKt.toDuration(3, durationUnit);
            MAX_BACK_OFF = DurationKt.toDuration(15, durationUnit);
        }

        @Nullable
        public final Object fetch(@NotNull CoroutineScope coroutineScope, boolean z, @NotNull Continuation<? super PendingResult<T>> continuation) {
            PendingResult pendingResult = (PendingResult) this.results.getValue();
            if (pendingResult != null && (!pendingResult.isError() || !z)) {
                return pendingResult;
            }
            Deferred deferred = this.fetchJob;
            if (deferred != null && deferred.isActive()) {
                return deferred.await(continuation);
            }
            Deferred deferred2 = this.fetchJob;
            if (deferred2 != null) {
                Job.DefaultImpls.cancel$default((Job) deferred2, (CancellationException) null, 1, (Object) null);
            }
            return initiateFetching(coroutineScope).await(continuation);
        }

        public final void cancel() {
            Deferred deferred = this.fetchJob;
            if (deferred != null) {
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
            }
        }

        private final Deferred initiateFetching(CoroutineScope scope) {
            Deferred deferred = this.fetchJob;
            if (deferred != null && deferred.isActive()) {
                return deferred;
            }
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(scope, null, null, new ThomasFormField$AsyncValueFetcher$initiateFetching$job$1(this._resultsFlow.getValue() == null, this, null), 3, null);
            this.fetchJob = deferredAsync$default;
            return deferredAsync$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object processBackOff(Continuation continuation) {
            Duration duration = this.nextBackOff;
            if (duration == null) {
                return Unit.INSTANCE;
            }
            long rawValue = duration.getRawValue();
            Long l = this.lastAttemptTimestamp;
            if (l == null) {
                return Unit.INSTANCE;
            }
            long jLongValue = l.longValue();
            Duration.Companion companion = Duration.INSTANCE;
            long jM3501minusLRDsOJo = Duration.m3501minusLRDsOJo(rawValue, DurationKt.toDuration(this.clock.currentTimeMillis() - jLongValue, DurationUnit.MILLISECONDS));
            if (Duration.m3500isPositiveimpl(jM3501minusLRDsOJo)) {
                Object objM2958sleepVtjQ1oo = this.taskSleeper.m2958sleepVtjQ1oo(jM3501minusLRDsOJo, continuation);
                return objM2958sleepVtjQ1oo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2958sleepVtjQ1oo : Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final PendingResult processResult(PendingResult result) {
            Object value;
            Duration durationM3465boximpl;
            MutableStateFlow mutableStateFlow = this._resultsFlow;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, result));
            this.lastAttemptTimestamp = Long.valueOf(this.clock.currentTimeMillis());
            if (result.isError()) {
                Duration duration = this.nextBackOff;
                durationM3465boximpl = Duration.m3465boximpl(duration != null ? ((Duration) ComparisonsKt.minOf(Duration.m3465boximpl(Duration.m3504timesUwyO8pc(duration.getRawValue(), 2)), Duration.m3465boximpl(MAX_BACK_OFF))).getRawValue() : INITIAL_BACK_OFF);
            } else {
                durationM3465boximpl = null;
            }
            this.nextBackOff = durationM3465boximpl;
            return result;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002:\u0003\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "isError", "", "()Z", "isInvalid", "status", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "getStatus", "()Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "value", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "getValue", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "Error", "Invalid", "Valid", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult$Error;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult$Invalid;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult$Valid;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class PendingResult<T> {
            public /* synthetic */ PendingResult(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0003\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004HÆ\u0003J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult$Valid;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult;", "result", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;)V", "getResult", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Valid<T> extends PendingResult<T> {
                private final Result result;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Valid copy$default(Valid valid, Result result, int i, Object obj) {
                    if ((i & 1) != 0) {
                        result = valid.result;
                    }
                    return valid.copy(result);
                }

                @NotNull
                public final Result<T> component1() {
                    return this.result;
                }

                @NotNull
                public final Valid<T> copy(@NotNull Result<T> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    return new Valid<>(result);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Valid) && Intrinsics.areEqual(this.result, ((Valid) other).result);
                }

                public int hashCode() {
                    return this.result.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Valid(result=" + this.result + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Valid(@NotNull Result<T> result) {
                    super(null);
                    Intrinsics.checkNotNullParameter(result, "result");
                    this.result = result;
                }

                @NotNull
                public final Result<T> getResult() {
                    return this.result;
                }
            }

            private PendingResult() {
            }

            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0003\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult$Invalid;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult;", "()V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Invalid<T> extends PendingResult<T> {
                public Invalid() {
                    super(null);
                }
            }

            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0003\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult$Error;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormField$AsyncValueFetcher$PendingResult;", "()V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Error<T> extends PendingResult<T> {
                public Error() {
                    super(null);
                }
            }

            public final boolean isError() {
                return this instanceof Error;
            }

            public final boolean isInvalid() {
                return this instanceof Invalid;
            }

            @NotNull
            public final ThomasFormFieldStatus<T> getStatus() {
                if (this instanceof Error) {
                    return new ThomasFormFieldStatus.Error();
                }
                if (this instanceof Invalid) {
                    return new ThomasFormFieldStatus.Invalid();
                }
                if (this instanceof Valid) {
                    return new ThomasFormFieldStatus.Valid(((Valid) this).getResult());
                }
                throw new NoWhenBranchMatchedException();
            }

            @Nullable
            public final Result<T> getValue() {
                if (this instanceof Valid) {
                    return ((Valid) this).getResult();
                }
                return null;
            }
        }
    }
}
