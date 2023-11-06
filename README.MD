# How to use the DEMO project

Change the env. variables in `docker-compose.yml` for service `demo-app`, then start it

```
docker-compose up -d
```

All that's left is open the home page of `demo-app` and click through the pages,
triggering different services in `HomeController`.

| URL                          | Description                                |
|------------------------------|--------------------------------------------|
| http://localhost:8100/       | Home page, only opens page                 |
| http://localhost:8100/normal | Calls some tracable methods normally       |
| http://localhost:8100/invoke | Calls some traceable methods by invocation |
