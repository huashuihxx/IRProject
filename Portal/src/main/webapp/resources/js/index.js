var persons = new Array();
// 添加两个测试人员
var id_index = 1;
var p1 = {"id":id_index++,"name":"赵文明","sex":"男","age":24,"from":"河北省"};
var p2 = {"id":id_index++,"name":"孙建国","sex":"男","age":35,"from":"北京市"};
persons.push(p2);
persons.push(p1);

// 只负责人员数据遍历 然后拼接到表格中
function showPerson(){
	// 获取数组数据拼接table
	// 获取table
	// var tb1 = document.getElementById("tb1"); // 只是获取了一个对象
	var tb1 = $("#tb1");
	// 定义表格的第一行
	var str = "<tr class='info'><th>编号</th><th>姓名</th><th>性别</th><th>年龄</th><th>籍贯</th><th>操作</th></tr>";
	// 遍历数组 追加str的内容
	for (var i = 0; i < persons.length; i++) {
		var p = persons[i];
		str += "<tr align='center'><td>"+p.id+"</td><td>"+p.name+"</td><td>"+p.sex+"</td><td>"+p.age+"</td><td>"+p.from+"</td><td><button type='button' class='btn btn-warning' onclick='reupdatePerson("+p.id+");'>更新</button>&nbsp;&nbsp;<button type='button' class='btn btn-danger' onclick='deletePerson("+p.id+");'>删除</button></td></tr>";
	}
	// 将表格内容与表格绑定
	// tb1.innerHTML = str;
	tb1.html(str);
	// 显示这个table
	// document.getElementById("div1").style.display = "";
	// $("#div1").show(); // 显示某个页面元素 show() 隐藏某个元素 是 hide();
	$("#div1").fadeIn();
}


// 准备添加方法
function readdPerson(){
	// 展示form
	// document.getElementById("addForm").style.display = "";
	// $("#addForm").show();
	$("#addForm").slideDown("slow");
}

// 根据ID隐藏某个标签
function hideDiv(id){
	// document.getElementById(id).style.display = "none";
	$("#"+id).hide(1000);
}

// 添加方法
function addPerson(){
	// 接收页面数据
	// var name = document.getElementById("paddname").value;
	var name = $("#paddname").val();
	// var sex = document.getElementById("paddsex").value;
	var sex = $("#paddsex").val();
	// var age = document.getElementById("paddage").value;
	var age = $("#paddage").val();
	// var from = document.getElementById("paddfrom").value;
	var from = $("#paddfrom").val();
	
	id = id_index++;
	// 封装JSON
	var p = {"id":id,"name":name,"sex":sex,"age":age,"from":from};
	// 存入数组
	persons.push(p);
	// 刷新数组
	showPerson();
	
}

/**
 * 根据ID查找相关人员然后进行显示
 */
function reupdatePerson(pid){
	
	// 根据ID查找人员
	for (var i = 0; i < persons.length; i++) {
		var p = persons[i];
		// 根据id找到这个人
		if(p.id == pid){
			// 找到了这个人
			// 将人员信息赋值给div中的输入框
			// document.getElementById("pupdateid").value = p.id;
			$("#pupdateid").val(p.id);
			// document.getElementById("pupdatename").value = p.name;
			$("#pupdatename").val(p.name);
			// document.getElementById("pupdatesex").value = p.sex;
			$("#pupdatesex").val(p.sex);
			// document.getElementById("pupdateage").value = p.age;
			$("#pupdateage").val(p.age);
			// document.getElementById("pupdatefrom").value = p.from;
			$("#pupdatefrom").val(p.from);
			break;
		}
	}
	// 将div的display属性设置""
	// document.getElementById("updateForm").style.display = "";
	$("#updateForm").show();
}

/**
 * 更新数据方法
 */
function updatePerson(){
	// 接收数据
	/*
	var pid = document.getElementById("pupdateid").value;
	var pname = document.getElementById("pupdatename").value;
	var sex = document.getElementById("pupdatesex").value;
	var from = document.getElementById("pupdatefrom").value;
	var age = document.getElementById("pupdateage").value;
	*/
   var pid = $("#pupdateid").val();
   var pname = $("#pupdatename").val();
   var sex = $("#pupdatesex").val();
   var from = $("#pupdatefrom").val();
   var age = $("#pupdateage").val();
   
	// 找到目标 更新值
	for (var i = 0; i < persons.length; i++) {
		var p = persons[i];
		// 根据id找到这个人
		if(p.id == pid){
			p.name = pname;
			p.sex = sex;
			p.from = from;
			p.age = age;
			break;
		}
	}
	
	// 刷新
	showPerson();
}


/**
 * 删除方法
 */
function deletePerson(pid){
	// 提示一下
	var con = confirm("确定删除ID为" + pid + "的数据么?");
	if(con == true){
		// 确定
		// 找到这个数据
			// 找到目标 更新值
		for (var i = 0; i < persons.length; i++) {
			var p = persons[i];
			// 根据id找到这个人
			if(p.id == pid){
				// 确定删除
				delete persons[i]; // 1 2 3 4 5 delete 3 1 2 null 4 5
				// 必须把老数组中的null元素干掉
				break;
			}
		}
		// 进行数组去null算法的编写 我用一个新数组 存储老数组的非空元素 然后 把新数组的值赋给老数组 
		var tmparry = new Array();
		for (var i = 0; i < persons.length; i++) {
			var p = persons[i];
			if(null != p){
				// 放入非空元素
				tmparry.push(p);
			}
		}
		alert(tmparry.length);
		// 重新复制
		persons = tmparry;
		// 重新调用showPerson();
		showPerson();
		
	}
}







