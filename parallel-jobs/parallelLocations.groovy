#!/usr/bin/env groovy

node('all') {

    wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {
        String locations_str = "${LOCATIONS}"
        def locations = locations_str.tokenize('[ \t\n]+')

        for (i=0; i < locations.size(); i++) {
            stage("${LOCATION}") {
            }
        }
    }             
}    


