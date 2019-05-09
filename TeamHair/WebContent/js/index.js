$(function() {
  $('.search-bar').css('width', $(window).width() - 180);
});

$(window).on('resize', function() {
  $('.search-bar').css('width', $(window).width() - 180);
});