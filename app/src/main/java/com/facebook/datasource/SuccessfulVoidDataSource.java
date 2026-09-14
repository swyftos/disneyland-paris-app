package com.facebook.datasource;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1836d2 = {"Lcom/facebook/datasource/SuccessfulVoidDataSource;", "Lcom/facebook/datasource/AbstractDataSource;", "Ljava/lang/Void;", "<init>", "()V", "fbcore_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SuccessfulVoidDataSource extends AbstractDataSource<Void> {

    @NotNull
    public static final SuccessfulVoidDataSource INSTANCE;

    private SuccessfulVoidDataSource() {
    }

    static {
        SuccessfulVoidDataSource successfulVoidDataSource = new SuccessfulVoidDataSource();
        INSTANCE = successfulVoidDataSource;
        successfulVoidDataSource.setResult(null, true);
    }
}
