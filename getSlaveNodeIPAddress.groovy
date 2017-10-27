import hudson.util.RemotingDiagnostics;

/*
  This script can be used to get the connected IP of all Slave Nodes
  that match a given naming convention
  or adapted to run whatever command you like on all matching slave nodes.
*/

String req_name = "test" // find all nodes containing 'test' in their name
print_ip = 'println InetAddress.localHost.hostAddress';
int counter = 0;

for (slave in hudson.model.Hudson.instance.slaves) {
  if (slave.name.toLowerCase().contains(req_name.toLowerCase())){
    println "Slave " + ++counter + " named '" + slave.name.toString() + "' has IP:"
    println RemotingDiagnostics.executeGroovy(print_ip, slave.getChannel());
  } else {
    println slave.name.toString() + " is not marked as a potential '" + req_name + "' slave \n"
  }
}

println "Done: Found " + counter + " potential " + req_name + " nodes to use"


