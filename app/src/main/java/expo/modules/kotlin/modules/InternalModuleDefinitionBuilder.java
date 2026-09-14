package expo.modules.kotlin.modules;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.urbanairship.actions.RateAppAction;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.classcomponent.ClassDefinitionData;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithPayload;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.TypeConverterProviderKt;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.ViewManagerDefinition;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020$2\u0006\u0010\f\u001a\u00020\rJ\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u0015H\u0001JE\u0010:\u001a\u00020$\"\n\b\u0000\u0010;\u0018\u0001*\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H;0>2\u001d\u0010?\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H;0A\u0012\u0004\u0012\u00020$0@¢\u0006\u0002\b&H\u0086\bø\u0001\u0000J\u001c\u0010B\u001a\u00020$2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u00020$0CH\u0086\bø\u0001\u0000J4\u0010D\u001a\u00020$2'\u0010?\u001a#\b\u0001\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%0!¢\u0006\u0002\b&¢\u0006\u0002\u0010+J\u001c\u0010E\u001a\u00020$2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u00020$0CH\u0086\bø\u0001\u0000J\u001c\u0010F\u001a\u00020$2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u00020$0CH\u0086\bø\u0001\u0000J\u001c\u0010G\u001a\u00020$2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u00020$0CH\u0086\bø\u0001\u0000J\u001c\u0010H\u001a\u00020$2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u00020$0CH\u0086\bø\u0001\u0000J\u001c\u0010I\u001a\u00020$2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u00020$0CH\u0086\bø\u0001\u0000J\"\u0010J\u001a\u00020$2\u0014\b\u0004\u0010?\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020$0@H\u0086\bø\u0001\u0000J(\u0010L\u001a\u00020$2\u001a\b\u0004\u0010?\u001a\u0014\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020$0!H\u0086\bø\u0001\u0000J5\u0010O\u001a\u00020$2\u0006\u0010\f\u001a\u00020\r2\u001f\b\u0002\u0010?\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0P\u0012\u0004\u0012\u00020$0@¢\u0006\u0002\b&H\u0086\bø\u0001\u0000JQ\u0010O\u001a\u00020$\"\n\b\u0000\u0010Q\u0018\u0001*\u00020R2\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u0002HQ0>2\u001f\b\u0002\u0010?\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002HQ0P\u0012\u0004\u0012\u00020$0@¢\u0006\u0002\b&H\u0086\bø\u0001\u0000JI\u0010O\u001a\u00020$\"\n\b\u0000\u0010Q\u0018\u0001*\u00020R2\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u0002HQ0>2\u001f\b\u0002\u0010?\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002HQ0P\u0012\u0004\u0012\u00020$0@¢\u0006\u0002\b&H\u0086\bø\u0001\u0000R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u00148\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u0018RI\u0010 \u001a%\b\u0001\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010!¢\u0006\u0002\b&8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010,\u0012\u0004\b'\u0010\t\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\t\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006T"}, m1836d2 = {"Lexpo/modules/kotlin/modules/InternalModuleDefinitionBuilder;", "Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "converters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "(Lexpo/modules/kotlin/modules/Module;Lexpo/modules/kotlin/types/TypeConverterProvider;)V", "getModule$annotations", "()V", "getModule", "()Lexpo/modules/kotlin/modules/Module;", "name", "", "getName$annotations", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "viewManagerDefinitions", "", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getViewManagerDefinitions$annotations", "getViewManagerDefinitions", "()Ljava/util/Map;", "setViewManagerDefinitions", "(Ljava/util/Map;)V", "eventListeners", "Lexpo/modules/kotlin/events/EventName;", "Lexpo/modules/kotlin/events/EventListener;", "getEventListeners$annotations", "getEventListeners", "registerContracts", "Lkotlin/Function2;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "getRegisterContracts$annotations", "getRegisterContracts", "()Lkotlin/jvm/functions/Function2;", "setRegisterContracts", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "classData", "", "Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "getClassData$annotations", "getClassData", "()Ljava/util/List;", "setClassData", "(Ljava/util/List;)V", "buildModule", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Name", "registerViewDefinition", "definition", "View", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "viewClass", "Lkotlin/reflect/KClass;", RateAppAction.BODY_KEY, "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "OnCreate", "Lkotlin/Function0;", "RegisterActivityContracts", "OnDestroy", "OnActivityEntersForeground", "OnActivityEntersBackground", "OnUserLeavesActivity", "OnActivityDestroys", "OnNewIntent", "Landroid/content/Intent;", "OnActivityResult", "Landroid/app/Activity;", "Lexpo/modules/kotlin/events/OnActivityResultPayload;", "Class", "Lexpo/modules/kotlin/classcomponent/ClassComponentBuilder;", "SharedObjectType", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "sharedObjectClass", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DefinitionMarker
@SourceDebugExtension({"SMAP\nModuleDefinitionBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleDefinitionBuilder.kt\nexpo/modules/kotlin/modules/InternalModuleDefinitionBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AnyType.kt\nexpo/modules/kotlin/types/AnyTypeKt\n+ 4 AnyType.kt\nexpo/modules/kotlin/types/AnyTypeProvider\n*L\n1#1,213:1\n1#2:214\n167#3,2:215\n158#3,11:219\n167#3,2:230\n158#3,11:234\n167#3,2:245\n158#3,11:249\n143#4,2:217\n143#4,2:232\n143#4,2:247\n*S KotlinDebug\n*F\n+ 1 ModuleDefinitionBuilder.kt\nexpo/modules/kotlin/modules/InternalModuleDefinitionBuilder\n*L\n175#1:215,2\n175#1:219,11\n191#1:230,2\n191#1:234,11\n206#1:245,2\n206#1:249,11\n175#1:217,2\n191#1:232,2\n206#1:247,2\n*E\n"})
public class InternalModuleDefinitionBuilder extends ObjectDefinitionBuilder {
    private List classData;
    private final Map eventListeners;
    private final Module module;
    private String name;
    private Function2 registerContracts;
    private Map viewManagerDefinitions;

    public InternalModuleDefinitionBuilder() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @PublishedApi
    public static /* synthetic */ void getClassData$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getEventListeners$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getModule$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getName$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getRegisterContracts$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getViewManagerDefinitions$annotations() {
    }

    @Nullable
    public final Module getModule() {
        return this.module;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InternalModuleDefinitionBuilder(Module module, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TypeConverterProvider typeConverterProviderConverters;
        module = (i & 1) != 0 ? null : module;
        this(module, (i & 2) != 0 ? (module == null || (typeConverterProviderConverters = module.converters()) == null) ? null : TypeConverterProviderKt.mergeWithDefault(typeConverterProviderConverters) : typeConverterProvider);
    }

    public InternalModuleDefinitionBuilder(@Nullable Module module, @Nullable TypeConverterProvider typeConverterProvider) {
        super(typeConverterProvider);
        this.module = module;
        this.viewManagerDefinitions = new LinkedHashMap();
        this.eventListeners = new LinkedHashMap();
        this.classData = new ArrayList();
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    @NotNull
    public final Map<String, ViewManagerDefinition> getViewManagerDefinitions() {
        return this.viewManagerDefinitions;
    }

    public final void setViewManagerDefinitions(@NotNull Map<String, ViewManagerDefinition> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.viewManagerDefinitions = map;
    }

    @NotNull
    public final Map<EventName, EventListener> getEventListeners() {
        return this.eventListeners;
    }

    @Nullable
    public final Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> getRegisterContracts() {
        return this.registerContracts;
    }

    public final void setRegisterContracts(@Nullable Function2<? super AppContextActivityResultCaller, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.registerContracts = function2;
    }

    @NotNull
    public final List<ClassDefinitionData> getClassData() {
        return this.classData;
    }

    public final void setClassData(@NotNull List<ClassDefinitionData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.classData = list;
    }

    @NotNull
    public final ModuleDefinitionData buildModule() {
        String simpleName = this.name;
        if (simpleName == null) {
            Module module = this.module;
            simpleName = module != null ? module.getClass().getSimpleName() : null;
        }
        String str = simpleName;
        if (str != null) {
            return new ModuleDefinitionData(str, buildObject(), this.viewManagerDefinitions, this.eventListeners, this.registerContracts, this.classData);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final void Name(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @PublishedApi
    public final void registerViewDefinition(@NotNull ViewManagerDefinition definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        if (definition.getName() != null) {
            if (this.viewManagerDefinitions.containsKey(definition.getName())) {
                throw new IllegalArgumentException(("The module definition defines more than one view with name " + definition.getName() + InstructionFileId.DOT).toString());
            }
            this.viewManagerDefinitions.put(definition.getName(), definition);
        }
        if (this.viewManagerDefinitions.containsKey(ModuleDefinitionBuilderKt.DEFAULT_MODULE_VIEW)) {
            return;
        }
        this.viewManagerDefinitions.put(ModuleDefinitionBuilderKt.DEFAULT_MODULE_VIEW, definition);
    }

    public final /* synthetic */ <T extends View> void View(KClass<T> viewClass, Function1<? super ViewDefinitionBuilder<T>, Unit> body) {
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(View.class);
        Intrinsics.needClassReification();
        ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(viewClass, new LazyKType(orCreateKotlinClass, false, new Function0<KType>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder$View$viewDefinitionBuilder$1
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                return null;
            }
        }, 2, null), getConverters());
        CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
        body.invoke(viewDefinitionBuilder);
        registerViewDefinition(viewDefinitionBuilder.build());
    }

    public final void OnCreate(@NotNull final Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.MODULE_CREATE;
        eventListeners.put(eventName, new BasicEventListener(eventName, new Function0<Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnCreate.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                body.invoke();
            }
        }));
    }

    public final void RegisterActivityContracts(@NotNull Function2<? super AppContextActivityResultCaller, ? super Continuation<? super Unit>, ? extends Object> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.registerContracts = body;
    }

    public final void OnDestroy(@NotNull final Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.MODULE_DESTROY;
        eventListeners.put(eventName, new BasicEventListener(eventName, new Function0<Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnDestroy.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                body.invoke();
            }
        }));
    }

    public final void OnActivityEntersForeground(@NotNull final Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.ACTIVITY_ENTERS_FOREGROUND;
        eventListeners.put(eventName, new BasicEventListener(eventName, new Function0<Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnActivityEntersForeground.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                body.invoke();
            }
        }));
    }

    public final void OnActivityEntersBackground(@NotNull final Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.ACTIVITY_ENTERS_BACKGROUND;
        eventListeners.put(eventName, new BasicEventListener(eventName, new Function0<Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnActivityEntersBackground.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                body.invoke();
            }
        }));
    }

    public final void OnUserLeavesActivity(@NotNull final Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.ON_USER_LEAVES_ACTIVITY;
        eventListeners.put(eventName, new BasicEventListener(eventName, new Function0<Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnUserLeavesActivity.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                body.invoke();
            }
        }));
    }

    public final void OnActivityDestroys(@NotNull final Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.ACTIVITY_DESTROYS;
        eventListeners.put(eventName, new BasicEventListener(eventName, new Function0<Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnActivityDestroys.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                body.invoke();
            }
        }));
    }

    public final void OnNewIntent(@NotNull final Function1<? super Intent, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.ON_NEW_INTENT;
        eventListeners.put(eventName, new EventListenerWithPayload(eventName, new Function1<Intent, Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnNewIntent.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                body.invoke(it);
            }
        }));
    }

    public final void OnActivityResult(@NotNull final Function2<? super Activity, ? super OnActivityResultPayload, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<EventName, EventListener> eventListeners = getEventListeners();
        EventName eventName = EventName.ON_ACTIVITY_RESULT;
        eventListeners.put(eventName, new EventListenerWithSenderAndPayload(eventName, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.OnActivityResult.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                invoke2(activity, onActivityResultPayload);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                Intrinsics.checkNotNullParameter(sender, "sender");
                Intrinsics.checkNotNullParameter(payload, "payload");
                body.invoke(sender, payload);
            }
        }));
    }

    public static /* synthetic */ void Class$default(InternalModuleDefinitionBuilder internalModuleDefinitionBuilder, String name, Function1 body, int i, Object obj) {
        AnyType anyType;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Class");
        }
        if ((i & 2) != 0) {
            body = new Function1<ClassComponentBuilder<Unit>, Unit>() { // from class: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder.Class.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClassComponentBuilder<Unit> classComponentBuilder) {
                    Intrinsics.checkNotNullParameter(classComponentBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClassComponentBuilder<Unit> classComponentBuilder) {
                    invoke2(classComponentBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Module module = internalModuleDefinitionBuilder.getModule();
        if (module == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        AppContext appContext = module.getAppContext();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        AnyType anyType2 = anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Unit.class), Boolean.FALSE));
        if (anyType2 == null) {
            anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Unit.class), false, C6307x9e61a209.INSTANCE), null);
        } else {
            anyType = anyType2;
        }
        ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, name, orCreateKotlinClass, anyType, internalModuleDefinitionBuilder.getConverters());
        body.invoke(classComponentBuilder);
        internalModuleDefinitionBuilder.getClassData().add(classComponentBuilder.buildClass());
    }

    public final void Class(@NotNull String name, @NotNull Function1<? super ClassComponentBuilder<Unit>, Unit> body) {
        AnyType anyType;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Module module = getModule();
        if (module == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        AppContext appContext = module.getAppContext();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        AnyType anyType2 = anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Unit.class), Boolean.FALSE));
        if (anyType2 == null) {
            anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Unit.class), false, C6307x9e61a209.INSTANCE), null);
        } else {
            anyType = anyType2;
        }
        ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, name, orCreateKotlinClass, anyType, getConverters());
        body.invoke(classComponentBuilder);
        getClassData().add(classComponentBuilder.buildClass());
    }

    public static /* synthetic */ void Class$default(InternalModuleDefinitionBuilder internalModuleDefinitionBuilder, String name, KClass kClass, Function1 body, int i, Object obj) {
        AnyType anyType;
        if (obj == null) {
            if ((i & 2) != 0) {
                Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
                kClass = Reflection.getOrCreateKotlinClass(SharedObject.class);
            }
            KClass sharedObjectClass = kClass;
            if ((i & 4) != 0) {
                Intrinsics.needClassReification();
                body = C63112.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(sharedObjectClass, "sharedObjectClass");
            Intrinsics.checkNotNullParameter(body, "body");
            Module module = internalModuleDefinitionBuilder.getModule();
            if (module != null) {
                AppContext appContext = module.getAppContext();
                AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
                AnyType anyType2 = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
                if (anyType2 == null) {
                    Intrinsics.needClassReification();
                    C6308x9e61a20a c6308x9e61a20a = C6308x9e61a20a.INSTANCE;
                    Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                    Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
                    anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, c6308x9e61a20a), null);
                } else {
                    anyType = anyType2;
                }
                ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, name, sharedObjectClass, anyType, internalModuleDefinitionBuilder.getConverters());
                body.invoke(classComponentBuilder);
                internalModuleDefinitionBuilder.getClassData().add(classComponentBuilder.buildClass());
                return;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Class");
    }

    public final /* synthetic */ <SharedObjectType extends SharedObject> void Class(String name, KClass<SharedObjectType> sharedObjectClass, Function1<? super ClassComponentBuilder<SharedObjectType>, Unit> body) {
        AnyType anyType;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sharedObjectClass, "sharedObjectClass");
        Intrinsics.checkNotNullParameter(body, "body");
        Module module = getModule();
        if (module != null) {
            AppContext appContext = module.getAppContext();
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
            AnyType anyType2 = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
            if (anyType2 == null) {
                Intrinsics.needClassReification();
                C6308x9e61a20a c6308x9e61a20a = C6308x9e61a20a.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, c6308x9e61a20a), null);
            } else {
                anyType = anyType2;
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, name, sharedObjectClass, anyType, getConverters());
            body.invoke(classComponentBuilder);
            getClassData().add(classComponentBuilder.buildClass());
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public static /* synthetic */ void Class$default(InternalModuleDefinitionBuilder internalModuleDefinitionBuilder, KClass kClass, Function1 body, int i, Object obj) {
        AnyType anyType;
        if (obj == null) {
            if ((i & 1) != 0) {
                Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
                kClass = Reflection.getOrCreateKotlinClass(SharedObject.class);
            }
            KClass sharedObjectClass = kClass;
            if ((i & 2) != 0) {
                Intrinsics.needClassReification();
                body = C63123.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(sharedObjectClass, "sharedObjectClass");
            Intrinsics.checkNotNullParameter(body, "body");
            Module module = internalModuleDefinitionBuilder.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            AppContext appContext = module.getAppContext();
            String simpleName = JvmClassMappingKt.getJavaClass(sharedObjectClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
            AnyType anyType2 = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
            if (anyType2 == null) {
                Intrinsics.needClassReification();
                C6309x9e61a20b c6309x9e61a20b = C6309x9e61a20b.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, c6309x9e61a20b), null);
            } else {
                anyType = anyType2;
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, simpleName, sharedObjectClass, anyType, internalModuleDefinitionBuilder.getConverters());
            body.invoke(classComponentBuilder);
            internalModuleDefinitionBuilder.getClassData().add(classComponentBuilder.buildClass());
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: Class");
    }

    public final /* synthetic */ <SharedObjectType extends SharedObject> void Class(KClass<SharedObjectType> sharedObjectClass, Function1<? super ClassComponentBuilder<SharedObjectType>, Unit> body) {
        AnyType anyType;
        Intrinsics.checkNotNullParameter(sharedObjectClass, "sharedObjectClass");
        Intrinsics.checkNotNullParameter(body, "body");
        Module module = getModule();
        if (module == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        AppContext appContext = module.getAppContext();
        String simpleName = JvmClassMappingKt.getJavaClass((KClass) sharedObjectClass).getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
        AnyType anyType2 = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            C6309x9e61a20b c6309x9e61a20b = C6309x9e61a20b.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "SharedObjectType");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "SharedObjectType");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, c6309x9e61a20b), null);
        } else {
            anyType = anyType2;
        }
        ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, simpleName, sharedObjectClass, anyType, getConverters());
        body.invoke(classComponentBuilder);
        getClassData().add(classComponentBuilder.buildClass());
    }
}
