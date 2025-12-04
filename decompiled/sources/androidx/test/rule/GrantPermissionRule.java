package androidx.test.rule;

import androidx.test.annotation.Beta;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.content.PermissionGranter;
import androidx.test.internal.util.Checks;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

@Beta
/* loaded from: classes2.dex */
public class GrantPermissionRule implements TestRule {
    private PermissionGranter permissionGranter;

    private GrantPermissionRule() {
        this((PermissionGranter) ServiceLoaderWrapper.loadSingleService(PermissionGranter.class, GrantPermissionRule$$Lambda$0.$instance));
    }

    GrantPermissionRule(PermissionGranter permissionGranter) {
        setPermissionGranter(permissionGranter);
    }

    public static GrantPermissionRule grant(String... strArr) {
        GrantPermissionRule grantPermissionRule = new GrantPermissionRule();
        grantPermissionRule.grantPermissions(strArr);
        return grantPermissionRule;
    }

    private void grantPermissions(String... strArr) {
        Set setSatisfyPermissionDependencies = satisfyPermissionDependencies(strArr);
        this.permissionGranter.addPermissions((String[]) setSatisfyPermissionDependencies.toArray(new String[setSatisfyPermissionDependencies.size()]));
    }

    Set satisfyPermissionDependencies(String... strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(strArr));
        if (linkedHashSet.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
            linkedHashSet.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        return linkedHashSet;
    }

    @Override // org.junit.rules.TestRule
    public final Statement apply(Statement statement, Description description) {
        return new RequestPermissionStatement(statement);
    }

    void setPermissionGranter(PermissionGranter permissionGranter) {
        this.permissionGranter = (PermissionGranter) Checks.checkNotNull(permissionGranter, "permissionRequester cannot be null!");
    }

    private class RequestPermissionStatement extends Statement {
        private final Statement base;

        public RequestPermissionStatement(Statement statement) {
            this.base = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            GrantPermissionRule.this.permissionGranter.requestPermissions();
            this.base.evaluate();
        }
    }
}
