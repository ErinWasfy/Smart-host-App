#!/usr/bin/env sh

# Change to the directory where the mvnw script is located
cd "$(dirname "$0")"

# Run the Spring Boot application using Maven Wrapper
./mvnw spring-boot:run &
SPRING_BOOT_PID=$!

# Save the PID to a file
echo $SPRING_BOOT_PID > spring_boot_pid.txt

echo "Spring Boot application started with PID: $SPRING_BOOT_PID"

