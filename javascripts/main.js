(function() {
  var current, retrieveStatus, source, template;

  source = "{{#builds}}\n<div id=\"build{{@index}}\" class=\"status-{{status}} activity-{{activity}}\">\n  <h1>{{name}}: last status was {{status}}, now {{activity}}</h1>\n</div>\n{{/builds}}";

  current = "";

  template = Handlebars.compile(source);

  retrieveStatus = function() {
    $.ajax({
      url: "builds.json",
      success: function(data) {
        var content;
        content = template({
          builds: data
        });
        if (current !== content) {
          $("#builds").html(content);
        }
        return current = content;
      }
    });
    return setTimeout(retrieveStatus, 2000);
  };

  retrieveStatus();

}).call(this);
