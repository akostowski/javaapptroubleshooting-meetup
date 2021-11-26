# javaapptroubleshooting-meetup

## Thread dump - sample application diagram
```mermaid
graph LR;
    A((User))-->|/hello|B(HelloApi);
    B(HelloApi)-->|/weather|C(WeatherApi);
```

## Heap dump - sample application diagram
```mermaid
graph LR;
    A((User))-->|/qr/find|B(QrCodeReader);
```

VM Options:

    -Xmx72m -Xlog:gc*:file=logsgc.log:tags,uptime,time,level:filecount=1,filesize=50m
