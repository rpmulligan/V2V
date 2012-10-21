package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import model.donor.Donor;
import model.donor.DonorBackingForm;
import model.donor.DonorBackingFormValidator;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import repository.DisplayNamesRepository;
import repository.DonorRepository;
import repository.LocationRepository;
import repository.RecordFieldsConfigRepository;
import repository.UserRepository;
import utils.ControllerUtil;
import viewmodel.donor.DonorViewModel;

@Controller
public class DonorController {

  @Autowired
  private DonorRepository donorRepository;

  @Autowired
  private LocationRepository locationRepository;

  @Autowired
  private DisplayNamesRepository displayNamesRepository;

  @Autowired
  private RecordFieldsConfigRepository recordFieldsConfigRepository;

  @Autowired
  private UserRepository userRepository;

  public DonorController() {
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    binder.setValidator(new DonorBackingFormValidator(binder.getValidator()));
  }

  @RequestMapping("/donorsLandingPage")
  public ModelAndView getDonorsLandingPage(HttpServletRequest request) {

    ModelAndView modelAndView = new ModelAndView("donorsLandingPage");
    Map<String, Object> model = new HashMap<String, Object>();
    modelAndView.addObject("model", model);
    return modelAndView;
  }

  @RequestMapping("/donors")
  public ModelAndView getDonorsPage(HttpServletRequest request) {

    ModelAndView modelAndView = new ModelAndView("donors");
    Map<String, Object> model = new HashMap<String, Object>();
    ControllerUtil.addDonorDisplayNamesToModel(model, displayNamesRepository);
    ControllerUtil.addFieldsToDisplay("donor", model,
        recordFieldsConfigRepository);
    ControllerUtil.addFieldsToDisplay("collection", model,
        recordFieldsConfigRepository);
    modelAndView.addObject("model", model);
    return modelAndView;
  }

  @RequestMapping(value = "/addDonorFormTab", method = RequestMethod.GET)
  public ModelAndView addDonorFormTabInit() {
    ModelAndView mv = new ModelAndView("addDonor");
    return mv;
  }

  @RequestMapping(value = "/editDonorFormGenerator", method = RequestMethod.GET)
  public ModelAndView editDonorFormGenerator(
      Model model,
      @RequestParam(value = "donorNumber", required = false) String donorNumber,
      @RequestParam(value = "isDialog", required = false) String isDialog) {

    DonorBackingForm form = new DonorBackingForm();
    Map<String, Object> m = model.asMap();
    ModelAndView mv = new ModelAndView("editDonorForm");
    if (donorNumber != null) {
      form.setDonorNumber(donorNumber);
      Donor donor = donorRepository.findDonorByNumber(donorNumber);
      if (donor != null)
       form = new DonorBackingForm(donor);
      else
       form = new DonorBackingForm();
    }
    m.put("editDonorForm", form);
    m.put("isDialog", isDialog);
    // to ensure custom field names are displayed in the form
    ControllerUtil.addDonorDisplayNamesToModel(m, displayNamesRepository);
    mv.addObject("model", m);
    return mv;
  }

  @RequestMapping(value = "/updateDonor", method = RequestMethod.POST)
  public ModelAndView updateOrAddDonor(
      @ModelAttribute("editDonorForm") @Valid DonorBackingForm form,
      BindingResult result, Model model) {

    ModelAndView mv = new ModelAndView("editDonorForm");
    Map<String, Object> m = new HashMap<String, Object>();
    if (form == null) {
      form = new DonorBackingForm();
      m.put("editDonorForm", form);
    } else {
      if (result.hasErrors()) {
        for (FieldError objectError : result.getFieldErrors()) {
          System.out.println("error");
          System.out.println(objectError.getObjectName());
          System.out.println(objectError.getField());
          System.out.println(objectError.getCode());
          System.out.println(objectError.getDefaultMessage());
        }
        if (form == result.getTarget())
          System.out.println("same");
        m.put("editDonorForm", result.getTarget());
      } else {
        DonorBackingForm finalForm = null;
        try {
          Donor donor = form.getDonor();
          donorRepository.updateOrAddDonor(donor);
          finalForm = new DonorBackingForm();
        } catch (EntityExistsException ex) {
          ex.printStackTrace();
          finalForm = (DonorBackingForm) result.getTarget();
        } catch (Exception ex) {
          ex.printStackTrace();
          finalForm = (DonorBackingForm) result.getTarget();
        } finally {
          m.put("editDonorForm", finalForm);
        }
      }
    }
    // to ensure custom field names are displayed in the form
    ControllerUtil.addDonorDisplayNamesToModel(m, displayNamesRepository);
    mv.addObject("model", m);
    return mv;
  }

  @RequestMapping(value = "/deleteDonor", method = RequestMethod.POST)
  public @ResponseBody
  Map<String, ? extends Object> deleteDonor(
      @RequestParam("donorId") String donorId) {

    boolean success = true;
    String errMsg = "";
    try {
      donorRepository.deleteDonor(donorId);
    } catch (Exception ex) {
      // TODO: Replace with logger
      System.err.println("Internal Exception");
      System.err.println(ex.getMessage());
      success = false;
      errMsg = "Internal Server Error";
    }

    Map<String, Object> m = new HashMap<String, Object>();
    m.put("success", success);
    m.put("errMsg", errMsg);
    return m;
  }

  @RequestMapping(value = "/addDonor", method = RequestMethod.POST)
  public ModelAndView addDonor(
      @ModelAttribute("editDonorForm") DonorBackingForm form,
      BindingResult result, Model m) {
    ModelAndView modelAndView = new ModelAndView("addDonor");
    return modelAndView;
  }

  @RequestMapping(value = "/findDonorFormGenerator", method = RequestMethod.GET)
  public ModelAndView findDonorFormInit(Model model) {

    DonorBackingForm form = new DonorBackingForm();
    model.addAttribute("findDonorForm", form);

    ModelAndView mv = new ModelAndView("findDonorForm");
    Map<String, Object> m = model.asMap();
    // to ensure custom field names are displayed in the form
    ControllerUtil.addDonorDisplayNamesToModel(m, displayNamesRepository);
    mv.addObject("model", m);
    return mv;
  }

  @RequestMapping(value = "/findDonor", method = RequestMethod.GET)
  public ModelAndView findDonor(
      @ModelAttribute("findDonorForm") DonorBackingForm form,
      BindingResult result, Model m) {

    String donorNumber = form.getDonorNumber();
    String firstName = form.getFirstName();
    String lastName = form.getLastName();
    List<String> bloodTypes = form.getBloodTypes();

    ModelAndView modelAndView = new ModelAndView("donorsTable");
    List<Donor> donors = donorRepository.findAnyDonor(donorNumber, firstName,
        lastName, bloodTypes);

    Map<String, Object> model = m.asMap();
    model.put("tableName", "findDonorResultsTable");
    ControllerUtil.addDonorDisplayNamesToModel(model, displayNamesRepository);
    ControllerUtil.addFieldsToDisplay("donor", model,
        recordFieldsConfigRepository);
    model.put("allDonors", getDonorsViewModels(donors));
    modelAndView.addObject("model", model);
    return modelAndView;
  }

  @RequestMapping("/viewDonors")
  public ModelAndView viewAllDonors(@RequestParam Map<String, String> params,
      HttpServletRequest request) {

    List<Donor> allDonors = donorRepository.getAllDonors();
    ModelAndView modelAndView = new ModelAndView("donorsTable");
    Map<String, Object> model = new HashMap<String, Object>();

    model.put("tableName", "viewAllDonors");
    model.put("allDonors", getDonorsViewModels(allDonors));
    ControllerUtil.addDonorDisplayNamesToModel(model, displayNamesRepository);
    ControllerUtil.addFieldsToDisplay("donor", model,
        recordFieldsConfigRepository);
    ControllerUtil.addFieldsToDisplay("collection", model,
        recordFieldsConfigRepository);
    modelAndView.addObject("model", model);
    return modelAndView;
  }

  private List<DonorViewModel> getDonorsViewModels(List<Donor> donors) {
    List<DonorViewModel> donorViewModels = new ArrayList<DonorViewModel>();
    for (Donor donor : donors) {
      donorViewModels.add(new DonorViewModel(donor));
    }
    return donorViewModels;
  }

  private Date getDonorDOB(Map<String, String> params) {

    String dobmonth = params.get("dobmonth");
    String dobday = params.get("dobday");
    String dobyear = params.get("dobyear");

    DateTime dob = new DateTime();
    try {
      dob = dob.withMonthOfYear(Integer.parseInt(dobmonth));
      dob = dob.withDayOfMonth(Integer.parseInt(dobday));
      dob = dob.withYear(Integer.parseInt(dobyear));
      return dob.toDate();
    } catch (NumberFormatException nfe) {
      return null;
    }
  }

  private Long getParam(Map<String, String> params, String paramName) {
    String paramValue = params.get(paramName);
    return paramValue == null || paramValue.isEmpty() ? null : Long
        .parseLong(paramValue);
  }
}
