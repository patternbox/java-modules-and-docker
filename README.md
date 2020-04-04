
# Project using Java Modules and Docker

```bash
$ jdeps --list-deps ./env-vars-helper/target/java-modules-env-vars-helper-1.0-SNAPSHOT.jar 
>   java.base
```

```bash
$ jdeps --module-path ./env-vars-helper/target/java-modules-env-vars-helper-1.0-SNAPSHOT.jar \
   --list-deps ./env-vars-appl/target/java-modules-env-vars-appl-1.0-SNAPSHOT.jar
>   java.base
>   patternbox.javamodules.helpers
```

```bash
$ $JAVA_HOME/bin/jlink --no-header-files --no-man-pages --compress=2 --strip-debug \
   --module-path ./env-vars-helper/target/java-modules-env-vars-helper-1.0-SNAPSHOT.jar:./env-vars-appl/target/java-modules-env-vars-appl-1.0-SNAPSHOT.jar \
   --add-modules java.base,patternbox.javamodules.helpers,patternbox.javamodules.appl \
   --output jlink-out
```


jlink-out/bin/java --list-modules

$ jlink-out/bin/java --module patternbox.javamodules.appl/com.patternbox.javamodules.appl.EnvVarsAppl