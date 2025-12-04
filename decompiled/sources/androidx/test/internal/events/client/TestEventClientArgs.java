package androidx.test.internal.events.client;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;

/* loaded from: classes2.dex */
public final class TestEventClientArgs {

    @Nullable
    public final ConnectionFactory connectionFactory;
    public final boolean isOrchestrated;
    public final boolean isPrimaryInstrProcess;
    public final boolean isTestDiscoveryRequested;
    public final boolean isTestRunEventsRequested;
    public final int orchestratorVersion;

    @Nullable
    public final String testDiscoveryService;
    public final boolean testPlatformMigration;

    @Nullable
    public final String testRunEventService;

    public interface ConnectionFactory {
        @NonNull
        TestEventServiceConnection create(@NonNull TestEventClientConnectListener testEventClientConnectListener);
    }

    private TestEventClientArgs(boolean z, int i, Builder builder) {
        this.isOrchestrated = z;
        this.isPrimaryInstrProcess = builder.isPrimaryInstProcess;
        this.isTestDiscoveryRequested = builder.testDiscoveryRequested;
        this.isTestRunEventsRequested = builder.testRunEventsRequested;
        this.testDiscoveryService = builder.testDiscoveryService;
        this.testRunEventService = builder.testRunEventService;
        this.connectionFactory = builder.connectionFactory;
        this.orchestratorVersion = i;
        this.testPlatformMigration = builder.testPlatformMigration;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ConnectionFactory connectionFactory;
        private String orchestratorService;
        private String testDiscoveryService;
        private String testRunEventService;
        boolean isPrimaryInstProcess = true;
        boolean testDiscoveryRequested = false;
        boolean testRunEventsRequested = false;
        boolean testPlatformMigration = false;

        @NonNull
        public Builder setPrimaryInstProcess(boolean z) {
            this.isPrimaryInstProcess = z;
            return this;
        }

        @NonNull
        public Builder setOrchestratorService(@Nullable String str) {
            this.orchestratorService = str;
            return this;
        }

        @NonNull
        public Builder setTestDiscoveryRequested(boolean z) {
            this.testDiscoveryRequested = z;
            return this;
        }

        @NonNull
        public Builder setTestRunEventsRequested(boolean z) {
            this.testRunEventsRequested = z;
            return this;
        }

        @NonNull
        public Builder setTestPlatformMigration(boolean z) {
            this.testPlatformMigration = z;
            return this;
        }

        @NonNull
        public Builder setTestDiscoveryService(@Nullable String str) {
            this.testDiscoveryService = str;
            return this;
        }

        @NonNull
        public Builder setTestRunEventService(@Nullable String str) {
            this.testRunEventService = str;
            return this;
        }

        @NonNull
        public Builder setConnectionFactory(@Nullable ConnectionFactory connectionFactory) {
            this.connectionFactory = connectionFactory;
            return this;
        }

        @NonNull
        public TestEventClientArgs build() {
            String str = this.testDiscoveryService;
            int i = 2;
            if (str != null && !str.isEmpty()) {
                this.testDiscoveryRequested = true;
                this.testRunEventsRequested = false;
            } else {
                String str2 = this.testRunEventService;
                if (str2 != null && !str2.isEmpty()) {
                    this.testRunEventsRequested = true;
                    this.testDiscoveryRequested = false;
                } else {
                    String str3 = this.orchestratorService;
                    if (str3 != null) {
                        if (this.connectionFactory == null) {
                            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 96);
                            sb.append("Orchestrator service [");
                            sb.append(str3);
                            sb.append("] argument given, but no connectionFactory was provided for the v1 service");
                            Log.w("TestEventClient", sb.toString());
                        } else if (this.testDiscoveryRequested || this.testRunEventsRequested) {
                            i = 1;
                        } else {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + PublicKeyAlgorithmTags.EXPERIMENTAL_4);
                            sb2.append("Orchestrator service [");
                            sb2.append(str3);
                            sb2.append("] argument given, but neither test discovery nor run event services was requested");
                            Log.w("TestEventClient", sb2.toString());
                        }
                    } else {
                        Log.v("TestEventClient", "No service name argument was given (testDiscoveryService, testRunEventService or orchestratorService)");
                        this.testDiscoveryRequested = false;
                        this.testRunEventsRequested = false;
                    }
                    i = 0;
                }
            }
            if (this.testDiscoveryRequested && this.testRunEventsRequested) {
                Log.w("TestEventClient", "Can't use both the test discovery and run event services simultaneously");
                this.testRunEventsRequested = false;
            }
            if (i > 0) {
                StringBuilder sb3 = new StringBuilder(39);
                sb3.append("Connecting to Orchestrator v");
                sb3.append(i);
                Log.v("TestEventClient", sb3.toString());
            }
            return new TestEventClientArgs(i > 0, i, this);
        }
    }
}
