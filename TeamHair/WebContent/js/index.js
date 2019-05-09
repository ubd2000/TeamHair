$(function(){
  var accessToken = '273700138.f359f2c.f6d5dd3e37704cb8b976331d56706931';
  $.getJSON('https://api.instagram.com/v1/users/self/media/recent/?access_token='+accessToken+'&callback=?',function (insta) {
    $.each(insta.data,function (photos,src) {
      if ( photos === 20 ) { return false; }
      $('<a href="'+src.link+'" class="post">'+
        '<div class="image" style="background-image:url('+src.images.standard_resolution.url+');"></div>'+
        '<ul>'+
        '<li><i class="fa fa-camera"></i> '+src.filter+'</li>'+
        '<li><i class="fa fa-heart"></i> '+src.likes.count+'</li>'+
        '<li><i class="fa fa-comment"></i> '+src.comments.count+'</li>'+
        '</ul></a>').appendTo('#content');
    });
  });

	
});


$('.open-popup-link').magnificPopup({
	  type: 'inline',
	  midClick: true,
	  mainClass: 'mfp-fade'
	});