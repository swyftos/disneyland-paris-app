package androidx.test.orchestrator.listeners;

import android.app.Instrumentation;
import androidx.test.orchestrator.junit.ParcelableDescription;
import androidx.test.orchestrator.junit.ParcelableFailure;
import androidx.test.orchestrator.junit.ParcelableResult;

/* loaded from: classes2.dex */
public abstract class OrchestrationRunListener {
    private Instrumentation instrumentation;

    public void orchestrationRunStarted(int i) {
    }

    public void testAssumptionFailure(ParcelableFailure parcelableFailure) {
    }

    public void testFailure(ParcelableFailure parcelableFailure) {
    }

    public void testFinished(ParcelableDescription parcelableDescription) {
    }

    public void testIgnored(ParcelableDescription parcelableDescription) {
    }

    public void testProcessFinished(String str) {
    }

    public void testRunFinished(ParcelableResult parcelableResult) {
    }

    public void testRunStarted(ParcelableDescription parcelableDescription) {
    }

    public void testStarted(ParcelableDescription parcelableDescription) {
    }

    public void setInstrumentation(Instrumentation instrumentation) {
        if (instrumentation == null) {
            throw new IllegalArgumentException("Instrumentation should not be null");
        }
        this.instrumentation = instrumentation;
    }

    public Instrumentation getInstrumentation() {
        return this.instrumentation;
    }
}
