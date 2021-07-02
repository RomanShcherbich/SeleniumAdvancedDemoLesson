```taskkill /F /IM chromedriver.exe```


CMD  to run stable tests
```mvn clean test -Dtest=SauceDemoTest -DexcludedGroups=flacky```


Allure installation for Linux:

```
curl -o allure-2.13.8.tgz -OLs https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.13.8/allure-commandline-2.13.8.tgz
sudo tar -zxvf allure-2.13.8.tgz -C /opt/
sudo ln -s /opt/allure-2.13.8/bin/allure /usr/bin/allure
allure --version
```

