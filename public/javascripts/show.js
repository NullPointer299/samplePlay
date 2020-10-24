$(function () {

    $('#datePicker').datetimepicker({
        format: 'YYYY-MM-DD'
    });

    $('#datePicker').on('change.datetimepicker', function () {
        const date = $('#inputDatePicker').val().split('-');
        console.log(date[0]);
        console.log(date[1]);
        console.log(date[2]);
        $('#year_create').val(date[0]);
        $('#month_create').val(date[1]);
        $('#day_create').val(date[2]);
    });

    // tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // dropdown select number
    $('.dropdown-number').click(function () {
        const selectedItem = $('.dropdown-toggle', $(this).closest('.dropdown'));
        const itemNumber = $(this).attr('value');
        selectedItem.text('#' + itemNumber);

        const itemRow = $('.auto-id')[itemNumber - 1].closest('tr');

        const employeeId = $('.employee-id', itemRow).text();
        const lastName = $('.last-name', itemRow).text();
        const firstName = $('.first-name', itemRow).text();
        const mailAddress = $('.mail-address', itemRow).text();
        const hireDate = $('.hire-date', itemRow).text().split('-');

        $('.input-employee-id').attr('placeholder', employeeId);
        $('.input-last-name').attr('placeholder', lastName);
        $('.input-first-name').attr('placeholder', firstName);
        $('.input-mail-address').attr('placeholder', mailAddress);

        // year
        $('.input-hire-date-year').attr('placeholder', hireDate[0]);

        // month
        $('.input-hire-date-month').attr('placeholder', hireDate[1]);

        // day
        $('.input-hire-date-day').attr('placeholder', hireDate[2]);

    });

    // reset modal forms when out of focus
    $('.btn-query').click(function () {
        $('.dropdown-toggle-number').text('Select #');
        $('.form-control').val('');
        $('.form-check-input').prop('checked', false);
        $('.text-tooltip').tooltip('enable');
        $('.update-text').prop('disabled', true);

        $('.input-employee-id').attr('placeholder', 'Employee ID');
        $('.input-last-name').attr('placeholder', 'Last name');
        $('.input-first-name').attr('placeholder', 'First name');
        $('.input-mail-address').attr('placeholder', 'Mail address');

        $('.input-hire-date-year').attr('placeholder', 'Year');
        $('.input-hire-date-month').attr('placeholder', 'Month');
        $('.input-hire-date-day').attr('placeholder', 'Day');
    });

    // enable textbox when checked box
    $('.form-check-input').change(function () {
        const textTooltip = $('.text-tooltip', $(this).closest('.form-group'));
        textTooltip.tooltip('toggleEnabled');

        const updateText = $('.update-text', textTooltip)
        updateText.prop('disabled', !$(this).prop('checked'));
        updateText.val('');
    });

});
