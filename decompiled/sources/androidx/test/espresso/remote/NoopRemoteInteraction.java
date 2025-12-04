package androidx.test.espresso.remote;

import android.os.IBinder;
import android.view.View;
import androidx.test.espresso.Root;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import java.util.Map;
import java.util.concurrent.Callable;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public class NoopRemoteInteraction implements RemoteInteraction {
    @Override // androidx.test.espresso.remote.RemoteInteraction
    public Callable<Void> createRemoteCheckCallable(Matcher<Root> matcher, Matcher<View> matcher2, Map<String, IBinder> map, ViewAssertion viewAssertion) {
        return new Callable<Void>(this) { // from class: androidx.test.espresso.remote.NoopRemoteInteraction.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                throw new NoRemoteEspressoInstanceException("No remote instances available");
            }
        };
    }

    @Override // androidx.test.espresso.remote.RemoteInteraction
    public Callable<Void> createRemotePerformCallable(Matcher<Root> matcher, Matcher<View> matcher2, Map<String, IBinder> map, ViewAction... viewActionArr) {
        return new Callable<Void>(this) { // from class: androidx.test.espresso.remote.NoopRemoteInteraction.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                throw new NoRemoteEspressoInstanceException("No remote instances available");
            }
        };
    }

    @Override // androidx.test.espresso.remote.RemoteInteraction
    public boolean isRemoteProcess() {
        return false;
    }
}
