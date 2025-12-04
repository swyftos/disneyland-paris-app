package com.brentvatne.exoplayer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.PictureInPictureParams;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashUtil;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.ima.ImaAdsLoader;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MergingMediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.util.EventLogger;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.session.MediaSessionService;
import androidx.media3.ui.LegacyPlayerControlView;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.brentvatne.common.api.AdsProps;
import com.brentvatne.common.api.BufferConfig;
import com.brentvatne.common.api.BufferingStrategy;
import com.brentvatne.common.api.ControlsConfig;
import com.brentvatne.common.api.DRMProps;
import com.brentvatne.common.api.SideLoadedTextTrack;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.api.TimedMetadata;
import com.brentvatne.common.api.Track;
import com.brentvatne.common.api.VideoTrack;
import com.brentvatne.common.react.VideoEventEmitter;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.react.R;
import com.brentvatne.react.ReactNativeVideoManager;
import com.brentvatne.receiver.AudioBecomingNoisyReceiver;
import com.brentvatne.receiver.BecomingNoisyListener;
import com.brentvatne.receiver.PictureInPictureReceiver;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.collect.ImmutableList;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class ReactExoplayerView extends FrameLayout implements LifecycleEventListener, Player.Listener, BandwidthMeter.EventListener, BecomingNoisyListener, DrmSessionEventListener, AdEvent.AdEventListener, AdErrorEvent.AdErrorListener {
    private static final CookieManager DEFAULT_COOKIE_MANAGER;
    public static final double DEFAULT_MAX_HEAP_ALLOCATION_PERCENT = 1.0d;
    public static final double DEFAULT_MIN_BUFFER_MEMORY_RESERVE = 0.0d;
    private ImaAdsLoader adsLoader;
    private final AudioBecomingNoisyReceiver audioBecomingNoisyReceiver;
    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    private final AudioManager audioManager;
    private AudioOutput audioOutput;
    private String audioTrackType;
    private String audioTrackValue;
    private float audioVolume;
    private final DefaultBandwidthMeter bandwidthMeter;
    private BufferingStrategy.BufferingStrategyEnum bufferingStrategy;
    private CmcdConfiguration.Factory cmcdConfigurationFactory;
    private final ReactExoplayerConfig config;
    private boolean controls;
    private ControlsConfig controlsConfig;
    private EventLogger debugEventLogger;
    private boolean disableDisconnectError;
    private boolean disableFocus;
    private boolean enableDebug;
    public boolean enterPictureInPictureOnLeave;
    protected final VideoEventEmitter eventEmitter;
    private Player.Listener eventListener;
    private ExoPlayerView exoPlayerView;
    private boolean focusable;
    private FullScreenPlayerView fullScreenPlayerView;
    private boolean hasAudioFocus;
    private boolean hasDrmFailed;
    private final String instanceId;
    private boolean isBuffering;
    private boolean isFullscreen;
    private boolean isInBackground;
    private boolean isPaused;
    private boolean isSeeking;
    private boolean isUsingContentResolution;
    private long lastBufferDuration;
    private long lastDuration;
    private long lastPos;
    private boolean loadVideoStarted;
    private float mProgressUpdateInterval;
    private boolean mReportBandwidth;
    private final Handler mainHandler;
    private Runnable mainRunnable;
    private int maxBitRate;
    private DataSource.Factory mediaDataSourceFactory;
    private boolean muted;
    private PictureInPictureParams.Builder pictureInPictureParamsBuilder;
    private final PictureInPictureReceiver pictureInPictureReceiver;
    private Runnable pipListenerUnsubscribe;
    protected boolean playInBackground;
    private View playPauseControlContainer;
    private PlaybackServiceBinder playbackServiceBinder;
    private ServiceConnection playbackServiceConnection;
    private ExoPlayer player;
    private LegacyPlayerControlView playerControlView;
    private boolean playerNeedsSource;
    private boolean preventsDisplaySleepDuringVideoPlayback;
    private final Handler progressHandler;
    private float rate;
    private boolean repeat;
    private long resumePosition;
    private int resumeWindow;
    private ArrayList rootViewChildrenOriginalVisibility;
    private long seekPosition;
    private boolean selectTrackWhenReady;
    private int selectedSpeedIndex;
    private boolean showNotificationControls;
    private Source source;
    private String textTrackType;
    private String textTrackValue;
    private final ThemedReactContext themedReactContext;
    private DefaultTrackSelector trackSelector;
    private boolean useCache;
    private String videoTrackType;
    private String videoTrackValue;
    private boolean viewHasDropped;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DrmSessionManager lambda$buildMediaSource$15(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsLoadingChanged(boolean z) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTimelineChanged(@NonNull Timeline timeline, int i) {
    }

    static {
        CookieManager cookieManager = new CookieManager();
        DEFAULT_COOKIE_MANAGER = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public void setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
        this.cmcdConfigurationFactory = factory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        if (this.player != null) {
            if (this.playerControlView != null && isPlayingAd() && this.controls) {
                this.playerControlView.hide();
            }
            long bufferedPercentage = (this.player.getBufferedPercentage() * this.player.getDuration()) / 100;
            long duration = this.player.getDuration();
            long currentPosition = this.player.getCurrentPosition();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            if (this.lastPos == currentPosition && this.lastBufferDuration == bufferedPercentage && this.lastDuration == duration) {
                return;
            }
            this.lastPos = currentPosition;
            this.lastBufferDuration = bufferedPercentage;
            this.lastDuration = duration;
            this.eventEmitter.onVideoProgress.invoke(Long.valueOf(currentPosition), Long.valueOf(bufferedPercentage), Long.valueOf(this.player.getDuration()), Double.valueOf(getPositionInFirstPeriodMsForCurrentWindow(currentPosition)));
        }
    }

    public double getPositionInFirstPeriodMsForCurrentWindow(long j) {
        Timeline.Window window = new Timeline.Window();
        if (!this.player.getCurrentTimeline().isEmpty()) {
            this.player.getCurrentTimeline().getWindow(this.player.getCurrentMediaItemIndex(), window);
        }
        return window.windowStartTimeMs + j;
    }

    public ReactExoplayerView(ThemedReactContext themedReactContext, ReactExoplayerConfig reactExoplayerConfig) {
        super(themedReactContext);
        this.debugEventLogger = null;
        this.enableDebug = false;
        this.muted = false;
        this.enterPictureInPictureOnLeave = false;
        this.hasAudioFocus = false;
        this.rate = 1.0f;
        this.audioOutput = AudioOutput.SPEAKER;
        this.audioVolume = 1.0f;
        this.maxBitRate = 0;
        this.hasDrmFailed = false;
        this.isUsingContentResolution = false;
        this.selectTrackWhenReady = false;
        this.useCache = false;
        this.controlsConfig = new ControlsConfig();
        this.rootViewChildrenOriginalVisibility = new ArrayList();
        this.isSeeking = false;
        this.seekPosition = -1L;
        this.source = new Source();
        this.textTrackType = "disabled";
        this.focusable = true;
        this.preventsDisplaySleepDuringVideoPlayback = true;
        this.mProgressUpdateInterval = 250.0f;
        this.playInBackground = false;
        this.mReportBandwidth = false;
        this.showNotificationControls = false;
        this.lastPos = -1L;
        this.lastBufferDuration = -1L;
        this.lastDuration = -1L;
        this.viewHasDropped = false;
        this.selectedSpeedIndex = 1;
        this.instanceId = String.valueOf(UUID.randomUUID());
        this.progressHandler = new Handler(Looper.getMainLooper()) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    ReactExoplayerView.this.updateProgress();
                    sendMessageDelayed(obtainMessage(1), Math.round(ReactExoplayerView.this.mProgressUpdateInterval));
                }
            }
        };
        this.themedReactContext = themedReactContext;
        this.eventEmitter = new VideoEventEmitter();
        this.config = reactExoplayerConfig;
        this.bandwidthMeter = reactExoplayerConfig.getBandWidthMeter();
        if (this.pictureInPictureParamsBuilder == null) {
            this.pictureInPictureParamsBuilder = new PictureInPictureParams.Builder();
        }
        this.mainHandler = new Handler();
        createViews();
        this.audioManager = (AudioManager) themedReactContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        themedReactContext.addLifecycleEventListener(this);
        this.audioBecomingNoisyReceiver = new AudioBecomingNoisyReceiver(themedReactContext);
        this.audioFocusChangeListener = new OnAudioFocusChangedListener(themedReactContext);
        this.pictureInPictureReceiver = new PictureInPictureReceiver(this, themedReactContext);
    }

    private boolean isPlayingAd() {
        ExoPlayer exoPlayer = this.player;
        return exoPlayer != null && exoPlayer.isPlayingAd();
    }

    private void createViews() {
        CookieHandler cookieHandler = CookieHandler.getDefault();
        CookieManager cookieManager = DEFAULT_COOKIE_MANAGER;
        if (cookieHandler != cookieManager) {
            CookieHandler.setDefault(cookieManager);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ExoPlayerView exoPlayerView = new ExoPlayerView(getContext());
        this.exoPlayerView = exoPlayerView;
        exoPlayerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda7
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$createViews$0(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        this.exoPlayerView.setLayoutParams(layoutParams);
        addView(this.exoPlayerView, 0, layoutParams);
        this.exoPlayerView.setFocusable(this.focusable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createViews$0(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PictureInPictureUtil.applySourceRectHint(this.themedReactContext, this.pictureInPictureParamsBuilder, this.exoPlayerView);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cleanupPlaybackService();
        super.onDetachedFromWindow();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        if (!this.playInBackground || !this.isInBackground) {
            setPlayWhenReady(!this.isPaused);
        }
        this.isInBackground = false;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.isInBackground = true;
        Activity currentActivity = this.themedReactContext.getCurrentActivity();
        int i = Util.SDK_INT;
        boolean z = i >= 24 && currentActivity != null && currentActivity.isInPictureInPictureMode();
        boolean z2 = i >= 24 && currentActivity != null && currentActivity.isInMultiWindowMode();
        if (this.playInBackground || z || z2) {
            return;
        }
        setPlayWhenReady(false);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        cleanUpResources();
    }

    public void cleanUpResources() {
        stopPlayback();
        this.themedReactContext.removeLifecycleEventListener(this);
        releasePlayer();
        this.viewHasDropped = true;
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener
    public void onBandwidthSample(int i, long j, long j2) {
        int i2;
        int i3;
        if (this.mReportBandwidth) {
            ExoPlayer exoPlayer = this.player;
            int i4 = 0;
            if (exoPlayer == null) {
                this.eventEmitter.onVideoBandwidthUpdate.invoke(Long.valueOf(j2), 0, 0, null);
                return;
            }
            Format videoFormat = exoPlayer.getVideoFormat();
            boolean z = videoFormat != null && ((i3 = videoFormat.rotationDegrees) == 90 || i3 == 270);
            if (videoFormat != null) {
                i2 = z ? videoFormat.height : videoFormat.width;
            } else {
                i2 = 0;
            }
            if (videoFormat != null) {
                i4 = z ? videoFormat.width : videoFormat.height;
            }
            this.eventEmitter.onVideoBandwidthUpdate.invoke(Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i2), videoFormat != null ? videoFormat.id : null);
        }
    }

    private void togglePlayerControlVisibility() {
        if (this.player == null) {
            return;
        }
        reLayoutControls();
        if (this.playerControlView.isVisible()) {
            this.playerControlView.hide();
        } else {
            this.playerControlView.show();
        }
    }

    private void initializePlayerControl() {
        if (this.playerControlView == null) {
            LegacyPlayerControlView legacyPlayerControlView = new LegacyPlayerControlView(getContext());
            this.playerControlView = legacyPlayerControlView;
            legacyPlayerControlView.addVisibilityListener(new LegacyPlayerControlView.VisibilityListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView.2
                @Override // androidx.media3.ui.LegacyPlayerControlView.VisibilityListener
                public void onVisibilityChange(int i) {
                    ReactExoplayerView.this.eventEmitter.onControlsVisibilityChange.invoke(Boolean.valueOf(i == 0));
                }
            });
        }
        this.playerControlView.setPlayer(this.player);
        this.playPauseControlContainer = this.playerControlView.findViewById(R.id.exo_play_pause_container);
        InstrumentationCallbacks.setOnClickListenerCalled(this.exoPlayerView, new View.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializePlayerControl$1(view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled((ImageButton) this.playerControlView.findViewById(R.id.exo_play), new View.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializePlayerControl$2(view);
            }
        });
        ImageButton imageButton = (ImageButton) this.playerControlView.findViewById(R.id.exo_rew);
        ImageButton imageButton2 = (ImageButton) this.playerControlView.findViewById(R.id.exo_ffwd);
        InstrumentationCallbacks.setOnClickListenerCalled(imageButton, new View.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializePlayerControl$3(view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled(imageButton2, new View.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializePlayerControl$4(view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled((ImageButton) this.playerControlView.findViewById(R.id.exo_pause), new View.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializePlayerControl$5(view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled((ImageButton) this.playerControlView.findViewById(R.id.exo_settings), new View.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializePlayerControl$6(view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled((ImageButton) this.playerControlView.findViewById(R.id.exo_fullscreen), new View.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initializePlayerControl$7(view);
            }
        });
        updateFullScreenButtonVisibility();
        refreshControlsStyles();
        Player.Listener listener = new Player.Listener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView.3
            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int i) {
                View viewFindViewById = ReactExoplayerView.this.playerControlView.findViewById(R.id.exo_play);
                View viewFindViewById2 = ReactExoplayerView.this.playerControlView.findViewById(R.id.exo_pause);
                if (viewFindViewById != null && viewFindViewById.getVisibility() == 8) {
                    viewFindViewById.setVisibility(4);
                }
                if (viewFindViewById2 != null && viewFindViewById2.getVisibility() == 8) {
                    viewFindViewById2.setVisibility(4);
                }
                ReactExoplayerView reactExoplayerView = ReactExoplayerView.this;
                reactExoplayerView.reLayout(reactExoplayerView.playPauseControlContainer);
                ReactExoplayerView.this.player.removeListener(ReactExoplayerView.this.eventListener);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayWhenReadyChanged(boolean z, int i) {
                ReactExoplayerView reactExoplayerView = ReactExoplayerView.this;
                reactExoplayerView.reLayout(reactExoplayerView.playPauseControlContainer);
                ReactExoplayerView.this.player.removeListener(ReactExoplayerView.this.eventListener);
            }
        };
        this.eventListener = listener;
        this.player.addListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$1(View view) {
        if (isPlayingAd()) {
            return;
        }
        togglePlayerControlVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$2(View view) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null && exoPlayer.getPlaybackState() == 4) {
            this.player.seekTo(0L);
        }
        setPausedModifier(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$3(View view) {
        seekTo(this.player.getCurrentPosition() - this.controlsConfig.getSeekIncrementMS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$4(View view) {
        seekTo(this.player.getCurrentPosition() + this.controlsConfig.getSeekIncrementMS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$5(View view) {
        setPausedModifier(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$6(View view) {
        openSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$7(View view) {
        setFullscreen(!this.isFullscreen);
    }

    private void openSettings() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.themedReactContext);
        builder.setTitle(R.string.settings);
        builder.setItems(new String[]{this.themedReactContext.getString(R.string.playback_speed)}, new DialogInterface.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda21
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$openSettings$8(dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openSettings$8(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            showPlaybackSpeedOptions();
        }
    }

    private void showPlaybackSpeedOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.themedReactContext);
        builder.setTitle(R.string.select_playback_speed);
        builder.setSingleChoiceItems(new String[]{"0.5x", "1.0x", "1.5x", "2.0x"}, this.selectedSpeedIndex, new DialogInterface.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPlaybackSpeedOptions$9(dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPlaybackSpeedOptions$9(DialogInterface dialogInterface, int i) {
        this.selectedSpeedIndex = i;
        setRateModifier(i != 0 ? i != 2 ? i != 3 ? 1.0f : 2.0f : 1.5f : 0.5f);
    }

    private void addPlayerControl() {
        if (this.playerControlView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.playerControlView.setLayoutParams(layoutParams);
        int iIndexOfChild = indexOfChild(this.playerControlView);
        if (iIndexOfChild != -1) {
            removeViewAt(iIndexOfChild);
        }
        addView(this.playerControlView, 1, layoutParams);
        reLayout(this.playerControlView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reLayout(View view) {
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private void refreshControlsStyles() {
        if (this.playerControlView == null || this.player == null || !this.controls) {
            return;
        }
        updateLiveContent();
        updatePlayPauseButtons();
        updateButtonVisibility(this.controlsConfig.getHideForward(), R.id.exo_ffwd);
        updateButtonVisibility(this.controlsConfig.getHideRewind(), R.id.exo_rew);
        updateButtonVisibility(this.controlsConfig.getHideNext(), R.id.exo_next);
        updateButtonVisibility(this.controlsConfig.getHidePrevious(), R.id.exo_prev);
        updateViewVisibility(this.playerControlView.findViewById(R.id.exo_fullscreen), this.controlsConfig.getHideFullscreen(), 8);
        updateViewVisibility(this.playerControlView.findViewById(R.id.exo_position), this.controlsConfig.getHidePosition(), 8);
        updateViewVisibility(this.playerControlView.findViewById(R.id.exo_progress), this.controlsConfig.getHideSeekBar(), 4);
        updateViewVisibility(this.playerControlView.findViewById(R.id.exo_duration), this.controlsConfig.getHideDuration(), 8);
        updateViewVisibility(this.playerControlView.findViewById(R.id.exo_settings), this.controlsConfig.getHideSettingButton(), 8);
    }

    private void updateLiveContent() {
        boolean zIsLive;
        LinearLayout linearLayout = (LinearLayout) this.playerControlView.findViewById(R.id.exo_live_container);
        TextView textView = (TextView) this.playerControlView.findViewById(R.id.exo_live_label);
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            zIsLive = false;
        } else {
            Timeline.Window window = new Timeline.Window();
            currentTimeline.getWindow(this.player.getCurrentMediaItemIndex(), window);
            zIsLive = window.isLive();
        }
        if (zIsLive && this.controlsConfig.getLiveLabel() != null) {
            textView.setText(this.controlsConfig.getLiveLabel());
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    private void updatePlayPauseButtons() {
        ImageButton imageButton = (ImageButton) this.playerControlView.findViewById(R.id.exo_play);
        ImageButton imageButton2 = (ImageButton) this.playerControlView.findViewById(R.id.exo_pause);
        if (this.controlsConfig.getHidePlayPause()) {
            this.playPauseControlContainer.setAlpha(BitmapDescriptorFactory.HUE_RED);
            imageButton.setClickable(false);
            imageButton2.setClickable(false);
        } else {
            this.playPauseControlContainer.setAlpha(1.0f);
            imageButton.setClickable(true);
            imageButton2.setClickable(true);
        }
    }

    private void updateButtonVisibility(boolean z, int i) {
        ImageButton imageButton = (ImageButton) this.playerControlView.findViewById(i);
        if (z) {
            imageButton.setImageAlpha(0);
            imageButton.setClickable(false);
        } else {
            imageButton.setImageAlpha(255);
            imageButton.setClickable(true);
        }
    }

    private void updateViewVisibility(View view, boolean z, int i) {
        if (z) {
            view.setVisibility(i);
        } else if (view.getVisibility() == i) {
            view.setVisibility(0);
        }
    }

    private void reLayoutControls() {
        reLayout(this.exoPlayerView);
        reLayout(this.playerControlView);
    }

    public boolean isUsingVideoABR() {
        String str = this.videoTrackType;
        return str == null || "auto".equals(str);
    }

    public void setDebug(boolean z) {
        this.enableDebug = z;
        refreshDebugState();
    }

    private void refreshDebugState() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            return;
        }
        if (this.enableDebug) {
            EventLogger eventLogger = new EventLogger("RNVExoplayer");
            this.debugEventLogger = eventLogger;
            this.player.addAnalyticsListener(eventLogger);
        } else {
            EventLogger eventLogger2 = this.debugEventLogger;
            if (eventLogger2 != null) {
                exoPlayer.removeAnalyticsListener(eventLogger2);
                this.debugEventLogger = null;
            }
        }
    }

    public void setViewType(int i) {
        this.exoPlayerView.updateSurfaceView(i);
    }

    private class RNVLoadControl extends DefaultLoadControl {
        private final int availableHeapInBytes;
        private final Runtime runtime;

        /* JADX WARN: Illegal instructions before constructor call */
        public RNVLoadControl(DefaultAllocator defaultAllocator, BufferConfig bufferConfig) {
            int minBufferMs = bufferConfig.getMinBufferMs();
            BufferConfig.Companion companion = BufferConfig.INSTANCE;
            super(defaultAllocator, minBufferMs != companion.getBufferConfigPropUnsetInt() ? bufferConfig.getMinBufferMs() : 50000, bufferConfig.getMaxBufferMs() != companion.getBufferConfigPropUnsetInt() ? bufferConfig.getMaxBufferMs() : 50000, bufferConfig.getBufferForPlaybackMs() != companion.getBufferConfigPropUnsetInt() ? bufferConfig.getBufferForPlaybackMs() : DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, bufferConfig.getBufferForPlaybackAfterRebufferMs() != companion.getBufferConfigPropUnsetInt() ? bufferConfig.getBufferForPlaybackAfterRebufferMs() : 5000, -1, true, bufferConfig.getBackBufferDurationMs() != companion.getBufferConfigPropUnsetInt() ? bufferConfig.getBackBufferDurationMs() : 0, false);
            this.runtime = Runtime.getRuntime();
            this.availableHeapInBytes = (int) Math.floor(((ActivityManager) ReactExoplayerView.this.themedReactContext.getSystemService("activity")).getMemoryClass() * (bufferConfig.getMaxHeapAllocationPercent() != companion.getBufferConfigPropUnsetDouble() ? bufferConfig.getMaxHeapAllocationPercent() : 1.0d) * 1024.0d * 1024.0d);
        }

        @Override // androidx.media3.exoplayer.LoadControl
        public boolean shouldContinueLoading(long j, long j2, float f) {
            if (ReactExoplayerView.this.bufferingStrategy == BufferingStrategy.BufferingStrategyEnum.DisableBuffering) {
                return false;
            }
            if (ReactExoplayerView.this.bufferingStrategy == BufferingStrategy.BufferingStrategyEnum.DependingOnMemory) {
                int totalBytesAllocated = getAllocator().getTotalBytesAllocated();
                int i = this.availableHeapInBytes;
                if (i > 0 && totalBytesAllocated >= i) {
                    return false;
                }
                long j3 = j2 / 1000;
                if (((long) (ReactExoplayerView.this.source.getBufferConfig().getMinBufferMemoryReservePercent() != BufferConfig.INSTANCE.getBufferConfigPropUnsetDouble() ? ReactExoplayerView.this.source.getBufferConfig().getMinBufferMemoryReservePercent() : AudioStats.AUDIO_AMPLITUDE_NONE)) * this.runtime.maxMemory() > this.runtime.maxMemory() - (this.runtime.totalMemory() - this.runtime.freeMemory()) && j3 > 2000) {
                    return false;
                }
                if (this.runtime.freeMemory() == 0) {
                    DebugLog.w("ReactExoplayerView", "Free memory reached 0, forcing garbage collection");
                    this.runtime.gc();
                    return false;
                }
            }
            return super.shouldContinueLoading(j, j2, f);
        }
    }

    private void initializePlayer() {
        final Activity currentActivity = this.themedReactContext.getCurrentActivity();
        final Source source = this.source;
        Runnable runnable = new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initializePlayer$12(source, this, currentActivity);
            }
        };
        this.mainRunnable = runnable;
        this.mainHandler.postDelayed(runnable, 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayer$12(final Source source, final ReactExoplayerView reactExoplayerView, final Activity activity) {
        if (this.viewHasDropped && source == this.source) {
            return;
        }
        try {
            if (source.getUri() == null) {
                return;
            }
            if (this.player == null) {
                initializePlayerCore(reactExoplayerView);
                this.pipListenerUnsubscribe = PictureInPictureUtil.addLifecycleEventListener(this.themedReactContext, this);
                PictureInPictureUtil.applyAutoEnterEnabled(this.themedReactContext, this.pictureInPictureParamsBuilder, this.enterPictureInPictureOnLeave);
            }
            if (!this.source.getIsLocalAssetFile() && !this.source.getIsAsset() && this.source.getBufferConfig().getCacheSize() > 0) {
                RNVSimpleCache.INSTANCE.setSimpleCache(getContext(), this.source.getBufferConfig().getCacheSize());
                this.useCache = true;
            } else {
                this.useCache = false;
            }
            if (this.playerNeedsSource) {
                this.exoPlayerView.updateShutterViewVisibility();
                this.exoPlayerView.invalidateAspectRatio();
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$initializePlayer$11(source, activity, reactExoplayerView);
                    }
                });
            } else if (source == this.source) {
                initializePlayerSource(source);
            }
        } catch (Exception e) {
            reactExoplayerView.playerNeedsSource = true;
            DebugLog.e("ReactExoplayerView", "Failed to initialize Player! 2");
            DebugLog.e("ReactExoplayerView", e.toString());
            e.printStackTrace();
            this.eventEmitter.onVideoError.invoke(e.toString(), e, "1001");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayer$11(final Source source, Activity activity, final ReactExoplayerView reactExoplayerView) {
        if (this.viewHasDropped && source == this.source) {
            return;
        }
        if (activity == null) {
            DebugLog.e("ReactExoplayerView", "Failed to initialize Player!, null activity");
            this.eventEmitter.onVideoError.invoke("Failed to initialize Player!", new Exception("Current Activity is null!"), "1001");
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initializePlayer$10(source, reactExoplayerView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayer$10(Source source, ReactExoplayerView reactExoplayerView) {
        if (this.viewHasDropped && source == this.source) {
            return;
        }
        try {
            initializePlayerSource(source);
        } catch (Exception e) {
            reactExoplayerView.playerNeedsSource = true;
            DebugLog.e("ReactExoplayerView", "Failed to initialize Player! 1");
            DebugLog.e("ReactExoplayerView", e.toString());
            e.printStackTrace();
            this.eventEmitter.onVideoError.invoke(e.toString(), e, "1001");
        }
    }

    public void getCurrentPosition(Promise promise) {
        if (this.player != null) {
            promise.resolve(Float.valueOf(r2.getCurrentPosition() / 1000.0f));
        } else {
            promise.reject("PLAYER_NOT_AVAILABLE", "Player is not initialized.");
        }
    }

    private void initializePlayerCore(ReactExoplayerView reactExoplayerView) {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(getContext(), new AdaptiveTrackSelection.Factory());
        reactExoplayerView.trackSelector = defaultTrackSelector;
        DefaultTrackSelector.Parameters.Builder builderBuildUponParameters = this.trackSelector.buildUponParameters();
        int i = this.maxBitRate;
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        defaultTrackSelector.setParameters(builderBuildUponParameters.setMaxVideoBitrate(i));
        RNVLoadControl rNVLoadControl = new RNVLoadControl(new DefaultAllocator(true, 65536), this.source.getBufferConfig());
        DefaultRenderersFactory defaultRenderersFactoryForceEnableMediaCodecAsynchronousQueueing = new DefaultRenderersFactory(getContext()).setExtensionRendererMode(0).setEnableDecoderFallback(true).forceEnableMediaCodecAsynchronousQueueing();
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(this.mediaDataSourceFactory);
        if (this.useCache) {
            defaultMediaSourceFactory.setDataSourceFactory(RNVSimpleCache.INSTANCE.getCacheFactory(buildHttpDataSourceFactory(true)));
        }
        defaultMediaSourceFactory.setLocalAdInsertionComponents(new AdsLoader.Provider() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda10
            @Override // androidx.media3.exoplayer.source.ads.AdsLoader.Provider
            public final AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration) {
                return this.f$0.lambda$initializePlayerCore$13(adsConfiguration);
            }
        }, this.exoPlayerView);
        this.player = new ExoPlayer.Builder(getContext(), defaultRenderersFactoryForceEnableMediaCodecAsynchronousQueueing).setTrackSelector(reactExoplayerView.trackSelector).setBandwidthMeter(this.bandwidthMeter).setLoadControl(rNVLoadControl).setMediaSourceFactory(defaultMediaSourceFactory).build();
        ReactNativeVideoManager.INSTANCE.getInstance().onInstanceCreated(this.instanceId, this.player);
        refreshDebugState();
        this.player.addListener(reactExoplayerView);
        this.player.setVolume(this.muted ? BitmapDescriptorFactory.HUE_RED : this.audioVolume * 1.0f);
        this.exoPlayerView.setPlayer(this.player);
        this.audioBecomingNoisyReceiver.setListener(reactExoplayerView);
        this.pictureInPictureReceiver.setListener();
        this.bandwidthMeter.addEventListener(new Handler(), reactExoplayerView);
        setPlayWhenReady(!this.isPaused);
        this.playerNeedsSource = true;
        this.player.setPlaybackParameters(new PlaybackParameters(this.rate, 1.0f));
        changeAudioOutput(this.audioOutput);
        if (this.showNotificationControls) {
            setupPlaybackService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdsLoader lambda$initializePlayerCore$13(MediaItem.AdsConfiguration adsConfiguration) {
        return this.adsLoader;
    }

    private AdsMediaSource initializeAds(MediaSource mediaSource, Source source) {
        Uri adTagUrl;
        AdsProps adsProps = source.getAdsProps();
        Uri uri = source.getUri();
        if (adsProps != null && uri != null && (adTagUrl = adsProps.getAdTagUrl()) != null) {
            this.exoPlayerView.showAds();
            ImaAdsLoader.Builder adErrorListener = new ImaAdsLoader.Builder(this.themedReactContext).setAdEventListener(this).setAdErrorListener(this);
            if (adsProps.getAdLanguage() != null) {
                ImaSdkSettings imaSdkSettingsCreateImaSdkSettings = ImaSdkFactory.getInstance().createImaSdkSettings();
                imaSdkSettingsCreateImaSdkSettings.setLanguage(adsProps.getAdLanguage());
                adErrorListener.setImaSdkSettings(imaSdkSettingsCreateImaSdkSettings);
            }
            ImaAdsLoader imaAdsLoaderBuild = adErrorListener.build();
            this.adsLoader = imaAdsLoaderBuild;
            imaAdsLoaderBuild.setPlayer(this.player);
            if (this.adsLoader != null) {
                return new AdsMediaSource(mediaSource, new DataSpec(adTagUrl), ImmutableList.of(uri, adTagUrl), new DefaultMediaSourceFactory(this.mediaDataSourceFactory).setLocalAdInsertionComponents(new AdsLoader.Provider() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda13
                    @Override // androidx.media3.exoplayer.source.ads.AdsLoader.Provider
                    public final AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration) {
                        return this.f$0.lambda$initializeAds$14(adsConfiguration);
                    }
                }, this.exoPlayerView), this.adsLoader, this.exoPlayerView);
            }
        }
        this.exoPlayerView.hideAds();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdsLoader lambda$initializeAds$14(MediaItem.AdsConfiguration adsConfiguration) {
        return this.adsLoader;
    }

    private DrmSessionManager buildDrmSessionManager(UUID uuid, DRMProps dRMProps) throws UnsupportedDrmException {
        if (Util.SDK_INT < 18) {
            return null;
        }
        try {
            DRMManagerSpec customDRMManager = ReactNativeVideoManager.INSTANCE.getInstance().getCustomDRMManager();
            if (customDRMManager == null) {
                customDRMManager = new DRMManager(buildHttpDataSourceFactory(false));
            }
            DrmSessionManager drmSessionManagerBuildDrmSessionManager = customDRMManager.buildDrmSessionManager(uuid, dRMProps);
            if (drmSessionManagerBuildDrmSessionManager == null) {
                this.eventEmitter.onVideoError.invoke("Failed to build DRM session manager", new Exception("DRM session manager is null"), "3007");
            }
            return drmSessionManagerBuildDrmSessionManager;
        } catch (UnsupportedDrmException e) {
            throw e;
        } catch (Exception e2) {
            this.eventEmitter.onVideoError.invoke(e2.toString(), e2, "3006");
            return null;
        }
    }

    private void initializePlayerSource(Source source) throws InterruptedException {
        ExoPlayer exoPlayer;
        if (source.getUri() == null) {
            return;
        }
        DrmSessionManager drmSessionManagerInitializePlayerDrm = initializePlayerDrm();
        if (drmSessionManagerInitializePlayerDrm == null && source.getDrmProps() != null && source.getDrmProps().getDrmType() != null) {
            DebugLog.e("ReactExoplayerView", "Failed to initialize DRM Session Manager Framework!");
            return;
        }
        MediaSource mediaSourceBuildMediaSource = buildMediaSource(source.getUri(), source.getExtension(), drmSessionManagerInitializePlayerDrm, source.getCropStartMs(), source.getCropEndMs());
        MediaSource mergingMediaSource = (MediaSource) ReactExoplayerView$$ExternalSyntheticBackport2.m(initializeAds(mediaSourceBuildMediaSource, source), mediaSourceBuildMediaSource);
        MediaSource mediaSourceBuildTextSource = buildTextSource();
        if (mediaSourceBuildTextSource != null) {
            mergingMediaSource = new MergingMediaSource(mergingMediaSource, mediaSourceBuildTextSource);
        }
        while (true) {
            exoPlayer = this.player;
            if (exoPlayer != null) {
                break;
            }
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                DebugLog.e("ReactExoplayerView", e.toString());
            }
        }
        int i = this.resumeWindow;
        if (i != -1) {
            exoPlayer.seekTo(i, this.resumePosition);
            this.player.setMediaSource(mergingMediaSource, false);
        } else if (source.getStartPositionMs() > 0) {
            this.player.setMediaSource(mergingMediaSource, source.getStartPositionMs());
        } else {
            this.player.setMediaSource(mergingMediaSource, true);
        }
        this.player.prepare();
        this.playerNeedsSource = false;
        reLayoutControls();
        this.eventEmitter.onVideoLoadStart.invoke();
        this.loadVideoStarted = true;
        finishPlayerInitialization();
    }

    private DrmSessionManager initializePlayerDrm() {
        UUID drmUuid;
        int i;
        DRMProps drmProps = this.source.getDrmProps();
        if (drmProps != null && drmProps.getDrmType() != null && (drmUuid = Util.getDrmUuid(drmProps.getDrmType())) != null) {
            try {
                DebugLog.d("ReactExoplayerView", "drm buildDrmSessionManager");
                return buildDrmSessionManager(drmUuid, drmProps);
            } catch (UnsupportedDrmException e) {
                if (Util.SDK_INT < 18) {
                    i = R.string.error_drm_not_supported;
                } else {
                    i = e.reason == 1 ? R.string.error_drm_unsupported_scheme : R.string.error_drm_unknown;
                }
                this.eventEmitter.onVideoError.invoke(this.getResources().getString(i), e, "3003");
            }
        }
        return null;
    }

    private void finishPlayerInitialization() {
        initializePlayerControl();
        setControls(this.controls);
        applyModifiers();
    }

    private void setupPlaybackService() {
        if (!this.showNotificationControls || this.player == null) {
            return;
        }
        this.playbackServiceConnection = new ServiceConnection() { // from class: com.brentvatne.exoplayer.ReactExoplayerView.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                ReactExoplayerView.this.playbackServiceBinder = (PlaybackServiceBinder) iBinder;
                try {
                    Activity currentActivity = ReactExoplayerView.this.themedReactContext.getCurrentActivity();
                    if (currentActivity == null) {
                        DebugLog.w("ReactExoplayerView", "Could not register ExoPlayer: currentActivity is null");
                    } else {
                        ReactExoplayerView.this.playbackServiceBinder.getService().registerPlayer(ReactExoplayerView.this.player, currentActivity.getClass());
                    }
                } catch (Exception e) {
                    DebugLog.e("ReactExoplayerView", "Could not register ExoPlayer: " + e.getMessage());
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                try {
                    if (ReactExoplayerView.this.playbackServiceBinder != null) {
                        ReactExoplayerView.this.playbackServiceBinder.getService().unregisterPlayer(ReactExoplayerView.this.player);
                    }
                } catch (Exception unused) {
                }
                ReactExoplayerView.this.playbackServiceBinder = null;
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName componentName) {
                DebugLog.e("ReactExoplayerView", "Could not register ExoPlayer");
            }
        };
        Intent intent = new Intent(this.themedReactContext, (Class<?>) VideoPlaybackService.class);
        intent.setAction(MediaSessionService.SERVICE_INTERFACE);
        this.themedReactContext.startForegroundService(intent);
        this.themedReactContext.bindService(intent, this.playbackServiceConnection, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    }

    private void cleanupPlaybackService() {
        PlaybackServiceBinder playbackServiceBinder;
        try {
            if (this.player != null && (playbackServiceBinder = this.playbackServiceBinder) != null) {
                playbackServiceBinder.getService().unregisterPlayer(this.player);
            }
            this.playbackServiceBinder = null;
            ServiceConnection serviceConnection = this.playbackServiceConnection;
            if (serviceConnection != null) {
                this.themedReactContext.unbindService(serviceConnection);
            }
        } catch (Exception unused) {
            DebugLog.w("ReactExoplayerView", "Cloud not cleanup playback service");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.media3.exoplayer.source.MediaSource buildMediaSource(android.net.Uri r6, java.lang.String r7, final androidx.media3.exoplayer.drm.DrmSessionManager r8, long r9, long r11) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerView.buildMediaSource(android.net.Uri, java.lang.String, androidx.media3.exoplayer.drm.DrmSessionManager, long, long):androidx.media3.exoplayer.source.MediaSource");
    }

    private MediaSource buildTextSource() {
        if (this.source.getSideLoadedTextTracks() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SideLoadedTextTrack> it = this.source.getSideLoadedTextTracks().getTracks().iterator();
        while (it.hasNext()) {
            SideLoadedTextTrack next = it.next();
            arrayList.add(new MediaItem.SubtitleConfiguration.Builder(next.getUri()).setMimeType(next.getType()).setLanguage(next.getLanguage()).setSelectionFlags(1).setRoleFlags(128).setLabel(next.getTitle()).build());
        }
        return new DefaultMediaSourceFactory(this.mediaDataSourceFactory).createMediaSource(new MediaItem.Builder().setUri(this.source.getUri()).setSubtitleConfigurations(arrayList).build());
    }

    private void releasePlayer() {
        Runnable runnable;
        if (this.player != null) {
            PlaybackServiceBinder playbackServiceBinder = this.playbackServiceBinder;
            if (playbackServiceBinder != null) {
                playbackServiceBinder.getService().unregisterPlayer(this.player);
                this.themedReactContext.unbindService(this.playbackServiceConnection);
            }
            updateResumePosition();
            this.player.release();
            this.player.removeListener(this);
            PictureInPictureUtil.applyAutoEnterEnabled(this.themedReactContext, this.pictureInPictureParamsBuilder, false);
            Runnable runnable2 = this.pipListenerUnsubscribe;
            if (runnable2 != null) {
                runnable2.run();
            }
            this.trackSelector = null;
            ReactNativeVideoManager.INSTANCE.getInstance().onInstanceRemoved(this.instanceId, this.player);
            this.player = null;
        }
        ImaAdsLoader imaAdsLoader = this.adsLoader;
        if (imaAdsLoader != null) {
            imaAdsLoader.release();
            this.adsLoader = null;
        }
        this.progressHandler.removeMessages(1);
        this.audioBecomingNoisyReceiver.removeListener();
        this.pictureInPictureReceiver.removeListener();
        this.bandwidthMeter.removeEventListener(this);
        Handler handler = this.mainHandler;
        if (handler == null || (runnable = this.mainRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.mainRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class OnAudioFocusChangedListener implements AudioManager.OnAudioFocusChangeListener {
        private final ThemedReactContext themedReactContext;
        private final ReactExoplayerView view;

        private OnAudioFocusChangedListener(ReactExoplayerView reactExoplayerView, ThemedReactContext themedReactContext) {
            this.view = reactExoplayerView;
            this.themedReactContext = themedReactContext;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Activity currentActivity = this.themedReactContext.getCurrentActivity();
            if (i == -2) {
                this.view.eventEmitter.onAudioFocusChanged.invoke(Boolean.FALSE);
            } else if (i == -1) {
                this.view.hasAudioFocus = false;
                this.view.eventEmitter.onAudioFocusChanged.invoke(Boolean.FALSE);
                if (currentActivity != null) {
                    final ReactExoplayerView reactExoplayerView = this.view;
                    Objects.requireNonNull(reactExoplayerView);
                    currentActivity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$OnAudioFocusChangedListener$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            reactExoplayerView.pausePlayback();
                        }
                    });
                }
                this.view.audioManager.abandonAudioFocus(this);
            } else if (i == 1) {
                this.view.hasAudioFocus = true;
                this.view.eventEmitter.onAudioFocusChanged.invoke(Boolean.TRUE);
            }
            if (this.view.player == null || currentActivity == null) {
                return;
            }
            if (i == -3) {
                if (this.view.muted) {
                    return;
                }
                currentActivity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$OnAudioFocusChangedListener$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAudioFocusChange$0();
                    }
                });
            } else {
                if (i != 1 || this.view.muted) {
                    return;
                }
                currentActivity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$OnAudioFocusChangedListener$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAudioFocusChange$1();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAudioFocusChange$0() {
            this.view.player.setVolume(this.view.audioVolume * 0.8f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAudioFocusChange$1() {
            this.view.player.setVolume(this.view.audioVolume * 1.0f);
        }
    }

    private boolean requestAudioFocus() {
        return this.disableFocus || this.source.getUri() == null || this.hasAudioFocus || this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1;
    }

    private void setPlayWhenReady(boolean z) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            return;
        }
        if (z) {
            boolean zRequestAudioFocus = requestAudioFocus();
            this.hasAudioFocus = zRequestAudioFocus;
            if (zRequestAudioFocus) {
                this.player.setPlayWhenReady(true);
                return;
            }
            return;
        }
        exoPlayer.setPlayWhenReady(false);
    }

    private void resumePlayback() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            if (!exoPlayer.getPlayWhenReady()) {
                setPlayWhenReady(true);
            }
            setKeepScreenOn(this.preventsDisplaySleepDuringVideoPlayback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayback() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null && exoPlayer.getPlayWhenReady()) {
            setPlayWhenReady(false);
        }
        setKeepScreenOn(false);
    }

    private void stopPlayback() {
        onStopPlayback();
        releasePlayer();
    }

    private void onStopPlayback() {
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    }

    private void updateResumePosition() {
        this.resumeWindow = this.player.getCurrentMediaItemIndex();
        this.resumePosition = this.player.isCurrentMediaItemSeekable() ? Math.max(0L, this.player.getCurrentPosition()) : C.TIME_UNSET;
    }

    private void clearResumePosition() {
        this.resumeWindow = -1;
        this.resumePosition = C.TIME_UNSET;
    }

    private DataSource.Factory buildDataSourceFactory(boolean z) {
        return DataSourceUtil.getDefaultDataSourceFactory(this.themedReactContext, z ? this.bandwidthMeter : null, this.source.getHeaders());
    }

    private HttpDataSource.Factory buildHttpDataSourceFactory(boolean z) {
        return DataSourceUtil.getDefaultHttpDataSourceFactory(this.themedReactContext, z ? this.bandwidthMeter : null, this.source.getHeaders());
    }

    @Override // com.brentvatne.receiver.BecomingNoisyListener
    public void onAudioBecomingNoisy() {
        this.eventEmitter.onVideoAudioBecomingNoisy.invoke();
    }

    @Override // androidx.media3.common.Player.Listener
    public void onEvents(@NonNull Player player, Player.Events events) throws MissingResourceException {
        String str;
        String str2;
        String str3;
        if (events.contains(4) || events.contains(5)) {
            int playbackState = player.getPlaybackState();
            boolean playWhenReady = player.getPlayWhenReady();
            String str4 = "onStateChanged: playWhenReady=" + playWhenReady + ", playbackState=";
            this.eventEmitter.onPlaybackRateChange.invoke(Float.valueOf((playWhenReady && playbackState == 3) ? 1.0f : BitmapDescriptorFactory.HUE_RED));
            if (playbackState == 1) {
                str = str4 + "idle";
                this.eventEmitter.onVideoIdle.invoke();
                clearProgressMessageHandler();
                if (!player.getPlayWhenReady()) {
                    setKeepScreenOn(false);
                }
            } else {
                if (playbackState == 2) {
                    str3 = str4 + "buffering";
                    onBuffering(true);
                    clearProgressMessageHandler();
                    setKeepScreenOn(this.preventsDisplaySleepDuringVideoPlayback);
                } else if (playbackState == 3) {
                    str = str4 + "ready";
                    this.eventEmitter.onReadyForDisplay.invoke();
                    onBuffering(false);
                    clearProgressMessageHandler();
                    startProgressHandler();
                    videoLoaded();
                    if (this.selectTrackWhenReady && this.isUsingContentResolution) {
                        this.selectTrackWhenReady = false;
                        setSelectedTrack(2, this.videoTrackType, this.videoTrackValue);
                    }
                    LegacyPlayerControlView legacyPlayerControlView = this.playerControlView;
                    if (legacyPlayerControlView != null) {
                        legacyPlayerControlView.show();
                    }
                    setKeepScreenOn(this.preventsDisplaySleepDuringVideoPlayback);
                } else if (playbackState == 4) {
                    str3 = str4 + "ended";
                    updateProgress();
                    this.eventEmitter.onVideoEnd.invoke();
                    onStopPlayback();
                    setKeepScreenOn(false);
                } else {
                    str2 = str4 + "unknown";
                    DebugLog.d("ReactExoplayerView", str2);
                }
                str2 = str3;
                DebugLog.d("ReactExoplayerView", str2);
            }
            str2 = str;
            DebugLog.d("ReactExoplayerView", str2);
        }
    }

    private void startProgressHandler() {
        this.progressHandler.sendEmptyMessage(1);
    }

    private void clearProgressMessageHandler() {
        this.progressHandler.removeMessages(1);
    }

    private void videoLoaded() throws MissingResourceException {
        final int i;
        int i2;
        if (this.player.isPlayingAd() || !this.loadVideoStarted) {
            return;
        }
        int i3 = 0;
        this.loadVideoStarted = false;
        String str = this.audioTrackType;
        if (str != null) {
            setSelectedAudioTrack(str, this.audioTrackValue);
        }
        String str2 = this.videoTrackType;
        if (str2 != null) {
            setSelectedVideoTrack(str2, this.videoTrackValue);
        }
        String str3 = this.textTrackType;
        if (str3 != null) {
            setSelectedTextTrack(str3, this.textTrackValue);
        }
        Format videoFormat = this.player.getVideoFormat();
        boolean z = videoFormat != null && ((i2 = videoFormat.rotationDegrees) == 90 || i2 == 270);
        if (videoFormat != null) {
            i = z ? videoFormat.height : videoFormat.width;
        } else {
            i = 0;
        }
        if (videoFormat != null) {
            i3 = z ? videoFormat.width : videoFormat.height;
        }
        final int i4 = i3;
        String str4 = videoFormat != null ? videoFormat.id : null;
        final long duration = this.player.getDuration();
        final long currentPosition = this.player.getCurrentPosition();
        final ArrayList<Track> audioTrackInfo = getAudioTrackInfo();
        final ArrayList<Track> textTrackInfo = getTextTrackInfo();
        if (this.source.getContentStartTime() != -1) {
            final String str5 = str4;
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$videoLoaded$16(duration, currentPosition, i, i4, audioTrackInfo, textTrackInfo, str5);
                }
            });
        } else {
            this.eventEmitter.onVideoLoad.invoke(Long.valueOf(duration), Long.valueOf(currentPosition), Integer.valueOf(i), Integer.valueOf(i4), audioTrackInfo, textTrackInfo, getVideoTrackInfo(), str4);
            refreshControlsStyles();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$videoLoaded$16(long j, long j2, int i, int i2, ArrayList arrayList, ArrayList arrayList2, String str) {
        ArrayList<VideoTrack> videoTrackInfoFromManifest = getVideoTrackInfoFromManifest();
        if (videoTrackInfoFromManifest != null) {
            this.isUsingContentResolution = true;
        }
        this.eventEmitter.onVideoLoad.invoke(Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), arrayList, arrayList2, videoTrackInfoFromManifest, str);
    }

    private static boolean isTrackSelected(TrackSelection trackSelection, TrackGroup trackGroup, int i) {
        return (trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i) == -1) ? false : true;
    }

    private ArrayList<Track> getAudioTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null) {
            return arrayList;
        }
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
        int trackRendererIndex = getTrackRendererIndex(1);
        if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
            TrackSelection trackSelection = this.player.getCurrentTrackSelections().get(1);
            for (int i = 0; i < trackGroups.length; i++) {
                TrackGroup trackGroup = trackGroups.get(i);
                Format format = trackGroup.getFormat(0);
                Track trackExoplayerTrackToGenericTrack = exoplayerTrackToGenericTrack(format, i, trackSelection, trackGroup);
                int i2 = format.bitrate;
                if (i2 == -1) {
                    i2 = 0;
                }
                trackExoplayerTrackToGenericTrack.setBitrate(i2);
                arrayList.add(trackExoplayerTrackToGenericTrack);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoTrack exoplayerVideoTrackToGenericVideoTrack(Format format, int i) {
        VideoTrack videoTrack = new VideoTrack();
        int i2 = format.width;
        if (i2 == -1) {
            i2 = 0;
        }
        videoTrack.setWidth(i2);
        int i3 = format.height;
        if (i3 == -1) {
            i3 = 0;
        }
        videoTrack.setHeight(i3);
        int i4 = format.bitrate;
        videoTrack.setBitrate(i4 != -1 ? i4 : 0);
        videoTrack.setRotation(format.rotationDegrees);
        String str = format.codecs;
        if (str != null) {
            videoTrack.setCodecs(str);
        }
        String strValueOf = format.id;
        if (strValueOf == null) {
            strValueOf = String.valueOf(i);
        }
        videoTrack.setTrackId(strValueOf);
        videoTrack.setIndex(i);
        return videoTrack;
    }

    private ArrayList<VideoTrack> getVideoTrackInfo() {
        ArrayList<VideoTrack> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null) {
            return arrayList;
        }
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
        int trackRendererIndex = getTrackRendererIndex(2);
        if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
            for (int i = 0; i < trackGroups.length; i++) {
                TrackGroup trackGroup = trackGroups.get(i);
                for (int i2 = 0; i2 < trackGroup.length; i2++) {
                    Format format = trackGroup.getFormat(i2);
                    if (isFormatSupported(format)) {
                        arrayList.add(exoplayerVideoTrackToGenericVideoTrack(format, i2));
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<VideoTrack> getVideoTrackInfoFromManifest() {
        return getVideoTrackInfoFromManifest(0);
    }

    private ArrayList getVideoTrackInfoFromManifest(int i) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            ArrayList arrayList = (ArrayList) executorServiceNewSingleThreadExecutor.submit(new Callable(this.mediaDataSourceFactory.createDataSource(), this.source.getUri(), (this.source.getContentStartTime() * 1000) - 100) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.5
                final DataSource ds;
                final long startTimeUs;
                final Uri uri;
                final /* synthetic */ DataSource val$dataSource;
                final /* synthetic */ Uri val$sourceUri;
                final /* synthetic */ long val$startTime;

                {
                    this.val$dataSource = dataSource;
                    this.val$sourceUri = uri;
                    this.val$startTime = j;
                    this.ds = dataSource;
                    this.uri = uri;
                    this.startTimeUs = j * 1000;
                }

                @Override // java.util.concurrent.Callable
                public ArrayList call() {
                    int i2;
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        DashManifest dashManifestLoadManifest = DashUtil.loadManifest(this.ds, this.uri);
                        int periodCount = dashManifestLoadManifest.getPeriodCount();
                        int i3 = 0;
                        while (i3 < periodCount) {
                            Period period = dashManifestLoadManifest.getPeriod(i3);
                            int i4 = 0;
                            while (i4 < period.adaptationSets.size()) {
                                AdaptationSet adaptationSet = period.adaptationSets.get(i4);
                                if (adaptationSet.type != 2) {
                                    i2 = i3;
                                } else {
                                    int i5 = 0;
                                    boolean z = false;
                                    while (true) {
                                        if (i5 >= adaptationSet.representations.size()) {
                                            i2 = i3;
                                            break;
                                        }
                                        Representation representation = adaptationSet.representations.get(i5);
                                        Format format = representation.format;
                                        if (ReactExoplayerView.this.isFormatSupported(format)) {
                                            i2 = i3;
                                            if (representation.presentationTimeOffsetUs <= this.startTimeUs) {
                                                break;
                                            }
                                            arrayList2.add(ReactExoplayerView.this.exoplayerVideoTrackToGenericVideoTrack(format, i5));
                                            z = true;
                                        } else {
                                            i2 = i3;
                                        }
                                        i5++;
                                        i3 = i2;
                                    }
                                    if (z) {
                                        return arrayList2;
                                    }
                                }
                                i4++;
                                i3 = i2;
                            }
                            i3++;
                        }
                        return null;
                    } catch (Exception e) {
                        DebugLog.w("ReactExoplayerView", "error in getVideoTrackInfoFromManifest:" + e.getMessage());
                        return null;
                    }
                }
            }).get(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS);
            if (arrayList == null && i < 1) {
                return getVideoTrackInfoFromManifest(i + 1);
            }
            executorServiceNewSingleThreadExecutor.shutdown();
            return arrayList;
        } catch (Exception e) {
            DebugLog.w("ReactExoplayerView", "error in getVideoTrackInfoFromManifest handling request:" + e.getMessage());
            return null;
        }
    }

    private Track exoplayerTrackToGenericTrack(Format format, int i, TrackSelection trackSelection, TrackGroup trackGroup) {
        Track track = new Track();
        track.setIndex(i);
        String str = format.sampleMimeType;
        if (str != null) {
            track.setMimeType(str);
        }
        String str2 = format.language;
        if (str2 != null) {
            track.setLanguage(str2);
        }
        String str3 = format.label;
        if (str3 != null) {
            track.setTitle(str3);
        }
        track.setSelected(isTrackSelected(trackSelection, trackGroup, i));
        return track;
    }

    private ArrayList<Track> getTextTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null) {
            return arrayList;
        }
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
        int trackRendererIndex = getTrackRendererIndex(3);
        if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
            TrackSelection trackSelection = this.player.getCurrentTrackSelections().get(2);
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
            for (int i = 0; i < trackGroups.length; i++) {
                TrackGroup trackGroup = trackGroups.get(i);
                arrayList.add(exoplayerTrackToGenericTrack(trackGroup.getFormat(0), i, trackSelection, trackGroup));
            }
        }
        return arrayList;
    }

    private void onBuffering(boolean z) {
        if (this.isBuffering == z) {
            return;
        }
        if (this.isPaused && this.isSeeking && !z) {
            this.eventEmitter.onVideoSeek.invoke(Long.valueOf(this.player.getCurrentPosition()), Long.valueOf(this.seekPosition));
            this.isSeeking = false;
        }
        this.isBuffering = z;
        this.eventEmitter.onVideoBuffer.invoke(Boolean.valueOf(z));
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPositionDiscontinuity(@NonNull Player.PositionInfo positionInfo, @NonNull Player.PositionInfo positionInfo2, int i) throws MissingResourceException {
        if (i == 1) {
            this.isSeeking = true;
            this.seekPosition = positionInfo2.positionMs;
            if (this.isUsingContentResolution) {
                setSelectedTrack(2, this.videoTrackType, this.videoTrackValue);
            }
        }
        if (this.playerNeedsSource) {
            updateResumePosition();
        }
        if (this.isUsingContentResolution) {
            setSelectedTrack(2, this.videoTrackType, this.videoTrackValue);
            this.selectTrackWhenReady = true;
        }
        if (i == 0 && this.player.getRepeatMode() == 1) {
            updateProgress();
            this.eventEmitter.onVideoEnd.invoke();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTracksChanged(@NonNull Tracks tracks) {
        this.eventEmitter.onTextTracks.invoke(getTextTrackInfo());
        this.eventEmitter.onAudioTracks.invoke(getAudioTrackInfo());
        this.eventEmitter.onVideoTracks.invoke(getVideoTrackInfo());
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.eventEmitter.onPlaybackRateChange.invoke(Float.valueOf(playbackParameters.speed));
    }

    @Override // androidx.media3.common.Player.Listener
    public void onVolumeChanged(float f) {
        this.eventEmitter.onVolumeChange.invoke(Float.valueOf(f));
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean z) {
        if (z && this.isSeeking) {
            this.eventEmitter.onVideoSeek.invoke(Long.valueOf(this.player.getCurrentPosition()), Long.valueOf(this.seekPosition));
        }
        PictureInPictureUtil.applyPlayingStatus(this.themedReactContext, this.pictureInPictureParamsBuilder, this.pictureInPictureReceiver, !z);
        this.eventEmitter.onVideoPlaybackStateChanged.invoke(Boolean.valueOf(z), Boolean.valueOf(this.isSeeking));
        if (z) {
            this.isSeeking = false;
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(@NonNull PlaybackException playbackException) {
        String str = "ExoPlaybackException: " + PlaybackException.getErrorCodeName(playbackException.errorCode);
        String str2 = ExifInterface.GPS_MEASUREMENT_2D + playbackException.errorCode;
        int i = playbackException.errorCode;
        if ((i == 6000 || i == 6002 || i == 6004 || i == 6006 || i == 6007) && !this.hasDrmFailed) {
            this.hasDrmFailed = true;
            this.playerNeedsSource = true;
            updateResumePosition();
            initializePlayer();
            setPlayWhenReady(true);
            return;
        }
        this.eventEmitter.onVideoError.invoke(str, playbackException, str2);
        this.playerNeedsSource = true;
        if (isBehindLiveWindow(playbackException)) {
            clearResumePosition();
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.seekToDefaultPosition();
                this.player.prepare();
                return;
            }
            return;
        }
        updateResumePosition();
    }

    private static boolean isBehindLiveWindow(PlaybackException playbackException) {
        return playbackException.errorCode == 1002;
    }

    public int getTrackRendererIndex(int i) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            return -1;
        }
        int rendererCount = exoPlayer.getRendererCount();
        for (int i2 = 0; i2 < rendererCount; i2++) {
            if (this.player.getRendererType(i2) == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMetadata(@NonNull Metadata metadata) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) metadata.get(i);
                if (!(id3Frame instanceof TextInformationFrame)) {
                    str = "";
                } else {
                    str = ((TextInformationFrame) id3Frame).value;
                }
                arrayList.add(new TimedMetadata(id3Frame.id, str));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                arrayList.add(new TimedMetadata(eventMessage.schemeIdUri, eventMessage.value));
            } else {
                DebugLog.d("ReactExoplayerView", "unhandled metadata " + entry);
            }
        }
        this.eventEmitter.onTimedMetadata.invoke(arrayList);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onCues(CueGroup cueGroup) {
        if (cueGroup.cues.isEmpty() || cueGroup.cues.get(0).text == null) {
            return;
        }
        this.eventEmitter.onTextTrackDataChanged.invoke(cueGroup.cues.get(0).text.toString());
    }

    public void setSrc(Source source) {
        if (source.getUri() != null) {
            clearResumePosition();
            boolean zIsEquals = source.isEquals(this.source);
            this.hasDrmFailed = false;
            this.source = source;
            this.mediaDataSourceFactory = DataSourceUtil.getDefaultDataSourceFactory(this.themedReactContext, this.bandwidthMeter, source.getHeaders());
            if (source.getCmcdProps() != null) {
                setCmcdConfigurationFactory(new CMCDConfig(source.getCmcdProps()).toCmcdConfigurationFactory());
            } else {
                setCmcdConfigurationFactory(null);
            }
            if (zIsEquals) {
                return;
            }
            this.playerNeedsSource = true;
            initializePlayer();
            return;
        }
        clearSrc();
    }

    public void clearSrc() {
        ExoPlayer exoPlayer;
        if (this.source.getUri() != null && (exoPlayer = this.player) != null) {
            exoPlayer.stop();
            this.player.clearMediaItems();
        }
        this.exoPlayerView.hideAds();
        this.source = new Source();
        this.mediaDataSourceFactory = null;
        clearResumePosition();
    }

    public void setProgressUpdateInterval(float f) {
        this.mProgressUpdateInterval = f;
    }

    public void setReportBandwidth(boolean z) {
        this.mReportBandwidth = z;
    }

    public void setResizeModeModifier(int i) {
        ExoPlayerView exoPlayerView = this.exoPlayerView;
        if (exoPlayerView != null) {
            exoPlayerView.setResizeMode(i);
        }
    }

    private void applyModifiers() {
        setRepeatModifier(this.repeat);
        setMutedModifier(this.muted);
    }

    public void setRepeatModifier(boolean z) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            if (z) {
                exoPlayer.setRepeatMode(1);
            } else {
                exoPlayer.setRepeatMode(0);
            }
        }
        this.repeat = z;
    }

    public void setPreventsDisplaySleepDuringVideoPlayback(boolean z) {
        this.preventsDisplaySleepDuringVideoPlayback = z;
    }

    public void disableTrack(int i) {
        this.trackSelector.setParameters(this.trackSelector.getParameters().buildUpon().setRendererDisabled(i, true).build());
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSelectedTrack(int r18, java.lang.String r19, java.lang.String r20) throws java.util.MissingResourceException {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerView.setSelectedTrack(int, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormatSupported(Format format) {
        int i = format.width;
        if (i == -1) {
            i = 0;
        }
        int i2 = format.height;
        if (i2 == -1) {
            i2 = 0;
        }
        float f = format.frameRate;
        if (f == -1.0f) {
            f = BitmapDescriptorFactory.HUE_RED;
        }
        String str = format.sampleMimeType;
        if (str == null) {
            return true;
        }
        try {
            return MediaCodecUtil.getDecoderInfo(str, false, false).isVideoSizeAndRateSupportedV21(i, i2, f);
        } catch (Exception unused) {
            return true;
        }
    }

    private int getGroupIndexForDefaultLocale(TrackGroupArray trackGroupArray) throws MissingResourceException {
        if (trackGroupArray.length == 0) {
            return -1;
        }
        String language = Locale.getDefault().getLanguage();
        String iSO3Language = Locale.getDefault().getISO3Language();
        for (int i = 0; i < trackGroupArray.length; i++) {
            String str = trackGroupArray.get(i).getFormat(0).language;
            if (str != null && (str.equals(language) || str.equals(iSO3Language))) {
                return i;
            }
        }
        return 0;
    }

    public void setSelectedVideoTrack(String str, String str2) throws MissingResourceException {
        this.videoTrackType = str;
        this.videoTrackValue = str2;
        if (this.loadVideoStarted) {
            return;
        }
        setSelectedTrack(2, str, str2);
    }

    public void setSelectedAudioTrack(String str, String str2) throws MissingResourceException {
        this.audioTrackType = str;
        this.audioTrackValue = str2;
        setSelectedTrack(1, str, str2);
    }

    public void setSelectedTextTrack(String str, String str2) throws MissingResourceException {
        this.textTrackType = str;
        this.textTrackValue = str2;
        setSelectedTrack(3, str, str2);
    }

    public void setPausedModifier(boolean z) {
        this.isPaused = z;
        if (this.player != null) {
            if (!z) {
                resumePlayback();
            } else {
                pausePlayback();
            }
        }
    }

    public void setEnterPictureInPictureOnLeave(boolean z) {
        this.enterPictureInPictureOnLeave = z;
        if (this.player != null) {
            PictureInPictureUtil.applyAutoEnterEnabled(this.themedReactContext, this.pictureInPictureParamsBuilder, z);
        }
    }

    protected void setIsInPictureInPicture(boolean z) {
        this.eventEmitter.onPictureInPictureStatusChanged.invoke(Boolean.valueOf(z));
        FullScreenPlayerView fullScreenPlayerView = this.fullScreenPlayerView;
        if (fullScreenPlayerView != null && fullScreenPlayerView.isShowing()) {
            if (z) {
                this.fullScreenPlayerView.hideWithoutPlayer();
                return;
            }
            return;
        }
        Activity currentActivity = this.themedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(android.R.id.content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            ViewGroup viewGroup2 = (ViewGroup) this.exoPlayerView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.exoPlayerView);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) != this.exoPlayerView) {
                    this.rootViewChildrenOriginalVisibility.add(Integer.valueOf(viewGroup.getChildAt(i).getVisibility()));
                    viewGroup.getChildAt(i).setVisibility(8);
                }
            }
            viewGroup.addView(this.exoPlayerView, layoutParams);
            return;
        }
        viewGroup.removeView(this.exoPlayerView);
        if (this.rootViewChildrenOriginalVisibility.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            viewGroup.getChildAt(i2).setVisibility(((Integer) this.rootViewChildrenOriginalVisibility.get(i2)).intValue());
        }
        addView(this.exoPlayerView, 0, layoutParams);
    }

    public void enterPictureInPictureMode() {
        this.pictureInPictureParamsBuilder.setActions(PictureInPictureUtil.getPictureInPictureActions(this.themedReactContext, this.isPaused, this.pictureInPictureReceiver));
        if (this.player.getPlaybackState() == 3) {
            this.pictureInPictureParamsBuilder.setAspectRatio(PictureInPictureUtil.calcPictureInPictureAspectRatio(this.player));
        }
        PictureInPictureUtil.enterPictureInPictureMode(this.themedReactContext, this.pictureInPictureParamsBuilder.build());
    }

    public void exitPictureInPictureMode() {
        Activity currentActivity = this.themedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (!this.rootViewChildrenOriginalVisibility.isEmpty()) {
            if (this.exoPlayerView.getParent().equals(viewGroup)) {
                viewGroup.removeView(this.exoPlayerView);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setVisibility(((Integer) this.rootViewChildrenOriginalVisibility.get(i)).intValue());
            }
            this.rootViewChildrenOriginalVisibility.clear();
        }
        if (currentActivity.isInPictureInPictureMode()) {
            currentActivity.moveTaskToBack(false);
        }
    }

    public void setMutedModifier(boolean z) {
        this.muted = z;
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setVolume(z ? BitmapDescriptorFactory.HUE_RED : this.audioVolume);
        }
    }

    private void changeAudioOutput(AudioOutput audioOutput) {
        if (this.player != null) {
            int streamType = audioOutput.getStreamType();
            this.player.setAudioAttributes(new AudioAttributes.Builder().setUsage(Util.getAudioUsageForStreamType(streamType)).setContentType(Util.getAudioContentTypeForStreamType(streamType)).build(), false);
            AudioManager audioManager = (AudioManager) this.themedReactContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            boolean z = audioOutput == AudioOutput.SPEAKER;
            audioManager.setMode(z ? 0 : 3);
            audioManager.setSpeakerphoneOn(z);
        }
    }

    public void setAudioOutput(AudioOutput audioOutput) {
        if (this.audioOutput != audioOutput) {
            this.audioOutput = audioOutput;
            changeAudioOutput(audioOutput);
        }
    }

    public void setVolumeModifier(float f) {
        this.audioVolume = f;
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setVolume(f);
        }
    }

    public void seekTo(long j) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.seekTo(j);
        }
    }

    public void setRateModifier(float f) {
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            DebugLog.w("ReactExoplayerView", "cannot set rate <= 0");
            return;
        }
        this.rate = f;
        if (this.player != null) {
            this.player.setPlaybackParameters(new PlaybackParameters(this.rate, 1.0f));
        }
    }

    public void setMaxBitRateModifier(int i) {
        this.maxBitRate = i;
        if (this.player == null || !isUsingVideoABR()) {
            return;
        }
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        DefaultTrackSelector.Parameters.Builder builderBuildUponParameters = defaultTrackSelector.buildUponParameters();
        int i2 = this.maxBitRate;
        if (i2 == 0) {
            i2 = Integer.MAX_VALUE;
        }
        defaultTrackSelector.setParameters(builderBuildUponParameters.setMaxVideoBitrate(i2));
    }

    public void setPlayInBackground(boolean z) {
        this.playInBackground = z;
    }

    public void setDisableFocus(boolean z) {
        this.disableFocus = z;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.focusable = z;
        this.exoPlayerView.setFocusable(z);
    }

    public void setShowNotificationControls(boolean z) {
        this.showNotificationControls = z;
        ServiceConnection serviceConnection = this.playbackServiceConnection;
        if (serviceConnection == null && z) {
            setupPlaybackService();
        } else {
            if (z || serviceConnection == null) {
                return;
            }
            cleanupPlaybackService();
        }
    }

    public void setBufferingStrategy(BufferingStrategy.BufferingStrategyEnum bufferingStrategyEnum) {
        this.bufferingStrategy = bufferingStrategyEnum;
    }

    public boolean getPreventsDisplaySleepDuringVideoPlayback() {
        return this.preventsDisplaySleepDuringVideoPlayback;
    }

    private void updateFullScreenButtonVisibility() {
        FullScreenPlayerView fullScreenPlayerView;
        LegacyPlayerControlView legacyPlayerControlView = this.playerControlView;
        if (legacyPlayerControlView != null) {
            ImageButton imageButton = (ImageButton) legacyPlayerControlView.findViewById(R.id.exo_fullscreen);
            if (this.isFullscreen && (fullScreenPlayerView = this.fullScreenPlayerView) != null && !fullScreenPlayerView.isShowing()) {
                imageButton.setVisibility(8);
            } else {
                imageButton.setVisibility(0);
            }
        }
    }

    public void setDisableDisconnectError(boolean z) {
        this.disableDisconnectError = z;
    }

    public void setFullscreen(boolean z) {
        if (z == this.isFullscreen) {
            return;
        }
        this.isFullscreen = z;
        if (this.themedReactContext.getCurrentActivity() == null) {
            return;
        }
        if (this.isFullscreen) {
            this.fullScreenPlayerView = new FullScreenPlayerView(getContext(), this.exoPlayerView, this, this.playerControlView, new OnBackPressedCallback(true) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.6
                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    ReactExoplayerView.this.setFullscreen(false);
                }
            }, this.controlsConfig);
            this.eventEmitter.onVideoFullscreenPlayerWillPresent.invoke();
            FullScreenPlayerView fullScreenPlayerView = this.fullScreenPlayerView;
            if (fullScreenPlayerView != null) {
                fullScreenPlayerView.show();
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFullscreen$17();
                }
            });
        } else {
            this.eventEmitter.onVideoFullscreenPlayerWillDismiss.invoke();
            FullScreenPlayerView fullScreenPlayerView2 = this.fullScreenPlayerView;
            if (fullScreenPlayerView2 != null) {
                fullScreenPlayerView2.dismiss();
                reLayoutControls();
                setControls(this.controls);
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFullscreen$18();
                }
            });
        }
        updateFullScreenButtonVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFullscreen$17() {
        this.eventEmitter.onVideoFullscreenPlayerDidPresent.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFullscreen$18() {
        this.eventEmitter.onVideoFullscreenPlayerDidDismiss.invoke();
    }

    public void setHideShutterView(boolean z) {
        this.exoPlayerView.setHideShutterView(z);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmKeysLoaded");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        DebugLog.d("DRM Info", "onDrmSessionAcquired");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmSessionReleased");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, @NonNull Exception exc) {
        DebugLog.d("DRM Info", "onDrmSessionManagerError");
        this.eventEmitter.onVideoError.invoke("onDrmSessionManagerError", exc, "3002");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmKeysRestored");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmKeysRemoved");
    }

    public void setControls(boolean z) {
        this.controls = z;
        if (z) {
            addPlayerControl();
            updateFullScreenButtonVisibility();
        } else {
            int iIndexOfChild = indexOfChild(this.playerControlView);
            if (iIndexOfChild != -1) {
                removeViewAt(iIndexOfChild);
            }
        }
        refreshControlsStyles();
    }

    public void setSubtitleStyle(SubtitleStyle subtitleStyle) {
        this.exoPlayerView.setSubtitleStyle(subtitleStyle);
    }

    public void setShutterColor(Integer num) {
        this.exoPlayerView.setShutterColor(num.intValue());
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
    public void onAdEvent(AdEvent adEvent) {
        if (adEvent.getAdData() != null) {
            this.eventEmitter.onReceiveAdEvent.invoke(adEvent.getType().name(), adEvent.getAdData());
        } else {
            this.eventEmitter.onReceiveAdEvent.invoke(adEvent.getType().name(), null);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public void onAdError(AdErrorEvent adErrorEvent) {
        AdError error = adErrorEvent.getError();
        this.eventEmitter.onReceiveAdEvent.invoke("ERROR", ReactExoplayerView$$ExternalSyntheticBackport1.m(new Map.Entry[]{new AbstractMap.SimpleEntry("message", error.getMessage()), new AbstractMap.SimpleEntry("code", String.valueOf(error.getErrorCode())), new AbstractMap.SimpleEntry("type", String.valueOf(error.getErrorType()))}));
    }

    public void setControlsStyles(ControlsConfig controlsConfig) {
        this.controlsConfig = controlsConfig;
        refreshControlsStyles();
    }
}
