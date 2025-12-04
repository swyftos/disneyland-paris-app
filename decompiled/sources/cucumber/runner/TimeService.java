package cucumber.runner;

/* loaded from: classes5.dex */
public interface TimeService {
    public static final TimeService SYSTEM = new TimeService() { // from class: cucumber.runner.TimeService.1
        @Override // cucumber.runner.TimeService
        public long time() {
            return System.nanoTime();
        }

        @Override // cucumber.runner.TimeService
        public long timeMillis() {
            return System.currentTimeMillis();
        }
    };

    long time();

    long timeMillis();
}
