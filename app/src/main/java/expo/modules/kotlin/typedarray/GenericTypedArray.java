package expo.modules.kotlin.typedarray;

import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u000bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002¨\u0006\u000e"}, m1836d2 = {"Lexpo/modules/kotlin/typedarray/GenericTypedArray;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/typedarray/TypedArray;", "", "get", ArrayContainsMatcher.INDEX_KEY, "", "(I)Ljava/lang/Object;", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "value", "(ILjava/lang/Object;)V", "iterator", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface GenericTypedArray<T> extends TypedArray, Iterable<T>, KMappedMarker {
    T get(int index);

    @Override // java.lang.Iterable
    @NotNull
    Iterator<T> iterator();

    void set(int index, T value);

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static <T> Iterator<T> iterator(@NotNull GenericTypedArray<T> genericTypedArray) {
            return new TypedArrayIterator(genericTypedArray);
        }
    }
}
