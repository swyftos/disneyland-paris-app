package com.amazonaws.mobileconnectors.p016s3.transfermanager.internal;

import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.p016s3.transfermanager.TransferProgress;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MultipleFileTransfer<T extends Transfer> extends AbstractTransfer {
    private AtomicBoolean subTransferStarted;
    protected final Collection<? extends T> subTransfers;

    MultipleFileTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, Collection collection) {
        super(str, transferProgress, progressListenerChain);
        this.subTransferStarted = new AtomicBoolean(false);
        this.subTransfers = collection;
    }

    public void collateFinalState() {
        boolean z = false;
        for (T t : this.subTransfers) {
            Transfer.TransferState state = t.getState();
            Transfer.TransferState transferState = Transfer.TransferState.Failed;
            if (state == transferState) {
                setState(transferState);
                return;
            } else if (t.getState() == Transfer.TransferState.Canceled) {
                z = true;
            }
        }
        if (z) {
            setState(Transfer.TransferState.Canceled);
        } else {
            setState(Transfer.TransferState.Completed);
        }
    }

    @Override // com.amazonaws.mobileconnectors.p016s3.transfermanager.internal.AbstractTransfer
    public void setState(Transfer.TransferState transferState) {
        super.setState(transferState);
        int i = C19951.f352x1ed3aa65[transferState.ordinal()];
        if (i == 1) {
            fireProgressEvent(1);
            return;
        }
        if (i == 2) {
            if (this.subTransferStarted.compareAndSet(false, true)) {
                fireProgressEvent(2);
            }
        } else if (i == 3) {
            fireProgressEvent(4);
        } else if (i == 4) {
            fireProgressEvent(16);
        } else {
            if (i != 5) {
                return;
            }
            fireProgressEvent(8);
        }
    }

    /* JADX INFO: renamed from: com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileTransfer$1 */
    static /* synthetic */ class C19951 {

        /* JADX INFO: renamed from: $SwitchMap$com$amazonaws$mobileconnectors$s3$transfermanager$Transfer$TransferState */
        static final /* synthetic */ int[] f352x1ed3aa65;

        static {
            int[] iArr = new int[Transfer.TransferState.values().length];
            f352x1ed3aa65 = iArr;
            try {
                iArr[Transfer.TransferState.Waiting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f352x1ed3aa65[Transfer.TransferState.InProgress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f352x1ed3aa65[Transfer.TransferState.Completed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f352x1ed3aa65[Transfer.TransferState.Canceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f352x1ed3aa65[Transfer.TransferState.Failed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
