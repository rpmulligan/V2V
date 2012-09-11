function addNewDonor(form) {
  updateDonorGeneric(form, "updateDonor.html");
}

function updateExistingDonor(form) {
  updateDonorGeneric(form, "updateDonor.html");
}

function updateDonorGeneric(form, url) {
  var donor = $("#" + form.getAttribute("id")).serialize();
  $.ajax({
    type : "POST",
    url : url,
    data : donor,
    success : function(responseStr) {
      var jsonResponse = jQuery.parseJSON(responseStr);
      console.log(jsonResponse);
      if (jsonResponse["success"] === "true") {
        $.showMessage("Donor Updated Successfully!");
      } else {
        $.showMessage("Something went wrong." + jsonResponse["errMsg"], {
          backgroundColor : 'red'
        });
      }
    }
  });
}