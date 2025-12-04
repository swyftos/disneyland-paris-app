package com.brentvatne.exoplayer;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/brentvatne/exoplayer/AudioOutput;", "", "outputName", "", "streamType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getStreamType", "()I", "SPEAKER", "EARPIECE", "toString", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"InlinedApi"})
/* loaded from: classes2.dex */
public final class AudioOutput {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudioOutput[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String outputName;
    private final int streamType;
    public static final AudioOutput SPEAKER = new AudioOutput("SPEAKER", 0, "speaker", 3);
    public static final AudioOutput EARPIECE = new AudioOutput("EARPIECE", 1, "earpiece", 0);

    private static final /* synthetic */ AudioOutput[] $values() {
        return new AudioOutput[]{SPEAKER, EARPIECE};
    }

    @JvmStatic
    @NotNull
    public static final AudioOutput get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    @NotNull
    public static EnumEntries<AudioOutput> getEntries() {
        return $ENTRIES;
    }

    private AudioOutput(String str, int i, String str2, int i2) {
        this.outputName = str2;
        this.streamType = i2;
    }

    public final int getStreamType() {
        return this.streamType;
    }

    static {
        AudioOutput[] audioOutputArr$values = $values();
        $VALUES = audioOutputArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(audioOutputArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/brentvatne/exoplayer/AudioOutput$Companion;", "", "<init>", "()V", "get", "Lcom/brentvatne/exoplayer/AudioOutput;", "name", "", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final AudioOutput get(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            for (AudioOutput audioOutput : AudioOutput.values()) {
                if (StringsKt.equals(audioOutput.outputName, name, true)) {
                    return audioOutput;
                }
            }
            return AudioOutput.SPEAKER;
        }
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return AudioOutput.class.getSimpleName() + "(" + this.outputName + ", " + this.streamType + ")";
    }

    public static AudioOutput valueOf(String str) {
        return (AudioOutput) Enum.valueOf(AudioOutput.class, str);
    }

    public static AudioOutput[] values() {
        return (AudioOutput[]) $VALUES.clone();
    }
}
