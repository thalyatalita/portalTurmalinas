$(document).ready(function () {

//VARIAVEIS
    var _containerBtn  = $('[data-container="botao-voltar"');

//RoLAGEM
    $(window).scroll(function() {
        if($(this).scrollTop() > 70) {
            _containerBtn.fadeIn(500);
    } else {
        _containerBtn.fadeOut(0);
    }
});

//CLICK
 _containerBtn.click(function() {
     $("html, body").animate({scrollTop: 0}, 800);

     return false;
 });


});
