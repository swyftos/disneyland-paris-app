package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EncoderRegistry {
    private final List encoders = new ArrayList();

    @Nullable
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> cls) {
        for (Entry entry : this.encoders) {
            if (entry.handles(cls)) {
                return entry.encoder;
            }
        }
        return null;
    }

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.encoders.add(new Entry(cls, encoder));
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.encoders.add(0, new Entry(cls, encoder));
    }

    private static final class Entry {
        private final Class dataClass;
        final Encoder encoder;

        Entry(Class cls, Encoder encoder) {
            this.dataClass = cls;
            this.encoder = encoder;
        }

        boolean handles(Class cls) {
            return this.dataClass.isAssignableFrom(cls);
        }
    }
}
