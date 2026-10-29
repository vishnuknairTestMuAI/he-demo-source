# he-demo-source (Repo 1: source code only)

This is a minimal Maven + TestNG + Selenium project with one test, `LaunchBrowserTest`. The test opens Chrome on the LambdaTest grid and checks the page title.

The repo has **no HyperExecute YAML on purpose.** Jobs get this code through `sourcePayload`, defined in the YAML repo `he-demo-yaml`.

Compile check, run locally:

```
mvn -Dmaven.test.skip=true clean install
```
