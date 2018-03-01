var options = {
            success: function (data) {
               $("#msg").html(data);
               $("#msg").css("display","block");
            },
            error:function(){
            	alert("提交失败");
            }
        };
$(function(){
	$("#ajaxSubmit").click(ajaxSubmit);
})

function ajaxSubmit() {
        $("#ajaxForm").ajaxSubmit(options);
        alert("aaa");
        }