package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ExperimentalRetryPolicy;
import androidx.camera.core.Logger;
import androidx.camera.core.RetryPolicy;
import androidx.camera.core.impl.CameraValidator;

@ExperimentalRetryPolicy
/* loaded from: classes.dex */
public final class CameraProviderInitRetryPolicy implements RetryPolicyInternal {
    private final RetryPolicy mDelegatePolicy;

    public CameraProviderInitRetryPolicy(final long j) {
        this.mDelegatePolicy = new TimeoutRetryPolicy(j, new RetryPolicy() { // from class: androidx.camera.core.impl.CameraProviderInitRetryPolicy.1
            @Override // androidx.camera.core.RetryPolicy
            public RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState executionState) {
                if (executionState.getStatus() == 1) {
                    return RetryPolicy.RetryConfig.NOT_RETRY;
                }
                return RetryPolicy.RetryConfig.DEFAULT_DELAY_RETRY;
            }

            @Override // androidx.camera.core.RetryPolicy
            public long getTimeoutInMillis() {
                return j;
            }
        });
    }

    @Override // androidx.camera.core.RetryPolicy
    @NonNull
    public RetryPolicy.RetryConfig onRetryDecisionRequested(@NonNull RetryPolicy.ExecutionState executionState) {
        return this.mDelegatePolicy.onRetryDecisionRequested(executionState);
    }

    @Override // androidx.camera.core.RetryPolicy
    public long getTimeoutInMillis() {
        return this.mDelegatePolicy.getTimeoutInMillis();
    }

    @Override // androidx.camera.core.impl.RetryPolicyInternal
    @NonNull
    public RetryPolicy copy(long j) {
        return new CameraProviderInitRetryPolicy(j);
    }

    public static final class Legacy implements RetryPolicyInternal {
        private final RetryPolicy mBasePolicy;

        public Legacy(long j) {
            this.mBasePolicy = new CameraProviderInitRetryPolicy(j);
        }

        @Override // androidx.camera.core.RetryPolicy
        @NonNull
        public RetryPolicy.RetryConfig onRetryDecisionRequested(@NonNull RetryPolicy.ExecutionState executionState) {
            if (!this.mBasePolicy.onRetryDecisionRequested(executionState).shouldRetry()) {
                Throwable cause = executionState.getCause();
                if (cause instanceof CameraValidator.CameraIdListIncorrectException) {
                    Logger.e("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                    if (((CameraValidator.CameraIdListIncorrectException) cause).getAvailableCameraCount() > 0) {
                        return RetryPolicy.RetryConfig.COMPLETE_WITHOUT_FAILURE;
                    }
                }
                return RetryPolicy.RetryConfig.NOT_RETRY;
            }
            return RetryPolicy.RetryConfig.DEFAULT_DELAY_RETRY;
        }

        @Override // androidx.camera.core.RetryPolicy
        public long getTimeoutInMillis() {
            return this.mBasePolicy.getTimeoutInMillis();
        }

        @Override // androidx.camera.core.impl.RetryPolicyInternal
        @NonNull
        public RetryPolicy copy(long j) {
            return new Legacy(j);
        }
    }
}
