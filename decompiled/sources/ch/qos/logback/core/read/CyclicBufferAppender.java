package ch.qos.logback.core.read;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.helpers.CyclicBuffer;

/* loaded from: classes2.dex */
public class CyclicBufferAppender<E> extends AppenderBase<E> {
    CyclicBuffer cb;
    int maxSize = 512;

    @Override // ch.qos.logback.core.AppenderBase
    protected void append(E e) {
        if (isStarted()) {
            this.cb.add(e);
        }
    }

    public E get(int i) {
        if (isStarted()) {
            return (E) this.cb.get(i);
        }
        return null;
    }

    public int getLength() {
        if (isStarted()) {
            return this.cb.length();
        }
        return 0;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void reset() {
        this.cb.clear();
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.cb = new CyclicBuffer(this.maxSize);
        super.start();
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.cb = null;
        super.stop();
    }
}
