package com.swmansion.rnscreens.gamma.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, m1836d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/TabScreenFragment;", "Landroidx/fragment/app/Fragment;", "tabScreen", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;", "<init>", "(Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;)V", "getTabScreen$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onResume", "onPause", "onStop", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class TabScreenFragment extends Fragment {

    @NotNull
    private final TabScreen tabScreen;

    @NotNull
    /* JADX INFO: renamed from: getTabScreen$react_native_screens_release, reason: from getter */
    public final TabScreen getTabScreen() {
        return this.tabScreen;
    }

    public TabScreenFragment(@NotNull TabScreen tabScreen) {
        Intrinsics.checkNotNullParameter(tabScreen, "tabScreen");
        this.tabScreen = tabScreen;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return this.tabScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnWillAppear();
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnDidAppear();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnWillDisappear();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnDidDisappear();
        super.onStop();
    }
}
