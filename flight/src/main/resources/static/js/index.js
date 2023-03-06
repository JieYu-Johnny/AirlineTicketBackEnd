$(function(){
  $.ajax({
    url: "/user/getUserName",
    type: "post",
    success : function(data){
      if(data.code===200){
        $(".header").html("");
        $(".header").append(
          '<a href="./index.html" class="logo">SCU Airlines</a>'+
          '<a href="#" onclick=logout() class="button">SignOut</a>'+
          '<a class="button">'+data.result+'</a>'+
          '<a href="#" class="button">Order</a>'+
          '<a href="#" class="button">Booking Ticket</a>'+
          '<a href="./index.html" class="button active">Home</a>'
        )
      }
    }
  })
})

function logout(){
  $.ajax({
    url: "/user/loginOut",
    type: "get",
    data: {},
    success: function(data) {
      if(data.code===200){
        window.location.href = "./index.html";
      }else{
        window.alert("失败咯~，找BUG吧！")
      }
    }
  });
}


let cityList = [];
$(function(){
  //获取CityList
  $.ajax({
    url: "/test/test",
    type: "post",
    dataType: "json",
    data: {},
    success: function(data) {
      cityList = data.result
    },
    error: function(error) {
      console.log(error.message);
    }

  });
})

// Activate and DeactivateReturn Date as per the value selected in Radio Buttons
function activateReturnDate(){
  const input = document.getElementById('return-date');
  if(document.getElementById('roundtrip').checked){
    document.getElementById('return-date').disabled = false; 
    input.setAttribute('required', '');
    
  }
  if(document.getElementById('one-way').checked){
    document.getElementById('return-date').disabled = true;
    input.setAttribute('required');
  }
}

// Prints the Error message on the Form.
function printError(message){
  document.getElementById('error-message').innerHTML = `Error: ${message} <br>`;
}


// Validate that the Source and Destination cities is among the list of cities of Array and they are not the same
function validateCityList(){
  let originIndex = false;
  let destinationIndex = false;
  let originCity = document.getElementById('origin').value;
  originCity = originCity.toLowerCase();
  let destinationCity = document.getElementById('destination').value;
  destinationCity = destinationCity.toLowerCase();
  //check if the source city is same as destination city
  if(originCity == destinationCity){
    printError("Origin and Destination city cannot be same");
    return false;  
  }
  // Matching the source and destination input with the array of cities
  cityList.forEach((city)=>{
    if(city == originCity){
      originIndex = true;
    }
    if(city == destinationCity){
      destinationIndex = true;
    }
  });
  if(!(originIndex)){
    printError("No available flights from the chosen Origin location");
    return false;   
  }
  if(!(destinationIndex)){
    printError("No available flights to the chosen Destination location");
    return false;   
  }
  return true;
}


// Validate that the Trip Type is selected
function validateTripType(){
  if(!(document.getElementById('one-way').checked || document.getElementById('roundtrip').checked)){
    printError("Please select your flight type ( Round Trip/One Way)");
    return false;
  }
  return true ;
} 



// function validateDate(){
//   let rdate = document.getElementById('roundtrip').value;
//   if(document.getElementById('roundtrip').checked && rdate == null){
//     printError("Please select the return date");
//     return false;
//   }
//   return true;
// }


form.addEventListener("submit", (e) => {
  if(!(validateCityList() && validateTripType())){
    e.preventDefault();
  }else{
    $.ajax({
      url: "/test/submit",
      type: "post",
      dataType: "json",
      data: $('#form').serialize(),
      success: function(data) {
        console.log(data)
        window.location.href = data.result
      },
      error: function(error) {
        
      }
  
    });
  }
});
