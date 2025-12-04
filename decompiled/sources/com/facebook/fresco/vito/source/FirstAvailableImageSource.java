package com.facebook.fresco.vito.source;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J \u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/facebook/fresco/vito/source/FirstAvailableImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "imageSources", "", "<init>", "([Lcom/facebook/fresco/vito/source/ImageSource;)V", "getImageSources", "()[Lcom/facebook/fresco/vito/source/ImageSource;", "[Lcom/facebook/fresco/vito/source/ImageSource;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "component1", "copy", "([Lcom/facebook/fresco/vito/source/ImageSource;)Lcom/facebook/fresco/vito/source/FirstAvailableImageSource;", "toString", "", "source_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FirstAvailableImageSource implements ImageSource {
    private final ImageSource[] imageSources;

    public static /* synthetic */ FirstAvailableImageSource copy$default(FirstAvailableImageSource firstAvailableImageSource, ImageSource[] imageSourceArr, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSourceArr = firstAvailableImageSource.imageSources;
        }
        return firstAvailableImageSource.copy(imageSourceArr);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ImageSource[] getImageSources() {
        return this.imageSources;
    }

    @NotNull
    public final FirstAvailableImageSource copy(@NotNull ImageSource[] imageSources) {
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        return new FirstAvailableImageSource(imageSources);
    }

    @NotNull
    public String toString() {
        return "FirstAvailableImageSource(imageSources=" + Arrays.toString(this.imageSources) + ")";
    }

    public FirstAvailableImageSource(@NotNull ImageSource[] imageSources) {
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        this.imageSources = imageSources;
    }

    @NotNull
    public final ImageSource[] getImageSources() {
        return this.imageSources;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(FirstAvailableImageSource.class, other != null ? other.getClass() : null)) {
            return false;
        }
        ImageSource[] imageSourceArr = this.imageSources;
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.fresco.vito.source.FirstAvailableImageSource");
        return Arrays.equals(imageSourceArr, ((FirstAvailableImageSource) other).imageSources);
    }

    public int hashCode() {
        return Arrays.hashCode(this.imageSources);
    }
}
