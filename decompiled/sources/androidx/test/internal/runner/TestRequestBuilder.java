package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;
import androidx.test.filters.Suppress;
import androidx.test.internal.runner.ClassPathScanner;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.filters.ParentFilter;
import androidx.test.internal.runner.filters.TestsRegExFilter;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.internal.util.Checks;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes2.dex */
public class TestRequestBuilder {
    private static final String[] DEFAULT_EXCLUDED_PACKAGES = {"junit", "org.junit", "org.hamcrest", "org.mockito", "androidx.test.internal.runner.junit3", "org.jacoco", "net.bytebuddy"};
    private final Bundle argsBundle;
    private ClassLoader classLoader;
    private ClassAndMethodFilter classMethodFilter;
    private List customRunnerBuilderClasses;
    private final DeviceBuild deviceBuild;
    private Set excludedClasses;
    private Set excludedPackages;
    private Filter filter;
    private boolean ignoreSuiteMethods;
    private Set includedClasses;
    private Set includedPackages;
    private final Instrumentation instr;
    private final List pathsToScan;
    private long perTestTimeout;
    private boolean skipExecution;
    private final TestsRegExFilter testsRegExFilter;

    interface DeviceBuild {
        String getCodeName();

        String getHardware();

        int getSdkVersionInt();
    }

    private static class DeviceBuildImpl implements DeviceBuild {
        private DeviceBuildImpl() {
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.DeviceBuild
        public int getSdkVersionInt() {
            return Build.VERSION.SDK_INT;
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.DeviceBuild
        public String getHardware() {
            return Build.HARDWARE;
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.DeviceBuild
        public String getCodeName() {
            return Build.VERSION.CODENAME;
        }
    }

    private static class AnnotationInclusionFilter extends ParentFilter {
        private final Class annotationClass;

        AnnotationInclusionFilter(Class cls) {
            this.annotationClass = cls;
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean evaluateTest(Description description) {
            Class<?> testClass = description.getTestClass();
            return description.getAnnotation(this.annotationClass) != null || (testClass != null && testClass.isAnnotationPresent(this.annotationClass));
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return String.format("annotation %s", this.annotationClass.getName());
        }
    }

    private static class SizeFilter extends ParentFilter {
        private final TestSize testSize;

        SizeFilter(TestSize testSize) {
            this.testSize = testSize;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return "";
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean evaluateTest(Description description) {
            if (this.testSize.testMethodIsAnnotatedWithTestSize(description)) {
                return true;
            }
            if (!this.testSize.testClassIsAnnotatedWithTestSize(description)) {
                return false;
            }
            Iterator<Annotation> it = description.getAnnotations().iterator();
            while (it.hasNext()) {
                if (TestSize.isAnyTestSize(it.next().annotationType())) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class AnnotationExclusionFilter extends ParentFilter {
        private final Class annotationClass;

        AnnotationExclusionFilter(Class cls) {
            this.annotationClass = cls;
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean evaluateTest(Description description) {
            Class<?> testClass = description.getTestClass();
            return (testClass == null || !testClass.isAnnotationPresent(this.annotationClass)) && description.getAnnotation(this.annotationClass) == null;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return String.format("not annotation %s", this.annotationClass.getName());
        }
    }

    private static class ExtendedSuite extends Suite {
        static Suite createSuite(List list) {
            try {
                return new ExtendedSuite(list);
            } catch (InitializationError unused) {
                String name = Suite.class.getName();
                StringBuilder sb = new StringBuilder(name.length() + PublicKeyAlgorithmTags.EXPERIMENTAL_8);
                sb.append("Internal Error: ");
                sb.append(name);
                sb.append("(Class<?>, List<Runner>) should never throw an InitializationError when passed a null Class");
                throw new RuntimeException(sb.toString());
            }
        }

        ExtendedSuite(List list) {
            super((Class<?>) null, (List<Runner>) list);
        }
    }

    private class SdkSuppressFilter extends ParentFilter {
        private SdkSuppressFilter() {
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean evaluateTest(Description description) {
            SdkSuppress annotationForTest = getAnnotationForTest(description);
            if (annotationForTest != null) {
                return (TestRequestBuilder.this.getDeviceSdkInt() >= annotationForTest.minSdkVersion() && TestRequestBuilder.this.getDeviceSdkInt() <= annotationForTest.maxSdkVersion()) || TestRequestBuilder.this.getDeviceCodeName().equals(annotationForTest.codeName());
            }
            return true;
        }

        private SdkSuppress getAnnotationForTest(Description description) {
            SdkSuppress sdkSuppress = (SdkSuppress) description.getAnnotation(SdkSuppress.class);
            if (sdkSuppress != null) {
                return sdkSuppress;
            }
            Class<?> testClass = description.getTestClass();
            if (testClass != null) {
                return (SdkSuppress) testClass.getAnnotation(SdkSuppress.class);
            }
            return null;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return String.format("skip tests annotated with SdkSuppress if necessary", new Object[0]);
        }
    }

    @VisibleForTesting
    class RequiresDeviceFilter extends AnnotationExclusionFilter {
        private final Set emulatorHardwareNames;

        RequiresDeviceFilter() {
            super(RequiresDevice.class);
            this.emulatorHardwareNames = new HashSet(Arrays.asList("goldfish", "ranchu", "gce_x86"));
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.AnnotationExclusionFilter, androidx.test.internal.runner.filters.ParentFilter
        protected boolean evaluateTest(Description description) {
            if (super.evaluateTest(description)) {
                return true;
            }
            return !this.emulatorHardwareNames.contains(TestRequestBuilder.this.getDeviceHardware());
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.AnnotationExclusionFilter, org.junit.runner.manipulation.Filter
        public String describe() {
            return String.format("skip tests annotated with RequiresDevice if necessary", new Object[0]);
        }
    }

    private static class ShardingFilter extends Filter {
        private final int numShards;
        private final int shardIndex;

        ShardingFilter(int i, int i2) {
            this.numShards = i;
            this.shardIndex = i2;
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(Description description) {
            return !description.isTest() || Math.abs(description.hashCode()) % this.numShards == this.shardIndex;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return String.format("Shard %s of %s shards", Integer.valueOf(this.shardIndex), Integer.valueOf(this.numShards));
        }
    }

    private static class LenientFilterRequest extends Request {
        private final Filter filter;
        private final Request request;

        public LenientFilterRequest(Request request, Filter filter) {
            this.request = request;
            this.filter = filter;
        }

        @Override // org.junit.runner.Request
        public Runner getRunner() {
            try {
                Runner runner = this.request.getRunner();
                this.filter.apply(runner);
                return runner;
            } catch (NoTestsRemainException unused) {
                return new BlankRunner();
            }
        }
    }

    private static class BlankRunner extends Runner {
        @Override // org.junit.runner.Runner
        public void run(RunNotifier runNotifier) {
        }

        private BlankRunner() {
        }

        @Override // org.junit.runner.Runner, org.junit.runner.Describable
        public Description getDescription() {
            return Description.createSuiteDescription("no tests found", new Annotation[0]);
        }
    }

    private static class ClassAndMethodFilter extends ParentFilter {
        private Map methodFilters;

        private ClassAndMethodFilter() {
            this.methodFilters = new HashMap();
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        public boolean evaluateTest(Description description) {
            if (this.methodFilters.isEmpty()) {
                return true;
            }
            MethodFilter methodFilter = (MethodFilter) this.methodFilters.get(description.getClassName());
            if (methodFilter != null) {
                return methodFilter.shouldRun(description);
            }
            return true;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return "Class and method filter";
        }

        public void addMethod(String str, String str2) {
            MethodFilter methodFilter = (MethodFilter) this.methodFilters.get(str);
            if (methodFilter == null) {
                methodFilter = new MethodFilter(str);
                this.methodFilters.put(str, methodFilter);
            }
            methodFilter.addInclusionMethod(str2);
        }

        public void removeMethod(String str, String str2) {
            MethodFilter methodFilter = (MethodFilter) this.methodFilters.get(str);
            if (methodFilter == null) {
                methodFilter = new MethodFilter(str);
                this.methodFilters.put(str, methodFilter);
            }
            methodFilter.addExclusionMethod(str2);
        }
    }

    private static class MethodFilter extends ParentFilter {
        private final String className;
        private Set includedMethods = new HashSet();
        private Set excludedMethods = new HashSet();

        public MethodFilter(String str) {
            this.className = str;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            String str = this.className;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24);
            sb.append("Method filter for ");
            sb.append(str);
            sb.append(" class");
            return sb.toString();
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        public boolean evaluateTest(Description description) {
            String methodName = description.getMethodName();
            if (methodName == null) {
                return false;
            }
            String strStripParameterizedSuffix = stripParameterizedSuffix(methodName);
            if (this.excludedMethods.contains(methodName) || this.excludedMethods.contains(strStripParameterizedSuffix)) {
                return false;
            }
            return this.includedMethods.isEmpty() || this.includedMethods.contains(methodName) || this.includedMethods.contains(strStripParameterizedSuffix) || methodName.equals("initializationError");
        }

        private String stripParameterizedSuffix(String str) {
            return Pattern.compile(".+(\\[[0-9]+\\])$").matcher(str).matches() ? str.substring(0, str.lastIndexOf(91)) : str;
        }

        public void addInclusionMethod(String str) {
            this.includedMethods.add(str);
        }

        public void addExclusionMethod(String str) {
            this.excludedMethods.add(str);
        }
    }

    public TestRequestBuilder(Instrumentation instrumentation, Bundle bundle) {
        this(new DeviceBuildImpl(), instrumentation, bundle);
    }

    TestRequestBuilder(DeviceBuild deviceBuild, Instrumentation instrumentation, Bundle bundle) throws ClassNotFoundException {
        this.pathsToScan = new ArrayList();
        this.includedPackages = new HashSet();
        this.excludedPackages = new HashSet();
        this.includedClasses = new HashSet();
        this.excludedClasses = new HashSet();
        this.classMethodFilter = new ClassAndMethodFilter();
        TestsRegExFilter testsRegExFilter = new TestsRegExFilter();
        this.testsRegExFilter = testsRegExFilter;
        this.filter = new AnnotationExclusionFilter(Suppress.class).intersect(new SdkSuppressFilter()).intersect(new RequiresDeviceFilter()).intersect(this.classMethodFilter).intersect(testsRegExFilter);
        this.customRunnerBuilderClasses = new ArrayList();
        this.skipExecution = false;
        this.perTestTimeout = 0L;
        this.ignoreSuiteMethods = false;
        this.deviceBuild = (DeviceBuild) Checks.checkNotNull(deviceBuild);
        this.instr = (Instrumentation) Checks.checkNotNull(instrumentation);
        this.argsBundle = (Bundle) Checks.checkNotNull(bundle);
        maybeAddLegacySuppressFilter();
    }

    private void maybeAddLegacySuppressFilter() throws ClassNotFoundException {
        try {
            this.filter = this.filter.intersect(new AnnotationExclusionFilter(Class.forName("android.test.suitebuilder.annotation.Suppress")));
        } catch (ClassNotFoundException unused) {
        }
    }

    public TestRequestBuilder addPathsToScan(Iterable<String> iterable) {
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            addPathToScan(it.next());
        }
        return this;
    }

    public TestRequestBuilder addPathToScan(String str) {
        this.pathsToScan.add(str);
        return this;
    }

    public TestRequestBuilder setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        return this;
    }

    public TestRequestBuilder ignoreSuiteMethods(boolean z) {
        this.ignoreSuiteMethods = z;
        return this;
    }

    public TestRequestBuilder addTestClass(String str) {
        this.includedClasses.add(str);
        return this;
    }

    public TestRequestBuilder removeTestClass(String str) {
        this.excludedClasses.add(str);
        return this;
    }

    public TestRequestBuilder addTestMethod(String str, String str2) {
        this.includedClasses.add(str);
        this.classMethodFilter.addMethod(str, str2);
        return this;
    }

    public TestRequestBuilder removeTestMethod(String str, String str2) {
        this.classMethodFilter.removeMethod(str, str2);
        return this;
    }

    public TestRequestBuilder addTestPackage(String str) {
        this.includedPackages.add(str);
        return this;
    }

    public TestRequestBuilder removeTestPackage(String str) {
        this.excludedPackages.add(str);
        return this;
    }

    public TestRequestBuilder setTestsRegExFilter(String str) {
        this.testsRegExFilter.setPattern(str);
        return this;
    }

    public TestRequestBuilder addTestSizeFilter(TestSize testSize) {
        if (!TestSize.NONE.equals(testSize)) {
            addFilter(new SizeFilter(testSize));
        } else {
            Log.e("TestRequestBuilder", String.format("Unrecognized test size '%s'", testSize.getSizeQualifierName()));
        }
        return this;
    }

    public TestRequestBuilder addAnnotationInclusionFilter(String str) {
        Class clsLoadAnnotationClass = loadAnnotationClass(str);
        if (clsLoadAnnotationClass != null) {
            addFilter(new AnnotationInclusionFilter(clsLoadAnnotationClass));
        }
        return this;
    }

    public TestRequestBuilder addAnnotationExclusionFilter(String str) {
        Class clsLoadAnnotationClass = loadAnnotationClass(str);
        if (clsLoadAnnotationClass != null) {
            addFilter(new AnnotationExclusionFilter(clsLoadAnnotationClass));
        }
        return this;
    }

    public TestRequestBuilder addShardingFilter(int i, int i2) {
        return addFilter(new ShardingFilter(i, i2));
    }

    public TestRequestBuilder addFilter(Filter filter) {
        this.filter = this.filter.intersect(filter);
        return this;
    }

    public TestRequestBuilder addCustomRunnerBuilderClass(Class<? extends RunnerBuilder> cls) {
        this.customRunnerBuilderClasses.add(cls);
        return this;
    }

    public TestRequestBuilder setSkipExecution(boolean z) {
        this.skipExecution = z;
        return this;
    }

    public TestRequestBuilder setPerTestTimeout(long j) {
        this.perTestTimeout = j;
        return this;
    }

    public TestRequestBuilder addFromRunnerArgs(RunnerArgs runnerArgs) {
        int i;
        for (RunnerArgs.TestArg testArg : runnerArgs.tests) {
            String str = testArg.methodName;
            if (str == null) {
                addTestClass(testArg.testClassName);
            } else {
                addTestMethod(testArg.testClassName, str);
            }
        }
        for (RunnerArgs.TestArg testArg2 : runnerArgs.notTests) {
            String str2 = testArg2.methodName;
            if (str2 == null) {
                removeTestClass(testArg2.testClassName);
            } else {
                removeTestMethod(testArg2.testClassName, str2);
            }
        }
        Iterator<String> it = runnerArgs.testPackages.iterator();
        while (it.hasNext()) {
            addTestPackage(it.next());
        }
        Iterator<String> it2 = runnerArgs.notTestPackages.iterator();
        while (it2.hasNext()) {
            removeTestPackage(it2.next());
        }
        String str3 = runnerArgs.testSize;
        if (str3 != null) {
            addTestSizeFilter(TestSize.fromString(str3));
        }
        Iterator<String> it3 = runnerArgs.annotations.iterator();
        while (it3.hasNext()) {
            addAnnotationInclusionFilter(it3.next());
        }
        Iterator<String> it4 = runnerArgs.notAnnotations.iterator();
        while (it4.hasNext()) {
            addAnnotationExclusionFilter(it4.next());
        }
        Iterator<Filter> it5 = runnerArgs.filters.iterator();
        while (it5.hasNext()) {
            addFilter(it5.next());
        }
        long j = runnerArgs.testTimeout;
        if (j > 0) {
            setPerTestTimeout(j);
        }
        int i2 = runnerArgs.numShards;
        if (i2 > 0 && (i = runnerArgs.shardIndex) >= 0 && i < i2) {
            addShardingFilter(i2, i);
        }
        if (runnerArgs.logOnly) {
            setSkipExecution(true);
        }
        ClassLoader classLoader = runnerArgs.classLoader;
        if (classLoader != null) {
            setClassLoader(classLoader);
        }
        Iterator<Class<? extends RunnerBuilder>> it6 = runnerArgs.runnerBuilderClasses.iterator();
        while (it6.hasNext()) {
            addCustomRunnerBuilderClass(it6.next());
        }
        String str4 = runnerArgs.testsRegEx;
        if (str4 != null) {
            setTestsRegExFilter(str4);
        }
        return this;
    }

    public Request build() {
        Collection classNamesFromClassPath;
        this.includedPackages.removeAll(this.excludedPackages);
        this.includedClasses.removeAll(this.excludedClasses);
        validate(this.includedClasses);
        boolean zIsEmpty = this.includedClasses.isEmpty();
        TestLoader testLoader = TestLoader.testLoader(this.classLoader, getRunnerBuilder(new AndroidRunnerParams(this.instr, this.argsBundle, this.perTestTimeout, this.ignoreSuiteMethods || zIsEmpty), zIsEmpty), zIsEmpty);
        if (zIsEmpty) {
            classNamesFromClassPath = getClassNamesFromClassPath();
        } else {
            classNamesFromClassPath = this.includedClasses;
        }
        return new LenientFilterRequest(Request.runner(ExtendedSuite.createSuite(testLoader.getRunnersFor(classNamesFromClassPath, zIsEmpty))), this.filter);
    }

    private void validate(Set set) {
        if (set.isEmpty() && this.pathsToScan.isEmpty()) {
            throw new IllegalArgumentException("Must provide either classes to run, or paths to scan");
        }
    }

    private RunnerBuilder getRunnerBuilder(AndroidRunnerParams androidRunnerParams, boolean z) {
        if (this.skipExecution) {
            return new AndroidLogOnlyBuilder(androidRunnerParams, z, this.customRunnerBuilderClasses);
        }
        return new AndroidRunnerBuilder(androidRunnerParams, z, this.customRunnerBuilderClasses);
    }

    private Collection getClassNamesFromClassPath() {
        if (this.pathsToScan.isEmpty()) {
            throw new IllegalStateException("neither test class to execute or class paths were provided");
        }
        Log.i("TestRequestBuilder", String.format("Scanning classpath to find tests in paths %s", this.pathsToScan));
        ClassPathScanner classPathScannerCreateClassPathScanner = createClassPathScanner(this.pathsToScan);
        ClassPathScanner.ChainedClassNameFilter chainedClassNameFilter = new ClassPathScanner.ChainedClassNameFilter();
        chainedClassNameFilter.add(new ClassPathScanner.ExternalClassNameFilter());
        for (String str : DEFAULT_EXCLUDED_PACKAGES) {
            if (!this.includedPackages.contains(str)) {
                this.excludedPackages.add(str);
            }
        }
        if (!this.includedPackages.isEmpty()) {
            chainedClassNameFilter.add(new ClassPathScanner.InclusivePackageNamesFilter(this.includedPackages));
        }
        Iterator it = this.excludedPackages.iterator();
        while (it.hasNext()) {
            chainedClassNameFilter.add(new ClassPathScanner.ExcludePackageNameFilter((String) it.next()));
        }
        chainedClassNameFilter.add(new ClassPathScanner.ExcludeClassNamesFilter(this.excludedClasses));
        try {
            return classPathScannerCreateClassPathScanner.getClassPathEntries(chainedClassNameFilter);
        } catch (IOException e) {
            Log.e("TestRequestBuilder", "Failed to scan classes", e);
            return Collections.emptyList();
        }
    }

    ClassPathScanner createClassPathScanner(List list) {
        return new ClassPathScanner(list);
    }

    private Class loadAnnotationClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassCastException unused) {
            Log.e("TestRequestBuilder", String.format("Class %s is not an annotation", str));
            return null;
        } catch (ClassNotFoundException unused2) {
            Log.e("TestRequestBuilder", String.format("Could not find annotation class: %s", str));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDeviceSdkInt() {
        return this.deviceBuild.getSdkVersionInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDeviceHardware() {
        return this.deviceBuild.getHardware();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDeviceCodeName() {
        return this.deviceBuild.getCodeName();
    }
}
