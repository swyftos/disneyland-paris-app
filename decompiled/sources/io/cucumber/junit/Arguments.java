package io.cucumber.junit;

import android.os.Bundle;
import com.urbanairship.actions.FetchDeviceInfoAction;

/* loaded from: classes5.dex */
public class Arguments {
    private final boolean countEnabled;
    private final String coverageDataFilePath;
    private final boolean coverageEnabled;
    private final String cucumberOptions;
    private final boolean debugEnabled;

    public Arguments(Bundle bundle) {
        this.countEnabled = getBooleanArgument(bundle, "count");
        this.debugEnabled = getBooleanArgument(bundle, "debug");
        this.coverageEnabled = getBooleanArgument(bundle, "coverage");
        this.coverageDataFilePath = getStringArgument(bundle, "coverageFile", "coverage.ec");
        this.cucumberOptions = getCucumberOptionsString(bundle);
    }

    public boolean isCountEnabled() {
        return this.countEnabled;
    }

    public boolean isDebugEnabled() {
        return this.debugEnabled;
    }

    public String coverageDataFilePath() {
        return this.coverageDataFilePath;
    }

    public boolean isCoverageEnabled() {
        return this.coverageEnabled;
    }

    public String getCucumberOptions() {
        return this.cucumberOptions;
    }

    private boolean getBooleanArgument(Bundle bundle, String str) {
        String string;
        return (bundle == null || (string = bundle.getString(str)) == null || !Boolean.parseBoolean(string)) ? false : true;
    }

    private String getStringArgument(Bundle bundle, String str, String str2) {
        return bundle == null ? str2 : bundle.getString(str, str2);
    }

    private void appendOption(StringBuilder sb, String str, String str2) {
        for (String str3 : str2.split("--")) {
            String str4 = "";
            sb.append((sb.length() == 0 || str.isEmpty()) ? "" : " ");
            sb.append(str);
            if (!str2.isEmpty()) {
                str4 = " " + str3;
            }
            sb.append(str4);
        }
    }

    private String getCucumberOptionsString(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("cucumberOptions");
        if (string != null) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = "";
        for (String str : bundle.keySet()) {
            if ("glue".equals(str)) {
                appendOption(sb, "--glue", bundle.getString(str));
            } else if ("format".equals(str)) {
                appendOption(sb, "--format", bundle.getString(str));
            } else if ("plugin".equals(str)) {
                appendOption(sb, "--plugin", bundle.getString(str));
            } else if (FetchDeviceInfoAction.TAGS_KEY.equals(str)) {
                appendOption(sb, "--tags", bundle.getString(str));
            } else if ("name".equals(str)) {
                appendOption(sb, "--name", bundle.getString(str));
            } else if ("dryRun".equals(str) && getBooleanArgument(bundle, str)) {
                appendOption(sb, "--dry-run", "");
            } else if ("log".equals(str) && getBooleanArgument(bundle, str)) {
                appendOption(sb, "--dry-run", "");
            } else if ("noDryRun".equals(str) && getBooleanArgument(bundle, str)) {
                appendOption(sb, "--no-dry-run", "");
            } else if ("monochrome".equals(str) && getBooleanArgument(bundle, str)) {
                appendOption(sb, "--monochrome", "");
            } else if ("noMonochrome".equals(str) && getBooleanArgument(bundle, str)) {
                appendOption(sb, "--no-monochrome", "");
            } else if ("strict".equals(str) && getBooleanArgument(bundle, str)) {
                appendOption(sb, "--strict", "");
            } else if ("noStrict".equals(str) && getBooleanArgument(bundle, str)) {
                appendOption(sb, "--no-strict", "");
            } else if ("snippets".equals(str)) {
                appendOption(sb, "--snippets", bundle.getString(str));
            } else if ("features".equals(str)) {
                string2 = bundle.getString(str);
            }
        }
        appendOption(sb, "", string2);
        return sb.toString();
    }
}
