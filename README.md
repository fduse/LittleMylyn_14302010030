# LittleMylyn_14302010030

## lab3

## 使用说明

### 新建任务
- 菜单栏File/new,选择Little Mylyn目录下Task即可

### 修改任务
- 单机目录左侧>,可展开目录
- 双击状态一栏，可转换状态。
- 双击文件，可打开文件。

## 开发指导

**Attention**

All of the commits are under either "feature" or "fix" branch.

To create a new branch:

Take "feature" as an example,

```bash
git checkout feature
git checkout -b feature-add-buttons
do something here
git add .
git commit -m"your commit message"
git pull
git push origin feature-add-buttons
```

Once you finish one branch(without bugs), merge it to "dev" branch and delete it.

Once we accomplish one iteration, merge "dev" to "master" but keep "dev" as a permanent branch.

Since time is limited, we adopt AGILE mode to enhance the velocity.





## 项目结构

- biz
- dao
- entity
- test
- util
- view

**Attention: the base directory is `com.littlemylyn `**

### entry

It is obvious that `Activator.java` serves as the entry for this plugin project. Besids, it helps control the life circle of the whole plugin.

### biz

The controller under all of the actions is implemented in `biz`, it takes over what you can do with the task entity. Say, as soon as you click on the view, the TaskBiz will respond to it and calls the Dao to manipulate data in database.

### dao

The `TaskDao` is implemented here to provide APIs for the data in database. With the help of `TaskDao`, `TaskBiz` doesn't need to care about how the data is stored or read.

### entity

Here we implemented the virtual model of File and Task as well as the status and type of tasks. Entity provides convenient access for views and it enables views to cover the fundation of `Dao`.

### test

Here are the unit tests for Dao and Util, and Biz.

### util

Util includes the most fundamental actions, e.g, establishing connection with database and so on. Besides, it has something to do with file count, which will seem ugly if implemented in `view`.

### view

View is the essential part in this plugin since it provides interaction with users. It is separated into parts exactly according to the requirement documentation.

