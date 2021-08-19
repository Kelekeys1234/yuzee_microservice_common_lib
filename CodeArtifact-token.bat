@echo off

echo AWS CODEARTIFACT PUBLISHING ARTIFACT
echo #####################################


cmd /C "aws configure set aws_access_key_id "AKIAY3DF52AXKFMEJIRG" && aws configure set aws_secret_access_key "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" && aws configure set region "ap-southeast-1" && aws codeartifact get-authorization-token --domain yuzee --domain-owner 607951638574 --query authorizationToken --output text > pass.txt""
cmd /C "set /p passwd= < pass.txt"
cmd /C "set CODEARTIFACT_AUTH_TOKEN=%passwd%"
cmd /C "mvn clean deploy -s settings.xml"

pause 