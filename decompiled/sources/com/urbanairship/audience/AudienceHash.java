package com.urbanairship.audience;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 12\u00020\u0001:\u00011B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JN\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J+\u0010(\u001a\u0004\u0018\u00010)2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030+H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b,J\t\u0010-\u001a\u00020\u000bHÖ\u0001J\b\u0010.\u001a\u00020/H\u0016J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Lcom/urbanairship/audience/AudienceHash;", "Lcom/urbanairship/json/JsonSerializable;", "prefix", "", "property", "Lcom/urbanairship/audience/HashIdentifiers;", "algorithm", "Lcom/urbanairship/audience/HashAlgorithm;", "seed", "", "numberOfHashBuckets", "", "overrides", "Lcom/urbanairship/json/JsonMap;", "(Ljava/lang/String;Lcom/urbanairship/audience/HashIdentifiers;Lcom/urbanairship/audience/HashAlgorithm;Ljava/lang/Long;ILcom/urbanairship/json/JsonMap;)V", "getAlgorithm", "()Lcom/urbanairship/audience/HashAlgorithm;", "getNumberOfHashBuckets", "()I", "getOverrides", "()Lcom/urbanairship/json/JsonMap;", "getPrefix", "()Ljava/lang/String;", "getProperty", "()Lcom/urbanairship/audience/HashIdentifiers;", "getSeed", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/urbanairship/audience/HashIdentifiers;Lcom/urbanairship/audience/HashAlgorithm;Ljava/lang/Long;ILcom/urbanairship/json/JsonMap;)Lcom/urbanairship/audience/AudienceHash;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "generate", "Lkotlin/ULong;", CustomEvent.PROPERTIES, "", "generate-JlBESG8$urbanairship_core_release", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAudienceHash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/AudienceHash\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,119:1\n79#2,16:120\n*S KotlinDebug\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/AudienceHash\n*L\n95#1:120,16\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class AudienceHash implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final HashAlgorithm algorithm;
    private final int numberOfHashBuckets;
    private final JsonMap overrides;
    private final String prefix;
    private final HashIdentifiers property;
    private final Long seed;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HashAlgorithm.values().length];
            try {
                iArr[HashAlgorithm.FARM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ AudienceHash copy$default(AudienceHash audienceHash, String str, HashIdentifiers hashIdentifiers, HashAlgorithm hashAlgorithm, Long l, int i, JsonMap jsonMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = audienceHash.prefix;
        }
        if ((i2 & 2) != 0) {
            hashIdentifiers = audienceHash.property;
        }
        HashIdentifiers hashIdentifiers2 = hashIdentifiers;
        if ((i2 & 4) != 0) {
            hashAlgorithm = audienceHash.algorithm;
        }
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        if ((i2 & 8) != 0) {
            l = audienceHash.seed;
        }
        Long l2 = l;
        if ((i2 & 16) != 0) {
            i = audienceHash.numberOfHashBuckets;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            jsonMap = audienceHash.overrides;
        }
        return audienceHash.copy(str, hashIdentifiers2, hashAlgorithm2, l2, i3, jsonMap);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final HashIdentifiers getProperty() {
        return this.property;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final HashAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getSeed() {
        return this.seed;
    }

    /* renamed from: component5, reason: from getter */
    public final int getNumberOfHashBuckets() {
        return this.numberOfHashBuckets;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final JsonMap getOverrides() {
        return this.overrides;
    }

    @NotNull
    public final AudienceHash copy(@NotNull String prefix, @NotNull HashIdentifiers property, @NotNull HashAlgorithm algorithm, @Nullable Long seed, int numberOfHashBuckets, @Nullable JsonMap overrides) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        return new AudienceHash(prefix, property, algorithm, seed, numberOfHashBuckets, overrides);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudienceHash)) {
            return false;
        }
        AudienceHash audienceHash = (AudienceHash) other;
        return Intrinsics.areEqual(this.prefix, audienceHash.prefix) && this.property == audienceHash.property && this.algorithm == audienceHash.algorithm && Intrinsics.areEqual(this.seed, audienceHash.seed) && this.numberOfHashBuckets == audienceHash.numberOfHashBuckets && Intrinsics.areEqual(this.overrides, audienceHash.overrides);
    }

    public int hashCode() {
        int iHashCode = ((((this.prefix.hashCode() * 31) + this.property.hashCode()) * 31) + this.algorithm.hashCode()) * 31;
        Long l = this.seed;
        int iHashCode2 = (((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Integer.hashCode(this.numberOfHashBuckets)) * 31;
        JsonMap jsonMap = this.overrides;
        return iHashCode2 + (jsonMap != null ? jsonMap.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AudienceHash(prefix=" + this.prefix + ", property=" + this.property + ", algorithm=" + this.algorithm + ", seed=" + this.seed + ", numberOfHashBuckets=" + this.numberOfHashBuckets + ", overrides=" + this.overrides + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AudienceHash(@NotNull String prefix, @NotNull HashIdentifiers property, @NotNull HashAlgorithm algorithm, @Nullable Long l, int i, @Nullable JsonMap jsonMap) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        this.prefix = prefix;
        this.property = property;
        this.algorithm = algorithm;
        this.seed = l;
        this.numberOfHashBuckets = i;
        this.overrides = jsonMap;
    }

    @NotNull
    public final String getPrefix() {
        return this.prefix;
    }

    @NotNull
    public final HashIdentifiers getProperty() {
        return this.property;
    }

    @NotNull
    public final HashAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    @Nullable
    public final Long getSeed() {
        return this.seed;
    }

    public final int getNumberOfHashBuckets() {
        return this.numberOfHashBuckets;
    }

    @Nullable
    public final JsonMap getOverrides() {
        return this.overrides;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/audience/AudienceHash$Companion;", "", "()V", "KEY_ALGORITHM", "", "KEY_HASH_BUCKETS", "KEY_IDENTIFIERS", "KEY_OVERRIDES", "KEY_PREFIX", "KEY_SEED", "fromJson", "Lcom/urbanairship/audience/AudienceHash;", "json", "Lcom/urbanairship/json/JsonMap;", "fromJson$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAudienceHash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/AudienceHash$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,119:1\n172#2:120\n79#2,16:121\n173#2,4:137\n172#2:141\n79#2,16:142\n173#2,4:158\n44#2,15:162\n79#2,16:177\n44#2,15:193\n79#2,16:208\n*S KotlinDebug\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/AudienceHash$Companion\n*L\n63#1:120\n63#1:121,16\n63#1:137,4\n68#1:141\n68#1:142,16\n68#1:158,4\n75#1:162,15\n78#1:177,16\n79#1:193,15\n80#1:208,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:200:0x0441  */
        /* JADX WARN: Removed duplicated region for block: B:201:0x0445 A[Catch: JsonException -> 0x090c, TryCatch #0 {JsonException -> 0x090c, blocks: (B:3:0x0009, B:65:0x0171, B:68:0x017c, B:72:0x018b, B:133:0x02df, B:136:0x02ea, B:140:0x02f9, B:143:0x0305, B:145:0x0316, B:198:0x0439, B:241:0x056c, B:243:0x0574, B:246:0x0587, B:248:0x058d, B:298:0x06a5, B:341:0x07dc, B:301:0x06b5, B:303:0x06c6, B:304:0x06ce, B:306:0x06d8, B:307:0x06e0, B:309:0x06ec, B:310:0x06f9, B:312:0x0705, B:313:0x0713, B:315:0x071d, B:316:0x072f, B:318:0x073b, B:319:0x0749, B:321:0x0755, B:322:0x0762, B:324:0x076c, B:325:0x0778, B:327:0x0784, B:328:0x0790, B:330:0x079a, B:331:0x07aa, B:333:0x07b4, B:334:0x07bb, B:336:0x07c5, B:337:0x07ca, B:339:0x07d4, B:343:0x07e2, B:344:0x0806, B:249:0x0591, B:250:0x0596, B:251:0x0597, B:253:0x05a1, B:255:0x05a7, B:256:0x05ab, B:257:0x05b0, B:258:0x05b1, B:260:0x05bd, B:261:0x05ca, B:263:0x05d6, B:264:0x05e4, B:266:0x05ee, B:267:0x0600, B:269:0x060c, B:270:0x061a, B:272:0x0626, B:273:0x0633, B:275:0x063d, B:276:0x0647, B:278:0x0651, B:279:0x0661, B:281:0x066b, B:283:0x0671, B:284:0x0674, B:285:0x0679, B:286:0x067a, B:288:0x0684, B:290:0x068a, B:291:0x068d, B:292:0x0692, B:293:0x0693, B:295:0x069d, B:297:0x06a3, B:345:0x0807, B:346:0x080c, B:347:0x080d, B:348:0x0831, B:349:0x0832, B:350:0x084b, B:201:0x0445, B:203:0x0456, B:204:0x045e, B:206:0x0468, B:207:0x0470, B:209:0x047c, B:210:0x0489, B:212:0x0495, B:213:0x04a1, B:215:0x04ab, B:216:0x04bd, B:218:0x04c9, B:219:0x04d7, B:221:0x04e3, B:222:0x04f0, B:224:0x04fa, B:225:0x0506, B:227:0x0512, B:228:0x051e, B:230:0x0528, B:231:0x0538, B:233:0x0542, B:234:0x0549, B:236:0x0553, B:237:0x055a, B:239:0x0564, B:351:0x084c, B:352:0x0870, B:148:0x0321, B:149:0x0326, B:150:0x0327, B:152:0x0331, B:155:0x0338, B:156:0x033d, B:157:0x033e, B:159:0x034a, B:160:0x0356, B:162:0x0362, B:164:0x0373, B:166:0x037e, B:167:0x038f, B:169:0x039b, B:170:0x03a8, B:172:0x03b4, B:173:0x03c0, B:175:0x03ca, B:176:0x03d6, B:178:0x03e0, B:179:0x03f1, B:181:0x03fb, B:183:0x0401, B:184:0x0405, B:185:0x040a, B:186:0x040b, B:188:0x0415, B:190:0x041b, B:191:0x041f, B:192:0x0424, B:193:0x0425, B:195:0x042f, B:197:0x0435, B:353:0x0871, B:354:0x0876, B:355:0x0877, B:356:0x089b, B:357:0x089c, B:358:0x08b5, B:75:0x0198, B:77:0x01a9, B:80:0x01b1, B:81:0x01b6, B:82:0x01b7, B:84:0x01c1, B:87:0x01c9, B:88:0x01ce, B:89:0x01cf, B:91:0x01db, B:92:0x01e7, B:94:0x01f3, B:95:0x0201, B:97:0x020b, B:98:0x021d, B:100:0x0229, B:101:0x0237, B:103:0x0243, B:104:0x0250, B:106:0x025a, B:107:0x0267, B:109:0x0273, B:110:0x027f, B:112:0x0289, B:113:0x0299, B:115:0x02a3, B:117:0x02a9, B:118:0x02ac, B:119:0x02b1, B:120:0x02b2, B:122:0x02bc, B:124:0x02c2, B:125:0x02c5, B:126:0x02ca, B:127:0x02cb, B:129:0x02d5, B:131:0x02db, B:359:0x08b6, B:360:0x08bb, B:361:0x08bc, B:362:0x08e0, B:7:0x002d, B:9:0x003e, B:12:0x0046, B:13:0x004b, B:14:0x004c, B:16:0x0056, B:19:0x005e, B:20:0x0063, B:21:0x0064, B:23:0x0070, B:24:0x007c, B:26:0x0088, B:27:0x0096, B:29:0x00a0, B:30:0x00b2, B:32:0x00be, B:33:0x00cc, B:35:0x00d8, B:36:0x00e5, B:38:0x00ef, B:39:0x00fb, B:41:0x0107, B:42:0x0112, B:44:0x011c, B:45:0x012b, B:47:0x0135, B:49:0x013b, B:50:0x013e, B:51:0x0143, B:52:0x0144, B:54:0x014e, B:56:0x0154, B:57:0x0157, B:58:0x015c, B:59:0x015d, B:61:0x0167, B:63:0x016d, B:363:0x08e1, B:364:0x08e6, B:365:0x08e7, B:366:0x090b), top: B:369:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:243:0x0574 A[Catch: JsonException -> 0x090c, TRY_LEAVE, TryCatch #0 {JsonException -> 0x090c, blocks: (B:3:0x0009, B:65:0x0171, B:68:0x017c, B:72:0x018b, B:133:0x02df, B:136:0x02ea, B:140:0x02f9, B:143:0x0305, B:145:0x0316, B:198:0x0439, B:241:0x056c, B:243:0x0574, B:246:0x0587, B:248:0x058d, B:298:0x06a5, B:341:0x07dc, B:301:0x06b5, B:303:0x06c6, B:304:0x06ce, B:306:0x06d8, B:307:0x06e0, B:309:0x06ec, B:310:0x06f9, B:312:0x0705, B:313:0x0713, B:315:0x071d, B:316:0x072f, B:318:0x073b, B:319:0x0749, B:321:0x0755, B:322:0x0762, B:324:0x076c, B:325:0x0778, B:327:0x0784, B:328:0x0790, B:330:0x079a, B:331:0x07aa, B:333:0x07b4, B:334:0x07bb, B:336:0x07c5, B:337:0x07ca, B:339:0x07d4, B:343:0x07e2, B:344:0x0806, B:249:0x0591, B:250:0x0596, B:251:0x0597, B:253:0x05a1, B:255:0x05a7, B:256:0x05ab, B:257:0x05b0, B:258:0x05b1, B:260:0x05bd, B:261:0x05ca, B:263:0x05d6, B:264:0x05e4, B:266:0x05ee, B:267:0x0600, B:269:0x060c, B:270:0x061a, B:272:0x0626, B:273:0x0633, B:275:0x063d, B:276:0x0647, B:278:0x0651, B:279:0x0661, B:281:0x066b, B:283:0x0671, B:284:0x0674, B:285:0x0679, B:286:0x067a, B:288:0x0684, B:290:0x068a, B:291:0x068d, B:292:0x0692, B:293:0x0693, B:295:0x069d, B:297:0x06a3, B:345:0x0807, B:346:0x080c, B:347:0x080d, B:348:0x0831, B:349:0x0832, B:350:0x084b, B:201:0x0445, B:203:0x0456, B:204:0x045e, B:206:0x0468, B:207:0x0470, B:209:0x047c, B:210:0x0489, B:212:0x0495, B:213:0x04a1, B:215:0x04ab, B:216:0x04bd, B:218:0x04c9, B:219:0x04d7, B:221:0x04e3, B:222:0x04f0, B:224:0x04fa, B:225:0x0506, B:227:0x0512, B:228:0x051e, B:230:0x0528, B:231:0x0538, B:233:0x0542, B:234:0x0549, B:236:0x0553, B:237:0x055a, B:239:0x0564, B:351:0x084c, B:352:0x0870, B:148:0x0321, B:149:0x0326, B:150:0x0327, B:152:0x0331, B:155:0x0338, B:156:0x033d, B:157:0x033e, B:159:0x034a, B:160:0x0356, B:162:0x0362, B:164:0x0373, B:166:0x037e, B:167:0x038f, B:169:0x039b, B:170:0x03a8, B:172:0x03b4, B:173:0x03c0, B:175:0x03ca, B:176:0x03d6, B:178:0x03e0, B:179:0x03f1, B:181:0x03fb, B:183:0x0401, B:184:0x0405, B:185:0x040a, B:186:0x040b, B:188:0x0415, B:190:0x041b, B:191:0x041f, B:192:0x0424, B:193:0x0425, B:195:0x042f, B:197:0x0435, B:353:0x0871, B:354:0x0876, B:355:0x0877, B:356:0x089b, B:357:0x089c, B:358:0x08b5, B:75:0x0198, B:77:0x01a9, B:80:0x01b1, B:81:0x01b6, B:82:0x01b7, B:84:0x01c1, B:87:0x01c9, B:88:0x01ce, B:89:0x01cf, B:91:0x01db, B:92:0x01e7, B:94:0x01f3, B:95:0x0201, B:97:0x020b, B:98:0x021d, B:100:0x0229, B:101:0x0237, B:103:0x0243, B:104:0x0250, B:106:0x025a, B:107:0x0267, B:109:0x0273, B:110:0x027f, B:112:0x0289, B:113:0x0299, B:115:0x02a3, B:117:0x02a9, B:118:0x02ac, B:119:0x02b1, B:120:0x02b2, B:122:0x02bc, B:124:0x02c2, B:125:0x02c5, B:126:0x02ca, B:127:0x02cb, B:129:0x02d5, B:131:0x02db, B:359:0x08b6, B:360:0x08bb, B:361:0x08bc, B:362:0x08e0, B:7:0x002d, B:9:0x003e, B:12:0x0046, B:13:0x004b, B:14:0x004c, B:16:0x0056, B:19:0x005e, B:20:0x0063, B:21:0x0064, B:23:0x0070, B:24:0x007c, B:26:0x0088, B:27:0x0096, B:29:0x00a0, B:30:0x00b2, B:32:0x00be, B:33:0x00cc, B:35:0x00d8, B:36:0x00e5, B:38:0x00ef, B:39:0x00fb, B:41:0x0107, B:42:0x0112, B:44:0x011c, B:45:0x012b, B:47:0x0135, B:49:0x013b, B:50:0x013e, B:51:0x0143, B:52:0x0144, B:54:0x014e, B:56:0x0154, B:57:0x0157, B:58:0x015c, B:59:0x015d, B:61:0x0167, B:63:0x016d, B:363:0x08e1, B:364:0x08e6, B:365:0x08e7, B:366:0x090b), top: B:369:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:349:0x0832 A[Catch: JsonException -> 0x090c, TryCatch #0 {JsonException -> 0x090c, blocks: (B:3:0x0009, B:65:0x0171, B:68:0x017c, B:72:0x018b, B:133:0x02df, B:136:0x02ea, B:140:0x02f9, B:143:0x0305, B:145:0x0316, B:198:0x0439, B:241:0x056c, B:243:0x0574, B:246:0x0587, B:248:0x058d, B:298:0x06a5, B:341:0x07dc, B:301:0x06b5, B:303:0x06c6, B:304:0x06ce, B:306:0x06d8, B:307:0x06e0, B:309:0x06ec, B:310:0x06f9, B:312:0x0705, B:313:0x0713, B:315:0x071d, B:316:0x072f, B:318:0x073b, B:319:0x0749, B:321:0x0755, B:322:0x0762, B:324:0x076c, B:325:0x0778, B:327:0x0784, B:328:0x0790, B:330:0x079a, B:331:0x07aa, B:333:0x07b4, B:334:0x07bb, B:336:0x07c5, B:337:0x07ca, B:339:0x07d4, B:343:0x07e2, B:344:0x0806, B:249:0x0591, B:250:0x0596, B:251:0x0597, B:253:0x05a1, B:255:0x05a7, B:256:0x05ab, B:257:0x05b0, B:258:0x05b1, B:260:0x05bd, B:261:0x05ca, B:263:0x05d6, B:264:0x05e4, B:266:0x05ee, B:267:0x0600, B:269:0x060c, B:270:0x061a, B:272:0x0626, B:273:0x0633, B:275:0x063d, B:276:0x0647, B:278:0x0651, B:279:0x0661, B:281:0x066b, B:283:0x0671, B:284:0x0674, B:285:0x0679, B:286:0x067a, B:288:0x0684, B:290:0x068a, B:291:0x068d, B:292:0x0692, B:293:0x0693, B:295:0x069d, B:297:0x06a3, B:345:0x0807, B:346:0x080c, B:347:0x080d, B:348:0x0831, B:349:0x0832, B:350:0x084b, B:201:0x0445, B:203:0x0456, B:204:0x045e, B:206:0x0468, B:207:0x0470, B:209:0x047c, B:210:0x0489, B:212:0x0495, B:213:0x04a1, B:215:0x04ab, B:216:0x04bd, B:218:0x04c9, B:219:0x04d7, B:221:0x04e3, B:222:0x04f0, B:224:0x04fa, B:225:0x0506, B:227:0x0512, B:228:0x051e, B:230:0x0528, B:231:0x0538, B:233:0x0542, B:234:0x0549, B:236:0x0553, B:237:0x055a, B:239:0x0564, B:351:0x084c, B:352:0x0870, B:148:0x0321, B:149:0x0326, B:150:0x0327, B:152:0x0331, B:155:0x0338, B:156:0x033d, B:157:0x033e, B:159:0x034a, B:160:0x0356, B:162:0x0362, B:164:0x0373, B:166:0x037e, B:167:0x038f, B:169:0x039b, B:170:0x03a8, B:172:0x03b4, B:173:0x03c0, B:175:0x03ca, B:176:0x03d6, B:178:0x03e0, B:179:0x03f1, B:181:0x03fb, B:183:0x0401, B:184:0x0405, B:185:0x040a, B:186:0x040b, B:188:0x0415, B:190:0x041b, B:191:0x041f, B:192:0x0424, B:193:0x0425, B:195:0x042f, B:197:0x0435, B:353:0x0871, B:354:0x0876, B:355:0x0877, B:356:0x089b, B:357:0x089c, B:358:0x08b5, B:75:0x0198, B:77:0x01a9, B:80:0x01b1, B:81:0x01b6, B:82:0x01b7, B:84:0x01c1, B:87:0x01c9, B:88:0x01ce, B:89:0x01cf, B:91:0x01db, B:92:0x01e7, B:94:0x01f3, B:95:0x0201, B:97:0x020b, B:98:0x021d, B:100:0x0229, B:101:0x0237, B:103:0x0243, B:104:0x0250, B:106:0x025a, B:107:0x0267, B:109:0x0273, B:110:0x027f, B:112:0x0289, B:113:0x0299, B:115:0x02a3, B:117:0x02a9, B:118:0x02ac, B:119:0x02b1, B:120:0x02b2, B:122:0x02bc, B:124:0x02c2, B:125:0x02c5, B:126:0x02ca, B:127:0x02cb, B:129:0x02d5, B:131:0x02db, B:359:0x08b6, B:360:0x08bb, B:361:0x08bc, B:362:0x08e0, B:7:0x002d, B:9:0x003e, B:12:0x0046, B:13:0x004b, B:14:0x004c, B:16:0x0056, B:19:0x005e, B:20:0x0063, B:21:0x0064, B:23:0x0070, B:24:0x007c, B:26:0x0088, B:27:0x0096, B:29:0x00a0, B:30:0x00b2, B:32:0x00be, B:33:0x00cc, B:35:0x00d8, B:36:0x00e5, B:38:0x00ef, B:39:0x00fb, B:41:0x0107, B:42:0x0112, B:44:0x011c, B:45:0x012b, B:47:0x0135, B:49:0x013b, B:50:0x013e, B:51:0x0143, B:52:0x0144, B:54:0x014e, B:56:0x0154, B:57:0x0157, B:58:0x015c, B:59:0x015d, B:61:0x0167, B:63:0x016d, B:363:0x08e1, B:364:0x08e6, B:365:0x08e7, B:366:0x090b), top: B:369:0x0009 }] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.audience.AudienceHash fromJson$urbanairship_core_release(@org.jetbrains.annotations.NotNull final com.urbanairship.json.JsonMap r28) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 2327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.AudienceHash.Companion.fromJson$urbanairship_core_release(com.urbanairship.json.JsonMap):com.urbanairship.audience.AudienceHash");
        }
    }

    @Nullable
    /* renamed from: generate-JlBESG8$urbanairship_core_release, reason: not valid java name */
    public final ULong m2762generateJlBESG8$urbanairship_core_release(@NotNull Map<String, String> properties) throws JsonException {
        String strOptString;
        Intrinsics.checkNotNullParameter(properties, "properties");
        String str = null;
        if (!properties.containsKey(this.property.getJsonValue())) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.audience.AudienceHash$generate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "can't find device property " + this.this$0.getProperty().getJsonValue();
                }
            }, 1, null);
        }
        String str2 = properties.get(this.property.getJsonValue());
        if (str2 == null) {
            return null;
        }
        JsonMap jsonMap = this.overrides;
        if (jsonMap != null) {
            JsonValue jsonValue = jsonMap.get(str2);
            if (jsonValue != null) {
                Intrinsics.checkNotNull(jsonValue);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + str2 + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
                str = strOptString;
            }
            if (str != null) {
                str2 = str;
            }
        }
        if (WhenMappings.$EnumSwitchMapping$0[this.algorithm.ordinal()] == 1) {
            return ULong.m3027boximpl(Long.remainderUnsigned(ULong.m3028constructorimpl(((Number) AudienceHash$generate$hashFunction$1.INSTANCE.invoke((AudienceHash$generate$hashFunction$1) (this.prefix + str2))).longValue()), ULong.m3028constructorimpl(UInt.m3003constructorimpl(this.numberOfHashBuckets) & BodyPartID.bodyIdMax)));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("hash_prefix", this.prefix).put("hash_identifier", this.property.getJsonValue()).put("hash_algorithm", this.algorithm.getJsonValue());
        Long l = this.seed;
        JsonValue jsonValue = builderPut.put("hash_seed", l != null ? l.longValue() : 0L).put("num_hash_buckets", this.numberOfHashBuckets).put("hash_identifier_overrides", this.overrides).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
