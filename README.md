# buildmonitor

A static html continuous integration build monitor.

## installation

* clone this repository
* install leiningen
* update 'cc-tray-url' in web.clj
* 'lein ring server'

## styling

Note the complete absence of styling. Please fork and add some styling to the *stylesheets/main.scss* and or editing the template in *javascripts/main.coffee*.

* run *guard* in this folder to automatically regenerate the *stylesheets/main.css* and *javascripts/main.js* files from the sass and coffeescript equivalents.

## to do

* cc-tray-url stored outside web.clj
* allow for more than one cc-tray-url

