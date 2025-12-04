package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ExperimentalRetryPolicy;
import androidx.camera.core.RetryPolicy;

@ExperimentalRetryPolicy
/* loaded from: classes.dex */
public interface RetryPolicyInternal extends RetryPolicy {
    @NonNull
    RetryPolicy copy(long j);
}
