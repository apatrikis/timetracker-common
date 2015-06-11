# Time Tracker
Time Tracker is a self educational application for timesheet tracking. The application mainly has three parts:
- a JEE7 REST server, connecting to a database for storing users, projects and timesheets, as well as an WebSocket interface to notify registered clients about status changes.
- a common library with interfaces, entities and exceptions.
- a AngularJS web client that is consuming the servers's REST API and registers for status changes.

# Time Tracker Common
## Main desicions
This project contains classes, exceptins, entities, etc. which are shared among all other project.
In this sense, the project represents a common base libray for developing the main `timetracker-server` as well as extensios like `timetracker-websocket-impl`.

## Used software and versions
- IDE : Oracle NetBeans 8.0.2 (https://netbeans.org/downloads/, choose the `Java EE` edition)

The IDE is allready installed for the development of `Timetracker Server`.

For the following descriptions the base installation directory `\time-tracker` is assumed.

## Development
The directory structure described below is like this:
```
\time-tracker
   \timetracker-common
```

### Requirements
1. Download the `timetracker-common` project from https://github.com/apatrikis/timetracker-common

In case NetBeans IDE is not already installed refer to `timetracker-server`.


### Initial configuration
This is covered by `timetracker-server`, no special setup is required.

## Test
Test do not apply for an `API` project as per definition there are no implementations (business, technical, etc.).
These are located in the main `timetracker-server` project.

## Build (CI)
For `CI` the `Maven POM` is to be used within `Jenkins`.
For more information see the `timetracker-server` project.

## Run
The packaging type of this project is `JAR`.
Project like `timetracker-server` that depend on this project require to define this dependency in the `pom.xml` file.

```
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>timetracker-common</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```
