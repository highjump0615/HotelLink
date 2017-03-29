/**
 * home page
 */

var objAjax;

/**
 * Key up on nationality field
 */
$('input[name="nationality"]').keyup(function () {
    var strKeyword = $(this).val();
    var aryNationality = [];

    $.ajax({
        type: "GET",
        url: API_URL + 'suggestion/nationality?key=' + strKeyword,
        dataType: 'json',
        crossDomain: true,
        success: function (data) {
            var objNationMenu = $('#nationality-menu');

            // clear list & array first
            aryNationality.slice(0, aryNationality.length);
            objNationMenu.empty();

            for (var i = 0; i < data.length; i++) {
                var dn = data[i];

                // add to array
                var nationality = Nationality.fromObject(dn);
                aryNationality.push(nationality);

                // add to list
                var strLi = '<li>' + nationality.countryName + '</li>';
                objNationMenu.append(strLi);
            }
        },
        error: function (data) {
            console.log(data);
        }
    });
});