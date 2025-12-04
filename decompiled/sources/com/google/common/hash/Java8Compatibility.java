package com.google.common.hash;

import java.nio.Buffer;

/* loaded from: classes4.dex */
abstract class Java8Compatibility {
    static void clear(Buffer buffer) {
        buffer.clear();
    }

    static void flip(Buffer buffer) {
        buffer.flip();
    }

    static void position(Buffer buffer, int i) {
        buffer.position(i);
    }
}
