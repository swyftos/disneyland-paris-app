package androidx.test.espresso;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.action.ScrollToAction;
import androidx.test.espresso.base.InterruptableUiController;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFutureTask;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.Bindable;
import androidx.test.espresso.remote.IInteractionExecutionStatus;
import androidx.test.espresso.remote.RemoteInteraction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.internal.platform.os.ControlledLooper;
import androidx.test.internal.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* loaded from: classes2.dex */
public final class ViewInteraction {
    private static final String TAG = "ViewInteraction";
    private final ControlledLooper controlledLooper;
    private volatile FailureHandler failureHandler;
    private boolean hasRootMatcher = false;
    private final Executor mainThreadExecutor;
    private final AtomicReference needsActivity;
    private final ListeningExecutorService remoteExecutor;
    private final RemoteInteraction remoteInteraction;
    private final AtomicReference rootMatcherRef;
    private final InterruptableUiController uiController;
    private final ViewFinder viewFinder;
    private final Matcher viewMatcher;

    private static final class SingleExecutionViewAction implements ViewAction, Bindable {
        private IInteractionExecutionStatus actionExecutionStatus;
        final ViewAction viewAction;
        final Matcher viewMatcher;

        private SingleExecutionViewAction(ViewAction viewAction, Matcher matcher) {
            this.actionExecutionStatus = new IInteractionExecutionStatus.Stub(this) { // from class: androidx.test.espresso.ViewInteraction.SingleExecutionViewAction.1
                AtomicBoolean run = new AtomicBoolean(true);

                @Override // androidx.test.espresso.remote.IInteractionExecutionStatus
                public boolean canExecute() {
                    return this.run.getAndSet(false);
                }
            };
            this.viewAction = viewAction;
            this.viewMatcher = matcher;
        }

        @Override // androidx.test.espresso.ViewAction
        public Matcher getConstraints() {
            return this.viewAction.getConstraints();
        }

        @Override // androidx.test.espresso.ViewAction
        public String getDescription() {
            return this.viewAction.getDescription();
        }

        @Override // androidx.test.espresso.remote.Bindable
        public IBinder getIBinder() {
            return this.actionExecutionStatus.asBinder();
        }

        @Override // androidx.test.espresso.remote.Bindable
        public String getId() {
            return RemoteInteraction.BUNDLE_EXECUTION_STATUS;
        }

        ViewAction getInnerViewAction() {
            return this.viewAction;
        }

        @Override // androidx.test.espresso.ViewAction
        public void perform(UiController uiController, View view) {
            try {
                if (this.actionExecutionStatus.canExecute()) {
                    this.viewAction.perform(uiController, view);
                    return;
                }
                String str = ViewInteraction.TAG;
                String strValueOf = String.valueOf(this.viewAction);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 63);
                sb.append("Attempted to execute a Single Execution Action more then once: ");
                sb.append(strValueOf);
                LogUtil.logDebugWithProcess(str, sb.toString(), new Object[0]);
            } catch (RemoteException e) {
                throw new PerformException.Builder().withActionDescription(this.viewAction.getDescription()).withViewDescription(this.viewMatcher.toString()).withCause(new RuntimeException("Unable to query interaction execution status", e.getCause())).build();
            }
        }

        @Override // androidx.test.espresso.remote.Bindable
        public void setIBinder(IBinder iBinder) {
            this.actionExecutionStatus = IInteractionExecutionStatus.Stub.asInterface(iBinder);
        }
    }

    private static final class SingleExecutionViewAssertion implements ViewAssertion, Bindable {
        private IInteractionExecutionStatus assertionExecutionStatus;
        final ViewAssertion viewAssertion;

        private SingleExecutionViewAssertion(ViewAssertion viewAssertion) {
            this.assertionExecutionStatus = new IInteractionExecutionStatus.Stub(this) { // from class: androidx.test.espresso.ViewInteraction.SingleExecutionViewAssertion.1
                AtomicBoolean run = new AtomicBoolean(true);

                @Override // androidx.test.espresso.remote.IInteractionExecutionStatus
                public boolean canExecute() {
                    return this.run.getAndSet(false);
                }
            };
            this.viewAssertion = viewAssertion;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noMatchingViewException) {
            try {
                if (this.assertionExecutionStatus.canExecute()) {
                    this.viewAssertion.check(view, noMatchingViewException);
                    return;
                }
                String str = ViewInteraction.TAG;
                String strValueOf = String.valueOf(this.viewAssertion);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 66);
                sb.append("Attempted to execute a Single Execution Assertion more then once: ");
                sb.append(strValueOf);
                LogUtil.logDebugWithProcess(str, sb.toString(), new Object[0]);
            } catch (RemoteException e) {
                throw new RuntimeException("Unable to query interaction execution status", e.getCause());
            }
        }

        @Override // androidx.test.espresso.remote.Bindable
        public IBinder getIBinder() {
            return this.assertionExecutionStatus.asBinder();
        }

        @Override // androidx.test.espresso.remote.Bindable
        public String getId() {
            return RemoteInteraction.BUNDLE_EXECUTION_STATUS;
        }

        @Override // androidx.test.espresso.remote.Bindable
        public void setIBinder(IBinder iBinder) {
            this.assertionExecutionStatus = IInteractionExecutionStatus.Stub.asInterface(iBinder);
        }
    }

    ViewInteraction(UiController uiController, ViewFinder viewFinder, Executor executor, FailureHandler failureHandler, Matcher matcher, AtomicReference atomicReference, AtomicReference atomicReference2, RemoteInteraction remoteInteraction, ListeningExecutorService listeningExecutorService, ControlledLooper controlledLooper) {
        this.viewFinder = (ViewFinder) Preconditions.checkNotNull(viewFinder);
        this.uiController = (InterruptableUiController) Preconditions.checkNotNull(uiController);
        this.failureHandler = (FailureHandler) Preconditions.checkNotNull(failureHandler);
        this.mainThreadExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.viewMatcher = (Matcher) Preconditions.checkNotNull(matcher);
        this.rootMatcherRef = (AtomicReference) Preconditions.checkNotNull(atomicReference);
        this.needsActivity = (AtomicReference) Preconditions.checkNotNull(atomicReference2);
        this.remoteInteraction = (RemoteInteraction) Preconditions.checkNotNull(remoteInteraction);
        this.remoteExecutor = (ListeningExecutorService) Preconditions.checkNotNull(listeningExecutorService);
        this.controlledLooper = (ControlledLooper) Preconditions.checkNotNull(controlledLooper);
    }

    private void desugaredPerform(final SingleExecutionViewAction singleExecutionViewAction) {
        Callable<Void> callable = new Callable<Void>() { // from class: androidx.test.espresso.ViewInteraction.1
            @Override // java.util.concurrent.Callable
            public Void call() throws NoMatchingViewException, AmbiguousViewMatcherException {
                ViewInteraction.this.doPerform(singleExecutionViewAction);
                return null;
            }
        };
        ViewAction innerViewAction = singleExecutionViewAction.getInnerViewAction();
        ArrayList arrayList = new ArrayList();
        arrayList.add(postAsynchronouslyOnUiThread(callable));
        if (!this.remoteInteraction.isRemoteProcess()) {
            arrayList.add(this.remoteExecutor.submit((Callable) this.remoteInteraction.createRemotePerformCallable((Matcher) this.rootMatcherRef.get(), this.viewMatcher, getIBindersFromViewActions(singleExecutionViewAction, innerViewAction), innerViewAction)));
        }
        waitForAndHandleInteractionResults(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPerform(SingleExecutionViewAction singleExecutionViewAction) throws NoMatchingViewException, AmbiguousViewMatcherException {
        Preconditions.checkNotNull(singleExecutionViewAction);
        Matcher matcher = (Matcher) Preconditions.checkNotNull(singleExecutionViewAction.getConstraints());
        this.uiController.loopMainThreadUntilIdle();
        View view = this.viewFinder.getView();
        Log.i(TAG, String.format(Locale.ROOT, "Performing '%s' action on view %s", singleExecutionViewAction.getDescription(), this.viewMatcher));
        if (matcher.matches(view)) {
            singleExecutionViewAction.perform(this.uiController, view);
            return;
        }
        StringDescription stringDescription = new StringDescription(new StringBuilder("Action will not be performed because the target view does not match one or more of the following constraints:\n"));
        matcher.describeTo(stringDescription);
        stringDescription.appendText("\nTarget view: ").appendValue(HumanReadables.describe(view));
        if ((singleExecutionViewAction.getInnerViewAction() instanceof ScrollToAction) && ViewMatchers.isDescendantOfA(ViewMatchers.isAssignableFrom(AdapterView.class)).matches(view)) {
            stringDescription.appendText("\nFurther Info: ScrollToAction on a view inside an AdapterView will not work. Use Espresso.onData to load the view.");
        }
        throw new PerformException.Builder().withActionDescription(singleExecutionViewAction.getDescription()).withViewDescription(this.viewMatcher.toString()).withCause(new RuntimeException(stringDescription.toString())).build();
    }

    private static List getBindables(Object... objArr) {
        ArrayList arrayListNewArrayListWithCapacity = Lists.newArrayListWithCapacity(objArr.length);
        for (Object obj : objArr) {
            if (obj instanceof Bindable) {
                arrayListNewArrayListWithCapacity.add((Bindable) obj);
            }
        }
        return arrayListNewArrayListWithCapacity;
    }

    private static Map getIBindersFromBindables(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Bindable bindable = (Bindable) it.next();
            map.put((String) Preconditions.checkNotNull(bindable.getId(), "Bindable id cannot be null!"), (IBinder) Preconditions.checkNotNull(bindable.getIBinder(), "Bindable binder cannot be null!"));
        }
        return ImmutableMap.copyOf((Map) map);
    }

    private static Map getIBindersFromViewActions(ViewAction... viewActionArr) {
        return getIBindersFromBindables(getBindables(viewActionArr));
    }

    private static Map getIBindersFromViewAssertions(ViewAssertion... viewAssertionArr) {
        return getIBindersFromBindables(getBindables(viewAssertionArr));
    }

    private ListenableFuture postAsynchronouslyOnUiThread(Callable callable) {
        ListenableFutureTask listenableFutureTaskCreate = ListenableFutureTask.create(callable);
        this.mainThreadExecutor.execute(listenableFutureTaskCreate);
        return listenableFutureTaskCreate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.test.espresso.base.InterruptableUiController] */
    private void waitForAndHandleInteractionResults(List list) {
        try {
            try {
                this.controlledLooper.drainMainThreadUntilIdle();
                InteractionResultsHandler.gatherAnyResult(list);
            } catch (Error e) {
                this.failureHandler.handle(e, this.viewMatcher);
            } catch (RuntimeException e2) {
                this.failureHandler.handle(e2, this.viewMatcher);
            }
        } finally {
            this.uiController.interruptEspressoTasks();
        }
    }

    public ViewInteraction check(final ViewAssertion viewAssertion) {
        Preconditions.checkNotNull(viewAssertion);
        final SingleExecutionViewAssertion singleExecutionViewAssertion = new SingleExecutionViewAssertion(viewAssertion);
        Callable<Void> callable = new Callable<Void>() { // from class: androidx.test.espresso.ViewInteraction.2
            @Override // java.util.concurrent.Callable
            public Void call() throws AmbiguousViewMatcherException {
                NoMatchingViewException noMatchingViewException;
                View view;
                ViewInteraction.this.uiController.loopMainThreadUntilIdle();
                try {
                    view = ViewInteraction.this.viewFinder.getView();
                    noMatchingViewException = null;
                } catch (NoMatchingViewException e) {
                    noMatchingViewException = e;
                    view = null;
                }
                Log.i(ViewInteraction.TAG, String.format(Locale.ROOT, "Checking '%s' assertion on view %s", viewAssertion, ViewInteraction.this.viewMatcher));
                singleExecutionViewAssertion.check(view, noMatchingViewException);
                return null;
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(postAsynchronouslyOnUiThread(callable));
        if (!this.remoteInteraction.isRemoteProcess()) {
            arrayList.add(this.remoteExecutor.submit((Callable) this.remoteInteraction.createRemoteCheckCallable((Matcher) this.rootMatcherRef.get(), this.viewMatcher, getIBindersFromViewAssertions(singleExecutionViewAssertion, viewAssertion), viewAssertion)));
        }
        waitForAndHandleInteractionResults(arrayList);
        return this;
    }

    public ViewInteraction inRoot(Matcher<Root> matcher) {
        this.hasRootMatcher = true;
        this.rootMatcherRef.set((Matcher) Preconditions.checkNotNull(matcher));
        return this;
    }

    public ViewInteraction noActivity() {
        if (!this.hasRootMatcher) {
            this.rootMatcherRef.set(Matchers.anyOf(RootMatchers.DEFAULT, Matchers.allOf(RootMatchers.hasWindowLayoutParams(), RootMatchers.isSystemAlertWindow())));
        }
        this.needsActivity.set(Boolean.FALSE);
        return this;
    }

    public ViewInteraction perform(ViewAction... viewActionArr) {
        Preconditions.checkNotNull(viewActionArr);
        for (ViewAction viewAction : viewActionArr) {
            desugaredPerform(new SingleExecutionViewAction(viewAction, this.viewMatcher));
        }
        return this;
    }

    public ViewInteraction withFailureHandler(FailureHandler failureHandler) {
        this.failureHandler = (FailureHandler) Preconditions.checkNotNull(failureHandler);
        return this;
    }
}
