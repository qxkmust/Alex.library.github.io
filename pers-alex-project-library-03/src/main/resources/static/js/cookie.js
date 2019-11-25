$(function () {
    setCookie = function(cname,cpwd,cday){
        var d = new Date();
        d.setTime(d.getTime() + (cday*24*60*60*1000));
        var expires = d.toUTCString();
        document.cookie = "user={username:'"+cname+"',password:'"+cpwd+"'};expires="+expires;
    },
    getCookie = function(){
        return document.cookie;
    },
    clearCookie = function (cuser) {
        return setCookie(cuser,"",-1);
    }
});