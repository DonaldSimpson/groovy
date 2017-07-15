node {
    stage "Create files"
    
    writeFile file: "keepthisfile.txt", text: "Some useful info"
    writeFile file: "ignorethisfile", text: "rubbish"

    stage "Archive files"
    archiveArtifacts artifacts: 'keep*', excludes: 'ignore*'
}
