package io.cucumber.cucumberexpressions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/* loaded from: classes5.dex */
class NumberParser {
    private final NumberFormat numberFormat;

    NumberParser(Locale locale) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(locale);
        this.numberFormat = numberInstance;
        if (numberInstance instanceof DecimalFormat) {
            ((DecimalFormat) numberInstance).setParseBigDecimal(true);
        }
    }

    double parseDouble(String str) {
        return parse(str).doubleValue();
    }

    float parseFloat(String str) {
        return parse(str).floatValue();
    }

    BigDecimal parseBigDecimal(String str) {
        if (this.numberFormat instanceof DecimalFormat) {
            return (BigDecimal) parse(str);
        }
        return new BigDecimal(str);
    }

    private Number parse(String str) {
        try {
            return this.numberFormat.parse(str);
        } catch (ParseException e) {
            throw new CucumberExpressionException("Failed to parse number", e);
        }
    }
}
