package com.fasterxml.jackson.core;

/* JADX INFO: loaded from: classes3.dex */
public interface FormatFeature {
    boolean enabledByDefault();

    boolean enabledIn(int i);

    int getMask();
}
