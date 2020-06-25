
rootProject.name = "java-dynamic-sqs-listener-parent"

pluginManagement {
    plugins {
        id("org.springframework.boot") version "2.2.2.RELEASE"
        id("com.commercehub.gradle.plugin.avro-base") version "0.20.0"
    }
    repositories {
        gradlePluginPortal()
        maven (url="https://dl.bintray.com/gradle/gradle-plugins")
    }
}

include(":java-dynamic-sqs-listener-api")
include(":java-dynamic-sqs-listener-core")
include(":examples:aws-xray-spring-example")
include(":examples:java-dynamic-sqs-listener-core-examples")
include(":examples:java-dynamic-sqs-listener-spring-aws-example")
include(":examples:spring-cloud-schema-registry-example:spring-cloud-schema-registry-consumer")
include(":examples:spring-cloud-schema-registry-example:spring-cloud-schema-registry-producer")
include(":examples:spring-cloud-schema-registry-example:spring-cloud-schema-registry-producer-two")
include(":examples:spring-cloud-schema-registry-example")
include(":examples:java-dynamic-sqs-listener-spring-integration-test-example")
include(":examples:multiple-aws-account-example")
include(":examples:spring-sleuth-example")
include(":examples:java-dynamic-sqs-listener-spring-starter-examples")
include(":examples:sqs-listener-library-comparison")
include(":extensions:aws-xray-message-processing-decorator")
include(":extensions:brave-message-processing-decorator")
include(":extensions:spring-cloud-schema-registry-extension:spring-cloud-schema-registry-extension-api")
include(":extensions:spring-cloud-schema-registry-extension:avro-spring-cloud-schema-registry-extension")
include(":extensions:spring-cloud-schema-registry-extension:in-memory-spring-cloud-schema-registry")
include(":extensions:spring-cloud-schema-registry-extension")
include(":java-dynamic-sqs-listener-spring:java-dynamic-sqs-listener-spring-api")
include(":java-dynamic-sqs-listener-spring:java-dynamic-sqs-listener-spring-core")
include(":java-dynamic-sqs-listener-spring:java-dynamic-sqs-listener-spring-starter")
include(":util:avro-spring-cloud-schema-registry-sqs-client")
include(":util:common-utils")
include(":util:elasticmq-sqs-client")
include(":util:expected-test-exception")
include(":util:local-sqs-async-client")
include(":util:proxy-method-interceptor")
include(":util:sqs-brave-tracing")
include(":util:annotation-utils")
include(":util:documentation-annotations")

project(":java-dynamic-sqs-listener-api").projectDir = file("api")
project(":java-dynamic-sqs-listener-core").projectDir = file("core")
project(":examples:aws-xray-spring-example").projectDir = file("examples/aws-xray-spring-example")
project(":examples:java-dynamic-sqs-listener-core-examples").projectDir = file("examples/core-examples")
project(":examples:java-dynamic-sqs-listener-spring-aws-example").projectDir = file("examples/spring-aws-example")
project(":examples:spring-cloud-schema-registry-example:spring-cloud-schema-registry-consumer").projectDir = file("examples/spring-cloud-schema-registry-example/spring-cloud-schema-registry-consumer")
project(":examples:spring-cloud-schema-registry-example:spring-cloud-schema-registry-producer").projectDir = file("examples/spring-cloud-schema-registry-example/spring-cloud-schema-registry-producer")
project(":examples:spring-cloud-schema-registry-example:spring-cloud-schema-registry-producer-two").projectDir = file("examples/spring-cloud-schema-registry-example/spring-cloud-schema-registry-producer-two")
project(":examples:spring-cloud-schema-registry-example").projectDir = file("examples/spring-cloud-schema-registry-example")
project(":examples:java-dynamic-sqs-listener-spring-integration-test-example").projectDir = file("examples/spring-integration-test-example")
project(":examples:multiple-aws-account-example").projectDir = file("examples/spring-multiple-aws-account-example")
project(":examples:spring-sleuth-example").projectDir = file("examples/spring-sleuth-example")
project(":examples:java-dynamic-sqs-listener-spring-starter-examples").projectDir = file("examples/spring-starter-examples")
project(":examples:sqs-listener-library-comparison").projectDir = file("examples/sqs-listener-library-comparison")
project(":extensions:aws-xray-message-processing-decorator").projectDir = file("extensions/aws-xray-message-processing-decorator")
project(":extensions:brave-message-processing-decorator").projectDir = file("extensions/brave-message-processing-decorator")
project(":extensions:spring-cloud-schema-registry-extension:spring-cloud-schema-registry-extension-api").projectDir = file("extensions/spring-cloud-schema-registry-extension/spring-cloud-schema-registry-extension-api")
project(":extensions:spring-cloud-schema-registry-extension:avro-spring-cloud-schema-registry-extension").projectDir = file("extensions/spring-cloud-schema-registry-extension/avro-spring-cloud-schema-registry-extension")
project(":extensions:spring-cloud-schema-registry-extension:in-memory-spring-cloud-schema-registry").projectDir = file("extensions/spring-cloud-schema-registry-extension/in-memory-spring-cloud-schema-registry")
project(":extensions:spring-cloud-schema-registry-extension").projectDir = file("extensions/spring-cloud-schema-registry-extension")
project(":java-dynamic-sqs-listener-spring:java-dynamic-sqs-listener-spring-api").projectDir = file("spring/spring-api")
project(":java-dynamic-sqs-listener-spring:java-dynamic-sqs-listener-spring-core").projectDir = file("spring/spring-core")
project(":java-dynamic-sqs-listener-spring:java-dynamic-sqs-listener-spring-starter").projectDir = file("spring/spring-starter")
project(":util:avro-spring-cloud-schema-registry-sqs-client").projectDir = file("util/avro-spring-cloud-schema-registry-sqs-client")
project(":util:common-utils").projectDir = file("util/common-utils")
project(":util:elasticmq-sqs-client").projectDir = file("util/elasticmq-sqs-client")
project(":util:expected-test-exception").projectDir = file("util/expected-test-exception")
project(":util:local-sqs-async-client").projectDir = file("util/local-sqs-async-client")
project(":util:proxy-method-interceptor").projectDir = file("util/proxy-method-interceptor")
project(":util:sqs-brave-tracing").projectDir = file("util/sqs-brave-tracing")
project(":util:annotation-utils").projectDir = file("util/annotation-utils")
project(":util:documentation-annotations").projectDir = file("util/documentation-annotations")
