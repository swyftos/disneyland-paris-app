package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

@UnstableApi
/* loaded from: classes.dex */
public final class CuesWithTimingSubtitle implements Subtitle {
    private static final Ordering CUES_BY_START_TIME_ASCENDING = Ordering.natural().onResultOf(new Function() { // from class: androidx.media3.extractor.text.CuesWithTimingSubtitle$$ExternalSyntheticLambda0
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return CuesWithTimingSubtitle.lambda$static$0((CuesWithTiming) obj);
        }
    });
    private final ImmutableList eventCues;
    private final long[] eventTimesUs;

    private static long normalizeUnsetStartTimeToZero(long j) {
        if (j == C.TIME_UNSET) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Comparable lambda$static$0(CuesWithTiming cuesWithTiming) {
        return Long.valueOf(normalizeUnsetStartTimeToZero(cuesWithTiming.startTimeUs));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CuesWithTimingSubtitle(java.util.List<androidx.media3.extractor.text.CuesWithTiming> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 2
            r2 = 0
            r17.<init>()
            int r3 = r18.size()
            r4 = 1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 != r4) goto L4c
            java.lang.Object r3 = com.google.common.collect.Iterables.getOnlyElement(r18)
            androidx.media3.extractor.text.CuesWithTiming r3 = (androidx.media3.extractor.text.CuesWithTiming) r3
            long r7 = r3.startTimeUs
            long r7 = normalizeUnsetStartTimeToZero(r7)
            long r9 = r3.durationUs
            int r5 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r5 != 0) goto L34
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r1 = r3.cues
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r1)
            r0.eventCues = r1
            long[] r1 = new long[r4]
            r1[r2] = r7
            r0.eventTimesUs = r1
            goto L4b
        L34:
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r5 = r3.cues
            com.google.common.collect.ImmutableList r6 = com.google.common.collect.ImmutableList.of()
            com.google.common.collect.ImmutableList r5 = com.google.common.collect.ImmutableList.of(r5, r6)
            r0.eventCues = r5
            long r5 = r3.durationUs
            long r5 = r5 + r7
            long[] r1 = new long[r1]
            r1[r2] = r7
            r1[r4] = r5
            r0.eventTimesUs = r1
        L4b:
            return
        L4c:
            int r3 = r18.size()
            int r3 = r3 * r1
            long[] r1 = new long[r3]
            r0.eventTimesUs = r1
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.Arrays.fill(r1, r7)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.common.collect.Ordering r3 = androidx.media3.extractor.text.CuesWithTimingSubtitle.CUES_BY_START_TIME_ASCENDING
            r7 = r18
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.sortedCopyOf(r3, r7)
            r7 = r2
        L6b:
            int r8 = r3.size()
            if (r2 >= r8) goto Ld6
            java.lang.Object r8 = r3.get(r2)
            androidx.media3.extractor.text.CuesWithTiming r8 = (androidx.media3.extractor.text.CuesWithTiming) r8
            long r9 = r8.startTimeUs
            long r9 = normalizeUnsetStartTimeToZero(r9)
            long r11 = r8.durationUs
            long r11 = r11 + r9
            if (r7 == 0) goto Lb4
            long[] r13 = r0.eventTimesUs
            int r14 = r7 + (-1)
            r15 = r13[r14]
            int r13 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r13 >= 0) goto L8d
            goto Lb4
        L8d:
            int r13 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r13 != 0) goto La3
            java.lang.Object r13 = r1.get(r14)
            com.google.common.collect.ImmutableList r13 = (com.google.common.collect.ImmutableList) r13
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto La3
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r9 = r8.cues
            r1.set(r14, r9)
            goto Lc0
        La3:
            java.lang.String r13 = "CuesWithTimingSubtitle"
            java.lang.String r15 = "Truncating unsupported overlapping cues."
            androidx.media3.common.util.Log.w(r13, r15)
            long[] r13 = r0.eventTimesUs
            r13[r14] = r9
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r9 = r8.cues
            r1.set(r14, r9)
            goto Lc0
        Lb4:
            long[] r13 = r0.eventTimesUs
            int r14 = r7 + 1
            r13[r7] = r9
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r7 = r8.cues
            r1.add(r7)
            r7 = r14
        Lc0:
            long r8 = r8.durationUs
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 == 0) goto Ld4
            long[] r8 = r0.eventTimesUs
            int r9 = r7 + 1
            r8[r7] = r11
            com.google.common.collect.ImmutableList r7 = com.google.common.collect.ImmutableList.of()
            r1.add(r7)
            r7 = r9
        Ld4:
            int r2 = r2 + r4
            goto L6b
        Ld6:
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.copyOf(r1)
            r0.eventCues = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.CuesWithTimingSubtitle.<init>(java.util.List):void");
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j, false, false);
        if (iBinarySearchCeil < this.eventCues.size()) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return this.eventCues.size();
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i < this.eventCues.size());
        return this.eventTimesUs[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.text.Subtitle
    public ImmutableList<Cue> getCues(long j) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.eventTimesUs, j, true, false);
        return iBinarySearchFloor == -1 ? ImmutableList.of() : (ImmutableList) this.eventCues.get(iBinarySearchFloor);
    }
}
