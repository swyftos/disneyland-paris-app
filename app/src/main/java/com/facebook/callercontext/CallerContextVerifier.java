package com.facebook.callercontext;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m1836d2 = {"Lcom/facebook/callercontext/CallerContextVerifier;", "", "verifyCallerContext", "", "callerContext", "isPrefetch", "", "imagepipeline-base_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface CallerContextVerifier {
    void verifyCallerContext(@Nullable Object callerContext, boolean isPrefetch);
}
