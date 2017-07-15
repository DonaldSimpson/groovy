node('localhost'){
    
    stage ("Create files"){
        writeFile file: "keepthisfile.txt", text: "Some useful info"
        writeFile file: "ignorethisfile", text: "rubbish"
        sh "docker ps"
        sh "df -h"
    }
    
    stage ("Archive files"){
        archiveArtifacts artifacts: 'keep*', excludes: 'ignore*'
    }    
}
