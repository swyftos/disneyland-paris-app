package androidx.test.internal.events.client;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.internal.util.Checks;
import androidx.test.services.events.ParcelableConverter;
import androidx.test.services.events.TestEventException;
import androidx.test.services.events.discovery.TestDiscoveryFinishedEvent;
import androidx.test.services.events.discovery.TestDiscoveryStartedEvent;
import androidx.test.services.events.discovery.TestFoundEvent;
import gherkin.GherkinLanguageConstants;
import java.util.Iterator;
import org.junit.runner.Description;

/* loaded from: classes2.dex */
public final class TestDiscovery {
    private final TestDiscoveryEventService testDiscoveryEventService;

    public TestDiscovery(@NonNull TestDiscoveryEventService testDiscoveryEventService) {
        this.testDiscoveryEventService = (TestDiscoveryEventService) Checks.checkNotNull(testDiscoveryEventService, "testDiscoveryEventService can't be null");
    }

    public void addTests(@NonNull Description description) throws TestEventClientException {
        Checks.checkNotNull(description, "description cannot be null");
        this.testDiscoveryEventService.send(new TestDiscoveryStartedEvent());
        addTest(description);
        this.testDiscoveryEventService.send(new TestDiscoveryFinishedEvent());
    }

    private void addTest(Description description) {
        if (description.isEmpty()) {
            Log.d("TestDiscovery", "addTest called with an empty test description");
            return;
        }
        if (description.isTest()) {
            if (!JUnitValidator.validateDescription(description)) {
                String className = description.getClassName();
                String methodName = description.getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(className).length() + 38 + String.valueOf(methodName).length());
                sb.append("JUnit reported ");
                sb.append(className);
                sb.append(GherkinLanguageConstants.COMMENT_PREFIX);
                sb.append(methodName);
                sb.append("; discarding as bogus.");
                Log.w("TestDiscovery", sb.toString());
                return;
            }
            try {
                this.testDiscoveryEventService.send(new TestFoundEvent(ParcelableConverter.getTestCaseFromDescription(description)));
                return;
            } catch (TestEventException e) {
                Log.e("TestDiscovery", "Failed to get test description", e);
                return;
            }
        }
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            addTest(it.next());
        }
    }
}
