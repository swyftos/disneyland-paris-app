package com.brentvatne.common.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/brentvatne/common/api/ViewType;", "", "<init>", "()V", "VIEW_TYPE_TEXTURE", "", "VIEW_TYPE_SURFACE", "VIEW_TYPE_SURFACE_SECURE", "ViewType", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewType {

    @NotNull
    public static final ViewType INSTANCE = new ViewType();
    public static final int VIEW_TYPE_SURFACE = 1;
    public static final int VIEW_TYPE_SURFACE_SECURE = 2;
    public static final int VIEW_TYPE_TEXTURE = 0;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/brentvatne/common/api/ViewType$ViewType;", "", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.brentvatne.common.api.ViewType$ViewType, reason: collision with other inner class name */
    public @interface InterfaceC0033ViewType {
    }

    private ViewType() {
    }
}
