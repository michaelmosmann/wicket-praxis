#!/bin/sh
MAVEN_OPTS="-Xmx256m -Dwicket.configuration=development"
export MAVEN_OPTS
mvn jetty:run
