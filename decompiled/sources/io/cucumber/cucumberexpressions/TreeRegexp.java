package io.cucumber.cucumberexpressions;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
class TreeRegexp {
    private final GroupBuilder groupBuilder;
    private final Pattern pattern;

    TreeRegexp(String str) {
        this(PatternCompilerProvider.getCompiler().compile(str, 256));
    }

    TreeRegexp(Pattern pattern) {
        this.pattern = pattern;
        String strPattern = pattern.pattern();
        char[] charArray = strPattern.toCharArray();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        arrayDeque.push(new GroupBuilder());
        int length = charArray.length;
        int i = 1;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        char c = 0;
        boolean z3 = false;
        while (i2 < length) {
            char c2 = charArray[i2];
            if (c2 == '[' && !z) {
                z2 = true;
            } else if (c2 != ']' || z) {
                if (c2 == '(' && !z && !z2) {
                    arrayDeque.push(new GroupBuilder());
                    arrayDeque2.push(Integer.valueOf(i));
                } else if (c2 == ')' && !z && !z2) {
                    GroupBuilder groupBuilder = (GroupBuilder) arrayDeque.pop();
                    int iIntValue = ((Integer) arrayDeque2.pop()).intValue();
                    if (groupBuilder.isCapturing()) {
                        groupBuilder.setSource(strPattern.substring(iIntValue, i - 1));
                        ((GroupBuilder) arrayDeque.peek()).add(groupBuilder);
                    } else {
                        groupBuilder.moveChildrenTo((GroupBuilder) arrayDeque.peek());
                    }
                } else if (c2 == '?' && c == '(') {
                    z3 = true;
                } else if (c2 == ':' && z3) {
                    ((GroupBuilder) arrayDeque.peek()).setNonCapturing();
                }
                z3 = false;
            } else {
                z2 = false;
            }
            z = c2 == '\\' && !z;
            i++;
            i2++;
            c = c2;
        }
        this.groupBuilder = (GroupBuilder) arrayDeque.pop();
    }

    Pattern pattern() {
        return this.pattern;
    }

    Group match(CharSequence charSequence) {
        Matcher matcher = this.pattern.matcher(charSequence);
        if (matcher.matches()) {
            return this.groupBuilder.build(matcher, new IntRange(0, matcher.groupCount() + 1));
        }
        return null;
    }

    public GroupBuilder getGroupBuilder() {
        return this.groupBuilder;
    }

    private static class IntRange implements Iterator {
        private final int endExclusive;
        private int n;

        public IntRange(int i, int i2) {
            this.endExclusive = i2;
            this.n = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n < this.endExclusive;
        }

        @Override // java.util.Iterator
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.n;
            this.n = i + 1;
            return Integer.valueOf(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
