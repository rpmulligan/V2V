package viewmodel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.CollectedSample;
import model.TestResult;
import model.User;

public class TestResultViewModel {

	private TestResult testResult;

	public TestResultViewModel(TestResult testResult) {

		this.testResult = testResult;
	}
	
	public String getDateTested() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(testResult.getTestedOn());
	}

  public void copy(TestResult otherTestResult) {
    testResult.copy(otherTestResult);
  }

  public boolean equals(Object obj) {
    return testResult.equals(obj);
  }

  public Long getId() {
    return testResult.getId();
  }

  public CollectedSample getCollectedSample() {
    return testResult.getCollectedSample();
  }

  public Date getTestedOn() {
    return testResult.getTestedOn();
  }

  public String getName() {
    return testResult.getName();
  }

  public String getResult() {
    return testResult.getResult();
  }

  public Date getLastUpdated() {
    return testResult.getLastUpdated();
  }

  public Date getCreatedDate() {
    return testResult.getCreatedDate();
  }

  public User getCreatedBy() {
    return testResult.getCreatedBy();
  }

  public User getLastUpdatedBy() {
    return testResult.getLastUpdatedBy();
  }

  public String getNotes() {
    return testResult.getNotes();
  }

  public Boolean getIsDeleted() {
    return testResult.getIsDeleted();
  }
}
