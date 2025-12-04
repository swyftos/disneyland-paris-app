package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InvalidTestClassError;
import org.junit.runners.model.TestClass;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

/* loaded from: classes6.dex */
public class Parameterized extends Suite {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AfterParam {
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BeforeParam {
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameter {
        int value() default 0;
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameters {
        String name() default "{index}";
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UseParametersRunnerFactory {
        Class<? extends ParametersRunnerFactory> value() default BlockJUnit4ClassRunnerWithParametersFactory.class;
    }

    public Parameterized(Class<?> cls) throws Throwable {
        this(cls, new RunnersFactory(cls));
    }

    private Parameterized(Class cls, RunnersFactory runnersFactory) throws InvalidTestClassError {
        super((Class<?>) cls, (List<Runner>) runnersFactory.createRunners());
        validateBeforeParamAndAfterParamMethods(Integer.valueOf(runnersFactory.parameterCount));
    }

    private void validateBeforeParamAndAfterParamMethods(Integer num) throws InvalidTestClassError {
        ArrayList arrayList = new ArrayList();
        validatePublicStaticVoidMethods(BeforeParam.class, num, arrayList);
        validatePublicStaticVoidMethods(AfterParam.class, num, arrayList);
        if (!arrayList.isEmpty()) {
            throw new InvalidTestClassError(getTestClass().getJavaClass(), arrayList);
        }
    }

    private void validatePublicStaticVoidMethods(Class cls, Integer num, List list) {
        int length;
        for (FrameworkMethod frameworkMethod : getTestClass().getAnnotatedMethods(cls)) {
            frameworkMethod.validatePublicVoid(true, list);
            if (num != null && (length = frameworkMethod.getMethod().getParameterTypes().length) != 0 && length != num.intValue()) {
                list.add(new Exception("Method " + frameworkMethod.getName() + "() should have 0 or " + num + " parameter(s)"));
            }
        }
    }

    private static class AssumptionViolationRunner extends Runner {
        private final Description description;
        private final AssumptionViolatedException exception;

        AssumptionViolationRunner(TestClass testClass, String str, AssumptionViolatedException assumptionViolatedException) {
            this.description = Description.createTestDescription(testClass.getJavaClass(), str + "() assumption violation");
            this.exception = assumptionViolatedException;
        }

        @Override // org.junit.runner.Runner, org.junit.runner.Describable
        public Description getDescription() {
            return this.description;
        }

        @Override // org.junit.runner.Runner
        public void run(RunNotifier runNotifier) {
            runNotifier.fireTestAssumptionFailed(new Failure(this.description, this.exception));
        }
    }

    private static class RunnersFactory {
        private static final ParametersRunnerFactory DEFAULT_FACTORY = new BlockJUnit4ClassRunnerWithParametersFactory();
        private final List allParameters;
        private final int parameterCount;
        private final FrameworkMethod parametersMethod;
        private final Runner runnerOverride;
        private final TestClass testClass;

        private RunnersFactory(Class cls) throws Exception {
            List listAllParameters;
            AssumptionViolationRunner assumptionViolationRunner;
            TestClass testClass = new TestClass(cls);
            this.testClass = testClass;
            FrameworkMethod parametersMethod = getParametersMethod(testClass);
            this.parametersMethod = parametersMethod;
            try {
                listAllParameters = allParameters(testClass, parametersMethod);
                assumptionViolationRunner = null;
            } catch (AssumptionViolatedException e) {
                List listEmptyList = Collections.emptyList();
                AssumptionViolationRunner assumptionViolationRunner2 = new AssumptionViolationRunner(this.testClass, this.parametersMethod.getName(), e);
                listAllParameters = listEmptyList;
                assumptionViolationRunner = assumptionViolationRunner2;
            }
            this.allParameters = listAllParameters;
            this.runnerOverride = assumptionViolationRunner;
            this.parameterCount = listAllParameters.isEmpty() ? 0 : normalizeParameters(listAllParameters.get(0)).length;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List createRunners() {
            Runner runner = this.runnerOverride;
            if (runner != null) {
                return Collections.singletonList(runner);
            }
            return Collections.unmodifiableList(createRunnersForParameters(this.allParameters, ((Parameters) this.parametersMethod.getAnnotation(Parameters.class)).name(), getParametersRunnerFactory()));
        }

        private ParametersRunnerFactory getParametersRunnerFactory() {
            UseParametersRunnerFactory useParametersRunnerFactory = (UseParametersRunnerFactory) this.testClass.getAnnotation(UseParametersRunnerFactory.class);
            if (useParametersRunnerFactory == null) {
                return DEFAULT_FACTORY;
            }
            return useParametersRunnerFactory.value().newInstance();
        }

        private TestWithParameters createTestWithNotNormalizedParameters(String str, int i, Object obj) {
            return createTestWithParameters(this.testClass, str, i, normalizeParameters(obj));
        }

        private static Object[] normalizeParameters(Object obj) {
            return obj instanceof Object[] ? (Object[]) obj : new Object[]{obj};
        }

        private static List allParameters(TestClass testClass, FrameworkMethod frameworkMethod) throws Exception {
            Object objInvokeExplosively = frameworkMethod.invokeExplosively(null, new Object[0]);
            if (objInvokeExplosively instanceof List) {
                return (List) objInvokeExplosively;
            }
            if (objInvokeExplosively instanceof Collection) {
                return new ArrayList((Collection) objInvokeExplosively);
            }
            if (objInvokeExplosively instanceof Iterable) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((Iterable) objInvokeExplosively).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                return arrayList;
            }
            if (objInvokeExplosively instanceof Object[]) {
                return Arrays.asList((Object[]) objInvokeExplosively);
            }
            throw parametersMethodReturnedWrongType(testClass, frameworkMethod);
        }

        private static FrameworkMethod getParametersMethod(TestClass testClass) throws Exception {
            for (FrameworkMethod frameworkMethod : testClass.getAnnotatedMethods(Parameters.class)) {
                if (frameworkMethod.isStatic() && frameworkMethod.isPublic()) {
                    return frameworkMethod;
                }
            }
            throw new Exception("No public static parameters method on class " + testClass.getName());
        }

        private List createRunnersForParameters(Iterable iterable, String str, ParametersRunnerFactory parametersRunnerFactory) throws Exception {
            try {
                List listCreateTestsForParameters = createTestsForParameters(iterable, str);
                ArrayList arrayList = new ArrayList();
                Iterator it = listCreateTestsForParameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(parametersRunnerFactory.createRunnerForTestWithParameters((TestWithParameters) it.next()));
                }
                return arrayList;
            } catch (ClassCastException unused) {
                throw parametersMethodReturnedWrongType(this.testClass, this.parametersMethod);
            }
        }

        private List createTestsForParameters(Iterable iterable, String str) {
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            int i = 0;
            while (it.hasNext()) {
                arrayList.add(createTestWithNotNormalizedParameters(str, i, it.next()));
                i++;
            }
            return arrayList;
        }

        private static Exception parametersMethodReturnedWrongType(TestClass testClass, FrameworkMethod frameworkMethod) {
            return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", testClass.getName(), frameworkMethod.getName()));
        }

        private TestWithParameters createTestWithParameters(TestClass testClass, String str, int i, Object[] objArr) {
            return new TestWithParameters("[" + MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i)), objArr) + "]", testClass, Arrays.asList(objArr));
        }
    }
}
