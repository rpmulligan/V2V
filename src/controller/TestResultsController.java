package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityExistsException;

import model.CollectedSample;
import model.TestResult;
import model.TestResultBackingForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import repository.CollectionRepository;
import repository.DisplayNamesRepository;
import repository.ProductRepository;
import repository.RecordFieldsConfigRepository;
import repository.TestResultRepository;
import utils.ControllerUtil;
import viewmodel.TestResultViewModel;

@Controller
public class TestResultsController {
  @Autowired
  private CollectionRepository collectionRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private TestResultRepository testResultRepository;

  @Autowired
  private DisplayNamesRepository displayNamesRepository;

  @Autowired
  private RecordFieldsConfigRepository recordFieldsConfigRepository;

  @RequestMapping(value = "/findTestResultFormGenerator", method = RequestMethod.GET)
  public ModelAndView findTestResultFormInit(Model model) {

    TestResultBackingForm form = new TestResultBackingForm();
    model.addAttribute("findTestResultForm", form);

    ModelAndView mv = new ModelAndView("findTestResultForm");
    Map<String, Object> m = model.asMap();
    // to ensure custom field names are displayed in the form
    ControllerUtil.addTestResultDisplayNamesToModel(m, displayNamesRepository);
    mv.addObject("model", m);
    return mv;
  }

  @RequestMapping("/findTestResult")
  public ModelAndView findTestResult(
      @ModelAttribute("findTestResultForm") TestResultBackingForm form,
      BindingResult result, Model model) {

    List<TestResult> testResults = testResultRepository
        .findAnyTestResultMatching(form.getCollectionNumber(), form.getTests(),
            form.getDateTestedFrom(), form.getDateTestedTo());

    ModelAndView modelAndView = new ModelAndView("testResultsTable");
    Map<String, Object> m = model.asMap();
    m.put("tableName", "findTestResultsTable");
    ControllerUtil.addTestResultDisplayNamesToModel(m, displayNamesRepository);
    ControllerUtil.addFieldsToDisplay("testResult", m,
        recordFieldsConfigRepository);
    m.put("allTestResults", getTestResultViewModels(testResults));

    modelAndView.addObject("model", m);
    return modelAndView;
  }

  @RequestMapping(value = "/editTestResultFormGenerator", method = RequestMethod.GET)
  public ModelAndView editTestResultFormGenerator(
      Model model,
      @RequestParam(value = "collectionNumber", required = false) String collectionNumber,
      @RequestParam(value = "isDialog", required = false) String isDialog) {

    TestResultBackingForm form = new TestResultBackingForm();
    Map<String, Object> m = model.asMap();
    m.put("isDialog", isDialog);

    if (collectionNumber != null) {
      CollectedSample collectedSample;
      collectedSample = collectionRepository.findCollectionByNumber(collectionNumber);
      form.setCollectedSample(collectedSample);
      TestResult testResult = testResultRepository
          .findTestResult(collectionNumber, form.getName());
      if (testResult != null) {
        form = new TestResultBackingForm(testResult);
      } else
        form = new TestResultBackingForm();
      System.out.println("here1");
    }
    m.put("editTestResultForm", form);
    // to ensure custom field names are displayed in the form
    ControllerUtil.addTestResultDisplayNamesToModel(m, displayNamesRepository);
    ModelAndView mv = new ModelAndView("editTestResultForm");
    mv.addObject("model", m);
    return mv;
  }

  @RequestMapping(value = "/updateTestResult", method = RequestMethod.POST)
  public @ResponseBody
  Map<String, ? extends Object> updateOrAddTestResult(
      @ModelAttribute("editTestResultForm") TestResultBackingForm form) {

    boolean success = true;
    String errMsg = "";
    try {
      TestResult testResult = form.getTestResult();
      testResultRepository.updateOrAddTestResult(testResult);
    } catch (EntityExistsException ex) {
      // TODO: Replace with logger
      System.err.println("Entity Already exists");
      System.err.println(ex.getMessage());
      success = false;
      errMsg = "Test Result Already Exists";
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

  private List<TestResultViewModel> getTestResultViewModels(
      List<TestResult> testResults) {
    if (testResults == null)
      return Arrays.asList(new TestResultViewModel[0]);
    List<TestResultViewModel> testResultViewModels = new ArrayList<TestResultViewModel>();
    for (TestResult testResult : testResults) {
      testResultViewModels.add(new TestResultViewModel(testResult));
    }
    return testResultViewModels;
  }
}
