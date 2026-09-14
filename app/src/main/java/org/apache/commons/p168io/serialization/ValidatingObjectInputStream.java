package org.apache.commons.p168io.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class ValidatingObjectInputStream extends ObjectInputStream {
    private final List acceptMatchers;
    private final List rejectMatchers;

    public ValidatingObjectInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        this.acceptMatchers = new ArrayList();
        this.rejectMatchers = new ArrayList();
    }

    private void validateClassName(String str) throws InvalidClassException {
        Iterator it = this.rejectMatchers.iterator();
        while (it.hasNext()) {
            if (((ClassNameMatcher) it.next()).matches(str)) {
                invalidClassNameFound(str);
            }
        }
        Iterator it2 = this.acceptMatchers.iterator();
        while (it2.hasNext()) {
            if (((ClassNameMatcher) it2.next()).matches(str)) {
                return;
            }
        }
        invalidClassNameFound(str);
    }

    protected void invalidClassNameFound(String str) throws InvalidClassException {
        throw new InvalidClassException("Class name not accepted: " + str);
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        validateClassName(objectStreamClass.getName());
        return super.resolveClass(objectStreamClass);
    }

    public ValidatingObjectInputStream accept(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.acceptMatchers.add(new FullClassNameMatcher(cls.getName()));
        }
        return this;
    }

    public ValidatingObjectInputStream reject(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.rejectMatchers.add(new FullClassNameMatcher(cls.getName()));
        }
        return this;
    }

    public ValidatingObjectInputStream accept(String... strArr) {
        for (String str : strArr) {
            this.acceptMatchers.add(new WildcardClassNameMatcher(str));
        }
        return this;
    }

    public ValidatingObjectInputStream reject(String... strArr) {
        for (String str : strArr) {
            this.rejectMatchers.add(new WildcardClassNameMatcher(str));
        }
        return this;
    }

    public ValidatingObjectInputStream accept(Pattern pattern) {
        this.acceptMatchers.add(new RegexpClassNameMatcher(pattern));
        return this;
    }

    public ValidatingObjectInputStream reject(Pattern pattern) {
        this.rejectMatchers.add(new RegexpClassNameMatcher(pattern));
        return this;
    }

    public ValidatingObjectInputStream accept(ClassNameMatcher classNameMatcher) {
        this.acceptMatchers.add(classNameMatcher);
        return this;
    }

    public ValidatingObjectInputStream reject(ClassNameMatcher classNameMatcher) {
        this.rejectMatchers.add(classNameMatcher);
        return this;
    }
}
