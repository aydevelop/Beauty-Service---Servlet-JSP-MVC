$(function () {
    $('select#master_select').on('change', function () {
        let value = this.value;
        $.post("/home/master-sort?by=" + value, function (data, status) {
            if (status == "success") {
                $('#masters-list').html(data);
            }
        });
    });

    $('body').on('change', '#filters input', function () {
        filter();
    });

    $('body').on('change', '#recordsPerPage', function () {
        filter();
    });

    $("#alert_msg").delay(3000).fadeOut(500);
});

function filter(index) {
    let categories = [];
    let masters = [];

    $('#filters #filter-category input:checked').each(function () {
        categories.push($(this).attr('value'));
    });

    $('#filters #filter-master input:checked').each(function () {
        masters.push($(this).attr('value'));
    });

    let recordsPerPage = $('#recordsPerPage').val();

    $.post("/home/service-sort", {
        categories: categories.join(' '),
        masters: masters.join(' '),
        currentPage: index,
        recordsPerPage: recordsPerPage
    }, function (data, status) {
        if (status == "success") {
            $('#services-list').html(data);
        }
    });
}