@echo off

echo AWS CODEARTIFACT PUBLISHING ARTIFACT
echo #####################################

aws --version >nul 2>&1 && (
    echo aws cli is found on your system
) || (
    echo installing aws cli 
    msiexec.exe /i https://awscli.amazonaws.com/AWSCLIV2.msi
)


aws configure set aws_access_key_id "AKIAY3DF52AXKFMEJIRG" && aws configure set aws_secret_access_key "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" && aws configure set region "ap-southeast-1" && aws codeartifact get-authorization-token --domain yuzee --domain-owner 607951638574 --query authorizationToken --output text > pass.txt"
for /f "delims=" %%i in (pass.txt) do set c=%%i
echo %c%
set CODEARTIFACT_AUTH_TOKEN=%c%
CALL mvn -s settings.xml clean package deploy

cmd /k

pause 