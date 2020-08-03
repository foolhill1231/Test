function check()
{
   var n = myform.name.value;  

   if(n == ""){
       window.alert("入力してください。");
       res = false;
   }
   else{
      window.alert("送信します。");
      res = true;
   }
   return res;
}
