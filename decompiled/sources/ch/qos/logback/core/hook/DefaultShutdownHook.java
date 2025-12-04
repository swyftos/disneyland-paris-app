package ch.qos.logback.core.hook;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.util.Duration;

/* loaded from: classes2.dex */
public class DefaultShutdownHook extends ShutdownHookBase {
    public static final Duration DEFAULT_DELAY = Duration.buildByMilliseconds(AudioStats.AUDIO_AMPLITUDE_NONE);
    private Duration delay = DEFAULT_DELAY;

    public Duration getDelay() {
        return this.delay;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        if (this.delay.getMilliseconds() > 0) {
            addInfo("Sleeping for " + this.delay);
            try {
                Thread.sleep(this.delay.getMilliseconds());
            } catch (InterruptedException unused) {
            }
        }
        super.stop();
    }

    public void setDelay(Duration duration) {
        this.delay = duration;
    }
}
