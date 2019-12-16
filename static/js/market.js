$(function () {
	$(".Js_closeBtn").click(function () {
	   $(".f_buy,.searchproduct,.viewproduct,.f_pay").fadeOut(200);
	});
	$(".Js_payBtn").click(function () {
		   $(".f_buy").fadeOut(200);
		   if($("#buy_number").val()=="")
			   $("#totalpay").val(parseInt($("#buy_price").val()));
		   else
			   $("#totalpay").val(parseInt($("#buy_number").val())*parseInt($("#buy_price").val())); 
		   $(".f_pay").fadeIn(200);
		});
	$(".Js_add").click(function () {
	   $(".addproduct").fadeIn(200);
	});
	$(".Js_search").click(function () {
	    $(".searchproduct").fadeIn(200);
	});
    $(".Js_view").click(function () {
    	var product_tr = $(this).parent().parent();
    	$("#view_id").val(product_tr.children(".productId").text());
    	$("#view_productname").val(product_tr.children(".productName").text());
    	$("#view_material").val(product_tr.children(".productMaterial").text());
    	$("#view_color").val(product_tr.children(".productColor").text());
    	$("#view_voltage").val(product_tr.children(".productVoltage").text());
    	$("#view_power").val(product_tr.children(".productPower").text());
    	$("#view_degree").val(product_tr.children(".productDegree").text());
    	$("#view_price").val(product_tr.children(".productPrice").text());
    	$("#view_store").val(product_tr.children(".productStore").text());
        $(".viewproduct").fadeIn(200);
    });
    $(".Js_buy").click(function () {
    	var product_tr = $(this).parent().parent();
    	$("#buy_id").val(product_tr.children(".productId").text());
    	$("#buy_price").val(product_tr.children(".productPrice").text());
    	$("#buy_address").val($(".userAddress").text());
    	$("#buy_money").val($(".userMoney").text());
        $(".f_buy").fadeIn(200);
    });
});