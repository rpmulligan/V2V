function addNewProduct(form) {
  updateProductGeneric(form, "updateProduct.html");
}

function updateExistingProduct(form) {
  updateProductGeneric(form, "updateProduct.html");
}

function updateProductGeneric(form, url) {
  var testResult = $("#" + form.getAttribute("id")).serialize();
  $.ajax({
    type : "POST",
    url : url,
    data : testResult,
    success : function(jsonResponse) {
      if (jsonResponse["success"] === true) {
        $.showMessage("Product Updated Successfully!");
      } else {
        $.showMessage("Something went wrong." + jsonResponse["errMsg"], {
          backgroundColor : 'red'
        });
      }
    }
  });
}

function deleteProduct(productNumber) {
  $.ajax({
    type : "POST",
    url : "deleteProduct.html",
    data : {productNumber: productNumber},
    success : function(jsonResponse) {
      if (jsonResponse["success"] === true) {
        $.showMessage("Product Deleted Successfully!");
      } else {
        $.showMessage("Something went wrong." + jsonResponse["errMsg"], {
          backgroundColor : 'red'
        });
      }
    }
  });
}

function decorateEditProductDialog() {
};
