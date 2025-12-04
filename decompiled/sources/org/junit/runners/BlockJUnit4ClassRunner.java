package org.junit.runners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.internal.runners.statements.Fail;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.MemberValueConsumer;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.PublicClassValidator;
import org.junit.validator.TestClassValidator;

/* loaded from: classes6.dex */
public class BlockJUnit4ClassRunner extends ParentRunner<FrameworkMethod> {
    private final ConcurrentMap methodDescriptions;
    private static TestClassValidator PUBLIC_CLASS_VALIDATOR = new PublicClassValidator();
    private static final ThreadLocal CURRENT_RULE_CONTAINER = new ThreadLocal();

    public BlockJUnit4ClassRunner(Class<?> cls) throws InitializationError {
        super(cls);
        this.methodDescriptions = new ConcurrentHashMap();
    }

    protected BlockJUnit4ClassRunner(TestClass testClass) throws InitializationError {
        super(testClass);
        this.methodDescriptions = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(final FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
        Description descriptionDescribeChild = describeChild(frameworkMethod);
        if (isIgnored(frameworkMethod)) {
            runNotifier.fireTestIgnored(descriptionDescribeChild);
        } else {
            runLeaf(new Statement() { // from class: org.junit.runners.BlockJUnit4ClassRunner.1
                @Override // org.junit.runners.model.Statement
                public void evaluate() throws Throwable {
                    BlockJUnit4ClassRunner.this.methodBlock(frameworkMethod).evaluate();
                }
            }, descriptionDescribeChild, runNotifier);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public boolean isIgnored(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getAnnotation(Ignore.class) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public Description describeChild(FrameworkMethod frameworkMethod) {
        Description description = (Description) this.methodDescriptions.get(frameworkMethod);
        if (description != null) {
            return description;
        }
        Description descriptionCreateTestDescription = Description.createTestDescription(getTestClass().getJavaClass(), testName(frameworkMethod), frameworkMethod.getAnnotations());
        this.methodDescriptions.putIfAbsent(frameworkMethod, descriptionCreateTestDescription);
        return descriptionCreateTestDescription;
    }

    @Override // org.junit.runners.ParentRunner
    protected List<FrameworkMethod> getChildren() {
        return computeTestMethods();
    }

    protected List<FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(Test.class);
    }

    @Override // org.junit.runners.ParentRunner
    protected void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        validatePublicConstructor(list);
        validateNoNonStaticInnerClass(list);
        validateConstructor(list);
        validateInstanceMethods(list);
        validateFields(list);
        validateMethods(list);
    }

    private void validatePublicConstructor(List list) {
        if (getTestClass().getJavaClass() != null) {
            list.addAll(PUBLIC_CLASS_VALIDATOR.validateTestClass(getTestClass()));
        }
    }

    protected void validateNoNonStaticInnerClass(List<Throwable> list) {
        if (getTestClass().isANonStaticInnerClass()) {
            list.add(new Exception("The inner class " + getTestClass().getName() + " is not static."));
        }
    }

    protected void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
        validateZeroArgConstructor(list);
    }

    protected void validateOnlyOneConstructor(List<Throwable> list) {
        if (hasOneConstructor()) {
            return;
        }
        list.add(new Exception("Test class should have exactly one public constructor"));
    }

    protected void validateZeroArgConstructor(List<Throwable> list) {
        if (getTestClass().isANonStaticInnerClass() || !hasOneConstructor() || getTestClass().getOnlyConstructor().getParameterTypes().length == 0) {
            return;
        }
        list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
    }

    private boolean hasOneConstructor() {
        return getTestClass().getJavaClass().getConstructors().length == 1;
    }

    @Deprecated
    protected void validateInstanceMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(After.class, false, list);
        validatePublicVoidNoArgMethods(Before.class, false, list);
        validateTestMethods(list);
        if (computeTestMethods().isEmpty()) {
            list.add(new Exception("No runnable methods"));
        }
    }

    protected void validateFields(List<Throwable> list) {
        RuleMemberValidator.RULE_VALIDATOR.validate(getTestClass(), list);
    }

    private void validateMethods(List list) {
        RuleMemberValidator.RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    protected void validateTestMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(Test.class, false, list);
    }

    protected Object createTest() throws Exception {
        return getTestClass().getOnlyConstructor().newInstance(new Object[0]);
    }

    protected Object createTest(FrameworkMethod frameworkMethod) throws Exception {
        return createTest();
    }

    protected String testName(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName();
    }

    protected Statement methodBlock(final FrameworkMethod frameworkMethod) {
        try {
            Object objRun = new ReflectiveCallable() { // from class: org.junit.runners.BlockJUnit4ClassRunner.2
                @Override // org.junit.internal.runners.model.ReflectiveCallable
                protected Object runReflectiveCall() {
                    return BlockJUnit4ClassRunner.this.createTest(frameworkMethod);
                }
            }.run();
            return withInterruptIsolation(withRules(frameworkMethod, objRun, withAfters(frameworkMethod, objRun, withBefores(frameworkMethod, objRun, withPotentialTimeout(frameworkMethod, objRun, possiblyExpectingExceptions(frameworkMethod, objRun, methodInvoker(frameworkMethod, objRun)))))));
        } catch (Throwable th) {
            return new Fail(th);
        }
    }

    protected Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
        return new InvokeMethod(frameworkMethod, obj);
    }

    protected Statement possiblyExpectingExceptions(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        Class expectedException = getExpectedException((Test) frameworkMethod.getAnnotation(Test.class));
        return expectedException != null ? new ExpectException(statement, expectedException) : statement;
    }

    @Deprecated
    protected Statement withPotentialTimeout(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        long timeout = getTimeout((Test) frameworkMethod.getAnnotation(Test.class));
        return timeout <= 0 ? statement : FailOnTimeout.builder().withTimeout(timeout, TimeUnit.MILLISECONDS).build(statement);
    }

    protected Statement withBefores(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Before.class);
        return annotatedMethods.isEmpty() ? statement : new RunBefores(statement, annotatedMethods, obj);
    }

    protected Statement withAfters(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(After.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfters(statement, annotatedMethods, obj);
    }

    private Statement withRules(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        RuleContainer ruleContainer = new RuleContainer();
        CURRENT_RULE_CONTAINER.set(ruleContainer);
        try {
            List<TestRule> testRules = getTestRules(obj);
            for (MethodRule methodRule : rules(obj)) {
                if (!(methodRule instanceof TestRule) || !testRules.contains(methodRule)) {
                    ruleContainer.add(methodRule);
                }
            }
            Iterator<TestRule> it = testRules.iterator();
            while (it.hasNext()) {
                ruleContainer.add(it.next());
            }
            CURRENT_RULE_CONTAINER.remove();
            return ruleContainer.apply(frameworkMethod, describeChild(frameworkMethod), obj, statement);
        } catch (Throwable th) {
            CURRENT_RULE_CONTAINER.remove();
            throw th;
        }
    }

    protected List<MethodRule> rules(Object obj) throws IllegalArgumentException {
        RuleCollector ruleCollector = new RuleCollector();
        getTestClass().collectAnnotatedMethodValues(obj, Rule.class, MethodRule.class, ruleCollector);
        getTestClass().collectAnnotatedFieldValues(obj, Rule.class, MethodRule.class, ruleCollector);
        return ruleCollector.result;
    }

    protected List<TestRule> getTestRules(Object obj) throws IllegalArgumentException {
        RuleCollector ruleCollector = new RuleCollector();
        getTestClass().collectAnnotatedMethodValues(obj, Rule.class, TestRule.class, ruleCollector);
        getTestClass().collectAnnotatedFieldValues(obj, Rule.class, TestRule.class, ruleCollector);
        return ruleCollector.result;
    }

    private Class getExpectedException(Test test) {
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    private long getTimeout(Test test) {
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }

    private static class RuleCollector implements MemberValueConsumer {
        final List result;

        private RuleCollector() {
            this.result = new ArrayList();
        }

        @Override // org.junit.runners.model.MemberValueConsumer
        public void accept(FrameworkMember frameworkMember, Object obj) {
            RuleContainer ruleContainer;
            Rule rule = (Rule) frameworkMember.getAnnotation(Rule.class);
            if (rule != null && (ruleContainer = (RuleContainer) BlockJUnit4ClassRunner.CURRENT_RULE_CONTAINER.get()) != null) {
                ruleContainer.setOrder(obj, rule.order());
            }
            this.result.add(obj);
        }
    }
}
