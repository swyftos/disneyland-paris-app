package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes4.dex */
interface MutableMapWithDefault extends Map, MapWithDefault, KMutableMap {
    @Override // kotlin.collections.MapWithDefault
    Map getMap();
}
