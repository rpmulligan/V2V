function generateEditForm(formGeneratorUrl, jsonInputData, updateFunction,
    title, divId, onSuccessDecorate, height, width) {

  var editFormId = 'edit' + divId;
  $.ajax({
    url : formGeneratorUrl,
    contentType: "application/json",
    type : "GET",
    data : jsonInputData,
    success : function(responseData) {
      $("<div id='" + editFormId + "'>" + responseData + "</div>").dialog({
        autoOpen : false,
        height : height,
        width : width,
        modal : true,
        title : title,
        buttons : {
          "Update" : function() {
            updateFunction($("#" + editFormId).children()[0]);
            $(this).dialog("close");
          },
          "Cancel" : function() {
            $(this).dialog("close");
          }
        },
        close : function() {
          $("#" + editFormId).remove();
        }

      });
      $("#" + editFormId).dialog("open");
    }
  });
}

$.fn.serializeObject = function() {
  var o = {};
  var a = this.serializeArray();
  console.log(a);
  $.each(a, function() {
    if (o[this.name] !== undefined) {
      if (!o[this.name].push) {
        o[this.name] = [ o[this.name] ];
      }
      o[this.name].push(this.value || '');
    } else {
      o[this.name] = this.value || '';
    }
  });
  return o;
};

function isValidDate(txtDate) {
  var objDate, // date object initialized from the txtDate string
  mSeconds, // txtDate in milliseconds
  day, // day
  month, // month
  year; // year
  // date length should be 10 characters (no more no less)
  if (txtDate.length !== 10) {
    return false;
  }
  // third and sixth character should be '/'
  if (txtDate.substring(2, 3) !== '/' || txtDate.substring(5, 6) !== '/') {
    return false;
  }
  // extract month, day and year from the txtDate (expected format is
  // mm/dd/yyyy)
  // subtraction will cast variables to integer implicitly (needed
  // for !== comparing)
  month = txtDate.substring(0, 2) - 1; // because months in JS start from 0
  day = txtDate.substring(3, 5) - 0;
  year = txtDate.substring(6, 10) - 0;
  // test year range
  if (year < 1000 || year > 3000) {
    return false;
  }
  // convert txtDate to milliseconds
  mSeconds = (new Date(year, month, day)).getTime();
  // initialize Date() object from calculated milliseconds
  objDate = new Date();
  objDate.setTime(mSeconds);
  // compare input date and parts from Date() object
  // if difference exists then date isn't valid
  if (objDate.getFullYear() !== year || objDate.getMonth() !== month
      || objDate.getDate() !== day) {
    return false;
  }
  // otherwise return true
  return true;
}

$.extend({
  getUrlVars : function() {
    var vars = [], hash;
    var hashes = window.location.href.slice(
        window.location.href.indexOf('?') + 1).split('&');
    for ( var i = 0; i < hashes.length; i++) {
      hash = hashes[i].split('=');
      vars.push(hash[0]);
      vars[hash[0]] = hash[1];
    }
    return vars;
  },
  getUrlVar : function(name) {
    return $.getUrlVars()[name];
  },
  validateDate : function(dateElement, errorPanelElement) {
    if (!dateElement.visible) {
      return true;
    }
    var dateValue = "";
    if (typeof (dateElement.value) == "string") {
      dateValue = dateElement.value;
    } else {
      dateValue = dateElement.val();
    }
    if (dateValue.length > 0) {

      if (isValidDate(dateValue)) {
        return true;
      } else {
        errorPanelElement.html("Date should be in mm/dd/yyyy format");
        errorPanelElement.show();
        dateElement.focus();
        return false;
      }
    }
    return true;
  },
  zerofill : function(number, length) {
    var result = number.toString();
    var pad = length - result.length;

    while (pad > 0) {
      result = '0' + result;
      pad--;
    }

    return result;
  },
  setDefaultDate : function(inputElement, date) {
    if (inputElement.val() == '') {
      var dateString = $.zerofill(date.getMonth() + 1, 2) + "/"
          + $.zerofill(date.getDate(), 2) + "/"
          + (date.getFullYear()).toString();
      inputElement.val(dateString);
    }
  },
  validateForm : function(formId, errorPanelId) {
    var errorPanelSelector = "#" + errorPanelId;
    var errorPanel = $(errorPanelSelector)
    errorPanel.html('<ul></ul>');

    var errorPanelUl = $(errorPanelSelector + ' ul');
    var validForm = true;
    var requiredFields = $('#' + formId + ' input[req|="true"]');
    var reqList = [];
    requiredFields.each(function(index, element) {
      if ($(element).is(":visible") && $(element).val().trim().length == 0) {
        $(element).siblings().each(function(i, e) {
          if ($(e).attr('for') == $(element).attr('id')) {
            reqList.push($(e).text().replace(':', ''));
          }
        })
      }
    });

    if (reqList.length > 0) {
      errorPanelUl.append('<li>Please enter ' + reqList.join(',') + '</li>')
      validForm = false;
    }

    var numOnlyList = [];
    var numOnlyFields = $('#' + formId + ' input[numOnly|="true"]');
    numOnlyFields.each(function(index, element) {
      if ($(element).val().length > 0 && $(element).is(":visible")) {
        var value = $(element).val();
        var intRegex = /^\d+$/;
        if (!intRegex.test(value)) {
          $(element).siblings().each(function(i, e) {
            if ($(e).attr('for') == $(element).attr('id')) {
              numOnlyList.push($(e).text().replace(':', ''));
            }
          })
        }
      }
    });

    if (numOnlyList.length > 0) {
      errorPanelUl.append('<li> ' + numOnlyList.join(',')
          + ' can only be numbers</li>')
      validForm = false;
    }

    var datesList = [];
    var dateFields = $('#' + formId + ' input[dateValid|="true"]');
    dateFields.each(function(index, element) {
      var dateValue = "";
      element = $(element);
      if (element.is(":visible")) {
        if (typeof (element.value) == "string") {
          dateValue = element.value;
        } else {
          dateValue = element.val();
        }
        if (dateValue.length > 0) {

          if (isValidDate(dateValue) == false) {
            $(element).siblings().each(function(i, e) {
              if ($(e).attr('for') == $(element).attr('id')) {
                datesList.push($(e).text().replace(':', ''));
              }
            })
          }
        }
      }
    });

    if (datesList.length > 0) {
      errorPanelUl.append('<li> ' + datesList.join(',')
          + ' should be in format mm/dd/yyyy</li>')
      validForm = false;
    }

    if (validForm == false) {
      errorPanel.show();
      window.scrollTo(0, 0);
    }
    return validForm;
  }
});

$.fn.isBound = function(type) {
  if (this.data('events') === undefined)
    return false;
  var data = this.data('events')[type];

  if (data === undefined || data.length === 0) {
      return false;
  }
  return true;
};