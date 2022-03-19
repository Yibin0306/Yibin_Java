<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/10/18
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="jquery/jquery-1.4.2.min.js"></script>
<body>
    <div style="width:500px">
    <input type="text" id="txtSearch" name="txtSearch"
           onkeyup="searchSuggest(this.value)"/>
    <input type="submit" id="cmdSearch" value=" 搜索 " />
    <div id="suggest"></div>
    </div>
</body>
</html>
<script>
    // 实训十一：
    var xhr;
    function searchSuggest(a){
        xhr = new XMLHttpRequest();
        xhr.onreadystatechange=c;
        xhr.open("get","seachKeyWord?key="+a,true);
        xhr.send(null);
    }
    function c(){
        var res = xhr.responseText;
        var sobj = document.getElementById("suggest")
        sobj.innerHTML ="";
        var suggest ="";
        var str = res.split(",");
        // 动态生成关键字下拉 div
        if(str.length > 0 && str[0].length > 0 ){
            for(var i = 0; i < str.length;i++){
                suggest += "<div onmouseover='suggestOver(this);'";
                suggest += " onmouseout='suggestOut(this);'";
                suggest += " onclick='setSearch(this.innerHTML);'";
                suggest += " class='suggest_link'>"+str[i]+"</div>";
            }
            sobj.innerHTML = suggest;
            sobj.style.display = "block";
        }else{
            sobj.style.display = "none";
        }
    }


    //实训十二：
    //get方式
    // var xhr;
    // function searchSuggest(a){
    //     $.get(
    //         'seachKeyWord',
    //         {key:a},
    //         function (result){
    //             var sobj = $("#suggest");
    //             sobj.innerHTML ="";
    //             var suggest ="";
    //             var str = result.split(",");
    //             // 动态生成关键字下拉 div
    //             if(str.length > 0 && str[0].length > 0 ){
    //                 for(var i = 0; i < str.length;i++){
    //                     suggest += "<div onmouseover='suggestOver(this);'";
    //                     suggest += " onmouseout='suggestOut(this);'";
    //                     suggest += " onclick='setSearch(this.innerHTML);'";
    //                     suggest += " class='suggest_link'>"+str[i]+"</div>";
    //                 }
    //                 sobj.html(suggest);
    //                 //sobj.style.display = "block";
    //             }else{
    //                 //sobj.style.display = "none";
    //             }
    //         }
    //     );
    // }

    //post方式
    // var xhr;
    // function searchSuggest(a){
    //     $.post(
    //         'seachKeyWord',
    //         {key:a},
    //         function (result){
    //             var sobj = $("#suggest");
    //             sobj.innerHTML ="";
    //             var suggest ="";
    //             var str = result.split(",");
    //             // 动态生成关键字下拉 div
    //             if(str.length > 0 && str[0].length > 0 ){
    //                 for(var i = 0; i < str.length;i++){
    //                     suggest += "<div onmouseover='suggestOver(this);'";
    //                     suggest += " onmouseout='suggestOut(this);'";
    //                     suggest += " onclick='setSearch(this.innerHTML);'";
    //                     suggest += " class='suggest_link'>"+str[i]+"</div>";
    //                 }
    //                 sobj.html(suggest);
    //                 //sobj.style.display = "block";
    //             }else{
    //                 //sobj.style.display = "none";
    //             }
    //         }
    //     );
    // }

    //ajax方式
    // var xhr;
    // function searchSuggest(a) {
    //     $.ajax({
    //         url: 'seachKeyWord',
    //         type: 'get',
    //         data: {key: a, name: a, age: a, sex: 's'},
    //         success: function (s) {
    //             var sobj = $("#suggest")
    //             sobj.innerHTML = "";
    //             var suggest = "";
    //             var str = s.split(",");
    //             if (str.length > 0 && str[0].length > 0) {// 动态生成关键字下拉div
    //                 for (var i = 0; i < str.length; i++) {
    //                     suggest += "<div onmouseover='suggestOver(this);'";
    //                     suggest += " onmouseout='suggestOut(this);'";
    //                     suggest += " onclick='setSearch(this.innerHTML);'";
    //                     suggest += " class='suggest_link'>" + str[i] + "</div>";
    //                 }
    //                 sobj.html(suggest);
    //                 //sobj.style.display = "block";
    //             } else {
    //                 //sobj.style.display = "none";
    //             }
    //         },
    //         error: function (r) {
    //
    //         }
    //     });
    // }

    //点击哪个补全哪个
    function setSearch(a) {
        $("#txtSearch").val(a);
    }
</script>
