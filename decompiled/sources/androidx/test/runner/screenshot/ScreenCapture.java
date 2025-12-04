package androidx.test.runner.screenshot;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public final class ScreenCapture {
    private static final Bitmap.CompressFormat DEFAULT_FORMAT = Bitmap.CompressFormat.PNG;
    private final Bitmap bitmap;
    private String filename;
    private ScreenCaptureProcessor defaultProcessor = new BasicScreenCaptureProcessor();
    private Set processorSet = new HashSet();
    private Bitmap.CompressFormat format = DEFAULT_FORMAT;

    ScreenCapture(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getName() {
        return this.filename;
    }

    public Bitmap.CompressFormat getFormat() {
        return this.format;
    }

    public ScreenCapture setName(String str) {
        this.filename = str;
        return this;
    }

    public ScreenCapture setFormat(Bitmap.CompressFormat compressFormat) {
        this.format = compressFormat;
        return this;
    }

    ScreenCapture setProcessors(Set set) {
        this.processorSet = (Set) Checks.checkNotNull(set);
        return this;
    }

    Set getProcessors() {
        return this.processorSet;
    }

    public void process() throws IOException {
        process(this.processorSet);
    }

    public void process(@NonNull Set<ScreenCaptureProcessor> set) throws IOException {
        Checks.checkNotNull(set);
        if (set.isEmpty()) {
            this.defaultProcessor.process(this);
            return;
        }
        Iterator<ScreenCaptureProcessor> it = set.iterator();
        while (it.hasNext()) {
            it.next().process(this);
        }
    }

    public int hashCode() {
        Bitmap bitmap = this.bitmap;
        int iHashCode = bitmap != null ? 37 + bitmap.hashCode() : 1;
        Bitmap.CompressFormat compressFormat = this.format;
        if (compressFormat != null) {
            iHashCode = (iHashCode * 37) + compressFormat.hashCode();
        }
        String str = this.filename;
        if (str != null) {
            iHashCode = (iHashCode * 37) + str.hashCode();
        }
        return !this.processorSet.isEmpty() ? (iHashCode * 37) + this.processorSet.hashCode() : iHashCode;
    }

    public boolean equals(Object obj) {
        boolean zSameAs;
        boolean zEquals;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ScreenCapture)) {
            return false;
        }
        ScreenCapture screenCapture = (ScreenCapture) obj;
        if (this.bitmap == null) {
            zSameAs = screenCapture.getBitmap() == null;
        } else {
            zSameAs = getBitmap().sameAs(screenCapture.getBitmap());
        }
        String str = this.filename;
        if (str == null) {
            zEquals = screenCapture.getName() == null;
        } else {
            zEquals = str.equals(screenCapture.getName());
        }
        Bitmap.CompressFormat compressFormat = this.format;
        if (compressFormat == null) {
            zEquals2 = screenCapture.getFormat() == null;
        } else {
            zEquals2 = compressFormat.equals(screenCapture.getFormat());
        }
        return zSameAs && zEquals && zEquals2 && this.processorSet.containsAll(screenCapture.getProcessors()) && screenCapture.getProcessors().containsAll(this.processorSet);
    }
}
