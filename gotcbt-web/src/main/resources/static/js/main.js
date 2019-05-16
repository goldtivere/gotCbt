$(document).ready(function () {
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (schoolClass, status) {
            $('.myForm #id').val(schoolClass.id);
            $('.myForm #classType').val(schoolClass.classType);
        })
        $('.myForm #trueModal').modal();
    });

});

function employeeSelect() {
    //display the spinner
    $('#ajaxLoader').show();

    //first, let's get rid of the default "SELECT" option if it exists
    var defaultOption = $("#employeeIdSelect option[value='default']");
    if (defaultOption) defaultOption.remove();

    //get the selected id
    var employeeId = $('#employeeIdSelect').val();
    console.log(employeeId + "  hi")

    //get the url for the ajax call
    var url = "./class/" + employeeId;
    console.log(url + "  hi")

    //do the ajax call
    $.get(url, populateEmployeeInfo);
}

//This is the function we run when we get back a response
//from the ajax call
function populateEmployeeInfo(val) {
    var status = val.responseStatus;

    for(let r in val){  //for in loop iterates all properties in an object
        console.log(r + "hhhh") ;  //print all properties in sequence
        console.log(val[r].responseStatus);//print all properties values
    }
    val.forEach((row) => {
        console.log(row+ " okay now");

        //check the response to make sure it's ok
        if (row.status == "Ok") {
            const classTy = document.querySelector("#rankingTab > tbody");
            console.log(row.grade + " here i am");

            //get the JSON data
            var department = response.grade;
            console.log(department + " okay");
            var employeeId = response.schoolClass;
            console.log(employeeId + " damn");
            var firstName = response.firstName;
            var lastName = response.lastName;
            var hoursPerWeek = response.hoursPerWeek;
            var imageFile = './images/' + response.imageFile;

            //set the profile badge values
            $('#employeePic').attr("src", imageFile);
            $('#employeeName').html(firstName + ' ' + lastName);
            $('#employeeDepartment').html(department);

            //set the input field values
            $('#employeeFirstName').val(firstName);
            $('#employeeLastName').val(lastName);
            $('#employeeDept').val(department);
            $('#employeeId').val(employeeId);
            $('#employeeHours').val(hoursPerWeek);

            //show the hidden elements
            $('#profileRow').css('visibility', 'visible');
        }
    });

    //hide the spinner again
    $('#ajaxLoader').hide();
}

$.preloadImages = function () {
    for (var i = 0; i < arguments.length; i++) {
        $("<img />").attr("src", arguments[i]);
    }
}