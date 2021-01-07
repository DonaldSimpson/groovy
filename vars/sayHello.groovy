#!/usr/bin/env groovy
def call(String name = 'human') {
    // See blog post on Jenkins Shared Libraries here: 
    // https://www.donaldsimpson.co.uk/2019/02/06/jenkins-global-pipeline-libraries-a-v-quick-start-guide/
    // 
    // Any valid steps can be called from this code, just like in other Scripted Pipelines
    echo "Hello, ${name}."
}
