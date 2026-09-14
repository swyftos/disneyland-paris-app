package com.github.barteksc.pdfviewer.exception;

/* JADX INFO: loaded from: classes3.dex */
public class PageRenderingException extends Exception {
    private final int page;

    public PageRenderingException(int i, Throwable th) {
        super(th);
        this.page = i;
    }

    public int getPage() {
        return this.page;
    }
}
