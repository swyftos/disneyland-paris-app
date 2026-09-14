package org.apache.commons.lang3;

import org.apache.commons.lang3.builder.AbstractSupplier;
import org.apache.commons.lang3.function.ToBooleanBiFunction;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Strings {

    /* JADX INFO: renamed from: CI */
    public static final Strings f3986CI;

    /* JADX INFO: renamed from: CS */
    public static final Strings f3987CS;
    private final boolean ignoreCase;
    private final boolean nullIsLess;

    public abstract int compare(String str, String str2);

    public abstract boolean contains(CharSequence charSequence, CharSequence charSequence2);

    public abstract boolean equals(CharSequence charSequence, CharSequence charSequence2);

    public abstract boolean equals(String str, String str2);

    public abstract int indexOf(CharSequence charSequence, CharSequence charSequence2, int i);

    public abstract int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i);

    public static class Builder extends AbstractSupplier<Strings, Builder, RuntimeException> {
        private boolean ignoreCase;
        private boolean nullIsLess;

        private Builder() {
        }

        @Override // org.apache.commons.lang3.function.FailableSupplier
        public Strings get() {
            return this.ignoreCase ? new CiStrings(this.nullIsLess) : new CsStrings(this.nullIsLess);
        }

        public Builder setIgnoreCase(boolean z) {
            this.ignoreCase = z;
            return asThis();
        }

        public Builder setNullIsLess(boolean z) {
            this.nullIsLess = z;
            return asThis();
        }
    }

    private static final class CiStrings extends Strings {
        private CiStrings(boolean z) {
            super(true, z);
        }

        @Override // org.apache.commons.lang3.Strings
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return isNullIsLess() ? -1 : 1;
            }
            if (str2 == null) {
                return isNullIsLess() ? 1 : -1;
            }
            return str.compareToIgnoreCase(str2);
        }

        @Override // org.apache.commons.lang3.Strings
        public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
            if (charSequence != null && charSequence2 != null) {
                int length = charSequence2.length();
                int length2 = charSequence.length() - length;
                for (int i = 0; i <= length2; i++) {
                    if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, length)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // org.apache.commons.lang3.Strings
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            if (charSequence == charSequence2) {
                return true;
            }
            if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
                return false;
            }
            return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, charSequence.length());
        }

        @Override // org.apache.commons.lang3.Strings
        public boolean equals(String str, String str2) {
            if (str == null) {
                return str2 == null;
            }
            return str.equalsIgnoreCase(str2);
        }

        @Override // org.apache.commons.lang3.Strings
        public int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
            if (charSequence != null && charSequence2 != null) {
                if (i < 0) {
                    i = 0;
                }
                int length = (charSequence.length() - charSequence2.length()) + 1;
                if (i > length) {
                    return -1;
                }
                if (charSequence2.length() == 0) {
                    return i;
                }
                while (i < length) {
                    if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, charSequence2.length())) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }

        @Override // org.apache.commons.lang3.Strings
        public int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
            if (charSequence != null && charSequence2 != null) {
                int length = charSequence2.length();
                int length2 = charSequence.length() - length;
                if (i > length2) {
                    i = length2;
                }
                if (i < 0) {
                    return -1;
                }
                if (length == 0) {
                    return i;
                }
                while (i >= 0) {
                    if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, length)) {
                        return i;
                    }
                    i--;
                }
            }
            return -1;
        }
    }

    private static final class CsStrings extends Strings {
        private CsStrings(boolean z) {
            super(false, z);
        }

        @Override // org.apache.commons.lang3.Strings
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return isNullIsLess() ? -1 : 1;
            }
            if (str2 == null) {
                return isNullIsLess() ? 1 : -1;
            }
            return str.compareTo(str2);
        }

        @Override // org.apache.commons.lang3.Strings
        public boolean contains(CharSequence charSequence, CharSequence charSequence2) {
            return CharSequenceUtils.indexOf(charSequence, charSequence2, 0) >= 0;
        }

        @Override // org.apache.commons.lang3.Strings
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            if (charSequence == charSequence2) {
                return true;
            }
            if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
                return false;
            }
            if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
                return charSequence.equals(charSequence2);
            }
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        @Override // org.apache.commons.lang3.Strings
        public boolean equals(String str, String str2) {
            return Strings.m1952eq(str, str2);
        }

        @Override // org.apache.commons.lang3.Strings
        public int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
            return CharSequenceUtils.indexOf(charSequence, charSequence2, i);
        }

        @Override // org.apache.commons.lang3.Strings
        public int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
            return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i);
        }
    }

    static {
        boolean z = true;
        f3986CI = new CiStrings(z);
        f3987CS = new CsStrings(z);
    }

    public static final Builder builder() {
        return new Builder();
    }

    private static boolean containsAny(ToBooleanBiFunction toBooleanBiFunction, CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!StringUtils.isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (toBooleanBiFunction.applyAsBoolean(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: eq */
    public static boolean m1952eq(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private Strings(boolean z, boolean z2) {
        this.ignoreCase = z;
        this.nullIsLess = z2;
    }

    public String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        if (str == null || StringUtils.isEmpty(charSequence) || endsWith(str, charSequence)) {
            return str;
        }
        if (ArrayUtils.isNotEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (endsWith(str, charSequence2)) {
                    return str;
                }
            }
        }
        return str + ((Object) charSequence);
    }

    public boolean containsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        return containsAny(new ToBooleanBiFunction() { // from class: org.apache.commons.lang3.Strings$$ExternalSyntheticLambda0
            @Override // org.apache.commons.lang3.function.ToBooleanBiFunction
            public final boolean applyAsBoolean(Object obj, Object obj2) {
                return this.f$0.contains((CharSequence) obj, (CharSequence) obj2);
            }
        }, charSequence, charSequenceArr);
    }

    public boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        int length = charSequence2.length();
        if (length > charSequence.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, this.ignoreCase, charSequence.length() - length, charSequence2, 0, length);
    }

    public boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!StringUtils.isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (endsWith(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equalsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (equals(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        return indexOf(charSequence, charSequence2, 0);
    }

    public boolean isCaseSensitive() {
        return !this.ignoreCase;
    }

    boolean isNullIsLess() {
        return this.nullIsLess;
    }

    public int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null) {
            return -1;
        }
        return lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        if (str == null || StringUtils.isEmpty(charSequence) || startsWith(str, charSequence)) {
            return str;
        }
        if (ArrayUtils.isNotEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (startsWith(str, charSequence2)) {
                    return str;
                }
            }
        }
        return ((Object) charSequence) + str;
    }

    public String remove(String str, String str2) {
        return replace(str, str2, "", -1);
    }

    public String removeEnd(String str, CharSequence charSequence) {
        return (StringUtils.isEmpty(str) || StringUtils.isEmpty(charSequence) || !endsWith(str, charSequence)) ? str : str.substring(0, str.length() - charSequence.length());
    }

    public String removeStart(String str, CharSequence charSequence) {
        return (str == null || !startsWith(str, charSequence)) ? str : str.substring(StringUtils.length(charSequence));
    }

    public String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public String replace(String str, String str2, String str3, int i) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2) || str3 == null || i == 0) {
            return str;
        }
        if (this.ignoreCase) {
            str2 = str2.toLowerCase();
        }
        int i2 = 0;
        int iIndexOf = indexOf(str, str2, 0);
        if (iIndexOf == -1) {
            return str;
        }
        int length = str2.length();
        StringBuilder sb = new StringBuilder(str.length() + (Math.max(str3.length() - length, 0) * (i < 0 ? 16 : Math.min(i, 64))));
        while (iIndexOf != -1) {
            sb.append((CharSequence) str, i2, iIndexOf);
            sb.append(str3);
            i2 = iIndexOf + length;
            i--;
            if (i == 0) {
                break;
            }
            iIndexOf = indexOf(str, str2, i2);
        }
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }

    public String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        int length = charSequence2.length();
        if (length > charSequence.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, this.ignoreCase, 0, charSequence2, 0, length);
    }

    public boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!StringUtils.isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (startsWith(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
