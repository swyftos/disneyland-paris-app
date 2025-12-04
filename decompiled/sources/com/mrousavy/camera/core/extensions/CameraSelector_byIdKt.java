package com.mrousavy.camera.core.extensions;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"byId", "Landroidx/camera/core/CameraSelector$Builder;", "id", "", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraSelector+byId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraSelector+byId.kt\ncom/mrousavy/camera/core/extensions/CameraSelector_byIdKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,9:1\n774#2:10\n865#2,2:11\n*S KotlinDebug\n*F\n+ 1 CameraSelector+byId.kt\ncom/mrousavy/camera/core/extensions/CameraSelector_byIdKt\n*L\n7#1:10\n7#1:11,2\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraSelector_byIdKt {
    @NotNull
    public static final CameraSelector.Builder byId(@NotNull CameraSelector.Builder builder, @NotNull final String id) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        CameraSelector.Builder builderAddCameraFilter = builder.addCameraFilter(new CameraFilter() { // from class: com.mrousavy.camera.core.extensions.CameraSelector_byIdKt$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
                return CameraSelector_byIdKt.byId$lambda$1(id, list);
            }
        });
        Intrinsics.checkNotNullExpressionValue(builderAddCameraFilter, "addCameraFilter(...)");
        return builderAddCameraFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List byId$lambda$1(String str, List cameraInfos) {
        Intrinsics.checkNotNullParameter(cameraInfos, "cameraInfos");
        ArrayList arrayList = new ArrayList();
        for (Object obj : cameraInfos) {
            CameraInfo cameraInfo = (CameraInfo) obj;
            Intrinsics.checkNotNull(cameraInfo);
            if (Intrinsics.areEqual(CameraInfo_idKt.getId(cameraInfo), str)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }
}
