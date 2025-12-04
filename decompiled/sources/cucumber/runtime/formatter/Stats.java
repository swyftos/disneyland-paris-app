package cucumber.runtime.formatter;

import cucumber.api.PickleStepTestStep;
import cucumber.api.Result;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.api.event.TestStepFinished;
import cucumber.api.formatter.ColorAware;
import cucumber.api.formatter.StrictAware;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class Stats implements EventListener, ColorAware, StrictAware {
    static final long ONE_MINUTE;
    static final long ONE_SECOND;
    private List ambiguousScenarios;
    private final List errors;
    private final List failedScenarios;
    private Formats formats;
    private Locale locale;
    private final List pendingScenarios;
    private SubCounts scenarioSubCounts;
    private long startTime;
    private final EventHandler stepFinishedHandler;
    private SubCounts stepSubCounts;
    private boolean strict;
    private final EventHandler testCaseFinishedHandler;
    private final EventHandler testRunFinishedHandler;
    private final EventHandler testRunStartedHandler;
    private long totalDuration;
    private final List undefinedScenarios;

    static {
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        ONE_SECOND = nanos;
        ONE_MINUTE = nanos * 60;
    }

    public Stats() {
        this(Locale.getDefault());
    }

    Stats(Locale locale) {
        this.scenarioSubCounts = new SubCounts();
        this.stepSubCounts = new SubCounts();
        this.startTime = 0L;
        this.totalDuration = 0L;
        this.formats = new AnsiFormats();
        this.failedScenarios = new ArrayList();
        this.ambiguousScenarios = new ArrayList();
        this.pendingScenarios = new ArrayList();
        this.undefinedScenarios = new ArrayList();
        this.errors = new ArrayList();
        this.testRunStartedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.Stats.1
            @Override // cucumber.api.event.EventHandler
            public void receive(TestRunStarted testRunStarted) {
                Stats.this.setStartTime(testRunStarted.getTimeStamp());
            }
        };
        this.stepFinishedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.Stats.2
            @Override // cucumber.api.event.EventHandler
            public void receive(TestStepFinished testStepFinished) {
                Result result = testStepFinished.result;
                if (result.getError() != null) {
                    Stats.this.addError(result.getError());
                }
                if (testStepFinished.testStep instanceof PickleStepTestStep) {
                    Stats.this.addStep(result.getStatus());
                }
            }
        };
        this.testCaseFinishedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.Stats.3
            @Override // cucumber.api.event.EventHandler
            public void receive(TestCaseFinished testCaseFinished) {
                Stats.this.addScenario(testCaseFinished.result.getStatus(), testCaseFinished.testCase.getScenarioDesignation());
            }
        };
        this.testRunFinishedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.Stats.4
            @Override // cucumber.api.event.EventHandler
            public void receive(TestRunFinished testRunFinished) {
                Stats.this.setFinishTime(testRunFinished.getTimeStamp());
            }
        };
        this.locale = locale;
    }

    @Override // cucumber.api.formatter.ColorAware
    public void setMonochrome(boolean z) {
        if (z) {
            this.formats = new MonochromeFormats();
        } else {
            this.formats = new AnsiFormats();
        }
    }

    @Override // cucumber.api.formatter.StrictAware
    public void setStrict(boolean z) {
        this.strict = true;
    }

    @Override // cucumber.api.event.EventListener
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this.testRunStartedHandler);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this.stepFinishedHandler);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this.testCaseFinishedHandler);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this.testRunFinishedHandler);
    }

    public List<Throwable> getErrors() {
        return this.errors;
    }

    void addStep(Result.Type type) {
        addResultToSubCount(this.stepSubCounts, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addError(Throwable th) {
        this.errors.add(th);
    }

    void setStartTime(Long l) {
        this.startTime = l.longValue();
    }

    void setFinishTime(Long l) {
        this.totalDuration = l.longValue() - this.startTime;
    }

    /* renamed from: cucumber.runtime.formatter.Stats$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$cucumber$api$Result$Type;

        static {
            int[] iArr = new int[Result.Type.values().length];
            $SwitchMap$cucumber$api$Result$Type = iArr;
            try {
                iArr[Result.Type.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.AMBIGUOUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.UNDEFINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.SKIPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void addResultToSubCount(SubCounts subCounts, Result.Type type) {
        int i = AnonymousClass5.$SwitchMap$cucumber$api$Result$Type[type.ordinal()];
        if (i == 1) {
            subCounts.failed++;
            return;
        }
        if (i == 2) {
            subCounts.ambiguous++;
            return;
        }
        if (i == 3) {
            subCounts.pending++;
            return;
        }
        if (i == 4) {
            subCounts.undefined++;
        } else if (i == 5) {
            subCounts.skipped++;
        } else {
            subCounts.passed++;
        }
    }

    void addScenario(Result.Type type, String str) {
        addResultToSubCount(this.scenarioSubCounts, type);
        int i = AnonymousClass5.$SwitchMap$cucumber$api$Result$Type[type.ordinal()];
        if (i == 1) {
            this.failedScenarios.add(str);
            return;
        }
        if (i == 2) {
            this.ambiguousScenarios.add(str);
        } else if (i == 3) {
            this.pendingScenarios.add(str);
        } else {
            if (i != 4) {
                return;
            }
            this.undefinedScenarios.add(str);
        }
    }

    static class SubCounts {
        public int passed = 0;
        public int failed = 0;
        public int ambiguous = 0;
        public int skipped = 0;
        public int pending = 0;
        public int undefined = 0;

        SubCounts() {
        }
    }
}
