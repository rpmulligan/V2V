package model.donor;

import java.util.Arrays;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

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
    System.out.println("here");
    System.out.println(obj);
    System.out.println(errors);
    validator.validate(obj, errors);
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "donorNumber", "editDonorForm.donorNumber.empty");
  }
}
