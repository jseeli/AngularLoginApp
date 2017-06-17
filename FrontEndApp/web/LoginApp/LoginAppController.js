myApp.controller("LoginAppController", function($scope, $http,$location) 
{
	$scope.register={loginid:"",password:"",username:"",email:"",mobile:""};
	
	$scope.completeRegister=function()
	{
		$http.post('http://localhost:8087/RestfulApp/insertRegister',$scope.register)
		.then(function(response)
				{
				$scope.message="Successfully Blog Added";
				$location.path('/Login');
				}
		);
	}	

});