package com.disney.id.android.validation;

import androidx.annotation.Keep;
import androidx.autofill.HintConstants;
import com.disney.id.android.PasswordScore;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import gherkin.GherkinLanguageConstants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/disney/id/android/validation/PasswordValidation;", "", "<init>", "()V", "", "str", "", "getEntropy", "(Ljava/lang/String;)D", "bitsOfEntropy", "", "getReportScore", "(D)I", HintConstants.AUTOFILL_HINT_PASSWORD, "Lcom/disney/id/android/PasswordScore;", "getScore", "(Ljava/lang/String;)Lcom/disney/id/android/PasswordScore;", "Lcom/disney/id/android/validation/PasswordValidation$EntropyReport;", "getEntropyReport", "(Ljava/lang/String;)Lcom/disney/id/android/validation/PasswordValidation$EntropyReport;", "Lkotlin/text/Regex;", "regex", "Lkotlin/text/Regex;", "EntropyReport", "ErrorReport", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPasswordValidation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PasswordValidation.kt\ncom/disney/id/android/validation/PasswordValidation\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1174#2,2:95\n1855#3,2:97\n*S KotlinDebug\n*F\n+ 1 PasswordValidation.kt\ncom/disney/id/android/validation/PasswordValidation\n*L\n74#1:95,2\n77#1:97,2\n*E\n"})
/* loaded from: classes3.dex */
public final class PasswordValidation {

    @NotNull
    public static final PasswordValidation INSTANCE = new PasswordValidation();
    private static final Regex regex = new Regex(ArraysKt.joinToString$default(new String[]{"[^ 0-9!@#$%^&*\"'()+,\\-./:;\\\\<=>?\\[\\]_`{|}~][ 0-9!@#$%^&*\"'()+,\\-./:;\\\\<=>?\\[\\]_`{|}~]", "[ 0-9!@#$%^&*\"'()+,\\-./:;\\\\<=>?\\[\\]_`{|}~][^ 0-9!@#$%^&*\"'()+,\\-./:;\\\\<=>?\\[\\]_`{|}~]"}, GherkinLanguageConstants.TABLE_CELL_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));

    private final int getReportScore(double bitsOfEntropy) {
        if (bitsOfEntropy >= 35.0d) {
            return 6;
        }
        if (bitsOfEntropy >= 30.0d && bitsOfEntropy < 35.0d) {
            return 5;
        }
        if (bitsOfEntropy >= 25.0d && bitsOfEntropy < 30.0d) {
            return 4;
        }
        if (bitsOfEntropy < 20.0d || bitsOfEntropy >= 25.0d) {
            return (bitsOfEntropy < 15.0d || bitsOfEntropy >= 20.0d) ? 1 : 2;
        }
        return 3;
    }

    private PasswordValidation() {
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/disney/id/android/validation/PasswordValidation$ErrorReport;", "", HintConstants.AUTOFILL_HINT_PASSWORD, "", "(Ljava/lang/String;)V", "invalidValuePasswordMissingExpectedChars", "", "getInvalidValuePasswordMissingExpectedChars$OneID_release", "()Z", "invalidValuePasswordTooLong", "getInvalidValuePasswordTooLong$OneID_release", "invalidValuePasswordTooShort", "getInvalidValuePasswordTooShort$OneID_release", "missingValue", "getMissingValue$OneID_release", "getPassword", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ErrorReport {
        private final boolean invalidValuePasswordMissingExpectedChars;
        private final boolean invalidValuePasswordTooLong;
        private final boolean invalidValuePasswordTooShort;
        private final boolean missingValue;

        @NotNull
        private final String password;

        public static /* synthetic */ ErrorReport copy$default(ErrorReport errorReport, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorReport.password;
            }
            return errorReport.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        @NotNull
        public final ErrorReport copy(@NotNull String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            return new ErrorReport(password);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ErrorReport) && Intrinsics.areEqual(this.password, ((ErrorReport) other).password);
        }

        public int hashCode() {
            return this.password.hashCode();
        }

        @NotNull
        public String toString() {
            return "ErrorReport(password=" + this.password + ")";
        }

        public ErrorReport(@NotNull String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.password = password;
            this.missingValue = password.length() == 0;
            this.invalidValuePasswordTooShort = password.length() < 6;
            this.invalidValuePasswordTooLong = password.length() >= 256;
            this.invalidValuePasswordMissingExpectedChars = !PasswordValidation.regex.containsMatchIn(password);
        }

        @NotNull
        public final String getPassword() {
            return this.password;
        }

        /* renamed from: getMissingValue$OneID_release, reason: from getter */
        public final boolean getMissingValue() {
            return this.missingValue;
        }

        /* renamed from: getInvalidValuePasswordTooShort$OneID_release, reason: from getter */
        public final boolean getInvalidValuePasswordTooShort() {
            return this.invalidValuePasswordTooShort;
        }

        /* renamed from: getInvalidValuePasswordTooLong$OneID_release, reason: from getter */
        public final boolean getInvalidValuePasswordTooLong() {
            return this.invalidValuePasswordTooLong;
        }

        /* renamed from: getInvalidValuePasswordMissingExpectedChars$OneID_release, reason: from getter */
        public final boolean getInvalidValuePasswordMissingExpectedChars() {
            return this.invalidValuePasswordMissingExpectedChars;
        }
    }

    @NotNull
    public final PasswordScore getScore(@NotNull String password) {
        int iMax;
        Intrinsics.checkNotNullParameter(password, "password");
        String string = StringsKt.trim(password).toString();
        ErrorReport errorReport = new ErrorReport(string);
        if (errorReport.getInvalidValuePasswordTooLong()) {
            iMax = 7;
        } else if (errorReport.getMissingValue()) {
            iMax = 0;
        } else if (errorReport.getInvalidValuePasswordTooShort() && errorReport.getInvalidValuePasswordMissingExpectedChars()) {
            iMax = 1;
        } else {
            iMax = (errorReport.getInvalidValuePasswordTooShort() || errorReport.getInvalidValuePasswordMissingExpectedChars()) ? 2 : Math.max(3, getEntropyReport(string).getScore());
        }
        return new PasswordScore(iMax, errorReport);
    }

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/disney/id/android/validation/PasswordValidation$EntropyReport;", "", "input", "", "entropy", "", "bitsOfEntropy", FirebaseAnalytics.Param.SCORE, "", "(Ljava/lang/String;DDI)V", "getBitsOfEntropy", "()D", "getEntropy", "getInput", "()Ljava/lang/String;", "getScore", "()I", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class EntropyReport {
        private final double bitsOfEntropy;
        private final double entropy;

        @NotNull
        private final String input;
        private final int score;

        public static /* synthetic */ EntropyReport copy$default(EntropyReport entropyReport, String str, double d, double d2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = entropyReport.input;
            }
            if ((i2 & 2) != 0) {
                d = entropyReport.entropy;
            }
            double d3 = d;
            if ((i2 & 4) != 0) {
                d2 = entropyReport.bitsOfEntropy;
            }
            double d4 = d2;
            if ((i2 & 8) != 0) {
                i = entropyReport.score;
            }
            return entropyReport.copy(str, d3, d4, i);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getInput() {
            return this.input;
        }

        /* renamed from: component2, reason: from getter */
        public final double getEntropy() {
            return this.entropy;
        }

        /* renamed from: component3, reason: from getter */
        public final double getBitsOfEntropy() {
            return this.bitsOfEntropy;
        }

        /* renamed from: component4, reason: from getter */
        public final int getScore() {
            return this.score;
        }

        @NotNull
        public final EntropyReport copy(@NotNull String input, double entropy, double bitsOfEntropy, int score) {
            Intrinsics.checkNotNullParameter(input, "input");
            return new EntropyReport(input, entropy, bitsOfEntropy, score);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EntropyReport)) {
                return false;
            }
            EntropyReport entropyReport = (EntropyReport) other;
            return Intrinsics.areEqual(this.input, entropyReport.input) && Double.compare(this.entropy, entropyReport.entropy) == 0 && Double.compare(this.bitsOfEntropy, entropyReport.bitsOfEntropy) == 0 && this.score == entropyReport.score;
        }

        public int hashCode() {
            return (((((this.input.hashCode() * 31) + Double.hashCode(this.entropy)) * 31) + Double.hashCode(this.bitsOfEntropy)) * 31) + Integer.hashCode(this.score);
        }

        @NotNull
        public String toString() {
            return "EntropyReport(input=" + this.input + ", entropy=" + this.entropy + ", bitsOfEntropy=" + this.bitsOfEntropy + ", score=" + this.score + ")";
        }

        public EntropyReport(@NotNull String input, double d, double d2, int i) {
            Intrinsics.checkNotNullParameter(input, "input");
            this.input = input;
            this.entropy = d;
            this.bitsOfEntropy = d2;
            this.score = i;
        }

        @NotNull
        public final String getInput() {
            return this.input;
        }

        public final double getEntropy() {
            return this.entropy;
        }

        public final double getBitsOfEntropy() {
            return this.bitsOfEntropy;
        }

        public final int getScore() {
            return this.score;
        }
    }

    @NotNull
    public final EntropyReport getEntropyReport(@NotNull String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        double entropy = getEntropy(password);
        double length = entropy * password.length();
        return new EntropyReport(password, entropy, length, getReportScore(length));
    }

    private final double getEntropy(String str) {
        double length = str.length();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            Character chValueOf = Character.valueOf(cCharAt);
            Integer num = (Integer) linkedHashMap.get(Character.valueOf(cCharAt));
            linkedHashMap.put(chValueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        }
        double dLog = 0.0d;
        for (Character ch2 : linkedHashMap.keySet()) {
            ch2.charValue();
            double dIntValue = (((Integer) linkedHashMap.get(ch2)) != null ? r6.intValue() : 0.0d) / length;
            dLog -= (dIntValue * Math.log(dIntValue)) / Math.log(2.0d);
        }
        return dLog;
    }
}
