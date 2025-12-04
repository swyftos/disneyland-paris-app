package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class AnnotationValidatorFactory {
    private static final ConcurrentHashMap VALIDATORS_FOR_ANNOTATION_TYPES = new ConcurrentHashMap();

    public AnnotationValidator createAnnotationValidator(ValidateWith validateWith) {
        ConcurrentHashMap concurrentHashMap = VALIDATORS_FOR_ANNOTATION_TYPES;
        AnnotationValidator annotationValidator = (AnnotationValidator) concurrentHashMap.get(validateWith);
        if (annotationValidator != null) {
            return annotationValidator;
        }
        Class<? extends AnnotationValidator> clsValue = validateWith.value();
        try {
            concurrentHashMap.putIfAbsent(validateWith, clsValue.newInstance());
            return (AnnotationValidator) concurrentHashMap.get(validateWith);
        } catch (Exception e) {
            throw new RuntimeException("Exception received when creating AnnotationValidator class " + clsValue.getName(), e);
        }
    }
}
