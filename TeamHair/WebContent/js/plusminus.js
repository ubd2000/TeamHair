(function($) {
  var events = 'ontouchstart' in document.documentElement ? ['touchstart', 'touchend'] : ['mousedown', 'mouseup'];
  
  $(document)
    .on(events[0], ".btn-minus, .btn-plus", function(e) {
      console.log(e);
      e.preventDefault();
      var $this = $(this);
      var data = $this.data();
      var parseFunc = data.type == "float" ? parseFloat : parseInt;

      var steps = data.steps ? parseFunc(data.steps, 10) : 1;
      var $input = data.target ? $(data.target) : $this.closest(".input-group").find("input.form-control");

      var val = parseFunc($input.val(), 10);
      var min = data.min ? parseFunc(data.min, 10) : parseFunc($input.attr("min"), 10);
      var max = data.max ? parseFunc(data.max, 10) : parseFunc($input.attr("max"), 10);

      if ($this.hasClass("btn-minus")) {
        if (val - steps >= min) $input.val(val - steps);
        else if (val !== min) $input.val(min);
      } else if ($this.hasClass("btn-plus")) {
        if (val + steps <= max) $input.val(val + steps);
        else if (val != max) $input.val(max);
      }
      if (data.interval) {
        clearInterval(data.interval);
        $this.delay = 180;
      } else 
        $this.delay = 500;
      data.interval = setInterval(function() {
        $this.trigger(e.type);
      }, $this.delay);
    })
    .on(events[1], ".btn-minus, .btn-plus", function(e) {
      console.log(e);
      var $this = $(this);
      var data = $this.data();
      if (data.interval) {
        clearInterval(data.interval);
        $this.delay = 500;
      }
    });
})(jQuery);