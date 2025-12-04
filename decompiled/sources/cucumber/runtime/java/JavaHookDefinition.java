package cucumber.runtime.java;

import cucumber.api.Scenario;
import cucumber.api.java.ObjectFactory;
import cucumber.runtime.CucumberException;
import cucumber.runtime.HookDefinition;
import cucumber.runtime.MethodFormat;
import cucumber.runtime.Utils;
import cucumber.runtime.filter.TagPredicate;
import gherkin.pickles.PickleTag;
import io.cucumber.core.event.Status;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes5.dex */
public class JavaHookDefinition implements HookDefinition {
    private final Method method;
    private final ObjectFactory objectFactory;
    private final int order;
    private final TagPredicate tagPredicate;
    private final long timeoutMillis;

    @Override // cucumber.runtime.HookDefinition
    public boolean isScenarioScoped() {
        return false;
    }

    JavaHookDefinition(Method method, String[] strArr, int i, long j, ObjectFactory objectFactory) {
        this.method = method;
        this.timeoutMillis = j;
        this.tagPredicate = new TagPredicate(Arrays.asList(strArr));
        this.order = i;
        this.objectFactory = objectFactory;
    }

    @Override // cucumber.runtime.HookDefinition
    public String getLocation(boolean z) {
        return (z ? MethodFormat.FULL : MethodFormat.SHORT).format(this.method);
    }

    @Override // cucumber.runtime.HookDefinition
    public void execute(Scenario scenario) throws Throwable {
        Object[] objArr;
        int length = this.method.getParameterTypes().length;
        if (length == 0) {
            objArr = new Object[0];
        } else if (length == 1) {
            Class<?> cls = this.method.getParameterTypes()[0];
            if (Scenario.class.equals(cls)) {
                objArr = new Object[]{scenario};
            } else {
                if (!io.cucumber.core.api.Scenario.class.equals(cls)) {
                    throw new CucumberException("When a hook declares an argument it must be of type " + io.cucumber.core.api.Scenario.class.getName() + ". " + this.method.toString());
                }
                objArr = new Object[]{new ScenarioAdaptor(scenario)};
            }
        } else {
            throw new CucumberException("Hooks must declare 0 or 1 arguments. " + this.method.toString());
        }
        Utils.invoke(this.objectFactory.getInstance(this.method.getDeclaringClass()), this.method, this.timeoutMillis, objArr);
    }

    @Override // cucumber.runtime.HookDefinition
    public boolean matches(Collection<PickleTag> collection) {
        return this.tagPredicate.apply(collection);
    }

    @Override // cucumber.runtime.HookDefinition
    public int getOrder() {
        return this.order;
    }

    private static class ScenarioAdaptor implements io.cucumber.core.api.Scenario {
        private final Scenario scenario;

        ScenarioAdaptor(Scenario scenario) {
            this.scenario = scenario;
        }

        @Override // io.cucumber.core.api.Scenario
        public Collection getSourceTagNames() {
            return this.scenario.getSourceTagNames();
        }

        @Override // io.cucumber.core.api.Scenario
        public Status getStatus() {
            return Status.valueOf(this.scenario.getStatus().name());
        }

        @Override // io.cucumber.core.api.Scenario
        public boolean isFailed() {
            return this.scenario.isFailed();
        }

        @Override // io.cucumber.core.api.Scenario
        public void embed(byte[] bArr, String str) {
            this.scenario.embed(bArr, str);
        }

        @Override // io.cucumber.core.api.Scenario
        public void embed(byte[] bArr, String str, String str2) {
            this.scenario.embed(bArr, str, str2);
        }

        @Override // io.cucumber.core.api.Scenario
        public void write(String str) {
            this.scenario.write(str);
        }

        @Override // io.cucumber.core.api.Scenario
        public String getName() {
            return this.scenario.getName();
        }

        @Override // io.cucumber.core.api.Scenario
        public String getId() {
            return this.scenario.getId();
        }

        @Override // io.cucumber.core.api.Scenario
        public String getUri() {
            return this.scenario.getUri();
        }

        @Override // io.cucumber.core.api.Scenario
        public Integer getLine() {
            return this.scenario.getLines().get(0);
        }
    }
}
