# Git命令个人学习与总结

### *一般推荐安装Git后,在git-bash中输入git命令:*

- ##### 切换到要提交的分支

```
git checkout 分支名
```



- ##### 首先进行git add 添加文件

```
git add 当前目录某个文件名

*或者*

当前目录所有(已修改)文件 git add .
```



- #### git commit 提交

```
使用git commit 的时候会有几个参数，git commit -m 打出你要提交的日志说明，如果么有的话，会进入一个vb编辑页面，简单的话，还是直接-m打出文字，直接enter即可。
```



- #### commit之后push

```
请注意，这个时候你只是把文件提交到了自己本地，并没有提交到服务器端，这个时候就要用到git push
 命令行也行，或者是直接win推送就可以了，这个时候即使win提交Git修改文件卡死，也能愉快的修改提交代码了。

可能遇到以下情况,提交不成功:

 **使用git push origin master报错:“fatal: ‘origin’ does not appear to be a git repository
fatal: Could not read from remote repository.** 
 原因：没有关注远程仓库为origin
 解决：git remote add origin “远程仓库地址” 

 **使用git push origin master报错:
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart. Integrate the remote changes (e.g.
hint: 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.**
 原因: 远程repository和我本地的repository冲突造成
 解决: 通过新建分支git branch 新的分支名;再次push 到新的分支名


```

------

未完待续