package model.donor;

import java.util.Arrays;

import org.apache.commons.beanutils.locale.LocaleBeanUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class DonorBackingFormValidator implements Validator {

  public Validator validator;
  public DonorBackingFormValidator(Validator validator) {
    super();
    this.validator = validator;
  }
  
  @Override
  public boolean supports(Class<?> clazz) {
    return Arrays.asList(DonorBackingForm.class, Donor.class).contains(clazz);
  }

  @Override
  public void validate(Object obj, Errors errors) {
    if (obj == null || validator == null)
      return;
    ValidationUtils.invokeValidator(validator, obj, errors);
  }
}
