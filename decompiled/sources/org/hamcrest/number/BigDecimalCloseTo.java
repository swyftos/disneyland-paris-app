package org.hamcrest.number;

import java.math.BigDecimal;
import java.math.MathContext;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes6.dex */
public class BigDecimalCloseTo extends TypeSafeMatcher<BigDecimal> {
    private final BigDecimal delta;
    private final BigDecimal value;

    public BigDecimalCloseTo(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        this.delta = bigDecimal2;
        this.value = bigDecimal;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(BigDecimal bigDecimal) {
        return actualDelta(bigDecimal).compareTo(BigDecimal.ZERO) <= 0;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(BigDecimal bigDecimal, Description description) {
        description.appendValue(bigDecimal).appendText(" differed by ").appendValue(actualDelta(bigDecimal));
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("a numeric value within ").appendValue(this.delta).appendText(" of ").appendValue(this.value);
    }

    private BigDecimal actualDelta(BigDecimal bigDecimal) {
        BigDecimal bigDecimal2 = this.value;
        MathContext mathContext = MathContext.DECIMAL128;
        return bigDecimal.subtract(bigDecimal2, mathContext).abs().subtract(this.delta, mathContext).stripTrailingZeros();
    }

    @Factory
    public static Matcher<BigDecimal> closeTo(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return new BigDecimalCloseTo(bigDecimal, bigDecimal2);
    }
}
