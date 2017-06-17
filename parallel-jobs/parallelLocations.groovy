#!/usr/bin/env groovy

node('all') {

    wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {
        String locations_str = "${LOCATIONS}"
        def locations = locations_str.tokenize('[ \t\n]+')
        def executions = [:]

        for(int i = 0; i < locations.size(); i++) {
            executions[locations[i]] = create_execution(locations[i])
            }

        parallel executions
        def create_execution(String dist) {
            stage("${dist}") {
                cmd = { 
                    node {
                        sh "echo ${dist}"
                    }
                }
                return cmd
            }
        }
    }       
}    


