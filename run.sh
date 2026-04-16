#!/bin/bash
# SmartCampus - Build and Run Script

echo "=== SmartCampus Build Script ==="

# Create output directory
mkdir -p out

# Compile all Java files
echo "Compiling..."
javac -d out \
  src/smartcampus/model/Courseable.java \
  src/smartcampus/model/Student.java \
  src/smartcampus/model/Course.java \
  src/smartcampus/exception/InvalidFeeException.java \
  src/smartcampus/exception/StudentNotFoundException.java \
  src/smartcampus/exception/CourseNotFoundException.java \
  src/smartcampus/service/CampusService.java \
  src/smartcampus/thread/EnrollmentProcessor.java \
  src/smartcampus/Main.java

if [ $? -eq 0 ]; then
  echo "Compilation successful!"
  echo "Running SmartCampus..."
  echo ""
  java -cp out smartcampus.Main
else
  echo "Compilation failed. Check errors above."
fi
