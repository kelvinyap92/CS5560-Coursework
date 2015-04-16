/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function calculate()
{
        var index = document.getElementById('index');

        var a = document.getElementById("calculate");
        
   //add function     
    if(a.options[a.selectedIndex].value == "0")
    {
             $("#num3").text(parseInt($("#num1").val()) + parseInt($("#num2").val()));

    }
    //division function
    else if(a.options[a.selectedIndex].value == "1")
    {
             $("#num3").text(parseInt($("#num1").val()) / parseInt($("#num2").val()));   

    }
    //multiplecation function
    else if(a.options[a.selectedIndex].value == "2")
    {
             $("#num3").text(parseInt($("#num1").val()) * parseInt($("#num2").val()));

    }
    //subtract function
    else if (a.options[a.selectedIndex].value == "3")
    {
    $("#num3").text(parseInt($("#num1").val()) - parseInt($("#num2").val()));

    }

}






