package com.urbanairship.featureflag;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.audience.AudienceSelector;
import com.urbanairship.experiment.TimeCriteria;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u0000 =2\u00020\u0001:\u0001=Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\u0081\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006>"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagInfo;", "", "id", "", "created", "", "lastUpdated", "name", "reportingContext", "Lcom/urbanairship/json/JsonMap;", "audience", "Lcom/urbanairship/audience/AudienceSelector;", "compoundAudienceSelector", "Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "timeCriteria", "Lcom/urbanairship/experiment/TimeCriteria;", "payload", "Lcom/urbanairship/featureflag/FeatureFlagPayload;", "evaluationOptions", "Lcom/urbanairship/featureflag/EvaluationOptions;", "controlOptions", "Lcom/urbanairship/featureflag/ControlOptions;", "(Ljava/lang/String;JJLjava/lang/String;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/audience/AudienceSelector;Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;Lcom/urbanairship/experiment/TimeCriteria;Lcom/urbanairship/featureflag/FeatureFlagPayload;Lcom/urbanairship/featureflag/EvaluationOptions;Lcom/urbanairship/featureflag/ControlOptions;)V", "getAudience", "()Lcom/urbanairship/audience/AudienceSelector;", "getCompoundAudienceSelector", "()Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "getControlOptions", "()Lcom/urbanairship/featureflag/ControlOptions;", "getCreated", "()J", "getEvaluationOptions", "()Lcom/urbanairship/featureflag/EvaluationOptions;", "getId", "()Ljava/lang/String;", "getLastUpdated", "getName", "getPayload", "()Lcom/urbanairship/featureflag/FeatureFlagPayload;", "getReportingContext", "()Lcom/urbanairship/json/JsonMap;", "getTimeCriteria", "()Lcom/urbanairship/experiment/TimeCriteria;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeatureFlagInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AudienceSelector audience;
    private final FeatureFlagCompoundAudience compoundAudienceSelector;
    private final ControlOptions controlOptions;
    private final long created;
    private final EvaluationOptions evaluationOptions;
    private final String id;
    private final long lastUpdated;
    private final String name;
    private final FeatureFlagPayload payload;
    private final JsonMap reportingContext;
    private final TimeCriteria timeCriteria;

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final EvaluationOptions getEvaluationOptions() {
        return this.evaluationOptions;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final ControlOptions getControlOptions() {
        return this.controlOptions;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCreated() {
        return this.created;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final JsonMap getReportingContext() {
        return this.reportingContext;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final AudienceSelector getAudience() {
        return this.audience;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final FeatureFlagCompoundAudience getCompoundAudienceSelector() {
        return this.compoundAudienceSelector;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final TimeCriteria getTimeCriteria() {
        return this.timeCriteria;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final FeatureFlagPayload getPayload() {
        return this.payload;
    }

    @NotNull
    public final FeatureFlagInfo copy(@NotNull String id, long created, long lastUpdated, @NotNull String name, @NotNull JsonMap reportingContext, @Nullable AudienceSelector audience, @Nullable FeatureFlagCompoundAudience compoundAudienceSelector, @Nullable TimeCriteria timeCriteria, @NotNull FeatureFlagPayload payload, @Nullable EvaluationOptions evaluationOptions, @Nullable ControlOptions controlOptions) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reportingContext, "reportingContext");
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new FeatureFlagInfo(id, created, lastUpdated, name, reportingContext, audience, compoundAudienceSelector, timeCriteria, payload, evaluationOptions, controlOptions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureFlagInfo)) {
            return false;
        }
        FeatureFlagInfo featureFlagInfo = (FeatureFlagInfo) other;
        return Intrinsics.areEqual(this.id, featureFlagInfo.id) && this.created == featureFlagInfo.created && this.lastUpdated == featureFlagInfo.lastUpdated && Intrinsics.areEqual(this.name, featureFlagInfo.name) && Intrinsics.areEqual(this.reportingContext, featureFlagInfo.reportingContext) && Intrinsics.areEqual(this.audience, featureFlagInfo.audience) && Intrinsics.areEqual(this.compoundAudienceSelector, featureFlagInfo.compoundAudienceSelector) && Intrinsics.areEqual(this.timeCriteria, featureFlagInfo.timeCriteria) && Intrinsics.areEqual(this.payload, featureFlagInfo.payload) && Intrinsics.areEqual(this.evaluationOptions, featureFlagInfo.evaluationOptions) && Intrinsics.areEqual(this.controlOptions, featureFlagInfo.controlOptions);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + Long.hashCode(this.created)) * 31) + Long.hashCode(this.lastUpdated)) * 31) + this.name.hashCode()) * 31) + this.reportingContext.hashCode()) * 31;
        AudienceSelector audienceSelector = this.audience;
        int iHashCode2 = (iHashCode + (audienceSelector == null ? 0 : audienceSelector.hashCode())) * 31;
        FeatureFlagCompoundAudience featureFlagCompoundAudience = this.compoundAudienceSelector;
        int iHashCode3 = (iHashCode2 + (featureFlagCompoundAudience == null ? 0 : featureFlagCompoundAudience.hashCode())) * 31;
        TimeCriteria timeCriteria = this.timeCriteria;
        int iHashCode4 = (((iHashCode3 + (timeCriteria == null ? 0 : timeCriteria.hashCode())) * 31) + this.payload.hashCode()) * 31;
        EvaluationOptions evaluationOptions = this.evaluationOptions;
        int iHashCode5 = (iHashCode4 + (evaluationOptions == null ? 0 : evaluationOptions.hashCode())) * 31;
        ControlOptions controlOptions = this.controlOptions;
        return iHashCode5 + (controlOptions != null ? controlOptions.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FeatureFlagInfo(id=" + this.id + ", created=" + this.created + ", lastUpdated=" + this.lastUpdated + ", name=" + this.name + ", reportingContext=" + this.reportingContext + ", audience=" + this.audience + ", compoundAudienceSelector=" + this.compoundAudienceSelector + ", timeCriteria=" + this.timeCriteria + ", payload=" + this.payload + ", evaluationOptions=" + this.evaluationOptions + ", controlOptions=" + this.controlOptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public FeatureFlagInfo(@NotNull String id, long j, long j2, @NotNull String name, @NotNull JsonMap reportingContext, @Nullable AudienceSelector audienceSelector, @Nullable FeatureFlagCompoundAudience featureFlagCompoundAudience, @Nullable TimeCriteria timeCriteria, @NotNull FeatureFlagPayload payload, @Nullable EvaluationOptions evaluationOptions, @Nullable ControlOptions controlOptions) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reportingContext, "reportingContext");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.id = id;
        this.created = j;
        this.lastUpdated = j2;
        this.name = name;
        this.reportingContext = reportingContext;
        this.audience = audienceSelector;
        this.compoundAudienceSelector = featureFlagCompoundAudience;
        this.timeCriteria = timeCriteria;
        this.payload = payload;
        this.evaluationOptions = evaluationOptions;
        this.controlOptions = controlOptions;
    }

    public /* synthetic */ FeatureFlagInfo(String str, long j, long j2, String str2, JsonMap jsonMap, AudienceSelector audienceSelector, FeatureFlagCompoundAudience featureFlagCompoundAudience, TimeCriteria timeCriteria, FeatureFlagPayload featureFlagPayload, EvaluationOptions evaluationOptions, ControlOptions controlOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, str2, jsonMap, (i & 32) != 0 ? null : audienceSelector, (i & 64) != 0 ? null : featureFlagCompoundAudience, (i & 128) != 0 ? null : timeCriteria, featureFlagPayload, (i & 512) != 0 ? null : evaluationOptions, (i & 1024) != 0 ? null : controlOptions);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getCreated() {
        return this.created;
    }

    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final JsonMap getReportingContext() {
        return this.reportingContext;
    }

    @Nullable
    public final AudienceSelector getAudience() {
        return this.audience;
    }

    @Nullable
    public final FeatureFlagCompoundAudience getCompoundAudienceSelector() {
        return this.compoundAudienceSelector;
    }

    @Nullable
    public final TimeCriteria getTimeCriteria() {
        return this.timeCriteria;
    }

    @NotNull
    public final FeatureFlagPayload getPayload() {
        return this.payload;
    }

    @Nullable
    public final EvaluationOptions getEvaluationOptions() {
        return this.evaluationOptions;
    }

    @Nullable
    public final ControlOptions getControlOptions() {
        return this.controlOptions;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagInfo$Companion;", "", "()V", "KEY_AUDIENCE_SELECTOR", "", "KEY_COMPOUND_AUDIENCE_SELECTOR", "KEY_CONTROL_OPTIONS", "KEY_CREATED", "KEY_DEFERRED", "KEY_EVALUATION_OPTIONS", "KEY_ID", "KEY_LAST_UPDATED", "KEY_NAME", "KEY_PAYLOAD", "KEY_REPORTING_METADATA", "KEY_TIME_CRITERIA", "KEY_TYPE", "KEY_URL", "KEY_VARIABLES", "fromJson", "Lcom/urbanairship/featureflag/FeatureFlagInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "fromJson$urbanairship_feature_flag_release", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFeatureFlagInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/FeatureFlagInfo$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,401:1\n1#2:402\n44#3,15:403\n44#3,15:420\n79#3,16:435\n44#3,15:451\n44#3,15:466\n44#3,15:481\n44#3,15:496\n288#4,2:418\n*S KotlinDebug\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/FeatureFlagInfo$Companion\n*L\n240#1:403,15\n249#1:420,15\n255#1:435,16\n263#1:451,15\n264#1:466,15\n265#1:481,15\n266#1:496,15\n241#1:418,2\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FeatureFlagPayloadType.values().length];
                try {
                    iArr[FeatureFlagPayloadType.DEFERRED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FeatureFlagPayloadType.STATIC.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:347:0x07fa A[Catch: JsonException -> 0x0028, ParseException -> 0x0c81, TryCatch #2 {JsonException -> 0x0028, ParseException -> 0x0c81, blocks: (B:3:0x000b, B:5:0x0020, B:8:0x002d, B:10:0x0035, B:12:0x0040, B:15:0x004a, B:18:0x006d, B:70:0x0191, B:71:0x0199, B:73:0x019f, B:77:0x01b2, B:79:0x01b6, B:84:0x01c6, B:146:0x031a, B:148:0x0322, B:250:0x05a9, B:252:0x05b1, B:254:0x05bf, B:306:0x06db, B:308:0x06e3, B:310:0x06f1, B:345:0x07ee, B:347:0x07fa, B:349:0x0808, B:383:0x0901, B:385:0x090d, B:387:0x091b, B:439:0x0a3a, B:441:0x0a53, B:443:0x0a5e, B:445:0x0a6a, B:447:0x0a75, B:449:0x0a7d, B:451:0x0a88, B:390:0x0924, B:391:0x0929, B:392:0x092a, B:394:0x0934, B:397:0x093b, B:398:0x0940, B:399:0x0941, B:401:0x094d, B:402:0x0959, B:404:0x0965, B:405:0x0972, B:407:0x097c, B:408:0x098d, B:410:0x0999, B:411:0x09a7, B:413:0x09b3, B:414:0x09c0, B:416:0x09ca, B:417:0x09d7, B:419:0x09e1, B:420:0x09f2, B:422:0x09fc, B:424:0x0a02, B:425:0x0a06, B:426:0x0a0b, B:427:0x0a0c, B:429:0x0a16, B:431:0x0a1c, B:432:0x0a20, B:433:0x0a25, B:434:0x0a26, B:436:0x0a30, B:438:0x0a36, B:453:0x0a96, B:454:0x0a9b, B:455:0x0a9c, B:456:0x0ac1, B:457:0x0ac2, B:458:0x0adb, B:350:0x080e, B:352:0x0818, B:353:0x081e, B:355:0x082a, B:356:0x0837, B:358:0x0843, B:359:0x0851, B:361:0x085b, B:362:0x086d, B:364:0x0879, B:365:0x0887, B:367:0x0893, B:368:0x089f, B:370:0x08a9, B:371:0x08b5, B:373:0x08bf, B:374:0x08cf, B:376:0x08d9, B:377:0x08e0, B:379:0x08ea, B:380:0x08f1, B:382:0x08fb, B:459:0x0adc, B:460:0x0b01, B:461:0x0b02, B:462:0x0b1b, B:312:0x06f9, B:314:0x0703, B:315:0x0708, B:317:0x0714, B:318:0x0720, B:320:0x072c, B:321:0x073c, B:323:0x0748, B:324:0x075a, B:326:0x0766, B:327:0x0774, B:329:0x0780, B:330:0x078c, B:332:0x0796, B:333:0x07a2, B:335:0x07ac, B:336:0x07bc, B:338:0x07c6, B:339:0x07cd, B:341:0x07d7, B:342:0x07de, B:344:0x07e8, B:463:0x0b1c, B:464:0x0b41, B:465:0x0b42, B:466:0x0b5b, B:257:0x05c7, B:258:0x05cc, B:259:0x05cd, B:261:0x05d7, B:264:0x05df, B:265:0x05e4, B:266:0x05e5, B:268:0x05f1, B:269:0x05fe, B:271:0x060a, B:272:0x0618, B:274:0x0622, B:275:0x0634, B:277:0x0640, B:278:0x064e, B:280:0x065a, B:281:0x0667, B:283:0x0671, B:284:0x067d, B:286:0x0687, B:287:0x0697, B:289:0x06a1, B:291:0x06a7, B:292:0x06aa, B:293:0x06af, B:294:0x06b0, B:296:0x06ba, B:298:0x06c0, B:299:0x06c3, B:300:0x06c8, B:301:0x06c9, B:303:0x06d3, B:305:0x06d9, B:467:0x0b5c, B:468:0x0b61, B:469:0x0b62, B:470:0x0b86, B:471:0x0b87, B:472:0x0ba0, B:87:0x01d2, B:89:0x01e0, B:91:0x01e6, B:93:0x01eb, B:94:0x01f0, B:95:0x01f1, B:97:0x01fb, B:99:0x0201, B:100:0x0204, B:101:0x0209, B:102:0x020a, B:104:0x0216, B:105:0x0222, B:107:0x022e, B:108:0x023d, B:110:0x0248, B:111:0x025a, B:113:0x0266, B:114:0x0274, B:116:0x0280, B:117:0x028d, B:119:0x0297, B:120:0x02a4, B:122:0x02b0, B:123:0x02bc, B:125:0x02c6, B:126:0x02d6, B:128:0x02e0, B:130:0x02e6, B:131:0x02e9, B:132:0x02ee, B:133:0x02ef, B:135:0x02f9, B:138:0x0300, B:139:0x0305, B:140:0x0306, B:142:0x0310, B:144:0x0316, B:149:0x0329, B:150:0x032e, B:151:0x032f, B:152:0x0352, B:153:0x0353, B:154:0x0358, B:155:0x0359, B:157:0x0362, B:159:0x0370, B:161:0x0376, B:211:0x048e, B:213:0x0496, B:215:0x04a4, B:249:0x059d, B:216:0x04aa, B:218:0x04b4, B:219:0x04ba, B:221:0x04c6, B:222:0x04d3, B:224:0x04df, B:225:0x04ed, B:227:0x04f7, B:228:0x0509, B:230:0x0515, B:231:0x0523, B:233:0x052f, B:234:0x053b, B:236:0x0545, B:237:0x0551, B:239:0x055b, B:240:0x056b, B:242:0x0575, B:243:0x057c, B:245:0x0586, B:246:0x058d, B:248:0x0597, B:473:0x0ba1, B:474:0x0bc5, B:475:0x0bc6, B:476:0x0bdf, B:162:0x037a, B:163:0x037f, B:164:0x0380, B:166:0x038a, B:168:0x0390, B:169:0x0394, B:170:0x0399, B:171:0x039a, B:173:0x03a6, B:174:0x03b3, B:176:0x03bf, B:177:0x03cd, B:179:0x03d7, B:180:0x03e9, B:182:0x03f5, B:183:0x0403, B:185:0x040f, B:186:0x041c, B:188:0x0426, B:189:0x0432, B:191:0x043c, B:192:0x044c, B:194:0x0456, B:196:0x045c, B:197:0x045f, B:198:0x0464, B:199:0x0465, B:201:0x046f, B:204:0x0476, B:205:0x047b, B:206:0x047c, B:208:0x0486, B:210:0x048c, B:477:0x0be0, B:478:0x0be5, B:479:0x0be6, B:480:0x0c0a, B:481:0x0c0b, B:482:0x0c24, B:483:0x0c25, B:484:0x0c3b, B:21:0x0075, B:22:0x007a, B:23:0x007b, B:25:0x0085, B:28:0x008d, B:29:0x0092, B:30:0x0093, B:32:0x009f, B:33:0x00ab, B:35:0x00b7, B:36:0x00c6, B:38:0x00d0, B:39:0x00e3, B:41:0x00ef, B:42:0x00fe, B:44:0x010a, B:45:0x0118, B:47:0x0122, B:48:0x012f, B:50:0x0139, B:51:0x014a, B:53:0x0154, B:55:0x015a, B:56:0x015e, B:57:0x0163, B:58:0x0164, B:60:0x016e, B:62:0x0174, B:63:0x0178, B:64:0x017d, B:65:0x017e, B:67:0x0188, B:69:0x018e, B:485:0x0c3c, B:486:0x0c41, B:487:0x0c42, B:488:0x0c66, B:489:0x0c67, B:490:0x0c80), top: B:495:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:461:0x0b02 A[Catch: JsonException -> 0x0028, ParseException -> 0x0c81, TryCatch #2 {JsonException -> 0x0028, ParseException -> 0x0c81, blocks: (B:3:0x000b, B:5:0x0020, B:8:0x002d, B:10:0x0035, B:12:0x0040, B:15:0x004a, B:18:0x006d, B:70:0x0191, B:71:0x0199, B:73:0x019f, B:77:0x01b2, B:79:0x01b6, B:84:0x01c6, B:146:0x031a, B:148:0x0322, B:250:0x05a9, B:252:0x05b1, B:254:0x05bf, B:306:0x06db, B:308:0x06e3, B:310:0x06f1, B:345:0x07ee, B:347:0x07fa, B:349:0x0808, B:383:0x0901, B:385:0x090d, B:387:0x091b, B:439:0x0a3a, B:441:0x0a53, B:443:0x0a5e, B:445:0x0a6a, B:447:0x0a75, B:449:0x0a7d, B:451:0x0a88, B:390:0x0924, B:391:0x0929, B:392:0x092a, B:394:0x0934, B:397:0x093b, B:398:0x0940, B:399:0x0941, B:401:0x094d, B:402:0x0959, B:404:0x0965, B:405:0x0972, B:407:0x097c, B:408:0x098d, B:410:0x0999, B:411:0x09a7, B:413:0x09b3, B:414:0x09c0, B:416:0x09ca, B:417:0x09d7, B:419:0x09e1, B:420:0x09f2, B:422:0x09fc, B:424:0x0a02, B:425:0x0a06, B:426:0x0a0b, B:427:0x0a0c, B:429:0x0a16, B:431:0x0a1c, B:432:0x0a20, B:433:0x0a25, B:434:0x0a26, B:436:0x0a30, B:438:0x0a36, B:453:0x0a96, B:454:0x0a9b, B:455:0x0a9c, B:456:0x0ac1, B:457:0x0ac2, B:458:0x0adb, B:350:0x080e, B:352:0x0818, B:353:0x081e, B:355:0x082a, B:356:0x0837, B:358:0x0843, B:359:0x0851, B:361:0x085b, B:362:0x086d, B:364:0x0879, B:365:0x0887, B:367:0x0893, B:368:0x089f, B:370:0x08a9, B:371:0x08b5, B:373:0x08bf, B:374:0x08cf, B:376:0x08d9, B:377:0x08e0, B:379:0x08ea, B:380:0x08f1, B:382:0x08fb, B:459:0x0adc, B:460:0x0b01, B:461:0x0b02, B:462:0x0b1b, B:312:0x06f9, B:314:0x0703, B:315:0x0708, B:317:0x0714, B:318:0x0720, B:320:0x072c, B:321:0x073c, B:323:0x0748, B:324:0x075a, B:326:0x0766, B:327:0x0774, B:329:0x0780, B:330:0x078c, B:332:0x0796, B:333:0x07a2, B:335:0x07ac, B:336:0x07bc, B:338:0x07c6, B:339:0x07cd, B:341:0x07d7, B:342:0x07de, B:344:0x07e8, B:463:0x0b1c, B:464:0x0b41, B:465:0x0b42, B:466:0x0b5b, B:257:0x05c7, B:258:0x05cc, B:259:0x05cd, B:261:0x05d7, B:264:0x05df, B:265:0x05e4, B:266:0x05e5, B:268:0x05f1, B:269:0x05fe, B:271:0x060a, B:272:0x0618, B:274:0x0622, B:275:0x0634, B:277:0x0640, B:278:0x064e, B:280:0x065a, B:281:0x0667, B:283:0x0671, B:284:0x067d, B:286:0x0687, B:287:0x0697, B:289:0x06a1, B:291:0x06a7, B:292:0x06aa, B:293:0x06af, B:294:0x06b0, B:296:0x06ba, B:298:0x06c0, B:299:0x06c3, B:300:0x06c8, B:301:0x06c9, B:303:0x06d3, B:305:0x06d9, B:467:0x0b5c, B:468:0x0b61, B:469:0x0b62, B:470:0x0b86, B:471:0x0b87, B:472:0x0ba0, B:87:0x01d2, B:89:0x01e0, B:91:0x01e6, B:93:0x01eb, B:94:0x01f0, B:95:0x01f1, B:97:0x01fb, B:99:0x0201, B:100:0x0204, B:101:0x0209, B:102:0x020a, B:104:0x0216, B:105:0x0222, B:107:0x022e, B:108:0x023d, B:110:0x0248, B:111:0x025a, B:113:0x0266, B:114:0x0274, B:116:0x0280, B:117:0x028d, B:119:0x0297, B:120:0x02a4, B:122:0x02b0, B:123:0x02bc, B:125:0x02c6, B:126:0x02d6, B:128:0x02e0, B:130:0x02e6, B:131:0x02e9, B:132:0x02ee, B:133:0x02ef, B:135:0x02f9, B:138:0x0300, B:139:0x0305, B:140:0x0306, B:142:0x0310, B:144:0x0316, B:149:0x0329, B:150:0x032e, B:151:0x032f, B:152:0x0352, B:153:0x0353, B:154:0x0358, B:155:0x0359, B:157:0x0362, B:159:0x0370, B:161:0x0376, B:211:0x048e, B:213:0x0496, B:215:0x04a4, B:249:0x059d, B:216:0x04aa, B:218:0x04b4, B:219:0x04ba, B:221:0x04c6, B:222:0x04d3, B:224:0x04df, B:225:0x04ed, B:227:0x04f7, B:228:0x0509, B:230:0x0515, B:231:0x0523, B:233:0x052f, B:234:0x053b, B:236:0x0545, B:237:0x0551, B:239:0x055b, B:240:0x056b, B:242:0x0575, B:243:0x057c, B:245:0x0586, B:246:0x058d, B:248:0x0597, B:473:0x0ba1, B:474:0x0bc5, B:475:0x0bc6, B:476:0x0bdf, B:162:0x037a, B:163:0x037f, B:164:0x0380, B:166:0x038a, B:168:0x0390, B:169:0x0394, B:170:0x0399, B:171:0x039a, B:173:0x03a6, B:174:0x03b3, B:176:0x03bf, B:177:0x03cd, B:179:0x03d7, B:180:0x03e9, B:182:0x03f5, B:183:0x0403, B:185:0x040f, B:186:0x041c, B:188:0x0426, B:189:0x0432, B:191:0x043c, B:192:0x044c, B:194:0x0456, B:196:0x045c, B:197:0x045f, B:198:0x0464, B:199:0x0465, B:201:0x046f, B:204:0x0476, B:205:0x047b, B:206:0x047c, B:208:0x0486, B:210:0x048c, B:477:0x0be0, B:478:0x0be5, B:479:0x0be6, B:480:0x0c0a, B:481:0x0c0b, B:482:0x0c24, B:483:0x0c25, B:484:0x0c3b, B:21:0x0075, B:22:0x007a, B:23:0x007b, B:25:0x0085, B:28:0x008d, B:29:0x0092, B:30:0x0093, B:32:0x009f, B:33:0x00ab, B:35:0x00b7, B:36:0x00c6, B:38:0x00d0, B:39:0x00e3, B:41:0x00ef, B:42:0x00fe, B:44:0x010a, B:45:0x0118, B:47:0x0122, B:48:0x012f, B:50:0x0139, B:51:0x014a, B:53:0x0154, B:55:0x015a, B:56:0x015e, B:57:0x0163, B:58:0x0164, B:60:0x016e, B:62:0x0174, B:63:0x0178, B:64:0x017d, B:65:0x017e, B:67:0x0188, B:69:0x018e, B:485:0x0c3c, B:486:0x0c41, B:487:0x0c42, B:488:0x0c66, B:489:0x0c67, B:490:0x0c80), top: B:495:0x000b }] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.featureflag.FeatureFlagInfo fromJson$urbanairship_feature_flag_release(@org.jetbrains.annotations.NotNull final com.urbanairship.json.JsonMap r30) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 3221
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagInfo.Companion.fromJson$urbanairship_feature_flag_release(com.urbanairship.json.JsonMap):com.urbanairship.featureflag.FeatureFlagInfo");
        }
    }
}
