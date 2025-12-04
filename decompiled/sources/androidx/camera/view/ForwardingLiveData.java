package androidx.camera.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* loaded from: classes.dex */
final class ForwardingLiveData extends MediatorLiveData {
    private LiveData mLiveDataSource;

    ForwardingLiveData() {
    }

    void setSource(LiveData liveData) {
        LiveData liveData2 = this.mLiveDataSource;
        if (liveData2 != null) {
            super.removeSource(liveData2);
        }
        this.mLiveDataSource = liveData;
        super.addSource(liveData, new Observer() { // from class: androidx.camera.view.ForwardingLiveData$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.setValue(obj);
            }
        });
    }

    @Override // androidx.lifecycle.LiveData
    public Object getValue() {
        LiveData liveData = this.mLiveDataSource;
        if (liveData == null) {
            return null;
        }
        return liveData.getValue();
    }
}
