package com.urbanairship.channel;

import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.Clock;
import com.urbanairship.util.DateUtils;
import gherkin.GherkinLanguageConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u0016\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H%J\u0010\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fJ\u0018\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001dJ\u0018\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001eJ\u0018\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001fJ\u001a\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010 \u001a\u00020\fJ0\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020#H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lcom/urbanairship/channel/AttributeEditor;", "", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/util/Clock;)V", "partialMutations", "", "Lcom/urbanairship/channel/AttributeEditor$PartialAttributeMutation;", "addMutation", "Lkotlin/Result;", "", "attribute", "", Constants.FirelogAnalytics.PARAM_INSTANCE_ID, "value", "Lcom/urbanairship/json/JsonValue;", "addMutation-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)Ljava/lang/Object;", "apply", "onApply", "collapsedMutations", "", "Lcom/urbanairship/channel/AttributeMutation;", "removeAttribute", "setAttribute", "date", "Ljava/util/Date;", "number", "", "", "", "", "string", "expiration", "json", "Lcom/urbanairship/json/JsonMap;", "Companion", "PartialAttributeMutation", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAttributeEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttributeEditor.kt\ncom/urbanairship/channel/AttributeEditor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,276:1\n1#2:277\n*E\n"})
/* loaded from: classes5.dex */
public abstract class AttributeEditor {
    private final Clock clock;
    private final List partialMutations;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract void onApply(@NotNull List<? extends AttributeMutation> collapsedMutations);

    @JvmOverloads
    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, @Size(min = 1) @NotNull String instanceId, @NotNull JsonMap json) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(json, "json");
        return setAttribute$default(this, attribute, instanceId, null, json, 4, null);
    }

    protected AttributeEditor(@NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.partialMutations = new ArrayList();
    }

    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, @Size(max = 1024, min = 1) @NotNull String string) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(string, "string");
        if (string.length() <= 0 || string.length() > 1024) {
            throw new IllegalArgumentException(("Attribute string value must be less than or equal to 1024 characters in length: " + string).toString());
        }
        ResultKt.throwOnFailure(m2832addMutation0E7RQCE$default(this, attribute, null, JsonValue.wrap(string), 2, null));
        return this;
    }

    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, int number) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        ResultKt.throwOnFailure(m2832addMutation0E7RQCE$default(this, attribute, null, JsonValue.wrap(number), 2, null));
        return this;
    }

    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, long number) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        ResultKt.throwOnFailure(m2832addMutation0E7RQCE$default(this, attribute, null, JsonValue.wrap(number), 2, null));
        return this;
    }

    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, float number) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (Float.isNaN(number) || Float.isInfinite(number)) {
            throw new NumberFormatException("Infinity or NaN: " + number);
        }
        ResultKt.throwOnFailure(m2832addMutation0E7RQCE$default(this, attribute, null, JsonValue.wrap(Float.valueOf(number)), 2, null));
        return this;
    }

    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, double number) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (Double.isNaN(number) || Double.isInfinite(number)) {
            throw new NumberFormatException("Infinity or NaN: " + number);
        }
        ResultKt.throwOnFailure(m2832addMutation0E7RQCE$default(this, attribute, null, JsonValue.wrap(number), 2, null));
        return this;
    }

    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, @NotNull Date date) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(date, "date");
        String strCreateIso8601TimeStamp = DateUtils.createIso8601TimeStamp(date.getTime());
        Intrinsics.checkNotNullExpressionValue(strCreateIso8601TimeStamp, "createIso8601TimeStamp(...)");
        ResultKt.throwOnFailure(m2832addMutation0E7RQCE$default(this, attribute, null, JsonValue.wrap(strCreateIso8601TimeStamp), 2, null));
        return this;
    }

    @NotNull
    public final AttributeEditor removeAttribute(@Size(min = 1) @NotNull String attribute) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        ResultKt.throwOnFailure(m2832addMutation0E7RQCE$default(this, attribute, null, null, 2, null));
        return this;
    }

    @NotNull
    public final AttributeEditor removeAttribute(@Size(min = 1) @NotNull String attribute, @Size(min = 1) @NotNull String instanceId) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        ResultKt.throwOnFailure(m2831addMutation0E7RQCE(attribute, instanceId, null));
        return this;
    }

    public static /* synthetic */ AttributeEditor setAttribute$default(AttributeEditor attributeEditor, String str, String str2, Date date, JsonMap jsonMap, int i, Object obj) throws IllegalArgumentException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAttribute");
        }
        if ((i & 4) != 0) {
            date = null;
        }
        return attributeEditor.setAttribute(str, str2, date, jsonMap);
    }

    @JvmOverloads
    @NotNull
    public final AttributeEditor setAttribute(@Size(min = 1) @NotNull String attribute, @Size(min = 1) @NotNull String instanceId, @Nullable Date expiration, @NotNull JsonMap json) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(json, "json");
        Duration.Companion companion = Duration.INSTANCE;
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        long duration = DurationKt.toDuration(jCurrentTimeMillis, durationUnit);
        if (expiration != null) {
            long duration2 = DurationKt.toDuration(expiration.getTime(), durationUnit);
            long jM3502plusLRDsOJo = Duration.m3502plusLRDsOJo(duration, DurationKt.toDuration(731, DurationUnit.DAYS));
            if (Duration.m3466compareToLRDsOJo(duration2, duration) <= 0 || Duration.m3466compareToLRDsOJo(duration2, jM3502plusLRDsOJo) > 0) {
                throw new IllegalArgumentException("The expiration is invalid (more than 731 days or not in the future).");
            }
        }
        if (json.isEmpty()) {
            throw new IllegalArgumentException("The input `json` payload is empty.");
        }
        if (json.containsKey("exp")) {
            throw new IllegalArgumentException("The JSON contains a top-level `exp` key (reserved for expiration).");
        }
        JsonMap.Builder builderPutAll = JsonMap.newBuilder().putAll(json);
        Intrinsics.checkNotNullExpressionValue(builderPutAll, "putAll(...)");
        if (expiration != null) {
            builderPutAll.put("exp", Duration.m3488getInWholeSecondsimpl(DurationKt.toDuration(expiration.getTime(), durationUnit)));
        }
        JsonValue jsonValue = builderPutAll.build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        ResultKt.throwOnFailure(m2831addMutation0E7RQCE(attribute, instanceId, jsonValue));
        return this;
    }

    public final void apply() {
        if (this.partialMutations.size() == 0) {
            return;
        }
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.partialMutations.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((PartialAttributeMutation) it.next()).toMutation(jCurrentTimeMillis));
            } catch (IllegalArgumentException e) {
                UALog.e(e, "Invalid attribute mutation.", new Object[0]);
            }
        }
        List<AttributeMutation> listCollapseMutations = AttributeMutation.collapseMutations(arrayList);
        Intrinsics.checkNotNullExpressionValue(listCollapseMutations, "collapseMutations(...)");
        onApply(listCollapseMutations);
    }

    /* renamed from: addMutation-0E7RQCE$default, reason: not valid java name */
    static /* synthetic */ Object m2832addMutation0E7RQCE$default(AttributeEditor attributeEditor, String str, String str2, JsonValue jsonValue, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMutation-0E7RQCE");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return attributeEditor.m2831addMutation0E7RQCE(str, str2, jsonValue);
    }

    /* renamed from: addMutation-0E7RQCE, reason: not valid java name */
    private final Object m2831addMutation0E7RQCE(String attribute, String instanceId, JsonValue value) {
        if (attribute.length() == 0 || StringsKt.contains$default((CharSequence) attribute, (CharSequence) GherkinLanguageConstants.COMMENT_PREFIX, false, 2, (Object) null)) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m2968constructorimpl(ResultKt.createFailure(new IllegalArgumentException("Attribute must not be empty or contain '#'")));
        }
        if (instanceId != null && (instanceId.length() == 0 || StringsKt.contains$default((CharSequence) instanceId, (CharSequence) GherkinLanguageConstants.COMMENT_PREFIX, false, 2, (Object) null))) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m2968constructorimpl(ResultKt.createFailure(new IllegalArgumentException("Instance ID must not be empty or contain '#'")));
        }
        if (instanceId != null) {
            attribute = attribute + '#' + instanceId;
        }
        this.partialMutations.add(new PartialAttributeMutation(this, attribute, value));
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m2968constructorimpl(Unit.INSTANCE);
    }

    private final class PartialAttributeMutation {
        private String key;
        final /* synthetic */ AttributeEditor this$0;
        private Object value;

        public PartialAttributeMutation(AttributeEditor attributeEditor, String key, Object obj) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.this$0 = attributeEditor;
            this.key = key;
            this.value = obj;
        }

        public final AttributeMutation toMutation(long j) {
            Object obj = this.value;
            if (obj != null) {
                AttributeMutation attributeMutationNewSetAttributeMutation = AttributeMutation.newSetAttributeMutation(this.key, JsonValue.wrapOpt(obj), j);
                Intrinsics.checkNotNull(attributeMutationNewSetAttributeMutation);
                return attributeMutationNewSetAttributeMutation;
            }
            AttributeMutation attributeMutationNewRemoveAttributeMutation = AttributeMutation.newRemoveAttributeMutation(this.key, j);
            Intrinsics.checkNotNull(attributeMutationNewRemoveAttributeMutation);
            return attributeMutationNewRemoveAttributeMutation;
        }
    }
}
