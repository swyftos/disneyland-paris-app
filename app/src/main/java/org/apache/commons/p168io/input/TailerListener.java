package org.apache.commons.p168io.input;

/* JADX INFO: loaded from: classes6.dex */
public interface TailerListener {
    void fileNotFound();

    void fileRotated();

    void handle(Exception exc);

    void handle(String str);

    void init(Tailer tailer);
}
