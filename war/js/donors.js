function addNewDonor(form, resultDivId) {
  updateDonorGeneric(form, resultDivId, "updateDonor.html");
}

function updateExistingDonor(form, resultDivId) {
  updateDonorGeneric(form, resultDivId, "updateDonor.html");
}

function updateDonorGeneric(form, resultDivId, url) {
  var donor = $("#" + form.getAttribute("id")).serialize();
  $.ajax({
    type : "POST",
    url : url,
    data : donor,
    success : function(jsonResponse) {
      $("#" + resultDivId).html(jsonResponse);
    }
  });
}

function deleteDonor(donorId) {
  $.ajax({
    type : "POST",
    url : "deleteDonor.html",
    data : {donorId: donorId},
    success : function(jsonResponse) {
      if (jsonResponse["success"] === true) {
        $.showMessage("Donor Deleted Successfully!");
      } else {
        $.showMessage("Something went wrong." + jsonResponse["errMsg"], {
          backgroundColor : 'red'
        });
      }
    }
  });
}
