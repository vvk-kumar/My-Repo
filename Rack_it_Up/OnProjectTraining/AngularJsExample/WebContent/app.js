var app = angular.module("myShoppingList", []);
app.controller("myCtrl", function($scope) {
    $scope.name = ["Vivek", "Ramki", "Mounish"];
    $scope.phone = ["4664664", "65466", "6544646466"];
    $scope.email = ["fffff@gmail.com", "sjjdj@yahoo.com", "sdhhdhhj@hotmail.com"];
    $scope.address = ["Ranchi", "chennnai", "madhurai"];
    
    $scope.addItem = function () {
        $scope.errortext = "";
        if (!$scope.addMe) {return;}
        if ($scope.products.indexOf($scope.addMe) == -1) {
            $scope.products.push($scope.addMe);
        } else {
            $scope.errortext = "The item is already in your shopping list.";
        }
    }
    $scope.removeItem = function (x) {
        $scope.errortext = "";
        $scope.products.splice(x, 1);
    }
    
    $scope.myFunc = function () {
        $scope.myTxt = "You clicked submit!";
    }
});