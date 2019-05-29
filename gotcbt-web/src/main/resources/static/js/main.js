$(document).ready( function () {
    var table = $('#employeesTsssable').DataTable({
        "sAjaxSource": "/employees",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "name" },
            { "mData": "lastName" },
            { "mData": "email" },
            { "mData": "phone" },
            { "mData": "active" }
        ]
    })
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
            $(".panel .replaceDiv").hide(100);
        } else {
            $(".panel .replaceDiv").show(100);
            var deleteCell = $('<td><a>Delete</a></td>');
            var editCell = $('<td><a>Edit</a></td>');
            // bind href first and insert the cells later
            deleteCell.find('a').attr('href', '/delete/${user.id}'),
                editCell.find('a').attr('href', '/edit/${user.id}')
            var url = "./department/val/"+uu;
            var urls = "./department/"+uu;
            var table = $('#employeesTable').DataTable({
                "sAjaxSource": url,
                "sAjaxDataProp": "",
                "order": [[ 0, "asc" ]],
                "aoColumns": [

                    { "mData": "id"},
                    { "mData": "grade" },
                    {
                        "mData": "id",
                        "render": function(data, type, row, meta){
                            if(type === 'display'){
                                data = '<a href="' + data + '"><span class="fa fa-edit" data-toggle="tooltip" data-placement="top" title="Edit"></span></a>';
                            }

                            return data;
                        }
                    }


                ]
            })
            console.log(url);
           // $('#replace_div').load(urls);

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