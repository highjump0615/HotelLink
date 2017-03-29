/**
 * home page
 */

var gdomDestinationMenu;
var gdomNationalityMenu;

/**
 * Key up on city field
 */
$('input[name="city"]').keyup(function () {
    var strKeyword = $(this).val();
    var menuDropdown = $(this).next();

    var aryDestination = [];

    if (strKeyword.length <= 0) {
        menuDropdown.hide();
        return;
    }

    //
    // query destination data
    //
    $.ajax({
        type: "GET",
        url: API_URL + 'suggestion/destination?key=' + strKeyword,
        dataType: 'json',
        crossDomain: true,
        success: function (data) {
            // clear list & array first
            aryDestination.slice(0, aryDestination.length);
            gdomDestinationMenu.empty();

            for (var i = 0; i < data.length; i++) {
                var dn = data[i];

                // add to array
                var destination = Destination.fromObject(dn);
                aryDestination.push(destination);

                // add to list
                var strLi = '<li>' + destination.cityName + ', ' + destination.countryName + '</li>';
                gdomDestinationMenu.append(strLi);
            }

            menuDropdown.show();
        },
        error: function (data) {
            console.log(data);
        }
    });
});

/**
 * Key up on nationality field
 */
$('input[name="nationality"]').keyup(function () {
    var strKeyword = $(this).val();
    var menuDropdown = $(this).next();

    if (strKeyword.length <= 0) {
        menuDropdown.hide();
        return;
    }

    var aryNationality = [];

    //
    // query nationality data
    //
    $.ajax({
        type: "GET",
        url: API_URL + 'suggestion/nationality?key=' + strKeyword,
        dataType: 'json',
        crossDomain: true,
        success: function (data) {
            // clear list & array first
            aryNationality.slice(0, aryNationality.length);
            gdomNationalityMenu.empty();

            for (var i = 0; i < data.length; i++) {
                var dn = data[i];

                // add to array
                var nationality = Nationality.fromObject(dn);
                aryNationality.push(nationality);

                // add to list
                var strLi = '<li>' + nationality.countryName + '</li>';
                gdomNationalityMenu.append(strLi);
            }

            menuDropdown.show();
        },
        error: function (data) {
            console.log(data);
        }
    });
});


$(document).ready(function(){

    'use strict';

    // init
    gdomDestinationMenu = $('#destination-menu');
    gdomNationalityMenu = $('#nationality-menu');

    /**
     * Initialize Date picker
     */
    var objDatePicker = $('.datepicker');

    objDatePicker.on('focus',function(){
        $(this).closest('.has-icon').addClass('dropdown-open');
        $('.dropdown-room').removeClass('open');
    });

    objDatePicker.datepick({
        alignment: 'top',
        onSelect: customRange,
        minDate: $.datepick.today(),
        monthsToShow: 2,
        changeMonth: false,
        popupContainer: '.calendardaten',
        nextText: '',
        prevText: '',
        showAnim: '',
        onClose: function() {
            $('.has-icon').removeClass('dropdown-open');
        }
    });

});

function customRange(dates) {
    if (this.id == 'dateCheckin') {
        $('#dateCheckout').datepick('option', 'minDate', dates[0] || null);
    } else {
        $('#dateCheckin').datepick('option', 'maxDate', dates[0] || null);
    }
}

$('body').on('click', function (e) {
    // close dropdown menus
    hideDropdown();
});

/**
 * hides Destination & Nationality Dropdown menus
 */
function hideDropdown() {
    gdomDestinationMenu.parent().hide();
    gdomNationalityMenu.parent().hide();
}
