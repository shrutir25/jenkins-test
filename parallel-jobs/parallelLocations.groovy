#!/usr/bin/env groovy

node('all') {

    wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {
        String locations_str = "${LOCATIONS}"
        def locations = locations_str.tokenize('[ \t\n]+')

        stage("DeployToLocations") {
            for (i=0; i < locations.size(); i++) {
                env.LOCATION = locations[i]
                stage("${LOCATION}") {
                }
            }
        }    
    }             
}    


