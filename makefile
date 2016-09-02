clean:
	./gradlew clean

build:
	./gradlew build

upload:
	./gradlew clean build install bintrayUpload
