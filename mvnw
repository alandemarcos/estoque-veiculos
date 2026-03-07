#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements. See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership. The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License. You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied. See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup script, version 3.2.0
#
# Required ENV vars:
# JAVA_HOME - location of a JDK home dir
#
# Optional ENV vars
# MAVEN_OPTS - parameters passed to the Java VM when running Maven
# MAVEN_SKIP_RC - flag to disable loading of mavenrc files
# ----------------------------------------------------------------------------

if [ -z "$MAVEN_SKIP_RC" ]; then
  if [ -f /usr/local/etc/mavenrc ]; then . /usr/local/etc/mavenrc; fi
  if [ -f /etc/mavenrc ]; then . /etc/mavenrc; fi
  if [ -f "$HOME/.mavenrc" ]; then . "$HOME/.mavenrc"; fi
fi

if [ -z "$JAVA_HOME" ]; then
  javaExecutable="$(which javac)"
  if [ -n "$javaExecutable" ]; then
    javaHome="$(dirname "$(dirname "$(dirname "$(readlink -f "$javaExecutable" 2>/dev/null || realpath "$javaExecutable" 2>/dev/null)")")")"
    if [ -x "$javaHome/bin/java" ]; then
      JAVA_HOME="$javaHome"
      export JAVA_HOME
    fi
  fi
fi

if [ -z "$JAVACMD" ]; then
  if [ -n "$JAVA_HOME" ]; then
    JAVACMD="$JAVA_HOME/bin/java"
  else
    JAVACMD="$(command -v java)"
  fi
fi

if [ ! -x "$JAVACMD" ]; then
  echo "Error: JAVA_HOME is not defined correctly. We cannot execute $JAVACMD" >&2
  exit 1
fi

find_maven_basedir() {
  basedir="$1"
  wdir="$1"
  while [ "$wdir" != '/' ]; do
    if [ -d "$wdir"/.mvn ]; then
      basedir=$wdir
      break
    fi
    wdir="$(cd "$wdir/.." 2>/dev/null && pwd)"
  done
  printf '%s' "$(cd "$basedir" 2>/dev/null && pwd)"
}

MAVEN_PROJECTBASEDIR=${MAVEN_BASEDIR:-"$(find_maven_basedir "$(pwd)")"}
export MAVEN_PROJECTBASEDIR

WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
exec "$JAVACMD" \
  $MAVEN_OPTS \
  $MAVEN_DEBUG_OPTS \
  -classpath "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" \
  "-Dmaven.multiModuleProjectDirectory=${MAVEN_PROJECTBASEDIR}" \
  ${WRAPPER_LAUNCHER} $MAVEN_CONFIG "$@"
