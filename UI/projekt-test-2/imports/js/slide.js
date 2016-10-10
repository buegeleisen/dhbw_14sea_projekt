$(document).ready(function(){

//slide
$(window).scroll(function() {
  $(".slideanim").each(function(){
    var pos = $(this).offset().top;

    var winTop = $(window).scrollTop();
    if (pos < winTop + 700) {
      $(this).addClass("slide");
    }
  });
});

    
})
