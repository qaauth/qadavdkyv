#!/bin/bash
javadoc -docletpath target/Dav-0.0.1-SNAPSHOT-jar-with-dependencies.jar -doclet Dav.Dav.Doclet "$@"
