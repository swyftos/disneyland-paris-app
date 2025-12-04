package io.cucumber.junit;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class CucumberAndroidJUnitArguments {
    private final Bundle originalArgs;
    private Bundle processedArgs;
    private static final String TRUE = Boolean.TRUE.toString();
    private static final String FALSE = Boolean.FALSE.toString();

    public static class Args {
        public static final String USE_DEFAULT_ANDROID_RUNNER = "cucumberUseAndroidJUnitRunner";
    }

    public CucumberAndroidJUnitArguments(@NonNull Bundle bundle) {
        this.originalArgs = new Bundle(bundle);
    }

    public Bundle processArgs() {
        this.processedArgs = new Bundle(this.originalArgs);
        if (TRUE.equals(this.originalArgs.getString(Args.USE_DEFAULT_ANDROID_RUNNER, FALSE))) {
            return this.processedArgs;
        }
        this.processedArgs.putString("runnerBuilder", CucumberJUnitRunnerBuilder.class.getName());
        String string = this.originalArgs.getString("class");
        if (string != null && !string.isEmpty()) {
            this.processedArgs.putString("cucumberAndroidTestClass", string);
        }
        this.processedArgs.putString("class", CucumberJUnitRunnerBuilder.class.getName());
        return this.processedArgs;
    }

    Bundle getRunnerArgs() {
        if (this.processedArgs == null) {
            this.processedArgs = processArgs();
        }
        return this.processedArgs;
    }
}
