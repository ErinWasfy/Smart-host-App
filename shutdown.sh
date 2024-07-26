# Read the PID from the file
if [ -f spring_boot_pid.txt ]; then
    SPRING_BOOT_PID=$(cat spring_boot_pid.txt)

    # Kill the process
    echo "Killing Spring Boot application with PID: $SPRING_BOOT_PID"
    kill $SPRING_BOOT_PID

    # Optionally wait for the process to terminate and confirm it's no longer running
    sleep 10 # Give it some time to shutdown gracefully
    if kill -0 $SPRING_BOOT_PID 2>/dev/null; then
        echo "Spring Boot application did not stop, forcing shutdown..."
        kill -9 $SPRING_BOOT_PID
    fi

    # Remove the PID file
    rm spring_boot_pid.txt
    echo "Spring Boot application stopped."
else
    echo "PID file not found. Is the Spring Boot application running?"
fi