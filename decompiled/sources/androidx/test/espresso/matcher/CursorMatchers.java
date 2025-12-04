package androidx.test.espresso.matcher;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

/* loaded from: classes2.dex */
public final class CursorMatchers {
    private static final CursorDataRetriever BLOB_MATCHER_APPLIER = new CursorDataRetriever<byte[]>() { // from class: androidx.test.espresso.matcher.CursorMatchers.1
        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Blob");
        }

        @Override // androidx.test.espresso.matcher.CursorMatchers.CursorDataRetriever
        public byte[] getData(Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    };
    private static final CursorDataRetriever LONG_MATCHER_APPLIER = new CursorDataRetriever<Long>() { // from class: androidx.test.espresso.matcher.CursorMatchers.2
        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Long");
        }

        @Override // androidx.test.espresso.matcher.CursorMatchers.CursorDataRetriever
        public Long getData(Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }
    };
    private static final CursorDataRetriever SHORT_MATCHER_APPLIER = new CursorDataRetriever<Short>() { // from class: androidx.test.espresso.matcher.CursorMatchers.3
        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Short");
        }

        @Override // androidx.test.espresso.matcher.CursorMatchers.CursorDataRetriever
        public Short getData(Cursor cursor, int i) {
            return Short.valueOf(cursor.getShort(i));
        }
    };
    private static final CursorDataRetriever INT_MATCHER_APPLIER = new CursorDataRetriever<Integer>() { // from class: androidx.test.espresso.matcher.CursorMatchers.4
        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Int");
        }

        @Override // androidx.test.espresso.matcher.CursorMatchers.CursorDataRetriever
        public Integer getData(Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    };
    private static final CursorDataRetriever FLOAT_MATCHER_APPLIER = new CursorDataRetriever<Float>() { // from class: androidx.test.espresso.matcher.CursorMatchers.5
        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Float");
        }

        @Override // androidx.test.espresso.matcher.CursorMatchers.CursorDataRetriever
        public Float getData(Cursor cursor, int i) {
            return Float.valueOf(cursor.getFloat(i));
        }
    };
    private static final CursorDataRetriever DOUBLE_MATCHER_APPLIER = new CursorDataRetriever<Double>() { // from class: androidx.test.espresso.matcher.CursorMatchers.6
        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Double");
        }

        @Override // androidx.test.espresso.matcher.CursorMatchers.CursorDataRetriever
        public Double getData(Cursor cursor, int i) {
            return Double.valueOf(cursor.getDouble(i));
        }
    };
    private static final CursorDataRetriever STRING_MATCHER_APPLIER = new CursorDataRetriever<String>() { // from class: androidx.test.espresso.matcher.CursorMatchers.7
        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with String");
        }

        @Override // androidx.test.espresso.matcher.CursorMatchers.CursorDataRetriever
        public String getData(Cursor cursor, int i) {
            return cursor.getString(i);
        }
    };

    private interface CursorDataRetriever<T> extends SelfDescribing {
        Object getData(Cursor cursor, int i);
    }

    public static CursorMatcher withRowBlob(int i, Matcher<byte[]> matcher) {
        return new CursorMatcher(i, matcher, BLOB_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowDouble(int i, double d) {
        return withRowDouble(i, (Matcher<Double>) Matchers.is(Double.valueOf(d)));
    }

    public static CursorMatcher withRowFloat(int i, float f) {
        return withRowFloat(i, (Matcher<Float>) Matchers.is(Float.valueOf(f)));
    }

    public static CursorMatcher withRowInt(int i, int i2) {
        return withRowInt(i, (Matcher<Integer>) Matchers.is(Integer.valueOf(i2)));
    }

    public static CursorMatcher withRowLong(int i, long j) {
        return withRowLong(i, (Matcher<Long>) Matchers.is(Long.valueOf(j)));
    }

    public static CursorMatcher withRowShort(int i, Matcher<Short> matcher) {
        return new CursorMatcher(i, matcher, SHORT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowString(int i, String str) {
        return withRowString(i, (Matcher<String>) Matchers.is(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int findColumnIndex(Matcher matcher, Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        int i = -1;
        for (int i2 = 0; i2 < columnNames.length; i2++) {
            if (matcher.matches(columnNames[i2])) {
                if (i != -1) {
                    return -2;
                }
                i = i2;
            }
        }
        return i;
    }

    public static CursorMatcher withRowBlob(int i, byte[] bArr) {
        return withRowBlob(i, (Matcher<byte[]>) Matchers.is(bArr));
    }

    public static CursorMatcher withRowDouble(int i, Matcher<Double> matcher) {
        return new CursorMatcher(i, matcher, DOUBLE_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowFloat(int i, Matcher<Float> matcher) {
        return new CursorMatcher(i, matcher, FLOAT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowInt(int i, Matcher<Integer> matcher) {
        return new CursorMatcher(i, matcher, INT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowLong(int i, Matcher<Long> matcher) {
        return new CursorMatcher(i, matcher, LONG_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowShort(int i, short s) {
        return withRowShort(i, (Matcher<Short>) Matchers.is(Short.valueOf(s)));
    }

    public static CursorMatcher withRowString(int i, Matcher<String> matcher) {
        return new CursorMatcher(i, matcher, STRING_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowBlob(String str, Matcher<byte[]> matcher) {
        return withRowBlob((Matcher<String>) Matchers.is(str), matcher);
    }

    public static CursorMatcher withRowDouble(String str, double d) {
        return withRowDouble(str, (Matcher<Double>) Matchers.is(Double.valueOf(d)));
    }

    public static CursorMatcher withRowFloat(String str, float f) {
        return withRowFloat(str, (Matcher<Float>) Matchers.is(Float.valueOf(f)));
    }

    public static CursorMatcher withRowInt(String str, int i) {
        return withRowInt(str, (Matcher<Integer>) Matchers.is(Integer.valueOf(i)));
    }

    public static CursorMatcher withRowLong(String str, long j) {
        return withRowLong(str, (Matcher<Long>) Matchers.is(Long.valueOf(j)));
    }

    public static CursorMatcher withRowShort(String str, Matcher<Short> matcher) {
        return withRowShort((Matcher<String>) Matchers.is(str), matcher);
    }

    public static CursorMatcher withRowString(String str, String str2) {
        return withRowString((Matcher<String>) Matchers.is(str), (Matcher<String>) Matchers.is(str2));
    }

    public static CursorMatcher withRowBlob(String str, byte[] bArr) {
        return withRowBlob((Matcher<String>) Matchers.is(str), (Matcher<byte[]>) Matchers.is(bArr));
    }

    public static CursorMatcher withRowDouble(String str, Matcher<Double> matcher) {
        return withRowDouble((Matcher<String>) Matchers.is(str), matcher);
    }

    public static CursorMatcher withRowFloat(String str, Matcher<Float> matcher) {
        return withRowFloat((Matcher<String>) Matchers.is(str), matcher);
    }

    public static CursorMatcher withRowInt(String str, Matcher<Integer> matcher) {
        return withRowInt((Matcher<String>) Matchers.is(str), matcher);
    }

    public static CursorMatcher withRowLong(String str, Matcher<Long> matcher) {
        return withRowLong((Matcher<String>) Matchers.is(str), matcher);
    }

    public static CursorMatcher withRowShort(String str, short s) {
        return withRowShort(str, (Matcher<Short>) Matchers.is(Short.valueOf(s)));
    }

    public static CursorMatcher withRowString(String str, Matcher<String> matcher) {
        return withRowString((Matcher<String>) Matchers.is(str), matcher);
    }

    public static CursorMatcher withRowBlob(Matcher<String> matcher, Matcher<byte[]> matcher2) {
        return new CursorMatcher(matcher, matcher2, BLOB_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowDouble(Matcher<String> matcher, Matcher<Double> matcher2) {
        return new CursorMatcher(matcher, matcher2, DOUBLE_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowFloat(Matcher<String> matcher, Matcher<Float> matcher2) {
        return new CursorMatcher(matcher, matcher2, FLOAT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowInt(Matcher<String> matcher, Matcher<Integer> matcher2) {
        return new CursorMatcher(matcher, matcher2, INT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowLong(Matcher<String> matcher, Matcher<Long> matcher2) {
        return new CursorMatcher(matcher, matcher2, LONG_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowShort(Matcher<String> matcher, Matcher<Short> matcher2) {
        return new CursorMatcher(matcher, matcher2, SHORT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowString(Matcher<String> matcher, Matcher<String> matcher2) {
        return new CursorMatcher(matcher, matcher2, STRING_MATCHER_APPLIER);
    }

    public static class CursorMatcher extends BoundedMatcher<Object, Cursor> {
        private boolean checkColumns;
        private final int columnIndex;
        private final Matcher columnNameMatcher;
        private final CursorDataRetriever cursorDataRetriever;
        private final Matcher valueMatcher;

        private CursorMatcher(int i, Matcher matcher, CursorDataRetriever cursorDataRetriever) {
            super(Cursor.class);
            this.checkColumns = false;
            Preconditions.checkArgument(i >= 0);
            this.columnIndex = i;
            this.valueMatcher = (Matcher) Preconditions.checkNotNull(matcher);
            this.cursorDataRetriever = (CursorDataRetriever) Preconditions.checkNotNull(cursorDataRetriever);
            this.columnNameMatcher = null;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("an instance of android.database.Cursor and Rows with column: ");
            int i = this.columnIndex;
            if (i < 0) {
                this.columnNameMatcher.describeTo(description);
            } else {
                StringBuilder sb = new StringBuilder(19);
                sb.append("index = ");
                sb.append(i);
                description.appendText(sb.toString());
            }
            description.appendText(" ").appendDescriptionOf(this.cursorDataRetriever).appendText(" matching ").appendDescriptionOf(this.valueMatcher);
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(Cursor cursor) {
            int iFindColumnIndex = this.columnIndex;
            StringDescription stringDescription = new StringDescription();
            if (iFindColumnIndex < 0 && (iFindColumnIndex = CursorMatchers.findColumnIndex(this.columnNameMatcher, cursor)) < 0) {
                if (iFindColumnIndex == -2) {
                    stringDescription.appendText("Multiple columns in ").appendValue(cursor.getColumnNames()).appendText(" match ").appendDescriptionOf(this.columnNameMatcher);
                } else {
                    stringDescription.appendText("Couldn't find column in ").appendValue(cursor.getColumnNames()).appendText(" matching ").appendDescriptionOf(this.columnNameMatcher);
                }
                if (this.checkColumns) {
                    throw new IllegalArgumentException(stringDescription.toString());
                }
                return false;
            }
            try {
                Object data = this.cursorDataRetriever.getData(cursor, iFindColumnIndex);
                boolean zMatches = this.valueMatcher.matches(data);
                if (!zMatches) {
                    stringDescription.appendText("value at column ").appendValue(Integer.valueOf(iFindColumnIndex)).appendText(" ");
                    this.valueMatcher.describeMismatch(data, stringDescription);
                }
                return zMatches;
            } catch (CursorIndexOutOfBoundsException e) {
                stringDescription.appendText("Column index ").appendValue(Integer.valueOf(iFindColumnIndex)).appendText(" is invalid");
                if (this.checkColumns) {
                    throw new IllegalArgumentException(stringDescription.toString(), e);
                }
                return false;
            }
        }

        public CursorMatcher withStrictColumnChecks(boolean z) {
            this.checkColumns = z;
            return this;
        }

        private CursorMatcher(Matcher matcher, Matcher matcher2, CursorDataRetriever cursorDataRetriever) {
            super(Cursor.class);
            this.checkColumns = false;
            this.columnNameMatcher = (Matcher) Preconditions.checkNotNull(matcher);
            this.valueMatcher = (Matcher) Preconditions.checkNotNull(matcher2);
            this.cursorDataRetriever = (CursorDataRetriever) Preconditions.checkNotNull(cursorDataRetriever);
            this.columnIndex = -3;
        }
    }
}
