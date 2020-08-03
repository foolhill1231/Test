function check()
{
   var p = new RegExp("^[0-9a-zA-z_\.-]+@[0-9a-zA-z_\.-]+\.[a-zA-Z]+$", "i");
   var s = myform.address.value;  
   var res = s.match(p);  

  if(res == null){
    window.alert("入力が誤っています。");
     res =  false;
   }
   else{
      window.alert("送信します。");
      res = true;
   }
   return res;
}