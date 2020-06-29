<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试页面</title>
    <script src="../static/jquery-1.8.3.js"></script>
</head>
<body>
    <#list areaList as stu>
        ${stu.name}<br/>
    </#list>
<form action="" method="post">
    <select id="sheng"  onchange="changeProvince()">
        <option value="test1">选择省</option>>
       <#list areaList as stu>
        <option value="${stu.id}"> ${stu.name}</option>
       </#list>
    </select>

    <select id="citys" onchange="changeCity()">
       <option value="test1">选择市</option>
    </select>

    <select id="qu">
        <option value="test1">选择区</option>
    </select>
</form>
</body>

<script type="text/JavaScript">
    function changeProvince(){
        var objS = document.getElementById("sheng");
        var city = document.getElementById("citys");
        var grade = objS.options[objS.selectedIndex].value;

        // 每次选择前需要清空市、区的附加select
        $('#citys option').not('option:first').remove();
        $('#qu option').not('option:first').remove();

        // city.options.length=0;
        $.ajax({
            url:'/testArea3',
            type:"post",
            data:{"parentId":grade},
            timeout:3000,//超时时间设置为3秒；
            success:function(data){
                arr=data.areaList;
                for(j = 0,len=arr.length; j < len; j++) {
                    city.options.add(new Option(arr[j].name,arr[j].id));
                }
            },
            error: function (data) {
            }
        });
    }
    function changeCity(){
        var objS = document.getElementById("citys");
        var qu = document.getElementById("qu");
        var grade = objS.options[objS.selectedIndex].value;

        $('#qu option').not('option:first').remove();//初始化select框

        $.ajax({
            url:'/testArea3',
            type:"post",
            data:{"parentId":grade},
            timeout:3000,//超时时间设置为3秒；
            success:function(data){
                arr=data.areaList;
                for(j = 0,len=arr.length; j < len; j++) {
                    qu.options.add(new Option(arr[j].name,arr[j].id));
                }
            },
            error: function (data) {
            }
        });
    }
</script>
</html>