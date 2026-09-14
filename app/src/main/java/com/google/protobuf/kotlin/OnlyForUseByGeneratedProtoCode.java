package com.google.protobuf.kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Metadata(m1835d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m1836d2 = {"Lcom/google/protobuf/kotlin/OnlyForUseByGeneratedProtoCode;", "", "java_kotlin-only_for_use_in_proto_generated_code_its_generator_and_tests"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "\n    This API is only intended for use by generated protobuf code, the code generator, and their own\n    tests.  If this does not describe your code, you should not be using this API.\n  ")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CONSTRUCTOR, AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface OnlyForUseByGeneratedProtoCode {
}
