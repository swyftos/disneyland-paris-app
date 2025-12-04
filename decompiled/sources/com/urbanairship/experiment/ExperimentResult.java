package com.urbanairship.experiment;

import androidx.annotation.RestrictTo;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/experiment/ExperimentResult;", "Lcom/urbanairship/json/JsonSerializable;", "channelId", "", "contactId", "matchedExperimentId", "isMatching", "", "allEvaluatedExperimentsMetadata", "", "Lcom/urbanairship/json/JsonMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getAllEvaluatedExperimentsMetadata", "()Ljava/util/List;", "getChannelId", "()Ljava/lang/String;", "getContactId", "()Z", "getMatchedExperimentId", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "evaluatedExperimentsDataAsJsonValue", "Lcom/urbanairship/json/JsonValue;", "hashCode", "", "toJsonValue", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nExperiment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentResult\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,254:1\n1549#2:255\n1620#2,3:256\n1#3:259\n*S KotlinDebug\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentResult\n*L\n89#1:255\n89#1:256,3\n*E\n"})
/* loaded from: classes5.dex */
public final class ExperimentResult implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List allEvaluatedExperimentsMetadata;
    private final String channelId;
    private final String contactId;
    private final boolean isMatching;
    private final String matchedExperimentId;

    public ExperimentResult(@NotNull String channelId, @NotNull String contactId, @Nullable String str, boolean z, @NotNull List<? extends JsonMap> allEvaluatedExperimentsMetadata) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        Intrinsics.checkNotNullParameter(allEvaluatedExperimentsMetadata, "allEvaluatedExperimentsMetadata");
        this.channelId = channelId;
        this.contactId = contactId;
        this.matchedExperimentId = str;
        this.isMatching = z;
        this.allEvaluatedExperimentsMetadata = allEvaluatedExperimentsMetadata;
    }

    public /* synthetic */ ExperimentResult(String str, String str2, String str3, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, z, list);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    public final String getMatchedExperimentId() {
        return this.matchedExperimentId;
    }

    /* renamed from: isMatching, reason: from getter */
    public final boolean getIsMatching() {
        return this.isMatching;
    }

    @NotNull
    public final List<JsonMap> getAllEvaluatedExperimentsMetadata() {
        return this.allEvaluatedExperimentsMetadata;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/experiment/ExperimentResult$Companion;", "", "()V", "KEY_CHANNEL_ID", "", "KEY_CONTACT_ID", "KEY_IS_MATCHING", "KEY_MATCHED_EXPERIMENT_ID", "KEY_REPORTING_METADATA", "fromJson", "Lcom/urbanairship/experiment/ExperimentResult;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @SourceDebugExtension({"SMAP\nExperiment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentResult$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,254:1\n1549#2:255\n1620#2,3:256\n44#3,15:259\n44#3,15:274\n79#3,16:289\n44#3,15:305\n*S KotlinDebug\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentResult$Companion\n*L\n71#1:255\n71#1:256,3\n74#1:259,15\n75#1:274,15\n76#1:289,16\n77#1:305,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:126:0x02d7  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x02da A[Catch: JsonException -> 0x0041, TryCatch #0 {JsonException -> 0x0041, blocks: (B:3:0x000b, B:4:0x002d, B:6:0x0033, B:9:0x0044, B:12:0x0050, B:15:0x0078, B:67:0x0192, B:69:0x019a, B:71:0x01ab, B:124:0x02cf, B:167:0x03fe, B:169:0x0406, B:172:0x0419, B:174:0x041f, B:224:0x0537, B:175:0x0423, B:176:0x0428, B:177:0x0429, B:179:0x0433, B:181:0x0439, B:182:0x043d, B:183:0x0442, B:184:0x0443, B:186:0x044f, B:187:0x045a, B:189:0x0466, B:190:0x0474, B:192:0x047e, B:193:0x0490, B:195:0x049c, B:196:0x04aa, B:198:0x04b6, B:199:0x04c3, B:201:0x04cd, B:202:0x04d9, B:204:0x04e3, B:205:0x04f3, B:207:0x04fd, B:209:0x0503, B:210:0x0506, B:211:0x050b, B:212:0x050c, B:214:0x0516, B:216:0x051c, B:217:0x051f, B:218:0x0524, B:219:0x0525, B:221:0x052f, B:223:0x0535, B:226:0x0544, B:227:0x0549, B:228:0x054a, B:229:0x056d, B:230:0x056e, B:231:0x0587, B:127:0x02da, B:129:0x02eb, B:130:0x02f1, B:132:0x02fb, B:133:0x0301, B:135:0x030d, B:136:0x031a, B:138:0x0326, B:139:0x0334, B:141:0x033e, B:142:0x0350, B:144:0x035c, B:145:0x036a, B:147:0x0376, B:148:0x0383, B:150:0x038d, B:151:0x0399, B:153:0x03a5, B:154:0x03b1, B:156:0x03bb, B:157:0x03cb, B:159:0x03d5, B:160:0x03dc, B:162:0x03e6, B:163:0x03ed, B:165:0x03f7, B:232:0x0588, B:233:0x05ab, B:74:0x01b6, B:75:0x01bb, B:76:0x01bc, B:78:0x01c6, B:81:0x01cd, B:82:0x01d2, B:83:0x01d3, B:85:0x01df, B:86:0x01eb, B:88:0x01f7, B:90:0x0208, B:92:0x0214, B:93:0x0225, B:95:0x0231, B:96:0x023e, B:98:0x024a, B:99:0x0256, B:101:0x0260, B:102:0x026c, B:104:0x0276, B:105:0x0287, B:107:0x0291, B:109:0x0297, B:110:0x029b, B:111:0x02a0, B:112:0x02a1, B:114:0x02ab, B:116:0x02b1, B:117:0x02b5, B:118:0x02ba, B:119:0x02bb, B:121:0x02c5, B:123:0x02cb, B:234:0x05ac, B:235:0x05b1, B:236:0x05b2, B:237:0x05d5, B:238:0x05d6, B:239:0x05ef, B:18:0x0081, B:19:0x0086, B:20:0x0087, B:22:0x0091, B:25:0x0098, B:26:0x009d, B:27:0x009e, B:29:0x00aa, B:30:0x00b5, B:32:0x00c1, B:33:0x00cf, B:35:0x00d9, B:36:0x00eb, B:38:0x00f7, B:39:0x0105, B:41:0x0111, B:42:0x011e, B:44:0x0128, B:45:0x0134, B:47:0x013e, B:48:0x014e, B:50:0x0158, B:52:0x015e, B:53:0x0161, B:54:0x0166, B:55:0x0167, B:57:0x0171, B:59:0x0177, B:60:0x017a, B:61:0x017f, B:62:0x0180, B:64:0x018a, B:66:0x0190, B:240:0x05f0, B:241:0x05f5, B:242:0x05f6, B:243:0x0619, B:244:0x061a, B:245:0x0633), top: B:248:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:169:0x0406 A[Catch: JsonException -> 0x0041, TRY_LEAVE, TryCatch #0 {JsonException -> 0x0041, blocks: (B:3:0x000b, B:4:0x002d, B:6:0x0033, B:9:0x0044, B:12:0x0050, B:15:0x0078, B:67:0x0192, B:69:0x019a, B:71:0x01ab, B:124:0x02cf, B:167:0x03fe, B:169:0x0406, B:172:0x0419, B:174:0x041f, B:224:0x0537, B:175:0x0423, B:176:0x0428, B:177:0x0429, B:179:0x0433, B:181:0x0439, B:182:0x043d, B:183:0x0442, B:184:0x0443, B:186:0x044f, B:187:0x045a, B:189:0x0466, B:190:0x0474, B:192:0x047e, B:193:0x0490, B:195:0x049c, B:196:0x04aa, B:198:0x04b6, B:199:0x04c3, B:201:0x04cd, B:202:0x04d9, B:204:0x04e3, B:205:0x04f3, B:207:0x04fd, B:209:0x0503, B:210:0x0506, B:211:0x050b, B:212:0x050c, B:214:0x0516, B:216:0x051c, B:217:0x051f, B:218:0x0524, B:219:0x0525, B:221:0x052f, B:223:0x0535, B:226:0x0544, B:227:0x0549, B:228:0x054a, B:229:0x056d, B:230:0x056e, B:231:0x0587, B:127:0x02da, B:129:0x02eb, B:130:0x02f1, B:132:0x02fb, B:133:0x0301, B:135:0x030d, B:136:0x031a, B:138:0x0326, B:139:0x0334, B:141:0x033e, B:142:0x0350, B:144:0x035c, B:145:0x036a, B:147:0x0376, B:148:0x0383, B:150:0x038d, B:151:0x0399, B:153:0x03a5, B:154:0x03b1, B:156:0x03bb, B:157:0x03cb, B:159:0x03d5, B:160:0x03dc, B:162:0x03e6, B:163:0x03ed, B:165:0x03f7, B:232:0x0588, B:233:0x05ab, B:74:0x01b6, B:75:0x01bb, B:76:0x01bc, B:78:0x01c6, B:81:0x01cd, B:82:0x01d2, B:83:0x01d3, B:85:0x01df, B:86:0x01eb, B:88:0x01f7, B:90:0x0208, B:92:0x0214, B:93:0x0225, B:95:0x0231, B:96:0x023e, B:98:0x024a, B:99:0x0256, B:101:0x0260, B:102:0x026c, B:104:0x0276, B:105:0x0287, B:107:0x0291, B:109:0x0297, B:110:0x029b, B:111:0x02a0, B:112:0x02a1, B:114:0x02ab, B:116:0x02b1, B:117:0x02b5, B:118:0x02ba, B:119:0x02bb, B:121:0x02c5, B:123:0x02cb, B:234:0x05ac, B:235:0x05b1, B:236:0x05b2, B:237:0x05d5, B:238:0x05d6, B:239:0x05ef, B:18:0x0081, B:19:0x0086, B:20:0x0087, B:22:0x0091, B:25:0x0098, B:26:0x009d, B:27:0x009e, B:29:0x00aa, B:30:0x00b5, B:32:0x00c1, B:33:0x00cf, B:35:0x00d9, B:36:0x00eb, B:38:0x00f7, B:39:0x0105, B:41:0x0111, B:42:0x011e, B:44:0x0128, B:45:0x0134, B:47:0x013e, B:48:0x014e, B:50:0x0158, B:52:0x015e, B:53:0x0161, B:54:0x0166, B:55:0x0167, B:57:0x0171, B:59:0x0177, B:60:0x017a, B:61:0x017f, B:62:0x0180, B:64:0x018a, B:66:0x0190, B:240:0x05f0, B:241:0x05f5, B:242:0x05f6, B:243:0x0619, B:244:0x061a, B:245:0x0633), top: B:248:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:230:0x056e A[Catch: JsonException -> 0x0041, TryCatch #0 {JsonException -> 0x0041, blocks: (B:3:0x000b, B:4:0x002d, B:6:0x0033, B:9:0x0044, B:12:0x0050, B:15:0x0078, B:67:0x0192, B:69:0x019a, B:71:0x01ab, B:124:0x02cf, B:167:0x03fe, B:169:0x0406, B:172:0x0419, B:174:0x041f, B:224:0x0537, B:175:0x0423, B:176:0x0428, B:177:0x0429, B:179:0x0433, B:181:0x0439, B:182:0x043d, B:183:0x0442, B:184:0x0443, B:186:0x044f, B:187:0x045a, B:189:0x0466, B:190:0x0474, B:192:0x047e, B:193:0x0490, B:195:0x049c, B:196:0x04aa, B:198:0x04b6, B:199:0x04c3, B:201:0x04cd, B:202:0x04d9, B:204:0x04e3, B:205:0x04f3, B:207:0x04fd, B:209:0x0503, B:210:0x0506, B:211:0x050b, B:212:0x050c, B:214:0x0516, B:216:0x051c, B:217:0x051f, B:218:0x0524, B:219:0x0525, B:221:0x052f, B:223:0x0535, B:226:0x0544, B:227:0x0549, B:228:0x054a, B:229:0x056d, B:230:0x056e, B:231:0x0587, B:127:0x02da, B:129:0x02eb, B:130:0x02f1, B:132:0x02fb, B:133:0x0301, B:135:0x030d, B:136:0x031a, B:138:0x0326, B:139:0x0334, B:141:0x033e, B:142:0x0350, B:144:0x035c, B:145:0x036a, B:147:0x0376, B:148:0x0383, B:150:0x038d, B:151:0x0399, B:153:0x03a5, B:154:0x03b1, B:156:0x03bb, B:157:0x03cb, B:159:0x03d5, B:160:0x03dc, B:162:0x03e6, B:163:0x03ed, B:165:0x03f7, B:232:0x0588, B:233:0x05ab, B:74:0x01b6, B:75:0x01bb, B:76:0x01bc, B:78:0x01c6, B:81:0x01cd, B:82:0x01d2, B:83:0x01d3, B:85:0x01df, B:86:0x01eb, B:88:0x01f7, B:90:0x0208, B:92:0x0214, B:93:0x0225, B:95:0x0231, B:96:0x023e, B:98:0x024a, B:99:0x0256, B:101:0x0260, B:102:0x026c, B:104:0x0276, B:105:0x0287, B:107:0x0291, B:109:0x0297, B:110:0x029b, B:111:0x02a0, B:112:0x02a1, B:114:0x02ab, B:116:0x02b1, B:117:0x02b5, B:118:0x02ba, B:119:0x02bb, B:121:0x02c5, B:123:0x02cb, B:234:0x05ac, B:235:0x05b1, B:236:0x05b2, B:237:0x05d5, B:238:0x05d6, B:239:0x05ef, B:18:0x0081, B:19:0x0086, B:20:0x0087, B:22:0x0091, B:25:0x0098, B:26:0x009d, B:27:0x009e, B:29:0x00aa, B:30:0x00b5, B:32:0x00c1, B:33:0x00cf, B:35:0x00d9, B:36:0x00eb, B:38:0x00f7, B:39:0x0105, B:41:0x0111, B:42:0x011e, B:44:0x0128, B:45:0x0134, B:47:0x013e, B:48:0x014e, B:50:0x0158, B:52:0x015e, B:53:0x0161, B:54:0x0166, B:55:0x0167, B:57:0x0171, B:59:0x0177, B:60:0x017a, B:61:0x017f, B:62:0x0180, B:64:0x018a, B:66:0x0190, B:240:0x05f0, B:241:0x05f5, B:242:0x05f6, B:243:0x0619, B:244:0x061a, B:245:0x0633), top: B:248:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:238:0x05d6 A[Catch: JsonException -> 0x0041, TryCatch #0 {JsonException -> 0x0041, blocks: (B:3:0x000b, B:4:0x002d, B:6:0x0033, B:9:0x0044, B:12:0x0050, B:15:0x0078, B:67:0x0192, B:69:0x019a, B:71:0x01ab, B:124:0x02cf, B:167:0x03fe, B:169:0x0406, B:172:0x0419, B:174:0x041f, B:224:0x0537, B:175:0x0423, B:176:0x0428, B:177:0x0429, B:179:0x0433, B:181:0x0439, B:182:0x043d, B:183:0x0442, B:184:0x0443, B:186:0x044f, B:187:0x045a, B:189:0x0466, B:190:0x0474, B:192:0x047e, B:193:0x0490, B:195:0x049c, B:196:0x04aa, B:198:0x04b6, B:199:0x04c3, B:201:0x04cd, B:202:0x04d9, B:204:0x04e3, B:205:0x04f3, B:207:0x04fd, B:209:0x0503, B:210:0x0506, B:211:0x050b, B:212:0x050c, B:214:0x0516, B:216:0x051c, B:217:0x051f, B:218:0x0524, B:219:0x0525, B:221:0x052f, B:223:0x0535, B:226:0x0544, B:227:0x0549, B:228:0x054a, B:229:0x056d, B:230:0x056e, B:231:0x0587, B:127:0x02da, B:129:0x02eb, B:130:0x02f1, B:132:0x02fb, B:133:0x0301, B:135:0x030d, B:136:0x031a, B:138:0x0326, B:139:0x0334, B:141:0x033e, B:142:0x0350, B:144:0x035c, B:145:0x036a, B:147:0x0376, B:148:0x0383, B:150:0x038d, B:151:0x0399, B:153:0x03a5, B:154:0x03b1, B:156:0x03bb, B:157:0x03cb, B:159:0x03d5, B:160:0x03dc, B:162:0x03e6, B:163:0x03ed, B:165:0x03f7, B:232:0x0588, B:233:0x05ab, B:74:0x01b6, B:75:0x01bb, B:76:0x01bc, B:78:0x01c6, B:81:0x01cd, B:82:0x01d2, B:83:0x01d3, B:85:0x01df, B:86:0x01eb, B:88:0x01f7, B:90:0x0208, B:92:0x0214, B:93:0x0225, B:95:0x0231, B:96:0x023e, B:98:0x024a, B:99:0x0256, B:101:0x0260, B:102:0x026c, B:104:0x0276, B:105:0x0287, B:107:0x0291, B:109:0x0297, B:110:0x029b, B:111:0x02a0, B:112:0x02a1, B:114:0x02ab, B:116:0x02b1, B:117:0x02b5, B:118:0x02ba, B:119:0x02bb, B:121:0x02c5, B:123:0x02cb, B:234:0x05ac, B:235:0x05b1, B:236:0x05b2, B:237:0x05d5, B:238:0x05d6, B:239:0x05ef, B:18:0x0081, B:19:0x0086, B:20:0x0087, B:22:0x0091, B:25:0x0098, B:26:0x009d, B:27:0x009e, B:29:0x00aa, B:30:0x00b5, B:32:0x00c1, B:33:0x00cf, B:35:0x00d9, B:36:0x00eb, B:38:0x00f7, B:39:0x0105, B:41:0x0111, B:42:0x011e, B:44:0x0128, B:45:0x0134, B:47:0x013e, B:48:0x014e, B:50:0x0158, B:52:0x015e, B:53:0x0161, B:54:0x0166, B:55:0x0167, B:57:0x0171, B:59:0x0177, B:60:0x017a, B:61:0x017f, B:62:0x0180, B:64:0x018a, B:66:0x0190, B:240:0x05f0, B:241:0x05f5, B:242:0x05f6, B:243:0x0619, B:244:0x061a, B:245:0x0633), top: B:248:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x019a A[Catch: JsonException -> 0x0041, TryCatch #0 {JsonException -> 0x0041, blocks: (B:3:0x000b, B:4:0x002d, B:6:0x0033, B:9:0x0044, B:12:0x0050, B:15:0x0078, B:67:0x0192, B:69:0x019a, B:71:0x01ab, B:124:0x02cf, B:167:0x03fe, B:169:0x0406, B:172:0x0419, B:174:0x041f, B:224:0x0537, B:175:0x0423, B:176:0x0428, B:177:0x0429, B:179:0x0433, B:181:0x0439, B:182:0x043d, B:183:0x0442, B:184:0x0443, B:186:0x044f, B:187:0x045a, B:189:0x0466, B:190:0x0474, B:192:0x047e, B:193:0x0490, B:195:0x049c, B:196:0x04aa, B:198:0x04b6, B:199:0x04c3, B:201:0x04cd, B:202:0x04d9, B:204:0x04e3, B:205:0x04f3, B:207:0x04fd, B:209:0x0503, B:210:0x0506, B:211:0x050b, B:212:0x050c, B:214:0x0516, B:216:0x051c, B:217:0x051f, B:218:0x0524, B:219:0x0525, B:221:0x052f, B:223:0x0535, B:226:0x0544, B:227:0x0549, B:228:0x054a, B:229:0x056d, B:230:0x056e, B:231:0x0587, B:127:0x02da, B:129:0x02eb, B:130:0x02f1, B:132:0x02fb, B:133:0x0301, B:135:0x030d, B:136:0x031a, B:138:0x0326, B:139:0x0334, B:141:0x033e, B:142:0x0350, B:144:0x035c, B:145:0x036a, B:147:0x0376, B:148:0x0383, B:150:0x038d, B:151:0x0399, B:153:0x03a5, B:154:0x03b1, B:156:0x03bb, B:157:0x03cb, B:159:0x03d5, B:160:0x03dc, B:162:0x03e6, B:163:0x03ed, B:165:0x03f7, B:232:0x0588, B:233:0x05ab, B:74:0x01b6, B:75:0x01bb, B:76:0x01bc, B:78:0x01c6, B:81:0x01cd, B:82:0x01d2, B:83:0x01d3, B:85:0x01df, B:86:0x01eb, B:88:0x01f7, B:90:0x0208, B:92:0x0214, B:93:0x0225, B:95:0x0231, B:96:0x023e, B:98:0x024a, B:99:0x0256, B:101:0x0260, B:102:0x026c, B:104:0x0276, B:105:0x0287, B:107:0x0291, B:109:0x0297, B:110:0x029b, B:111:0x02a0, B:112:0x02a1, B:114:0x02ab, B:116:0x02b1, B:117:0x02b5, B:118:0x02ba, B:119:0x02bb, B:121:0x02c5, B:123:0x02cb, B:234:0x05ac, B:235:0x05b1, B:236:0x05b2, B:237:0x05d5, B:238:0x05d6, B:239:0x05ef, B:18:0x0081, B:19:0x0086, B:20:0x0087, B:22:0x0091, B:25:0x0098, B:26:0x009d, B:27:0x009e, B:29:0x00aa, B:30:0x00b5, B:32:0x00c1, B:33:0x00cf, B:35:0x00d9, B:36:0x00eb, B:38:0x00f7, B:39:0x0105, B:41:0x0111, B:42:0x011e, B:44:0x0128, B:45:0x0134, B:47:0x013e, B:48:0x014e, B:50:0x0158, B:52:0x015e, B:53:0x0161, B:54:0x0166, B:55:0x0167, B:57:0x0171, B:59:0x0177, B:60:0x017a, B:61:0x017f, B:62:0x0180, B:64:0x018a, B:66:0x0190, B:240:0x05f0, B:241:0x05f5, B:242:0x05f6, B:243:0x0619, B:244:0x061a, B:245:0x0633), top: B:248:0x000b }] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.experiment.ExperimentResult fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r24) {
            /*
                Method dump skipped, instructions count: 1595
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.experiment.ExperimentResult.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.experiment.ExperimentResult");
        }
    }

    @NotNull
    public final JsonValue evaluatedExperimentsDataAsJsonValue() {
        List list = this.allEvaluatedExperimentsMetadata;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((JsonMap) it.next()).getJsonValue());
        }
        JsonValue jsonValue = new JsonList(arrayList).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().put("channelId", this.channelId).put("contactId", this.contactId).put("matchedExperimentId", this.matchedExperimentId).put("isMatching", this.isMatching).put("allEvaluatedExperimentsMetadata", evaluatedExperimentsDataAsJsonValue()).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ExperimentResult.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.experiment.ExperimentResult");
        ExperimentResult experimentResult = (ExperimentResult) other;
        if (Intrinsics.areEqual(this.channelId, experimentResult.channelId) && Intrinsics.areEqual(this.contactId, experimentResult.contactId) && Intrinsics.areEqual(this.matchedExperimentId, experimentResult.matchedExperimentId) && this.isMatching == experimentResult.isMatching) {
            return Intrinsics.areEqual(this.allEvaluatedExperimentsMetadata, experimentResult.allEvaluatedExperimentsMetadata);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.channelId, this.contactId, this.matchedExperimentId, Boolean.valueOf(this.isMatching), this.allEvaluatedExperimentsMetadata);
    }
}
