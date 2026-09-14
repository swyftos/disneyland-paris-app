package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ExperimentalRetryPolicy;
import androidx.camera.core.RetryPolicy;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalRetryPolicy
public interface RetryPolicyInternal extends RetryPolicy {
    @NonNull
    RetryPolicy copy(long j);
}
