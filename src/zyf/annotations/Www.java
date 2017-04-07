package zyf.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.google.inject.BindingAnnotation;

@Retention(RUNTIME)
@Target({FIELD,PARAMETER})
@BindingAnnotation
public @interface Www {
}
