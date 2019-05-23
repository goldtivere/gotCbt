// $(document).ready(function () {
//     $('.tables .eBtn').on('click', function (event) {
//         event.preventDefault();
//         var href = $(this).attr('href');
//         var val = $(this).attr("id");
//
//         console.log(val + " na this")
//         $.get(href, function (schlDept, status) {
//             $('.myForms #id').val(schoolClass.id);
//             $('.myForms #dept').val(schoolClass.grade);
//         })
//         $('.myForms #trueModals').modal();
//
//     });
//
// });
//
// $(document).ready(function () {
//     $('.table .eBtn').on('click', function (event) {
//         event.preventDefault();
//         var href = $(this).attr('href');
//         var val = $(this).attr("id");
//
//         if (val == "dept") {
//             console.log(val + " na this")
//             $.get(href, function (schoolClass, status) {
//                 $('.myForm #id').val(schoolClass.id);
//                 $('.myForm #classType').val(schoolClass.classType);
//             })
//             $('.myForm #trueModal').modal();
//         } else if (val == "class") {
//             console.log(val + " na this")
//             $.get(href, function (schlDept, status) {
//                 $('.myForm #id').val(schoolClass.id);
//                 $('.myForm #dept').val(schoolClass.grade);
//             })
//             $('.myForm #trueModal').modal();
//         }
//     });
//
//
// });


$(document).ready(function () {
    $('#postMe .nav-link').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#replace_div').load(url);

    });

});

$(document).ready(function () {

    //call function when page is loaded
    getContent();

    //set on change listener
    $('#employeeIdSelect').change(getContent);

    function getContent() {

        //create url to request fragment
        $('#ajaxLoader').show();
        var uu = $('#employeeIdSelect').val();
        if (uu == "default") {
        } else {
            var url = "./department/" + uu;

            console.log(url);
            $('#replace_div').load(url);
            //load fragment and replace content
            // $('#replace_div').load(url);
        }
        $('#ajaxLoader').hide();
    }
})


// function employeeSelect() {
//     $('#ajaxLoader').show();
//         var name = $('.drop-down option:selected').val();
//     var employeeId = $('#employeeIdSelect').val();
//     console.log(employeeId + "  hi")
//         var url = "./class/";
//         console.log(url);
//         $.ajax({
//             type: 'get',
//             url: url,
//             data:  {name:name},
//             success: function(returnedData){
//                 console.log(returnedData+ " dude");
//                 $('.deptDetails').html(returnedData);
//
//             },
//
//             error: function(xhr, exception) {
//                 console.log(xhr);
//                 alert("error");
//             }
//         });
//
//     $('#ajaxLoader').hide();
// }



// function employeeSelect() {
//     //display the spinner
//     $('#ajaxLoader').show();
//
//     //first, let's get rid of the default "SELECT" option if it exists
//     var defaultOption = $("#employeeIdSelect option[value='default']");
//     if (defaultOption) defaultOption.remove();
//
//     //get the selected id
//     var employeeId = $('#employeeIdSelect').val();
//     console.log(employeeId + "  hi")
//
//     //get the url for the ajax call
//     var url = "./class/" + employeeId;
//     console.log(url + "  hi")
//
//     //do the ajax call
//     $.get(url, populateEmployeeInfo);
// }

//This is the function we run when we get back a response
//from the ajax call
// function populateEmployeeInfo(val) {
//     var status = val.responseStatus;
//
//     for(let r in val){  //for in loop iterates all properties in an object
//         console.log(val[r].responseStatus+ "yess");
//
//         $('.deptDetails').html(val[r].response);
//         if(val[r].responseStatus== "Ok") {
//
//             for (let u in val[r].response) {
//                 console.log(val[r].response[u].grade + " hello");//print all properties values
//                 //get the JSON data
//                 var id = val[r].response[u].id;
//                 var grade =val[r].response[u].grade;
//
//
//                 //set the profile badge values
//                 $('#employeePic').attr("src", imageFile);
//                 $('#employeeName').html(firstName + ' ' + lastName);
//                 $('#employeeDepartment').html(department);
//
//             }
//         }
//     }
//
//     //hide the spinner again
//     $('#ajaxLoader').hide();
// }
//
// $.preloadImages = function () {
//     for (var i = 0; i < arguments.length; i++) {
//         $("<img />").attr("src", arguments[i]);
//     }
// }