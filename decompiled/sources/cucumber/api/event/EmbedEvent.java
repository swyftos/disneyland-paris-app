package cucumber.api.event;

import cucumber.api.TestCase;

/* loaded from: classes5.dex */
public final class EmbedEvent extends TestCaseEvent {
    public final byte[] data;
    public final String mimeType;
    public final String name;

    @Deprecated
    public EmbedEvent(Long l, TestCase testCase, byte[] bArr, String str) {
        this(l, 0L, testCase, bArr, str);
    }

    public EmbedEvent(Long l, long j, TestCase testCase, byte[] bArr, String str) {
        super(l, j, testCase);
        this.data = bArr;
        this.mimeType = str;
        this.name = null;
    }

    public EmbedEvent(Long l, long j, TestCase testCase, byte[] bArr, String str, String str2) {
        super(l, j, testCase);
        this.data = bArr;
        this.mimeType = str;
        this.name = str2;
    }
}
