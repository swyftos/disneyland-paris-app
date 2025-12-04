package kotlin.time;

import ch.qos.logback.core.CoreConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "zero", "", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes6.dex */
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    /* renamed from: zero$delegate, reason: from kotlin metadata */
    private final Lazy zero;

    protected abstract long read();

    public AbstractLongTimeSource(@NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero = LazyKt.lazy(new Function0() { // from class: kotlin.time.AbstractLongTimeSource$zero$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(this.this$0.read());
            }
        });
    }

    @NotNull
    protected final DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((Number) this.zero.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long adjustedRead() {
        return read() - getZero();
    }

    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        private LongTimeMark(long j, AbstractLongTimeSource timeSource, long j2) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = j;
            this.timeSource = timeSource;
            this.offset = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo3459minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m3462minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public long mo3458elapsedNowUwyO8pc() {
            return Duration.m3501minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo3461plusLRDsOJo(long j) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m3498isInfiniteimpl(j)) {
                return new LongTimeMark(LongSaturatedMathKt.m3572saturatingAddNuflL3o(this.startedAt, unit, j), this.timeSource, Duration.INSTANCE.m3548getZEROUwyO8pc(), null);
            }
            long jM3518truncateToUwyO8pc$kotlin_stdlib = Duration.m3518truncateToUwyO8pc$kotlin_stdlib(j, unit);
            long jM3502plusLRDsOJo = Duration.m3502plusLRDsOJo(Duration.m3501minusLRDsOJo(j, jM3518truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long jM3572saturatingAddNuflL3o = LongSaturatedMathKt.m3572saturatingAddNuflL3o(this.startedAt, unit, jM3518truncateToUwyO8pc$kotlin_stdlib);
            long jM3518truncateToUwyO8pc$kotlin_stdlib2 = Duration.m3518truncateToUwyO8pc$kotlin_stdlib(jM3502plusLRDsOJo, unit);
            long jM3572saturatingAddNuflL3o2 = LongSaturatedMathKt.m3572saturatingAddNuflL3o(jM3572saturatingAddNuflL3o, unit, jM3518truncateToUwyO8pc$kotlin_stdlib2);
            long jM3501minusLRDsOJo = Duration.m3501minusLRDsOJo(jM3502plusLRDsOJo, jM3518truncateToUwyO8pc$kotlin_stdlib2);
            long jM3487getInWholeNanosecondsimpl = Duration.m3487getInWholeNanosecondsimpl(jM3501minusLRDsOJo);
            if (jM3572saturatingAddNuflL3o2 != 0 && jM3487getInWholeNanosecondsimpl != 0 && (jM3572saturatingAddNuflL3o2 ^ jM3487getInWholeNanosecondsimpl) < 0) {
                long duration = DurationKt.toDuration(MathKt.getSign(jM3487getInWholeNanosecondsimpl), unit);
                jM3572saturatingAddNuflL3o2 = LongSaturatedMathKt.m3572saturatingAddNuflL3o(jM3572saturatingAddNuflL3o2, unit, duration);
                jM3501minusLRDsOJo = Duration.m3501minusLRDsOJo(jM3501minusLRDsOJo, duration);
            }
            if ((1 | (jM3572saturatingAddNuflL3o2 - 1)) == Long.MAX_VALUE) {
                jM3501minusLRDsOJo = Duration.INSTANCE.m3548getZEROUwyO8pc();
            }
            return new LongTimeMark(jM3572saturatingAddNuflL3o2, this.timeSource, jM3501minusLRDsOJo, null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc */
        public long mo3460minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return Duration.m3502plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), Duration.m3501minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object obj) {
            return (obj instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) obj).timeSource) && Duration.m3472equalsimpl0(mo3460minusUwyO8pc((ComparableTimeMark) obj), Duration.INSTANCE.m3548getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m3494hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m3515toStringimpl(this.offset)) + ", " + this.timeSource + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Override // kotlin.time.TimeSource
    @NotNull
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.INSTANCE.m3548getZEROUwyO8pc(), null);
    }
}
