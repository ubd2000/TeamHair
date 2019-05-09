$(document).ready(
		function() {
			$('.openBtn').click(
					function(e) {
						setTimeout(function() {
							$('.popup').removeClass('animationClose').addClass(
									'animationOpen');
						}, 100);
						$('.obscure').fadeIn(50);
						e.preventDefault();
					});

			$('.btnclose').click(
					function(e) {
						e.preventDefault();
						setTimeout(function() {
							$('.obscure').fadeOut(350);
						}, 50);
						$('.popup').removeClass('animationOpen').addClass(
								'animationClose');
					});
		});