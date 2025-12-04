package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.MediaInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.property.MediaType;
import com.urbanairship.android.layout.view.MediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001&B-\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\"\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0002H\u0010¢\u0006\u0002\b%R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/urbanairship/android/layout/model/MediaModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/MediaView;", "Lcom/urbanairship/android/layout/info/MediaInfo;", "Lcom/urbanairship/android/layout/model/MediaModel$Listener;", "viewInfo", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/MediaInfo;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "isPlayableMedia", "", "isShrinkable", "isShrinkable$urbanairship_layout_release", "()Z", "setShrinkable$urbanairship_layout_release", "(Z)V", "mediaViewId", "", "getMediaViewId", "()I", "getPagerState", "()Lcom/urbanairship/android/layout/environment/SharedState;", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "", "view", "onViewAttached$urbanairship_layout_release", "Listener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMediaModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaModel.kt\ncom/urbanairship/android/layout/model/MediaModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
/* loaded from: classes5.dex */
public final class MediaModel extends BaseModel<MediaView, MediaInfo, Listener> {
    private final boolean isPlayableMedia;
    private boolean isShrinkable;
    private final int mediaViewId;
    private final SharedState pagerState;

    @Nullable
    public final SharedState<State.Pager> getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaModel(@NotNull MediaInfo viewInfo, @Nullable SharedState<State.Pager> sharedState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.pagerState = sharedState;
        this.mediaViewId = View.generateViewId();
        MediaType mediaType = viewInfo.getMediaType();
        this.isPlayableMedia = mediaType == MediaType.VIDEO || mediaType == MediaType.YOUTUBE || mediaType == MediaType.VIMEO;
        this.isShrinkable = true;
    }

    public final int getMediaViewId() {
        return this.mediaViewId;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/MediaModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "onPause", "", "onResume", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void onPause();

        void onResume();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStateUpdated(@NotNull Listener listener, @NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Listener.super.onStateUpdated(state);
            }
        }
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    /* renamed from: isShrinkable$urbanairship_layout_release, reason: from getter */
    public boolean getIsShrinkable() {
        return this.isShrinkable;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void setShrinkable$urbanairship_layout_release(boolean z) {
        this.isShrinkable = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public MediaView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        MediaView mediaView = new MediaView(context, this, viewEnvironment, itemProperties);
        mediaView.setId(getViewId());
        return mediaView;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull MediaView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (EventHandlerKt.hasTapHandler(getViewInfo().getEventHandlers())) {
            BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new MediaModel$onViewAttached$1(view, this, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new MediaModel$onViewAttached$2(this, null), 3, null);
    }
}
