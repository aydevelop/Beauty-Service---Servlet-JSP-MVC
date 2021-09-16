$(function () {
    // setCookie("master_sort", "name", 10);
    // $('select').on('change', function () {
    //     setCookie("master_sort", this.value, 10);
    //     //location.reload();
    // });
    //
    // $('#master_select').val("val2");

    $('select#master_select').on('change', function () {
        let value = this.value;
        $.post("/home/master-sort?by=" + value, function (data, status) {
            if (status == "success") {
                $('#masters-list').html(data);
            }
        });
    });

    $('div#filters input').on('change', function () {
        let categories = [];
        let services = [];

        $('#filters #filter-category input:checked').each(function () {
            categories.push($(this).attr('value'));
        });

        $('#filters #filter-master input:checked').each(function () {
            services.push($(this).attr('value'));
        });

        $.post("/home/service-sort", {orderId: categories.toString()}, function (data, status) {
            if (status == "success") {
                alert("done....");
            }
        });

    });
});

function setCookie(name, value, days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "") + expires + "; path=/";
}

function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}