package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.screenshot.ScreenCaptureProcessor;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.RunListener;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes2.dex */
public class RunnerArgs {
    public final List<String> annotations;
    public final List<ApplicationLifecycleCallback> appListeners;
    public final ClassLoader classLoader;
    public final Set<String> classpathToScan;
    public final boolean codeCoverage;
    public final String codeCoveragePath;
    public final boolean debug;
    public final int delayInMillis;
    public final boolean disableAnalytics;
    public final List<Filter> filters;
    public final boolean listTestsForOrchestrator;
    public final List<RunListener> listeners;
    public final boolean logOnly;
    public final boolean newRunListenerMode;
    public final List<String> notAnnotations;
    public final List<String> notTestPackages;
    public final List<TestArg> notTests;
    public final int numShards;
    public final String orchestratorService;
    public final TestArg remoteMethod;
    public final List<Class<? extends RunnerBuilder>> runnerBuilderClasses;
    public final List<ScreenCaptureProcessor> screenCaptureProcessors;
    public final int shardIndex;
    public final String shellExecBinderKey;
    public final boolean suiteAssignment;
    public final String targetProcess;
    public final String testDiscoveryService;
    public final List<String> testPackages;
    public final boolean testPlatformMigration;
    public final String testRunEventsService;
    public final String testSize;
    public final long testTimeout;
    public final List<TestArg> tests;
    public final String testsRegEx;
    public final boolean useTestStorageService;

    public static class TestArg {
        public final String methodName;
        public final String testClassName;

        TestArg(String str, String str2) {
            this.testClassName = str;
            this.methodName = str2;
        }

        TestArg(String str) {
            this(str, null);
        }

        public String toString() {
            String str = this.methodName;
            String str2 = this.testClassName;
            if (str == null) {
                return str2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
            sb.append(str2);
            sb.append('#');
            sb.append(str);
            return sb.toString();
        }
    }

    private static final class TestFileArgs {
        private final List packages;
        private final List tests;

        private TestFileArgs() {
            this.tests = new ArrayList();
            this.packages = new ArrayList();
        }
    }

    private RunnerArgs(Builder builder) {
        this.debug = builder.debug;
        this.suiteAssignment = builder.suiteAssignment;
        this.codeCoverage = builder.codeCoverage;
        this.codeCoveragePath = builder.codeCoveragePath;
        this.delayInMillis = builder.delayInMillis;
        this.logOnly = builder.logOnly;
        this.testPackages = builder.testPackages;
        this.notTestPackages = builder.notTestPackages;
        this.testSize = builder.testSize;
        this.annotations = Collections.unmodifiableList(builder.annotations);
        this.notAnnotations = Collections.unmodifiableList(builder.notAnnotations);
        this.testTimeout = builder.testTimeout;
        this.listeners = Collections.unmodifiableList(builder.listeners);
        this.filters = Collections.unmodifiableList(builder.filters);
        this.runnerBuilderClasses = Collections.unmodifiableList(builder.runnerBuilderClasses);
        this.tests = Collections.unmodifiableList(builder.tests);
        this.notTests = Collections.unmodifiableList(builder.notTests);
        this.numShards = builder.numShards;
        this.shardIndex = builder.shardIndex;
        this.disableAnalytics = builder.disableAnalytics;
        this.appListeners = Collections.unmodifiableList(builder.appListeners);
        this.classLoader = builder.classLoader;
        this.classpathToScan = builder.classpathToScan;
        this.remoteMethod = builder.remoteMethod;
        this.orchestratorService = builder.orchestratorService;
        this.listTestsForOrchestrator = builder.listTestsForOrchestrator;
        this.testDiscoveryService = builder.testDiscoveryService;
        this.testRunEventsService = builder.testRunEventsService;
        this.useTestStorageService = builder.useTestStorageService;
        this.screenCaptureProcessors = Collections.unmodifiableList(builder.screenCaptureProcessors);
        this.targetProcess = builder.targetProcess;
        this.shellExecBinderKey = builder.shellExecBinderKey;
        this.newRunListenerMode = builder.newRunListenerMode;
        this.testsRegEx = builder.testsRegEx;
        this.testPlatformMigration = builder.testPlatformMigration;
    }

    public static class Builder {
        public String shellExecBinderKey;
        private boolean debug = false;
        private boolean suiteAssignment = false;
        private boolean codeCoverage = false;
        private String codeCoveragePath = null;
        private int delayInMillis = -1;
        private boolean logOnly = false;
        private List testPackages = new ArrayList();
        private List notTestPackages = new ArrayList();
        private String testSize = null;
        private final List annotations = new ArrayList();
        private final List notAnnotations = new ArrayList();
        private long testTimeout = -1;
        private List listeners = new ArrayList();
        private List filters = new ArrayList();
        private List runnerBuilderClasses = new ArrayList();
        private List tests = new ArrayList();
        private List notTests = new ArrayList();
        private int numShards = 0;
        private int shardIndex = 0;
        private boolean disableAnalytics = false;
        private List appListeners = new ArrayList();
        private ClassLoader classLoader = null;
        private Set classpathToScan = new HashSet();
        private TestArg remoteMethod = null;
        private String orchestratorService = null;
        private boolean listTestsForOrchestrator = false;
        private String testDiscoveryService = null;
        private String testRunEventsService = null;
        private boolean useTestStorageService = false;
        private String targetProcess = null;
        private List screenCaptureProcessors = new ArrayList();
        private boolean newRunListenerMode = false;
        private String testsRegEx = null;
        private boolean testPlatformMigration = false;

        public Builder fromBundle(Instrumentation instrumentation, Bundle bundle) throws IOException {
            this.debug = parseBoolean(bundle.getString("debug"));
            this.delayInMillis = parseUnsignedInt(bundle.get("delay_msec"), "delay_msec");
            this.tests.addAll(parseTestClasses(bundle.getString("class")));
            this.notTests.addAll(parseTestClasses(bundle.getString("notClass")));
            this.testPackages.addAll(parseTestPackages(bundle.getString("package")));
            this.notTestPackages.addAll(parseTestPackages(bundle.getString("notPackage")));
            TestFileArgs fromFile = parseFromFile(instrumentation, bundle.getString("testFile"));
            this.tests.addAll(fromFile.tests);
            this.testPackages.addAll(fromFile.packages);
            TestFileArgs fromFile2 = parseFromFile(instrumentation, bundle.getString("notTestFile"));
            this.notTests.addAll(fromFile2.tests);
            this.notTestPackages.addAll(fromFile2.packages);
            this.listeners.addAll(parseLoadAndInstantiateClasses(bundle.getString(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER), RunListener.class, null));
            this.filters.addAll(parseLoadAndInstantiateClasses(bundle.getString(ViewProps.FILTER), Filter.class, bundle));
            this.runnerBuilderClasses.addAll(parseAndLoadClasses(bundle.getString("runnerBuilder"), RunnerBuilder.class));
            this.testSize = bundle.getString(TCEventPropertiesNames.TCP_SIZE);
            this.annotations.addAll(parseStrings(bundle.getString("annotation")));
            this.notAnnotations.addAll(parseStrings(bundle.getString("notAnnotation")));
            this.testTimeout = parseUnsignedLong(bundle.getString("timeout_msec"), "timeout_msec");
            this.numShards = parseUnsignedInt(bundle.get("numShards"), "numShards");
            this.shardIndex = parseUnsignedInt(bundle.get("shardIndex"), "shardIndex");
            this.logOnly = parseBoolean(bundle.getString("log"));
            this.disableAnalytics = parseBoolean(bundle.getString("disableAnalytics"));
            this.appListeners.addAll(parseLoadAndInstantiateClasses(bundle.getString("appListener"), ApplicationLifecycleCallback.class, null));
            this.codeCoverage = parseBoolean(bundle.getString("coverage"));
            this.codeCoveragePath = bundle.getString("coverageFile");
            this.suiteAssignment = parseBoolean(bundle.getString("suiteAssignment"));
            this.classLoader = (ClassLoader) parseLoadAndInstantiateClass(bundle.getString("classLoader"), ClassLoader.class);
            this.classpathToScan = parseClasspath(bundle.getString("classpathToScan"));
            if (bundle.containsKey("remoteMethod")) {
                this.remoteMethod = parseTestClass(bundle.getString("remoteMethod"));
            }
            this.orchestratorService = bundle.getString("orchestratorService");
            this.listTestsForOrchestrator = parseBoolean(bundle.getString("listTestsForOrchestrator"));
            this.testDiscoveryService = bundle.getString("testDiscoveryService");
            this.testRunEventsService = bundle.getString("testRunEventsService");
            this.useTestStorageService = parseBoolean(bundle.getString("useTestStorageService"));
            this.targetProcess = bundle.getString("targetProcess");
            this.screenCaptureProcessors.addAll(parseLoadAndInstantiateClasses(bundle.getString("screenCaptureProcessors"), ScreenCaptureProcessor.class, null));
            this.shellExecBinderKey = bundle.getString("shellExecBinderKey");
            this.newRunListenerMode = parseBoolean(bundle.getString("newRunListenerMode"));
            this.testsRegEx = bundle.getString("tests_regex");
            this.testPlatformMigration = parseBoolean(bundle.getString("temporary_testPlatformMigration"));
            return this;
        }

        public Builder fromManifest(Instrumentation instrumentation) {
            try {
                Bundle bundle = instrumentation.getContext().getPackageManager().getInstrumentationInfo(instrumentation.getComponentName(), 128).metaData;
                return bundle == null ? this : fromBundle(instrumentation, bundle);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.wtf("RunnerArgs", String.format("Could not find component %s", instrumentation.getComponentName()));
                return this;
            }
        }

        private static List parseStrings(String str) {
            if (str == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(str.split(","));
        }

        private static boolean parseBoolean(String str) {
            return str != null && Boolean.parseBoolean(str);
        }

        private static int parseUnsignedInt(Object obj, String str) throws NumberFormatException {
            if (obj == null) {
                return -1;
            }
            int i = Integer.parseInt(obj.toString());
            if (i >= 0) {
                return i;
            }
            throw new NumberFormatException(String.valueOf(str).concat(" can not be negative"));
        }

        private static long parseUnsignedLong(Object obj, String str) throws NumberFormatException {
            if (obj == null) {
                return -1L;
            }
            long j = Long.parseLong(obj.toString());
            if (j >= 0) {
                return j;
            }
            throw new NumberFormatException(String.valueOf(str).concat(" can not be negative"));
        }

        private static List parseTestPackages(String str) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String str2 : str.split(",")) {
                    arrayList.add(str2);
                }
            }
            return arrayList;
        }

        private List parseTestClasses(String str) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String str2 : str.split(",")) {
                    arrayList.add(parseTestClass(str2));
                }
            }
            return arrayList;
        }

        private static Set parseClasspath(String str) {
            if (str == null || str.isEmpty()) {
                return new HashSet();
            }
            return new HashSet(Arrays.asList(str.split(":", -1)));
        }

        private static TestArg parseTestClass(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int iIndexOf = str.indexOf(35);
            if (iIndexOf > 0) {
                return new TestArg(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            return new TestArg(str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.test.internal.runner.RunnerArgs$1] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
        /* JADX WARN: Type inference failed for: r1v3 */
        private TestFileArgs parseFromFile(Instrumentation instrumentation, String str) throws IOException {
            ?? OpenFile = 0;
            OpenFile = 0;
            TestFileArgs testFileArgs = new TestFileArgs();
            try {
                if (str == null) {
                    return testFileArgs;
                }
                try {
                    OpenFile = openFile(instrumentation, str);
                    while (true) {
                        String line = OpenFile.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        } else if (isClassOrMethod(line)) {
                            testFileArgs.tests.add(parseTestClass(line));
                        } else {
                            testFileArgs.packages.addAll(parseTestPackages(line));
                        }
                    }
                    OpenFile.close();
                    return testFileArgs;
                } catch (FileNotFoundException e) {
                    throw new IllegalArgumentException(str.length() != 0 ? "testfile not found: ".concat(str) : new String("testfile not found: "), e);
                } catch (IOException e2) {
                    throw new IllegalArgumentException(str.length() != 0 ? "Could not read test file ".concat(str) : new String("Could not read test file "), e2);
                }
            } catch (Throwable th) {
                if (OpenFile != 0) {
                    try {
                        OpenFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }

        private BufferedReader openFile(Instrumentation instrumentation, String str) {
            Reader fileReader;
            if (instrumentation.getContext().getPackageManager().isInstantApp()) {
                UiAutomation uiAutomation = instrumentation.getUiAutomation();
                String strValueOf = String.valueOf(str);
                fileReader = new InputStreamReader(new ParcelFileDescriptor.AutoCloseInputStream(uiAutomation.executeShellCommand(strValueOf.length() != 0 ? "cat ".concat(strValueOf) : new String("cat "))));
            } else {
                fileReader = new FileReader(new File(str));
            }
            return new BufferedReader(fileReader);
        }

        static boolean isClassOrMethod(String str) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '#' || Character.isUpperCase(cCharAt)) {
                    return true;
                }
            }
            return false;
        }

        private List parseLoadAndInstantiateClasses(String str, Class cls, Bundle bundle) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String str2 : str.split(",")) {
                    loadClassByNameInstantiateAndAdd(arrayList, str2, cls, bundle);
                }
            }
            return arrayList;
        }

        private Object parseLoadAndInstantiateClass(String str, Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            List loadAndInstantiateClasses = parseLoadAndInstantiateClasses(str, cls, null);
            if (loadAndInstantiateClasses.isEmpty()) {
                return null;
            }
            if (loadAndInstantiateClasses.size() > 1) {
                throw new IllegalArgumentException(String.format("Expected 1 class loader, %d given", Integer.valueOf(loadAndInstantiateClasses.size())));
            }
            return loadAndInstantiateClasses.get(0);
        }

        private void loadClassByNameInstantiateAndAdd(List list, String str, Class cls, Bundle bundle) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Constructor<?> constructor;
            Object[] objArr;
            if (str == null || str.length() == 0) {
                return;
            }
            try {
                try {
                    Class<?> cls2 = Class.forName(str);
                    try {
                        constructor = cls2.getConstructor(new Class[0]);
                        objArr = new Object[0];
                    } catch (NoSuchMethodException e) {
                        if (bundle != null) {
                            try {
                                constructor = cls2.getConstructor(Bundle.class);
                                objArr = new Object[]{bundle};
                            } catch (NoSuchMethodException e2) {
                                e2.initCause(e);
                                throw e2;
                            }
                        } else {
                            throw e;
                        }
                    }
                    constructor.setAccessible(true);
                    list.add(constructor.newInstance(objArr));
                } catch (ClassCastException unused) {
                    String name = cls.getName();
                    StringBuilder sb = new StringBuilder(str.length() + 17 + name.length());
                    sb.append(str);
                    sb.append(" does not extend ");
                    sb.append(name);
                    throw new IllegalArgumentException(sb.toString());
                } catch (ClassNotFoundException unused2) {
                    throw new IllegalArgumentException(str.length() != 0 ? "Could not find extra class ".concat(str) : new String("Could not find extra class "));
                } catch (IllegalAccessException e3) {
                    throw new IllegalArgumentException(str.length() != 0 ? "Failed to create listener: ".concat(str) : new String("Failed to create listener: "), e3);
                } catch (InstantiationException e4) {
                    throw new IllegalArgumentException(str.length() != 0 ? "Failed to create: ".concat(str) : new String("Failed to create: "), e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalArgumentException(str.length() != 0 ? "Failed to create: ".concat(str) : new String("Failed to create: "), e5);
                }
            } catch (NoSuchMethodException unused3) {
                throw new IllegalArgumentException(str.length() != 0 ? "Must have no argument constructor for class ".concat(str) : new String("Must have no argument constructor for class "));
            }
        }

        private List parseAndLoadClasses(String str, Class cls) throws ClassNotFoundException {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                for (String str2 : str.split(",")) {
                    loadClassByNameAndAdd(arrayList, str2, cls);
                }
            }
            return arrayList;
        }

        private void loadClassByNameAndAdd(List list, String str, Class cls) throws ClassNotFoundException {
            if (str == null || str.length() == 0) {
                return;
            }
            try {
                Class<?> cls2 = Class.forName(str);
                if (!cls.isAssignableFrom(cls2)) {
                    String name = cls.getName();
                    StringBuilder sb = new StringBuilder(str.length() + 17 + name.length());
                    sb.append(str);
                    sb.append(" does not extend ");
                    sb.append(name);
                    throw new IllegalArgumentException(sb.toString());
                }
                list.add(cls2);
            } catch (ClassCastException unused) {
                String name2 = cls.getName();
                StringBuilder sb2 = new StringBuilder(str.length() + 17 + name2.length());
                sb2.append(str);
                sb2.append(" does not extend ");
                sb2.append(name2);
                throw new IllegalArgumentException(sb2.toString());
            } catch (ClassNotFoundException unused2) {
                throw new IllegalArgumentException(str.length() != 0 ? "Could not find extra class ".concat(str) : new String("Could not find extra class "));
            }
        }

        public RunnerArgs build() {
            return new RunnerArgs(this);
        }
    }
}
