package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
interface MapWithDefault extends Map, KMappedMarker {
    Map getMap();

    Object getOrImplicitDefault(Object obj);
}
