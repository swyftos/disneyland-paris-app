package org.junit.runner;

import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.manipulation.Filter;

/* loaded from: classes6.dex */
abstract class FilterFactories {
    public static Filter createFilterFromFilterSpec(Request request, String str) {
        String[] strArrSplit;
        Description description = request.getRunner().getDescription();
        if (str.contains("=")) {
            strArrSplit = str.split("=", 2);
        } else {
            strArrSplit = new String[]{str, ""};
        }
        return createFilter(strArrSplit[0], new FilterFactoryParams(description, strArrSplit[1]));
    }

    public static Filter createFilter(String str, FilterFactoryParams filterFactoryParams) {
        return createFilterFactory(str).createFilter(filterFactoryParams);
    }

    static FilterFactory createFilterFactory(String str) throws FilterFactory.FilterNotCreatedException {
        try {
            return createFilterFactory(Classes.getClass(str).asSubclass(FilterFactory.class));
        } catch (Exception e) {
            throw new FilterFactory.FilterNotCreatedException(e);
        }
    }

    static FilterFactory createFilterFactory(Class cls) throws FilterFactory.FilterNotCreatedException {
        try {
            return (FilterFactory) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new FilterFactory.FilterNotCreatedException(e);
        }
    }
}
