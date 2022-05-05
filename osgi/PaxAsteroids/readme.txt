mvn org.ops4j:maven-pax-plugin:create-project -DgroupId=org.sonatype.mcookbook -DartifactId=osgi-project -Dversion=1.0-SNAPSHOT

mvn pax:create-bundle -Dpackage=dk.sdu.mmmi.OSGiAsteroids -Dname=core-bundle -Dversion=1.0-SNAPSHOT

mvn pax:wrap-jar -g groupId -a artifactId -v version