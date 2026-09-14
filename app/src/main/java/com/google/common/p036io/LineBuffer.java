package com.google.common.p036io;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p168io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    protected abstract void handleLine(String str, String str2);

    LineBuffer() {
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    protected void add(char[] cArr, int i, int i2) {
        int i3;
        if (!this.sawReturn || i2 <= 0) {
            i3 = i;
        } else {
            if (finishLine(cArr[i] == '\n')) {
                i3 = i + 1;
            } else {
                i3 = i;
            }
        }
        int i4 = i + i2;
        int i5 = i3;
        while (i3 < i4) {
            char c = cArr[i3];
            if (c != '\n') {
                if (c == '\r') {
                    this.line.append(cArr, i5, i3 - i5);
                    this.sawReturn = true;
                    int i6 = i3 + 1;
                    if (i6 < i4) {
                        if (finishLine(cArr[i6] == '\n')) {
                            i3 = i6;
                        }
                    }
                }
                i3++;
            } else {
                this.line.append(cArr, i5, i3 - i5);
                finishLine(true);
            }
            i5 = i3 + 1;
            i3++;
        }
        this.line.append(cArr, i5, i4 - i5);
    }

    private boolean finishLine(boolean z) {
        String str;
        if (this.sawReturn) {
            str = z ? IOUtils.LINE_SEPARATOR_WINDOWS : StringUtils.f3984CR;
        } else {
            str = z ? "\n" : "";
        }
        handleLine(this.line.toString(), str);
        this.line = new StringBuilder();
        this.sawReturn = false;
        return z;
    }

    protected void finish() {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }
}
