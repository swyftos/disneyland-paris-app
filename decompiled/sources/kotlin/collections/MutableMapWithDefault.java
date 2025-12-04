package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes5.dex */
interface MutableMapWithDefault extends Map, MapWithDefault, KMutableMap {
    @Override // kotlin.collections.MapWithDefault
    Map getMap();
}
