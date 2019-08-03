package edu.mum.cs.cs425.studentregistrationapp.model.validators;

import java.lang.annotation.Annotation;

public class UniqueISBN implements UniqueISBNValidator {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
