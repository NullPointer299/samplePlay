$(function () {
    $('[data-toggle="tooltip"]').tooltip();

    $('.dropdown-menu .dropdown-item').click(function () {
        const visibleItem = $('.dropdown-toggle', $(this).closest('.dropdown'));
        visibleItem.text($(this).attr('value'));
    });
});
