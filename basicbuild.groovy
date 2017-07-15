node('localhost'){
    
    stage ("Create files"){
        writeFile file: "keepthisfile.txt", text: "Setting up commit hooks"
        writeFile file: "ignorethisfile", text: "rubbish"
        sh "docker ps"
        sh "df -h"
    }
    
    stage ("Archive files"){
        archiveArtifacts artifacts: 'keep*', excludes: 'ignore*'
    }    
}
