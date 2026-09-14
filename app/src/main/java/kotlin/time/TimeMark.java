package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@SinceKotlin(version = "1.9")
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\u0004\n\u0002\b!¨\u0006\u000f"}, m1836d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", TypedValues.TransitionType.S_DURATION, "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface TimeMark {
    /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
    long mo5763elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @NotNull
    /* JADX INFO: renamed from: minus-LRDsOJo */
    TimeMark mo5764minusLRDsOJo(long duration);

    @NotNull
    /* JADX INFO: renamed from: plus-LRDsOJo */
    TimeMark mo5766plusLRDsOJo(long duration);

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        @NotNull
        /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m5886plusLRDsOJo(@NotNull TimeMark timeMark, long j) {
            return new AdjustedTimeMark(timeMark, j, null);
        }

        @NotNull
        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m5885minusLRDsOJo(@NotNull TimeMark timeMark, long j) {
            return timeMark.mo5766plusLRDsOJo(Duration.m5824unaryMinusUwyO8pc(j));
        }

        public static boolean hasPassedNow(@NotNull TimeMark timeMark) {
            return !Duration.m5804isNegativeimpl(timeMark.mo5763elapsedNowUwyO8pc());
        }

        public static boolean hasNotPassedNow(@NotNull TimeMark timeMark) {
            return Duration.m5804isNegativeimpl(timeMark.mo5763elapsedNowUwyO8pc());
        }
    }
}
