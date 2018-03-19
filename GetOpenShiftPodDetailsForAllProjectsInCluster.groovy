// quick script built upon these examples: https://github.com/utherp0/groovyoscp
// for all projects in the current cluster, show details/describe all pods this user can access

def parseproject(projectName) {
    return projectName.tokenize('/').last()
}

pipeline{
  agent any
  stages  {
    stage('selectortest') {
      steps {
        script {
          openshift.withCluster() {
            // For each project in the cluster
            def proselector = openshift.selector( 'project' )
                proselector.withEach {
                  //get the short project name
                  def proname = it.name()
                  proname = parseproject(proname)
                  echo "DON: This project is " + proname
                   try {
                      // use each project name
                      openshift.withProject( proname ) {
                      echo "Hello from project ${openshift.project()} in cluster ${openshift.cluster()}"
                        // try and list each of the pods in it (access permitting)
                        echo "Cycling through all PODs for " + proname
                        def selector = openshift.selector( 'pod' )
                        //selector.describe()
                        selector.withEach {
                          echo "DON: This POD is ${it.name()}"
                          selector.describe()
                        }
                      }
                   } catch (e) {
                       echo "ERROR: No access to project " + proname
                   }
                  }
                }
             }
      } //steps
    }
  }
}
