package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface EncoderFactory {
    @NonNull
    Encoder createEncoder(@NonNull Executor executor, @NonNull EncoderConfig encoderConfig) throws InvalidConfigException;
}
