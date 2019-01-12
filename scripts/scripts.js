"use strict";angular.module("taskApp",["ngAnimate","ngResource","ngSanitize","ngTouch","ui.router","toastr"]).config(["$stateProvider","$urlRouterProvider","$httpProvider",function(t,o,r){r.defaults.withCredentials=!1,t.state("app",{url:"/app","abstract":!0,templateUrl:"views/layout.html",controller:"RootCtrl"}).state("app.home",{url:"^/home",views:{content:{templateUrl:"views/home.html",controller:"HomeCtrl as vm"}}}).state("app.profile",{url:"^/profile",views:{content:{templateUrl:"views/profile.html"}}}),o.otherwise("/home")}]),angular.module("taskApp").controller("RootCtrl",function(){}),angular.module("taskApp").controller("HomeCtrl",["Produto","$window","toastr",function(t,o,r){var e=this,u={nm_product:"",ds_product:"",status:0};e.loadProducts=function(){e.products=[],t.query().$promise.then(function(t){e.products=t})},e.newProduct=function(){e.product=angular.copy(u)},e.creationNewProduct=function(){e.newProduct()},e.saveProduct=function(){var o="insert",u=null;e.product.cd_product&&(o="update",u={id:e.product.cd_product}),t.save(u,e.product).$promise.then(function(t){t.cd_product&&("insert"===o?(r.success("Produto cadastrada","Sucesso."),e.products.push(t)):(r.success("Produto alterada","Sucesso."),e.loadProducts()))})["finally"](function(){e.newProduct()})},e.editProduct=function(t){e.product=t},e.deleteProduct=function(u){o.confirm("Confirma a exclusão do produto?")&&t["delete"]({id:u}).$promise.then(function(t){t.count&&(r.success("Produto excluido","Sucesso."),e.loadProducts(),e.newProduct())})},e.formatDate=function(t){return new Date(t).toISOString()},e.loadProducts(),e.newProduct()}]),angular.module("taskApp").directive("btnNewProduct",["$timeout",function(t){return{restrict:"C",link:function(o,r,e){r.bind("click",function(){t(function(){$("form input:nth-child(1n):visible")[0].focus()})})}}}]),angular.module("taskApp").factory("Produto",["$resource",function(t){return t("http://127.0.0.1/SuperoTeste/api/tasklist/:id",null,{update:{method:"PUT"}})}]);