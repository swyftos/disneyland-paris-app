package com.urbanairship.automation;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.audience.AudienceSelector;
import com.urbanairship.automation.engine.SchedulePrepareResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/automation/AutomationAudience;", "Lcom/urbanairship/json/JsonSerializable;", "audienceSelector", "Lcom/urbanairship/audience/AudienceSelector;", "missBehavior", "Lcom/urbanairship/automation/AutomationAudience$MissBehavior;", "(Lcom/urbanairship/audience/AudienceSelector;Lcom/urbanairship/automation/AutomationAudience$MissBehavior;)V", "getAudienceSelector$urbanairship_automation_release", "()Lcom/urbanairship/audience/AudienceSelector;", "getMissBehavior$urbanairship_automation_release", "()Lcom/urbanairship/automation/AutomationAudience$MissBehavior;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "MissBehavior", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationAudience implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AudienceSelector audienceSelector;
    private final MissBehavior missBehavior;

    public AutomationAudience(@NotNull AudienceSelector audienceSelector, @Nullable MissBehavior missBehavior) {
        Intrinsics.checkNotNullParameter(audienceSelector, "audienceSelector");
        this.audienceSelector = audienceSelector;
        this.missBehavior = missBehavior;
    }

    public /* synthetic */ AutomationAudience(AudienceSelector audienceSelector, MissBehavior missBehavior, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(audienceSelector, (i & 2) != 0 ? null : missBehavior);
    }

    @NotNull
    /* renamed from: getAudienceSelector$urbanairship_automation_release, reason: from getter */
    public final AudienceSelector getAudienceSelector() {
        return this.audienceSelector;
    }

    @Nullable
    /* renamed from: getMissBehavior$urbanairship_automation_release, reason: from getter */
    public final MissBehavior getMissBehavior() {
        return this.missBehavior;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/AutomationAudience$MissBehavior;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toPrepareResult", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "toPrepareResult$urbanairship_automation_release", "CANCEL", "SKIP", "PENALIZE", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MissBehavior implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MissBehavior[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final MissBehavior CANCEL = new MissBehavior("CANCEL", 0, "cancel");
        public static final MissBehavior SKIP = new MissBehavior("SKIP", 1, "skip");
        public static final MissBehavior PENALIZE = new MissBehavior("PENALIZE", 2, "penalize");

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MissBehavior.values().length];
                try {
                    iArr[MissBehavior.CANCEL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MissBehavior.SKIP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MissBehavior.PENALIZE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ MissBehavior[] $values() {
            return new MissBehavior[]{CANCEL, SKIP, PENALIZE};
        }

        @NotNull
        public static EnumEntries<MissBehavior> getEntries() {
            return $ENTRIES;
        }

        public static MissBehavior valueOf(String str) {
            return (MissBehavior) Enum.valueOf(MissBehavior.class, str);
        }

        public static MissBehavior[] values() {
            return (MissBehavior[]) $VALUES.clone();
        }

        private MissBehavior(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            MissBehavior[] missBehaviorArr$values = $values();
            $VALUES = missBehaviorArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(missBehaviorArr$values);
            INSTANCE = new Companion(null);
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/AutomationAudience$MissBehavior$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/AutomationAudience$MissBehavior;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nAutomationAudience.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationAudience.kt\ncom/urbanairship/automation/AutomationAudience$MissBehavior$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n288#2,2:123\n*S KotlinDebug\n*F\n+ 1 AutomationAudience.kt\ncom/urbanairship/automation/AutomationAudience$MissBehavior$Companion\n*L\n45#1:123,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final MissBehavior fromJson(@NotNull JsonValue value) throws JsonException {
                MissBehavior next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                String lowerCase = strRequireString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Iterator<MissBehavior> it = MissBehavior.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), lowerCase)) {
                        break;
                    }
                }
                MissBehavior missBehavior = next;
                if (missBehavior != null) {
                    return missBehavior;
                }
                throw new JsonException("invalid miss behavior " + lowerCase);
            }
        }

        @NotNull
        public final SchedulePrepareResult toPrepareResult$urbanairship_automation_release() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return SchedulePrepareResult.Cancel.INSTANCE;
            }
            if (i == 2) {
                return SchedulePrepareResult.Skip.INSTANCE;
            }
            if (i == 3) {
                return SchedulePrepareResult.Penalize.INSTANCE;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/automation/AutomationAudience$Companion;", "", "()V", "MISS_BEHAVIOR", "", "fromJson", "Lcom/urbanairship/automation/AutomationAudience;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationAudience.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationAudience.kt\ncom/urbanairship/automation/AutomationAudience$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomationAudience fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            AudienceSelector audienceSelectorFromJson = AudienceSelector.INSTANCE.fromJson(value);
            JsonValue jsonValue = value.optMap().get("miss_behavior");
            return new AutomationAudience(audienceSelectorFromJson, jsonValue != null ? MissBehavior.INSTANCE.fromJson(jsonValue) : null);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().putAll(this.audienceSelector.getJsonValue().optMap()).putOpt("miss_behavior", this.missBehavior).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AutomationAudience.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.AutomationAudience");
        AutomationAudience automationAudience = (AutomationAudience) other;
        return Intrinsics.areEqual(this.audienceSelector, automationAudience.audienceSelector) && this.missBehavior == automationAudience.missBehavior;
    }

    public int hashCode() {
        return Objects.hash(this.audienceSelector, this.missBehavior);
    }
}
