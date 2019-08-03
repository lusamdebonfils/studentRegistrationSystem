package edu.mum.cs.cs425.studentregistrationapp.model.validators;


//import javax.validation.Constraint;
//import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS.RUNTIME)
//@Constraint(validatedBy = UniqueISBNValidator.class)
public @interface UniqueISBNValidator {

}
