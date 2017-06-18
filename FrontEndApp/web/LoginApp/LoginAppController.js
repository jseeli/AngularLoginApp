myApp.controller('LoginAppController',['$scope','$http','$location','$cookies',function($scope, $http,$location,$cookies) 
{
	$scope.register={errorcode:"",errordesc:"",loginid:"",password:"",username:"",email:"",mobile:""};
	var errorcode;
	
	$scope.completeRegister=function()
	{
		$http.post('http://localhost:8087/RestfulApp/insertRegister',$scope.register)
		.then(function(response)
				{
				console.log('--Registration Successful--');
				$location.path('/Login');
				}
		);
	}	
	
	$scope.loginCheck=function()
	{
		$http.post('http://localhost:8087/RestfulApp/loginCheck',$scope.register)
		.then(function(response)
				{
				console.log('---Login Module execution-----');
				console.log(response);
				$scope.register=response.data;
				errorcode=$scope.register.errorcode;
				if(errorcode=="200")
					{
					$cookies.putObject('user',$scope.register);
					$cookies.putObject('isAuthenticated',true);
					$location.path("/UserHome");
					}
					
				else
					{
					alert("User Name and Password Does not Match");
					}
					
				}
			,function(errResponse)
				{
				console.log('---Login Module Failure-----');
				}
			
		);
	}

}]);