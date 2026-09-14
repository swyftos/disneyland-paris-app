package org.junit.internal.management;

/* JADX INFO: loaded from: classes2.dex */
public interface ThreadMXBean {
    long getThreadCpuTime(long j);

    boolean isThreadCpuTimeSupported();
}
