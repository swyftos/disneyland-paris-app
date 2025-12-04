package com.fasterxml.jackson.core.async;

/* loaded from: classes3.dex */
public interface NonBlockingInputFeeder {
    void endOfInput();

    boolean needMoreInput();
}
