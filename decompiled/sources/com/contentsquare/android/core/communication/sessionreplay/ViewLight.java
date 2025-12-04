package com.contentsquare.android.core.communication.sessionreplay;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.VisibleForTesting;
import androidx.camera.video.AudioStats;
import com.contentsquare.android.core.utils.InstanceCreator;
import com.contentsquare.android.core.utils.Recycler;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 y2\u00020\u0001:\u0001yB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010g\u001a\u00020JJ*\u0010h\u001a\u00020i2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00000k2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002050mH\u0002J\"\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00000k2\u0014\b\u0002\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002050mJ$\u0010o\u001a\u00020i2\n\u0010p\u001a\u00060qj\u0002`r2\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000eH\u0002J\b\u0010u\u001a\u00020iH\u0007J\u001e\u0010v\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000k\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000k0wJ\b\u0010x\u001a\u00020\u000eH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001c\u0010.\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001a\u00101\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\u001a\u0010;\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u001a\u0010=\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001a\u0010?\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00106\"\u0004\b@\u00108R\u001a\u0010A\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00106\"\u0004\bB\u00108R\u001a\u0010C\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00106\"\u0004\bD\u00108R\u001a\u0010E\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00106\"\u0004\bF\u00108R\u001a\u0010G\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00106\"\u0004\bH\u00108R\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001a\u0010R\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001a\u0010U\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010L\"\u0004\bW\u0010NR\u001c\u0010X\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010%\"\u0004\bZ\u0010'R\u001e\u0010[\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0016\"\u0004\b]\u0010\u0018R\u001c\u0010^\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R\u001e\u0010a\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0016\"\u0004\bc\u0010\u0018R\u001a\u0010d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\b¨\u0006z"}, d2 = {"Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;", "", "()V", ViewProps.BACKGROUND_COLOR, "", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "children", "", "getChildren", "()Ljava/util/List;", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "clippedPercentage", "", "getClippedPercentage", "()F", "setClippedPercentage", "(F)V", "editableText", "getEditableText", "setEditableText", "encodedBitmap", "", "getEncodedBitmap", "()[B", "setEncodedBitmap", "([B)V", "errorText", "", "getErrorText", "()Ljava/lang/CharSequence;", "setErrorText", "(Ljava/lang/CharSequence;)V", "height", "getHeight", "setHeight", "hintText", "getHintText", "setHintText", "incrementalPath", "getIncrementalPath", "setIncrementalPath", "indexInParent", "getIndexInParent", "setIndexInParent", "isAnimating", "", "()Z", "setAnimating", "(Z)V", "isBitmapHashChanged", "setBitmapHashChanged", "isClickable", "setClickable", "isClipChildren", "setClipChildren", "isForceMasked", "setForceMasked", "isMasked", "setMasked", "isTransparent", "setTransparent", "isVisible", "setVisible", "isWebView", "setWebView", "parentId", "", "getParentId", "()J", "setParentId", "(J)V", "posX", "getPosX", "setPosX", "posY", "getPosY", "setPosY", "recordingId", "getRecordingId", "setRecordingId", "text", "getText", "setText", "viewAlpha", "getViewAlpha", "setViewAlpha", "viewBitmapHash", "getViewBitmapHash", "setViewBitmapHash", "visibilityPercentage", "getVisibilityPercentage", "setVisibilityPercentage", "width", "getWidth", "setWidth", "computePropertiesHash", "convertToListRecursively", "", "viewLightList", "Ljava/util/LinkedList;", "predicate", "Lkotlin/Function1;", "flattenAndReverse", "printRecursive", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "prefix", "childrenPrefix", "reset", "splitFlattenAndReverse", "Lkotlin/Pair;", "toString", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewLight.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewLight.kt\ncom/contentsquare/android/core/communication/sessionreplay/ViewLight\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,256:1\n1855#2,2:257\n1855#2,2:259\n*S KotlinDebug\n*F\n+ 1 ViewLight.kt\ncom/contentsquare/android/core/communication/sessionreplay/ViewLight\n*L\n137#1:257,2\n168#1:259,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ViewLight {
    private static final int BUFFER_SIZE = 300;

    @NotNull
    public static final String CLASS_NAME = "SR_CLASS_NAME";

    @NotNull
    public static final String FULL_PATH = "SR_FULL_PATH";

    @NotNull
    public static final String NO_ID = "NO_ID";
    public static final int NO_INDEX_IN_PARENT = -1;
    public static final long NO_PARENT_ID = -1;
    private static final int PRIME_NUMBER = 31;

    @ColorInt
    private int backgroundColor;

    @NotNull
    private final List<ViewLight> children = new ArrayList();

    @Nullable
    private String className;
    private float clippedPercentage;

    @Nullable
    private String editableText;

    @Nullable
    private byte[] encodedBitmap;

    @Nullable
    private CharSequence errorText;
    private int height;

    @Nullable
    private CharSequence hintText;

    @Nullable
    private String incrementalPath;
    private int indexInParent;
    private boolean isAnimating;
    private boolean isBitmapHashChanged;
    private boolean isClickable;
    private boolean isClipChildren;
    private boolean isForceMasked;
    private boolean isMasked;
    private boolean isTransparent;
    private boolean isVisible;
    private boolean isWebView;
    private long parentId;
    private int posX;
    private int posY;
    private long recordingId;

    @Nullable
    private CharSequence text;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    private float viewAlpha;

    @Nullable
    private String viewBitmapHash;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    private float visibilityPercentage;
    private int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static Recycler<ViewLight> recycler = new Recycler<>();

    @NotNull
    private static final InstanceCreator<ViewLight> viewLightInstanceCreator = new InstanceCreator() { // from class: com.contentsquare.android.core.communication.sessionreplay.ViewLight$$ExternalSyntheticLambda0
        @Override // com.contentsquare.android.core.utils.InstanceCreator
        public final Object create() {
            return ViewLight.viewLightInstanceCreator$lambda$2();
        }
    };

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight$Companion;", "", "()V", "BUFFER_SIZE", "", "CLASS_NAME", "", "FULL_PATH", ViewLight.NO_ID, "NO_INDEX_IN_PARENT", "NO_PARENT_ID", "", "PRIME_NUMBER", "recycler", "Lcom/contentsquare/android/core/utils/Recycler;", "Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;", "getRecycler$annotations", "getRecycler", "()Lcom/contentsquare/android/core/utils/Recycler;", "setRecycler", "(Lcom/contentsquare/android/core/utils/Recycler;)V", "viewLightInstanceCreator", "Lcom/contentsquare/android/core/utils/InstanceCreator;", "hasChangedSinceThePreviousFrame", "", "previousViewLight", "currentViewLight", "obtain", "recycleRecursive", "", "viewLight", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getRecycler$annotations() {
        }

        @NotNull
        public final Recycler<ViewLight> getRecycler() {
            return ViewLight.recycler;
        }

        public final boolean hasChangedSinceThePreviousFrame(ViewLight previousViewLight, ViewLight currentViewLight) {
            Intrinsics.checkNotNullParameter(previousViewLight, "previousViewLight");
            Intrinsics.checkNotNullParameter(currentViewLight, "currentViewLight");
            return (!currentViewLight.getIsBitmapHashChanged() && previousViewLight.computePropertiesHash() == currentViewLight.computePropertiesHash() && previousViewLight.getBackgroundColor() == currentViewLight.getBackgroundColor()) ? false : true;
        }

        @NotNull
        public final ViewLight obtain() {
            ViewLight viewLightObtain = getRecycler().obtain(ViewLight.viewLightInstanceCreator);
            viewLightObtain.reset();
            return viewLightObtain;
        }

        public final void recycleRecursive(ViewLight viewLight) {
            Intrinsics.checkNotNullParameter(viewLight, "viewLight");
            List<ViewLight> children = viewLight.getChildren();
            int size = children.size();
            for (int i = 0; i < size; i++) {
                recycleRecursive(children.get(i));
            }
            getRecycler().recycle(viewLight);
        }

        public final void setRecycler(Recycler<ViewLight> recycler) {
            Intrinsics.checkNotNullParameter(recycler, "<set-?>");
            ViewLight.recycler = recycler;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void convertToListRecursively(LinkedList<ViewLight> viewLightList, Function1<? super ViewLight, Boolean> predicate) {
        if (predicate.invoke(this).booleanValue()) {
            viewLightList.addFirst(this);
        }
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            ((ViewLight) it.next()).convertToListRecursively(viewLightList, predicate);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinkedList flattenAndReverse$default(ViewLight viewLight, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<ViewLight, Boolean>() { // from class: com.contentsquare.android.core.communication.sessionreplay.ViewLight.flattenAndReverse.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(ViewLight it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        return viewLight.flattenAndReverse(function1);
    }

    private final void printRecursive(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append("id=");
        buffer.append(this.recordingId);
        buffer.append(" path=");
        buffer.append(this.incrementalPath);
        buffer.append(" pos=");
        buffer.append(this.posX);
        buffer.append(',');
        buffer.append(this.posY);
        buffer.append(';');
        buffer.append(this.width);
        buffer.append(',');
        buffer.append(this.height);
        buffer.append('\n');
        int size = this.children.size();
        int i = 0;
        while (i < size) {
            ViewLight viewLight = this.children.get(i);
            String str = childrenPrefix + "├── ";
            StringBuilder sb = new StringBuilder();
            sb.append(childrenPrefix);
            sb.append(i != this.children.size() + (-1) ? "│   " : "    ");
            viewLight.printRecursive(buffer, str, sb.toString());
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewLight viewLightInstanceCreator$lambda$2() {
        return new ViewLight();
    }

    public final long computePropertiesHash() {
        long j = 31;
        return (((((((((((((((((((((this.width * j) + this.height) * j) + this.posX) * j) + this.posY) * j) + (this.isVisible ? 1L : 0L)) * j) + Float.floatToIntBits(this.viewAlpha)) * j) + (this.isClipChildren ? 1L : 0L)) * j) + (this.isMasked ? 1L : 0L)) * j) + (this.text != null ? r4.hashCode() : 0)) * j) + (this.editableText != null ? r4.hashCode() : 0)) * j) + (this.errorText != null ? r4.hashCode() : 0)) * j) + (this.hintText != null ? r8.hashCode() : 0);
    }

    @NotNull
    public final LinkedList<ViewLight> flattenAndReverse(Function1<? super ViewLight, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        LinkedList<ViewLight> linkedList = new LinkedList<>();
        convertToListRecursively(linkedList, predicate);
        return linkedList;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final List<ViewLight> getChildren() {
        return this.children;
    }

    @Nullable
    public final String getClassName() {
        return this.className;
    }

    public final float getClippedPercentage() {
        return this.clippedPercentage;
    }

    @Nullable
    public final String getEditableText() {
        return this.editableText;
    }

    @Nullable
    public final byte[] getEncodedBitmap() {
        return this.encodedBitmap;
    }

    @Nullable
    public final CharSequence getErrorText() {
        return this.errorText;
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final CharSequence getHintText() {
        return this.hintText;
    }

    @Nullable
    public final String getIncrementalPath() {
        return this.incrementalPath;
    }

    public final int getIndexInParent() {
        return this.indexInParent;
    }

    public final long getParentId() {
        return this.parentId;
    }

    public final int getPosX() {
        return this.posX;
    }

    public final int getPosY() {
        return this.posY;
    }

    public final long getRecordingId() {
        return this.recordingId;
    }

    @Nullable
    public final CharSequence getText() {
        return this.text;
    }

    public final float getViewAlpha() {
        return this.viewAlpha;
    }

    @Nullable
    public final String getViewBitmapHash() {
        return this.viewBitmapHash;
    }

    public final float getVisibilityPercentage() {
        return this.visibilityPercentage;
    }

    public final int getWidth() {
        return this.width;
    }

    /* renamed from: isAnimating, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    /* renamed from: isBitmapHashChanged, reason: from getter */
    public final boolean getIsBitmapHashChanged() {
        return this.isBitmapHashChanged;
    }

    /* renamed from: isClickable, reason: from getter */
    public final boolean getIsClickable() {
        return this.isClickable;
    }

    /* renamed from: isClipChildren, reason: from getter */
    public final boolean getIsClipChildren() {
        return this.isClipChildren;
    }

    /* renamed from: isForceMasked, reason: from getter */
    public final boolean getIsForceMasked() {
        return this.isForceMasked;
    }

    /* renamed from: isMasked, reason: from getter */
    public final boolean getIsMasked() {
        return this.isMasked;
    }

    /* renamed from: isTransparent, reason: from getter */
    public final boolean getIsTransparent() {
        return this.isTransparent;
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* renamed from: isWebView, reason: from getter */
    public final boolean getIsWebView() {
        return this.isWebView;
    }

    @VisibleForTesting
    public final void reset() {
        this.recordingId = 0L;
        this.width = 0;
        this.height = 0;
        this.posX = 0;
        this.posY = 0;
        this.clippedPercentage = BitmapDescriptorFactory.HUE_RED;
        this.backgroundColor = 0;
        this.viewAlpha = BitmapDescriptorFactory.HUE_RED;
        this.isVisible = false;
        this.isClipChildren = true;
        this.viewBitmapHash = null;
        this.encodedBitmap = null;
        this.text = null;
        this.errorText = null;
        this.hintText = null;
        this.editableText = null;
        this.parentId = -1L;
        this.indexInParent = -1;
        this.children.clear();
        this.isMasked = true;
        this.isForceMasked = false;
        this.isAnimating = false;
        this.isBitmapHashChanged = false;
        this.visibilityPercentage = 1.0f;
        this.isWebView = false;
        this.isTransparent = false;
        this.isClickable = false;
        this.className = null;
        this.incrementalPath = null;
    }

    public final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void setBitmapHashChanged(boolean z) {
        this.isBitmapHashChanged = z;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    public final void setClickable(boolean z) {
        this.isClickable = z;
    }

    public final void setClipChildren(boolean z) {
        this.isClipChildren = z;
    }

    public final void setClippedPercentage(float f) {
        this.clippedPercentage = f;
    }

    public final void setEditableText(String str) {
        this.editableText = str;
    }

    public final void setEncodedBitmap(byte[] bArr) {
        this.encodedBitmap = bArr;
    }

    public final void setErrorText(CharSequence charSequence) {
        this.errorText = charSequence;
    }

    public final void setForceMasked(boolean z) {
        this.isForceMasked = z;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setHintText(CharSequence charSequence) {
        this.hintText = charSequence;
    }

    public final void setIncrementalPath(String str) {
        this.incrementalPath = str;
    }

    public final void setIndexInParent(int i) {
        this.indexInParent = i;
    }

    public final void setMasked(boolean z) {
        this.isMasked = z;
    }

    public final void setParentId(long j) {
        this.parentId = j;
    }

    public final void setPosX(int i) {
        this.posX = i;
    }

    public final void setPosY(int i) {
        this.posY = i;
    }

    public final void setRecordingId(long j) {
        this.recordingId = j;
    }

    public final void setText(CharSequence charSequence) {
        this.text = charSequence;
    }

    public final void setTransparent(boolean z) {
        this.isTransparent = z;
    }

    public final void setViewAlpha(float f) {
        this.viewAlpha = f;
    }

    public final void setViewBitmapHash(String str) {
        this.viewBitmapHash = str;
    }

    public final void setVisibilityPercentage(float f) {
        this.visibilityPercentage = f;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final void setWebView(boolean z) {
        this.isWebView = z;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    @NotNull
    public final Pair<LinkedList<ViewLight>, LinkedList<ViewLight>> splitFlattenAndReverse() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        linkedList3.push(this);
        while (!linkedList3.isEmpty()) {
            ViewLight viewLight = (ViewLight) linkedList3.removeFirst();
            if (!viewLight.isWebView) {
                if (viewLight.isMasked && !viewLight.isTransparent && viewLight.children.isEmpty()) {
                    linkedList.addFirst(viewLight);
                } else {
                    linkedList2.addFirst(viewLight);
                }
                Iterator it = CollectionsKt.reversed(viewLight.children).iterator();
                while (it.hasNext()) {
                    linkedList3.addFirst((ViewLight) it.next());
                }
            }
        }
        return new Pair<>(linkedList, linkedList2);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder(300);
        printRecursive(sb, "", "");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "treeStr.toString()");
        return string;
    }
}
