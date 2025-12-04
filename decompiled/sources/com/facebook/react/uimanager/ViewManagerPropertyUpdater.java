package com.facebook.react.uimanager;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagersPropertyCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006*+,-./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0007J?\u0010\u000e\u001a\u00020\r\"\u000e\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\b\b\u0001\u0010\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u000f2\u0006\u0010\u0014\u001a\u0002H\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J9\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u0002H\u0011\u0012\u0002\b\u00030\u00192\u0006\u0010\u0014\u001a\u0002H\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001aJ-\u0010\u000e\u001a\u00020\r\"\u000e\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u001b2\u0006\u0010\u001c\u001a\u0002H\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001dJ>\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001f2\u0018\u0010 \u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00020!\u0012\u0002\b\u00030\u00190\b2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\bH\u0007JB\u0010#\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0011\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u0002H\u00110\t\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0018\u0010$\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u0002H\u0011\u0012\u0002\b\u00030\u00190\bH\u0002J.\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000b\"\u000e\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u001b2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000f0\bH\u0002J!\u0010'\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0002\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;", "", "<init>", "()V", "TAG", "", "VIEW_MANAGER_SETTER_MAP", "", "Ljava/lang/Class;", "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;", "SHADOW_NODE_SETTER_MAP", "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;", "clear", "", "updateProps", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/uimanager/ViewManagerDelegate;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "delegate", "view", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "(Lcom/facebook/react/uimanager/ViewManagerDelegate;Landroid/view/View;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V", "manager", "Lcom/facebook/react/uimanager/ViewManager;", "(Lcom/facebook/react/uimanager/ViewManager;Landroid/view/View;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V", "Lcom/facebook/react/uimanager/ReactShadowNode;", "node", "(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V", "getNativeProps", "", "viewManagerTopClass", "", "shadowNodeTopClass", "findManagerSetter", "managerClass", "findNodeSetter", "nodeClass", "findGeneratedSetter", "cls", "(Ljava/lang/Class;)Ljava/lang/Object;", "Settable", "ViewManagerSetter", "ShadowNodeSetter", "FallbackViewManagerSetter", "FallbackShadowNodeSetter", "GenericViewManagerDelegate", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewManagerPropertyUpdater {

    @NotNull
    private static final String TAG = "ViewManagerPropertyUpdater";

    @NotNull
    public static final ViewManagerPropertyUpdater INSTANCE = new ViewManagerPropertyUpdater();

    @NotNull
    private static final Map<Class<?>, ViewManagerSetter<?, ?>> VIEW_MANAGER_SETTER_MAP = new HashMap();

    @NotNull
    private static final Map<Class<?>, ShadowNodeSetter<?>> SHADOW_NODE_SETTER_MAP = new HashMap();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$Settable;", "", "getProperties", "", "props", "", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Settable {
        void getProperties(@NotNull Map<String, String> props);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001 \u0000*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/uimanager/ReactShadowNode;", "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$Settable;", "setProperty", "", "node", "name", "", "value", "", "(Lcom/facebook/react/uimanager/ReactShadowNode;Ljava/lang/String;Ljava/lang/Object;)V", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ShadowNodeSetter<T extends ReactShadowNode<?>> extends Settable {
        void setProperty(@NotNull T node, @NotNull String name, @Nullable Object value);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0004\u0012\u0002H\u0003\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/uimanager/ViewManager;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$Settable;", "setProperty", "", "manager", "view", "name", "", "value", "", "(Lcom/facebook/react/uimanager/ViewManager;Landroid/view/View;Ljava/lang/String;Ljava/lang/Object;)V", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ViewManagerSetter<T extends ViewManager<V, ?>, V extends View> extends Settable {
        void setProperty(@NotNull T manager, @NotNull V view, @NotNull String name, @Nullable Object value);
    }

    private ViewManagerPropertyUpdater() {
    }

    @JvmStatic
    public static final void clear() {
        ViewManagersPropertyCache.clear();
        VIEW_MANAGER_SETTER_MAP.clear();
        SHADOW_NODE_SETTER_MAP.clear();
    }

    @Deprecated(message = "Use ViewManager#updateProperties to update a view's properties")
    @JvmStatic
    public static final <T extends ViewManagerDelegate<V>, V extends View> void updateProps(@NotNull T delegate, @NotNull V view, @NotNull ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Iterator<Map.Entry<String, Object>> entryIterator = props.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            delegate.kotlinCompat$setProperty(view, next.getKey(), next.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Use ViewManager#updateProperties to update a view's properties")
    @JvmStatic
    public static final <V extends View> void updateProps(@NotNull ViewManager<V, ?> manager, @NotNull V view, @NotNull ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        ViewManagerSetter viewManagerSetterFindManagerSetter = INSTANCE.findManagerSetter(manager.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = props.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            viewManagerSetterFindManagerSetter.setProperty(manager, view, next.getKey(), next.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ReactShadowNode<T>> void updateProps(@NotNull T node, @NotNull ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(props, "props");
        ShadowNodeSetter shadowNodeSetterFindNodeSetter = INSTANCE.findNodeSetter(node.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = props.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            shadowNodeSetterFindNodeSetter.setProperty(node, next.getKey(), next.getValue());
        }
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> getNativeProps(@NotNull Class<? extends ViewManager> viewManagerTopClass, @NotNull Class shadowNodeTopClass) {
        Intrinsics.checkNotNullParameter(viewManagerTopClass, "viewManagerTopClass");
        Intrinsics.checkNotNullParameter(shadowNodeTopClass, "shadowNodeTopClass");
        HashMap map = new HashMap();
        ViewManagerPropertyUpdater viewManagerPropertyUpdater = INSTANCE;
        viewManagerPropertyUpdater.findManagerSetter(viewManagerTopClass).getProperties(map);
        viewManagerPropertyUpdater.findNodeSetter(shadowNodeTopClass).getProperties(map);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <V extends View> ViewManagerSetter<ViewManager<V, ?>, V> findManagerSetter(Class<? extends ViewManager<V, ?>> managerClass) {
        Map<Class<?>, ViewManagerSetter<?, ?>> map = VIEW_MANAGER_SETTER_MAP;
        ViewManagerSetter<ViewManager<V, ?>, V> viewManagerSetter = (ViewManagerSetter) map.get(managerClass);
        if (viewManagerSetter != null) {
            return viewManagerSetter;
        }
        ViewManagerSetter<ViewManager<V, ?>, V> fallbackViewManagerSetter = (ViewManagerSetter) findGeneratedSetter(managerClass);
        if (fallbackViewManagerSetter == null) {
            fallbackViewManagerSetter = new FallbackViewManagerSetter<>(managerClass);
        }
        ViewManagerSetter<ViewManager<V, ?>, V> viewManagerSetter2 = fallbackViewManagerSetter;
        map.put(managerClass, viewManagerSetter2);
        return viewManagerSetter2;
    }

    private final <T extends ReactShadowNode<T>> ShadowNodeSetter<T> findNodeSetter(Class<? extends T> nodeClass) {
        Map<Class<?>, ShadowNodeSetter<?>> map = SHADOW_NODE_SETTER_MAP;
        ShadowNodeSetter<T> shadowNodeSetter = (ShadowNodeSetter) map.get(nodeClass);
        if (shadowNodeSetter != null) {
            return shadowNodeSetter;
        }
        ShadowNodeSetter<T> fallbackShadowNodeSetter = (ShadowNodeSetter) findGeneratedSetter(nodeClass);
        if (fallbackShadowNodeSetter == null) {
            Intrinsics.checkNotNull(nodeClass, "null cannot be cast to non-null type java.lang.Class<kotlin.Nothing>");
            fallbackShadowNodeSetter = new FallbackShadowNodeSetter(nodeClass);
        }
        ShadowNodeSetter<T> shadowNodeSetter2 = fallbackShadowNodeSetter;
        map.put(nodeClass, shadowNodeSetter2);
        return shadowNodeSetter2;
    }

    private final <T> T findGeneratedSetter(Class<?> cls) {
        String name = cls.getName();
        try {
            return (T) Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException unused) {
            FLog.w(TAG, "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e2);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00040\u0006¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00042\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0016R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;", "Lcom/facebook/react/uimanager/ViewManager;", "viewManagerClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "mPropSetters", "", "", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "setProperty", "", "manager", "view", "name", "value", "", "(Lcom/facebook/react/uimanager/ViewManager;Landroid/view/View;Ljava/lang/String;Ljava/lang/Object;)V", "getProperties", "props", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class FallbackViewManagerSetter<V extends View> implements ViewManagerSetter<ViewManager<V, ?>, V> {

        @NotNull
        private final Map<String, ViewManagersPropertyCache.PropSetter> mPropSetters;

        public FallbackViewManagerSetter(@NotNull Class<? extends ViewManager<V, ?>> viewManagerClass) {
            Intrinsics.checkNotNullParameter(viewManagerClass, "viewManagerClass");
            Map<String, ViewManagersPropertyCache.PropSetter> nativePropSettersForViewManagerClass = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(viewManagerClass);
            Intrinsics.checkNotNullExpressionValue(nativePropSettersForViewManagerClass, "getNativePropSettersForViewManagerClass(...)");
            this.mPropSetters = nativePropSettersForViewManagerClass;
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter
        public void setProperty(@NotNull ViewManager<V, ?> manager, @NotNull V view, @NotNull String name, @Nullable Object value) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(name, "name");
            ViewManagersPropertyCache.PropSetter propSetter = this.mPropSetters.get(name);
            if (propSetter != null) {
                propSetter.updateViewProp(manager, view, value);
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public void getProperties(@NotNull Map<String, String> props) {
            Intrinsics.checkNotNullParameter(props, "props");
            for (ViewManagersPropertyCache.PropSetter propSetter : this.mPropSetters.values()) {
                props.put(propSetter.getPropName(), propSetter.getPropType());
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0014H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackShadowNodeSetter;", "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;", "Lcom/facebook/react/uimanager/ReactShadowNode;", "shadowNodeClass", "Ljava/lang/Class;", "", "<init>", "(Ljava/lang/Class;)V", "propSetters", "", "", "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;", "setProperty", "", "node", "name", "value", "", "getProperties", "props", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class FallbackShadowNodeSetter implements ShadowNodeSetter<ReactShadowNode<?>> {

        @NotNull
        private final Map<String, ViewManagersPropertyCache.PropSetter> propSetters;

        public FallbackShadowNodeSetter(@NotNull Class shadowNodeClass) {
            Intrinsics.checkNotNullParameter(shadowNodeClass, "shadowNodeClass");
            Map<String, ViewManagersPropertyCache.PropSetter> nativePropSettersForShadowNodeClass = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(shadowNodeClass);
            Intrinsics.checkNotNullExpressionValue(nativePropSettersForShadowNodeClass, "getNativePropSettersForShadowNodeClass(...)");
            this.propSetters = nativePropSettersForShadowNodeClass;
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter
        public void setProperty(@NotNull ReactShadowNode<?> node, @NotNull String name, @Nullable Object value) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(name, "name");
            ViewManagersPropertyCache.PropSetter propSetter = this.propSetters.get(name);
            if (propSetter != null) {
                propSetter.updateShadowNodeProp(node, value);
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public void getProperties(@NotNull Map<String, String> props) {
            Intrinsics.checkNotNullParameter(props, "props");
            for (ViewManagersPropertyCache.PropSetter propSetter : this.propSetters.values()) {
                props.put(propSetter.getPropName(), propSetter.getPropType());
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J'\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$GenericViewManagerDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "manager", "Lcom/facebook/react/uimanager/ViewManager;", "<init>", "(Lcom/facebook/react/uimanager/ViewManager;)V", "setter", "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;", "setProperty", "", "view", "propName", "", "value", "", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Object;)V", "receiveCommand", "commandName", "args", "Lcom/facebook/react/bridge/ReadableArray;", "(Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;)V", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GenericViewManagerDelegate<T extends View> implements ViewManagerDelegate<T> {

        @NotNull
        private final ViewManager<T, ?> manager;

        @NotNull
        private final ViewManagerSetter<ViewManager<T, ?>, T> setter;

        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        /* renamed from: receiveCommand, reason: merged with bridge method [inline-methods] */
        public void kotlinCompat$receiveCommand(@NotNull T view, @NotNull String commandName, @Nullable ReadableArray args) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(commandName, "commandName");
        }

        public GenericViewManagerDelegate(@NotNull ViewManager<T, ?> manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.manager = manager;
            this.setter = ViewManagerPropertyUpdater.INSTANCE.findManagerSetter(manager.getClass());
        }

        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        /* renamed from: setProperty, reason: merged with bridge method [inline-methods] */
        public void kotlinCompat$setProperty(@NotNull T view, @NotNull String propName, @Nullable Object value) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(propName, "propName");
            this.setter.setProperty(this.manager, view, propName, value);
        }
    }
}
