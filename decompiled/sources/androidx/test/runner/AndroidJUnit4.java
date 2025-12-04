package androidx.test.runner;

import android.util.Log;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.InvocationTargetException;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

@Deprecated
/* loaded from: classes2.dex */
public final class AndroidJUnit4 extends Runner implements Filterable, Sortable {
    private final Runner delegate;

    public AndroidJUnit4(Class<?> cls, AndroidRunnerParams androidRunnerParams) throws InitializationError {
        this.delegate = new AndroidJUnit4ClassRunner(cls, androidRunnerParams);
    }

    public AndroidJUnit4(Class<?> cls) throws InitializationError {
        this.delegate = loadRunner(cls);
    }

    private static Runner loadRunner(Class cls) {
        return loadRunner(cls, System.getProperty("android.junit.runner", "org.robolectric.RobolectricTestRunner"));
    }

    private static Runner loadRunner(Class cls, String str) throws InitializationError {
        try {
            return (Runner) Class.forName(str).getConstructor(Class.class).newInstance(cls);
        } catch (ClassNotFoundException e) {
            Log.e("AndroidJUnit4", String.valueOf(str).concat(" could not be loaded"), e);
            throw new InitializationError(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", str));
        } catch (IllegalAccessException e2) {
            Log.e("AndroidJUnit4", String.valueOf(str).concat(" could not be loaded"), e2);
            throw new InitializationError(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", str));
        } catch (InstantiationException e3) {
            Log.e("AndroidJUnit4", String.valueOf(str).concat(" could not be loaded"), e3);
            throw new InitializationError(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", str));
        } catch (NoSuchMethodException e4) {
            Log.e("AndroidJUnit4", String.valueOf(str).concat(" could not be loaded"), e4);
            throw new InitializationError(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", str));
        } catch (InvocationTargetException e5) {
            Log.e("AndroidJUnit4", String.valueOf(str).concat(" could not be loaded"), e5);
            throw new InitializationError(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", str));
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return this.delegate.getDescription();
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        this.delegate.run(runNotifier);
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        ((Filterable) this.delegate).filter(filter);
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        ((Sortable) this.delegate).sort(sorter);
    }
}
