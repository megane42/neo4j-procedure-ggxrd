# Neo4j Procedure for GGXrdx

## Build

```bash
mvn clean package -DskipTests=true
```

Test is implemented but not working. I don't know why.

## Install

Copy jar file into neo4j's `plugins` folder.

## Use

`Integer ggxrd.alv2frame(Integer attack_lv, String situation)`

* It returns stan frames. (see: http://www.4gamer.net/guide/ggxrd/031723049/#data_4)
* `situation` is one of follows:
    * `hit_stand`
    * `hit_crouchd`
    * `hit_air`
    * `normal_ground`
    * `normal_air`
    * `just_ground`
    * `just_air`
    * `fd_ground`
    * `fd_air`

### example

```java
ggxrd.alv2frame(1, "normal_ground") # => 11
ggxrd.alv2frame(4, "hit_stand") # => 19
```

## Why?

* https://qiita.com/megane42/item/2d9cd425a111a3068fa3
