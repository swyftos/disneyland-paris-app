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
public interface RemoteInteraction {
    public static final String BUNDLE_EXECUTION_STATUS = "executionStatus";

    Callable<Void> createRemoteCheckCallable(Matcher<Root> matcher, Matcher<View> matcher2, Map<String, IBinder> map, ViewAssertion viewAssertion);

    Callable<Void> createRemotePerformCallable(Matcher<Root> matcher, Matcher<View> matcher2, Map<String, IBinder> map, ViewAction... viewActionArr);

    boolean isRemoteProcess();
}
