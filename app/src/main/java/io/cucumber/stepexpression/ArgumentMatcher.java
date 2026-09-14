package io.cucumber.stepexpression;

import gherkin.pickles.PickleStep;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface ArgumentMatcher {
    List<Argument> argumentsFrom(PickleStep pickleStep, Type... typeArr);
}
