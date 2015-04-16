/*
 * 
 * Written by: Kelvin Yap
 */

function myCon() {
  var FromVal, ToVal, FromName, ToName, v1;

  v1 = document.MainForm.what.value;
  v1 = stripBad(v1);
  v1 = parseFloat(v1);
  if (isNaN(v1)) v1 = 0;
  document.MainForm.what.value = v1;
  
  
  FromVal = $('input[name=fromCh]:checked').val(); ;
  ToVal = $('input[name=toCh]:checked').val(); ;
 /* 
  FromName = $('input[name=fromCh]:checked').val(); ;
  ToName = $('input[name=toCh]:checked').val(); 
  */
  FromName = $('input[name=fromCh]:checked').attr('id');
  ToName = $('input[name=toCh]:checked').attr('id'); 

  var ConvertedTemp = get_fact(v1, FromVal, ToVal);
  if (ConvertedTemp == "Below Absolute Zero"){
    document.MainForm.answer.value = "Your input cannot be below absolute zero.";
  } else {
    document.MainForm.answer.value = v1 + " " + FromName + " = " + ConvertedTemp + " " + ToName;
  }
}

function resetanswer() {
  document.MainForm.answer.value = "";
}

function get_fact(ff,from_val,to_val){
 // first convert to kelvin
 if (from_val == 0){
   ff = ff + 273.15;
 } else if (from_val == 1){
   ff = ((ff - 32)/ 1.8) + 273.15;
 } else if (from_val == 2){
   ff = ff / 1.8;
 } else if (from_val == 3){
   ff = (ff * 1.25) + 273.15;
 }

 if (ff < 0){
   // Below absolute zero
   return "Below Absolute Zero";
 }

 // now convert kelvin to unit
 if (to_val == 0){
   ff = ff - 273.15;
 } else if (to_val == 1){
   ff = (1.8 * (ff -273.15)) + 32;
 } else if (to_val == 2){
   ff = (ff - 273.15) / 1.25;
 } else if (to_val == 3){
   ff = ff * 1.8;
 }
 
 // round it off
 if (Number.prototype.toFixed) {
   ff = ff.toFixed(7);
   ff = parseFloat(ff);
 }
 else {
   var leftSide = Math.floor(ff);
   var rightSide = ff - leftSide;
   ff = leftSide + Math.round(rightSide *10000000)/10000000;
 }

return ff;
}

function stripBad(string) {
    for (var i=0, output='', valid="eE-0123456789."; i<string.length; i++)
       if (valid.indexOf(string.charAt(i)) != -1)
          output += string.charAt(i)
    return output;
} 
