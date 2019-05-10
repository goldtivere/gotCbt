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