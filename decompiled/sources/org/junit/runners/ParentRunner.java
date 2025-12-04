package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.Checks;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.RuleContainer;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.InvalidTestClassError;
import org.junit.runners.model.MemberValueConsumer;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.TestClassValidator;

/* loaded from: classes6.dex */
public abstract class ParentRunner<T> extends Runner implements Filterable, Orderable {
    private static final List VALIDATORS = Collections.singletonList(new AnnotationsValidator());
    private final Lock childrenLock = new ReentrantLock();
    private volatile List filteredChildren = null;
    private volatile RunnerScheduler scheduler = new RunnerScheduler() { // from class: org.junit.runners.ParentRunner.1
        @Override // org.junit.runners.model.RunnerScheduler
        public void finished() {
        }

        @Override // org.junit.runners.model.RunnerScheduler
        public void schedule(Runnable runnable) {
            runnable.run();
        }
    };
    private final TestClass testClass;

    protected abstract Description describeChild(T t);

    protected abstract List<T> getChildren();

    protected boolean isIgnored(T t) {
        return false;
    }

    protected abstract void runChild(T t, RunNotifier runNotifier);

    protected ParentRunner(Class<?> cls) throws InitializationError {
        this.testClass = createTestClass(cls);
        validate();
    }

    protected ParentRunner(TestClass testClass) throws InitializationError {
        this.testClass = (TestClass) Checks.notNull(testClass);
        validate();
    }

    @Deprecated
    protected TestClass createTestClass(Class<?> cls) {
        return new TestClass(cls);
    }

    protected void collectInitializationErrors(List<Throwable> list) {
        validatePublicVoidNoArgMethods(BeforeClass.class, true, list);
        validatePublicVoidNoArgMethods(AfterClass.class, true, list);
        validateClassRules(list);
        applyValidators(list);
    }

    private void applyValidators(List list) {
        if (getTestClass().getJavaClass() != null) {
            Iterator it = VALIDATORS.iterator();
            while (it.hasNext()) {
                list.addAll(((TestClassValidator) it.next()).validateTestClass(getTestClass()));
            }
        }
    }

    protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> cls, boolean z, List<Throwable> list) {
        Iterator<FrameworkMethod> it = getTestClass().getAnnotatedMethods(cls).iterator();
        while (it.hasNext()) {
            it.next().validatePublicVoidNoArg(z, list);
        }
    }

    private void validateClassRules(List list) {
        RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), list);
        RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    protected Statement classBlock(RunNotifier runNotifier) {
        Statement statementChildrenInvoker = childrenInvoker(runNotifier);
        return !areAllChildrenIgnored() ? withInterruptIsolation(withClassRules(withAfterClasses(withBeforeClasses(statementChildrenInvoker)))) : statementChildrenInvoker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean areAllChildrenIgnored() {
        Iterator it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            if (!isIgnored(it.next())) {
                return false;
            }
        }
        return true;
    }

    protected Statement withBeforeClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(BeforeClass.class);
        return annotatedMethods.isEmpty() ? statement : new RunBefores(statement, annotatedMethods, null);
    }

    protected Statement withAfterClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(AfterClass.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfters(statement, annotatedMethods, null);
    }

    private Statement withClassRules(Statement statement) throws IllegalArgumentException {
        List<TestRule> listClassRules = classRules();
        return listClassRules.isEmpty() ? statement : new RunRules(statement, listClassRules, getDescription());
    }

    protected List<TestRule> classRules() throws IllegalArgumentException {
        ClassRuleCollector classRuleCollector = new ClassRuleCollector();
        this.testClass.collectAnnotatedMethodValues(null, ClassRule.class, TestRule.class, classRuleCollector);
        this.testClass.collectAnnotatedFieldValues(null, ClassRule.class, TestRule.class, classRuleCollector);
        return classRuleCollector.getOrderedRules();
    }

    protected Statement childrenInvoker(final RunNotifier runNotifier) {
        return new Statement() { // from class: org.junit.runners.ParentRunner.2
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                ParentRunner.this.runChildren(runNotifier);
            }
        };
    }

    protected final Statement withInterruptIsolation(final Statement statement) {
        return new Statement() { // from class: org.junit.runners.ParentRunner.3
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                try {
                    statement.evaluate();
                } finally {
                    Thread.interrupted();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runChildren(final RunNotifier runNotifier) {
        RunnerScheduler runnerScheduler = this.scheduler;
        try {
            for (final Object obj : getFilteredChildren()) {
                runnerScheduler.schedule(new Runnable() { // from class: org.junit.runners.ParentRunner.4
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ParentRunner.this.runChild(obj, runNotifier);
                    }
                });
            }
        } finally {
            runnerScheduler.finished();
        }
    }

    protected String getName() {
        return this.testClass.getName();
    }

    public final TestClass getTestClass() {
        return this.testClass;
    }

    protected final void runLeaf(Statement statement, Description description, RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, description);
        eachTestNotifier.fireTestStarted();
        try {
            try {
                statement.evaluate();
            } catch (AssumptionViolatedException e) {
                eachTestNotifier.addFailedAssumption(e);
                eachTestNotifier.fireTestFinished();
            } catch (Throwable th) {
                eachTestNotifier.addFailure(th);
                eachTestNotifier.fireTestFinished();
            }
            eachTestNotifier.fireTestFinished();
        } catch (Throwable th2) {
            eachTestNotifier.fireTestFinished();
            throw th2;
        }
    }

    protected Annotation[] getRunnerAnnotations() {
        return this.testClass.getAnnotations();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description descriptionCreateSuiteDescription;
        Class<?> javaClass = getTestClass().getJavaClass();
        if (javaClass == null || !javaClass.getName().equals(getName())) {
            descriptionCreateSuiteDescription = Description.createSuiteDescription(getName(), getRunnerAnnotations());
        } else {
            descriptionCreateSuiteDescription = Description.createSuiteDescription(javaClass, getRunnerAnnotations());
        }
        Iterator it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            descriptionCreateSuiteDescription.addChild(describeChild(it.next()));
        }
        return descriptionCreateSuiteDescription;
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, getDescription());
        eachTestNotifier.fireTestSuiteStarted();
        try {
            try {
                try {
                    try {
                        classBlock(runNotifier).evaluate();
                    } catch (AssumptionViolatedException e) {
                        eachTestNotifier.addFailedAssumption(e);
                    }
                } catch (Throwable th) {
                    eachTestNotifier.addFailure(th);
                }
                eachTestNotifier.fireTestSuiteFinished();
            } catch (StoppedByUserException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            eachTestNotifier.fireTestSuiteFinished();
            throw th2;
        }
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        this.childrenLock.lock();
        try {
            ArrayList arrayList = new ArrayList(getFilteredChildren());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (shouldRun(filter, next)) {
                    try {
                        filter.apply(next);
                    } catch (NoTestsRemainException unused) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.filteredChildren = Collections.unmodifiableList(arrayList);
            if (this.filteredChildren.isEmpty()) {
                throw new NoTestsRemainException();
            }
        } finally {
            this.childrenLock.unlock();
        }
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        if (shouldNotReorder()) {
            return;
        }
        this.childrenLock.lock();
        try {
            Iterator it = getFilteredChildren().iterator();
            while (it.hasNext()) {
                sorter.apply(it.next());
            }
            ArrayList arrayList = new ArrayList(getFilteredChildren());
            Collections.sort(arrayList, comparator(sorter));
            this.filteredChildren = Collections.unmodifiableList(arrayList);
            this.childrenLock.unlock();
        } catch (Throwable th) {
            this.childrenLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.manipulation.Orderable
    public void order(Orderer orderer) throws InvalidOrderingException {
        if (shouldNotReorder()) {
            return;
        }
        this.childrenLock.lock();
        try {
            List filteredChildren = getFilteredChildren();
            LinkedHashMap linkedHashMap = new LinkedHashMap(filteredChildren.size());
            for (Object obj : filteredChildren) {
                Description descriptionDescribeChild = describeChild(obj);
                List arrayList = (List) linkedHashMap.get(descriptionDescribeChild);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    linkedHashMap.put(descriptionDescribeChild, arrayList);
                }
                arrayList.add(obj);
                orderer.apply(obj);
            }
            List<Description> listOrder = orderer.order(linkedHashMap.keySet());
            ArrayList arrayList2 = new ArrayList(filteredChildren.size());
            Iterator<Description> it = listOrder.iterator();
            while (it.hasNext()) {
                arrayList2.addAll((Collection) linkedHashMap.get(it.next()));
            }
            this.filteredChildren = Collections.unmodifiableList(arrayList2);
            this.childrenLock.unlock();
        } catch (Throwable th) {
            this.childrenLock.unlock();
            throw th;
        }
    }

    private boolean shouldNotReorder() {
        return getDescription().getAnnotation(FixMethodOrder.class) != null;
    }

    private void validate() throws InvalidTestClassError {
        ArrayList arrayList = new ArrayList();
        collectInitializationErrors(arrayList);
        if (!arrayList.isEmpty()) {
            throw new InvalidTestClassError(this.testClass.getJavaClass(), arrayList);
        }
    }

    private List getFilteredChildren() {
        if (this.filteredChildren == null) {
            this.childrenLock.lock();
            try {
                if (this.filteredChildren == null) {
                    this.filteredChildren = Collections.unmodifiableList(new ArrayList(getChildren()));
                }
            } finally {
                this.childrenLock.unlock();
            }
        }
        return this.filteredChildren;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean shouldRun(Filter filter, Object obj) {
        return filter.shouldRun(describeChild(obj));
    }

    private Comparator comparator(final Sorter sorter) {
        return new Comparator() { // from class: org.junit.runners.ParentRunner.5
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                return sorter.compare(ParentRunner.this.describeChild(obj), ParentRunner.this.describeChild(obj2));
            }
        };
    }

    public void setScheduler(RunnerScheduler runnerScheduler) {
        this.scheduler = runnerScheduler;
    }

    private static class ClassRuleCollector implements MemberValueConsumer {
        final List entries;

        private ClassRuleCollector() {
            this.entries = new ArrayList();
        }

        @Override // org.junit.runners.model.MemberValueConsumer
        public void accept(FrameworkMember frameworkMember, TestRule testRule) {
            ClassRule classRule = (ClassRule) frameworkMember.getAnnotation(ClassRule.class);
            this.entries.add(new RuleContainer.RuleEntry(testRule, 1, classRule != null ? Integer.valueOf(classRule.order()) : null));
        }

        public List getOrderedRules() {
            Collections.sort(this.entries, RuleContainer.ENTRY_COMPARATOR);
            ArrayList arrayList = new ArrayList(this.entries.size());
            Iterator it = this.entries.iterator();
            while (it.hasNext()) {
                arrayList.add((TestRule) ((RuleContainer.RuleEntry) it.next()).rule);
            }
            return arrayList;
        }
    }
}
