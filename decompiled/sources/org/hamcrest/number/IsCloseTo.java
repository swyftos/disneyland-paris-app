package org.hamcrest.number;

import androidx.camera.video.AudioStats;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes6.dex */
public class IsCloseTo extends TypeSafeMatcher<Double> {
    private final double delta;
    private final double value;

    public IsCloseTo(double d, double d2) {
        this.delta = d2;
        this.value = d;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(Double d) {
        return actualDelta(d) <= AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(Double d, Description description) {
        description.appendValue(d).appendText(" differed by ").appendValue(Double.valueOf(actualDelta(d)));
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("a numeric value within ").appendValue(Double.valueOf(this.delta)).appendText(" of ").appendValue(Double.valueOf(this.value));
    }

    private double actualDelta(Double d) {
        return Math.abs(d.doubleValue() - this.value) - this.delta;
    }

    @Factory
    public static Matcher<Double> closeTo(double d, double d2) {
        return new IsCloseTo(d, d2);
    }
}
