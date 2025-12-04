package cucumber.runner;

import cucumber.runtime.CucumberException;
import cucumber.runtime.StepDefinition;
import cucumber.runtime.StepDefinitionMatch;
import gherkin.pickles.PickleStep;
import io.cucumber.cucumberexpressions.CucumberExpressionException;
import io.cucumber.datatable.CucumberDataTableException;
import io.cucumber.datatable.UndefinedDataTableTypeException;
import io.cucumber.stepexpression.Argument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class PickleStepDefinitionMatch extends Match implements StepDefinitionMatch {
    private final transient String featurePath;
    private final transient PickleStep step;
    private final StepDefinition stepDefinition;

    public void dryRunStep(cucumber.api.Scenario scenario) {
    }

    public PickleStepDefinitionMatch(List list, StepDefinition stepDefinition, String str, PickleStep pickleStep) {
        super(list, stepDefinition.getLocation(false));
        this.stepDefinition = stepDefinition;
        this.featurePath = str;
        this.step = pickleStep;
    }

    public void runStep(cucumber.api.Scenario scenario) throws Throwable {
        int size = getArguments().size();
        Integer parameterCount = this.stepDefinition.getParameterCount();
        if (parameterCount != null && size != parameterCount.intValue()) {
            throw arityMismatch(parameterCount.intValue());
        }
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = getArguments().iterator();
            while (it.hasNext()) {
                arrayList.add(((Argument) it.next()).getValue());
            }
            try {
                this.stepDefinition.execute(arrayList.toArray(new Object[0]));
            } catch (CucumberException e) {
                throw e;
            } catch (Throwable th) {
                throw removeFrameworkFramesAndAppendStepLocation(th, getStepLocation());
            }
        } catch (CucumberExpressionException | CucumberDataTableException e2) {
            throw couldNotConvertArguments(e2);
        } catch (UndefinedDataTableTypeException e3) {
            throw registerTypeInConfiguration(e3);
        }
    }

    private CucumberException registerTypeInConfiguration(Exception exc) {
        return new CucumberException(String.format("Could not convert arguments for step [%s] defined at '%s'.\nIt appears you did not register a data table type. The details are in the stacktrace below.", this.stepDefinition.getPattern(), this.stepDefinition.getLocation(true)), exc);
    }

    private CucumberException couldNotConvertArguments(Exception exc) {
        return new CucumberException(String.format("Could not convert arguments for step [%s] defined at '%s'.\nThe details are in the stacktrace below.", this.stepDefinition.getPattern(), this.stepDefinition.getLocation(true)), exc);
    }

    private CucumberException arityMismatch(int i) {
        List listCreateArgumentsForErrorMessage = createArgumentsForErrorMessage();
        return new CucumberException(String.format("Step [%s] is defined with %s parameters at '%s'.\nHowever, the gherkin step has %s arguments%sStep text: %s", this.stepDefinition.getPattern(), Integer.valueOf(i), this.stepDefinition.getLocation(true), Integer.valueOf(listCreateArgumentsForErrorMessage.size()), formatArguments(listCreateArgumentsForErrorMessage), this.step.getText()));
    }

    private String formatArguments(List list) {
        if (list.isEmpty()) {
            return ".\n";
        }
        StringBuilder sb = new StringBuilder(":\n");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(" * ");
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }

    private List createArgumentsForErrorMessage() {
        ArrayList arrayList = new ArrayList(getArguments().size());
        Iterator it = getArguments().iterator();
        while (it.hasNext()) {
            arrayList.add(((Argument) it.next()).toString());
        }
        return arrayList;
    }

    Throwable removeFrameworkFramesAndAppendStepLocation(Throwable th, StackTraceElement stackTraceElement) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length != 0 && stackTraceElement != null) {
            int i = 1;
            while (i < stackTrace.length && !this.stepDefinition.isDefinedAt(stackTrace[i - 1])) {
                i++;
            }
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[i + 1];
            System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, i);
            stackTraceElementArr[i] = stackTraceElement;
            th.setStackTrace(stackTraceElementArr);
        }
        return th;
    }

    public String getPattern() {
        return this.stepDefinition.getPattern();
    }

    StackTraceElement getStepLocation() {
        return new StackTraceElement("✽", this.step.getText(), this.featurePath, getStepLine(this.step));
    }

    StepDefinition getStepDefinition() {
        return this.stepDefinition;
    }

    @Override // cucumber.runtime.StepDefinitionMatch
    public String getCodeLocation() {
        return this.stepDefinition.getLocation(false);
    }

    private static int getStepLine(PickleStep pickleStep) {
        return pickleStep.getLocations().get(pickleStep.getLocations().size() - 1).getLine();
    }
}
