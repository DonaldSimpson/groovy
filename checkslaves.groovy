// Simplisitc groovy script to check the sattus of Jenkins Slaves
// Intended to be run in the Jenkins Script Console
int exitcode = 0
for (slave in hudson.model.Hudson.instance.slaves) {
 if (slave.getComputer().isOffline().toString() == "true"){
 println('Slave ' + slave.name + " is offline!");
 exitcode++;
 }else{
   println('No slaves found to be offline...');
 }
}

if (exitcode > 0){
 println("We have a Slave down, failing the build!");
 return 1;
}
