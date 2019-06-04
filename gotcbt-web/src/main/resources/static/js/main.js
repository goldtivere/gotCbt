$(document).ready(function () {

    // $('.confirmation').on('click', function () {
    //     return confirm('Are you sure you want to delete?');
    // });

    //call function when page is loaded
    getContent();

    //set on change listener
    $('#employeeIdSelect').change(getContent);
    $('#termSelect').change(getTermContent);

    function getContent() {

        //create url to request fragment
        $('#ajaxLoader').show();
        // $('.confirmation').on('click', function () {
        //     return confirm('Are you sure you want to delete?');
        // });
        var uu = $('#employeeIdSelect').val();
        if (uu == "default") {
            $(".panel .replaceDiv").hide(100);
        } else {
            $(".panel .replaceDiv").show(100);
            var url = "./department/val/"+uu;
            var urls = "./department/"+uu;
            var table = $('#employeesTable').DataTable({
                "destroy": true,
                "sAjaxSource": url,
                "sAjaxDataProp": "",
                "order": [[ 0, "asc" ]],
                "aoColumns": [

                    { "mData": "grade" },
                    {
                        "mData": "id",
                        "render": function(data, type, row, meta){
                            if(type === 'display'){
                                data = '<a href="/admin/department/update/' + data + '"><span class="fa fa-edit" data-toggle="tooltip" data-placement="top" title="Edit"></span></a>' +
                                    '<a class="confirmation" href="/admin/department/delete/' + data + '" onclick = "if (! confirm(\'Are you sure you want to delete?\')) { return false; }"><span class="fa fa-trash" data-toggle="tooltip"  title="Sent to Trash Box"></span></a>';
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


    function getTermContent() {
        var country = $("#termSelect").val();
        var url = "./department/val/"+country;
        console.log(url+ " here i am");
        $.get( url, function( data ) {
            $("#classId").empty();
            data.forEach(function(item, i) {
                console.log(item.grade+ "  i am");
                var option = "<option value = " + item.grade + ">" + item.grade +  "</option>";
                $("#classId").append(option);
            });
        });

    }
})


