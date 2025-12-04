package io.cucumber.android.runner;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.test.runner.AndroidJUnitRunner;
import io.cucumber.junit.CucumberAndroidJUnitArguments;
import io.cucumber.junit.CucumberArgumentsProvider;

/* loaded from: classes5.dex */
public class CucumberAndroidJUnitRunner extends AndroidJUnitRunner implements CucumberArgumentsProvider {
    private CucumberAndroidJUnitArguments cucumberJUnitRunnerCore;

    @Override // androidx.test.runner.AndroidJUnitRunner, androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void onCreate(Bundle bundle) {
        CucumberAndroidJUnitArguments cucumberAndroidJUnitArguments = new CucumberAndroidJUnitArguments(bundle);
        this.cucumberJUnitRunnerCore = cucumberAndroidJUnitArguments;
        super.onCreate(cucumberAndroidJUnitArguments.processArgs());
    }

    @Override // io.cucumber.junit.CucumberArgumentsProvider
    @NonNull
    public CucumberAndroidJUnitArguments getArguments() {
        return this.cucumberJUnitRunnerCore;
    }
}
