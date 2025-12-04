package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import ch.qos.logback.core.CoreConstants;
import com.google.common.primitives.Longs;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.6")
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b>\b\u0087@\u0018\u0000 ¥\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¥\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0013\u0010\r\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001eH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u001cJ\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001eH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u001fJ\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010#J\u001a\u0010(\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$H\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\r\u0010*\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\bJ\r\u0010,\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\bJ\r\u0010.\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\bJ\r\u00100\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\bJ\u0018\u00103\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b1\u00102J\u009d\u0001\u0010@\u001a\u00028\u0000\"\u0004\b\u0000\u001042u\u0010=\u001aq\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(<\u0012\u0004\u0012\u00028\u000005H\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b>\u0010?J\u0088\u0001\u0010@\u001a\u00028\u0000\"\u0004\b\u0000\u001042`\u0010=\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(<\u0012\u0004\u0012\u00028\u00000AH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b>\u0010BJs\u0010@\u001a\u00028\u0000\"\u0004\b\u0000\u001042K\u0010=\u001aG\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(<\u0012\u0004\u0012\u00028\u00000CH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b>\u0010DJ^\u0010@\u001a\u00028\u0000\"\u0004\b\u0000\u0010426\u0010=\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(<\u0012\u0004\u0012\u00028\u00000EH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b>\u0010FJ\u0015\u0010I\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\bG\u0010HJ\u0015\u0010K\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$¢\u0006\u0004\bJ\u0010'J\u0015\u0010N\u001a\u00020\u00192\u0006\u0010%\u001a\u00020$¢\u0006\u0004\bL\u0010MJ\u000f\u0010P\u001a\u00020\u0002H\u0007¢\u0006\u0004\bO\u0010\u0005J\u000f\u0010R\u001a\u00020\u0002H\u0007¢\u0006\u0004\bQ\u0010\u0005J\u000f\u0010V\u001a\u00020SH\u0016¢\u0006\u0004\bT\u0010UJ?\u0010`\u001a\u00020]*\u00060Wj\u0002`X2\u0006\u0010Y\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u00192\u0006\u0010%\u001a\u00020S2\u0006\u0010\\\u001a\u00020\u0006H\u0002¢\u0006\u0004\b^\u0010_J\u001f\u0010V\u001a\u00020S2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010a\u001a\u00020\u0019¢\u0006\u0004\bT\u0010bJ\r\u0010d\u001a\u00020S¢\u0006\u0004\bc\u0010UJ\u0010\u0010g\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\be\u0010fJ\u001a\u0010k\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010hHÖ\u0003¢\u0006\u0004\bi\u0010jR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010lR\u0014\u0010n\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010\u0005R\u0014\u0010q\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\br\u0010\u0005R\u001a\u0010w\u001a\u00020\u00198@X\u0081\u0004¢\u0006\f\u0012\u0004\bu\u0010v\u001a\u0004\bt\u0010fR\u001a\u0010z\u001a\u00020\u00198@X\u0081\u0004¢\u0006\f\u0012\u0004\by\u0010v\u001a\u0004\bx\u0010fR\u001a\u0010}\u001a\u00020\u00198@X\u0081\u0004¢\u0006\f\u0012\u0004\b|\u0010v\u001a\u0004\b{\u0010fR\u001b\u0010\u0080\u0001\u001a\u00020\u00198@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u007f\u0010v\u001a\u0004\b~\u0010fR\u001e\u0010\u0084\u0001\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0083\u0001\u0010v\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001e\u0010\u0087\u0001\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0086\u0001\u0010v\u001a\u0006\b\u0085\u0001\u0010\u0082\u0001R\u001e\u0010\u008a\u0001\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0089\u0001\u0010v\u001a\u0006\b\u0088\u0001\u0010\u0082\u0001R\u001e\u0010\u008d\u0001\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u008c\u0001\u0010v\u001a\u0006\b\u008b\u0001\u0010\u0082\u0001R\u001e\u0010\u0090\u0001\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u008f\u0001\u0010v\u001a\u0006\b\u008e\u0001\u0010\u0082\u0001R\u001e\u0010\u0093\u0001\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0092\u0001\u0010v\u001a\u0006\b\u0091\u0001\u0010\u0082\u0001R\u001e\u0010\u0096\u0001\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0095\u0001\u0010v\u001a\u0006\b\u0094\u0001\u0010\u0082\u0001R\u0013\u0010\u0098\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u0005R\u0013\u0010\u009a\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u0010\u0005R\u0013\u0010\u009c\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010\u0005R\u0013\u0010\u009e\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010\u0005R\u0013\u0010 \u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010\u0005R\u0013\u0010¢\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010\u0005R\u0013\u0010¤\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b£\u0001\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006¦\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "", "rawValue", "constructor-impl", "(J)J", "", "isInNanos-impl", "(J)Z", "isInNanos", "isInMillis-impl", "isInMillis", "unaryMinus-UwyO8pc", "unaryMinus", ETCPaymentMethod.OTHER, "plus-LRDsOJo", "(JJ)J", "plus", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "addValuesMixedRanges", "minus-LRDsOJo", "minus", "", "scale", "times-UwyO8pc", "(JI)J", "times", "", "(JD)J", "div-UwyO8pc", "div", "div-LRDsOJo", "(JJ)D", "Lkotlin/time/DurationUnit;", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "truncateTo", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "compareTo-LRDsOJo", "(JJ)I", "compareTo", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toDouble", "toLong-impl", "toLong", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toInt", "toLongNanoseconds-impl", "toLongNanoseconds", "toLongMilliseconds-impl", "toLongMilliseconds", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "appendFractional", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString-impl", "toIsoString", "hashCode-impl", "(J)I", "hashCode", "", "equals-impl", "(JLjava/lang/Object;)Z", ExactValueMatcher.EQUALS_VALUE_KEY, "J", "getValue-impl", "value", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "getHoursComponent$annotations", "()V", "hoursComponent", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "getInDays-impl", "(J)D", "getInDays$annotations", "inDays", "getInHours-impl", "getInHours$annotations", "inHours", "getInMinutes-impl", "getInMinutes$annotations", "inMinutes", "getInSeconds-impl", "getInSeconds$annotations", "inSeconds", "getInMilliseconds-impl", "getInMilliseconds$annotations", "inMilliseconds", "getInMicroseconds-impl", "getInMicroseconds$annotations", "inMicroseconds", "getInNanoseconds-impl", "getInNanoseconds$annotations", "inNanoseconds", "getInWholeDays-impl", "inWholeDays", "getInWholeHours-impl", "inWholeHours", "getInWholeMinutes-impl", "inWholeMinutes", "getInWholeSeconds-impl", "inWholeSeconds", "getInWholeMilliseconds-impl", "inWholeMilliseconds", "getInWholeMicroseconds-impl", "inWholeMicroseconds", "getInWholeNanoseconds-impl", "inWholeNanoseconds", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1494:1\n38#1:1495\n38#1:1496\n38#1:1497\n38#1:1498\n38#1:1499\n683#1,2:1500\n700#1,2:1509\n170#2,6:1502\n1#3:1508\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1495\n40#1:1496\n458#1:1497\n478#1:1498\n662#1:1499\n979#1:1500,2\n1070#1:1509,2\n1021#1:1502,6\n*E\n"})
/* loaded from: classes6.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m3467constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m3465boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3471equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3472equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    private static final long m3493getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3494hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m3496isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m3497isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m3499isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m3500isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(Object obj) {
        return m3471equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m3494hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m3520compareToLRDsOJo(duration.getRawValue());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m3492getStorageUnitimpl(long j) {
        return m3497isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3467constructorimpl(long j) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m3497isInNanosimpl(j)) {
                long jM3493getValueimpl = m3493getValueimpl(j);
                if (-4611686018426999999L > jM3493getValueimpl || jM3493getValueimpl >= 4611686018427000000L) {
                    throw new AssertionError(m3493getValueimpl(j) + " ns is out of nanoseconds range");
                }
            } else {
                long jM3493getValueimpl2 = m3493getValueimpl(j);
                if (-4611686018427387903L > jM3493getValueimpl2 || jM3493getValueimpl2 >= Longs.MAX_POWER_OF_TWO) {
                    throw new AssertionError(m3493getValueimpl(j) + " ms is out of milliseconds range");
                }
                long jM3493getValueimpl3 = m3493getValueimpl(j);
                if (-4611686018426L <= jM3493getValueimpl3 && jM3493getValueimpl3 < 4611686018427L) {
                    throw new AssertionError(m3493getValueimpl(j) + " ms is denormalized");
                }
            }
        }
        return j;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b$\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0011J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000eJ\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000eJ\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u000eJ\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0012J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000eJ\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0012J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000eJ\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0011J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000eJ\u001a\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b#\u0010!J\u001a\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b(\u0010&R\u001a\u0010*\u001a\u00020\f8\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\f8\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u001d\u00100\u001a\u00020\f8\u0000X\u0080\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\"\u0010\u000f\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b3\u00104\u001a\u0004\b2\u0010\u000eR\"\u0010\u000f\u001a\u00020\f*\u00020\u00108Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b3\u00105\u001a\u0004\b2\u0010\u0011R\"\u0010\u000f\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b3\u00106\u001a\u0004\b2\u0010\u0012R\"\u0010\u0014\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00104\u001a\u0004\b7\u0010\u000eR\"\u0010\u0014\u001a\u00020\f*\u00020\u00108Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00105\u001a\u0004\b7\u0010\u0011R\"\u0010\u0014\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00106\u001a\u0004\b7\u0010\u0012R\"\u0010\u0016\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00104\u001a\u0004\b9\u0010\u000eR\"\u0010\u0016\u001a\u00020\f*\u00020\u00108Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00105\u001a\u0004\b9\u0010\u0011R\"\u0010\u0016\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00106\u001a\u0004\b9\u0010\u0012R\"\u0010\u0018\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00104\u001a\u0004\b;\u0010\u000eR\"\u0010\u0018\u001a\u00020\f*\u00020\u00108Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00105\u001a\u0004\b;\u0010\u0011R\"\u0010\u0018\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00106\u001a\u0004\b;\u0010\u0012R\"\u0010\u001a\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00104\u001a\u0004\b=\u0010\u000eR\"\u0010\u001a\u001a\u00020\f*\u00020\u00108Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00105\u001a\u0004\b=\u0010\u0011R\"\u0010\u001a\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00106\u001a\u0004\b=\u0010\u0012R\"\u0010\u001c\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00104\u001a\u0004\b?\u0010\u000eR\"\u0010\u001c\u001a\u00020\f*\u00020\u00108Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00105\u001a\u0004\b?\u0010\u0011R\"\u0010\u001c\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00106\u001a\u0004\b?\u0010\u0012R\"\u0010\u001e\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bB\u00104\u001a\u0004\bA\u0010\u000eR\"\u0010\u001e\u001a\u00020\f*\u00020\u00108Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bB\u00105\u001a\u0004\bA\u0010\u0011R\"\u0010\u001e\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bB\u00106\u001a\u0004\bA\u0010\u0012\u0082\u0002\u0004\n\u0002\b!¨\u0006C"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "(DLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)D", "", "Lkotlin/time/Duration;", "nanoseconds-UwyO8pc", "(I)J", "nanoseconds", "", "(J)J", "(D)J", "microseconds-UwyO8pc", "microseconds", "milliseconds-UwyO8pc", "milliseconds", "seconds-UwyO8pc", "seconds", "minutes-UwyO8pc", "minutes", "hours-UwyO8pc", "hours", "days-UwyO8pc", "days", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parse", "parseIsoString-UwyO8pc", "parseIsoString", "parseOrNull-FghU774", "(Ljava/lang/String;)Lkotlin/time/Duration;", "parseOrNull", "parseIsoStringOrNull-FghU774", "parseIsoStringOrNull", "ZERO", "J", "getZERO-UwyO8pc", "()J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "getNanoseconds-UwyO8pc", "getNanoseconds-UwyO8pc$annotations", "(I)V", "(J)V", "(D)V", "getMicroseconds-UwyO8pc", "getMicroseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "getMilliseconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "getSeconds-UwyO8pc$annotations", "getMinutes-UwyO8pc", "getMinutes-UwyO8pc$annotations", "getHours-UwyO8pc", "getHours-UwyO8pc$annotations", "getDays-UwyO8pc", "getDays-UwyO8pc$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3522getDaysUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3523getDaysUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3524getDaysUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3525getHoursUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3526getHoursUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3527getHoursUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3528getMicrosecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3529getMicrosecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3530getMicrosecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3531getMillisecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3532getMillisecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3533getMillisecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3534getMinutesUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3535getMinutesUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3536getMinutesUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3537getNanosecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3538getNanosecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3539getNanosecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3540getSecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3541getSecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3542getSecondsUwyO8pc$annotations(long j) {
        }

        private Companion() {
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m3548getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m3546getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m3547getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        @ExperimentalTime
        public final double convert(double value, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3562nanosecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3563nanosecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3561nanosecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3553microsecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3554microsecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3552microsecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3556millisecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3557millisecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3555millisecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3569secondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3570secondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3568secondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3559minutesUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3560minutesUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3558minutesUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3550hoursUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3551hoursUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3549hoursUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3544daysUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3545daysUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final /* synthetic */ long m3543daysUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        /* renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m3564parseUwyO8pc(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m3565parseIsoStringUwyO8pc(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        @Nullable
        /* renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m3567parseOrNullFghU774(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m3465boximpl(DurationKt.parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Nullable
        /* renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m3566parseIsoStringOrNullFghU774(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m3465boximpl(DurationKt.parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m3519unaryMinusUwyO8pc(long j) {
        return DurationKt.durationOf(-m3493getValueimpl(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m3502plusLRDsOJo(long j, long j2) {
        if (m3498isInfiniteimpl(j)) {
            if (m3495isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m3498isInfiniteimpl(j2)) {
            return j2;
        }
        if ((((int) j) & 1) == (((int) j2) & 1)) {
            long jM3493getValueimpl = m3493getValueimpl(j) + m3493getValueimpl(j2);
            return m3497isInNanosimpl(j) ? DurationKt.durationOfNanosNormalized(jM3493getValueimpl) : DurationKt.durationOfMillisNormalized(jM3493getValueimpl);
        }
        if (m3496isInMillisimpl(j)) {
            return m3463addValuesMixedRangesUwyO8pc(j, m3493getValueimpl(j), m3493getValueimpl(j2));
        }
        return m3463addValuesMixedRangesUwyO8pc(j, m3493getValueimpl(j2), m3493getValueimpl(j));
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m3463addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = DurationKt.nanosToMillis(j3);
        long j4 = j2 + jNanosToMillis;
        if (-4611686018426L > j4 || j4 >= 4611686018427L) {
            return DurationKt.durationOfMillis(RangesKt.coerceIn(j4, -4611686018427387903L, DurationKt.MAX_MILLIS));
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(j4) + (j3 - DurationKt.millisToNanos(jNanosToMillis)));
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m3501minusLRDsOJo(long j, long j2) {
        return m3502plusLRDsOJo(j, m3519unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m3504timesUwyO8pc(long j, int i) {
        if (m3498isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m3519unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return ZERO;
        }
        long jM3493getValueimpl = m3493getValueimpl(j);
        long j2 = i;
        long j3 = jM3493getValueimpl * j2;
        if (!m3497isInNanosimpl(j)) {
            if (j3 / j2 == jM3493getValueimpl) {
                return DurationKt.durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            }
            return MathKt.getSign(jM3493getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= jM3493getValueimpl && jM3493getValueimpl < 2147483648L) {
            return DurationKt.durationOfNanos(j3);
        }
        if (j3 / j2 == jM3493getValueimpl) {
            return DurationKt.durationOfNanosNormalized(j3);
        }
        long jNanosToMillis = DurationKt.nanosToMillis(jM3493getValueimpl);
        long j4 = jNanosToMillis * j2;
        long jNanosToMillis2 = DurationKt.nanosToMillis((jM3493getValueimpl - DurationKt.millisToNanos(jNanosToMillis)) * j2) + j4;
        if (j4 / j2 != jNanosToMillis || (jNanosToMillis2 ^ j4) < 0) {
            return MathKt.getSign(jM3493getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(jNanosToMillis2, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m3503timesUwyO8pc(long j, double d) {
        int iRoundToInt = MathKt.roundToInt(d);
        if (iRoundToInt == d) {
            return m3504timesUwyO8pc(j, iRoundToInt);
        }
        DurationUnit durationUnitM3492getStorageUnitimpl = m3492getStorageUnitimpl(j);
        return DurationKt.toDuration(m3509toDoubleimpl(j, durationUnitM3492getStorageUnitimpl) * d, durationUnitM3492getStorageUnitimpl);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m3470divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m3500isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m3499isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m3497isInNanosimpl(j)) {
            return DurationKt.durationOfNanos(m3493getValueimpl(j) / i);
        }
        if (m3498isInfiniteimpl(j)) {
            return m3504timesUwyO8pc(j, MathKt.getSign(i));
        }
        long j2 = i;
        long jM3493getValueimpl = m3493getValueimpl(j) / j2;
        if (-4611686018426L > jM3493getValueimpl || jM3493getValueimpl >= 4611686018427L) {
            return DurationKt.durationOfMillis(jM3493getValueimpl);
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(jM3493getValueimpl) + (DurationKt.millisToNanos(m3493getValueimpl(j) - (jM3493getValueimpl * j2)) / j2));
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m3469divUwyO8pc(long j, double d) {
        int iRoundToInt = MathKt.roundToInt(d);
        if (iRoundToInt == d && iRoundToInt != 0) {
            return m3470divUwyO8pc(j, iRoundToInt);
        }
        DurationUnit durationUnitM3492getStorageUnitimpl = m3492getStorageUnitimpl(j);
        return DurationKt.toDuration(m3509toDoubleimpl(j, durationUnitM3492getStorageUnitimpl) / d, durationUnitM3492getStorageUnitimpl);
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m3468divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.maxOf(m3492getStorageUnitimpl(j), m3492getStorageUnitimpl(j2));
        return m3509toDoubleimpl(j, durationUnit) / m3509toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m3518truncateToUwyO8pc$kotlin_stdlib(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnitM3492getStorageUnitimpl = m3492getStorageUnitimpl(j);
        if (unit.compareTo(durationUnitM3492getStorageUnitimpl) <= 0 || m3498isInfiniteimpl(j)) {
            return j;
        }
        return DurationKt.toDuration(m3493getValueimpl(j) - (m3493getValueimpl(j) % DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, unit, durationUnitM3492getStorageUnitimpl)), durationUnitM3492getStorageUnitimpl);
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m3498isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m3495isFiniteimpl(long j) {
        return !m3498isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m3473getAbsoluteValueUwyO8pc(long j) {
        return m3499isNegativeimpl(j) ? m3519unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m3520compareToLRDsOJo(long j) {
        return m3466compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m3466compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m3499isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m3508toComponentsimpl(long j, @NotNull Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m3482getInWholeDaysimpl(j)), Integer.valueOf(m3474getHoursComponentimpl(j)), Integer.valueOf(m3489getMinutesComponentimpl(j)), Integer.valueOf(m3491getSecondsComponentimpl(j)), Integer.valueOf(m3490getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m3507toComponentsimpl(long j, @NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m3483getInWholeHoursimpl(j)), Integer.valueOf(m3489getMinutesComponentimpl(j)), Integer.valueOf(m3491getSecondsComponentimpl(j)), Integer.valueOf(m3490getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m3506toComponentsimpl(long j, @NotNull Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m3486getInWholeMinutesimpl(j)), Integer.valueOf(m3491getSecondsComponentimpl(j)), Integer.valueOf(m3490getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m3505toComponentsimpl(long j, @NotNull Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m3488getInWholeSecondsimpl(j)), Integer.valueOf(m3490getNanosecondsComponentimpl(j)));
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m3474getHoursComponentimpl(long j) {
        if (m3498isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m3483getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m3489getMinutesComponentimpl(long j) {
        if (m3498isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m3486getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m3491getSecondsComponentimpl(long j) {
        if (m3498isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m3488getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m3490getNanosecondsComponentimpl(long j) {
        long jM3493getValueimpl;
        if (m3498isInfiniteimpl(j)) {
            return 0;
        }
        if (m3496isInMillisimpl(j)) {
            jM3493getValueimpl = DurationKt.millisToNanos(m3493getValueimpl(j) % 1000);
        } else {
            jM3493getValueimpl = m3493getValueimpl(j) % 1000000000;
        }
        return (int) jM3493getValueimpl;
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m3509toDoubleimpl(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m3493getValueimpl(j), m3492getStorageUnitimpl(j), unit);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m3512toLongimpl(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m3493getValueimpl(j), m3492getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m3510toIntimpl(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m3512toLongimpl(j, unit), -2147483648L, 2147483647L);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m3482getInWholeDaysimpl(long j) {
        return m3512toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m3483getInWholeHoursimpl(long j) {
        return m3512toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m3486getInWholeMinutesimpl(long j) {
        return m3512toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m3488getInWholeSecondsimpl(long j) {
        return m3512toLongimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m3485getInWholeMillisecondsimpl(long j) {
        return (m3496isInMillisimpl(j) && m3495isFiniteimpl(j)) ? m3493getValueimpl(j) : m3512toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m3484getInWholeMicrosecondsimpl(long j) {
        return m3512toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m3487getInWholeNanosecondsimpl(long j) {
        long jM3493getValueimpl = m3493getValueimpl(j);
        if (m3497isInNanosimpl(j)) {
            return jM3493getValueimpl;
        }
        if (jM3493getValueimpl > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jM3493getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(jM3493getValueimpl);
    }

    @NotNull
    public String toString() {
        return m3515toStringimpl(this.rawValue);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3515toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM3499isNegativeimpl = m3499isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (zM3499isNegativeimpl) {
            sb.append('-');
        }
        long jM3473getAbsoluteValueUwyO8pc = m3473getAbsoluteValueUwyO8pc(j);
        long jM3482getInWholeDaysimpl = m3482getInWholeDaysimpl(jM3473getAbsoluteValueUwyO8pc);
        int iM3474getHoursComponentimpl = m3474getHoursComponentimpl(jM3473getAbsoluteValueUwyO8pc);
        int iM3489getMinutesComponentimpl = m3489getMinutesComponentimpl(jM3473getAbsoluteValueUwyO8pc);
        int iM3491getSecondsComponentimpl = m3491getSecondsComponentimpl(jM3473getAbsoluteValueUwyO8pc);
        int iM3490getNanosecondsComponentimpl = m3490getNanosecondsComponentimpl(jM3473getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM3482getInWholeDaysimpl != 0;
        boolean z2 = iM3474getHoursComponentimpl != 0;
        boolean z3 = iM3489getMinutesComponentimpl != 0;
        boolean z4 = (iM3491getSecondsComponentimpl == 0 && iM3490getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM3482getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM3474getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM3489getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM3491getSecondsComponentimpl != 0 || z || z2 || z3) {
                m3464appendFractionalimpl(j, sb, iM3491getSecondsComponentimpl, iM3490getNanosecondsComponentimpl, 9, CmcdData.Factory.STREAMING_FORMAT_SS, false);
            } else if (iM3490getNanosecondsComponentimpl >= 1000000) {
                m3464appendFractionalimpl(j, sb, iM3490getNanosecondsComponentimpl / 1000000, iM3490getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (iM3490getNanosecondsComponentimpl >= 1000) {
                m3464appendFractionalimpl(j, sb, iM3490getNanosecondsComponentimpl / 1000, iM3490getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM3490getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (zM3499isNegativeimpl && i > 1) {
            sb.insert(1, CoreConstants.LEFT_PARENTHESIS_CHAR).append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m3464appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strPadStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) strPadStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m3517toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m3516toStringimpl(j, durationUnit, i);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static final String m3516toStringimpl(long j, @NotNull DurationUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i < 0) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        }
        double dM3509toDoubleimpl = m3509toDoubleimpl(j, unit);
        if (Double.isInfinite(dM3509toDoubleimpl)) {
            return String.valueOf(dM3509toDoubleimpl);
        }
        return DurationJvmKt.formatToExactDecimals(dM3509toDoubleimpl, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt__DurationUnitKt.shortName(unit);
    }

    @NotNull
    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m3511toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m3499isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM3473getAbsoluteValueUwyO8pc = m3473getAbsoluteValueUwyO8pc(j);
        long jM3483getInWholeHoursimpl = m3483getInWholeHoursimpl(jM3473getAbsoluteValueUwyO8pc);
        int iM3489getMinutesComponentimpl = m3489getMinutesComponentimpl(jM3473getAbsoluteValueUwyO8pc);
        int iM3491getSecondsComponentimpl = m3491getSecondsComponentimpl(jM3473getAbsoluteValueUwyO8pc);
        int iM3490getNanosecondsComponentimpl = m3490getNanosecondsComponentimpl(jM3473getAbsoluteValueUwyO8pc);
        if (m3498isInfiniteimpl(j)) {
            jM3483getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = jM3483getInWholeHoursimpl != 0;
        boolean z3 = (iM3491getSecondsComponentimpl == 0 && iM3490getNanosecondsComponentimpl == 0) ? false : true;
        if (iM3489getMinutesComponentimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jM3483getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(iM3489getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m3464appendFractionalimpl(j, sb, iM3491getSecondsComponentimpl, iM3490getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
