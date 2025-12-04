package com.urbanairship.experiment;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.audience.AudienceSelector;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0080\b\u0018\u0000 =2\u00020\u0001:\u0001=Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003Jw\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\u000e\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\tJ\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lcom/urbanairship/experiment/Experiment;", "", "id", "", "type", "Lcom/urbanairship/experiment/ExperimentType;", "resolutionType", "Lcom/urbanairship/experiment/ResolutionType;", "created", "", "lastUpdated", "reportingMetadata", "Lcom/urbanairship/json/JsonMap;", "audience", "Lcom/urbanairship/audience/AudienceSelector;", "compoundAudienceSelector", "Lcom/urbanairship/experiment/ExperimentCompoundAudience;", "exclusions", "", "Lcom/urbanairship/experiment/MessageCriteria;", "timeCriteria", "Lcom/urbanairship/experiment/TimeCriteria;", "(Ljava/lang/String;Lcom/urbanairship/experiment/ExperimentType;Lcom/urbanairship/experiment/ResolutionType;JJLcom/urbanairship/json/JsonMap;Lcom/urbanairship/audience/AudienceSelector;Lcom/urbanairship/experiment/ExperimentCompoundAudience;Ljava/util/List;Lcom/urbanairship/experiment/TimeCriteria;)V", "getAudience", "()Lcom/urbanairship/audience/AudienceSelector;", "getCompoundAudienceSelector", "()Lcom/urbanairship/experiment/ExperimentCompoundAudience;", "getCreated", "()J", "getExclusions", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getLastUpdated", "getReportingMetadata", "()Lcom/urbanairship/json/JsonMap;", "getResolutionType", "()Lcom/urbanairship/experiment/ResolutionType;", "getTimeCriteria", "()Lcom/urbanairship/experiment/TimeCriteria;", "getType", "()Lcom/urbanairship/experiment/ExperimentType;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "isActive", "date", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Experiment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_ID = "experiment_id";
    private final AudienceSelector audience;
    private final ExperimentCompoundAudience compoundAudienceSelector;
    private final long created;
    private final List exclusions;
    private final String id;
    private final long lastUpdated;
    private final JsonMap reportingMetadata;
    private final ResolutionType resolutionType;
    private final TimeCriteria timeCriteria;
    private final ExperimentType type;

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final TimeCriteria getTimeCriteria() {
        return this.timeCriteria;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ExperimentType getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final ResolutionType getResolutionType() {
        return this.resolutionType;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreated() {
        return this.created;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final AudienceSelector getAudience() {
        return this.audience;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final ExperimentCompoundAudience getCompoundAudienceSelector() {
        return this.compoundAudienceSelector;
    }

    @NotNull
    public final List<MessageCriteria> component9() {
        return this.exclusions;
    }

    @NotNull
    public final Experiment copy(@NotNull String id, @NotNull ExperimentType type, @NotNull ResolutionType resolutionType, long created, long lastUpdated, @NotNull JsonMap reportingMetadata, @NotNull AudienceSelector audience, @Nullable ExperimentCompoundAudience compoundAudienceSelector, @NotNull List<MessageCriteria> exclusions, @Nullable TimeCriteria timeCriteria) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(resolutionType, "resolutionType");
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        Intrinsics.checkNotNullParameter(audience, "audience");
        Intrinsics.checkNotNullParameter(exclusions, "exclusions");
        return new Experiment(id, type, resolutionType, created, lastUpdated, reportingMetadata, audience, compoundAudienceSelector, exclusions, timeCriteria);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Experiment)) {
            return false;
        }
        Experiment experiment = (Experiment) other;
        return Intrinsics.areEqual(this.id, experiment.id) && this.type == experiment.type && this.resolutionType == experiment.resolutionType && this.created == experiment.created && this.lastUpdated == experiment.lastUpdated && Intrinsics.areEqual(this.reportingMetadata, experiment.reportingMetadata) && Intrinsics.areEqual(this.audience, experiment.audience) && Intrinsics.areEqual(this.compoundAudienceSelector, experiment.compoundAudienceSelector) && Intrinsics.areEqual(this.exclusions, experiment.exclusions) && Intrinsics.areEqual(this.timeCriteria, experiment.timeCriteria);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.resolutionType.hashCode()) * 31) + Long.hashCode(this.created)) * 31) + Long.hashCode(this.lastUpdated)) * 31) + this.reportingMetadata.hashCode()) * 31) + this.audience.hashCode()) * 31;
        ExperimentCompoundAudience experimentCompoundAudience = this.compoundAudienceSelector;
        int iHashCode2 = (((iHashCode + (experimentCompoundAudience == null ? 0 : experimentCompoundAudience.hashCode())) * 31) + this.exclusions.hashCode()) * 31;
        TimeCriteria timeCriteria = this.timeCriteria;
        return iHashCode2 + (timeCriteria != null ? timeCriteria.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Experiment(id=" + this.id + ", type=" + this.type + ", resolutionType=" + this.resolutionType + ", created=" + this.created + ", lastUpdated=" + this.lastUpdated + ", reportingMetadata=" + this.reportingMetadata + ", audience=" + this.audience + ", compoundAudienceSelector=" + this.compoundAudienceSelector + ", exclusions=" + this.exclusions + ", timeCriteria=" + this.timeCriteria + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Experiment(@NotNull String id, @NotNull ExperimentType type, @NotNull ResolutionType resolutionType, long j, long j2, @NotNull JsonMap reportingMetadata, @NotNull AudienceSelector audience, @Nullable ExperimentCompoundAudience experimentCompoundAudience, @NotNull List<MessageCriteria> exclusions, @Nullable TimeCriteria timeCriteria) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(resolutionType, "resolutionType");
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        Intrinsics.checkNotNullParameter(audience, "audience");
        Intrinsics.checkNotNullParameter(exclusions, "exclusions");
        this.id = id;
        this.type = type;
        this.resolutionType = resolutionType;
        this.created = j;
        this.lastUpdated = j2;
        this.reportingMetadata = reportingMetadata;
        this.audience = audience;
        this.compoundAudienceSelector = experimentCompoundAudience;
        this.exclusions = exclusions;
        this.timeCriteria = timeCriteria;
    }

    public /* synthetic */ Experiment(String str, ExperimentType experimentType, ResolutionType resolutionType, long j, long j2, JsonMap jsonMap, AudienceSelector audienceSelector, ExperimentCompoundAudience experimentCompoundAudience, List list, TimeCriteria timeCriteria, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, experimentType, resolutionType, j, j2, jsonMap, audienceSelector, (i & 128) != 0 ? null : experimentCompoundAudience, list, timeCriteria);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final ExperimentType getType() {
        return this.type;
    }

    @NotNull
    public final ResolutionType getResolutionType() {
        return this.resolutionType;
    }

    public final long getCreated() {
        return this.created;
    }

    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    @NotNull
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    public final AudienceSelector getAudience() {
        return this.audience;
    }

    @Nullable
    public final ExperimentCompoundAudience getCompoundAudienceSelector() {
        return this.compoundAudienceSelector;
    }

    @NotNull
    public final List<MessageCriteria> getExclusions() {
        return this.exclusions;
    }

    @Nullable
    public final TimeCriteria getTimeCriteria() {
        return this.timeCriteria;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/experiment/Experiment$Companion;", "", "()V", "KEY_AUDIENCE_SELECTOR", "", "KEY_COMPOUND_AUDIENCE_SELECTOR", "KEY_CREATED", "KEY_EXPERIMENT_DEFINITION", "KEY_ID", "KEY_LAST_UPDATED", "KEY_MESSAGE_EXCLUSION", "KEY_REPORTING_METADATA", "KEY_RESOLUTION_TYPE", "KEY_TIME_CRITERIA", "KEY_TYPE", "fromJson", "Lcom/urbanairship/experiment/Experiment;", "json", "Lcom/urbanairship/json/JsonMap;", "fromJson$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nExperiment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/Experiment$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,254:1\n172#2:255\n79#2,16:256\n173#2,4:272\n172#2:276\n79#2,16:277\n173#2,4:293\n44#2,15:315\n44#2,15:330\n44#2,15:345\n1#3:297\n1#3:312\n1549#4:298\n1620#4,3:299\n1603#4,9:302\n1855#4:311\n1856#4:313\n1612#4:314\n*S KotlinDebug\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/Experiment$Companion\n*L\n212#1:255\n212#1:256,16\n212#1:272,4\n214#1:276\n214#1:277,16\n214#1:293,4\n229#1:315,15\n232#1:330,15\n233#1:345,15\n226#1:312\n225#1:298\n225#1:299,3\n226#1:302,9\n226#1:311\n226#1:313\n226#1:314\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:224:0x04e4 A[Catch: JsonException -> 0x005f, ParseException -> 0x085e, TryCatch #0 {JsonException -> 0x005f, blocks: (B:3:0x0009, B:66:0x0190, B:69:0x019b, B:78:0x01ae, B:139:0x0303, B:142:0x030e, B:150:0x0320, B:152:0x0339, B:154:0x0344, B:155:0x0362, B:157:0x0368, B:158:0x0376, B:159:0x0381, B:161:0x0387, B:163:0x0393, B:164:0x0397, B:167:0x03a3, B:169:0x03b6, B:222:0x04dc, B:224:0x04e4, B:226:0x04f5, B:261:0x05f2, B:263:0x05fe, B:265:0x060f, B:300:0x070c, B:267:0x0617, B:269:0x0621, B:270:0x0626, B:272:0x0632, B:273:0x063e, B:275:0x064a, B:276:0x065a, B:278:0x0666, B:279:0x0678, B:281:0x0684, B:282:0x0692, B:284:0x069e, B:285:0x06aa, B:287:0x06b4, B:288:0x06c0, B:290:0x06ca, B:291:0x06da, B:293:0x06e4, B:294:0x06eb, B:296:0x06f5, B:297:0x06fc, B:299:0x0706, B:302:0x0739, B:303:0x075e, B:304:0x075f, B:305:0x077a, B:228:0x04fd, B:230:0x0507, B:231:0x050c, B:233:0x0518, B:234:0x0524, B:236:0x0530, B:237:0x0540, B:239:0x054c, B:240:0x055e, B:242:0x056a, B:243:0x0578, B:245:0x0584, B:246:0x0590, B:248:0x059a, B:249:0x05a6, B:251:0x05b0, B:252:0x05c0, B:254:0x05ca, B:255:0x05d1, B:257:0x05db, B:258:0x05e2, B:260:0x05ec, B:306:0x077b, B:307:0x07a0, B:308:0x07a1, B:309:0x07bb, B:172:0x03c2, B:173:0x03c7, B:174:0x03c8, B:176:0x03d2, B:179:0x03d9, B:180:0x03de, B:181:0x03df, B:183:0x03eb, B:184:0x03f7, B:186:0x0403, B:188:0x0415, B:190:0x0421, B:191:0x0432, B:193:0x043e, B:194:0x044b, B:196:0x0457, B:197:0x0463, B:199:0x046d, B:200:0x0479, B:202:0x0483, B:203:0x0494, B:205:0x049e, B:207:0x04a4, B:208:0x04a8, B:209:0x04ad, B:210:0x04ae, B:212:0x04b8, B:214:0x04be, B:215:0x04c2, B:216:0x04c7, B:217:0x04c8, B:219:0x04d2, B:221:0x04d8, B:310:0x07bc, B:311:0x07c1, B:312:0x07c2, B:313:0x07e9, B:314:0x07ea, B:315:0x0805, B:81:0x01bb, B:83:0x01cc, B:86:0x01d4, B:87:0x01d9, B:88:0x01da, B:90:0x01e4, B:93:0x01ec, B:94:0x01f1, B:95:0x01f2, B:97:0x01fe, B:98:0x020b, B:100:0x0217, B:101:0x0225, B:103:0x022f, B:104:0x0241, B:106:0x024d, B:107:0x025b, B:109:0x0267, B:110:0x0274, B:112:0x027e, B:113:0x028b, B:115:0x0297, B:116:0x02a3, B:118:0x02ad, B:119:0x02bd, B:121:0x02c7, B:123:0x02cd, B:124:0x02d0, B:125:0x02d5, B:126:0x02d6, B:128:0x02e0, B:130:0x02e6, B:131:0x02e9, B:132:0x02ee, B:133:0x02ef, B:135:0x02f9, B:137:0x02ff, B:316:0x0806, B:317:0x080b, B:318:0x080c, B:319:0x0831, B:7:0x003c, B:9:0x004d, B:12:0x0059, B:13:0x005e, B:15:0x0063, B:17:0x006d, B:20:0x0074, B:21:0x0079, B:22:0x007a, B:24:0x0086, B:25:0x0092, B:27:0x009e, B:28:0x00af, B:30:0x00bc, B:31:0x00ce, B:33:0x00da, B:34:0x00e8, B:36:0x00f4, B:37:0x0101, B:39:0x010b, B:40:0x0118, B:42:0x0124, B:43:0x0130, B:45:0x013a, B:46:0x014a, B:48:0x0154, B:50:0x015a, B:51:0x015d, B:52:0x0162, B:53:0x0163, B:55:0x016d, B:57:0x0173, B:58:0x0176, B:59:0x017b, B:60:0x017c, B:62:0x0186, B:64:0x018c, B:320:0x0832, B:321:0x0837, B:322:0x0838, B:323:0x085d), top: B:328:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:263:0x05fe A[Catch: JsonException -> 0x005f, ParseException -> 0x085e, TryCatch #0 {JsonException -> 0x005f, blocks: (B:3:0x0009, B:66:0x0190, B:69:0x019b, B:78:0x01ae, B:139:0x0303, B:142:0x030e, B:150:0x0320, B:152:0x0339, B:154:0x0344, B:155:0x0362, B:157:0x0368, B:158:0x0376, B:159:0x0381, B:161:0x0387, B:163:0x0393, B:164:0x0397, B:167:0x03a3, B:169:0x03b6, B:222:0x04dc, B:224:0x04e4, B:226:0x04f5, B:261:0x05f2, B:263:0x05fe, B:265:0x060f, B:300:0x070c, B:267:0x0617, B:269:0x0621, B:270:0x0626, B:272:0x0632, B:273:0x063e, B:275:0x064a, B:276:0x065a, B:278:0x0666, B:279:0x0678, B:281:0x0684, B:282:0x0692, B:284:0x069e, B:285:0x06aa, B:287:0x06b4, B:288:0x06c0, B:290:0x06ca, B:291:0x06da, B:293:0x06e4, B:294:0x06eb, B:296:0x06f5, B:297:0x06fc, B:299:0x0706, B:302:0x0739, B:303:0x075e, B:304:0x075f, B:305:0x077a, B:228:0x04fd, B:230:0x0507, B:231:0x050c, B:233:0x0518, B:234:0x0524, B:236:0x0530, B:237:0x0540, B:239:0x054c, B:240:0x055e, B:242:0x056a, B:243:0x0578, B:245:0x0584, B:246:0x0590, B:248:0x059a, B:249:0x05a6, B:251:0x05b0, B:252:0x05c0, B:254:0x05ca, B:255:0x05d1, B:257:0x05db, B:258:0x05e2, B:260:0x05ec, B:306:0x077b, B:307:0x07a0, B:308:0x07a1, B:309:0x07bb, B:172:0x03c2, B:173:0x03c7, B:174:0x03c8, B:176:0x03d2, B:179:0x03d9, B:180:0x03de, B:181:0x03df, B:183:0x03eb, B:184:0x03f7, B:186:0x0403, B:188:0x0415, B:190:0x0421, B:191:0x0432, B:193:0x043e, B:194:0x044b, B:196:0x0457, B:197:0x0463, B:199:0x046d, B:200:0x0479, B:202:0x0483, B:203:0x0494, B:205:0x049e, B:207:0x04a4, B:208:0x04a8, B:209:0x04ad, B:210:0x04ae, B:212:0x04b8, B:214:0x04be, B:215:0x04c2, B:216:0x04c7, B:217:0x04c8, B:219:0x04d2, B:221:0x04d8, B:310:0x07bc, B:311:0x07c1, B:312:0x07c2, B:313:0x07e9, B:314:0x07ea, B:315:0x0805, B:81:0x01bb, B:83:0x01cc, B:86:0x01d4, B:87:0x01d9, B:88:0x01da, B:90:0x01e4, B:93:0x01ec, B:94:0x01f1, B:95:0x01f2, B:97:0x01fe, B:98:0x020b, B:100:0x0217, B:101:0x0225, B:103:0x022f, B:104:0x0241, B:106:0x024d, B:107:0x025b, B:109:0x0267, B:110:0x0274, B:112:0x027e, B:113:0x028b, B:115:0x0297, B:116:0x02a3, B:118:0x02ad, B:119:0x02bd, B:121:0x02c7, B:123:0x02cd, B:124:0x02d0, B:125:0x02d5, B:126:0x02d6, B:128:0x02e0, B:130:0x02e6, B:131:0x02e9, B:132:0x02ee, B:133:0x02ef, B:135:0x02f9, B:137:0x02ff, B:316:0x0806, B:317:0x080b, B:318:0x080c, B:319:0x0831, B:7:0x003c, B:9:0x004d, B:12:0x0059, B:13:0x005e, B:15:0x0063, B:17:0x006d, B:20:0x0074, B:21:0x0079, B:22:0x007a, B:24:0x0086, B:25:0x0092, B:27:0x009e, B:28:0x00af, B:30:0x00bc, B:31:0x00ce, B:33:0x00da, B:34:0x00e8, B:36:0x00f4, B:37:0x0101, B:39:0x010b, B:40:0x0118, B:42:0x0124, B:43:0x0130, B:45:0x013a, B:46:0x014a, B:48:0x0154, B:50:0x015a, B:51:0x015d, B:52:0x0162, B:53:0x0163, B:55:0x016d, B:57:0x0173, B:58:0x0176, B:59:0x017b, B:60:0x017c, B:62:0x0186, B:64:0x018c, B:320:0x0832, B:321:0x0837, B:322:0x0838, B:323:0x085d), top: B:328:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:304:0x075f A[Catch: JsonException -> 0x005f, ParseException -> 0x085e, TryCatch #0 {JsonException -> 0x005f, blocks: (B:3:0x0009, B:66:0x0190, B:69:0x019b, B:78:0x01ae, B:139:0x0303, B:142:0x030e, B:150:0x0320, B:152:0x0339, B:154:0x0344, B:155:0x0362, B:157:0x0368, B:158:0x0376, B:159:0x0381, B:161:0x0387, B:163:0x0393, B:164:0x0397, B:167:0x03a3, B:169:0x03b6, B:222:0x04dc, B:224:0x04e4, B:226:0x04f5, B:261:0x05f2, B:263:0x05fe, B:265:0x060f, B:300:0x070c, B:267:0x0617, B:269:0x0621, B:270:0x0626, B:272:0x0632, B:273:0x063e, B:275:0x064a, B:276:0x065a, B:278:0x0666, B:279:0x0678, B:281:0x0684, B:282:0x0692, B:284:0x069e, B:285:0x06aa, B:287:0x06b4, B:288:0x06c0, B:290:0x06ca, B:291:0x06da, B:293:0x06e4, B:294:0x06eb, B:296:0x06f5, B:297:0x06fc, B:299:0x0706, B:302:0x0739, B:303:0x075e, B:304:0x075f, B:305:0x077a, B:228:0x04fd, B:230:0x0507, B:231:0x050c, B:233:0x0518, B:234:0x0524, B:236:0x0530, B:237:0x0540, B:239:0x054c, B:240:0x055e, B:242:0x056a, B:243:0x0578, B:245:0x0584, B:246:0x0590, B:248:0x059a, B:249:0x05a6, B:251:0x05b0, B:252:0x05c0, B:254:0x05ca, B:255:0x05d1, B:257:0x05db, B:258:0x05e2, B:260:0x05ec, B:306:0x077b, B:307:0x07a0, B:308:0x07a1, B:309:0x07bb, B:172:0x03c2, B:173:0x03c7, B:174:0x03c8, B:176:0x03d2, B:179:0x03d9, B:180:0x03de, B:181:0x03df, B:183:0x03eb, B:184:0x03f7, B:186:0x0403, B:188:0x0415, B:190:0x0421, B:191:0x0432, B:193:0x043e, B:194:0x044b, B:196:0x0457, B:197:0x0463, B:199:0x046d, B:200:0x0479, B:202:0x0483, B:203:0x0494, B:205:0x049e, B:207:0x04a4, B:208:0x04a8, B:209:0x04ad, B:210:0x04ae, B:212:0x04b8, B:214:0x04be, B:215:0x04c2, B:216:0x04c7, B:217:0x04c8, B:219:0x04d2, B:221:0x04d8, B:310:0x07bc, B:311:0x07c1, B:312:0x07c2, B:313:0x07e9, B:314:0x07ea, B:315:0x0805, B:81:0x01bb, B:83:0x01cc, B:86:0x01d4, B:87:0x01d9, B:88:0x01da, B:90:0x01e4, B:93:0x01ec, B:94:0x01f1, B:95:0x01f2, B:97:0x01fe, B:98:0x020b, B:100:0x0217, B:101:0x0225, B:103:0x022f, B:104:0x0241, B:106:0x024d, B:107:0x025b, B:109:0x0267, B:110:0x0274, B:112:0x027e, B:113:0x028b, B:115:0x0297, B:116:0x02a3, B:118:0x02ad, B:119:0x02bd, B:121:0x02c7, B:123:0x02cd, B:124:0x02d0, B:125:0x02d5, B:126:0x02d6, B:128:0x02e0, B:130:0x02e6, B:131:0x02e9, B:132:0x02ee, B:133:0x02ef, B:135:0x02f9, B:137:0x02ff, B:316:0x0806, B:317:0x080b, B:318:0x080c, B:319:0x0831, B:7:0x003c, B:9:0x004d, B:12:0x0059, B:13:0x005e, B:15:0x0063, B:17:0x006d, B:20:0x0074, B:21:0x0079, B:22:0x007a, B:24:0x0086, B:25:0x0092, B:27:0x009e, B:28:0x00af, B:30:0x00bc, B:31:0x00ce, B:33:0x00da, B:34:0x00e8, B:36:0x00f4, B:37:0x0101, B:39:0x010b, B:40:0x0118, B:42:0x0124, B:43:0x0130, B:45:0x013a, B:46:0x014a, B:48:0x0154, B:50:0x015a, B:51:0x015d, B:52:0x0162, B:53:0x0163, B:55:0x016d, B:57:0x0173, B:58:0x0176, B:59:0x017b, B:60:0x017c, B:62:0x0186, B:64:0x018c, B:320:0x0832, B:321:0x0837, B:322:0x0838, B:323:0x085d), top: B:328:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:308:0x07a1 A[Catch: JsonException -> 0x005f, ParseException -> 0x085e, TryCatch #0 {JsonException -> 0x005f, blocks: (B:3:0x0009, B:66:0x0190, B:69:0x019b, B:78:0x01ae, B:139:0x0303, B:142:0x030e, B:150:0x0320, B:152:0x0339, B:154:0x0344, B:155:0x0362, B:157:0x0368, B:158:0x0376, B:159:0x0381, B:161:0x0387, B:163:0x0393, B:164:0x0397, B:167:0x03a3, B:169:0x03b6, B:222:0x04dc, B:224:0x04e4, B:226:0x04f5, B:261:0x05f2, B:263:0x05fe, B:265:0x060f, B:300:0x070c, B:267:0x0617, B:269:0x0621, B:270:0x0626, B:272:0x0632, B:273:0x063e, B:275:0x064a, B:276:0x065a, B:278:0x0666, B:279:0x0678, B:281:0x0684, B:282:0x0692, B:284:0x069e, B:285:0x06aa, B:287:0x06b4, B:288:0x06c0, B:290:0x06ca, B:291:0x06da, B:293:0x06e4, B:294:0x06eb, B:296:0x06f5, B:297:0x06fc, B:299:0x0706, B:302:0x0739, B:303:0x075e, B:304:0x075f, B:305:0x077a, B:228:0x04fd, B:230:0x0507, B:231:0x050c, B:233:0x0518, B:234:0x0524, B:236:0x0530, B:237:0x0540, B:239:0x054c, B:240:0x055e, B:242:0x056a, B:243:0x0578, B:245:0x0584, B:246:0x0590, B:248:0x059a, B:249:0x05a6, B:251:0x05b0, B:252:0x05c0, B:254:0x05ca, B:255:0x05d1, B:257:0x05db, B:258:0x05e2, B:260:0x05ec, B:306:0x077b, B:307:0x07a0, B:308:0x07a1, B:309:0x07bb, B:172:0x03c2, B:173:0x03c7, B:174:0x03c8, B:176:0x03d2, B:179:0x03d9, B:180:0x03de, B:181:0x03df, B:183:0x03eb, B:184:0x03f7, B:186:0x0403, B:188:0x0415, B:190:0x0421, B:191:0x0432, B:193:0x043e, B:194:0x044b, B:196:0x0457, B:197:0x0463, B:199:0x046d, B:200:0x0479, B:202:0x0483, B:203:0x0494, B:205:0x049e, B:207:0x04a4, B:208:0x04a8, B:209:0x04ad, B:210:0x04ae, B:212:0x04b8, B:214:0x04be, B:215:0x04c2, B:216:0x04c7, B:217:0x04c8, B:219:0x04d2, B:221:0x04d8, B:310:0x07bc, B:311:0x07c1, B:312:0x07c2, B:313:0x07e9, B:314:0x07ea, B:315:0x0805, B:81:0x01bb, B:83:0x01cc, B:86:0x01d4, B:87:0x01d9, B:88:0x01da, B:90:0x01e4, B:93:0x01ec, B:94:0x01f1, B:95:0x01f2, B:97:0x01fe, B:98:0x020b, B:100:0x0217, B:101:0x0225, B:103:0x022f, B:104:0x0241, B:106:0x024d, B:107:0x025b, B:109:0x0267, B:110:0x0274, B:112:0x027e, B:113:0x028b, B:115:0x0297, B:116:0x02a3, B:118:0x02ad, B:119:0x02bd, B:121:0x02c7, B:123:0x02cd, B:124:0x02d0, B:125:0x02d5, B:126:0x02d6, B:128:0x02e0, B:130:0x02e6, B:131:0x02e9, B:132:0x02ee, B:133:0x02ef, B:135:0x02f9, B:137:0x02ff, B:316:0x0806, B:317:0x080b, B:318:0x080c, B:319:0x0831, B:7:0x003c, B:9:0x004d, B:12:0x0059, B:13:0x005e, B:15:0x0063, B:17:0x006d, B:20:0x0074, B:21:0x0079, B:22:0x007a, B:24:0x0086, B:25:0x0092, B:27:0x009e, B:28:0x00af, B:30:0x00bc, B:31:0x00ce, B:33:0x00da, B:34:0x00e8, B:36:0x00f4, B:37:0x0101, B:39:0x010b, B:40:0x0118, B:42:0x0124, B:43:0x0130, B:45:0x013a, B:46:0x014a, B:48:0x0154, B:50:0x015a, B:51:0x015d, B:52:0x0162, B:53:0x0163, B:55:0x016d, B:57:0x0173, B:58:0x0176, B:59:0x017b, B:60:0x017c, B:62:0x0186, B:64:0x018c, B:320:0x0832, B:321:0x0837, B:322:0x0838, B:323:0x085d), top: B:328:0x0009 }] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [com.urbanairship.experiment.Experiment, java.lang.Object, java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r3v34 */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.experiment.Experiment fromJson$urbanairship_core_release(@org.jetbrains.annotations.NotNull final com.urbanairship.json.JsonMap r34) {
            /*
                Method dump skipped, instructions count: 2162
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.experiment.Experiment.Companion.fromJson$urbanairship_core_release(com.urbanairship.json.JsonMap):com.urbanairship.experiment.Experiment");
        }
    }

    public final boolean isActive(long date) {
        TimeCriteria timeCriteria = this.timeCriteria;
        if (timeCriteria != null) {
            return timeCriteria.meets(date);
        }
        return true;
    }
}
