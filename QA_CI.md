# Настройка CI на основе Github Actions

## CI
  После связывания локального репозитория с удалённым и первого пуша в заготовки проекта, время настроить CI на основе GitHub Actions. Шаблон вашего maven.yml должен выглядеть вот так, убедитесь, что всё совпадает с вашим шаблоном, например, что вы указали фазу `verify`, а не `package`:
  ```yml
  name: Java CI with Maven

  on: [push, pull_request]

  jobs:
    build:

      runs-on: ubuntu-latest

      steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          java-version: '11'
          distribution: 'adopt'
      - name: Build with Maven
        run: mvn -B -e verify
  ```
  
## JaCoCo

  ```xml
              <plugin>
                  <groupId>org.jacoco</groupId>
                  <artifactId>jacoco-maven-plugin</artifactId>
                  <version>0.8.5</version>
                  ...
  ```

  Инициализация:
  ```xml
                      <execution>
                          <id>prepare-agent</id>
                          <goals>
                              <goal>prepare-agent</goal>
                          </goals>
                      </execution>
  ```

  В режиме генерации отчётов:
  ```xml
                      <execution>
                          <id>report</id>
                          <phase>verify</phase>
                          <goals>
                              <goal>report</goal>
                          </goals>
                      </execution>
  ```

  В режиме проверки и обрушения сборки по уровню покрытия по счётчику `BRANCH`:
  ```xml
                      <execution>
                          <id>check</id>
                          <goals>
                              <goal>check</goal>
                          </goals>
                          <configuration>
                              <rules>
                                  <rule>
                                      <limits>
                                          <limit>
                                              <counter>BRANCH</counter>
                                              <value>COVEREDRATIO</value>
                                              <minimum>100%</minimum>
                                          </limit>
                                      </limits>
                                  </rule>
                              </rules>
                          </configuration>
                      </execution>
  ```
