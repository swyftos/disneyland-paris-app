package io.cucumber.cucumberexpressions;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
class ParameterTypeMatcher implements Comparable {
    private final Matcher matcher;
    private final ParameterType parameterType;
    private final int textLength;

    public ParameterTypeMatcher(ParameterType parameterType, Matcher matcher, int i) {
        this.parameterType = parameterType;
        this.matcher = matcher;
        this.textLength = i;
    }

    public boolean advanceToAndFind(int i) {
        this.matcher.region(i, this.textLength);
        while (this.matcher.find()) {
            if (!group().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int start() {
        return this.matcher.start();
    }

    public String group() {
        return this.matcher.group();
    }

    @Override // java.lang.Comparable
    public int compareTo(ParameterTypeMatcher parameterTypeMatcher) {
        int iCompare = Integer.compare(start(), parameterTypeMatcher.start());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Integer.compare(parameterTypeMatcher.group().length(), group().length());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        return 0;
    }

    public ParameterType getParameterType() {
        return this.parameterType;
    }
}
