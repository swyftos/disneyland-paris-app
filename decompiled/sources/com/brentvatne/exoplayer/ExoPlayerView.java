package com.brentvatne.exoplayer;

import android.R;
import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.SubtitleView;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.api.ViewType;
import com.brentvatne.common.toolbox.DebugLog;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0002>?B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020!J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u001cJ\u0010\u0010)\u001a\u00020#2\b\b\u0001\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010.\u001a\u00020#J\u0006\u0010/\u001a\u00020#J\u0006\u00100\u001a\u00020#J\b\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u001cJ\u000e\u00107\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u0019J\u0012\u0010:\u001a\u00020#2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0006\u0010=\u001a\u00020#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010-R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/brentvatne/exoplayer/ExoPlayerView;", "Landroid/widget/FrameLayout;", "Landroidx/media3/common/AdViewProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Landroid/view/View;", "surfaceView", "getSurfaceView", "()Landroid/view/View;", "shutterView", "subtitleLayout", "Landroidx/media3/ui/SubtitleView;", "layout", "Lcom/brentvatne/exoplayer/AspectRatioFrameLayout;", "componentListener", "Lcom/brentvatne/exoplayer/ExoPlayerView$ComponentListener;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "adOverlayFrameLayout", "isPlaying", "", "()Z", "viewType", "", "getViewType$annotations", "()V", "hideShutterView", "localStyle", "Lcom/brentvatne/common/api/SubtitleStyle;", "clearVideoView", "", "setVideoView", "setSubtitleStyle", "style", "setShutterColor", "color", "updateSurfaceView", "adsShown", "getAdsShown", "setAdsShown", "(Z)V", "showAds", "hideAds", "updateShutterViewVisibility", "requestLayout", "getAdViewGroup", "Landroid/view/ViewGroup;", "setPlayer", "setResizeMode", ViewProps.RESIZE_MODE, "setHideShutterView", "measureAndLayout", "Ljava/lang/Runnable;", "updateForCurrentTrackSelections", "tracks", "Landroidx/media3/common/Tracks;", "invalidateAspectRatio", "ComponentListener", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@UnstableApi
/* loaded from: classes2.dex */
public final class ExoPlayerView extends FrameLayout implements AdViewProvider {
    private FrameLayout adOverlayFrameLayout;
    private boolean adsShown;
    private ComponentListener componentListener;
    private final Context context;
    private boolean hideShutterView;
    private AspectRatioFrameLayout layout;
    private ViewGroup.LayoutParams layoutParams;
    private SubtitleStyle localStyle;
    private final Runnable measureAndLayout;
    private ExoPlayer player;
    private View shutterView;
    private SubtitleView subtitleLayout;
    private View surfaceView;
    private int viewType;

    @ViewType.InterfaceC0033ViewType
    private static /* synthetic */ void getViewType$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoPlayerView(@NotNull Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.viewType = 1;
        this.localStyle = new SubtitleStyle();
        this.componentListener = new ComponentListener();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(context);
        this.layout = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setLayoutParams(layoutParams);
        View view = new View(context);
        this.shutterView = view;
        view.setLayoutParams(this.layoutParams);
        this.shutterView.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
        SubtitleView subtitleView = new SubtitleView(context);
        this.subtitleLayout = subtitleView;
        subtitleView.setLayoutParams(this.layoutParams);
        this.subtitleLayout.setUserDefaultStyle();
        this.subtitleLayout.setUserDefaultTextSize();
        updateSurfaceView(this.viewType);
        this.layout.addView(this.shutterView, 1, this.layoutParams);
        if (this.localStyle.getSubtitlesFollowVideo()) {
            this.layout.addView(this.subtitleLayout, this.layoutParams);
        }
        addViewInLayout(this.layout, 0, layoutParams);
        if (!this.localStyle.getSubtitlesFollowVideo()) {
            addViewInLayout(this.subtitleLayout, 1, this.layoutParams);
        }
        this.measureAndLayout = new Runnable() { // from class: com.brentvatne.exoplayer.ExoPlayerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerView.measureAndLayout$lambda$0(this.f$0);
            }
        };
    }

    @Nullable
    public final View getSurfaceView() {
        return this.surfaceView;
    }

    public final boolean isPlaying() {
        ExoPlayer exoPlayer = this.player;
        return (exoPlayer == null || exoPlayer == null || !exoPlayer.isPlaying()) ? false : true;
    }

    private final void clearVideoView() {
        View view = this.surfaceView;
        if (view instanceof TextureView) {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.clearVideoTextureView((TextureView) view);
                return;
            }
            return;
        }
        if (view instanceof SurfaceView) {
            ExoPlayer exoPlayer2 = this.player;
            if (exoPlayer2 != null) {
                exoPlayer2.clearVideoSurfaceView((SurfaceView) view);
                return;
            }
            return;
        }
        Log.w("clearVideoView", "Unexpected surfaceView type: " + (view != null ? view.getClass().getName() : null));
    }

    private final void setVideoView() {
        View view = this.surfaceView;
        if (view instanceof TextureView) {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.setVideoTextureView((TextureView) view);
                return;
            }
            return;
        }
        if (view instanceof SurfaceView) {
            ExoPlayer exoPlayer2 = this.player;
            if (exoPlayer2 != null) {
                exoPlayer2.setVideoSurfaceView((SurfaceView) view);
                return;
            }
            return;
        }
        Log.w("setVideoView", "Unexpected surfaceView type: " + (view != null ? view.getClass().getName() : null));
    }

    public final void setSubtitleStyle(@NotNull SubtitleStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.subtitleLayout.setUserDefaultStyle();
        this.subtitleLayout.setUserDefaultTextSize();
        if (style.getFontSize() > 0) {
            this.subtitleLayout.setFixedTextSize(2, style.getFontSize());
        }
        this.subtitleLayout.setPadding(style.getPaddingLeft(), style.getPaddingTop(), style.getPaddingTop(), style.getPaddingBottom());
        if (style.getOpacity() != BitmapDescriptorFactory.HUE_RED) {
            this.subtitleLayout.setAlpha(style.getOpacity());
            this.subtitleLayout.setVisibility(0);
        } else {
            this.subtitleLayout.setVisibility(8);
        }
        if (this.localStyle.getSubtitlesFollowVideo() != style.getSubtitlesFollowVideo()) {
            if (style.getSubtitlesFollowVideo()) {
                removeViewInLayout(this.subtitleLayout);
                this.layout.addView(this.subtitleLayout, this.layoutParams);
            } else {
                this.layout.removeViewInLayout(this.subtitleLayout);
                addViewInLayout(this.subtitleLayout, 1, this.layoutParams, false);
            }
            requestLayout();
        }
        this.localStyle = style;
    }

    public final void setShutterColor(int color) {
        this.shutterView.setBackgroundColor(color);
    }

    public final void updateSurfaceView(@ViewType.InterfaceC0033ViewType int viewType) {
        boolean z;
        this.viewType = viewType;
        if (viewType == 0) {
            if (this.surfaceView instanceof TextureView) {
                z = false;
            } else {
                this.surfaceView = new TextureView(this.context);
            }
            View view = this.surfaceView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.TextureView");
            ((TextureView) view).setOpaque(false);
            z = z;
        } else if (viewType == 1 || viewType == 2) {
            if (this.surfaceView instanceof SurfaceView) {
                z = false;
            } else {
                this.surfaceView = new SurfaceView(this.context);
                z = true;
            }
            View view2 = this.surfaceView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.SurfaceView");
            ((SurfaceView) view2).setSecure(viewType == 2);
        } else {
            DebugLog.wtf("ExoPlayerView", "Unexpected texture view type: " + viewType);
            z = false;
        }
        if (z) {
            View view3 = this.surfaceView;
            if (view3 != null) {
                view3.setLayoutParams(this.layoutParams);
            }
            if (this.layout.getChildAt(0) != null) {
                this.layout.removeViewAt(0);
            }
            this.layout.addView(this.surfaceView, 0, this.layoutParams);
            if (this.player != null) {
                setVideoView();
            }
        }
    }

    public final boolean getAdsShown() {
        return this.adsShown;
    }

    public final void setAdsShown(boolean z) {
        this.adsShown = z;
    }

    public final void showAds() {
        if (this.adsShown) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.context);
        this.adOverlayFrameLayout = frameLayout;
        this.layout.addView(frameLayout, this.layoutParams);
        this.adsShown = true;
    }

    public final void hideAds() {
        if (this.adsShown) {
            this.layout.removeView(this.adOverlayFrameLayout);
            this.adOverlayFrameLayout = null;
            this.adsShown = false;
        }
    }

    public final void updateShutterViewVisibility() {
        this.shutterView.setVisibility(this.hideShutterView ? 4 : 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    @Override // androidx.media3.common.AdViewProvider
    @NotNull
    public ViewGroup getAdViewGroup() {
        Object objCheckNotNull = Assertions.checkNotNull(this.adOverlayFrameLayout, "exo_ad_overlay must be present for ad playback");
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
        return (ViewGroup) objCheckNotNull;
    }

    public final void setPlayer(@Nullable ExoPlayer player) {
        if (Intrinsics.areEqual(this.player, player)) {
            return;
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            Intrinsics.checkNotNull(exoPlayer);
            exoPlayer.removeListener(this.componentListener);
            clearVideoView();
        }
        this.player = player;
        updateShutterViewVisibility();
        if (player != null) {
            setVideoView();
            player.addListener(this.componentListener);
        }
    }

    public final void setResizeMode(int resizeMode) {
        if (this.layout.getResizeMode() != resizeMode) {
            this.layout.setResizeMode(resizeMode);
            post(this.measureAndLayout);
        }
    }

    public final void setHideShutterView(boolean hideShutterView) {
        this.hideShutterView = hideShutterView;
        updateShutterViewVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void measureAndLayout$lambda$0(ExoPlayerView exoPlayerView) {
        exoPlayerView.measure(View.MeasureSpec.makeMeasureSpec(exoPlayerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(exoPlayerView.getHeight(), 1073741824));
        exoPlayerView.layout(exoPlayerView.getLeft(), exoPlayerView.getTop(), exoPlayerView.getRight(), exoPlayerView.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateForCurrentTrackSelections(Tracks tracks) {
        if (tracks == null) {
            return;
        }
        ImmutableList<Tracks.Group> groups = tracks.getGroups();
        Intrinsics.checkNotNullExpressionValue(groups, "getGroups(...)");
        UnmodifiableIterator<Tracks.Group> it = groups.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Tracks.Group next = it.next();
            if (next.getType() == 2 && next.length > 0) {
                Format trackFormat = next.getTrackFormat(0);
                Intrinsics.checkNotNullExpressionValue(trackFormat, "getTrackFormat(...)");
                if (trackFormat.width > 0 || trackFormat.height > 0) {
                    this.layout.updateAspectRatio(trackFormat);
                    return;
                }
                return;
            }
        }
        updateShutterViewVisibility();
    }

    public final void invalidateAspectRatio() {
        this.layout.invalidateAspectRatio();
    }

    private final class ComponentListener implements Player.Listener {
        public ComponentListener() {
        }

        @Override // androidx.media3.common.Player.Listener
        public void onCues(List cues) {
            Intrinsics.checkNotNullParameter(cues, "cues");
            ExoPlayerView.this.subtitleLayout.setCues(cues);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVideoSizeChanged(VideoSize videoSize) {
            ExoPlayer exoPlayer;
            Intrinsics.checkNotNullParameter(videoSize, "videoSize");
            if (videoSize.height == 0 || videoSize.width == 0 || (exoPlayer = ExoPlayerView.this.player) == null) {
                return;
            }
            ExoPlayerView.this.updateForCurrentTrackSelections(exoPlayer.getCurrentTracks());
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRenderedFirstFrame() {
            ExoPlayerView.this.shutterView.setVisibility(4);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTracksChanged(Tracks tracks) {
            Intrinsics.checkNotNullParameter(tracks, "tracks");
            ExoPlayerView.this.updateForCurrentTrackSelections(tracks);
        }
    }
}
