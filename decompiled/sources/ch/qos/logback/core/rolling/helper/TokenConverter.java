package ch.qos.logback.core.rolling.helper;

/* loaded from: classes2.dex */
public class TokenConverter {
    TokenConverter next;
    int type;

    protected TokenConverter(int i) {
        this.type = i;
    }

    public TokenConverter getNext() {
        return this.next;
    }

    public int getType() {
        return this.type;
    }

    public void setNext(TokenConverter tokenConverter) {
        this.next = tokenConverter;
    }

    public void setType(int i) {
        this.type = i;
    }
}
