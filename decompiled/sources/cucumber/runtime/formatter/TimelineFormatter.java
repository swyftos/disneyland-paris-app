package cucumber.runtime.formatter;

import cucumber.api.TestCase;
import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseEvent;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestSourceRead;
import cucumber.api.formatter.NiceAppendable;
import cucumber.runtime.CucumberException;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.JsonIOException;
import gherkin.pickles.PickleTag;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class TimelineFormatter implements ConcurrentEventListener {
    private static final String[] TEXT_ASSETS = {"/io/cucumber/formatter/timeline/index.html", "/io/cucumber/formatter/timeline/formatter.js", "/io/cucumber/formatter/timeline/report.css", "/io/cucumber/formatter/timeline/jquery-3.4.1.min.js", "/io/cucumber/formatter/timeline/vis.min.css", "/io/cucumber/formatter/timeline/vis.min.js", "/io/cucumber/formatter/timeline/vis.override.css", "/io/cucumber/formatter/timeline/chosen.jquery.min.js", "/io/cucumber/formatter/timeline/chosen.min.css", "/io/cucumber/formatter/timeline/chosen.override.css", "/io/cucumber/formatter/timeline/chosen-sprite.png"};
    private final Map allGroups;
    private final Map allTests;
    private final EventHandler caseFinishedHandler;
    private final EventHandler caseStartedHandler;
    private final URL reportDir;
    private final NiceAppendable reportJs;
    private final EventHandler runFinishedHandler;
    private final EventHandler testSourceReadHandler;
    private final TestSourcesModel testSources;

    public TimelineFormatter(URL url) {
        this(url, createJsonOut(url, "report.js"));
    }

    private TimelineFormatter(URL url, NiceAppendable niceAppendable) {
        this.testSourceReadHandler = new EventHandler() { // from class: cucumber.runtime.formatter.TimelineFormatter.1
            @Override // cucumber.api.event.EventHandler
            public void receive(TestSourceRead testSourceRead) {
                TimelineFormatter.this.testSources.addTestSourceReadEvent(testSourceRead.uri, testSourceRead);
            }
        };
        this.caseStartedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.TimelineFormatter.2
            @Override // cucumber.api.event.EventHandler
            public void receive(TestCaseStarted testCaseStarted) {
                TimelineFormatter.this.handleTestCaseStarted(testCaseStarted);
            }
        };
        this.caseFinishedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.TimelineFormatter.3
            @Override // cucumber.api.event.EventHandler
            public void receive(TestCaseFinished testCaseFinished) {
                TimelineFormatter.this.handleTestCaseFinished(testCaseFinished);
            }
        };
        this.runFinishedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.TimelineFormatter.4
            @Override // cucumber.api.event.EventHandler
            public void receive(TestRunFinished testRunFinished) throws Throwable {
                TimelineFormatter.this.finishReport(testRunFinished);
            }
        };
        this.testSources = new TestSourcesModel();
        this.allTests = new HashMap();
        this.allGroups = new HashMap();
        this.reportDir = url;
        this.reportJs = niceAppendable;
    }

    @Override // cucumber.api.event.ConcurrentEventListener
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestSourceRead.class, this.testSourceReadHandler);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this.caseStartedHandler);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this.caseFinishedHandler);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this.runFinishedHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTestCaseStarted(TestCaseStarted testCaseStarted) {
        Thread threadCurrentThread = Thread.currentThread();
        Long lValueOf = Long.valueOf(threadCurrentThread.getId());
        this.allTests.put(getId(testCaseStarted), new TestData(testCaseStarted, lValueOf));
        if (this.allGroups.containsKey(lValueOf)) {
            return;
        }
        this.allGroups.put(lValueOf, new GroupData(threadCurrentThread));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTestCaseFinished(TestCaseFinished testCaseFinished) {
        ((TestData) this.allTests.get(getId(testCaseFinished))).end(testCaseFinished);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishReport(TestRunFinished testRunFinished) throws Throwable {
        Gson gsonCreate = new GsonBuilder().setPrettyPrinting().create();
        this.reportJs.append((CharSequence) "$(document).ready(function() {");
        this.reportJs.println();
        appendAsJsonToJs(gsonCreate, this.reportJs, "timelineItems", this.allTests.values());
        this.reportJs.println();
        appendAsJsonToJs(gsonCreate, this.reportJs, "timelineGroups", new TreeMap(this.allGroups).values());
        this.reportJs.println();
        this.reportJs.append((CharSequence) "});");
        this.reportJs.close();
        copyReportFiles();
    }

    private void appendAsJsonToJs(Gson gson, NiceAppendable niceAppendable, String str, Collection collection) throws IOException, JsonIOException {
        niceAppendable.append((CharSequence) ("CucumberHTML." + str + ".pushArray("));
        gson.toJson(collection, niceAppendable);
        niceAppendable.append(");");
    }

    private void copyReportFiles() throws Throwable {
        if (this.reportDir == null) {
            return;
        }
        File file = new File(this.reportDir.getPath());
        for (String str : TEXT_ASSETS) {
            InputStream resourceAsStream = getClass().getResourceAsStream(str);
            if (resourceAsStream == null) {
                throw new CucumberException("Couldn't find " + str);
            }
            copyFile(resourceAsStream, new File(file, new File(str).getName()));
            closeQuietly(resourceAsStream);
        }
    }

    private static NiceAppendable createJsonOut(URL url, String str) {
        File file = new File(url.getPath());
        if (!file.exists() && !file.mkdirs()) {
            throw new CucumberException("Failed to create dir: " + url.getPath());
        }
        try {
            return new NiceAppendable(new OutputStreamWriter(new URLOutputStream(new URL(url, str)), "UTF-8"));
        } catch (IOException e) {
            throw new CucumberException(e);
        }
    }

    private static void copyFile(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            closeQuietly(fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    throw new CucumberException("Unable to write to report file item: ", e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getId(TestCaseEvent testCaseEvent) {
        TestCase testCase = testCaseEvent.getTestCase();
        return TestSourcesModel.calculateId(this.testSources.getAstNode(testCase.getUri(), testCase.getLine()));
    }

    class TestData {
        String className;
        final String content = "";
        long endTime;
        final String feature;
        final String id;
        final String scenario;
        final long startTime;
        final String tags;
        final long threadId;

        TestData(TestCaseStarted testCaseStarted, Long l) {
            this.id = TimelineFormatter.this.getId(testCaseStarted);
            TestCase testCase = testCaseStarted.getTestCase();
            this.feature = TimelineFormatter.this.testSources.getFeatureName(testCase.getUri());
            this.scenario = testCase.getName();
            this.startTime = testCaseStarted.getTimeStampMillis();
            this.threadId = l.longValue();
            this.tags = buildTagsValue(testCase);
        }

        private String buildTagsValue(TestCase testCase) {
            StringBuilder sb = new StringBuilder();
            Iterator<PickleTag> it = testCase.getTags().iterator();
            while (it.hasNext()) {
                sb.append(it.next().getName().toLowerCase());
                sb.append(",");
            }
            return sb.toString();
        }

        public void end(TestCaseFinished testCaseFinished) {
            this.endTime = testCaseFinished.getTimeStampMillis();
            this.className = testCaseFinished.result.getStatus().lowerCaseName();
        }
    }

    class GroupData {
        final String content;
        final long id;

        GroupData(Thread thread) {
            this.id = thread.getId();
            this.content = thread.toString();
        }
    }
}
