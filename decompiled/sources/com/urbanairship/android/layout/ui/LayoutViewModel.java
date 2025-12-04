package com.urbanairship.android.layout.ui;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.contentsquare.android.api.Currencies;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.ModelFactory;
import com.urbanairship.android.layout.ModelFactoryException;
import com.urbanairship.android.layout.ThomasModelFactory;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.Reporter;
import com.urbanairship.android.layout.environment.ThomasActionRunner;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.reporting.DisplayTimer;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007J2\u0010\u0015\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006j\u0002`\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/layout/ui/LayoutViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "rootViewId", "", "getRootViewId", "()I", "getOrCreateEnvironment", "reporter", "Lcom/urbanairship/android/layout/environment/Reporter;", "displayTimer", "Lcom/urbanairship/android/layout/reporting/DisplayTimer;", "actionRunner", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "layoutState", "Lcom/urbanairship/android/layout/environment/LayoutState;", "getOrCreateModel", "viewInfo", "Lcom/urbanairship/android/layout/info/ViewInfo;", "modelEnvironment", "factory", "Lcom/urbanairship/android/layout/ModelFactory;", "onCleared", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LayoutViewModel extends ViewModel {
    private ModelEnvironment environment;
    private BaseModel model;
    private final int rootViewId = View.generateViewId();

    @JvmOverloads
    @NotNull
    public final ModelEnvironment getOrCreateEnvironment(@NotNull Reporter reporter, @NotNull DisplayTimer displayTimer, @NotNull ThomasActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(displayTimer, "displayTimer");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        return getOrCreateEnvironment$default(this, reporter, displayTimer, actionRunner, null, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final BaseModel<?, ?, ?> getOrCreateModel(@NotNull ViewInfo viewInfo, @NotNull ModelEnvironment modelEnvironment) throws ModelFactoryException {
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(modelEnvironment, "modelEnvironment");
        return getOrCreateModel$default(this, viewInfo, modelEnvironment, null, 4, null);
    }

    public final int getRootViewId() {
        return this.rootViewId;
    }

    public static /* synthetic */ ModelEnvironment getOrCreateEnvironment$default(LayoutViewModel layoutViewModel, Reporter reporter, DisplayTimer displayTimer, ThomasActionRunner thomasActionRunner, LayoutState layoutState, int i, Object obj) {
        if ((i & 8) != 0) {
            layoutState = LayoutState.EMPTY;
        }
        return layoutViewModel.getOrCreateEnvironment(reporter, displayTimer, thomasActionRunner, layoutState);
    }

    @JvmOverloads
    @NotNull
    public final ModelEnvironment getOrCreateEnvironment(@NotNull Reporter reporter, @NotNull DisplayTimer displayTimer, @NotNull ThomasActionRunner actionRunner, @NotNull LayoutState layoutState) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(displayTimer, "displayTimer");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        Intrinsics.checkNotNullParameter(layoutState, "layoutState");
        ModelEnvironment modelEnvironment = this.environment;
        if (modelEnvironment != null) {
            return modelEnvironment;
        }
        ModelEnvironment modelEnvironment2 = new ModelEnvironment(layoutState, reporter, actionRunner, displayTimer, null, null, null, null, null, Currencies.MNT, null);
        this.environment = modelEnvironment2;
        return modelEnvironment2;
    }

    public static /* synthetic */ BaseModel getOrCreateModel$default(LayoutViewModel layoutViewModel, ViewInfo viewInfo, ModelEnvironment modelEnvironment, ModelFactory modelFactory, int i, Object obj) throws ModelFactoryException {
        if ((i & 4) != 0) {
            modelFactory = new ThomasModelFactory();
        }
        return layoutViewModel.getOrCreateModel(viewInfo, modelEnvironment, modelFactory);
    }

    @JvmOverloads
    @NotNull
    public final BaseModel<?, ?, ?> getOrCreateModel(@NotNull ViewInfo viewInfo, @NotNull ModelEnvironment modelEnvironment, @NotNull ModelFactory factory) throws ModelFactoryException {
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(modelEnvironment, "modelEnvironment");
        Intrinsics.checkNotNullParameter(factory, "factory");
        BaseModel<?, ?, ?> baseModel = this.model;
        if (baseModel != null) {
            return baseModel;
        }
        BaseModel<?, ?, ?> baseModelCreate = factory.create(viewInfo, modelEnvironment);
        this.model = baseModelCreate;
        return baseModelCreate;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        CoroutineScope modelScope;
        UALog.v("Lifecycle: CLEARED", new Object[0]);
        ModelEnvironment modelEnvironment = this.environment;
        if (modelEnvironment == null || (modelScope = modelEnvironment.getModelScope()) == null) {
            return;
        }
        CoroutineScopeKt.cancel$default(modelScope, null, 1, null);
    }
}
