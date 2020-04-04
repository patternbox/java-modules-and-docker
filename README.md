
# Project using Java Modules, JLink and Docker

```bash
$ jdeps --list-deps ./env-vars-util/target/env-vars-util-1.0-SNAPSHOT.jar
>   java.base
>   java.logging
```

```bash
$ jdeps --module-path ./env-vars-util/target/env-vars-util-1.0-SNAPSHOT.jar \
   --list-deps ./env-vars-app/target/env-vars-app-1.0-SNAPSHOT.jar
>   java.base
>   patternbox.javamodules.util
```

```bash
$ $JAVA_HOME/bin/jlink --no-header-files --no-man-pages --compress=2 --strip-debug \
   --module-path ./env-vars-util/target/env-vars-util-1.0-SNAPSHOT.jar:./env-vars-app/target/env-vars-app-1.0-SNAPSHOT.jar \
   --add-modules java.base,java.logging,patternbox.javamodules.util,patternbox.javamodules.app \
   --output jlink-out
```

```bash
# List Java modules
$ jlink-out/bin/java --list-modules
# Run application
$ jlink-out/bin/java --module patternbox.javamodules.app/com.patternbox.javamodules.app.EnvVarsApplication
```