cd NLPostCodes

mvn clean 
mvn install

docker build -t lengarski/nl:latest .

cd ..


cd NLPostCodesWeb

docker build -t lengarski/nl-web:latest .

cd ..

