# buildmonitor

A static html continuous integration build monitor.

## installation

* clone this repository
* install ruby
* gem install bundler
* bundle
* run *chicanery builds.chicanery* (this will generate *state* and *builds.json* files)
* point any kind of web server to this folder (eg. "python -m SimpleHTTPServer")

## updating build status

* edit the builds.chicanery file to point to your favourite ci servers
* configure a crontab job or scheduled task to run *chicanery builds.chicanery*

See [chicanery](https://github.com/markryall/chicanery) for more details.

## styling

Note the complete absence of styling. Please fork and add some styling to the *stylesheets/main.scss* and or editing the template in *javascripts/main.coffee*.

* run *guard* in this folder to automatically regenerate the *stylesheets/main.css* and *javascripts/main.js* files from the sass and coffeescript equivalents.

## development

Plenty more build information is available - see the generated *state* file.

If you wish to display this, edit *builds.chicanery* to include it in the generated *builds.json* file.