package androidx.media3.exoplayer.upstream.experimental;

import androidx.camera.video.AudioStats;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.TreeSet;

@UnstableApi
/* loaded from: classes.dex */
public class SlidingPercentileBandwidthStatistic implements BandwidthStatistic {
    public static final int DEFAULT_MAX_SAMPLES_COUNT = 10;
    public static final double DEFAULT_PERCENTILE = 0.5d;
    private long bitrateEstimate;
    private final int maxSampleCount;
    private final double percentile;
    private final ArrayDeque samples;
    private final TreeSet sortedSamples;
    private double weightSum;

    public SlidingPercentileBandwidthStatistic() {
        this(10, 0.5d);
    }

    public SlidingPercentileBandwidthStatistic(int i, double d) {
        Assertions.checkArgument(d >= AudioStats.AUDIO_AMPLITUDE_NONE && d <= 1.0d);
        this.maxSampleCount = i;
        this.percentile = d;
        this.samples = new ArrayDeque();
        this.sortedSamples = new TreeSet();
        this.bitrateEstimate = Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public void addSample(long j, long j2) {
        while (this.samples.size() >= this.maxSampleCount) {
            Sample sample = (Sample) this.samples.remove();
            this.sortedSamples.remove(sample);
            this.weightSum -= sample.weight;
        }
        double dSqrt = Math.sqrt(j);
        Sample sample2 = new Sample((j * 8000000) / j2, dSqrt);
        this.samples.add(sample2);
        this.sortedSamples.add(sample2);
        this.weightSum += dSqrt;
        this.bitrateEstimate = calculateBitrateEstimate();
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public long getBandwidthEstimate() {
        return this.bitrateEstimate;
    }

    @Override // androidx.media3.exoplayer.upstream.experimental.BandwidthStatistic
    public void reset() {
        this.samples.clear();
        this.sortedSamples.clear();
        this.weightSum = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.bitrateEstimate = Long.MIN_VALUE;
    }

    private long calculateBitrateEstimate() {
        if (this.samples.isEmpty()) {
            return Long.MIN_VALUE;
        }
        double d = this.weightSum * this.percentile;
        Iterator it = this.sortedSamples.iterator();
        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        long j = 0;
        double d3 = 0.0d;
        while (it.hasNext()) {
            Sample sample = (Sample) it.next();
            double d4 = d2 + (sample.weight / 2.0d);
            if (d4 >= d) {
                return j == 0 ? sample.bitrate : j + ((long) (((sample.bitrate - j) * (d - d3)) / (d4 - d3)));
            }
            j = sample.bitrate;
            d2 = (sample.weight / 2.0d) + d4;
            d3 = d4;
        }
        return j;
    }

    private static class Sample implements Comparable {
        private final long bitrate;
        private final double weight;

        public Sample(long j, double d) {
            this.bitrate = j;
            this.weight = d;
        }

        @Override // java.lang.Comparable
        public int compareTo(Sample sample) {
            return Util.compareLong(this.bitrate, sample.bitrate);
        }
    }
}
