% ./gradlew -q dependencies

------------------------------------------------------------
Root project 'match'
------------------------------------------------------------

annotationProcessor - Annotation processors and their dependencies for source set 'main'.
\--- org.projectlombok:lombok -> 1.18.30

bootArchives - Configuration for Spring Boot archive artifacts. (n)
No dependencies

compileClasspath - Compile classpath for source set 'main'.
+--- org.projectlombok:lombok -> 1.18.30
+--- org.springframework.boot:spring-boot-starter -> 3.2.3
|    +--- org.springframework.boot:spring-boot:3.2.3
|    |    +--- org.springframework:spring-core:6.1.4
|    |    |    \--- org.springframework:spring-jcl:6.1.4
|    |    \--- org.springframework:spring-context:6.1.4
|    |         +--- org.springframework:spring-aop:6.1.4
|    |         |    +--- org.springframework:spring-beans:6.1.4
|    |         |    |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-expression:6.1.4
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- io.micrometer:micrometer-observation:1.12.3
|    |              \--- io.micrometer:micrometer-commons:1.12.3
|    +--- org.springframework.boot:spring-boot-autoconfigure:3.2.3
|    |    \--- org.springframework.boot:spring-boot:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-logging:3.2.3
|    |    +--- ch.qos.logback:logback-classic:1.4.14
|    |    |    +--- ch.qos.logback:logback-core:1.4.14
|    |    |    \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.12
|    |    +--- org.apache.logging.log4j:log4j-to-slf4j:2.21.1
|    |    |    +--- org.apache.logging.log4j:log4j-api:2.21.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    \--- org.slf4j:jul-to-slf4j:2.0.12
|    |         \--- org.slf4j:slf4j-api:2.0.12
|    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    +--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.yaml:snakeyaml:2.2
+--- org.springframework.boot:spring-boot-starter-data-jpa -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-aop:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    \--- org.aspectj:aspectjweaver:1.9.21
|    +--- org.springframework.boot:spring-boot-starter-jdbc:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- com.zaxxer:HikariCP:5.0.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.30 -> 2.0.12
|    |    \--- org.springframework:spring-jdbc:6.1.4
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- org.springframework:spring-tx:6.1.4
|    |              +--- org.springframework:spring-beans:6.1.4 (*)
|    |              \--- org.springframework:spring-core:6.1.4 (*)
|    +--- org.hibernate.orm:hibernate-core:6.4.4.Final
|    |    +--- jakarta.persistence:jakarta.persistence-api:3.1.0
|    |    \--- jakarta.transaction:jakarta.transaction-api:2.0.1
|    +--- org.springframework.data:spring-data-jpa:3.2.3
|    |    +--- org.springframework.data:spring-data-commons:3.2.3
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-orm:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-jdbc:6.1.4 (*)
|    |    |    \--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-context:6.1.4 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    +--- org.antlr:antlr4-runtime:4.13.0
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.0.0 -> 2.1.1
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.springframework:spring-aspects:6.1.4
|         \--- org.aspectj:aspectjweaver:1.9.21
+--- org.springframework.boot:spring-boot-starter-web -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-json:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-web:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    \--- io.micrometer:micrometer-observation:1.12.3 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4 (c)
|    |    |    |         \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4 (c)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4
|    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |         \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    +--- org.springframework.boot:spring-boot-starter-tomcat:3.2.3
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    |    +--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    |    +--- org.apache.tomcat.embed:tomcat-embed-el:10.1.19
|    |    \--- org.apache.tomcat.embed:tomcat-embed-websocket:10.1.19
|    |         \--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    +--- org.springframework:spring-web:6.1.4 (*)
|    \--- org.springframework:spring-webmvc:6.1.4
|         +--- org.springframework:spring-aop:6.1.4 (*)
|         +--- org.springframework:spring-beans:6.1.4 (*)
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         +--- org.springframework:spring-expression:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.boot:spring-boot-starter-websocket -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-web:3.2.3 (*)
|    +--- org.springframework:spring-messaging:6.1.4
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    \--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.springframework:spring-websocket:6.1.4
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.data:spring-data-rest-hal-explorer -> 4.2.3
|    +--- org.springframework.data:spring-data-rest-webmvc:4.2.3
|    |    +--- org.springframework.data:spring-data-rest-core:4.2.3
|    |    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    |    +--- org.springframework.hateoas:spring-hateoas:2.2.0
|    |    |    |    +--- org.springframework:spring-aop:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-beans:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-context:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-core:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-web:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0
|    |    |    |    |    +--- org.springframework:spring-beans:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-context:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-aop:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.3 -> 2.0.12
|    |    |    |    +--- com.jayway.jsonpath:json-path:2.8.0 -> 2.9.0
|    |    |    |    \--- org.slf4j:slf4j-api:2.0.9 -> 2.0.12
|    |    |    +--- org.springframework.data:spring-data-commons:3.2.3 (*)
|    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0 (*)
|    |    |    +--- org.atteo:evo-inflector:1.3
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.3 -> 2.15.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-webmvc:6.1.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.3 -> 2.15.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
+--- com.btse.match:general:2.5.slim-SNAPSHOT
|    \--- com.btse.match:client_commons:2.5.slim-SNAPSHOT
|         +--- io.fastjson:boon:0.34
|         +--- org.xson:xson:1.0.2.1
|         +--- com.esotericsoftware:kryonet:5.5
|         +--- commons-io:commons-io:2.5
|         +--- com.lmax:disruptor:3.4.2
|         +--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1
|         |    \--- org.apache.logging.log4j:log4j-api:2.21.1
|         \--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
+--- com.btse.match:client:2.5.slim-SNAPSHOT
|    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    +--- com.btse.match:rateservice:2.5.slim-SNAPSHOT
|    |    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    |    +--- redis.clients:jedis:2.9.0 -> 5.0.2
|    |    |    +--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    |    +--- org.apache.commons:commons-pool2:2.11.1 -> 2.12.0
|    |    |    +--- org.json:json:20231013
|    |    |    \--- com.google.code.gson:gson:2.10.1
|    |    +--- com.alibaba:fastjson:1.2.54
|    |    +--- commons-codec:commons-codec:1.9 -> 1.16.1
|    |    +--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
|    |    +--- org.apache.commons:commons-pool2:2.6.0 -> 2.12.0
|    |    \--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1 (*)
|    \--- com.btse.match:general:2.5.slim-SNAPSHOT (*)
\--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)

compileOnly - Compile-only dependencies for the 'main' feature. (n)
\--- org.projectlombok:lombok (n)

default - Configuration for default artifacts. (n)
No dependencies

developmentOnly - Configuration for development-only dependencies such as Spring Boot's DevTools.
\--- org.springframework.boot:spring-boot-devtools -> 3.2.3
     +--- org.springframework.boot:spring-boot:3.2.3
     |    +--- org.springframework:spring-core:6.1.4
     |    |    \--- org.springframework:spring-jcl:6.1.4
     |    \--- org.springframework:spring-context:6.1.4
     |         +--- org.springframework:spring-aop:6.1.4
     |         |    +--- org.springframework:spring-beans:6.1.4
     |         |    |    \--- org.springframework:spring-core:6.1.4 (*)
     |         |    \--- org.springframework:spring-core:6.1.4 (*)
     |         +--- org.springframework:spring-beans:6.1.4 (*)
     |         +--- org.springframework:spring-core:6.1.4 (*)
     |         +--- org.springframework:spring-expression:6.1.4
     |         |    \--- org.springframework:spring-core:6.1.4 (*)
     |         \--- io.micrometer:micrometer-observation:1.12.3
     |              \--- io.micrometer:micrometer-commons:1.12.3
     \--- org.springframework.boot:spring-boot-autoconfigure:3.2.3
          \--- org.springframework.boot:spring-boot:3.2.3 (*)

implementation - Implementation dependencies for the 'main' feature. (n)
+--- org.springframework.boot:spring-boot-starter (n)
+--- org.springframework.boot:spring-boot-starter-data-jpa (n)
+--- org.springframework.boot:spring-boot-starter-web (n)
+--- org.springframework.boot:spring-boot-starter-websocket (n)
+--- org.springframework.data:spring-data-rest-hal-explorer (n)
+--- com.btse.match:general:2.5.slim-SNAPSHOT (n)
+--- com.btse.match:client:2.5.slim-SNAPSHOT (n)
\--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (n)

mainSourceElements - List of source directories contained in the Main SourceSet. (n)
No dependencies

productionRuntimeClasspath
+--- org.springframework.boot:spring-boot-starter -> 3.2.3
|    +--- org.springframework.boot:spring-boot:3.2.3
|    |    +--- org.springframework:spring-core:6.1.4
|    |    |    \--- org.springframework:spring-jcl:6.1.4
|    |    \--- org.springframework:spring-context:6.1.4
|    |         +--- org.springframework:spring-aop:6.1.4
|    |         |    +--- org.springframework:spring-beans:6.1.4
|    |         |    |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-expression:6.1.4
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- io.micrometer:micrometer-observation:1.12.3
|    |              \--- io.micrometer:micrometer-commons:1.12.3
|    +--- org.springframework.boot:spring-boot-autoconfigure:3.2.3
|    |    \--- org.springframework.boot:spring-boot:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-logging:3.2.3
|    |    +--- ch.qos.logback:logback-classic:1.4.14
|    |    |    +--- ch.qos.logback:logback-core:1.4.14
|    |    |    \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.12
|    |    +--- org.apache.logging.log4j:log4j-to-slf4j:2.21.1
|    |    |    +--- org.apache.logging.log4j:log4j-api:2.21.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    \--- org.slf4j:jul-to-slf4j:2.0.12
|    |         \--- org.slf4j:slf4j-api:2.0.12
|    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    +--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.yaml:snakeyaml:2.2
+--- org.springframework.boot:spring-boot-starter-data-jpa -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-aop:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    \--- org.aspectj:aspectjweaver:1.9.21
|    +--- org.springframework.boot:spring-boot-starter-jdbc:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- com.zaxxer:HikariCP:5.0.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.30 -> 2.0.12
|    |    \--- org.springframework:spring-jdbc:6.1.4
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- org.springframework:spring-tx:6.1.4
|    |              +--- org.springframework:spring-beans:6.1.4 (*)
|    |              \--- org.springframework:spring-core:6.1.4 (*)
|    +--- org.hibernate.orm:hibernate-core:6.4.4.Final
|    |    +--- jakarta.persistence:jakarta.persistence-api:3.1.0
|    |    +--- jakarta.transaction:jakarta.transaction-api:2.0.1
|    |    +--- org.jboss.logging:jboss-logging:3.5.0.Final -> 3.5.3.Final
|    |    +--- org.hibernate.common:hibernate-commons-annotations:6.0.6.Final
|    |    +--- io.smallrye:jandex:3.1.2
|    |    +--- com.fasterxml:classmate:1.5.1 -> 1.6.0
|    |    +--- net.bytebuddy:byte-buddy:1.14.11 -> 1.14.12
|    |    +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.0 -> 4.0.1
|    |    |    \--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    +--- org.glassfish.jaxb:jaxb-runtime:4.0.2 -> 4.0.4
|    |    |    \--- org.glassfish.jaxb:jaxb-core:4.0.4
|    |    |         +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.1 (*)
|    |    |         +--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    |         +--- org.eclipse.angus:angus-activation:2.0.1
|    |    |         |    \--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    |         +--- org.glassfish.jaxb:txw2:4.0.4
|    |    |         \--- com.sun.istack:istack-commons-runtime:4.1.2
|    |    +--- jakarta.inject:jakarta.inject-api:2.0.1
|    |    \--- org.antlr:antlr4-runtime:4.13.0
|    +--- org.springframework.data:spring-data-jpa:3.2.3
|    |    +--- org.springframework.data:spring-data-commons:3.2.3
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-orm:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-jdbc:6.1.4 (*)
|    |    |    \--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-context:6.1.4 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    +--- org.antlr:antlr4-runtime:4.13.0
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.0.0 -> 2.1.1
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.springframework:spring-aspects:6.1.4
|         \--- org.aspectj:aspectjweaver:1.9.21
+--- org.springframework.boot:spring-boot-starter-web -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-json:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-web:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    \--- io.micrometer:micrometer-observation:1.12.3 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4 (c)
|    |    |    |         \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4 (c)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4
|    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |         \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    +--- org.springframework.boot:spring-boot-starter-tomcat:3.2.3
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    |    +--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    |    +--- org.apache.tomcat.embed:tomcat-embed-el:10.1.19
|    |    \--- org.apache.tomcat.embed:tomcat-embed-websocket:10.1.19
|    |         \--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    +--- org.springframework:spring-web:6.1.4 (*)
|    \--- org.springframework:spring-webmvc:6.1.4
|         +--- org.springframework:spring-aop:6.1.4 (*)
|         +--- org.springframework:spring-beans:6.1.4 (*)
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         +--- org.springframework:spring-expression:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.boot:spring-boot-starter-websocket -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-web:3.2.3 (*)
|    +--- org.springframework:spring-messaging:6.1.4
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    \--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.springframework:spring-websocket:6.1.4
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.data:spring-data-rest-hal-explorer -> 4.2.3
|    +--- org.springframework.data:spring-data-rest-webmvc:4.2.3
|    |    +--- org.springframework.data:spring-data-rest-core:4.2.3
|    |    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    |    +--- org.springframework.hateoas:spring-hateoas:2.2.0
|    |    |    |    +--- org.springframework:spring-aop:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-beans:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-context:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-core:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-web:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0
|    |    |    |    |    +--- org.springframework:spring-beans:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-context:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-aop:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.3 -> 2.0.12
|    |    |    |    +--- com.jayway.jsonpath:json-path:2.8.0 -> 2.9.0
|    |    |    |    |    +--- net.minidev:json-smart:2.5.0
|    |    |    |    |    |    \--- net.minidev:accessors-smart:2.5.0
|    |    |    |    |    |         \--- org.ow2.asm:asm:9.3
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.11 -> 2.0.12
|    |    |    |    \--- org.slf4j:slf4j-api:2.0.9 -> 2.0.12
|    |    |    +--- org.springframework.data:spring-data-commons:3.2.3 (*)
|    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0 (*)
|    |    |    +--- org.atteo:evo-inflector:1.3
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.3 -> 2.15.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-webmvc:6.1.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.3 -> 2.15.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
+--- com.btse.match:general:2.5.slim-SNAPSHOT
|    \--- com.btse.match:client_commons:2.5.slim-SNAPSHOT
|         +--- io.fastjson:boon:0.34
|         +--- org.xson:xson:1.0.2.1
|         +--- com.esotericsoftware:kryonet:5.5
|         +--- commons-io:commons-io:2.5
|         +--- com.lmax:disruptor:3.4.2
|         +--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1
|         |    \--- org.apache.logging.log4j:log4j-api:2.21.1
|         \--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
+--- com.btse.match:client:2.5.slim-SNAPSHOT
|    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    +--- com.btse.match:rateservice:2.5.slim-SNAPSHOT
|    |    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    |    +--- redis.clients:jedis:2.9.0 -> 5.0.2
|    |    |    +--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    |    +--- org.apache.commons:commons-pool2:2.11.1 -> 2.12.0
|    |    |    +--- org.json:json:20231013
|    |    |    \--- com.google.code.gson:gson:2.10.1
|    |    +--- com.alibaba:fastjson:1.2.54
|    |    +--- commons-codec:commons-codec:1.9 -> 1.16.1
|    |    +--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
|    |    +--- org.apache.commons:commons-pool2:2.6.0 -> 2.12.0
|    |    \--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1 (*)
|    \--- com.btse.match:general:2.5.slim-SNAPSHOT (*)
+--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
\--- com.h2database:h2 -> 2.2.224

runtimeClasspath - Runtime classpath of source set 'main'.
+--- org.springframework.boot:spring-boot-devtools -> 3.2.3
|    +--- org.springframework.boot:spring-boot:3.2.3
|    |    +--- org.springframework:spring-core:6.1.4
|    |    |    \--- org.springframework:spring-jcl:6.1.4
|    |    \--- org.springframework:spring-context:6.1.4
|    |         +--- org.springframework:spring-aop:6.1.4
|    |         |    +--- org.springframework:spring-beans:6.1.4
|    |         |    |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-expression:6.1.4
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- io.micrometer:micrometer-observation:1.12.3
|    |              \--- io.micrometer:micrometer-commons:1.12.3
|    \--- org.springframework.boot:spring-boot-autoconfigure:3.2.3
|         \--- org.springframework.boot:spring-boot:3.2.3 (*)
+--- org.springframework.boot:spring-boot-starter -> 3.2.3
|    +--- org.springframework.boot:spring-boot:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-autoconfigure:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-logging:3.2.3
|    |    +--- ch.qos.logback:logback-classic:1.4.14
|    |    |    +--- ch.qos.logback:logback-core:1.4.14
|    |    |    \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.12
|    |    +--- org.apache.logging.log4j:log4j-to-slf4j:2.21.1
|    |    |    +--- org.apache.logging.log4j:log4j-api:2.21.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    \--- org.slf4j:jul-to-slf4j:2.0.12
|    |         \--- org.slf4j:slf4j-api:2.0.12
|    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    +--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.yaml:snakeyaml:2.2
+--- org.springframework.boot:spring-boot-starter-data-jpa -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-aop:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    \--- org.aspectj:aspectjweaver:1.9.21
|    +--- org.springframework.boot:spring-boot-starter-jdbc:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- com.zaxxer:HikariCP:5.0.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.30 -> 2.0.12
|    |    \--- org.springframework:spring-jdbc:6.1.4
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- org.springframework:spring-tx:6.1.4
|    |              +--- org.springframework:spring-beans:6.1.4 (*)
|    |              \--- org.springframework:spring-core:6.1.4 (*)
|    +--- org.hibernate.orm:hibernate-core:6.4.4.Final
|    |    +--- jakarta.persistence:jakarta.persistence-api:3.1.0
|    |    +--- jakarta.transaction:jakarta.transaction-api:2.0.1
|    |    +--- org.jboss.logging:jboss-logging:3.5.0.Final -> 3.5.3.Final
|    |    +--- org.hibernate.common:hibernate-commons-annotations:6.0.6.Final
|    |    +--- io.smallrye:jandex:3.1.2
|    |    +--- com.fasterxml:classmate:1.5.1 -> 1.6.0
|    |    +--- net.bytebuddy:byte-buddy:1.14.11 -> 1.14.12
|    |    +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.0 -> 4.0.1
|    |    |    \--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    +--- org.glassfish.jaxb:jaxb-runtime:4.0.2 -> 4.0.4
|    |    |    \--- org.glassfish.jaxb:jaxb-core:4.0.4
|    |    |         +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.1 (*)
|    |    |         +--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    |         +--- org.eclipse.angus:angus-activation:2.0.1
|    |    |         |    \--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    |         +--- org.glassfish.jaxb:txw2:4.0.4
|    |    |         \--- com.sun.istack:istack-commons-runtime:4.1.2
|    |    +--- jakarta.inject:jakarta.inject-api:2.0.1
|    |    \--- org.antlr:antlr4-runtime:4.13.0
|    +--- org.springframework.data:spring-data-jpa:3.2.3
|    |    +--- org.springframework.data:spring-data-commons:3.2.3
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-orm:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-jdbc:6.1.4 (*)
|    |    |    \--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-context:6.1.4 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    +--- org.antlr:antlr4-runtime:4.13.0
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.0.0 -> 2.1.1
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.springframework:spring-aspects:6.1.4
|         \--- org.aspectj:aspectjweaver:1.9.21
+--- org.springframework.boot:spring-boot-starter-web -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-json:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-web:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    \--- io.micrometer:micrometer-observation:1.12.3 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4 (c)
|    |    |    |         \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4 (c)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4
|    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |         \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    +--- org.springframework.boot:spring-boot-starter-tomcat:3.2.3
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    |    +--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    |    +--- org.apache.tomcat.embed:tomcat-embed-el:10.1.19
|    |    \--- org.apache.tomcat.embed:tomcat-embed-websocket:10.1.19
|    |         \--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    +--- org.springframework:spring-web:6.1.4 (*)
|    \--- org.springframework:spring-webmvc:6.1.4
|         +--- org.springframework:spring-aop:6.1.4 (*)
|         +--- org.springframework:spring-beans:6.1.4 (*)
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         +--- org.springframework:spring-expression:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.boot:spring-boot-starter-websocket -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-web:3.2.3 (*)
|    +--- org.springframework:spring-messaging:6.1.4
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    \--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.springframework:spring-websocket:6.1.4
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.data:spring-data-rest-hal-explorer -> 4.2.3
|    +--- org.springframework.data:spring-data-rest-webmvc:4.2.3
|    |    +--- org.springframework.data:spring-data-rest-core:4.2.3
|    |    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    |    +--- org.springframework.hateoas:spring-hateoas:2.2.0
|    |    |    |    +--- org.springframework:spring-aop:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-beans:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-context:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-core:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-web:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0
|    |    |    |    |    +--- org.springframework:spring-beans:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-context:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-aop:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.3 -> 2.0.12
|    |    |    |    +--- com.jayway.jsonpath:json-path:2.8.0 -> 2.9.0
|    |    |    |    |    +--- net.minidev:json-smart:2.5.0
|    |    |    |    |    |    \--- net.minidev:accessors-smart:2.5.0
|    |    |    |    |    |         \--- org.ow2.asm:asm:9.3
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.11 -> 2.0.12
|    |    |    |    \--- org.slf4j:slf4j-api:2.0.9 -> 2.0.12
|    |    |    +--- org.springframework.data:spring-data-commons:3.2.3 (*)
|    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0 (*)
|    |    |    +--- org.atteo:evo-inflector:1.3
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.3 -> 2.15.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-webmvc:6.1.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.3 -> 2.15.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
+--- com.btse.match:general:2.5.slim-SNAPSHOT
|    \--- com.btse.match:client_commons:2.5.slim-SNAPSHOT
|         +--- io.fastjson:boon:0.34
|         +--- org.xson:xson:1.0.2.1
|         +--- com.esotericsoftware:kryonet:5.5
|         +--- commons-io:commons-io:2.5
|         +--- com.lmax:disruptor:3.4.2
|         +--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1
|         |    \--- org.apache.logging.log4j:log4j-api:2.21.1
|         \--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
+--- com.btse.match:client:2.5.slim-SNAPSHOT
|    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    +--- com.btse.match:rateservice:2.5.slim-SNAPSHOT
|    |    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    |    +--- redis.clients:jedis:2.9.0 -> 5.0.2
|    |    |    +--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    |    +--- org.apache.commons:commons-pool2:2.11.1 -> 2.12.0
|    |    |    +--- org.json:json:20231013
|    |    |    \--- com.google.code.gson:gson:2.10.1
|    |    +--- com.alibaba:fastjson:1.2.54
|    |    +--- commons-codec:commons-codec:1.9 -> 1.16.1
|    |    +--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
|    |    +--- org.apache.commons:commons-pool2:2.6.0 -> 2.12.0
|    |    \--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1 (*)
|    \--- com.btse.match:general:2.5.slim-SNAPSHOT (*)
+--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
\--- com.h2database:h2 -> 2.2.224

runtimeElements - Runtime elements for the 'main' feature. (n)
No dependencies

runtimeOnly - Runtime-only dependencies for the 'main' feature. (n)
\--- com.h2database:h2 (n)

testAndDevelopmentOnly - Configuration for test and development-only dependencies such as Spring Boot's DevTools.
No dependencies

testAnnotationProcessor - Annotation processors and their dependencies for source set 'test'.
No dependencies

testCompileClasspath - Compile classpath for source set 'test'.
+--- org.springframework.boot:spring-boot-starter -> 3.2.3
|    +--- org.springframework.boot:spring-boot:3.2.3
|    |    +--- org.springframework:spring-core:6.1.4
|    |    |    \--- org.springframework:spring-jcl:6.1.4
|    |    \--- org.springframework:spring-context:6.1.4
|    |         +--- org.springframework:spring-aop:6.1.4
|    |         |    +--- org.springframework:spring-beans:6.1.4
|    |         |    |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-expression:6.1.4
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- io.micrometer:micrometer-observation:1.12.3
|    |              \--- io.micrometer:micrometer-commons:1.12.3
|    +--- org.springframework.boot:spring-boot-autoconfigure:3.2.3
|    |    \--- org.springframework.boot:spring-boot:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-logging:3.2.3
|    |    +--- ch.qos.logback:logback-classic:1.4.14
|    |    |    +--- ch.qos.logback:logback-core:1.4.14
|    |    |    \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.12
|    |    +--- org.apache.logging.log4j:log4j-to-slf4j:2.21.1
|    |    |    +--- org.apache.logging.log4j:log4j-api:2.21.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    \--- org.slf4j:jul-to-slf4j:2.0.12
|    |         \--- org.slf4j:slf4j-api:2.0.12
|    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    +--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.yaml:snakeyaml:2.2
+--- org.springframework.boot:spring-boot-starter-data-jpa -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-aop:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    \--- org.aspectj:aspectjweaver:1.9.21
|    +--- org.springframework.boot:spring-boot-starter-jdbc:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- com.zaxxer:HikariCP:5.0.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.30 -> 2.0.12
|    |    \--- org.springframework:spring-jdbc:6.1.4
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- org.springframework:spring-tx:6.1.4
|    |              +--- org.springframework:spring-beans:6.1.4 (*)
|    |              \--- org.springframework:spring-core:6.1.4 (*)
|    +--- org.hibernate.orm:hibernate-core:6.4.4.Final
|    |    +--- jakarta.persistence:jakarta.persistence-api:3.1.0
|    |    \--- jakarta.transaction:jakarta.transaction-api:2.0.1
|    +--- org.springframework.data:spring-data-jpa:3.2.3
|    |    +--- org.springframework.data:spring-data-commons:3.2.3
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-orm:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-jdbc:6.1.4 (*)
|    |    |    \--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-context:6.1.4 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    +--- org.antlr:antlr4-runtime:4.13.0
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.0.0 -> 2.1.1
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.springframework:spring-aspects:6.1.4
|         \--- org.aspectj:aspectjweaver:1.9.21
+--- org.springframework.boot:spring-boot-starter-web -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-json:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-web:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    \--- io.micrometer:micrometer-observation:1.12.3 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4 (c)
|    |    |    |         \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4 (c)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4
|    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |         \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    +--- org.springframework.boot:spring-boot-starter-tomcat:3.2.3
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    |    +--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    |    +--- org.apache.tomcat.embed:tomcat-embed-el:10.1.19
|    |    \--- org.apache.tomcat.embed:tomcat-embed-websocket:10.1.19
|    |         \--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    +--- org.springframework:spring-web:6.1.4 (*)
|    \--- org.springframework:spring-webmvc:6.1.4
|         +--- org.springframework:spring-aop:6.1.4 (*)
|         +--- org.springframework:spring-beans:6.1.4 (*)
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         +--- org.springframework:spring-expression:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.boot:spring-boot-starter-websocket -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-web:3.2.3 (*)
|    +--- org.springframework:spring-messaging:6.1.4
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    \--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.springframework:spring-websocket:6.1.4
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.data:spring-data-rest-hal-explorer -> 4.2.3
|    +--- org.springframework.data:spring-data-rest-webmvc:4.2.3
|    |    +--- org.springframework.data:spring-data-rest-core:4.2.3
|    |    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    |    +--- org.springframework.hateoas:spring-hateoas:2.2.0
|    |    |    |    +--- org.springframework:spring-aop:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-beans:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-context:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-core:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-web:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0
|    |    |    |    |    +--- org.springframework:spring-beans:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-context:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-aop:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.3 -> 2.0.12
|    |    |    |    +--- com.jayway.jsonpath:json-path:2.8.0 -> 2.9.0
|    |    |    |    \--- org.slf4j:slf4j-api:2.0.9 -> 2.0.12
|    |    |    +--- org.springframework.data:spring-data-commons:3.2.3 (*)
|    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0 (*)
|    |    |    +--- org.atteo:evo-inflector:1.3
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.3 -> 2.15.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-webmvc:6.1.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.3 -> 2.15.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
+--- com.btse.match:general:2.5.slim-SNAPSHOT
|    \--- com.btse.match:client_commons:2.5.slim-SNAPSHOT
|         +--- io.fastjson:boon:0.34
|         +--- org.xson:xson:1.0.2.1
|         +--- com.esotericsoftware:kryonet:5.5
|         +--- commons-io:commons-io:2.5
|         +--- com.lmax:disruptor:3.4.2
|         +--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1
|         |    \--- org.apache.logging.log4j:log4j-api:2.21.1
|         \--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
+--- com.btse.match:client:2.5.slim-SNAPSHOT
|    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    +--- com.btse.match:rateservice:2.5.slim-SNAPSHOT
|    |    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    |    +--- redis.clients:jedis:2.9.0 -> 5.0.2
|    |    |    +--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    |    +--- org.apache.commons:commons-pool2:2.11.1 -> 2.12.0
|    |    |    +--- org.json:json:20231013
|    |    |    \--- com.google.code.gson:gson:2.10.1
|    |    +--- com.alibaba:fastjson:1.2.54
|    |    +--- commons-codec:commons-codec:1.9 -> 1.16.1
|    |    +--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
|    |    +--- org.apache.commons:commons-pool2:2.6.0 -> 2.12.0
|    |    \--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1 (*)
|    \--- com.btse.match:general:2.5.slim-SNAPSHOT (*)
+--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
+--- org.springframework.boot:spring-boot-starter-test -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-test:3.2.3
|    |    \--- org.springframework.boot:spring-boot:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-test-autoconfigure:3.2.3
|    |    +--- org.springframework.boot:spring-boot:3.2.3 (*)
|    |    +--- org.springframework.boot:spring-boot-test:3.2.3 (*)
|    |    \--- org.springframework.boot:spring-boot-autoconfigure:3.2.3 (*)
|    +--- com.jayway.jsonpath:json-path:2.9.0
|    +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.1
|    |    \--- jakarta.activation:jakarta.activation-api:2.1.2
|    +--- net.minidev:json-smart:2.5.0
|    |    \--- net.minidev:accessors-smart:2.5.0
|    |         \--- org.ow2.asm:asm:9.3
|    +--- org.assertj:assertj-core:3.24.2
|    |    \--- net.bytebuddy:byte-buddy:1.12.21 -> 1.14.12
|    +--- org.awaitility:awaitility:4.2.0
|    |    \--- org.hamcrest:hamcrest:2.1 -> 2.2
|    +--- org.hamcrest:hamcrest:2.2
|    +--- org.junit.jupiter:junit-jupiter:5.10.2
|    |    +--- org.junit:junit-bom:5.10.2
|    |    |    +--- org.junit.jupiter:junit-jupiter:5.10.2 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-api:5.10.2 -> 5.8.1 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-params:5.10.2 (c)
|    |    |    \--- org.junit.platform:junit-platform-commons:1.10.2 (c)
|    |    +--- org.junit.jupiter:junit-jupiter-api:5.10.2 -> 5.8.1
|    |    |    +--- org.junit:junit-bom:5.8.1 -> 5.10.2 (*)
|    |    |    +--- org.opentest4j:opentest4j:1.2.0
|    |    |    +--- org.junit.platform:junit-platform-commons:1.8.1 -> 1.10.2
|    |    |    |    +--- org.junit:junit-bom:5.10.2 (*)
|    |    |    |    \--- org.apiguardian:apiguardian-api:1.1.2
|    |    |    \--- org.apiguardian:apiguardian-api:1.1.2
|    |    \--- org.junit.jupiter:junit-jupiter-params:5.10.2
|    |         +--- org.junit:junit-bom:5.10.2 (*)
|    |         +--- org.junit.jupiter:junit-jupiter-api:5.10.2 -> 5.8.1 (*)
|    |         \--- org.apiguardian:apiguardian-api:1.1.2
|    +--- org.mockito:mockito-core:5.7.0
|    |    +--- net.bytebuddy:byte-buddy:1.14.9 -> 1.14.12
|    |    \--- net.bytebuddy:byte-buddy-agent:1.14.9 -> 1.14.12
|    +--- org.mockito:mockito-junit-jupiter:5.7.0
|    |    \--- org.mockito:mockito-core:5.7.0 (*)
|    +--- org.skyscreamer:jsonassert:1.5.1
|    |    \--- com.vaadin.external.google:android-json:0.0.20131108.vaadin1
|    +--- org.springframework:spring-core:6.1.4 (*)
|    +--- org.springframework:spring-test:6.1.4
|    |    \--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.xmlunit:xmlunit-core:2.9.1
\--- org.junit.jupiter:junit-jupiter-api:5.8.1 (*)

testCompileOnly - Compile only dependencies for source set 'test'. (n)
No dependencies

testImplementation - Implementation only dependencies for source set 'test'. (n)
+--- org.springframework.boot:spring-boot-starter-test (n)
\--- org.junit.jupiter:junit-jupiter-api:5.8.1 (n)

testRuntimeClasspath - Runtime classpath of source set 'test'.
+--- org.springframework.boot:spring-boot-starter -> 3.2.3
|    +--- org.springframework.boot:spring-boot:3.2.3
|    |    +--- org.springframework:spring-core:6.1.4
|    |    |    \--- org.springframework:spring-jcl:6.1.4
|    |    \--- org.springframework:spring-context:6.1.4
|    |         +--- org.springframework:spring-aop:6.1.4
|    |         |    +--- org.springframework:spring-beans:6.1.4
|    |         |    |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         +--- org.springframework:spring-expression:6.1.4
|    |         |    \--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- io.micrometer:micrometer-observation:1.12.3
|    |              \--- io.micrometer:micrometer-commons:1.12.3
|    +--- org.springframework.boot:spring-boot-autoconfigure:3.2.3
|    |    \--- org.springframework.boot:spring-boot:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-logging:3.2.3
|    |    +--- ch.qos.logback:logback-classic:1.4.14
|    |    |    +--- ch.qos.logback:logback-core:1.4.14
|    |    |    \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.12
|    |    +--- org.apache.logging.log4j:log4j-to-slf4j:2.21.1
|    |    |    +--- org.apache.logging.log4j:log4j-api:2.21.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    \--- org.slf4j:jul-to-slf4j:2.0.12
|    |         \--- org.slf4j:slf4j-api:2.0.12
|    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    +--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.yaml:snakeyaml:2.2
+--- org.springframework.boot:spring-boot-starter-data-jpa -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-aop:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    \--- org.aspectj:aspectjweaver:1.9.21
|    +--- org.springframework.boot:spring-boot-starter-jdbc:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- com.zaxxer:HikariCP:5.0.1
|    |    |    \--- org.slf4j:slf4j-api:1.7.30 -> 2.0.12
|    |    \--- org.springframework:spring-jdbc:6.1.4
|    |         +--- org.springframework:spring-beans:6.1.4 (*)
|    |         +--- org.springframework:spring-core:6.1.4 (*)
|    |         \--- org.springframework:spring-tx:6.1.4
|    |              +--- org.springframework:spring-beans:6.1.4 (*)
|    |              \--- org.springframework:spring-core:6.1.4 (*)
|    +--- org.hibernate.orm:hibernate-core:6.4.4.Final
|    |    +--- jakarta.persistence:jakarta.persistence-api:3.1.0
|    |    +--- jakarta.transaction:jakarta.transaction-api:2.0.1
|    |    +--- org.jboss.logging:jboss-logging:3.5.0.Final -> 3.5.3.Final
|    |    +--- org.hibernate.common:hibernate-commons-annotations:6.0.6.Final
|    |    +--- io.smallrye:jandex:3.1.2
|    |    +--- com.fasterxml:classmate:1.5.1 -> 1.6.0
|    |    +--- net.bytebuddy:byte-buddy:1.14.11 -> 1.14.12
|    |    +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.0 -> 4.0.1
|    |    |    \--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    +--- org.glassfish.jaxb:jaxb-runtime:4.0.2 -> 4.0.4
|    |    |    \--- org.glassfish.jaxb:jaxb-core:4.0.4
|    |    |         +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.1 (*)
|    |    |         +--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    |         +--- org.eclipse.angus:angus-activation:2.0.1
|    |    |         |    \--- jakarta.activation:jakarta.activation-api:2.1.2
|    |    |         +--- org.glassfish.jaxb:txw2:4.0.4
|    |    |         \--- com.sun.istack:istack-commons-runtime:4.1.2
|    |    +--- jakarta.inject:jakarta.inject-api:2.0.1
|    |    \--- org.antlr:antlr4-runtime:4.13.0
|    +--- org.springframework.data:spring-data-jpa:3.2.3
|    |    +--- org.springframework.data:spring-data-commons:3.2.3
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-orm:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    +--- org.springframework:spring-jdbc:6.1.4 (*)
|    |    |    \--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-context:6.1.4 (*)
|    |    +--- org.springframework:spring-aop:6.1.4 (*)
|    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    +--- org.antlr:antlr4-runtime:4.13.0
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.0.0 -> 2.1.1
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.springframework:spring-aspects:6.1.4
|         \--- org.aspectj:aspectjweaver:1.9.21
+--- org.springframework.boot:spring-boot-starter-web -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-starter-json:3.2.3
|    |    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    |    +--- org.springframework:spring-web:6.1.4
|    |    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    |    +--- org.springframework:spring-core:6.1.4 (*)
|    |    |    \--- io.micrometer:micrometer-observation:1.12.3 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4 (c)
|    |    |    |         \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4 (c)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.4
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    |    \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.4
|    |         +--- com.fasterxml.jackson.core:jackson-core:2.15.4 (*)
|    |         +--- com.fasterxml.jackson.core:jackson-databind:2.15.4 (*)
|    |         \--- com.fasterxml.jackson:jackson-bom:2.15.4 (*)
|    +--- org.springframework.boot:spring-boot-starter-tomcat:3.2.3
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    |    +--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    |    +--- org.apache.tomcat.embed:tomcat-embed-el:10.1.19
|    |    \--- org.apache.tomcat.embed:tomcat-embed-websocket:10.1.19
|    |         \--- org.apache.tomcat.embed:tomcat-embed-core:10.1.19
|    +--- org.springframework:spring-web:6.1.4 (*)
|    \--- org.springframework:spring-webmvc:6.1.4
|         +--- org.springframework:spring-aop:6.1.4 (*)
|         +--- org.springframework:spring-beans:6.1.4 (*)
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         +--- org.springframework:spring-expression:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.boot:spring-boot-starter-websocket -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter-web:3.2.3 (*)
|    +--- org.springframework:spring-messaging:6.1.4
|    |    +--- org.springframework:spring-beans:6.1.4 (*)
|    |    \--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.springframework:spring-websocket:6.1.4
|         +--- org.springframework:spring-context:6.1.4 (*)
|         +--- org.springframework:spring-core:6.1.4 (*)
|         \--- org.springframework:spring-web:6.1.4 (*)
+--- org.springframework.data:spring-data-rest-hal-explorer -> 4.2.3
|    +--- org.springframework.data:spring-data-rest-webmvc:4.2.3
|    |    +--- org.springframework.data:spring-data-rest-core:4.2.3
|    |    |    +--- org.springframework:spring-tx:6.1.4 (*)
|    |    |    +--- org.springframework.hateoas:spring-hateoas:2.2.0
|    |    |    |    +--- org.springframework:spring-aop:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-beans:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-context:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-core:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework:spring-web:6.1.0 -> 6.1.4 (*)
|    |    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0
|    |    |    |    |    +--- org.springframework:spring-beans:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-context:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    +--- org.springframework:spring-aop:6.0.0 -> 6.1.4 (*)
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.3 -> 2.0.12
|    |    |    |    +--- com.jayway.jsonpath:json-path:2.8.0 -> 2.9.0
|    |    |    |    |    +--- net.minidev:json-smart:2.5.0
|    |    |    |    |    |    \--- net.minidev:accessors-smart:2.5.0
|    |    |    |    |    |         \--- org.ow2.asm:asm:9.3
|    |    |    |    |    \--- org.slf4j:slf4j-api:2.0.11 -> 2.0.12
|    |    |    |    \--- org.slf4j:slf4j-api:2.0.9 -> 2.0.12
|    |    |    +--- org.springframework.data:spring-data-commons:3.2.3 (*)
|    |    |    +--- org.springframework.plugin:spring-plugin-core:3.0.0 (*)
|    |    |    +--- org.atteo:evo-inflector:1.3
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.3 -> 2.15.4 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    |    +--- org.springframework:spring-webmvc:6.1.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.15.3 -> 2.15.4 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.15.3 -> 2.15.4 (*)
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
|    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.12
+--- com.btse.match:general:2.5.slim-SNAPSHOT
|    \--- com.btse.match:client_commons:2.5.slim-SNAPSHOT
|         +--- io.fastjson:boon:0.34
|         +--- org.xson:xson:1.0.2.1
|         +--- com.esotericsoftware:kryonet:5.5
|         +--- commons-io:commons-io:2.5
|         +--- com.lmax:disruptor:3.4.2
|         +--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1
|         |    \--- org.apache.logging.log4j:log4j-api:2.21.1
|         \--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
+--- com.btse.match:client:2.5.slim-SNAPSHOT
|    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    +--- com.btse.match:rateservice:2.5.slim-SNAPSHOT
|    |    +--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
|    |    +--- redis.clients:jedis:2.9.0 -> 5.0.2
|    |    |    +--- org.slf4j:slf4j-api:1.7.36 -> 2.0.12
|    |    |    +--- org.apache.commons:commons-pool2:2.11.1 -> 2.12.0
|    |    |    +--- org.json:json:20231013
|    |    |    \--- com.google.code.gson:gson:2.10.1
|    |    +--- com.alibaba:fastjson:1.2.54
|    |    +--- commons-codec:commons-codec:1.9 -> 1.16.1
|    |    +--- org.apache.commons:commons-lang3:3.8.1 -> 3.13.0
|    |    +--- org.apache.commons:commons-pool2:2.6.0 -> 2.12.0
|    |    \--- org.apache.logging.log4j:log4j-core:2.16.0 -> 2.21.1 (*)
|    \--- com.btse.match:general:2.5.slim-SNAPSHOT (*)
+--- com.btse.match:client_commons:2.5.slim-SNAPSHOT (*)
+--- com.h2database:h2 -> 2.2.224
+--- org.springframework.boot:spring-boot-starter-test -> 3.2.3
|    +--- org.springframework.boot:spring-boot-starter:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-test:3.2.3
|    |    \--- org.springframework.boot:spring-boot:3.2.3 (*)
|    +--- org.springframework.boot:spring-boot-test-autoconfigure:3.2.3
|    |    +--- org.springframework.boot:spring-boot:3.2.3 (*)
|    |    +--- org.springframework.boot:spring-boot-test:3.2.3 (*)
|    |    \--- org.springframework.boot:spring-boot-autoconfigure:3.2.3 (*)
|    +--- com.jayway.jsonpath:json-path:2.9.0 (*)
|    +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.1 (*)
|    +--- net.minidev:json-smart:2.5.0 (*)
|    +--- org.assertj:assertj-core:3.24.2
|    |    \--- net.bytebuddy:byte-buddy:1.12.21 -> 1.14.12
|    +--- org.awaitility:awaitility:4.2.0
|    |    \--- org.hamcrest:hamcrest:2.1 -> 2.2
|    +--- org.hamcrest:hamcrest:2.2
|    +--- org.junit.jupiter:junit-jupiter:5.10.2
|    |    +--- org.junit:junit-bom:5.10.2
|    |    |    +--- org.junit.jupiter:junit-jupiter:5.10.2 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-api:5.10.2 -> 5.8.1 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-engine:5.10.2 -> 5.8.1 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-params:5.10.2 (c)
|    |    |    +--- org.junit.platform:junit-platform-commons:1.10.2 (c)
|    |    |    \--- org.junit.platform:junit-platform-engine:1.10.2 (c)
|    |    +--- org.junit.jupiter:junit-jupiter-api:5.10.2 -> 5.8.1
|    |    |    +--- org.junit:junit-bom:5.8.1 -> 5.10.2 (*)
|    |    |    +--- org.opentest4j:opentest4j:1.2.0 -> 1.3.0
|    |    |    \--- org.junit.platform:junit-platform-commons:1.8.1 -> 1.10.2
|    |    |         \--- org.junit:junit-bom:5.10.2 (*)
|    |    +--- org.junit.jupiter:junit-jupiter-params:5.10.2
|    |    |    +--- org.junit:junit-bom:5.10.2 (*)
|    |    |    \--- org.junit.jupiter:junit-jupiter-api:5.10.2 -> 5.8.1 (*)
|    |    \--- org.junit.jupiter:junit-jupiter-engine:5.10.2 -> 5.8.1
|    |         +--- org.junit:junit-bom:5.8.1 -> 5.10.2 (*)
|    |         +--- org.junit.platform:junit-platform-engine:1.8.1 -> 1.10.2
|    |         |    +--- org.junit:junit-bom:5.10.2 (*)
|    |         |    +--- org.opentest4j:opentest4j:1.3.0
|    |         |    \--- org.junit.platform:junit-platform-commons:1.10.2 (*)
|    |         \--- org.junit.jupiter:junit-jupiter-api:5.8.1 (*)
|    +--- org.mockito:mockito-core:5.7.0
|    |    +--- net.bytebuddy:byte-buddy:1.14.9 -> 1.14.12
|    |    +--- net.bytebuddy:byte-buddy-agent:1.14.9 -> 1.14.12
|    |    \--- org.objenesis:objenesis:3.3
|    +--- org.mockito:mockito-junit-jupiter:5.7.0
|    |    +--- org.mockito:mockito-core:5.7.0 (*)
|    |    \--- org.junit.jupiter:junit-jupiter-api:5.10.0 -> 5.8.1 (*)
|    +--- org.skyscreamer:jsonassert:1.5.1
|    |    \--- com.vaadin.external.google:android-json:0.0.20131108.vaadin1
|    +--- org.springframework:spring-core:6.1.4 (*)
|    +--- org.springframework:spring-test:6.1.4
|    |    \--- org.springframework:spring-core:6.1.4 (*)
|    \--- org.xmlunit:xmlunit-core:2.9.1
+--- org.junit.jupiter:junit-jupiter-api:5.8.1 (*)
\--- org.junit.jupiter:junit-jupiter-engine:5.8.1 (*)

testRuntimeOnly - Runtime only dependencies for source set 'test'. (n)
\--- org.junit.jupiter:junit-jupiter-engine:5.8.1 (n)

(c) - A dependency constraint, not a dependency. The dependency affected by the constraint occurs elsewhere in the tree.
(*) - Indicates repeated occurrences of a transitive dependency subtree. Gradle expands transitive dependency subtrees only once per project; repeat occurrences only display the root of the subtree, followed by this annotation.

(n) - A dependency or dependency configuration that cannot be resolved.

A web-based, searchable dependency report is available by adding the --scan option.
