package org.picocontainer.classname;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentFactory;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.ComponentMonitorStrategy;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoClassNotFoundException;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoException;
import org.picocontainer.PicoVisitor;
import org.picocontainer.behaviors.Caching;
import org.picocontainer.containers.AbstractDelegatingMutablePicoContainer;
import org.picocontainer.lifecycle.LifecycleState;
import org.picocontainer.security.CustomPermissionsURLClassLoader;

/* loaded from: classes6.dex */
public class DefaultClassLoadingPicoContainer extends AbstractDelegatingMutablePicoContainer implements ClassLoadingPicoContainer, ComponentMonitorStrategy {
    private static final transient Map primitiveNameToBoxedName;
    private final transient List classPathElements;
    private transient ClassLoader componentClassLoader;
    private transient boolean componentClassLoaderLocked;
    protected final Map<String, PicoContainer> namedChildContainers;
    private final transient ClassLoader parentClassLoader;

    public interface ClassVisitor {
        void classFound(Class cls);
    }

    static {
        HashMap map = new HashMap();
        primitiveNameToBoxedName = map;
        map.put("int", Integer.class.getName());
        map.put("byte", Byte.class.getName());
        map.put("short", Short.class.getName());
        map.put(LongTypedProperty.TYPE, Long.class.getName());
        map.put(TypedValues.Custom.S_FLOAT, Float.class.getName());
        map.put(DoubleTypedProperty.TYPE, Double.class.getName());
        map.put("boolean", Boolean.class.getName());
    }

    public DefaultClassLoadingPicoContainer(ClassLoader classLoader, ComponentFactory componentFactory, PicoContainer picoContainer) {
        super(new DefaultPicoContainer(componentFactory, picoContainer));
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = classLoader;
    }

    public DefaultClassLoadingPicoContainer(ClassLoader classLoader, MutablePicoContainer mutablePicoContainer) {
        super(mutablePicoContainer);
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = classLoader;
    }

    public DefaultClassLoadingPicoContainer(ClassLoader classLoader, PicoContainer picoContainer, ComponentMonitor componentMonitor) {
        super(new DefaultPicoContainer(new Caching(), picoContainer));
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = classLoader;
        ((ComponentMonitorStrategy) getDelegate()).changeMonitor(componentMonitor);
    }

    public DefaultClassLoadingPicoContainer(ComponentFactory componentFactory) {
        super(new DefaultPicoContainer(componentFactory, (PicoContainer) null));
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = DefaultClassLoadingPicoContainer.class.getClassLoader();
    }

    public DefaultClassLoadingPicoContainer(PicoContainer picoContainer) {
        super(new DefaultPicoContainer(picoContainer));
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = DefaultClassLoadingPicoContainer.class.getClassLoader();
    }

    public DefaultClassLoadingPicoContainer(MutablePicoContainer mutablePicoContainer) {
        super(mutablePicoContainer);
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = DefaultClassLoadingPicoContainer.class.getClassLoader();
    }

    public DefaultClassLoadingPicoContainer(ClassLoader classLoader) {
        super(new DefaultPicoContainer());
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = classLoader;
    }

    public DefaultClassLoadingPicoContainer() {
        super(new DefaultPicoContainer());
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = DefaultClassLoadingPicoContainer.class.getClassLoader();
    }

    public DefaultClassLoadingPicoContainer(ComponentFactory componentFactory, LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer, ClassLoader classLoader, ComponentMonitor componentMonitor) {
        super(new DefaultPicoContainer(componentFactory, lifecycleStrategy, picoContainer, componentMonitor));
        this.classPathElements = new ArrayList();
        this.namedChildContainers = new HashMap();
        this.parentClassLoader = classLoader == null ? DefaultClassLoadingPicoContainer.class.getClassLoader() : classLoader;
    }

    protected DefaultClassLoadingPicoContainer createChildContainer() {
        DefaultClassLoadingPicoContainer defaultClassLoadingPicoContainer = new DefaultClassLoadingPicoContainer(getComponentClassLoader(), getDelegate().makeChildContainer());
        defaultClassLoadingPicoContainer.changeMonitor(currentMonitor());
        return defaultClassLoadingPicoContainer;
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public void changeMonitor(ComponentMonitor componentMonitor) {
        for (MutablePicoContainer delegate = getDelegate(); delegate != null; delegate = ((AbstractDelegatingMutablePicoContainer) delegate).getDelegate()) {
            if (delegate instanceof ComponentMonitorStrategy) {
                ((ComponentMonitorStrategy) delegate).changeMonitor(componentMonitor);
                return;
            } else {
                if (!(delegate instanceof AbstractDelegatingMutablePicoContainer)) {
                    break;
                }
            }
        }
        throw new IllegalStateException("Could not find delegate picocontainer that implemented ComponentMonitorStrategy");
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public ComponentMonitor currentMonitor() {
        for (MutablePicoContainer delegate = getDelegate(); delegate != null; delegate = ((AbstractDelegatingMutablePicoContainer) delegate).getDelegate()) {
            if (delegate instanceof ComponentMonitorStrategy) {
                return ((ComponentMonitorStrategy) delegate).currentMonitor();
            }
            if (!(delegate instanceof AbstractDelegatingMutablePicoContainer)) {
                break;
            }
        }
        throw new IllegalStateException("Could not find delegate picocontainer that implemented ComponentMonitorStrategy");
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
    public final Object getComponent(Object obj) throws PicoException {
        ComponentAdapter<?> next;
        if (obj instanceof ClassName) {
            obj = loadClass((ClassName) obj);
        }
        Object component = getDelegate().getComponent(obj);
        if (component != null) {
            return component;
        }
        if (obj.toString().startsWith("*")) {
            String strSubstring = obj.toString().substring(1);
            Iterator<ComponentAdapter<?>> it = getComponentAdapters().iterator();
            while (it.hasNext()) {
                next = it.next();
                Object componentKey = next.getComponentKey();
                if ((componentKey instanceof Class) && strSubstring.equals(((Class) componentKey).getName())) {
                    break;
                }
            }
            next = null;
        } else {
            next = null;
        }
        if (next != null) {
            return next.getComponentInstance(this, ComponentAdapter.NOTHING.class);
        }
        return getComponentInstanceFromChildren(obj);
    }

    private Object getComponentInstanceFromChildren(Object obj) {
        String string = obj.toString();
        int iIndexOf = string.indexOf(47);
        if (iIndexOf == -1) {
            return null;
        }
        String strSubstring = string.substring(0, iIndexOf);
        String strSubstring2 = string.substring(iIndexOf + 1, string.length());
        PicoContainer picoContainer = getNamedContainers().get(strSubstring);
        if (picoContainer != null) {
            return ((MutablePicoContainer) picoContainer).getComponent(strSubstring2);
        }
        return null;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public final MutablePicoContainer makeChildContainer() {
        return makeChildContainer("containers" + this.namedChildContainers.size());
    }

    @Override // org.picocontainer.classname.ClassLoadingPicoContainer
    public ClassLoadingPicoContainer makeChildContainer(String str) {
        DefaultClassLoadingPicoContainer defaultClassLoadingPicoContainerCreateChildContainer = createChildContainer();
        MutablePicoContainer delegate = getDelegate();
        delegate.removeChildContainer(defaultClassLoadingPicoContainerCreateChildContainer.getDelegate());
        delegate.addChildContainer(defaultClassLoadingPicoContainerCreateChildContainer);
        this.namedChildContainers.put(str, defaultClassLoadingPicoContainerCreateChildContainer);
        return defaultClassLoadingPicoContainerCreateChildContainer;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public boolean removeChildContainer(PicoContainer picoContainer) {
        boolean zRemoveChildContainer = getDelegate().removeChildContainer(picoContainer);
        Iterator<Map.Entry<String, PicoContainer>> it = this.namedChildContainers.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == picoContainer) {
                it.remove();
            }
        }
        return zRemoveChildContainer;
    }

    protected final Map<String, PicoContainer> getNamedContainers() {
        return this.namedChildContainers;
    }

    @Override // org.picocontainer.classname.ClassLoadingPicoContainer
    public ClassPathElement addClassLoaderURL(URL url) {
        if (this.componentClassLoaderLocked) {
            throw new IllegalStateException("ClassLoader URLs cannot be added once this instance is locked");
        }
        ClassPathElement classPathElement = new ClassPathElement(url);
        this.classPathElements.add(classPathElement);
        return classPathElement;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addComponent(Object obj) throws PicoCompositionException {
        if (obj instanceof ClassName) {
            super.addComponent(loadClass((ClassName) obj));
        } else {
            super.addComponent(obj);
        }
        return this;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addComponent(Object obj, Object obj2, Parameter... parameterArr) throws PicoCompositionException {
        super.addComponent(classNameToClassIfApplicable(obj), classNameToClassIfApplicable(obj2), parameterArr);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object classNameToClassIfApplicable(Object obj) {
        return obj instanceof ClassName ? loadClass((ClassName) obj) : obj;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addAdapter(ComponentAdapter<?> componentAdapter) throws PicoCompositionException {
        super.addAdapter(componentAdapter);
        return this;
    }

    @Override // org.picocontainer.classname.ClassLoadingPicoContainer
    public ClassLoader getComponentClassLoader() {
        if (this.componentClassLoader == null) {
            this.componentClassLoaderLocked = true;
            this.componentClassLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.classname.DefaultClassLoadingPicoContainer.1
                @Override // java.security.PrivilegedAction
                public ClassLoader run() {
                    DefaultClassLoadingPicoContainer defaultClassLoadingPicoContainer = DefaultClassLoadingPicoContainer.this;
                    return new CustomPermissionsURLClassLoader(defaultClassLoadingPicoContainer.getURLs(defaultClassLoadingPicoContainer.classPathElements), DefaultClassLoadingPicoContainer.this.makePermissions(), DefaultClassLoadingPicoContainer.this.parentClassLoader);
                }
            });
        }
        return this.componentClassLoader;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addChildContainer(PicoContainer picoContainer) {
        getDelegate().addChildContainer(picoContainer);
        this.namedChildContainers.put("containers" + this.namedChildContainers.size(), picoContainer);
        return this;
    }

    @Override // org.picocontainer.classname.ClassLoadingPicoContainer
    public ClassLoadingPicoContainer addChildContainer(String str, PicoContainer picoContainer) {
        super.addChildContainer(picoContainer);
        this.namedChildContainers.put(str, picoContainer);
        return this;
    }

    private Class loadClass(ClassName className) {
        ClassLoader componentClassLoader = getComponentClassLoader();
        String className2 = getClassName(className.toString());
        try {
            return componentClassLoader.loadClass(className2);
        } catch (ClassNotFoundException e) {
            throw new PicoClassNotFoundException(className2, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map makePermissions() {
        HashMap map = new HashMap();
        for (ClassPathElement classPathElement : this.classPathElements) {
            map.put(classPathElement.getUrl(), classPathElement.getPermissionCollection());
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URL[] getURLs(List list) {
        int size = list.size();
        URL[] urlArr = new URL[size];
        for (int i = 0; i < size; i++) {
            urlArr[i] = ((ClassPathElement) list.get(i)).getUrl();
        }
        return urlArr;
    }

    private static String getClassName(String str) {
        String str2 = (String) primitiveNameToBoxedName.get(str);
        return str2 != null ? str2 : str;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
    public ComponentAdapter<?> getComponentAdapter(Object obj) {
        if (obj instanceof ClassName) {
            obj = loadClass((ClassName) obj);
        }
        return super.getComponentAdapter(obj);
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public MutablePicoContainer change(Properties... propertiesArr) {
        super.change(propertiesArr);
        return this;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
    public MutablePicoContainer as(Properties... propertiesArr) {
        return new AsPropertiesPicoContainer(propertiesArr);
    }

    private class AsPropertiesPicoContainer implements ClassLoadingPicoContainer {
        private MutablePicoContainer delegate;

        @Override // org.picocontainer.Disposable
        public void dispose() {
        }

        @Override // org.picocontainer.Startable
        public void start() {
        }

        @Override // org.picocontainer.Startable
        public void stop() {
        }

        public AsPropertiesPicoContainer(Properties... propertiesArr) {
            this.delegate = DefaultClassLoadingPicoContainer.this.getDelegate().as(propertiesArr);
        }

        @Override // org.picocontainer.classname.ClassLoadingPicoContainer
        public ClassPathElement addClassLoaderURL(URL url) {
            return DefaultClassLoadingPicoContainer.this.addClassLoaderURL(url);
        }

        @Override // org.picocontainer.classname.ClassLoadingPicoContainer
        public ClassLoader getComponentClassLoader() {
            return DefaultClassLoadingPicoContainer.this.getComponentClassLoader();
        }

        @Override // org.picocontainer.classname.ClassLoadingPicoContainer
        public ClassLoadingPicoContainer makeChildContainer(String str) {
            return DefaultClassLoadingPicoContainer.this.makeChildContainer(str);
        }

        @Override // org.picocontainer.classname.ClassLoadingPicoContainer
        public ClassLoadingPicoContainer addChildContainer(String str, PicoContainer picoContainer) {
            return (ClassLoadingPicoContainer) DefaultClassLoadingPicoContainer.this.addChildContainer(picoContainer);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addComponent(Object obj, Object obj2, Parameter... parameterArr) {
            this.delegate.addComponent(DefaultClassLoadingPicoContainer.this.classNameToClassIfApplicable(obj), DefaultClassLoadingPicoContainer.this.classNameToClassIfApplicable(obj2), parameterArr);
            return DefaultClassLoadingPicoContainer.this;
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addComponent(Object obj) {
            this.delegate.addComponent(DefaultClassLoadingPicoContainer.this.classNameToClassIfApplicable(obj));
            return DefaultClassLoadingPicoContainer.this;
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addConfig(String str, Object obj) {
            this.delegate.addConfig(str, obj);
            return DefaultClassLoadingPicoContainer.this;
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addAdapter(ComponentAdapter componentAdapter) {
            this.delegate.addAdapter(componentAdapter);
            return DefaultClassLoadingPicoContainer.this;
        }

        @Override // org.picocontainer.MutablePicoContainer
        public ComponentAdapter removeComponent(Object obj) {
            return this.delegate.removeComponent(obj);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public ComponentAdapter removeComponentByInstance(Object obj) {
            return this.delegate.removeComponentByInstance(obj);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer makeChildContainer() {
            return DefaultClassLoadingPicoContainer.this.makeChildContainer();
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addChildContainer(PicoContainer picoContainer) {
            return DefaultClassLoadingPicoContainer.this.addChildContainer(picoContainer);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public boolean removeChildContainer(PicoContainer picoContainer) {
            return DefaultClassLoadingPicoContainer.this.removeChildContainer(picoContainer);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer change(Properties... propertiesArr) {
            return DefaultClassLoadingPicoContainer.this.change(propertiesArr);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public MutablePicoContainer as(Properties... propertiesArr) {
            return DefaultClassLoadingPicoContainer.this.new AsPropertiesPicoContainer(propertiesArr);
        }

        @Override // org.picocontainer.PicoContainer
        public Object getComponent(Object obj) {
            return DefaultClassLoadingPicoContainer.this.getComponent(obj);
        }

        @Override // org.picocontainer.PicoContainer
        public Object getComponent(Object obj, Type type) {
            return DefaultClassLoadingPicoContainer.this.getComponent(obj, type);
        }

        @Override // org.picocontainer.PicoContainer
        public Object getComponent(Class cls) {
            return DefaultClassLoadingPicoContainer.this.getComponent(cls);
        }

        @Override // org.picocontainer.PicoContainer
        public Object getComponent(Class cls, Class cls2) {
            return DefaultClassLoadingPicoContainer.this.getComponent(cls, (Class<? extends Annotation>) cls2);
        }

        @Override // org.picocontainer.PicoContainer
        public List getComponents() {
            return DefaultClassLoadingPicoContainer.this.getComponents();
        }

        @Override // org.picocontainer.PicoContainer
        public PicoContainer getParent() {
            return DefaultClassLoadingPicoContainer.this.getParent();
        }

        @Override // org.picocontainer.PicoContainer
        public ComponentAdapter getComponentAdapter(Object obj) {
            return DefaultClassLoadingPicoContainer.this.getComponentAdapter(obj);
        }

        @Override // org.picocontainer.PicoContainer
        public ComponentAdapter getComponentAdapter(Class cls, NameBinding nameBinding) {
            return DefaultClassLoadingPicoContainer.this.getComponentAdapter(cls, nameBinding);
        }

        @Override // org.picocontainer.PicoContainer
        public ComponentAdapter getComponentAdapter(Class cls, Class cls2) {
            return DefaultClassLoadingPicoContainer.this.getComponentAdapter(cls, (Class<? extends Annotation>) cls2);
        }

        @Override // org.picocontainer.PicoContainer
        public Collection getComponentAdapters() {
            return DefaultClassLoadingPicoContainer.this.getComponentAdapters();
        }

        @Override // org.picocontainer.PicoContainer
        public List getComponentAdapters(Class cls) {
            return DefaultClassLoadingPicoContainer.this.getComponentAdapters(cls);
        }

        @Override // org.picocontainer.PicoContainer
        public List getComponentAdapters(Class cls, Class cls2) {
            return DefaultClassLoadingPicoContainer.this.getComponentAdapters(cls, cls2);
        }

        @Override // org.picocontainer.PicoContainer
        public List getComponents(Class cls) {
            return DefaultClassLoadingPicoContainer.this.getComponents(cls);
        }

        @Override // org.picocontainer.PicoContainer
        public void accept(PicoVisitor picoVisitor) {
            DefaultClassLoadingPicoContainer.this.accept(picoVisitor);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public void setName(String str) {
            DefaultClassLoadingPicoContainer.this.setName(str);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public void setLifecycleState(LifecycleState lifecycleState) {
            DefaultClassLoadingPicoContainer.this.setLifecycleState(lifecycleState);
        }

        @Override // org.picocontainer.MutablePicoContainer
        public LifecycleState getLifecycleState() {
            return DefaultClassLoadingPicoContainer.this.getLifecycleState();
        }

        @Override // org.picocontainer.MutablePicoContainer
        public String getName() {
            return DefaultClassLoadingPicoContainer.this.getName();
        }
    }

    public int visit(ClassName className, String str, boolean z, ClassVisitor classVisitor) {
        Class clsLoadClass = loadClass(className);
        String strReplace = clsLoadClass.getPackage().getName().replace(InstructionFileId.DOT, "/");
        CodeSource codeSource = clsLoadClass.getProtectionDomain().getCodeSource();
        if (codeSource == null) {
            throw new PicoCompositionException("no codesource for " + ((Object) className));
        }
        String file = codeSource.getLocation().getFile();
        File file2 = new File(file + File.separator + strReplace);
        Pattern patternCompile = Pattern.compile(str);
        if (file2.exists()) {
            return visit(file2.isFile() ? file2.getParentFile() : file2, strReplace, patternCompile, z, classVisitor);
        }
        return visit(strReplace, file, patternCompile, z, classVisitor);
    }

    public int visit(String str, String str2, Pattern pattern, boolean z, ClassVisitor classVisitor) {
        int iVisit = 0;
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2)).entries();
            while (enumerationEntries.hasMoreElements()) {
                String name = enumerationEntries.nextElement().getName();
                if (name.startsWith(str) && name.endsWith(".class")) {
                    String strSubstring = name.substring(str.length() + 1);
                    if (strSubstring.endsWith("XStream.class")) {
                        System.out.println();
                    }
                    if (strSubstring.split("/").length == 1 || z) {
                        iVisit = visit(str, pattern, classVisitor, iVisit, name.replace("/", InstructionFileId.DOT), null);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iVisit;
    }

    public int visit(File file, String str, Pattern pattern, boolean z, ClassVisitor classVisitor) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0;
        }
        int iVisit = 0;
        for (File file2 : fileArrListFiles) {
            if (!file2.isDirectory()) {
                iVisit = visit(str, pattern, classVisitor, iVisit, file2.getName(), file2.getAbsolutePath().replace(File.separatorChar, '/'));
            } else if (z) {
                iVisit += visit(file2, str, pattern, z, classVisitor);
            }
        }
        return iVisit;
    }

    private int visit(String str, Pattern pattern, ClassVisitor classVisitor, int i, String str2, String str3) {
        String strSubstring;
        if (!pattern.matcher(str2).matches()) {
            return i;
        }
        if (str3 != null) {
            String strSubstring2 = str3.substring(str3.indexOf(str));
            strSubstring = strSubstring2.substring(0, strSubstring2.indexOf(".class")).replace('/', '.');
        } else {
            strSubstring = str2.substring(0, str2.indexOf(".class"));
        }
        classVisitor.classFound(loadClass(new ClassName(strSubstring)));
        return i + 1;
    }
}
