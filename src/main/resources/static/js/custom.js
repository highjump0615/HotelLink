// On-load scripts
$(window).load(function(){

});

// Mouseup handle
jQuery(document).mouseup(function(e){
    var container = $("");
    if (!container.is(e.target) && container.has(e.target).length === 0){
        container.hide();
    }
});

$('.dropdown.dropdown-room .dropdown-toggle').on('click', function (event) {
    $(this).parent().toggleClass('open');
	return false;
});

$('body').on('click', function (e) {
    if (!$('.dropdown.dropdown-room .dropdown-menu').is(e.target) 
        && $('.dropdown.dropdown-room .dropdown-menu').has(e.target).length === 0 
        && $('.open').has(e.target).length === 0
    ) {
        $('.dropdown.dropdown-room').removeClass('open');
    }
});

// jQuery scripts
$(document).ready(function(){

	'use strict';

	// Jump toggle
	$('a.goto').on('click',function(){
		var gotoId = $(this).data('goto');
		$('html, body').animate({
			scrollTop: $('#'+gotoId).offset().top 
		}, 1000);
		return false;
	});

	$('.nav-opt').on('click',function(){
		$('.dropdown-menu',this).show();
		return false;
	});

	$('#controlQty button').on('click',function() {
		var _this = $('#controlQty'),
			_butt = $(this),
			qty = _this.find('input').val();
		if (_butt.hasClass('btn-plus')) {
			var qtys = parseInt(qty)+1;
			_this.find('input').val(qtys);
		} else {
			if (qty > 1) {
				var qtys = parseInt(qty)-1;
				_this.find('input').val(qtys);
			}
		}
		return false;
	});

	$('.toggle-facilities').on('click',function(){
		var facs = $(this).closest('.facility-list').find('.facility-list-more');
		if (facs.is(':hidden')) {
			facs.slideDown(300);
			$(this).html('Show less <span class="ico ico-arrow-up"></span>');
		} else {
			facs.slideUp(300);
			$(this).html('Show more <span class="ico ico-arrow-bottom"></span>');
		}
		return false;
	});

	$('.toggle-filter').on('click',function(){
		$(this).parent().find('hgroup').slideToggle(300);
	});

	// Checkbox
	$('input.checkbox-square').iCheck({ checkboxClass: 'icheckbox_square', radioClass: 'iradio_square' });
	$('input.checkbox-filter').iCheck({ checkboxClass: 'icheckbox_filter', radioClass: 'iradio_filter' });
	$("select.selector").select2({
		minimumResultsForSearch: Infinity
	});

	// Bootstrap
	$('[data-toggle="tooltip"]').tooltip({
		container: 'body'
	});
	$('[data-toggle="popover"]').popover({
		container: 'body'
	});
});


(function ($) {
    "use strict";
    function centerModal() {
        $(this).css('display', 'block');
        var $dialog  = $(this).find(".modal-dialog"),
        offset       = ($(window).height() - $dialog.height()) / 2,
        bottomMargin = parseInt($dialog.css('marginBottom'), 10);

        if(offset < bottomMargin) offset = bottomMargin;
        $dialog.css("margin-top", offset);
    }

    $(document).on('show.bs.modal', '.modal', centerModal);
    $(window).on("resize", function () {
        $('.modal:visible').each(centerModal);
    });
}(jQuery));
