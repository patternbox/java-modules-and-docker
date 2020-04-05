
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
>   java.base@11.0.2
>   java.logging@11.0.2
>   patternbox.javamodules.app
>   patternbox.javamodules.util
```

```bash
# Run application
$ jlink-out/bin/java --module patternbox.javamodules.app/com.patternbox.javamodules.app.EnvVarsApplication
...
JAVA_11_HOME=/Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home
JAVA_8_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home
JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home
JAVA_MAIN_CLASS_33280=com.patternbox.javamodules.app.EnvVarsApplication
...
```