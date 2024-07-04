Primefaces 14 calls WelcomeMBean method at Restore View Phase not called with Primefaces 13
=====

This simple app shows one difference on primefaces 14 and primefaces 13 usage.

When Faces process the action of 'Submit' button with primefaces 14, getDetails method of WelcomeMBean is called at Restore View Faces Phase.

This action is not triggered with primefaces 13.

**Why Faces calls getDetails with empty string at RESTORE_VIEW phase with PrimeFaces 14?**

**What is the right behavior (PrimeFaces 13 or PrimeFaces 14)?**

## How to reproduce the difference

### I- Run the app with primefaces 13 and save the logs

1- Clone this project
```Shell
git clone https://github.com/joinfaces/primefaces-14.git
```

2- Build the app
```Shell
mvn clean install
```

3- Run the app
```Shell
java -jar target/joinfaces-example-5.3.x.jar
```

4- Access welcome page at **http://localhost:8080/welcome.faces**

5- Clean the logs.

6- Click 'Submit' button.

7- You will get logs like the following:

```
2024-07-04T12:31:32.474-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:31:32.475-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:31:32.475-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:31:32.475-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:31:32.475-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getText called: PROCESS_VALIDATIONS
2024-07-04T12:31:32.475-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:31:32.475-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:31:32.476-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:31:32.476-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:31:32.476-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:31:32.476-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:31:32.476-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:31:32.476-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:31:32.476-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : find called: INVOKE_APPLICATION
2024-07-04T12:31:32.478-03:00  INFO 1837790 --- [mcat-handler-14] o.joinfaces.example.view.WelcomeMBean    : getText called: RENDER_RESPONSE
```

### II- Run the app with primefaces 14 and save the logs

1- Change primefaces version from 13 to 14 at pom.xml (comment primefaces 13 and uncomment primefaces 14)
```xml
        <!--
        <primefaces.version>13.0.10</primefaces.version>
        <primefaces-extensions.version>13.0.13</primefaces-extensions.version>
        -->
        <primefaces.version>14.0.2</primefaces.version>
        <primefaces-extensions.version>14.0.2</primefaces-extensions.version>
```

2- Build the app
```Shell
mvn clean install
```

3- Run the app
```Shell
java -jar target/joinfaces-example-5.3.x.jar
```

4- Access starter page at **http://localhost:8080/welcome.faces**

5- Clean the logs.

6- Click 'Submit' button.

7- You will get logs like the following (**See the first line below is different from primefaces 13 log**):

```
2024-07-04T12:42:38.740-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDetails called with '' : RESTORE_VIEW
2024-07-04T12:42:38.741-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:42:38.742-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:42:38.742-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:42:38.745-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: APPLY_REQUEST_VALUES
2024-07-04T12:42:38.746-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getText called: PROCESS_VALIDATIONS
2024-07-04T12:42:38.746-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:42:38.746-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:42:38.746-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:42:38.747-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: PROCESS_VALIDATIONS
2024-07-04T12:42:38.748-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:42:38.748-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:42:38.748-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:42:38.748-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getDataList called: UPDATE_MODEL_VALUES
2024-07-04T12:42:38.749-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : find called: INVOKE_APPLICATION
2024-07-04T12:42:38.753-03:00  INFO 1838197 --- [omcat-handler-1] o.joinfaces.example.view.WelcomeMBean    : getText called: RENDER_RESPONSE
```

