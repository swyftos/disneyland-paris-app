package com.google.common.base;

/* JADX INFO: loaded from: classes4.dex */
abstract class CommonPattern {
    public abstract int flags();

    public abstract CommonMatcher matcher(CharSequence charSequence);

    public abstract String pattern();

    CommonPattern() {
    }
}
