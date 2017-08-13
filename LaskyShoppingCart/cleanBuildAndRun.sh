#!/bin/bash

rm -fvR target
status=$?

if [ $status -eq 0 ]; then
	mvn clean
	status=$?
else
	echo "removing target failed!"
fi

if [ $status -eq 0 ]; then
	mvn install
	status=$?
else
	echo "mvn clean failed!"
fi

if [ $status -eq 0 ]; then
	mvn package
	status=$?
else
	echo "mvn install failed!"
fi


if [ $status -eq 0 ]; then
	mvn wildfly-swarm:run
	status=$?
else
	echo "mvn package failed!"
fi
