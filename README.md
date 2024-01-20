XBUP: eXtensible Binary Universal Protocol
==========================================

The goal of this project is to design and to provide an open-source support for unified general binary data representation format.

This should provide following advantages:

 * Advanced Data Structures - Unified structure should allow to combine various types of data together
 * Efficiency - Optional compression and encryption on multiple levels should allow effective representation of binary data
 * Flexibility - General framework should provide data transformations/processing and compatibility issues solving capability
 * Comprehensibility - Catalog of data types, metadata, relations and abstraction should allow better understanding of data

Homepage: https://xbup.exbin.org  

This repository contains Java implementation of the protocol and support tools and sample files.

Structure
---------

As the project is currently in alpha stage, repository contains complete resources for distribution package with following folders:

 * doc - Documentation + related presentations
 * gradle - Gradle wrapper
 * src - Sources related to building distribution packages
 * modules - Libraries and other
 * plugins - Catalog plugins
 * resources - Related resource files, like sample files, images, etc.
 * tools - Distributable subprojects encapsulating modules to runnable applications

Compiling
---------

Java Development Kit (JDK) version 8 or later is required to build this project.

For project compiling Gradle 6.0 build system is used. You can either download and install gradle and run "gradle build" command in project folder or gradlew or gradlew.bat scripts to download separate copy of gradle to perform the project build.

Build system website: https://gradle.org

License
-------

Project uses various libraries with specific licenses and some tools are licensed with multiple licenses with exceptions for specific modules to cover license requirements for used libraries.

Primary license: Apache License, Version 2.0 - see LICENSE.txt
