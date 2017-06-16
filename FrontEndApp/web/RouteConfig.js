myApp.config(function($routeProvider)
		{
			$routeProvider.when("/",{templateUrl:"LoginApp/Home.html"})
						  .when("/Login",{templateUrl:"LoginApp/Login.html"})
						  .when("/Register",{templateUrl:"LoginApp/Register.html"})
		});