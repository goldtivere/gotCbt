$(document).ready(function () {

    // $('.confirmation').on('click', function () {
    //     return confirm('Are you sure you want to delete?');
    // });

    //call function when page is loaded
    getSubj();
    getContent();

    getTermContent();

    //set on change listener
    $('#employeeIdSelect').change(getContent);
    $('#termSelect').change(getTermContent);
    $('#classId').change(getTabContent);
    $('#classIdSub').change(getSubContent);
    $('#entryType').change(getSel);
    $('#termId').change(getSubjectContent);


    function getContent() {

        //create url to request fragment
        $('#ajaxLoader').show();
        // $('.confirmation').on('click', function () {
        //     return confirm('Are you sure you want to delete?');
        // });
        var uu = $('#employeeIdSelect').val();
        if (uu == "default") {
            $(".panel .replaceDiv").hide();
        } else {
            $(".panel .replaceDiv").show();
            var url = "./department/val/" + uu;
            var urls = "./department/" + uu;
            var table = $('#employeesTable').DataTable({
                "destroy": true,
                "sAjaxSource": url,
                "sAjaxDataProp": "",
                "order": [[0, "asc"]],
                "aoColumns": [

                    {"mData": "grade"},
                    {
                        "mData": "id",
                        "render": function (data, type, row, meta) {
                            if (type === 'display') {
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

    function getSubj() {

        //create url to request fragment
        $(".panel .replaceDivs").hide();
        $(".replace_div1").hide();
        $(".replace_div2").hide();

    }
    function getSel() {

        var uu = $('#entryType').val();

        if (uu == "Entry") {

            $(".replace_div1").show();
            $(".replace_div2").hide();
        } else if(uu=="Upload"){

            $(".replace_div1").hide();
            $(".replace_div2").show();

        }

    }

    function getTabContent() {

        //create url to request fragment
        $('#ajaxLoader').show();
        // $('.confirmation').on('click', function () {
        //     return confirm('Are you sure you want to delete?');
        // });
        var uu = $('#classId').val();

        if (uu == "default" || uu == "" || uu == null) {
            $(".panels .replaceDivs").hide(100);
        } else {
            $(".panels .replaceDivs").show(100);
            var url = "./term/val/" + uu;
            var urls = "./term/" + uu;
            var table = $('#tabTable').DataTable({
                "destroy": true,
                "sAjaxSource": url,
                "sAjaxDataProp": "",
                "order": [[0, "asc"]],
                "aoColumns": [

                    {"mData": "term"},
                    {
                        "mData": "id",
                        "render": function (data, type, row, meta) {
                            if (type === 'display') {
                                data = '<a href="/admin/term/update/' + data + '"><span class="fa fa-edit" data-toggle="tooltip" data-placement="top" title="Edit"></span></a>' +
                                    '<a class="confirmation" href="/admin/term/delete/' + data + '" onclick = "if (! confirm(\'Are you sure you want to delete?\')) { return false; }"><span class="fa fa-trash" data-toggle="tooltip"  title="Sent to Trash Box"></span></a>';
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

    function getSubContent() {

        $('#ajaxLoader').show();
        var country = $("#classIdSub").val();
        $(".panels .replaceDivs").hide();
        if (country == "default" || country == null || country == "") {

        } else {

            var url = "./term/val/" + country;
            console.log(url + " here i am");
            $.get(url, function (data) {
                $("#termId").empty();

                var options = " <option value='default' selected='true'>-- SELECT TERM--</option>";
                $("#termId").append(options);
                data.forEach(function (item, i) {
                    console.log(item.term + "  i am");

                    var option = "<option value = " + item.id + ">" + item.term + "</option>";
                    $("#termId").append(option);
                });
            });
        }


        $('#ajaxLoader').hide();

    }

    function getTermContent() {
        $('#ajaxLoader').show();
        var country = $("#termSelect").val();
        $(".panels .replaceDivs").hide();
        if (country == "default" || country == null || country == "") {

        } else {

            var url = "./department/val/" + country;
            console.log(url + " here i am");
            $.get(url, function (data) {
                $("#classId,#classIds,#classIdss").empty();

                var options = " <option value='default' selected='true'>-- SELECT GRADE--</option>";
                $("#classId").append(options);
                $("#classIdss").append(options)
                data.forEach(function (item, i) {
                    console.log(item.grade + "  i am");

                    var option = "<option value = " + item.id + ">" + item.grade + "</option>";
                    $("#classIds").append(option)
                    $("#classId").append(option)
                    $("#classIdss").append(option)
                    $("#classIdSub").append(option)
                });
            });
        }


        $('#ajaxLoader').hide();

    }

    function getSubjectContent() {

        //create url to request fragment
        $('#ajaxLoader').show();
        // $('.confirmation').on('click', function () {
        //     return confirm('Are you sure you want to delete?');
        // });
        var term = $('#termId').val();
        var dept = $('#classIdSub').val();
        var year = $('#year').val();
        if (term == "default") {
            $(".panel .replaceDivs").hide();
        } else {
            $(".panel .replaceDivs").show();
            var url = "./subject/term/" + term+"/"+dept+"/"+year+"/";
            //var urls = "./department/" + uu;
            var table = $('#tabTable').DataTable({
                "destroy": true,
                "sAjaxSource": url,
                "sAjaxDataProp": "",
                "order": [[0, "asc"]],
                "aoColumns": [

                    {"mData": "subjectName"},
                    {
                        "mData": "id",
                        "render": function (data, type, row, meta) {
                            if (type === 'display') {
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
})


