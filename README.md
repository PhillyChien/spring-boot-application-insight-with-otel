# Spring Boot Application Insight with Open Telemetry

## Setup
```bash
curl -L -O https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.6.2/applicationinsights-agent-3.6.2.jar

```

## Run with Java Agent 

```bash
java -javaagent:applicationinsights-agent-3.6.2.jar \
    -jar target/spring-boot-appinsight-otel-0.0.1-SNAPSHOT.jar
    
```

## Setup Application Insight Connection String using Environment Variable 
```bash
APPLICATIONINSIGHTS_CONNECTION_STRING=InstrumentationKey=1a1c79ec-f660-49ce-b900-9e67cac2ec79;IngestionEndpoint=https://canadaeast-0.in.applicationinsights.azure.com/;ApplicationId=7003877e-05e9-4ad5-b9a1-eec5bb97ce9e

```

## Run on Docker
```bash
docker build -t spring-boot-application-insight-with-otel:latest .

docker run -e APPLICATIONINSIGHTS_CONNECTION_STRING="InstrumentationKey=1a1c79ec-f660-49ce-b900-9e67cac2ec79;IngestionEndpoint=https://canadaeast-0.in.applicationinsights.azure.com/;ApplicationId=7003877e-05e9-4ad5-b9a1-eec5bb97ce9e" \
  spring-boot-application-insight-with-otel:latest
   
```