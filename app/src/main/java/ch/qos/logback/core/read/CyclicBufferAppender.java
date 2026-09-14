package ch.qos.logback.core.read;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.helpers.CyclicBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class CyclicBufferAppender<E> extends AppenderBase<E> {

    /* JADX INFO: renamed from: cb */
    CyclicBuffer f194cb;
    int maxSize = 512;

    @Override // ch.qos.logback.core.AppenderBase
    protected void append(E e) {
        if (isStarted()) {
            this.f194cb.add(e);
        }
    }

    public E get(int i) {
        if (isStarted()) {
            return (E) this.f194cb.get(i);
        }
        return null;
    }

    public int getLength() {
        if (isStarted()) {
            return this.f194cb.length();
        }
        return 0;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void reset() {
        this.f194cb.clear();
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.f194cb = new CyclicBuffer(this.maxSize);
        super.start();
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.f194cb = null;
        super.stop();
    }
}
