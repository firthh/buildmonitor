  source =
    """
    {{#builds}}
    <div id="build{{@index}}" class="status-{{status}} activity-{{activity}}">
      <h1>{{name}}: last status was {{status}}, now {{activity}}</h1>
    </div>
    {{/builds}}
    """

  current = ""
  template = Handlebars.compile source

  retrieveStatus = () ->
    $.ajax
      url: "builds.json",
      success: (data) ->
        content = template builds: data
        unless current == content
          $("#builds").html content
        current = content
    setTimeout retrieveStatus, 2000

  retrieveStatus()