/**
 * home page
 */

var gdomDestinationMenu;
var gdomNationalityMenu;

var garyNationality = [];
var gnNationalityIndex;

var garyDestination = [];
var gnDestinationIndex;

var gnRoomCount = 1;
var gnAdultCount = 2;
var gnChildCount = 1;

/**
 * Key up on city field
 */
$('input[name="destination"]').keyup(function () {
    var strKeyword = $(this).val();
    var menuDropdown = $(this).next();

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
            garyDestination.splice(0, garyDestination.length);
            gdomDestinationMenu.empty();

            for (var i = 0; i < data.length; i++) {
                var dn = data[i];

                // add to array
                var destination = Destination.fromObject(dn);
                garyDestination.push(destination);

                // add to list
                var strLi = '<li>' + destination.toString() + '</li>';
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
            garyNationality.splice(0, garyNationality.length);
            gdomNationalityMenu.empty();

            for (var i = 0; i < data.length; i++) {
                var dn = data[i];

                // add to array
                var nationality = Nationality.fromObject(dn);
                garyNationality.push(nationality);

                // add to list
                var strLi = '<li>' +
                    '<span class="flag-icon flag-icon-' + nationality.countryId + '"></span>'
                    + nationality.countryName +
                    '</li>';

                gdomNationalityMenu.append(strLi);
            }

            menuDropdown.show();
        },
        error: function (data) {
            console.log(data);
        }
    });
});

/**
 * Update room, adult, child counts
 */
function updateRoomInfo() {
    var strValue = gnRoomCount + ' Rooms, ' + gnAdultCount + ' Adults, ' + gnChildCount + ' Children';
    $('#roominfo-a').html(strValue);
}

/**
 * add/remove child age select
 */
function updateChildRow() {
    var domChild = $('#childrow-div');

    // remove all first
    domChild.empty();

    for (var i = 0; i < gnChildCount; i++) {
        var strSelect = '<div class="col-sm-4"><div class="form-group">' +
            '<label>Child ' + (i + 1) + ' Age</label>' +
            '<select class="selector" name="childage" style="width:100%;">' +
            '   <option value="1">1</option>' +
            '   <option value="2">2</option>' +
            '   <option value="3">3</option>' +
            '   <option value="4">4</option>' +
            '   <option value="5">5</option>' +
            '   <option value="6" selected>6</option>' +
            '   <option value="0">...</option>' +
            '</select>' +
            '</div></div>';

        domChild.append(strSelect);
    }

    initSelect2();
}

$(document).ready(function(){

    'use strict';

    // init
    gdomDestinationMenu = $('#destination-menu');
    gdomDestinationMenu.on('click', 'li', function () {
        gnDestinationIndex = $(this).index();

        // Set selected destination
        $('input[name="destination"]').val($(this).html());
    });

    gdomNationalityMenu = $('#nationality-menu');
    gdomNationalityMenu.on('click', 'li', function () {
        gnNationalityIndex = $(this).index();
        var nationality = garyNationality[gnNationalityIndex];

        // Set selected nationality
        var domInput = $('input[name="nationality"]');
        domInput.val(nationality.countryName);

        // set flag
        var domFlag = domInput.prev();
        var aryClass = domFlag.attr('class').split(' ');
        $.each(aryClass, function(index, item) {
            // get current country flag
            if (item.indexOf('flag-icon-') == 0) {
                domFlag.removeClass(item);
            }
        });
        domFlag.addClass('flag-icon-' + nationality.countryId);
    });

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

    /**
     * ROOM, ADULTS, CHILDREN form
     */
    $('#controlQty button').on('click',function() {
        var _this = $('#controlQty'),
            _butt = $(this),
            qty = _this.find('input').val();
        if (_butt.hasClass('btn-plus')) {
            var qtys = parseInt(qty)+1;
            _this.find('input').val(qtys).change();
        } else {
            if (qty > 1) {
                var qtys = parseInt(qty)-1;
                _this.find('input').val(qtys).change();
            }
        }
        return false;
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

/**
 * changing room count
 */
$('input[name="roomcount"]').on('change', function () {
    gnRoomCount = parseInt($(this).val());
    updateRoomInfo();
});

/**
 * changing adult count
 */
$('#adultcount-select').on('change', function () {
    gnAdultCount = parseInt($(this).val());
    updateRoomInfo();
});

/**
 * changing child count
 */
$('#childcount-select').on('change', function () {
    gnChildCount = parseInt($(this).val());
    updateRoomInfo();
    updateChildRow();
});

/**
 * form submit
 */
$('#findhotel-form').submit(function () {
});