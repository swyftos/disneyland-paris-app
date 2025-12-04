package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
interface MapWithDefault extends Map, KMappedMarker {
    Map getMap();

    Object getOrImplicitDefault(Object obj);
}
